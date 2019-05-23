package com.dilatoit.eagletest.model;

import javax.persistence.*;

/**
 * Created by xueshan.wei on 12/26/2016.
 */
@Entity
@Table(name = "et_system_config")
public class EtSystemConfig {
    private Integer id;
    private String configName;
    private String configValue;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "config_name", nullable = false)
    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    @Column(name = "config_value", nullable = false)
    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    @Override
    public String toString() {
        return "EtSystemConfig{" +
                "id=" + id +
                ", configName='" + configName + '\'' +
                ", configValue='" + configValue + '\'' +
                '}';
    }
}
