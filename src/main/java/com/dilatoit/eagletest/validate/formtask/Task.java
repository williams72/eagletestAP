package com.dilatoit.eagletest.validate.formtask;

import com.google.gson.annotations.Expose;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
@ApiModel(value = "任务实体")
public class Task {
    @Expose
    private String taskName;
    private Integer taskOS;
    @ApiModelProperty(value = "运行包id",required = true,example = "37")
    private Integer appId;
    @ApiModelProperty(value = "运行包url",required = true,example = "http://10.0.40.49:8001/storage/download/apk/b33ade746094fd8d3ac9df02004281d2.apk")
    private String appUrl;

    // preTask
    @ApiModelProperty(value = "是否重启：0不重启；1重启",required = true,example = "0")
    private String isReboot;
    @ApiModelProperty(value = "是否开启弱网：0关闭；1开启",required = true,example = "0")
    private String isNetSimulation; //是否选择了弱网测试
    @ApiModelProperty(value = "弱网类型",required = true,example = "2G")
    private String netSimulationType; //选择的弱网类型
    @ApiModelProperty(value = "弱网参数",required = true,example = "data")
    private String netSimulationData;
    // testType
    @ApiModelProperty(value = "兼容测试 0: 未选中|1: 选中",required = true,example = "1")
    private String compatibilityTest;  // 0: 未选中 | 1: 选中
    @ApiModelProperty(value = "兼容测试时间|分钟",required = true,example = "5")
    private Integer compatibilityTime;
    @ApiModelProperty(value = "兼容测试类型|0:Monkey | 1:SmartMonkey",required = true,example = "0")
    private Integer compatibilityType; // 0: Monkey | 1: Smart Monkey

    @ApiModelProperty(value = "脚本测试 0: 未选中|1: 选中",required = true,example = "0")
    private String scriptTest;  // 0: 未选中 | 1: 选中
    @ApiModelProperty(value = "脚本测试类型|0:appium |1:robotium |2:uiautomator |3robotFramework",required = true,example = "0")
    private Integer scriptType; // 0: appium | 1: robotium | 2: uiautomator | 3：robotFramework
    @ApiModelProperty(value = "脚本地址：需要使用上传文件的API上传脚本，返回的URL",required = true,example = "http://10.0.40.229:80/storage/download/caseBank/ios_case_script")
    private String scriptUrl;
    @ApiModelProperty(value = "rf脚本参数",required = true, example = "pybot -b C:/Python27/Debug/debug.txt --test Add --test device  C:/Python27/Test/Test2/Demo2.txt")
    private String scriptCmd;

    @ApiModelProperty(value = "遍历测试 0: 未选中|1: 选中",required = true,example = "1")
    private String traversalTest;  // 0: 未选中 | 1: 选中
    @ApiModelProperty(value = "遍历测试时间|分钟",required = true,example = "5")
    private Integer traversalTime;


    @ApiModelProperty(value = "智能遍历 0: 未选中|1: 选中",required = true,example = "0")
    private String smartTraversalTest; // 0:未选中 | 1：选中

    //engine
    @ApiModelProperty(value = "引擎选择 0 ETE | 1 MTC",required = true,example = "1")
    private Integer engine;   // 0 ETE | 1 MTC



    //optInfo
    @ApiModelProperty(value = "高级设置",required = true,example = "user,123456")
    private String optInfo;

    //mobliles
    private List<Mobile> mobiles = new ArrayList<Mobile>();

    public Task(){
        compatibilityTest = "0";
        scriptTest = "0";
        traversalTest = "0";
        isReboot = "0";
        isNetSimulation = "0";
        smartTraversalTest = "0";
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getTaskOS() {
        return taskOS;
    }

    public void setTaskOS(Integer taskOS) {
        this.taskOS = taskOS;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public String getIsReboot() {
        return isReboot;
    }

    public void setIsReboot(String isReboot) {
        this.isReboot = isReboot;
    }

    public String getIsNetSimulation() {
        return isNetSimulation;
    }

    public void setIsNetSimulation(String isNetSimulation) {
        this.isNetSimulation = isNetSimulation;
    }

    public String getNetSimulationType() {
        return netSimulationType;
    }

    public void setNetSimulationType(String netSimulationType) {
        this.netSimulationType = netSimulationType;
    }

    public String getNetSimulationData() {
        return netSimulationData;
    }

    public void setNetSimulationData(String netSimulationData) {
        this.netSimulationData = netSimulationData;
    }


    public String getCompatibilityTest() {
        return compatibilityTest;
    }

    public void setCompatibilityTest(String compatibilityTest) {
        this.compatibilityTest = compatibilityTest;
    }

    public Integer getCompatibilityTime() {
        return compatibilityTime;
    }

    public void setCompatibilityTime(Integer compatibilityTime) {
        this.compatibilityTime = compatibilityTime;
    }

    public Integer getCompatibilityType() {
        return compatibilityType;
    }

    public void setCompatibilityType(Integer compatibilityType) {
        this.compatibilityType = compatibilityType;
    }

    public String getScriptTest() {
        return scriptTest;
    }

    public void setScriptTest(String scriptTest) {
        this.scriptTest = scriptTest;
    }

    public Integer getScriptType() {
        return scriptType;
    }

    public void setScriptType(Integer scriptType) {
        this.scriptType = scriptType;
    }

    public String getScriptUrl() {
        return scriptUrl;
    }

    public void setScriptUrl(String scriptUrl) {
        this.scriptUrl = scriptUrl;
    }

    public String getScriptCmd() {
        return scriptCmd;
    }

    public void setScriptCmd(String scriptCmd) {
        this.scriptCmd = scriptCmd;
    }

    public String getTraversalTest() {
        return traversalTest;
    }

    public void setTraversalTest(String traversalTest) {
        this.traversalTest = traversalTest;
    }

    public Integer getTraversalTime() {
        return traversalTime;
    }

    public void setTraversalTime(Integer traversalTime) {
        this.traversalTime = traversalTime;
    }

    public String getSmartTraversalTest() {
        return smartTraversalTest;
    }

    public void setSmartTraversalTest(String smartTraversalTest) {
        this.smartTraversalTest = smartTraversalTest;
    }

    public Integer getEngine() {
        return engine;
    }

    public void setEngine(Integer engine) {
        this.engine = engine;
    }

    public String getOptInfo() {
        return optInfo;
    }

    public void setOptInfo(String optInfo) {
        this.optInfo = optInfo;
    }

    public List<Mobile> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<Mobile> mobiles) {
        this.mobiles = mobiles;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", taskOS=" + taskOS +
                ", appId=" + appId +
                ", appUrl='" + appUrl + '\'' +
                ", isReboot='" + isReboot + '\'' +
                ", isNetSimulation='" + isNetSimulation + '\'' +
                ", netSimulationType='" + netSimulationType + '\'' +
                ", netSimulationData='" + netSimulationData + '\'' +
                ", compatibilityTest='" + compatibilityTest + '\'' +
                ", compatibilityTime=" + compatibilityTime +
                ", compatibilityType=" + compatibilityType +
                ", scriptTest='" + scriptTest + '\'' +
                ", scriptType=" + scriptType +
                ", scriptUrl='" + scriptUrl + '\'' +
                ", traversalTest='" + traversalTest + '\'' +
                ", traversalTime=" + traversalTime +
                ", smartTraversalTest='" + smartTraversalTest + '\'' +
                ", engine=" + engine +
                ", optInfo='" + optInfo + '\'' +
                ", mobiles=" + mobiles +
                '}';
    }
}
