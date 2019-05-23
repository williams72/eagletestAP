package com.dilatoit.eagletest.service;

import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtSystemConfig;
import com.dilatoit.eagletest.util.Conditions;

/**
 * Created by xueshan.wei on 12/26/2016.
 */
public interface SystemConfigService {
    EtSystemConfig getSystemConfig(String configName) throws DataBaseException;

    void updateSystemConfig(String configName, String configValue) throws DataBaseException;

    EtSystemConfig queryByConditions(Conditions conditions) throws DataBaseException;
}
