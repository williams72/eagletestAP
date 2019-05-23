package com.dilatoit.engine.dto.translate;

import com.dilatoit.eagletest.validate.formtask.Mobile;
import com.dilatoit.engine.dto.EngineTaskMobileDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/16.
 */
public class EngineTaskMobileTranslate {
    public static EngineTaskMobileDTO translate(Mobile mobile){
        EngineTaskMobileDTO engineTaskMobileDTO = null;
        if(mobile != null){
            engineTaskMobileDTO = new EngineTaskMobileDTO();
            engineTaskMobileDTO.setSerialno(mobile.getSn());
            engineTaskMobileDTO.setBrand(mobile.getBrand());
            engineTaskMobileDTO.setModel(mobile.getModel());
            engineTaskMobileDTO.setOs(mobile.getOs());
            engineTaskMobileDTO.setIp(mobile.getIp());
        }
        return engineTaskMobileDTO;
    }
    public static List<EngineTaskMobileDTO> translateList(List<Mobile> mobiles){
        List<EngineTaskMobileDTO> list = null;
        if(mobiles != null){
            list = new ArrayList<EngineTaskMobileDTO>();
            for(Mobile mobile : mobiles){
                list.add(EngineTaskMobileTranslate.translate(mobile));
            }
        }
        return list;
    }
}
