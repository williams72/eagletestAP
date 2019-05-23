package com.dilatoit.eagletest.util;

import com.google.gson.Gson;

import java.util.Map;

/**
 * Created by xueshan.wei on 3/29/2017.
 */
public class GsonUtils {
    private static Gson gson = new Gson();

    public static String toJsonString(Object obj){
        return gson.toJson(obj);
    }

    public static Map toMap(String json){
        return gson.fromJson(json, Map.class);
    }
}
