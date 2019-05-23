package com.dilatoit.eagletest.dto;

import com.dilatoit.eagletest.model.EtVersion;
import com.google.gson.annotations.Expose;

/**
 * Created by Salt on 2017/7/20.
 */
public class AppDTO {
    @Expose
    private Integer id;
    @Expose
    private String appName;
    @Expose
    private String appRealName;
    @Expose
    private Integer visibility;
    @Expose
    private String appUrl;

    @Override
    public String toString() {
        return "AppDTO{" +
                "id=" + id +
                ", appName='" + appName + '\'' +
                ", appRealName='" + appRealName + '\'' +
                ", visibility=" + visibility +
                ", appUrl='" + appUrl + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppRealName() {
        return appRealName;
    }

    public void setAppRealName(String appRealName) {
        this.appRealName = appRealName;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }
}
