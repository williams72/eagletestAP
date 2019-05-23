package com.dilatoit.engine.engines.mtc.pipe;

import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.engine.enums.MobileOsEnum;
import com.dilatoit.engine.enums.RealMobileTime;
import com.dilatoit.engine.exception.EngineException;
import com.dilatoit.engine.exception.MobilePipeException;
import com.dilatoit.engine.exception.RealMobilePipeException;
import com.dilatoit.engine.pipes.RealMobilePipe;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by xueshan.wei on 11/16/2016.
 */
@Component
public class MtcRealMobilePipe extends MtcBasePipe implements RealMobilePipe{
    public String realmobiles() throws EngineException {
        try{
            return realmobilesByOs(MobileOsEnum.ANDROID);
        }catch (EngineException ee){
            throw new MobilePipeException(ExceptionEnum.ENGINE_REALMOBILE_PIPE_ERROR);
        }
    }

    public String realmobilesByOs(MobileOsEnum mobileOsType) throws EngineException {
        try{
            //the default is all;
            String osType = "all";
            switch (mobileOsType){
                case ALL: osType = "all"; break;
                case ANDROID: osType = "android"; break;
                case IOS: osType = "ios"; break;
                default: break;
            }
            String params = "type=" + osType;
            return this.accessApi("api_mobile_info", params);
        }catch (EngineException ee){
            throw new RealMobilePipeException("realmobile pipe has a exception");
        }
    }

    public String rent(String realMobileId, RealMobileTime realMobileTime) throws EngineException {
        try{
            String time = this.getTimeLength(realMobileTime);
            String params = "serialNumber=" + realMobileId + "&userId=" + this.getServerAccountId() + "&useTime=" + time;
            String resultStr = this.accessApi("api_realmobile_rent", params);
            Gson gson = new Gson();
            Map result = gson.fromJson(resultStr, Map.class);
            if(result.containsKey("status") && "success".equals(result.get("status"))){
                resultStr = "success";
            }else{
                resultStr = "fail";
            }
            return resultStr;
        }catch (EngineException ee){
            throw new MobilePipeException(ExceptionEnum.ENGINE_REALMOBILE_PIPE_ERROR);
        }
    }

    public String realmobileinfo(String realMobileId) throws EngineException {
        try{
            String params = "serialNumber=" + realMobileId + "&userId=" + this.getServerAccountId();
            String result = this.accessApi("api_realmobile_rent_info", params);
            Gson gson = new Gson();
            Map map = gson.fromJson(result, Map.class);
            if(map != null && map.containsKey("Error")){
                throw new EngineException(ExceptionEnum.RESOURCE_NOT_FOUND);
            }
            return result;
        }catch (EngineException ee){
            throw new MobilePipeException(ExceptionEnum.ENGINE_REALMOBILE_PIPE_ERROR);
        }
    }

    public String renewal(String realMobileId) throws EngineException {
        try{
            String params = "serialNumber=" + realMobileId + "&userId=" + this.getServerAccountId();
            return this.accessApi("api_realmobile_renewal", params);
        }catch (EngineException ee){
            throw new MobilePipeException(ExceptionEnum.ENGINE_REALMOBILE_PIPE_ERROR);
        }
    }

    public String stop(String realMobileId) throws EngineException {
        try{
            String params = "id=" + realMobileId + "&abortInfo=" + "user stop";
            return this.accessApi("api_realmobile_stop_current", params);
        }catch (EngineException ee){
            throw new MobilePipeException(ExceptionEnum.ENGINE_REALMOBILE_PIPE_ERROR);
        }
    }

    public String stopAll(String realMobileId) throws EngineException {
        try{
            String params = "serialNumber=" + realMobileId + "&abortInfo=" + "admin stop it";
            return this.accessApi("api_realmobile_stop_all", params);
        }catch (EngineException ee){
            throw new MobilePipeException(ExceptionEnum.ENGINE_REALMOBILE_PIPE_ERROR);
        }
    }
}
