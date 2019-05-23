package com.dilatoit.eagletest.model;

import com.google.gson.annotations.Expose;
import io.swagger.models.auth.In;

import javax.persistence.*;

/**
 * Created by Salt on 2017/10/29.
 */

@Entity
public class EtPyLibLog {
    @Expose
    private Integer id;

    @Expose
    private String name;

    @Expose
    private Integer type;

    @Expose
    private String cmd;

    @Expose
    private Integer cmdId;

    @Expose
    private EtUser etUser;

    @Expose
    private Integer status;

    @Expose
    private String createTime;

    @Expose
    private String modifyTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "type", nullable = false)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column(name = "cmd")
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    @Column(name = "cmd_id", nullable = false)
    public Integer getCmdId() {
        return cmdId;
    }

    public void setCmdId(Integer cmdId) {
        this.cmdId = cmdId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    public EtUser getEtUser() {
        return etUser;
    }

    public void setEtUser(EtUser etUser) {
        this.etUser = etUser;
    }

    @Column(name = "status", nullable = false)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "create_time", nullable = false)
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Column(name = "modify_time", nullable = false)
    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
}
