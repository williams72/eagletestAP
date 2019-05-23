package com.dilatoit.eagletest.api.model;

import com.dilatoit.eagletest.model.EtVersion;
import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 * Created by xueshan.wei on 3/9/2017.
 */
public class Version {
    //版本id
    @Expose
    private int vid;
    //项目id
    @Expose
    private int pid;
    //项目名称
    @Expose
    private String name;
    //版本状态
    @Expose
    private int status;
    //版本创建时间
    @Expose
    private Date time;

    public Version(){

    }
    public Version(EtVersion version){
        if(version != null) {
            this.vid = version.getId();
            this.pid = version.getEtProject().getId();
            this.name = version.getVersionName();
            this.status = version.getVersionStatus();
            this.time = version.getCreateTime();
        }
    }
    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
