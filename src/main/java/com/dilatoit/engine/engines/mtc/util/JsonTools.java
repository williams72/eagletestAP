package com.dilatoit.engine.engines.mtc.util;

import com.google.gson.Gson;

import java.util.Map;

/**
 * Created by xueshan.wei on 11/21/2016.
 */
public class JsonTools {
    public static Map toMap(String json){
        Gson gson = new Gson();

        Map map = gson.fromJson(json, Map.class);
        return map;
    }
}
