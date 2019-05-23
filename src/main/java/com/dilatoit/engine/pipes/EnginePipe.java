package com.dilatoit.engine.pipes;

import com.dilatoit.engine.exception.EngineConfigException;

/**
 * Created by xueshan.wei on 11/16/2016.
 */
public interface EnginePipe {

    void reloadConfig() throws EngineConfigException;

    MobilePipe mobilePipe();

    RealMobilePipe realMobilePipe();

    CommonsPipe commonsPipe();

    TaskPipe taskPipe();
}
