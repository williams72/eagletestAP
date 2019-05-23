package com.dilatoit.eagletest.service.impl;

import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtMobile;
import com.dilatoit.eagletest.service.MobileService;
import com.dilatoit.engine.dto.MobileDTO;
import com.dilatoit.engine.enums.EngineEnum;
import com.dilatoit.engine.enums.MobileOsEnum;
import com.dilatoit.engine.exception.EngineException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by xueshan.wei on 4/14/2017.
 */
@Service("egMobileService")
public class EgMobileService extends BaseService<EtMobile> implements MobileService {

    @Override
    public EtMobile queryByName(String queryName, String value) throws DataBaseException {
            return (EtMobile) baseDAO.queryByName(com.dilatoit.eagletest.model.EtMobile.class, queryName, value);
    }

    @Override
    public EtMobile queryById(Integer mobileId) throws DataBaseException {
        return (EtMobile)this.baseDAO.queryById(com.dilatoit.eagletest.model.EtMobile.class, mobileId);
    }

    @Override
    public List<EtMobile> queryMobilesNew()  throws DataBaseException {
        return baseDAO.queryAll(com.dilatoit.eagletest.model.EtMobile.class);
    }

    public Map queryMobiles() throws BusinessException {
        return null;
    }

    public String httpRename(String serialNumber, String name) throws EngineException {
        return null;
    }

    public String httpReboot(String serialNumber) throws EngineException {
        return null;
    }

    public String httpGetMobileInfo() throws EngineException {
        return null;
    }

    @Override
    public String httphttpGetMobileInfoByOS(MobileOsEnum mobileOsEnum) throws EngineException {
        return null;
    }

    @Override
    public List<MobileDTO> httpGetMobileInfoByOS(EngineEnum engineEnum, MobileOsEnum mobileOsEnum) throws EngineException {
        return null;
    }

    public String httpGetMobileInfoByOS(MobileOsEnum mobileOsType) throws EngineException {
        return null;
    }

    public String httpStopCurrentTask(String serialNumber, String taskId) throws EngineException {
        return null;
    }

    public String httpStopAllTask(String serialNumber) throws EngineException {
        return null;
    }
}
