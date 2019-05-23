package com.dilatoit.engine.engines.mtc.pipe;

import com.dilatoit.engine.exception.EngineConfigException;
import com.dilatoit.engine.pipes.*;
import com.dilatoit.engine.engines.mtc.config.MtcConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by xueshan.wei on 11/16/2016.
 */
@Component("mtcEnginePipe")
public class MtcEnginePipe implements EnginePipe {
    @Autowired
    private MtcConfig mtcConfig;
    @Autowired
    private MobilePipe mtcMobilePipe;
    @Autowired
    private RealMobilePipe mtcRealMobilePipe;
    @Autowired
    private CommonsPipe mtcCommonsPipe;
    @Autowired
    private TaskPipe mtcTaskPipe;

    public void reloadConfig() throws EngineConfigException {
        mtcConfig.reloadConfig();
    }

    public MobilePipe mobilePipe(){
        return mtcMobilePipe;
    }
    public RealMobilePipe realMobilePipe(){
        return mtcRealMobilePipe;
    }
    public CommonsPipe commonsPipe() {
        return mtcCommonsPipe;
    }
    public TaskPipe taskPipe() {
        return mtcTaskPipe;
    }
}
