package com.dilatoit.eagletest.service.impl;


import com.dilatoit.commons.GsonUtils;
import com.dilatoit.eagletest.api.model.ApiRealMobile;
import com.dilatoit.eagletest.dto.NetSimulationDTO;
import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.enums.RealMobileStatus;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtMobile;
import com.dilatoit.eagletest.model.EtRealMobile;
import com.dilatoit.eagletest.model.EtUser;
import com.dilatoit.eagletest.model.EtWeaknet;
import com.dilatoit.eagletest.service.*;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;

import com.dilatoit.engine.engines.mtc.util.JsonTools;
import com.dilatoit.engine.enums.RealMobileTime;
import com.dilatoit.engine.exception.EngineException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by beishan on 2016/11/15.
 */
@Service("realMobileService")
public class RealMobileServiceImpl extends BaseService<EtRealMobile> implements RealMobileService {
    @Autowired
    private UserService userService;
    @Autowired
    private MobileService mobileService;
    @Autowired
    private WeaknetService weaknetService;

    @Resource(name = "egMobileService")
    private MobileService egMoblieSevice;

    @Resource(name = "netSimulationService")
    private NetSimulationService netSimulationService;

    @Override
    public NetSimulationDTO addNetSimulation(Integer rmId, Integer netSimulationId) throws BusinessException {
        EtRealMobile etRealMobile = realMobileIsInUse(rmId);
        EtWeaknet etWeaknet = null;
        if(etRealMobile == null){
            throw new BusinessException(ExceptionEnum.Mobile_NOT_EXIST);
        }
        try {
            etWeaknet = weaknetService.queryById(netSimulationId);
            if(etWeaknet == null){
                throw new BusinessException(ExceptionEnum.NET_SIMULATION_NOT_EXIST);
            }
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new BusinessException(e.getEe());
        }
        EtMobile etMobile = queryIpByRealMobileId(rmId);
        if (etMobile == null){
            throw new BusinessException(ExceptionEnum.Mobile_NOT_EXIST);
        }else {
            String param = etWeaknet.getParam().substring (1, etWeaknet.getParam().length() - 1);
            boolean end = false;
            end = netSimulationService.setNetSimulation(etMobile.getRealIp(), param);
            if(end){
                try {
                    etWeaknet.setId(netSimulationId);
                    etRealMobile.setNetSimulation(etWeaknet);
                    this.update(etRealMobile);
                }
                catch (DataBaseException e){
                    e.printStackTrace();
                    throw new BusinessException(e.getEe());
                }
            } else {
                throw new BusinessException(ExceptionEnum.NET_SIMULATION_FAIL);
            }
        }
        return null;
    }

    @Override
    public NetSimulationDTO deleteSimulation(Integer rmId) throws BusinessException {
        EtRealMobile etRealMobile = realMobileIsInUse(rmId);

        if(realMobileIsInUse(rmId) == null){
            throw new BusinessException(ExceptionEnum.Mobile_NOT_EXIST);
        }
        //获取设备IP
        EtMobile etMobile = queryIpByRealMobileId(rmId);
        if (etMobile == null){
            throw new BusinessException(ExceptionEnum.Mobile_NOT_EXIST);
        }else {
            boolean end = false;
            end = netSimulationService.removeNetSimulation(etMobile.getRealIp());
            if(end){
                try {
                    etRealMobile.setNetSimulation(null);
                    this.update(etRealMobile);
                }catch (DataBaseException e){
                    e.printStackTrace();
                    throw new BusinessException(e.getEe());
                }
            }else {
                throw new BusinessException(ExceptionEnum.NET_SIMULATION_FAIL);
            }
        }
        return null;
    }

    @Override
    public boolean clearNetAfterRemote(String rmIp) throws BusinessException {
        boolean removeEnd = netSimulationService.removeNetSimulation(rmIp);
        if(removeEnd){
            return true;
        }else {
            return false;
        }
    }


