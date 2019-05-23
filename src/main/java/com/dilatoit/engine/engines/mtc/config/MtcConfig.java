package com.dilatoit.engine.engines.mtc.config;

import com.dilatoit.engine.exception.EngineConfigException;
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
public class MtcConfig implements ResourceLoaderAware {
    //private static Logger logger = Logger.getLogger(Config.class);
    private static ResourceLoader resourceLoader;
    private static Properties properties;
    private String serverHost = null;
    private String serverPort = null;
    private String serverAccount = null;
    private String serverPassword = null;
    private String serverAccountId = null;
    public MtcConfig(){

    }
    public void setResourceLoader(ResourceLoader resourceLoader) {
        MtcConfig.resourceLoader = resourceLoader;
    }

    @PostConstruct
    public void reloadConfig() throws EngineConfigException {
        //load the mtc`s config
        MtcConfig.properties = new Properties();
            Resource resource = MtcConfig.resourceLoader.getResource("classpath:engineconfig.properties");
        try {
            MtcConfig.properties.load(resource.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            throw new EngineConfigException("[mtc_config] 服务器配置文件不存在, 请检查目录下是否存在 mtcconfig.properties文件");
        }
        //get the server host & port
        this.serverHost = getProperties("mtc_host");
        this.serverPort = getProperties("mtc_port");

        //read the server account config
        this.serverAccount = getProperties("mtc_server_account");
        this.serverPassword = getProperties("mtc_server_password");
        this.serverAccountId = getProperties("mtc_server_account_id");

        if(this.serverHost == null){
            //no baseHost error
            throw new EngineConfigException("[mtc_config] mtc engine server host is not found");
        }
        if(this.serverPort == null){
            //set the default port
            this.serverPort = "80";
        }
        if(this.serverAccount == null){
            //set the default username
            this.serverAccount = "admin";
        }
        if(this.serverPassword == null){
            //set the default password
            this.serverPassword = "admin";
        }

        if(this.serverAccountId == null){
            //set the default id
            this.serverAccountId = "1";
        }
    }
    public String getUrl(String apiName) throws EngineConfigException {
        String api = getProperties(apiName);
        if(api == null || "".equals(apiName)){
            throw new EngineConfigException("[mtc_config] mtc engine api is not found");
        }else{
            return serverHost + ":" + serverPort + api;
        }
    }
    public String getProperties(String key){
        return properties.getProperty(key);
    }

    public String getServerHost() throws EngineConfigException {
        if(this.serverHost == null){
            throw new EngineConfigException("[mtc_config] mtc server host config error");
        }
        return serverHost;
    }

    public String getServerPort() throws EngineConfigException {
        if(this.serverPort == null){
            throw new EngineConfigException("[mtc_config] mtc server port config error");
        }
        return serverPort;
    }

    public String getServerAccountId() throws EngineConfigException {
        if(this.serverAccountId == null){
            throw new EngineConfigException("[mtc_config] mtc server accountId config error");
        }
        return serverAccountId;
    }

    public String getServerAccount() throws EngineConfigException {
        if(this.serverAccount == null){
            throw new EngineConfigException("[mtc_config] mtc server account config error");
        }
        return serverAccount;
    }

    public String getServerPassword() throws EngineConfigException {
        if(this.serverPassword == null){
            throw new EngineConfigException("[mtc_config] mtc server password config error");
        }
        return serverPassword;
    }
}
