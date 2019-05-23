package com.dilatoit.engine.engines.mtc.data;

import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.engine.enums.EngineEnum;
import com.dilatoit.engine.exception.EngineException;

/**
 * Created by xueshan.wei on 6/15/2017.
 */
public enum ScriptFrameTypeEnum {
    APPIUM("appium", 0),
    ROBOTIUM("robotium", 1),
    UIAUTOMATOR("uiautomator", 2),
    ROBOTFRAMEWORK("robotFramework", 3)
    ;
    private String name;
    private int value;

    ScriptFrameTypeEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }
    public int value(){
        return value;
    }
    public String getName(){
        return name;
    }

    public static String indexName(int value) throws EngineException{
        if(value == APPIUM.value()){
            return APPIUM.getName();
        }else if(value == ROBOTIUM.value()){
            return ROBOTIUM.getName();
        }else if(value == UIAUTOMATOR.value()){
            return UIAUTOMATOR.getName();
        }else if(value == ROBOTFRAMEWORK.value()){
            return ROBOTFRAMEWORK.getName();
        }else {
            throw new EngineException("测试类型转换错误");
        }
    }
}
