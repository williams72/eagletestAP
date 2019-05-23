package com.dilatoit.engine.engines.mtc.data.task;

public class MtcMobile {
    private String brand;
    private String model;
    private String os;
    private String serialNumber;

    public MtcMobile(String brand, String model, String os, String serialNumber) {
        this.brand = brand;
        this.model = model;
        this.os = os;
        this.serialNumber = serialNumber;
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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}