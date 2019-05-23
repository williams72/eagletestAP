package com.dilatoit.eagletest.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by xueshan.wei on 11/14/2016.
 */
@Entity
@Table(name = "et_log")
public class EtLog implements java.io.Serializable{
    //Fields

    private Integer id;
    private String operator;
    private String operationCode;
    private String operation;
    private Date operateTime;
    private String ip;
    private String url;
    private String param;
    private String detail;
    private Integer logType;

    public EtLog() {
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

    @Column(name = "operator", nullable = false)
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Column(name = "operation_code", nullable = false)
    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    @Column(name = "operation", nullable = false)
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Column(name = "operate_time", nullable = false)
    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    @Column(name = "ip", nullable = false)
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Column(name = "url", nullable = false)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "param")
    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    @Column(name = "detail")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Column(name = "log_type", nullable = false)
    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    @Override
    public String toString() {
        return "EtLog{" +
                "id=" + id +
                ", operator='" + operator + '\'' +
                ", operationCode='" + operationCode + '\'' +
                ", operation='" + operation + '\'' +
                ", operateTime=" + operateTime +
                ", ip='" + ip + '\'' +
                ", url='" + url + '\'' +
                ", param='" + param + '\'' +
                ", detail='" + detail + '\'' +
                ", logType=" + logType +
                '}';
    }
}
