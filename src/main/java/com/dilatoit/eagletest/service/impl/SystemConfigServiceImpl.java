package com.dilatoit.eagletest.service.impl;

import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtSystemConfig;
import com.dilatoit.eagletest.service.SystemConfigService;
import com.dilatoit.eagletest.util.Conditions;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xueshan.wei on 12/26/2016.
 */
@Service(value = "systemConfig")
public class SystemConfigServiceImpl extends BaseService<EtSystemConfig> implements SystemConfigService {
    public EtSystemConfig getSystemConfig(String configName) throws DataBaseException {
        Conditions conditions = new Conditions();
        conditions.addCondition("config_name", configName, Conditions.Operator.EQUAL);
        return queryByConditions(conditions);
    }

    public void updateSystemConfig(String configName, String configValue) throws DataBaseException {
        Conditions conditions = new Conditions();
        conditions.addCondition("config_name", configName, Conditions.Operator.EQUAL);
        EtSystemConfig systemConfig = queryByConditions(conditions);
        systemConfig.setConfigValue(configValue);
        this.baseDAO.update(systemConfig);
    }

    public EtSystemConfig queryByConditions(Conditions conditions) throws DataBaseException {
        List<EtSystemConfig> list = this.baseDAO.queryByConditions(com.dilatoit.eagletest.model.EtSystemConfig.class, conditions);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }
}
