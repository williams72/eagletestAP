package com.dilatoit.eagletest.interceptor;

import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.service.SystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by xueshan.wei on 12/26/2016.
 */
public class UserLocaleChangeInterceptor extends LocaleChangeInterceptor {
    @Autowired
    private SystemConfigService systemConfigService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException{
        String newLocale = request.getParameter(getParamName());
        /*if(StringUtils.isBlank(newLocale)){
            newLocale = (String)request.getSession().getAttribute("language");
            //-- set language to chinese
            if (StringUtils.isBlank(newLocale)) {
                newLocale = "zh_CN";
            }
        }
        //-- 如果没有改变语言返回true，否则要重置session中的值
        if (newLocale.equals(request.getSession().getAttribute("language"))) {
            return true;
        }*/
        String sysLocale = "zh_CN";
        try{
            sysLocale = systemConfigService.getSystemConfig("system_language").getConfigValue();

        }catch (DataBaseException dbe){
            // TODO: 3/28/2017 此处应该处理
            //此处应该处理
        }
        reSetSessionLocale(request, response, sysLocale);
        return true;
    }
    private void reSetSessionLocale(HttpServletRequest request, HttpServletResponse response, String newLocale) {
        request.getSession().setAttribute("language", newLocale);
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        if (localeResolver == null) {
            throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
        }
        LocaleEditor localeEditor = new LocaleEditor();
        localeEditor.setAsText(newLocale);
        localeResolver.setLocale(request, response, (Locale) localeEditor.getValue());

    }
}