    //暂时无用
    @Override
    public NetSimulationDTO queryNetSimulation(Integer rmId) throws BusinessException {
        EtRealMobile etRealMobile = null;
        try{
            etRealMobile = queryById(rmId);
            if (etRealMobile == null){
                throw new BusinessException(ExceptionEnum.REALMOBILE_NOT_EXIST);
            }
        }catch (DataBaseException e){
            e.printStackTrace();
            throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
        if(etRealMobile.getStatus() != RealMobileStatus.UNDERWAY.value()){
            throw new BusinessException(ExceptionEnum.REALMOBILE_NOT_EXIST);
        }else {
            //获取设备IP
            EtMobile etMobile = null;
            try{
                etMobile = egMoblieSevice.queryByName("serialNumber", etRealMobile.getSerialNumber());
                if(etMobile == null){
                    throw new BusinessException(ExceptionEnum.Mobile_NOT_EXIST);
                }
            }catch (DataBaseException e){
                e.printStackTrace();
                throw new BusinessException(e.getEe());
            }
            boolean end = false;
            end = netSimulationService.queryNetSimulationStatus(etMobile.getRealIp());
            if(end){

            }else {
                throw new BusinessException(ExceptionEnum.NET_SIMULATION_FAIL);
            }
        }
        return null;
    }

    public void page(DataPage<EtRealMobile> page) throws DataBaseException {
        Conditions conditions = new Conditions();
        page(page, conditions);
    }

    public void page(DataPage<EtRealMobile> page, Conditions conditions) throws DataBaseException {
        baseDAO.page(page, com.dilatoit.eagletest.model.EtRealMobile.class, conditions);
    }

    public EtRealMobile queryById(Integer realMobileId) throws DataBaseException {
        return (EtRealMobile) this.baseDAO.queryById(com.dilatoit.eagletest.model.EtRealMobile.class, realMobileId);
    }

    public Integer save(EtRealMobile realMobile) throws DataBaseException {
        try {
            return this.baseDAO.save(realMobile);
        }catch (Exception e){
            e.printStackTrace();
            throw new DataBaseException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
    }

    public void delete(EtRealMobile realMobile) throws DataBaseException {
        try {
            this.baseDAO.delete(realMobile);
        }catch (Exception e){
            e.printStackTrace();
            throw new DataBaseException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
    }

    public void update(EtRealMobile realMobile) throws DataBaseException {
        try {
            this.baseDAO.update(realMobile);
        }catch (Exception e){
            e.printStackTrace();
            throw new DataBaseException(ExceptionEnum.DB_UPDATE_RESULT_ERROR);
        }
    }

    public List<EtRealMobile> queryByConditions(Conditions conditions) throws DataBaseException {
        return this.baseDAO.queryByConditions(com.dilatoit.eagletest.model.EtRealMobile.class, conditions);
    }

    public String realmobiles() throws EngineException {
        return this.enginePipe.realMobilePipe().realmobiles();
    }



    public Integer httpRentRealMobile(Integer userId, String serialNumber, String mobilename, RealMobileTime realMobileTime) throws DataBaseException, EngineException {
        String result = this.enginePipe.realMobilePipe().rent(serialNumber, realMobileTime);

        if("success".equals(result)){ // MTC申请调试成功
            Map map = JsonTools.toMap(this.enginePipe.realMobilePipe().realmobileinfo(serialNumber));
            String rdi = (String) map.get("realDeviceId");
            //得到当前用户
            EtUser currentUser = userService.queryUserById(userId);
            currentUser.setId(userId);

            //新建调试 记录
            EtRealMobile realMobile = new EtRealMobile();
            realMobile.setStatus(RealMobileStatus.UNDERWAY.value());
            realMobile.setBeginTime(new Date());
            realMobile.setEtUser(currentUser);
            realMobile.setMobileName(mobilename);
            realMobile.setSerialNumber(serialNumber);
            realMobile.setRealDevId(rdi);
            return this.save(realMobile);
        }
        return 0;
    }

    public ApiRealMobile queryRealMobileInfo(Integer rmid) throws BusinessException {
        String result = null;
        ApiRealMobile realMobile = null;
        try{
            result = httpGetRealMobileInfo(rmid);
        }catch (BusinessException be){
            if(be.getEe() == ExceptionEnum.NUll_OBJECT_ERROR){
                throw new BusinessException(ExceptionEnum.REALMOBILE_NOT_EXIST);
            }
        }
        //处理返回的结果
        if(result != null){
            Map map = GsonUtils.toMap(result);
            String rm_url = (String) map.get("url");
            Double rm_remaintime = (Double) map.get("remainTime");
            try {
                EtRealMobile etRealMobile = (EtRealMobile) this.baseDAO.queryById(EtRealMobile.class, rmid);
                realMobile = new ApiRealMobile(etRealMobile.getId(),
                        etRealMobile.getSerialNumber(),
                        etRealMobile.getBeginTime(),
                        etRealMobile.getMobileName());

                realMobile.setDebugAddress(rm_url);
                realMobile.setRemainTime(rm_remaintime.longValue());
            } catch (DataBaseException e) {
                e.printStackTrace();
                throw new BusinessException(e.getEe());
            }
        }else {
            throw new BusinessException(ExceptionEnum.NUll_OBJECT_ERROR);
        }

        return realMobile;
    }

    public String httpGetRealMobileInfo(Integer realMobileId) throws BusinessException {
        EtRealMobile rm = null;
        try {
            rm = (EtRealMobile)this.baseDAO.queryById(EtRealMobile.class, realMobileId);
            if(rm == null){
                //不存在该真机调试
                throw new BusinessException(ExceptionEnum.REALMOBILE_NOT_EXIST);
            }
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
        try{
            return this.enginePipe.realMobilePipe().realmobileinfo(rm.getSerialNumber());
        }catch (EngineException ee){
            //任务结束 更新调试状态
            try {
                updateRmStatus(rm.getId(), RealMobileStatus.STOPPED);
                //停止该机的网络模拟
                this.deleteSimulation(realMobileId);
            } catch (DataBaseException e) {
                e.printStackTrace();
                throw new BusinessException(ExceptionEnum.DB_UPDATE_RESULT_ERROR);
            }
            throw new BusinessException(ExceptionEnum.REALMOBILE_TIMEOUT);
        }

    }

    public String httpRenewalRealMobile(Integer realMobileId, Long time) throws EngineException, DataBaseException {
        try{
            EtRealMobile rm = queryById(realMobileId);
            String result = this.enginePipe.realMobilePipe().renewal(rm.getSerialNumber());
            return result;
        }catch (EngineException ee){
            throw new EngineException("[real mobile] 续借出错");
        }
    }

    public String httpStopRealMobile(Integer realMobileId) throws EngineException, DataBaseException,BusinessException {
        EtRealMobile rm = (EtRealMobile)this.baseDAO.queryById(com.dilatoit.eagletest.model.EtRealMobile.class, realMobileId);
        if(rm == null){
            throw new BusinessException(ExceptionEnum.REALMOBILE_NOT_EXIST);
        }
        //MTC 调用停止
        try{
            this.enginePipe.realMobilePipe().stop(rm.getRealDevId());
        }catch (EngineException ee){
            throw new EngineException("mtc 停止出错");
        }

        // 更新数据库状态
        rm.setStatus(RealMobileStatus.STOPPED.value());
        rm.setIs_abort(1);
        rm.setEndTime(new Date());
        rm.setDuration("");

        update(rm);
        return null;
    }

    public String httpStopAllRealmobile(String mobileId) throws BusinessException{

        try {

            String result = this.enginePipe.realMobilePipe().stopAll(mobileId);
            String serialno = mobileId;
            Conditions conditions = new Conditions();
            conditions.addCondition("serialNumber", serialno, Conditions.Operator.EQUAL);
            conditions.addCondition("status", RealMobileStatus.UNDERWAY.value(), Conditions.Operator.EQUAL);
            try {
                List<EtRealMobile> rms = queryByConditions(conditions);
                if(rms != null && rms.size() > 0){
                    EtRealMobile rm = rms.get(0);
                    rm.setStatus(RealMobileStatus.STOPPED.value());
                    update(rm);
                }else {
                    throw new BusinessException(ExceptionEnum.REALMOBILE_NOT_EXIST);
                }
            } catch (DataBaseException e) {
                e.printStackTrace();
                throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
            }
            return result;
        } catch (EngineException e) {
            e.printStackTrace();
            throw new BusinessException(e.getEe());
        }
    }

    public List<EtRealMobile> currentRealMobiles(Integer userId) throws EngineException, DataBaseException {
        Conditions conditions = new Conditions();
        conditions.addCondition("etUser.id", userId, Conditions.Operator.EQUAL);
        conditions.addCondition("status", RealMobileStatus.UNDERWAY.value(), Conditions.Operator.EQUAL);

        List<EtRealMobile> list = queryByConditions(conditions);
        //同步并筛选出可用的调试列表
        list = synoRealMobileStatus(list);
        /*String results = mobileService.httpGetMobileInfoByOS(MobileOsType.ANDROID);
        Map result = JsonTools.toMap(results);
        List mobiles = (List)result.get("mobile");
        for(int i = 0; i < mobiles.size(); i++){
        }*/
        return list;
    }

    public List<EtRealMobile> synoRealMobileStatus(List<EtRealMobile> rms) throws EngineException, DataBaseException {
        List<EtRealMobile> usableRMS = new ArrayList<EtRealMobile>();
        if(rms != null && rms.size() > 0){
            for(EtRealMobile rm : rms){
                //1、 判断该任务是否已结束（MTC）
                if(!isUsableRm(rm.getId())){
                    //任务结束， 更新任务状态
                    updateRmStatus(rm.getId(), RealMobileStatus.STOPPED);
                }else{
                    //加入可用列表
                    usableRMS.add(rm);
                }
            }
        }
        return usableRMS;
    }

    public void updateRmStatus(Integer realmobileId, RealMobileStatus realMobileStatus) throws DataBaseException {
        EtRealMobile rm = (EtRealMobile) this.baseDAO.queryById(com.dilatoit.eagletest.model.EtRealMobile.class, realmobileId);
        rm.setStatus(realMobileStatus.STOPPED.value());
        update(rm);
    }

    public boolean isUsableRm(Integer realMobileId) throws EngineException, DataBaseException {
        try{
            EtRealMobile rm = (EtRealMobile) this.baseDAO.queryById(com.dilatoit.eagletest.model.EtRealMobile.class, realMobileId);
            this.enginePipe.realMobilePipe().realmobileinfo(rm.getSerialNumber());
            //不抛出异常返回true
            return true;
        }catch (EngineException ee){
            ee.printStackTrace();
        }
        //抛出异常直接返回false
        return false;
    }

    public void synoRealDevId(Integer realMobileId) throws BusinessException {
        Map map = null;
        map = JsonTools.toMap(httpGetRealMobileInfo(realMobileId));
        String rdi = (String) map.get("realDeviceId");
        EtRealMobile rm = null;
        try {
            rm = (EtRealMobile) this.baseDAO.queryById(EtRealMobile.class, realMobileId);
            rm.setRealDevId(rdi);
            update(rm);
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }

    }

    @Override
    public EtRealMobile realMobileIsInUse(Integer realMoblieId) throws BusinessException {
        EtRealMobile etRealMobile = null;
        try {
            etRealMobile = queryById(realMoblieId);
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new BusinessException(e.getEe());
        }
        if(etRealMobile != null && etRealMobile.getStatus() != RealMobileStatus.UNDERWAY.value()){
            return null;
        }
        return etRealMobile;
    }

    @Override
    public EtMobile queryIpByRealMobileId(Integer rmid) throws BusinessException {
        EtRealMobile etRealMobile = null;
        try {
            etRealMobile = queryById(rmid);
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new BusinessException(e.getEe());
        }
        EtMobile etMobile = null;
        try{
            etMobile = egMoblieSevice.queryByName("serialNumber", etRealMobile.getSerialNumber());
            if(etMobile == null){
                return null;
            }
        }catch (DataBaseException e){
            e.printStackTrace();
            throw new BusinessException(e.getEe());
        }
        return etMobile;
    }

}
