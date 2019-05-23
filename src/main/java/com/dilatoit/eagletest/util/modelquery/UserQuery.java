package com.dilatoit.eagletest.util.modelquery;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xueshan.wei on 12/28/2016.
 */
public class UserQuery {
    private static Set<String> querys = null;
    static{
        querys = new HashSet<String>();
        querys.add("username");
        querys.add("email");
    }
    public static boolean contains(String field){
        if(querys.contains(field)){
            return true;
        }
        return false;
    }
}
