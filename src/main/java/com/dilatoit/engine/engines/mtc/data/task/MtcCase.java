package com.dilatoit.engine.engines.mtc.data.task;

import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.engine.engines.mtc.data.ScriptFrameTypeEnum;
import com.dilatoit.engine.exception.EngineException;
import com.google.gson.annotations.SerializedName;

/**
 * Created by xueshan.wei on 4/1/2017.
 */
public class MtcCase {
    @SerializedName("appium")
    private MtcCaseType appium;
    @SerializedName("robotium")
    private MtcCaseType robotium;
    @SerializedName("uiautomator")
    private MtcCaseType uiautomator;
    @SerializedName("robotFramework")
    private MtcCaseType robotFramework;

    public MtcCase(String typeName, MtcCaseType type) throws EngineException{
        if(ScriptFrameTypeEnum.APPIUM.getName().equals(typeName)){
            appium = type;
        }else if(ScriptFrameTypeEnum.ROBOTIUM.getName().equals(typeName)){
            robotium = type;
        }else if(ScriptFrameTypeEnum.UIAUTOMATOR.getName().equals(typeName)){
            uiautomator = type;
        }else if(ScriptFrameTypeEnum.ROBOTFRAMEWORK.getName().equals(typeName)){
            robotFramework = type;
        }else{
            throw new EngineException(ExceptionEnum.ENGINE_TASK_CONVERSION_ERROR);
        }
    }

    public MtcCaseType getAppium() {
        return appium;
    }

    public void setAppium(MtcCaseType appium) {
        this.appium = appium;
    }

    public MtcCaseType getRobotium() {
        return robotium;
    }

    public void setRobotium(MtcCaseType robotium) {
        this.robotium = robotium;
    }

    public MtcCaseType getUiautomator() {
        return uiautomator;
    }

    public void setUiautomator(MtcCaseType uiautomator) {
        this.uiautomator = uiautomator;
    }

    public MtcCaseType getRobotFramework() {
        return robotFramework;
    }

    public void setRobotFramework(MtcCaseType robotFramework) {
        this.robotFramework = robotFramework;
    }
}
