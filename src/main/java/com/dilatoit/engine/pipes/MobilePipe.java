package com.dilatoit.engine.pipes;

import com.dilatoit.engine.dto.MobileDTO;
import com.dilatoit.engine.enums.MobileOsEnum;
import com.dilatoit.engine.exception.EngineException;
import com.dilatoit.engine.exception.MobilePipeException;

import java.util.List;

/**
 * Created by xueshan.wei on 11/16/2016.
 */
public interface MobilePipe {
    /**
     * reboot a mobile
     * @param mobileId the mobile's unique identifier
     *                 forexample: mobile's serial number
     * @return the reboot result
     * @throws MobilePipeException
     */
    String reboot(String mobileId) throws EngineException;

    /**
     * rename a mobile
     * @param mobileId the mobile's unique identifier
     *                 forexample: mobile's serial number
     * @param name     the new name
     * @return change`s result
     * @throws MobilePipeException
     */
    @Deprecated
    String rename(String mobileId, String name) throws EngineException;

    @Deprecated
    String mobiles() throws MobilePipeException;

    @Deprecated
    String mobilesByOs(MobileOsEnum mobileOsEnum) throws MobilePipeException;
    /**
     * 查询所有设备
     * @return
     *     1、所有设备列表，
     *     2、null 如果没有在线设备，则返回空
     * @throws EngineException
     */
    List<MobileDTO> queryMobiles() throws EngineException;

    /**
     * 查询指定OS的设备
     * @param mobileOsEnum 设备类型枚举类型
     * @return
     *     1、所有设备列表，
     *     2、null 如果没有在线设备，则返回空
     * @throws EngineException
     */
    List<MobileDTO> queryMobilesByOS(MobileOsEnum mobileOsEnum) throws EngineException;

    /**
     * stop the current task in this mobile
     * @param mobileId the mobile's unique identifier
     *                 forexample: mobile's serial number
     * @param taskId   the task's unique identifier
     * @return the result
     * @throws MobilePipeException
     */
    String stopCurrentTask(String mobileId, String taskId) throws EngineException;

    /**
     * sotp all the task in this mobile
     * @param mobileId the mobile's unique identifier
     *                 forexample: mobile's serial number
     * @return the result
     * @throws MobilePipeException
     */
    String stopAllTask(String mobileId) throws EngineException;
}
