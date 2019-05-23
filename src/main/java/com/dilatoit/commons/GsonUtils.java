package com.dilatoit.commons;

import com.google.gson.Gson;

import java.util.Map;

/**
 * Gson utils
 * Created by xueshan.wei on 3/29/2017.
 */
public class GsonUtils {
    private static Gson gson = new Gson();

    public static String toJsonString(Object obj){
        return gson.toJson(obj);
    }

    /**
     * convert a json string to map
     * @param json
     * @return a map object or null if the json is null
     */
    public static Map toMap(String json){
        return gson.fromJson(json, Map.class);
    }
}
