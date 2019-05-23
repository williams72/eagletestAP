package com.dilatoit.eagletest.enums.system;

/**
 * Created by xueshan.wei on 12/26/2016.
 */
public enum LanguageEnum {
    ZH_CN("zh_CN"),
    EN_US("en_US");
    private String locale;
    LanguageEnum(String locale){
        this.locale = locale;
    }
    public String getLocale(){
        return locale;
    }
}
