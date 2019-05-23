package com.dilatoit.eagletest.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by xueshan.wei on 5/18/2017.
 */
@Entity
@Table(name = "et_smarttraversal_task")
public class EtSmartTraversalTask {

    private Integer id;
    private EtTask task;
    private String serialno;
    private long eteJobId;
    private Integer result;
    private Integer status;
    private String report;
    private String appUrl;
    private Date createTime;
    private Date lastModifyTime;
    private Date begTime;
    private Date endTime;

    private String brand;
    private String model;
    private String os;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    public EtTask getTask() {
        return task;
    }

    public void setTask(EtTask task) {
        this.task = task;
    }

    @Column(name = "serialno", nullable = false)
    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }
    @Column(name = "ete_job_id", nullable = false)
    public long getEteJobId() {
        return eteJobId;
    }

    public void setEteJobId(long eteJobId) {
        this.eteJobId = eteJobId;
    }
    @Column(name = "result")
    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    @Column(name = "report")
    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }
    @Column(name = "app_url")
    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }
    @Column(name = "create_time", nullable = false)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Column(name = "last_modify_time")
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
    @Column(name = "begin_time")
    public Date getBegTime() {
        return begTime;
    }

    public void setBegTime(Date begTime) {
        this.begTime = begTime;
    }
    @Column(name = "end_time")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "os")
    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return "EtSmartTraversalTask{" +
                "id=" + id +
                ", task=" + task +
                ", serialno='" + serialno + '\'' +
                ", eteJobId=" + eteJobId +
                ", result=" + result +
                ", status=" + status +
                ", report='" + report + '\'' +
                ", appUrl='" + appUrl + '\'' +
                ", createTime=" + createTime +
                ", lastModifyTime=" + lastModifyTime +
                ", begTime=" + begTime +
                ", endTime=" + endTime +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", os='" + os + '\'' +
                '}';
    }
}
