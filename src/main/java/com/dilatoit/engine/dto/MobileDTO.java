package com.dilatoit.engine.dto;

import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 * Created by xueshan.wei on 4/10/2017.
 */
public class MobileDTO {
    //设备信息所在的引擎 (0 mtc | 1 ete)
    @Expose
    private int engine;
    //设备名称（自定义名称）
    @Expose
    private String name;
    //设备类型（0 Android 或者 1 IOS）
    @Expose
    private Integer mobileType;
    //设备序列号
    @Expose
    private String serialno;
    //设备Mac地址
    @Expose
    private String macAddress;
    //设备工作IP
    @Expose
    private String workIp;
    //设备品牌
    @Expose
    private String brand;
    //设备型号
    @Expose
    private String model;
    //设备系统
    @Expose
    private String os;
    //设备SDK版本号（IOS没有为空）
    @Expose
    private String sdkVersion;
    //屏幕分辨率宽度
    @Expose
    private String width;
    //屏幕分辨率高度
    @Expose
    private String height;
    //sim 卡状态
    @Expose
    private Integer simStatus;
    //电池状态
    @Expose
    private Integer batteryLevel;
    //设备状态 （0 在线 | 1 离线 | 2 不在线 | 3 在线但是处于未认证状态）
    //这里ete 的设备状态值和 eagletest 的状态值一致
    @Expose
    private int status;
    //设备在线状态，忙碌（任务中，调试中等） | 空闲
    @Expose
    private boolean busy;
    //设备截图地址
    @Expose
    private String screenshotUrl;
    //设备重启状态
    @Expose
    private Integer rebootStatus;
    //设备信息最后更新时间
    @Expose
    private Date updatedTime;
    //附加信息
    @Expose
    private String extraInfo;

    @Override
    public String toString() {
        return "MobileDTO{" +
                "engine=" + engine +
                ", name='" + name + '\'' +
                ", mobileType=" + mobileType +
                ", serialno='" + serialno + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", workIp='" + workIp + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", os='" + os + '\'' +
                ", sdkVersion='" + sdkVersion + '\'' +
                ", width='" + width + '\'' +
                ", height='" + height + '\'' +
                ", simStatus=" + simStatus +
                ", batteryLevel=" + batteryLevel +
                ", status=" + status +
                ", busy=" + busy +
                ", screenshotUrl='" + screenshotUrl + '\'' +
                ", rebootStatus=" + rebootStatus +
                ", updatedTime=" + updatedTime +
                ", extraInfo='" + extraInfo + '\'' +
                '}';
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public int getEngine() {
        return engine;
    }

    public void setEngine(int engine) {
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMobileType() {
        return mobileType;
    }

    public void setMobileType(Integer mobileType) {
        this.mobileType = mobileType;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getWorkIp() {
        return workIp;
    }

    public void setWorkIp(String workIp) {
        this.workIp = workIp;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Integer getSimStatus() {
        return simStatus;
    }

    public void setSimStatus(Integer simStatus) {
        this.simStatus = simStatus;
    }

    public Integer getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(Integer batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getScreenshotUrl() {
        return screenshotUrl;
    }

    public void setScreenshotUrl(String screenshotUrl) {
        this.screenshotUrl = screenshotUrl;
    }

    public Integer getRebootStatus() {
        return rebootStatus;
    }

    public void setRebootStatus(Integer rebootStatus) {
        this.rebootStatus = rebootStatus;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
}
