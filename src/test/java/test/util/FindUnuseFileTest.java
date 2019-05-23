package test.util;

import org.hibernate.boot.jaxb.SourceType;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Administrator on 2017/7/3.
 */
public class FindUnuseFileTest {
    static List<File> fileList = new ArrayList<>();
    @Test
    public static void main(String[] args){

        String filePath = "C:\\Users\\Salt\\Documents\\IdeaProjects\\eagletest\\src\\main\\webapp\\WEB-INF\\view";
        getFileList(filePath);
        try{
            String str = null;
            Set<String>  set = new HashSet<>();
            for (int i = 0; i < fileList.size(); i++){
                FileReader fileReader = new FileReader(fileList.get(i).getAbsolutePath());
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while ((str=bufferedReader.readLine()) != null ){
                    /*if(str.trim().length() >= 5 && str.trim().substring(0,5).equals("<link")){
                        set.add(str.trim());
                    }*/
                    if(str.trim().length() >= 12 && str.trim().substring(0,12).equals("<script src=")){
                        set.add(str.trim());
                    }
                }
                bufferedReader.close();
            }
            for(String result: set) {
                System.out.println(result);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static List<File> getFileList(String strPath){
        File dir = new File(strPath);
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++){
            String fileName = files[i].getName();
            if(files[i].isDirectory()) {
                getFileList(files[i].getAbsolutePath());
            }else if(fileName != null && fileName.endsWith("ftl")){
                //String strFileName = files[i].getAbsolutePath();
                System.out.println(files[i].getAbsolutePath());
                fileList.add(files[i]);
            }
            else {
                continue;
            }
        }
        return fileList;
    }
}
