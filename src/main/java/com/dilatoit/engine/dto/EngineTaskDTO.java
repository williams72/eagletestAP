package com.dilatoit.engine.dto;

import java.util.List;

/**
 * Created by xueshan.wei on 6/15/2017.
 */
public class EngineTaskDTO {
    // 选择的引擎
    private int engine;
    //任务基础信息
    private String taskName;
    private String appUrl;
    //任务设备类型 0 android | 1 ios
    private int osType;

    //pre job
    private boolean reboot;

    private boolean netsimulation;
    private String netsimulationData;

    //任务类型
    //兼容
    private boolean compatibility;
    private int compatibilityTime;
    //monkey 测试类型 0 monkey | 1 smart monkey
    private int compatibilityType;

    //脚本
    private boolean script;
    private String scriptUrl;
    //脚本测试框架类型， 0 appium | 1 robotium | 2 uiautomator | 3 robotFramework
    private int scriptType;
    //rf脚本命令
    private String scriptCmd;

    //遍历
    private boolean traversal;
    private int traversalTime;

    //智能遍历
    private boolean smartTraversal;

    //高级设置
    private String optInfo;

    List<EngineTaskMobileDTO> mobiles;

    public int getScriptType() {
        return scriptType;
    }

    public void setScriptType(int scriptType) {
        this.scriptType = scriptType;
    }

    public String getScriptCmd() {
        return scriptCmd;
    }

    public void setScriptCmd(String scriptCmd) {
        this.scriptCmd = scriptCmd;
    }

    public boolean isPrejob(){
        return isReboot() || isNetsimulation();
    }
    public String getNetsimulationData() {
        return netsimulationData;
    }

    public void setNetsimulationData(String netsimulationData) {
        this.netsimulationData = netsimulationData;
    }

    public boolean isNetsimulation() {
        return netsimulation;
    }

    public void setNetsimulation(boolean netsimulation) {
        this.netsimulation = netsimulation;
    }

    public int getCompatibilityType() {
        return compatibilityType;
    }

    public void setCompatibilityType(int compatibilityType) {
        this.compatibilityType = compatibilityType;
    }

    public int getOsType() {
        return osType;
    }

    public void setOsType(int osType) {
        this.osType = osType;
    }

    public int getEngine() {
        return engine;
    }

    public void setEngine(int engine) {
        this.engine = engine;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public boolean isReboot() {
        return reboot;
    }

    public void setReboot(boolean reboot) {
        this.reboot = reboot;
    }

    public boolean isCompatibility() {
        return compatibility;
    }

    public void setCompatibility(boolean compatibility) {
        this.compatibility = compatibility;
    }

    public int getCompatibilityTime() {
        return compatibilityTime;
    }

    public void setCompatibilityTime(int compatibilityTime) {
        this.compatibilityTime = compatibilityTime;
    }

    public boolean isScript() {
        return script;
    }

    public void setScript(boolean script) {
        this.script = script;
    }

    public String getScriptUrl() {
        return scriptUrl;
    }

    public void setScriptUrl(String scriptUrl) {
        this.scriptUrl = scriptUrl;
    }

    public boolean isTraversal() {
        return traversal;
    }

    public void setTraversal(boolean traversal) {
        this.traversal = traversal;
    }

    public int getTraversalTime() {
        return traversalTime;
    }

    public void setTraversalTime(int traversalTime) {
        this.traversalTime = traversalTime;
    }

    public boolean isSmartTraversal() {
        return smartTraversal;
    }

    public void setSmartTraversal(boolean smartTraversal) {
        this.smartTraversal = smartTraversal;
    }

    public String getOptInfo() {
        return optInfo;
    }

    public void setOptInfo(String optInfo) {
        this.optInfo = optInfo;
    }

    public List<EngineTaskMobileDTO> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<EngineTaskMobileDTO> mobiles) {
        this.mobiles = mobiles;
    }
}
