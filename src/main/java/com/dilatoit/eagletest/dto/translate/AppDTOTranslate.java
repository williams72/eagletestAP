package com.dilatoit.eagletest.dto.translate;

import com.dilatoit.eagletest.dto.AppDTO;
import com.dilatoit.eagletest.model.EtApp;

/**
 * Created by Salt on 2017/7/20.
 */
public class AppDTOTranslate {
    public static AppDTO translate(EtApp app){
        AppDTO appDTO = null;
        if(app != null){
            appDTO = new AppDTO();
            appDTO.setId(app.getId());
            appDTO.setAppName(app.getAppName());
            appDTO.setAppRealName(app.getAppRealName());
            appDTO.setVisibility(app.getVisibility());
            appDTO.setAppUrl(app.getAppAddress());
        }
        return appDTO;
    }
}
