package com.dilatoit.eagletest.dto;

import com.google.gson.annotations.Expose;

/**
 * Created by xueshan.wei on 4/19/2017.
 */
public class WeaknetDTO {
    @Expose
    private Integer id;
    @Expose
    private String name;
    @Expose
    private String param;
    @Expose
    private String desc;

    private String key;
    @Expose
    private boolean sysdefault;
    @Expose
    private boolean enable;
    @Expose
    private long lastModifyTime;
    @Expose
    private long createTime;

    @Override
    public String toString() {
        return "WeaknetDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", param='" + param + '\'' +
                ", desc='" + desc + '\'' +
                ", key='" + key + '\'' +
                ", sysdefault=" + sysdefault +
                ", enable=" + enable +
                ", lastModifyTime=" + lastModifyTime +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public long getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(long lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isSysdefault() {
        return sysdefault;
    }

    public void setSysdefault(boolean sysdefault) {
        this.sysdefault = sysdefault;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
