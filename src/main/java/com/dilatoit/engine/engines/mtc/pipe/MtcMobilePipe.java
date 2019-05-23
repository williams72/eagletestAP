package com.dilatoit.engine.engines.mtc.pipe;

import com.dilatoit.eagletest.util.GsonUtils;
import com.dilatoit.engine.dto.MobileDTO;
import com.dilatoit.engine.enums.MobileOsEnum;
import com.dilatoit.engine.exception.EngineException;
import com.dilatoit.engine.exception.MobilePipeException;
import com.dilatoit.engine.pipes.MobilePipe;
import com.dilatoit.engine.engines.mtc.data.adapter.MobileTranslate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by xueshan.wei on 11/16/2016.
 */
@Component
public class MtcMobilePipe extends MtcBasePipe implements MobilePipe{

    public String reboot(String mobileId) throws MobilePipeException {
        try{
            return this.accessApi("api_mobile_reboot", "serialNumber=" + mobileId);
        }catch (EngineException ee){
            throw new MobilePipeException("mobile pipe has a exception");
        }
    }

    public String rename(String mobileId, String name) throws MobilePipeException {
        try{
            String params = "serialNumber=" + mobileId + "&name=" + name;
            return this.accessApi("api_mobile_rename", params);
        }catch (EngineException ee){
            throw new MobilePipeException("mobile pipe has a exception");
        }
    }

    public List<MobileDTO> queryMobiles() throws EngineException {
        return queryMobilesByOS(MobileOsEnum.ALL);
    }

    public List<MobileDTO> queryMobilesByOS(MobileOsEnum mobileOsEnum) throws EngineException {
        //the default is all;
        String osType = null;
        switch (mobileOsEnum){
            case ALL: osType = "all"; break;
            case ANDROID: osType = "android"; break;
            case IOS: osType = "ios"; break;
            default: osType = "all"; break;
        }
        String params = "type=" + osType;
        String result = this.accessApi("api_mobile_info", params);
        Map mobileInfo = GsonUtils.toMap(result);
        //查询的结果包含status 字段并且该字段值为success 表示调用接口成功
        if(mobileInfo.containsKey("status") && "success".equals(mobileInfo.get("status"))){
            List mobiles = (List) mobileInfo.get("mobile");
            if(mobiles != null){
                return MobileTranslate.translateList(mobiles);
            }
        }
        return null;
    }

    public String mobiles() throws MobilePipeException {
        try{
            return this.mobilesByOs(MobileOsEnum.ALL);
        }catch (EngineException ee){
            throw new MobilePipeException("mobile pipe has a exception");
        }
    }

    public String mobilesByOs(MobileOsEnum mobileOsEnum) throws MobilePipeException {
        try{
            //the default is all;
            String osType = null;
            switch (mobileOsEnum){
                case ALL: osType = "all"; break;
                case ANDROID: osType = "android"; break;
                case IOS: osType = "ios"; break;
                default: osType = "all"; break;
            }
            String params = "type=" + osType;
            return this.accessApi("api_mobile_info", params);
        }catch (EngineException ee){
            throw new MobilePipeException("mobile pipe has a exception");
        }
    }

    public String stopCurrentTask(String mobileId, String taskId) throws MobilePipeException {
        try{
            String params = "taskId=" + taskId + "&serialNumber=" + mobileId;
            return this.accessApi("api_mobile_task_stop", params);
        }catch (EngineException ee){
            throw new MobilePipeException("mobile pipe has a exception");
        }
    }

    public String stopAllTask(String mobileId) throws MobilePipeException {
        try{
            return this.accessApi("api_mobile_task_stop_all", "serialNumber=" + mobileId);
        }catch (EngineException ee){
            throw new MobilePipeException("mobile pipe has a exception");
        }
    }
}
