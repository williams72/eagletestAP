package com.dilatoit.engine.engines.ete;

import com.dilatoit.commons.GsonUtils;
import com.dilatoit.commons.http.HttpUtils;
import com.dilatoit.engine.engines.mtc.util.HttpUtil;
import com.dilatoit.engine.exception.EngineException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 负责与远端engine 交互
 * Created by xueshan.wei on 6/19/2017.
 */
@Component
public class EteEngineRemoteMaster {
    @Autowired
    private EteEngineConfig eteEngineConfig;

    /**
     * post 方法交互类
     * @param api
     * @param params
     * @return 正常返回的数据 | null 结果出错时
     * @throws EngineException
     */
    public Map postMethod(String api, String params) throws EngineException{
        String uri = eteEngineConfig.getServerUrl() + api;
        String result = null;
        try {
            result = HttpUtils.sendJsonPost(uri, params);
        } catch (Exception e) {
            e.printStackTrace();
            throw new EngineException("[ETE 连接错误]");
        }
        Map resultMap = GsonUtils.toMap(result);
        return resultMap;
    }

    public Map getMethod(String api) throws EngineException{
        return getMethod(api, null);
    }

    public Map getMethod(String api, String params) throws EngineException{
        String result = null;
        String uri = eteEngineConfig.getServerUrl() + api;
        try {
            result = HttpUtils.sendGet(uri, params);
        } catch (Exception e) {
            e.printStackTrace();
            throw new EngineException("[ETE 连接错误]");
        }
        Map resultMap = GsonUtils.toMap(result);
        return resultMap;
    }

}
