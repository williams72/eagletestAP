package com.dilatoit.engine.engines.ete.pipe;

import com.dilatoit.commons.GsonUtils;
import com.dilatoit.commons.http.HttpUtils;
import com.dilatoit.commons.utils.TimeUtils;
import com.dilatoit.engine.dto.MobileDTO;
import com.dilatoit.engine.engines.ete.EteEngineConfig;
import com.dilatoit.engine.engines.ete.utils.ResultVerification;
import com.dilatoit.engine.enums.MobileOsEnum;
import com.dilatoit.engine.exception.EngineException;
import com.dilatoit.engine.exception.MobilePipeException;
import com.dilatoit.engine.pipes.MobilePipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ete 设备管理
 * Created by xueshan.wei on 6/14/2017.
 */
@Component
public class EteMobilePipe implements MobilePipe{
    private static Logger LOGGER = LoggerFactory.getLogger(EteMobilePipe.class);

    @Autowired
    private EteEngineConfig eteEngineConfig;

    @Override
    public String reboot(String mobileId) throws MobilePipeException {
        return null;
    }

    @Override
    public String rename(String mobileId, String name) throws MobilePipeException {
        return null;
    }

    @Override
    public String mobiles() throws MobilePipeException {
        return null;
    }

    @Override
    public String mobilesByOs(MobileOsEnum mobileOsEnum) throws MobilePipeException {
        return null;
    }

    @Override
    public List<MobileDTO> queryMobiles() throws EngineException {
        List<MobileDTO> list = new ArrayList<>();
        String api = "/api/mobiles";
        String uri = eteEngineConfig.getServerUrl() + api;
        String result = null;
        try {
            result = HttpUtils.sendGet(uri);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("[ete engine] ete engine connect error", e);
            throw new EngineException("[ete engine] ete engine connect error");
        }
        if(ResultVerification.isSuccess(result)){
            Map map = GsonUtils.toMap(result);
            List<Map> mobileDTOS = (List<Map>)map.get("data");
            if(mobileDTOS != null && mobileDTOS.size() > 0){
                for(Map eteMobileDTO : mobileDTOS){
                    list.add(convertToMobileDTO(eteMobileDTO));
                }
            }
        }
        return list;
    }

    /**
     * convert ete mobile info to MobileDTO
     * @param eteMobileDTO
     * @return
     */
    private MobileDTO convertToMobileDTO(Map eteMobileDTO){
        MobileDTO mobileDTO = null;
        if(eteMobileDTO != null){
            mobileDTO = new MobileDTO();
            mobileDTO.setModel((String)eteMobileDTO.get("model"));
            mobileDTO.setBrand((String)eteMobileDTO.get("brand"));
            mobileDTO.setMacAddress((String)eteMobileDTO.get("macAddress"));
            mobileDTO.setSerialno((String)eteMobileDTO.get("serialno"));
            mobileDTO.setHeight(String.valueOf(((Double) eteMobileDTO.get("heigh")).intValue()));
            mobileDTO.setWidth(String.valueOf(((Double)eteMobileDTO.get("width")).intValue()));
            mobileDTO.setMobileType(((Double)eteMobileDTO.get("os")).intValue());
            mobileDTO.setOs((String)eteMobileDTO.get("osVersion"));
            //这里ete 的设备状态值和 eagletest 的状态值一致
            // TODO: 6/21/2017 这里先全部设置为空闲，等到ete 后台能够判断设备状态的时候再更新为正确的
            mobileDTO.setBusy(false);
            mobileDTO.setStatus(((Double)eteMobileDTO.get("statusValue")).intValue());
            mobileDTO.setUpdatedTime(TimeUtils.convertMillisToDate(((Double)eteMobileDTO.get("update")).longValue()));
        }
        return mobileDTO;
    }
    @Override
    public List<MobileDTO> queryMobilesByOS(MobileOsEnum mobileOsEnum) throws EngineException {
        return queryMobiles();
    }

    @Override
    public String stopCurrentTask(String mobileId, String taskId) throws MobilePipeException {
        return null;
    }

    @Override
    public String stopAllTask(String mobileId) throws MobilePipeException {
        return null;
    }
}
