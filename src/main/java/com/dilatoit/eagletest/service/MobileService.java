package com.dilatoit.eagletest.service;


import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtMobile;
import com.dilatoit.engine.dto.MobileDTO;
import com.dilatoit.engine.enums.EngineEnum;
import com.dilatoit.engine.enums.MobileOsEnum;
import com.dilatoit.engine.exception.EngineException;

import java.util.List;
import java.util.Map;

/**
 * Created by beishan on 2016/11/15.
 */
public interface MobileService {
    /**
     * 查询本地数据库
     * @return
     * @throws DataBaseException
     */
    default List<EtMobile> queryMobilesNew() throws DataBaseException {
        return null;
    }

    Map queryMobiles() throws BusinessException;

    default EtMobile queryByName(String queryName, String value) throws DataBaseException{
        return null;
    }

    EtMobile queryById(Integer mobileId)throws DataBaseException;

    /**
     * rename a mobile
     * @param serialNumber
     * @return
     * @throws EngineException
     */
    String httpRename(String serialNumber, String name) throws EngineException;

    /**
     * reboot a mobile
     * @param serialNumber
     * @return
     * @throws EngineException
     */
    String httpReboot(String serialNumber) throws EngineException;

    /**
     * get all mobile info
     * @return
     * @throws EngineException
     */
    String httpGetMobileInfo() throws EngineException;

    /**
     * 旧接口
     * @param mobileOsEnum
     * @return
     * @throws EngineException
     */
    String httphttpGetMobileInfoByOS(MobileOsEnum mobileOsEnum) throws EngineException;

    /**
     * get all mobiles by mobile os
     * @param mobileOsEnum ios | android | all
     * @return
     * @throws EngineException
     */
    List<MobileDTO> httpGetMobileInfoByOS(EngineEnum engineEnum, MobileOsEnum mobileOsEnum) throws EngineException;

    /**
     * stop the mobile`s current task
     * @param serialNumber
     * @return
     * @throws EngineException
     */
    String httpStopCurrentTask(String serialNumber, String taskId) throws EngineException;

    /**
     * stop all the mobile`s task incloud queue
     * @param serialNumber
     * @return
     * @throws EngineException
     */
    String httpStopAllTask(String serialNumber) throws EngineException;
}
