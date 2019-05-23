package com.dilatoit.eagletest.dto.translate;
import com.dilatoit.eagletest.dto.LogDTO;
import com.dilatoit.eagletest.model.EtLog;
import java.util.ArrayList;
import java.util.List;

/**
 * log data transalte Object
 * Created by xueshan.wei on 4/10/2017.
 */
public class LogDTOTranslate {

    public static LogDTO translate(EtLog log){
        LogDTO logDTO = null;
        if(log != null){
            logDTO = new LogDTO();
            logDTO.setId(log.getId());
            logDTO.setDetail(log.getDetail());
            logDTO.setIp(log.getIp());
            logDTO.setLogType(log.getLogType());
            logDTO.setOperateTime(log.getOperateTime());
            logDTO.setOperation(log.getOperation());
            logDTO.setOperationCode(log.getOperationCode());
            logDTO.setOperator(log.getOperator());
            logDTO.setParam(log.getParam());
            logDTO.setUrl(log.getUrl());
        }
        return logDTO;
    }

    public static List<LogDTO> translateList(List<EtLog> logs){
        List<LogDTO> logDTOS = null;
        if(logs != null){
            logDTOS = new ArrayList<LogDTO>();
            for(EtLog log : logs){
                logDTOS.add(LogDTOTranslate.translate(log));
            }
        }
        return logDTOS;
    }
}
