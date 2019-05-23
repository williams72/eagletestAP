package com.dilatoit.eagletest.dto;

import com.dilatoit.eagletest.model.EtLog;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xueshan.wei on 3/10/2017.
 */
public class LogDTO {
    @Expose
    private Integer id;
    @Expose
    private String operator;
    @Expose
    private String operationCode;
    @Expose
    private String operation;
    @Expose
    private Date operateTime;
    @Expose
    private String ip;
    @Expose
    private String url;
    @Expose
    private String param;
    @Expose
    private String detail;
    @Expose
    private Integer logType;

    public LogDTO(){

    }

    public LogDTO(EtLog log){
        if(log != null){
            id = log.getId();
            operator = log.getOperator();
            operationCode = log.getOperationCode();
            operation = log.getOperation();
            operateTime = log.getOperateTime();
            ip = log.getIp();
            url = log.getUrl();
            param = log.getParam();
            detail = log.getDetail();
            logType = log.getLogType();
        }
    }

    public static List<LogDTO> tranceformList(List<EtLog> logs){
        List<LogDTO> logDTOS = null;
        if(logs != null && logs.size() > 0){
            logDTOS = new ArrayList<LogDTO>();
            LogDTO logtemp = null;
            for(EtLog log : logs){
                logtemp = LogDTO.transformTo(log);
                logDTOS.add(logtemp);
            }
        }
        return logDTOS;
    }

    public static LogDTO transformTo(EtLog log){
        if(log != null){
            LogDTO logDTO = new LogDTO(log);
            return logDTO;
        }
        return null;
    }
    public void setApiLog(EtLog log){
        if(log != null){
            id = log.getId();
            operator = log.getOperator();
            operationCode = log.getOperationCode();
            operation = log.getOperation();
            operateTime = log.getOperateTime();
            ip = log.getIp();
            url = log.getUrl();
            param = log.getParam();
            detail = log.getDetail();
            logType = log.getLogType();
        }
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }
}
