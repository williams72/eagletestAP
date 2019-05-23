package com.dilatoit.eagletest.service.impl;

import com.dilatoit.eagletest.service.NetSimulationService;
import com.dilatoit.eagletest.util.NoUseClass;
import com.dilatoit.netsimulation.service.NetSimulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Salt on 2017/5/22.
 */
@Service("netSimulationService")
public class NetSimulationServiceImpl extends BaseService<NoUseClass> implements NetSimulationService {
    @Autowired
    NetSimulation netSimulation;
    @Override
    public boolean setNetSimulation(String deviceIp, String param) {
        return netSimulation.setNetSimulation(deviceIp, param);
    }

    @Override
    public boolean removeNetSimulation(String deviceIp) {
        return netSimulation.removeNetSimulation(deviceIp);
    }

    @Override
    public boolean queryNetSimulationStatus(String deviceIp) {
        return netSimulation.checkIsInNetSimulation(deviceIp);
    }
}
