package com.ninova.mlc.blImpl.trace;

import com.ninova.mlc.bl.trace.TraceService;
import com.ninova.mlc.data.Purchase.PurchaseMapper;
import com.ninova.mlc.po.PurchaseRecord;
import com.ninova.mlc.vo.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Repository
public class TraceServiceImpl implements TraceService {
    @Autowired
    private PurchaseMapper purchaseMapper;

    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";


    @Override
    //返回purchase库状态为0的所有产品的每日收益和累计收益
    public ResponseVO getAll(int userId){
        try {
            List<PurchaseRecord> purchaseRecords = purchaseMapper.selectRecordsByUserId(userId);
            List<String> earningsReturnAll = new ArrayList<>();
            String r;
            for (PurchaseRecord p : purchaseRecords) {
                String code = p.getCode();
                double principal = p.getPrincipal();
                float number = p.getNumber();
                String dailyEarnings=null;
                String allEarings=null;
                if (p.getState() == 0 && p.getType() == 1) {
                    double nowPrice = (double) getRequest2(code).get("netWorth");
                    double dayGrowth = (double) getRequest2(code).get("dayGrowth")/100;
                    dailyEarnings = nowPrice*(dayGrowth/(1+dayGrowth))+"";
                    allEarings = (float) (nowPrice * number - principal)+"";
                } else if (p.getState() == 0 && p.getType() == 3) {
                    double nowPrice = (double) getRequest1(code).get("price");
                    double yesPrice = (double) getRequest1(code).get("close");
                    dailyEarnings = (nowPrice - yesPrice) * number+"";
                    allEarings = (float) (nowPrice * number - principal)+"";
                }else if(p.getState()==0 && p.getType()==2){
                    double nowPrice=(double)getRequest3(code).get("newnet");
                    double dayGrowth = (double) getRequest3(code).get("dayincrease");
                    dailyEarnings = nowPrice*(dayGrowth/(1+dayGrowth))+"";
                    allEarings = (double) (nowPrice * number - principal)+"";
                }
                r = code + "," + dailyEarnings + "," + allEarings;
                earningsReturnAll.add(r);
            }
            return ResponseVO.buildSuccess(earningsReturnAll);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    //返回某一产品的累计收益和每日收益
    public ResponseVO getSpecific(int userId,String code){
        try{
            List<String> earningsReturnAll=(List<String>) getAll(userId).getContent();
            String r=null;
            for(String p:earningsReturnAll){
                String[] temp=p.split(",");
                String pCode=temp[0];
                if(code.equals(pCode)){
                    r=p;
                }
            }
            return ResponseVO.buildSuccess(r);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO getHistory(int userId,String code){
        try {
            PurchaseRecord pr=purchaseMapper.selectRecordByUserIdAndCode(userId,code);
            String his[]=pr.getHistory().split(",");

            List<Double> history=new ArrayList<>();
            for (String item:his){
                history.add(Double.parseDouble(item));
            }
            return ResponseVO.buildSuccess(history);

        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO getMonthHistory(int userId){
        try {
            List<PurchaseRecord> all=purchaseMapper.getAll();
            List<PurchaseRecord> presentUser=new ArrayList<>();
            List<String> columns=new ArrayList<>();
            TraceVO response=new TraceVO();
            columns.add("日期");
            for (PurchaseRecord pr:all){
                if (pr.getUserId()==userId){
                    presentUser.add(pr);
                    columns.add(pr.getName());
                }
            }
            // 6 1 5 3 4 5
            response.setColumns(columns);
            DailyBenefitVO[] dailyBenefitVOS=new DailyBenefitVO[30];
            for (int i=0;i<30;i++){
                DailyBenefitVO dailyBenefitVO=new DailyBenefitVO();
                dailyBenefitVO.setDate(getDate(30-i));
                List<Double> list=new ArrayList<>();
                for (PurchaseRecord item:presentUser){
                    String stringHistory=item.getHistory();
                    String[] historyArr=stringHistory.split(",");
                    if (historyArr.length> (30-i)){
                        int index=historyArr.length-(30-i);
                        list.add(Double.parseDouble(historyArr[index]));
                    }
                }
                dailyBenefitVO.setBenefits(list);
                dailyBenefitVOS[i]=dailyBenefitVO;
            }
            response.setRows(dailyBenefitVOS);
            return ResponseVO.buildSuccess(response);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO addPurchase(int userId,String code,int number,Timestamp startTime){
        try {
            PurchaseForm purchaseForm=new PurchaseForm();
            JSONObject jsonObject=getRequest1(code);
            purchaseForm.setCode(code);
            purchaseForm.setName((String)jsonObject.get("name"));
            purchaseForm.setNumber(number);
            purchaseForm.setType(3);
            purchaseForm.setUserId(userId);
            purchaseForm.setStartTime(startTime);
            purchaseForm.setPrincipal(number*((double)jsonObject.get("price")));
            purchaseMapper.insertRecord(purchaseForm);
            return ResponseVO.buildSuccess();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO getTotal(int userId){
        try {
            List<PurchaseRecord> all=purchaseMapper.selectRecordsByUserId(userId);
            //总投入
            double totalInput=0;
            //总价值
            double total=0;
            //总收益
            double totalIncome=0;
            List<MessageItem> scheme=new ArrayList<>();
            for (PurchaseRecord purchaseRecord:all){
                int type=purchaseRecord.getType();
                if (type==0){
                    continue;
                }
                String name=purchaseRecord.getName();
                Timestamp time1=purchaseRecord.getStartTime();
                String s=(String)getSpecific(userId,purchaseRecord.getCode()).getContent();
                double earning=Double.parseDouble(s.split(",")[2]);
                double growthRate=earning/purchaseRecord.getPrincipal();
                MessageItem messageItem=new MessageItem();
                messageItem.setGrowthRate(growthRate);
                messageItem.setName(name);
                messageItem.setTime1(time1);
                scheme.add(messageItem);

                totalInput=totalInput+purchaseRecord.getPrincipal();
                total=total+earning+purchaseRecord.getPrincipal();
                totalIncome=totalIncome+earning;

            }
            Message message=new Message();
            message.setScheme(scheme);
            message.setTotal(total);
            message.setTotalInput(totalInput);
            message.setTotalIncome(totalIncome);

            return ResponseVO.buildSuccess(message);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    //债券KEY
    public static final String APPKEY ="da1fc68aff9b013397d0356b5854b8a4";

    //请求股票数据
    public static JSONObject getRequest1(String code){
        //接口地址
        String requestUrl = "https://api.doctorxiong.club/v1/stock/detail";
        return getRequest(requestUrl,code);
    }

    //请求基金数据
    public static JSONObject getRequest2(String code) {
        //接口地址
        String requestUrl = "https://api.doctorxiong.club/v1/fund/detail";
        //params用于存储要请求的参数
        return getRequest(requestUrl,code);
    }

    //请求债券数据
    public static JSONObject getRequest3(String code){
        return getRequestall(code,"http://web.juhe.cn:8080/fund/netdata/bond");
    }

    public static JSONObject getRequest(String requestUrl,String code){
        //params用于存储要请求的参数
        Map params = new HashMap();
        params.put("code",code);
        String string = httpRequest(requestUrl,params);
        //处理返回的JSON数据并返回
        JSONObject object = JSONObject.fromObject(string);
        return object.getJSONObject("data");
    }

    private static String httpRequest(String requestUrl,Map params) {
        //buffer用于接受返回的字符
        StringBuffer buffer = new StringBuffer();
        try {
            //建立URL，把请求地址给补全，其中urlencode（）方法用于把params里的参数给取出来
            URL url = new URL(requestUrl+"?"+urlencode(params));
            //打开http连接
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.connect();

            //获得输入
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            //将bufferReader的值给放到buffer里
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            //关闭bufferReader和输入流
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            //断开连接
            httpUrlConn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回字符串
        return buffer.toString();
    }

    public static JSONObject getRequestall(String code,String oldUrl){
        String result =null;
        String url =oldUrl;//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key",APPKEY);//APPKEY值

        try {
            result =net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                JSONArray ja=JSONArray.fromObject(object.get("result"));
                JSONObject ob=ja.getJSONObject(0);
                System.out.println(ob);
                Iterator iter=ob.keys();
                while (iter.hasNext()){
                    String key=(String)iter.next();
                    JSONObject value=ob.getJSONObject(key);
                    if (((String)value.get("code")).equals(code)){
                        return value;
                    }
                }

            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String net(String strUrl, Map params,String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if(method==null || method.equals("GET")){
                strUrl = strUrl+"?"+urlencode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if(method==null || method.equals("GET")){
                conn.setRequestMethod("GET");
            }else{
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("User-agent", userAgent);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params!= null && method.equals("POST")) {
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                    out.writeBytes(urlencode(params));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }

    public static String urlencode(Map<String,Object>data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static String getDate(int day){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar=new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(calendar.DATE,-day);
        String dd=sdf.format(calendar.getTime());
        return dd;
    }
}