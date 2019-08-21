package com.ninova.mlc.blImpl.trace;

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
import java.util.Iterator;
import java.util.Map;

@Service
@Repository
public class TraceServiceImpl {
    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

    //申请的KEY
    public static final String APPKEY ="a04675114c99983de7e893dbaca4896c";
    //债券KEY
    public static final String APPKEY_2 ="da1fc68aff9b013397d0356b5854b8a4";

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
        return getRequestall(code,"http://web.juhe.cn:8080/fund/netdata/all");
    }

    //请求债券数据
    public static JSONObject getRequest3(String code){
        return getRequestall(code,"http://web.juhe.cn:8080/fund/netdata/bond");
    }

    public static JSONObject getRequestall(String code,String oldUrl){
        String result =null;
        String url =oldUrl;//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key",APPKEY_2);//APPKEY值

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
}
