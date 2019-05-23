package com.dilatoit.eagletest.service;

/**
 * 网络模拟
 * Created by xueshan.wei on 5/12/2017.
 */
public interface NetSimulationService {
    /**
     * 设置网络模拟
     * @param deviceIp 设备ip
     * @param param 网络模拟参数
     * @return true 成功 | false 失败
     */
    boolean setNetSimulation(String deviceIp, String param);

    /**
     * 移除网络模拟
     * @param deviceIp 设备ip
     * @return true 成功 | false 失败
     */
    boolean removeNetSimulation(String deviceIp);

    /**
     * 查询网络模拟状态
     * @param deviceIp
     * @return
     */
    boolean queryNetSimulationStatus(String deviceIp);
}
