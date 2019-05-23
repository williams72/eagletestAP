package com.dilatoit.eagletest.service.impl;

import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtMobile;
import com.dilatoit.eagletest.service.MobileService;
import com.dilatoit.eagletest.util.NoUseClass;
import com.dilatoit.engine.MobileEngineManager;
import com.dilatoit.engine.dto.MobileDTO;
import com.dilatoit.engine.enums.EngineEnum;
import com.dilatoit.engine.enums.MobileOsEnum;
import com.dilatoit.engine.exception.EngineException;
import com.dilatoit.engine.exception.MobilePipeException;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by beishan on 2016/11/15.
 */
@Service("mobileService")
public class MobileServiceImpl extends BaseService<NoUseClass> implements MobileService {

    @Autowired
    MobileEngineManager mobileEngineManager;

    public Map queryMobiles() throws BusinessException {
        Map mobiles = new HashMap();
        String result = null;
        try{
            result = httpGetMobileInfo();
        }catch (EngineException ee){
            throw new BusinessException(ExceptionEnum.INNER_SERVER_ERROR);
        }

        Gson gson = new Gson();
        Map map = gson.fromJson(result, Map.class);
        List list = (List) map.get("mobile");
        System.out.println("jjj");
        return null;
    }

    @Override
    public EtMobile queryById(Integer mobileId) throws DataBaseException {
        return null;
    }

    public String httpRename(String serialNumber, String name) throws EngineException {
        try{
            return this.enginePipe.mobilePipe().rename(serialNumber, name);
        }catch (MobilePipeException e){
            throw new EngineException("mobile pipe has a exception");
        }
    }

    public String httpReboot(String serialNumber) throws EngineException{
        try{
            return this.enginePipe.mobilePipe().reboot(serialNumber);
        }catch (MobilePipeException e){
            throw new EngineException("mobile pipe has a exception");
        }
    }

    public String httpGetMobileInfo() throws EngineException{
        /*try{
            return this.enginePipe.mobilePipe().mobiles();
        }catch (MobilePipeException e){
            throw new EngineException("mobile pipe has a exception");
        }*/
        // TODO: 2017/6/16 [紧急]接口待修改
        return null;
    }

    @Override
    public String httphttpGetMobileInfoByOS(MobileOsEnum mobileOsEnum) throws EngineException {
        try{
            return this.enginePipe.mobilePipe().mobilesByOs(mobileOsEnum);
        }catch (MobilePipeException e){
            throw new EngineException("mobile pipe has a exception");
        }
    }
    public List<MobileDTO> httpGetMobileInfoByOS(EngineEnum engineEnum, MobileOsEnum mobileOsEnum) throws EngineException {
        try{
            return mobileEngineManager.getAllMobliesByEngineAndOS(engineEnum, mobileOsEnum);
            //return this.enginePipe.mobilePipe().mobilesByOs(mobileOsType);
        }catch (MobilePipeException e){
            throw new EngineException("mobile pipe has a exception");
        }
    }



    public String httpStopCurrentTask(String serialNumber, String taskId) throws EngineException {
        try{
            return this.enginePipe.mobilePipe().stopCurrentTask(serialNumber, taskId);
        }catch (MobilePipeException e){
            throw new EngineException("mobile pipe has a exception");
        }
    }

    public String httpStopAllTask(String serialNumber) throws EngineException {
        try{
            return this.enginePipe.mobilePipe().stopAllTask(serialNumber);
        }catch (MobilePipeException e){
            throw new EngineException("mobile pipe has a exception");
        }
    }
}
