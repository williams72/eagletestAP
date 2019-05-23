package com.dilatoit.engine.engines.ete;

import com.dilatoit.engine.exception.EngineConfigException;
import com.dilatoit.engine.utils.EngineConfig;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * ete engine config 操作类
 * 主要作用是读取ete engine 的相关配置
 * Created by xueshan.wei on 6/14/2017.
 */
@Component
public class EteEngineConfig extends EngineConfig {
    private static Logger LOGGER = LoggerFactory.getLogger(EteEngineConfig.class);

    @Override
    public void reloadConfig() throws EngineConfigException {
        super.reloadConfig();
    }

    /**
     * get ete server url
     * @return
     * @throws EngineConfigException
     */
    public String getServerUrl() throws EngineConfigException{
        String serverAddressKey = "ete.server.address";
        String serverPortKey = "ete.server.port";

        String serverAddress = getProperties(serverAddressKey);
        String serverPort = getProperties(serverPortKey);

        if(StringUtils.isNotEmpty(serverAddress) && StringUtils.isNotEmpty(serverPort)){
            return serverAddress + ":" + serverPort;
        }else {
            LOGGER.error("[ete engine config] ete engine server add or port config error");
            throw new EngineConfigException("[ete engine config] ete engine server add or port config error");
        }
    }
}
