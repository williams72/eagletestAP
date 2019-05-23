package com.dilatoit.eagletest.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by xueshan.wei on 3/29/2017.
 */
@Entity
@Table(name = "et_mobile")
public class EtMobile implements Serializable {
    private Integer id;
    private String serialNumber;
    private String macAddress;
    private String realIp;
    private String extra;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "serial_number", nullable = false)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Column(name = "mac_address", nullable = false)
    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    @Column(name = "real_ip", nullable = false)
    public String getRealIp() {
        return realIp;
    }

    public void setRealIp(String realIp) {
        this.realIp = realIp;
    }

    @Column(name = "extra", nullable = false)
    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "EtMobile{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", realIp='" + realIp + '\'' +
                ", extra='" + extra + '\'' +
                '}';
    }
}
