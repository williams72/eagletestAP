package com.dilatoit.eagletest.validate.formtask;

import com.google.gson.annotations.Expose;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by xueshan.wei on 3/28/2017.
 */
public class Mobile {
    //设备名
    @Expose
    @ApiModelProperty(value = "设备名",required = true,example = "HUAWEI MT7-CL00")
    private String name;
    // 品牌
    @Expose
    @ApiModelProperty(value = "设备品牌",required = true,example = "Huawei")
    private String brand;
    // 型号
    @Expose
    @ApiModelProperty(value = "设备型号",required = true,example = "HUAWEI MT7-CL00")
    private String model;
    // 系统版本
    @Expose
    @ApiModelProperty(value = "系统版本",required = true,example = "android 6.0")
    private String os;
    //serial number
    @Expose
    @ApiModelProperty(value = "设备sn",required = true,example = "G2W7N15120024967")
    private String sn;
    @Expose
    @ApiModelProperty(value = "设备ip",required = true,example = "192.168.0.102")
    private String ip;

    public Mobile(){

    }

    @Override
    public String toString() {
        return "Mobile{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", os='" + os + '\'' +
                ", sn='" + sn + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }

    public Mobile(String name, String brand, String model, String os, String sn) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.os = os;
        this.sn = sn;
    }
    public Mobile(String name, String brand, String model, String os, String sn, String ip) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.os = os;
        this.sn = sn;
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
