package com.dilatoit.eagletest.api.common;


import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.annotation.SystemControllerLog;
import com.dilatoit.eagletest.api.base.BaseController;
import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.enums.log.SystemLog;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.exception.ex.api.ApiBusinessException;
import com.dilatoit.eagletest.validate.api.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by xueshan.wei on 1/18/2017.
 */
@Api(value = "language", description = "系统语言相关")
@Controller
@RequestMapping(value = "/api/common")
@Scope("prototype")
public class LanguageController extends BaseController {
    @RequestMapping(value = "/language", method = RequestMethod.GET)
    @ApiOperation(value = "查询当前系统语言", notes = "用于查询当前的系统语言", httpMethod = "GET", response = ApiResult.class)
    @AuthorityCheck
    public void getSystemLanguage() throws ApiBusinessException {
        try{
            String language = serviceManager.getSystemConfigService().getSystemConfig("system_language").getConfigValue();
            Map<String, String> result = new HashMap<String, String>();
            result.put("language", language);
            renderResult("查询当前系统语言成功", result);
        }catch (DataBaseException dbe){
            throw new ApiBusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
    }
    @RequestMapping(value = "/language", method = RequestMethod.PUT)
    @ApiOperation(value = "设置当前系统语言", notes = "用于设置当前的系统语言", httpMethod = "PUT", response = ApiResult.class)
    @AuthorityCheck(permission = "systemConfig:update")
    @SystemControllerLog(systemLog = SystemLog.SYSTEM_CONFIG_LANGUAGE_UPDATE)
    public void setSystemLanguage(@RequestParam String language) throws ApiBusinessException{
        if(StringUtils.isNotBlank(language)){
            if("zh_CN".equals(language) || "en_US".equals(language)){
                try{
                    serviceManager.getSystemConfigService().updateSystemConfig("system_language", language);
                    Map<String, String> result = new HashMap<String, String>();
                    result.put("language", language);
                    renderResult("设置当前系统语言成功", result);
                }catch (DataBaseException dbe){
                    throw new ApiBusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
                }
            }
        }
    }
}
