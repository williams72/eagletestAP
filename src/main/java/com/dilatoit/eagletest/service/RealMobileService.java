package com.dilatoit.eagletest.service;


import com.dilatoit.eagletest.api.model.ApiRealMobile;
import com.dilatoit.eagletest.dto.NetSimulationDTO;
import com.dilatoit.eagletest.enums.RealMobileStatus;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtMobile;
import com.dilatoit.eagletest.model.EtRealMobile;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;
import com.dilatoit.engine.enums.RealMobileTime;
import com.dilatoit.engine.exception.EngineException;

import java.util.List;

/**
 * Created by beishan on 2016/11/15.
 */
public interface RealMobileService {

    /**
     * 给某台真机调试中的设备设置网络模拟
     * @param rmid
     * @param netSimulationId
     * @return
     * @throws DataBaseException
     */
    NetSimulationDTO addNetSimulation(Integer rmid, Integer netSimulationId) throws BusinessException;

    /**
     *
     * @param rmid
     * @return
     * @throws BusinessException
     */
    NetSimulationDTO deleteSimulation(Integer rmid)throws BusinessException;

    /**
     *
     * @param rmid
     * @return
     * @throws BusinessException
     */
    NetSimulationDTO queryNetSimulation(Integer rmid)throws BusinessException;

    /**
     * 在停止真机调试前清除网络模拟环境，如果清理成功或没有网络模拟环境，则返回true
     * @param rmIp
     * @return
     * @throws BusinessException
     */
    boolean clearNetAfterRemote(String rmIp) throws BusinessException;

    /**
     * query by page
     * @param page
     * @throws DataBaseException
     */
    void page(DataPage<EtRealMobile> page) throws DataBaseException;

    /**
     * query page by conditions
     * @param page
     * @param conditions
     * @throws DataBaseException
     */
    void page(DataPage<EtRealMobile> page, Conditions conditions) throws DataBaseException;
    /**
     * query a realMobile by id
     * @param realMobileId
     * @return
     * @throws DataBaseException
     */
    EtRealMobile queryById(Integer realMobileId) throws DataBaseException;
    /**
     * save a real mobile
     * @param realMobile
     * @throws DataBaseException
     */
    Integer save(EtRealMobile realMobile) throws DataBaseException;

    /**
     * delete a real mobile
     * @param realMobile
     * @throws DataBaseException
     */
    void delete(EtRealMobile realMobile) throws DataBaseException;

    /**
     * update a realMobile
     * @param realMobile
     * @throws DataBaseException
     */
    void update(EtRealMobile realMobile) throws DataBaseException;

    /**
     * query all real mobile by conditions
     * @param conditions
     * @return
     * @throws DataBaseException
     */
    List<EtRealMobile> queryByConditions(Conditions conditions) throws DataBaseException;
    /**
     * get all real mobiles info
     * @return
     * @throws EngineException
     */
    String realmobiles() throws EngineException;

    /**
     * rent a real mobile
     * @param userId
     * @param serialNumber
     * @param realMobileTime
     * @return
     * @throws InternalServerException
     */
    Integer httpRentRealMobile(Integer userId, String serialNumber, String mobilename, RealMobileTime realMobileTime) throws DataBaseException, EngineException;

    /**
     * 查询某个远程手机的信息
     * 1、id 为 rmid 的远程真机不存在则返回 null
     * 2、id 为 rmid 的远程真机存在，并且没有结束，
     *    则返回这个远程真机的一些基本信息和剩余的时间以及调试窗口的地址
     * 3、id 为 rmid 的远程真机存在，并且已经结束，则返回
     *    则返回该这个远程真机的一些基本信息和结束状态
     * @param rmid
     * @return
     * @throws BusinessException
     */
    ApiRealMobile queryRealMobileInfo(Integer rmid) throws BusinessException;
    /**
     * get the info what have been rent real mobile
     * @param realMobileId
     * @return
     * @throws InternalServerException
     */
    String httpGetRealMobileInfo(Integer realMobileId) throws BusinessException;

    /**
     * renewal a real mobile
     * @param realMobileId
     * @param time
     * @return
     * @throws InternalServerException
     */
    String httpRenewalRealMobile(Integer realMobileId, Long time) throws EngineException, DataBaseException;

    /**
     * stop a real mobile
     * @param realMobileId serialNumber
     * @return
     * @throws EngineException
     */
    String httpStopRealMobile(Integer realMobileId) throws EngineException, DataBaseException,BusinessException;

    /**
     * stop the mobile`s all tiaoshi task
     * @param mobileId serialNubmer
     * @return
     * @throws EngineException
     */
    String httpStopAllRealmobile(String mobileId) throws BusinessException;

    /**
     * get all current tiaoshi mobiles
     * 得到某个用户当前正在调试的所有手机
     * @param userId
     * @return
     * @throws EngineException
     * @throws DataBaseException
     */
    List<EtRealMobile> currentRealMobiles(Integer userId) throws EngineException, DataBaseException;

    /**
     * 同步调试手机状态
     * @param rms
     * @return
     * @throws EngineException
     * @throws DataBaseException
     */
    List<EtRealMobile> synoRealMobileStatus(List<EtRealMobile> rms) throws EngineException, DataBaseException;

    /**
     * 更新手机状态
     * @param realmobileId
     * @param realMobileStatus
     * @throws DataBaseException
     */
    void updateRmStatus(Integer realmobileId, RealMobileStatus realMobileStatus) throws DataBaseException;

    /**
     * 查询该调试是否可用
     * @param realMobileId
     * @return
     * @throws EngineException
     */
    boolean isUsableRm(Integer realMobileId) throws EngineException, DataBaseException;

    /**
     * syno the realDevId
     * @param realMobileId
     * @throws EngineException
     * @throws DataBaseException
     */
    void synoRealDevId(Integer realMobileId) throws BusinessException;

    /**
     * 查询真机是否在调试状态，如果返回null,则真机不存在或者不在调试状态
     * @param realMoblieId
     * @return
     * @throws BusinessException
     */
    EtRealMobile realMobileIsInUse(Integer realMoblieId) throws BusinessException;

    /**
     * 根据调试id，查询真机ip地址
     * @param rmid
     * @return
     * @throws BusinessException
     */
    EtMobile queryIpByRealMobileId(Integer rmid) throws BusinessException;
}
