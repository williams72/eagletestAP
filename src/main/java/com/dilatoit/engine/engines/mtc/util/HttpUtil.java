package com.dilatoit.engine.engines.mtc.util;

import com.dilatoit.eagletest.exception.ex.InternalServerException;
import com.dilatoit.engine.exception.EngineNotFoundException;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpUtil {
    private static Logger LOGGER = Logger.getLogger(HttpUtil.class);
    /**
     * 
     * Send request to a specify URL by GET method
     * 
     * @param url  the aim URL
     *      
     * @param param   request parameter as name1=value1&name2=value2
     * 
     * @return the response result
     */
    public static String sendGet(String url, String param) throws EngineNotFoundException {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // Create connection instance
            URLConnection connection = realUrl.openConnection();
            // setting the request property
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // open connect
            connection.connect();
            // get the response header
            Map<String, List<String>> map = connection.getHeaderFields();
            // iterator the 
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // create BufferedReader read the output
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            LOGGER.error("mtc server is not found");
            throw new EngineNotFoundException("mtc server is not found");
        }
        // close the stream
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Send request to a specify URL by POST method
     * 
     * @param url  the aim URL
     *      
     * @param param   request parameter as name1=value1&name2=value2
     * 
     * @return the response result
     * @throws InternalServerException 
     */
    public static String sendPost(String url, String param) throws EngineNotFoundException {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // create the connection instance
            URLConnection conn = realUrl.openConnection();
            // setting the request property
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // you have to setting the follow
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // get URLConnection output stream
            out = new PrintWriter(conn.getOutputStream());
            // send request
            out.print(param);
            // flush the cache
            out.flush();
            // create BufferedReader read the output
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            LOGGER.error("mtc server is not found");
            throw new EngineNotFoundException("mtc server is not found");
        }
        //close the stream
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }    
}