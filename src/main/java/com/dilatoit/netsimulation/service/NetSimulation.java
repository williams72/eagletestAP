package com.dilatoit.netsimulation.service;

import com.dilatoit.eagletest.config.WeaknetConfig;
import com.google.gson.Gson;
import com.dilatoit.netsimulation.http.HttpUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.Map;

/**
 * 网络模拟盒子交互类
 * 负责与网络模拟盒子进行交互的组件
 *
 * Created by xueshan.wei on 5/12/2017.
 */
@Component
@Scope("singleton")
public class NetSimulation {
    private static final Logger LOGGER = LoggerFactory.getLogger(NetSimulation.class);
    @Autowired
    private WeaknetConfig weaknetConfig;

    //private final String SERVER_ADDRESS = "http://10.0.40.35:8000";
    private String SERVER_ADDRESS = null;
    private final String GET_STATUS = "/api/v1/shape/";
    private final String SET_STATUS = "/api/v1/shape/"; // SET_STATUS + deviceIp + "/"
    private final String REMOVE_STATUS = "/api/v1/shape/";

    private final String IS_NOT_SHAPE_STR_BEG = "{\"detail\":\"This IP (";
    private final String IS_NOT_SHAPE_STR_END = ") is not being shaped\"}";
    /**
     * 设置网络模拟
     * @param deviceIp 设备ip
     * @param param 网络模拟参数
     * @return true 成功 | false 失败
     */
    public boolean setNetSimulation(String deviceIp, String param){
        LOGGER.debug("设置网络模拟: deviceIp = " + deviceIp + " param = " + param);

        try{
            SERVER_ADDRESS = weaknetConfig.getServerUrl();

        }catch (Exception e){
            e.printStackTrace();
        }
        String url = "http://" + SERVER_ADDRESS + SET_STATUS + deviceIp + "/";
        String result = null;
        try {
            System.out.println("url = " + url);
            result = HttpUtils.sendJsonPost(url, param);
            System.out.println(param);
            System.out.println(result);
            LOGGER.debug(result);
        } catch (Exception e) {
            System.out.println("设置网络模拟出错");
            LOGGER.error("设置网络模拟出错");
            e.printStackTrace();
            return false;
        }
        if(StringUtils.isNotBlank(result)){
            return checkIsInNetSimulation(deviceIp);
        }
        return false;
    }

    /**
     * 移除网络模拟
     * @param deviceIp 设备ip
     * @return true 成功 | false 失败
     */
    public boolean removeNetSimulation(String deviceIp){
        try{
            SERVER_ADDRESS = weaknetConfig.getServerUrl();
        }catch (Exception e){
            e.printStackTrace();
        }
        String url = "http://" + SERVER_ADDRESS + REMOVE_STATUS + deviceIp + "/";
        String result = null;
        LOGGER.debug("移除网络模拟：url = " + url);
        try {
            result = HttpUtils.sendDelete(url);
        } catch (Exception e) {
            LOGGER.error("移除网络模拟出错： deviceIp = " + deviceIp);
            e.printStackTrace();
            return false;
        }
        if(StringUtils.isBlank(result)){
            return true;
        }
        Gson gson = new Gson();
        Map map = gson.fromJson(result, Map.class);
        if(map != null && map.containsKey("message") && map.containsKey("result")){
            String message = (String) map.get("message");
            String re = (String) map.get("result");

            if(!"12".equals(re)){
                return true;
            }
        }
        return false;
    }

    /**
     * 用来检查某个ip的设备是否处于网络模拟中
     * @param deviceIp 设备ip
     * @return true 处于网络模拟中 | false 不处于网络模拟中
     */
    public boolean checkIsInNetSimulation(String deviceIp){
        try{
            SERVER_ADDRESS = weaknetConfig.getServerUrl();
        }catch (Exception e){
            e.printStackTrace();
        }
        String url = "http://" + SERVER_ADDRESS + GET_STATUS + deviceIp + "/";
        String result = null;
        try {
            result = HttpUtils.sendGet(url);

        } catch (Exception e) {
            LOGGER.error("查询网络模拟出错： deviceIp = " + deviceIp);
            e.printStackTrace();
            return false;
        }
        System.out.println(result);

        String isNotShapedStr = IS_NOT_SHAPE_STR_BEG + deviceIp + IS_NOT_SHAPE_STR_END;
        if(!isNotShapedStr.equals(result)){
            return true;
        }
        return false;
    }
}
