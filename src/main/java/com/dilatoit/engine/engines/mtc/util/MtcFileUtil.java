package com.dilatoit.engine.engines.mtc.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author xueshan.wei
 *
 */
public class MtcFileUtil {
	
	public static String httpUploadAPP(String url, String fileFormName, File file, String userId, String fileType){
		String result = "";
		CloseableHttpClient httpclient = HttpClients.createDefault();  
        try {  
            //HttpPost httppost = new HttpPost("http://10.0.40.49:8001/app/submitApp");
            HttpPost httppost = new HttpPost(url);

            //FileBody bin = new FileBody(new File("F:\\image\\sendpix0.jpg"));  
            FileBody bin = new FileBody(file);
            
            StringBody commentUserId = new StringBody(userId, ContentType.MULTIPART_FORM_DATA);
            StringBody commentFileType = new StringBody(fileType, ContentType.MULTIPART_FORM_DATA);
            StringBody token = new StringBody("", ContentType.MULTIPART_FORM_DATA);

            
            HttpEntity reqEntity = MultipartEntityBuilder.create()
            		.addPart(fileFormName, bin)
            		.addPart("userId", commentUserId)
            		.addPart("fileType", commentFileType)
            		.addPart("token", token)
            		.build();
            httppost.setEntity(reqEntity);  
  
            System.out.println("executing request " + httppost.getRequestLine());  
            CloseableHttpResponse response = httpclient.execute(httppost);  
            try {
                HttpEntity resEntity = response.getEntity();
                
                if (resEntity != null) {  
                	
                	BufferedReader in = new BufferedReader(new InputStreamReader(resEntity.getContent()));
                    String line;
                    while ((line = in.readLine()) != null) {
                        result += line;
                    }
                    
                }  
                EntityUtils.consume(resEntity);  
            } finally {  
                response.close();  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }
        
        return result;
	}
	
	public static String httpUploadFile(String url, String fileFormName, File file, String bucket, String key){
		String result = "";
		CloseableHttpClient httpclient = HttpClients.createDefault();  
        try {  
            HttpPost httppost = new HttpPost(url);
  
            FileBody bin = new FileBody(file);
            
            StringBody commentBucket = new StringBody(bucket, ContentType.MULTIPART_FORM_DATA);
            StringBody commentKey = new StringBody(key, ContentType.MULTIPART_FORM_DATA);
            
            
            HttpEntity reqEntity = MultipartEntityBuilder.create()
            		.addPart(fileFormName, bin)
            		.addPart("bucket", commentBucket)
            		.addPart("key", commentKey)
            		.build();  
            httppost.setEntity(reqEntity);  
  
            System.out.println("executing request " + httppost.getRequestLine());  
            CloseableHttpResponse response = httpclient.execute(httppost);  
            try {  
                HttpEntity resEntity = response.getEntity();
                
                if (resEntity != null) {  
                	
                	BufferedReader in = new BufferedReader(new InputStreamReader(resEntity.getContent()));
                    String line;
                    while ((line = in.readLine()) != null) {
                        result += line;
                    }
                    
                }  
                EntityUtils.consume(resEntity);  
            } finally {  
                response.close();  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }
        
        return result;
	}
}
