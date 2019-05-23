package com.dilatoit.engine.engines.mtc.pipe;

import com.dilatoit.engine.enums.RealMobileTime;
import com.dilatoit.engine.exception.EngineConfigException;
import com.dilatoit.engine.exception.EngineException;
import com.dilatoit.engine.engines.mtc.config.MtcConfig;
import com.dilatoit.engine.engines.mtc.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * pipe 基础类
 * 主要用于调用 mtc 接口，以及得到mtc 相应配置内容
 * Created by xueshan.wei on 11/16/2016.
 */
public class MtcBasePipe {
    /**
     * mtc 配置类
     */
    @Autowired
    protected MtcConfig mtcConfig;


    /**
     * mtc API访问方法
     * @param apiName 要访问的API
     * @param param 要传递的参数
     * @return 调用mtc API返回的结果
     * @throws EngineException 这里可能会抛出 EngineNotFoundException 或者 EngineConfigException
     */
    public String accessApi(String apiName, String param) throws EngineException{
        String url = mtcConfig.getUrl(apiName);
        return HttpUtil.sendPost(url, param);
        /*
        if(api == null || "".equals(apiName)){
            throw new EngineConfigException("engine api is not found");
        }else{
            String url = mtcConfig.getServerHost() + ":" + mtcConfig.getServerPort() + api;
            result = HttpUtil.sendPost(url, param);
            Map map = JsonTools.toMap(result);
            if(map.containsKey("Error")){
                System.out.println(result);
                throw new EngineException(ExceptionEnum.ENGINE_ERROR);
            }else{
                return result;
            }
        }*/
    }

    /**
     * 获取app上传url
     * @return app 上传url
     * @throws EngineConfigException mtc 配置文件异常（app 上传api配置错误）
     */
    public String getAppUploadUrl() throws EngineConfigException{
        return mtcConfig.getUrl("api_upload_app");
    }

    /**
     * 获取文件上传url
     * @return 文件上传url
     * @throws EngineConfigException mtc 配置文件异常（文件上传api配置错误）
     */
    public String getFileUploadUrl() throws EngineConfigException{
        return mtcConfig.getUrl("api_upload_file");

    }

    /**
     * 获取创建任务url
     * @return
     * @throws EngineException
     */
    public String getCreateTaskUrl() throws EngineException{
        return mtcConfig.getUrl("api_task_submit");
    }

    /**
     * rf实时日志url
     */
    public String getRFLogUrl() throws EngineException{
        return mtcConfig.getUrl("api_task_mobile_realtime_log");
    }

    /**
     * 获取配置的真机调试三级时长
     * @param realMobileTime
     * @return
     */
    public String getTimeLength(RealMobileTime realMobileTime){
        String time;
        switch (realMobileTime){
            case TIME_1: time = mtcConfig.getProperties("mtc_tiaoshi_time_1");break;
            case TIME_2: time = mtcConfig.getProperties("mtc_tiaoshi_time_2");break;
            case TIME_3: time = mtcConfig.getProperties("mtc_tiaoshi_time_3");break;
            default:time = mtcConfig.getProperties("");break;
        }
        return time;
    }

    /**
     * 获取配置的mtc 账户
     * @return mtc 账户
     * @throws EngineConfigException 配置项读取失败
     */
    public String getServerAccount() throws EngineConfigException{
        return mtcConfig.getServerAccount();
    }

    /**
     * 获取配置的mtc密码
     * @return mtc 密码
     * @throws EngineConfigException 配置项读取失败
     */
    public String getServerPassword() throws EngineConfigException{
        return mtcConfig.getServerPassword();
    }

    /**
     * 获取配置的mtc账户id
     * @return mtc账户id
     * @throws EngineConfigException 配置项读取失败
     */
    public String getServerAccountId()throws EngineConfigException{
        return mtcConfig.getServerAccountId();
    }

    /**
     * 获取配置的 mtc 服务base uri
     * @return mtc 服务base uri
     * @throws EngineConfigException 配置项读取失败
     */
    public String getBaseUri() throws EngineConfigException{
        return  mtcConfig.getServerHost() + ":" + mtcConfig.getServerPort();
    }
}
