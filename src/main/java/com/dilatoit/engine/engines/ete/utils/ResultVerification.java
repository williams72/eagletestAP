package com.dilatoit.engine.engines.ete.utils;

import com.dilatoit.commons.GsonUtils;
import com.google.gson.Gson;

import java.util.Map;

/**
 * ete engine result verification class
 * Created by xueshan.wei on 6/14/2017.
 */
public class ResultVerification {
    /**
     * 判断ete engine 返回的结果是否成功
     * @param resultJson
     * @return
     */
    public static boolean isSuccess(String resultJson){
        Map map = GsonUtils.toMap(resultJson);
        if(map != null && map.containsKey("code")){
            String code = (String) map.get("code");
            if("00000000".equals(code)){
                return true;
            }
        }
        return false;
    }
}
