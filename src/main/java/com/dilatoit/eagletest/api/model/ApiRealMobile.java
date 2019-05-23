package com.dilatoit.eagletest.api.model;

import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 * Created by beishan on 2017/3/30.
 */
public class ApiRealMobile {
    @Expose
    private Integer id;
    @Expose
    private String serialNumber;
    @Expose
    private Date beginTime;
    @Expose
    private String mobileName;
    @Expose
    private long remainTime; //剩余时间
    @Expose
    private String debugAddress; // 调试地址，主要用于打开调试的窗口

    public ApiRealMobile(Integer id, String serialNumber, Date beginTime, String mobileName) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.beginTime = beginTime;
        this.mobileName = mobileName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public long getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(long remainTime) {
        this.remainTime = remainTime;
    }

    public String getDebugAddress() {
        return debugAddress;
    }

    public void setDebugAddress(String debugAddress) {
        this.debugAddress = debugAddress;
    }
}
