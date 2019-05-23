package com.dilatoit.eagletest.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.dilatoit.commons.http.HttpUtils;
import com.dilatoit.engine.engines.mtc.util.HttpUtil;
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
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


/**
 * 
 * @author xueshan.wei
 *
 */

public class FileUtil {
	
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
            
            
            HttpEntity reqEntity = MultipartEntityBuilder.create()
            		.addPart(fileFormName, bin)
            		.addPart("userId", commentUserId)
            		.addPart("fileType", commentFileType)
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
            //HttpPost httppost = new HttpPost("http://10.0.40.49:8001/storage/upload");
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

	public static File transferFile(MultipartFile file, File tempDir) throws IOException{
        String prefix = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf(".") - 1) + "-";
        String uuid = Tools.getUuid();
        String suffix ="."+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        //File tempFile = new File(prefix + uuid + suffix);
        //tempFile.createNewFile();
        File tempFile = File.createTempFile(prefix, suffix, tempDir);
        try {
            file.transferTo(tempFile);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("转换错误！");
        }
        return tempFile;
    }

	public static String unZipFile(String zipFile, String descDir) throws IOException{
        ZipFile zip = new ZipFile(zipFile, Charset.forName("GBK"));//解决中文文件夹乱码
        //统一路径符号
        String zipPath = zip.getName().replaceAll("\\\\", "/");
        descDir = descDir.replaceAll("\\\\", "/");

        //System.out.println(zipPath);
        String name = zipPath.substring(zipPath.lastIndexOf('/') + 1, zipPath.lastIndexOf('.'));

        File pathFile = new File(descDir + "/"  + name);
        if (!pathFile.exists()) {
            if(!pathFile.mkdirs()){
                return null;
            }
        }
        else {
            FileUtil.delete(pathFile.getPath());
            if(!pathFile.mkdirs()){
                return null;
            }
        }

        for (Enumeration<? extends ZipEntry> entries = zip.entries(); entries.hasMoreElements();) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            String zipEntryName = entry.getName();
            InputStream in = zip.getInputStream(entry);
            String outPath = (descDir + "/"  + name  + "/" + zipEntryName).replaceAll("\\\\", "/");

            // 判断路径是否存在,不存在则创建文件路径
            File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
            if (!file.exists()) {
              if(!file.mkdirs()){
                  return null;
              }
            }
            // 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
            if (new File(outPath).isDirectory()) {
                continue;
            }
            // 输出文件路径信息
            System.out.println(outPath);

            FileOutputStream out = new FileOutputStream(outPath);
            byte[] buf1 = new byte[1024];
            int len;
            while ((len = in.read(buf1)) > 0) {
                out.write(buf1, 0, len);
            }
            in.close();
            out.close();
            zip.getInputStream(entry).close();
        }
        zip.stream().close();
        zip.close();
        System.out.println("******************解压完毕********************");

        return  pathFile.getAbsolutePath().replaceAll("\\\\", "/");
    }

    public static boolean delete(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("删除文件失败:" + fileName + "不存在！");
            return false;
        } else {
            if (file.isFile())
                return deleteFile(fileName);
            else
                return deleteDirectory(fileName);
        }

    }

    private static boolean deleteFile(String fileName){
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }

    private static boolean deleteDirectory(String dir) {
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        if (!dir.endsWith(File.separator))
            dir = dir + File.separator;
        File dirFile = new File(dir);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
            System.out.println("删除目录失败：" + dir + "不存在！");
            return false;
        }
        boolean flag = true;
        // 删除文件夹中的所有文件包括子目录
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 删除子文件
            if (files[i].isFile()) {
                flag = FileUtil.deleteFile(files[i].getAbsolutePath());
                if (!flag)
                    break;
            }
            // 删除子目录
            else if (files[i].isDirectory()) {
                flag = FileUtil.deleteDirectory(files[i]
                        .getAbsolutePath());
                if (!flag)
                    break;
            }
        }
        if (!flag) {
            System.out.println("删除目录失败！");
            return false;
        }
        // 删除当前目录
        if (dirFile.delete()) {
            System.out.println("删除目录" + dir + "成功！");
            return true;
        } else {
            return false;
        }
    }

    public static int getFileLines(String filePath) {
        int count = 0;
        try{
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            while (br.readLine() != null){
                count++;
            }
            br.close();
            fr.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return count;
    }

    public static void refreshFile(String localFilePath, String serverFileUrl){
        if(new File(localFilePath).exists()){
            int count = FileUtil.getFileLines(localFilePath);
            try{
                URL url = new URL(serverFileUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream is = connection.getInputStream();
                InputStreamReader  isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                FileWriter fr = new FileWriter(localFilePath, true);
                BufferedWriter bw = new BufferedWriter(fr);

                String lineStr;
                int line = 1;
                while ((lineStr = br.readLine()) != null) {
                    if(line > count){
                        bw.write(lineStr);
                        bw.newLine();
                        bw.flush();
                    }
                    line++;
                }
                bw.close();
                fr.close();
                br.close();
                isr.close();
                is.close();
                connection.disconnect();
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {
            try{
                HttpUtils.downloadFile(serverFileUrl, localFilePath);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static boolean mtcServerFileIsExist(String serverFileUrl){
        String result = "";
        try {
            result = HttpUtils.sendGet(serverFileUrl);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  !(result.startsWith("{\"Error\":\"file not exists\""));
    }
}
