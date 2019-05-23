package com.dilatoit.eagletest.model;

import javax.persistence.*;

/**
 * Created by xueshan.wei on 1/5/2017.
 */
@Entity
@Table(name = "et_subtask")
public class EtSubtask {
    private Integer id;
    private Integer projectId;
    private Integer versionId;
    private Integer appId;
    private EtTask task;
    private Integer userId;
    private Integer status;
    private Integer result;
    private Integer subtaskType;
    private Integer installErrorNum;
    private Integer uninstallErrorNum;
    private Integer runErrorNum;
    private Integer notRunNum;
    private Integer passNum;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "project_id", nullable = false)
    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
    @Column(name = "version_id", nullable = false)
    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    public EtTask getTask() {
        return task;
    }

    public void setTask(EtTask task) {
        this.task = task;
    }
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    @Column(name = "result", nullable = false)
    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
    @Column(name = "subtask_type", nullable = false)
    public Integer getSubtaskType() {
        return subtaskType;
    }

    public void setSubtaskType(Integer subtaskType) {
        this.subtaskType = subtaskType;
    }
    @Column(name = "install_error_num")
    public Integer getInstallErrorNum() {
        return installErrorNum;
    }

    public void setInstallErrorNum(Integer installErrorNum) {
        this.installErrorNum = installErrorNum;
    }
    @Column(name = "uninstall_error_num")
    public Integer getUninstallErrorNum() {
        return uninstallErrorNum;
    }

    public void setUninstallErrorNum(Integer uninstallErrorNum) {
        this.uninstallErrorNum = uninstallErrorNum;
    }
    @Column(name = "run_error_num")
    public Integer getRunErrorNum() {
        return runErrorNum;
    }

    public void setRunErrorNum(Integer runErrorNum) {
        this.runErrorNum = runErrorNum;
    }
    @Column(name = "not_run_num")
    public Integer getNotRunNum() {
        return notRunNum;
    }

    public void setNotRunNum(Integer notRunNum) {
        this.notRunNum = notRunNum;
    }
    @Column(name = "pass_num")
    public Integer getPassNum() {
        return passNum;
    }

    public void setPassNum(Integer passNum) {
        this.passNum = passNum;
    }
    @Column(name = "app_id", nullable = false)
    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    @Override
    public String toString() {
        return "EtSubtask{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", versionId=" + versionId +
                ", appId=" + appId +
                ", userId=" + userId +
                ", status=" + status +
                ", result=" + result +
                ", subtaskType=" + subtaskType +
                ", installErrorNum=" + installErrorNum +
                ", uninstallErrorNum=" + uninstallErrorNum +
                ", runErrorNum=" + runErrorNum +
                ", notRunNum=" + notRunNum +
                ", passNum=" + passNum +
                '}';
    }
}
