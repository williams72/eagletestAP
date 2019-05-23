package com.dilatoit.engine.engines.ete.pipe;

import com.dilatoit.engine.engines.ete.EteEngineConfig;
import com.dilatoit.engine.exception.EngineConfigException;
import com.dilatoit.engine.pipes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by xueshan.wei on 6/15/2017.
 */
@Component
public class EteEngine implements EnginePipe{
    @Autowired
    private EteEngineConfig eteEngineConfig;
    @Autowired
    private EteMobilePipe eteMobilePipe;
    @Autowired
    private EteTaskPipe eteTaskPipe;

    @Override
    public void reloadConfig() throws EngineConfigException {
        eteEngineConfig.reloadConfig();
    }

    @Override
    public MobilePipe mobilePipe() {
        return eteMobilePipe;
    }

    @Override
    public RealMobilePipe realMobilePipe() {
        return null;
    }

    @Override
    public CommonsPipe commonsPipe() {
        return null;
    }

    @Override
    public TaskPipe taskPipe() {
        return eteTaskPipe;
    }
}
