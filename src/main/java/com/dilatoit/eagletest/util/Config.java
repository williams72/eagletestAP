package com.dilatoit.eagletest.util;

import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.exception.ex.MtcConfigException;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * Created by beishan on 2016/11/15.
 */
@Component
public class Config implements ResourceLoaderAware {
    //private static Logger logger = Logger.getLogger(Config.class);
    private static ResourceLoader resourceLoader;
    private static Properties properties;
    private String baseHost = null;
    private String basePort = null;
    public  Config(){

    }
    public void setResourceLoader(ResourceLoader resourceLoader) {
        Config.resourceLoader = resourceLoader;
    }

    @PostConstruct
    public void reloadConfig() throws MtcConfigException {
        //load mtc config
        Config.properties = new Properties();
        try{
            Resource resource = Config.resourceLoader.getResource("classpath:engineconfig.properties");
            Config.properties.load(resource.getInputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
        this.baseHost = getProperties("mtc_host");
        this.basePort = getProperties("mtc_port");
        if(this.baseHost == null){
            //no baseHost error
            throw new MtcConfigException(ExceptionEnum.MTC_CONFIG_ERROR);
        }
        if(this.basePort == null){
            //set the default port
            this.basePort = "80";
            System.out.println("没有端口值");
        }
    }
    public String getUrl(String apiName) throws MtcConfigException{
        String api = getProperties(apiName);
        if(api == null || "".equals(apiName)){
            throw new MtcConfigException(ExceptionEnum.MTC_CONFIG_API_ERROR);
        }else{
            return baseHost + ":" + basePort + api;
        }
    }
    public String getProperties(String key){
        return properties.getProperty(key);
    }
}
