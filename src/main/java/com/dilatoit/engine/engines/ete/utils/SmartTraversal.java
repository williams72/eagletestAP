package com.dilatoit.engine.engines.ete.utils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by xueshan.wei on 5/17/2017.
 */
public class SmartTraversal {
    private long id;
    private String param;
    private String appUrl;
    private String serialno;
    private String stkey;
    private int result;
    private Date createTime;
    private Date lastModifyTime;
    private Date beginTime;
    private Date endTime;
    private int status;
    private String resultLog;
    private String resultPath;

    @Override
    public String toString() {
        return "SmartTraversal{" +
                "id=" + id +
                ", param='" + param + '\'' +
                ", appUrl='" + appUrl + '\'' +
                ", serialno='" + serialno + '\'' +
                ", stkey='" + stkey + '\'' +
                ", result=" + result +
                ", createTime=" + createTime +
                ", lastModifyTime=" + lastModifyTime +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", status=" + status +
                ", resultLog='" + resultLog + '\'' +
                ", resultPath='" + resultPath + '\'' +
                '}';
    }

    public String getResultPath() {
        return resultPath;
    }

    public void setResultPath(String resultPath) {
        this.resultPath = resultPath;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getResultLog() {
        return resultLog;
    }

    public void setResultLog(String resultLog) {
        this.resultLog = resultLog;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getStkey() {
        return stkey;
    }

    public void setStkey(String stkey) {
        this.stkey = stkey;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}
