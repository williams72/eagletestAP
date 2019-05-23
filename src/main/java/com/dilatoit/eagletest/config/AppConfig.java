package com.dilatoit.eagletest.config;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * 系统配置读取类
 *
 * Created by xueshan.wei on 3/20/2017.
 */
@Component
@Scope("singleton")
public class AppConfig implements ResourceLoaderAware {
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
            Resource resource = resourceLoader.getResource("classpath:/app/app.properties");
            properties.load(resource.getInputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 得到配置项
     * @param configName
     * @return
     */
    public String getConfig(String configName){
        return properties.getProperty(configName);
    }
}
