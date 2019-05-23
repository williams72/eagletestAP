package com.dilatoit.commons.http;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xueshan.wei on 5/12/2017.
 */
public class HttpUtils {


    /**
     * 下载文件
     * @param url
     * @param aimPath
     * @throws Exception
     */
    public static void downloadFile(String url, String aimPath) throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = "";
        try{
            HttpGet httpGet = new HttpGet(url);
            System.out.println("Executing request " + httpGet.getRequestLine());
            CloseableHttpResponse response = httpClient.execute(httpGet);
            String newFileName = "test.html";
            /*String pathName = System.getProperty("user.home") + File.separator + "downloadtest"
                    + File.separator + newFileName;*/
            FileOutputStream fos = new FileOutputStream(new File(aimPath));
            response.getEntity().writeTo(fos);
        }finally {
            httpClient.close();
        }
    }

    public static String sendGet(String url) throws Exception{
        return HttpUtils.sendGet(url, null);
    }

    /**
     * 发送Http Get 请求
     * @param url
     * @param params
     * @return
     * @throws Exception
     */
    public static String sendGet(String url, String params) throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = "";
        String uri = url + (StringUtils.isBlank(params) ? "" : "?" + params);
        try{
            HttpGet httpGet = new HttpGet(url);
            System.out.println("Executing request " + httpGet.getRequestLine());
            CloseableHttpResponse response = httpClient.execute(httpGet);
            result = parseResult(response);
        }finally {
            httpClient.close();
        }
        return result;
    }

    public static String sendJsonPost(String url, String jsonStr) throws Exception{
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        try{
            StringEntity stringEntity = new StringEntity(jsonStr, "UTF-8");
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);

            CloseableHttpResponse response = httpClient.execute(httpPost);

            result = parseResult(response);
        }
        finally {
            httpClient.close();
        }
        return result;
    }
    /**
     * 发送Post 请求
     * @param url
     * @param params
     * @return
     * @throws Exception
     */
    public static String sendPost(String url, List<SimpleParamEntity> params) throws Exception{
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try{
            HttpPost httpPost = new HttpPost(url);
            
            if(params != null && params.size() > 0){
                List<NameValuePair> nvps = new ArrayList<>();
                for (SimpleParamEntity spe: params
                     ) {
                    nvps.add(new BasicNameValuePair(spe.getName(), spe.getValue()));
                }
                httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            }
            CloseableHttpResponse response = httpClient.execute(httpPost);
            result = parseResult(response);

        }finally {
            httpClient.close();
        }
        return result;
    }

    /**
     * 发送Delete 请求
     * @param url
     * @return
     * @throws Exception
     */
    public static String sendDelete(String url) throws Exception{
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try{
            HttpDelete httpDelete = new HttpDelete(url);
            CloseableHttpResponse response = httpClient.execute(httpDelete);
            result = parseResult(response);
        }finally {
            httpClient.close();
        }
        return result;
    }

    /**
     * 读取响应结果
     * @param response
     * @return
     * @throws Exception
     */
    private static String parseResult(CloseableHttpResponse response) throws Exception{
        String result = "";
        try{
            HttpEntity entity = response.getEntity();
            if(entity != null) {
                InputStream inputStream = entity.getContent();
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                String line = null;
                try {
                    while ((line = br.readLine()) != null) {
                        result += line;
                    }
                } finally {
                    inputStream.close();
                }
                EntityUtils.consume(entity);
            }
        }finally {
            response.close();
        }
        return result;
    }
}
