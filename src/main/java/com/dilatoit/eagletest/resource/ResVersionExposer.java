package com.dilatoit.eagletest.resource;

import com.dilatoit.eagletest.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * resource version controller
 * Created by xueshan.wei on 3/20/2017.
 */
@Component(value = "resVersionExposer")
public class ResVersionExposer implements ServletContextAware {
    @Autowired
    private AppConfig appConfig;
    private ServletContext servletContext;

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
        String appVersion = appConfig.getConfig("app.version");
        String jsVersion = appConfig.getConfig("app.js.version");
        String cssVersion = appConfig.getConfig("app.css.version");

        //set js version
        getServletContext().setAttribute("jsVersion", jsVersion);
        getServletContext().setAttribute("cssVersion", cssVersion);
        getServletContext().setAttribute("appVersion", appVersion);
    }

    public ServletContext getServletContext() {
        return servletContext;
    }
}
