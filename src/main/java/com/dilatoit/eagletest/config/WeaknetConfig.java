package com.dilatoit.eagletest.config;

import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.exception.ex.ConfigException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * 弱网配置文件读取类
 * Created by xueshan.wei on 4/20/2017.
 */
@Component
@Scope("singleton")
public class WeaknetConfig implements ResourceLoaderAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeaknetConfig.class);

    private ResourceLoader resourceLoader;
    private Properties properties;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @PostConstruct
    public void reload() throws Exception{
        properties = new Properties();
        try{
            Resource resource = resourceLoader.getResource("classpath:/app/weaknet.properties");
            properties.load(resource.getInputStream());
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error("弱网配置文件加载错误");
        }
    }

    /**
     * 得到弱网配置项
     * @param configName 配置名称
     * @return
     * @throws ConfigException
     */
    public String getConfig(String configName) throws ConfigException {
        if(!properties.containsKey(configName)){
            LOGGER.error("弱网配置【" + configName + "】项不存在");
            throw new ConfigException(ExceptionEnum.WEAKNET_CONFIG_ERROR);
        }
        return properties.getProperty(configName);
    }

    /**
     * 设置弱网配置项
     * @param configName 配置名称
     * @param configValue 配置值
     */
    public void setConfig(String configName, String configValue) throws ConfigException{
        if(!properties.containsKey(configName)){
            LOGGER.error("弱网配置【" + configName + "】项不存在");
            throw new ConfigException(ExceptionEnum.WEAKNET_CONFIG_ERROR);
        }
        properties.setProperty(configName, configValue);
    }

    /**
     * 得到开启命令
     * @return
     * @throws ConfigException
     */
    public String getStartCmd() throws ConfigException{
        return getConfig("weaknet.cmd.set");
    }

    /**
     * 得到关闭命令
     * @return
     * @throws ConfigException
     */
    public String getEndCmd() throws ConfigException{
        return getConfig("weaknet.cmd.unset");
    }

    /**
     * 得到开始脚本的地址
     * @return
     * @throws ConfigException
     */
    public String getStartScriptLocation() throws ConfigException{
        return getConfig("weaknet.script.set.location");
    }

    /**
     * 得到关闭脚本的地址
     * @return
     * @throws ConfigException
     */
    public String getEndScriptLocation() throws ConfigException{
        return getConfig("weaknet.script.unset.location");
    }

    /**
     * 得到弱网服务的地址
     * @return
     * @throws ConfigException
     */
    public String getServerUrl() throws ConfigException{
        return getConfig("weaknet.server.url");
    }
}
