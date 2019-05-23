package com.dilatoit.engine.utils;

import com.dilatoit.engine.exception.EngineConfigException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Properties;

/**
 * mtc 后台配置文件加载类，主要用于加载各种配置
 * Created by beishan on 2016/11/15.
 */
@Component
public class EngineConfig implements ResourceLoaderAware {
    private static Logger LOGGER = LoggerFactory.getLogger(EngineConfig.class);

    private static ResourceLoader resourceLoader;
    private static Properties properties;
    public EngineConfig(){

    }
    public void setResourceLoader(ResourceLoader resourceLoader) {
        EngineConfig.resourceLoader = resourceLoader;
    }

    @PostConstruct
    public void reloadConfig() throws EngineConfigException {
        //load the engine config
        LOGGER.info("[engine config] load the engine config file...");
        EngineConfig.properties = new Properties();
        Resource resource = EngineConfig.resourceLoader.getResource("classpath:engineconfig.properties");
        try {
            EngineConfig.properties.load(resource.getInputStream());
        } catch (IOException e) {
            LOGGER.error("[engine config] load the engine config has a error, the config file is not exist, please check it");
            e.printStackTrace();
            throw new EngineConfigException("[engine config] 引擎服务器配置文件不存在, 请检查目录下是否存在 engineconfig.properties文件");
        }
    }

    /**
     * 读取配置文件内容，如果名称为key的属性不存在则返回null
     * @param key 要读取的属性名
     * @return 属性值 | null 属性不存在
     */
    protected String getProperties(String key){
        return properties.getProperty(key);
    }
}
