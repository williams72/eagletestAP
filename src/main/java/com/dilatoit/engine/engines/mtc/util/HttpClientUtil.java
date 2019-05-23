package com.dilatoit.engine.engines.mtc.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xueshan.wei on 12/1/2016.
 */
public class HttpClientUtil {
    public static String sendJsonPost(String url, String jsonStr){
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        try {
            StringEntity s = new StringEntity(jsonStr, "UTF-8");
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");
            httpPost.setEntity(s);

            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity resEntity = response.getEntity();

            if (resEntity != null) {

                BufferedReader in = new BufferedReader(new InputStreamReader(resEntity.getContent()));
                String line;
                while ((line = in.readLine()) != null) {
                    result += line;
                }
                EntityUtils.consume(resEntity);

            }
            response.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally{
            try {
                httpClient.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return result;
    }
}
