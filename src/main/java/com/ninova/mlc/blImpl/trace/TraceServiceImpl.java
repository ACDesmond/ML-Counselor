package com.ninova.mlc.blImpl.trace;

import com.ninova.mlc.bl.trace.TraceService;
import com.ninova.mlc.data.PurchaseMapper;
import com.ninova.mlc.po.PurchaseRecord;
import com.ninova.mlc.vo.ResponseVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

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
    public ResponseVO getStockDailyBenefit(int userId, String code){
        try{
            float stockDailyBenefit;
            PurchaseRecord stock=purchaseMapper.selectRecordByUserIdAndCode(userId,code);
            float num=stock.getNumber();
            float nowPrice=(float)getRequest(code).get("nowPri");
            float yestodEndPrice=(float)getRequest(code).get("yestodEndPri");
            stockDailyBenefit=(nowPrice-yestodEndPrice)*num;
            return ResponseVO.buildSuccess(stockDailyBenefit);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO getStockTotalBenefit(int userId,String code){
        try{
            double stockTotalBenefit;
            PurchaseRecord stock=purchaseMapper.selectRecordByUserIdAndCode(userId,code);
            float num=stock.getNumber();
            float nowPrice=(float)getRequest(code).get("nowPri");
            double principle=stock.getPrincipal();
            stockTotalBenefit=nowPrice*num-principle;
            return ResponseVO.buildSuccess(stockTotalBenefit);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO getfundDailyBenefit(int userId,String code){
        try{
            double fundDailyBenefit=0.0;
            return ResponseVO.buildSuccess(fundDailyBenefit);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO getfundTotalBenefit(int userId,String code){
        try{
            double fundTotalBenefit=0.0;
            return ResponseVO.buildSuccess(fundTotalBenefit);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO getbondDailyBenefit(int userId,String code){
        try{
            double bondDailyBenefit=0.0;
            return ResponseVO.buildSuccess(bondDailyBenefit);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO getbondTotalBenefit(int userId,String code){
        try{
            double bondTotalBenefit=0.0;
            return ResponseVO.buildSuccess(bondTotalBenefit);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO getCFPDailyBenefit(int userId,String code){
        try{
            double CFPDailyBenefit=0.0;
            return ResponseVO.buildSuccess(CFPDailyBenefit);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO getCFPTotalBenefit(int userId,String code){
        try{
            double CFPTotalBenefit=0.0;
            return ResponseVO.buildSuccess(CFPTotalBenefit);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }


    //申请的KEY
    public static final String APPKEY ="a04675114c99983de7e893dbaca4896c";

    //沪深股市
    public static JSONObject getRequest(String code){
        String result=null;
        String url ="http://web.juhe.cn:8080/finance/stock/hs";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("gid","sh"+code);//股票编号，上海股市以sh开头，深圳股市以sz开头如：sh601009
        params.put("key",APPKEY);//APP Key

        try {
            result =net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            //转换
            Object jsonArray=object.get("result");
            System.out.println(((JSONArray) jsonArray).get(0));
            JSONObject data=(JSONObject)((JSONArray) jsonArray).get(0);
            data=data.getJSONObject("data");
            if(object.getInt("error_code")==0){
                return data;
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //请求基金数据
    public static JSONObject getRequest2(String code) {
        //接口地址
        String requestUrl = "http://fundgz.1234567.com.cn/js/"+code+".js?rt=1463558676006";
        Map params = new HashMap();
        String string = httpRequest(requestUrl,params);
        string=string.substring(8,string.length()-2);
        JSONObject object = JSONObject.fromObject(string);
        System.out.println(object);
        return object;
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
}
