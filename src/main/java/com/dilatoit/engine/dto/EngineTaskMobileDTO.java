package com.dilatoit.engine.dto;

/**
 * Created by xueshan.wei on 6/15/2017.
 */
public class EngineTaskMobileDTO {
    private String serialno;
    private String brand;
    private String model;
    private String os;
    private String ip;

    @Override
    public String toString() {
        return "EngineTaskMobileDTO{" +
                "serialno='" + serialno + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", os='" + os + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
