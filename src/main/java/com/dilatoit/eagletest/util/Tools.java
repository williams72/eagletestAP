package com.dilatoit.eagletest.util;

import sun.security.action.GetPropertyAction;

import java.io.File;
import java.security.AccessController;
import java.util.UUID;

/**
 * Created by xueshan.wei on 12/1/2016.
 */
public class Tools {
    public static String getUuid(){
        return UUID.randomUUID().toString();
    }

    public static String getTempPath(){
        //TODO temp path is hard-coded
        String tempFolder = "/tmp/EagleTest/";
        //String tempFolder = System.getProperty("java.io.tmpdir") + "/EagleTest/";
        //String tempFolder = new File(AccessController.doPrivileged(new GetPropertyAction("java.io.tmpdir"))) + "/EagleTest/";
        tempFolder =  tempFolder.replaceAll("\\\\", "/");
        File file = new File(tempFolder);
        if(!file.exists()){
            file.mkdirs();
            new File(tempFolder + "rf_log/").mkdir();
            new File(tempFolder + "rf_result/").mkdir();
            new File(tempFolder + "script_file/").mkdir();
            new File(tempFolder + "others/").mkdir();
        }
        return tempFolder;
    }
}
