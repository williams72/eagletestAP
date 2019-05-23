package com.dilatoit.engine.engines.ete;

import java.util.Date;

/**
 * Created by beishan on 2017/5/28.
 */
public class EteMobileDTO {

    private long id;
    private String brand;
    private String model;
    private String serialno;
    private String resolution;
    private int os;
    private String osVersion;
    private int width;
    private int heigh;
    private int statusValue;
    private String statusName;
    private long updateTime;
    private String macAddress;
    private Date update;

    @Override
    public String toString() {
        return "MobileDTO{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", serialno='" + serialno + '\'' +
                ", resolution='" + resolution + '\'' +
                ", os=" + os +
                ", osVersion='" + osVersion + '\'' +
                ", width=" + width +
                ", heigh=" + heigh +
                ", statusValue=" + statusValue +
                ", statusName='" + statusName + '\'' +
                ", updateTime=" + updateTime +
                ", macAddress='" + macAddress + '\'' +
                '}';
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int getOs() {
        return os;
    }

    public void setOs(int os) {
        this.os = os;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigh() {
        return heigh;
    }

    public void setHeigh(int heigh) {
        this.heigh = heigh;
    }

    public int getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(int statusValue) {
        this.statusValue = statusValue;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }
}
