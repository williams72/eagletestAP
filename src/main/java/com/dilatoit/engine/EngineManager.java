package com.dilatoit.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by xueshan.wei on 6/14/2017.
 */
@Component
public class EngineManager {
    @Autowired
    private MobileEngineManager mobileEngineManager;
    @Autowired
    private TaskEngineManager taskEngineManager;

    public TaskEngineManager getTaskEngineManager() {
        return taskEngineManager;
    }

    public MobileEngineManager getMobileEngineManager() {
        return mobileEngineManager;
    }
}
