package com.dilatoit.eagletest.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by xueshan.wei on 4/14/2017.
 */
@Entity
@Table(name = "et_net_simulation")
public class EtWeaknet {

    private Integer id;
    private String name;
    private String key;
    private String param;
    private String desc;
    private Integer enable;
    private Date modifyTime;
    private Date createTime;
    private Integer systemDefault;

    @Override
    public String toString() {
        return "EtWeaknet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", param='" + param + '\'' +
                ", desc='" + desc + '\'' +
                ", enable=" + enable +
                ", modifyTime=" + modifyTime +
                ", createTime=" + createTime +
                ", systemDefault=" + systemDefault +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "short_key", nullable = false)
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Column(name = "param", nullable = false)
    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    @Column(name = "description")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    @Column(name = "enable", nullable = false)
    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    @Column(name = "modify_time")
    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
    @Column(name = "create_time", nullable = false)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "is_default", nullable = false)
    public Integer getSystemDefault() {
        return systemDefault;
    }

    public void setSystemDefault(Integer systemDefault) {
        this.systemDefault = systemDefault;
    }
}
