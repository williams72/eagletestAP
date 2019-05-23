package com.dilatoit.eagletest.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by beishan on 2016/11/15.
 */
@Entity
@Table(name = "et_realmobile")
public class EtRealMobile {
    //Fields

    private Integer id;
    private String serialNumber;
    private Date beginTime;
    private Date endTime;
    private String duration; //endtime - begintime millis
    private Integer status;
    private EtUser etUser;
    private Integer is_terminated;
    private String terminatedInfo;
    private Integer is_abort;
    private String abortInfo;
    private String realDevId;

    private String mobileName;
    private EtWeaknet netSimulation;

    public EtRealMobile() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "serial_number", length = 50, nullable = false)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Column(name = "begin_time", nullable = false)
    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    @Column(name = "end_time")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Column(name = "duration", length = 50)
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    @Column(name = "status", nullable = false)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    public EtUser getEtUser() {
        return etUser;
    }

    public void setEtUser(EtUser etUser) {
        this.etUser = etUser;
    }

    @Column(name = "is_terminated")
    public Integer getIs_terminated() {
        return is_terminated;
    }

    public void setIs_terminated(Integer is_terminated) {
        this.is_terminated = is_terminated;
    }
    @Column(name = "terminated_info")
    public String getTerminatedInfo() {
        return terminatedInfo;
    }

    public void setTerminatedInfo(String terminatedInfo) {
        this.terminatedInfo = terminatedInfo;
    }
    @Column(name = "is_abort")
    public Integer getIs_abort() {
        return is_abort;
    }

    public void setIs_abort(Integer is_abort) {
        this.is_abort = is_abort;
    }
    @Column(name = "abort_info")
    public String getAbortInfo() {
        return abortInfo;
    }

    public void setAbortInfo(String abortInfo) {
        this.abortInfo = abortInfo;
    }

    @Column(name = "real_dev_id")
    public String getRealDevId() {
        return realDevId;
    }

    public void setRealDevId(String realDevId) {
        this.realDevId = realDevId;
    }

    @Column(name = "mobile_name")
    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "net_simulation_id")
    public EtWeaknet getNetSimulation() {
        return netSimulation;
    }

    public void setNetSimulation(EtWeaknet netSimulation) {
        this.netSimulation = netSimulation;
    }

    @Override
    public String toString() {
        return "EtRealMobile{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", duration='" + duration + '\'' +
                ", status=" + status +
                ", etUser=" + etUser +
                ", is_terminated=" + is_terminated +
                ", terminatedInfo='" + terminatedInfo + '\'' +
                ", is_abort=" + is_abort +
                ", abortInfo='" + abortInfo + '\'' +
                ", realDevId='" + realDevId + '\'' +
                ", mobileName='" + mobileName + '\'' +
                ", NetSimulation=" + netSimulation +
                '}';
    }
}
