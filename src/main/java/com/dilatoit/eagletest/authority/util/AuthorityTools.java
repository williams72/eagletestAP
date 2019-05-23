package com.dilatoit.eagletest.authority.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beishan on 2016/12/5.
 */
public class AuthorityTools {
    public static List<String> parsePermission(String permission){
        List<String> result = new ArrayList<String>();
        if(permission != null && permission.length() > 0){
            String rp[] = permission.split(":");
            String resource = rp[0];
            String [] ops = rp[1].split(",");

            for(int i = 0; i < ops.length; i++){
                result.add(resource + ":" + ops[i]);
            }
        }else{
            System.out.println("权限字符串既不能为null，也不能为空！");
        }
        return result;
    }
}
