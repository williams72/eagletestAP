package com.dilatoit.eagletest.api.common;

import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.api.base.BaseController;
import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.exception.ex.api.ApiBusinessException;
import com.dilatoit.eagletest.model.EtApp;
import com.dilatoit.eagletest.model.EtVersion;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Salt on 2017/10/17.
 */

@Controller
@RequestMapping(value = "/api/validate")
@Api(value = "表单校验相关API", description = "表单校验相关API")

public class ValidationController extends BaseController {

    @RequestMapping(value = "/userNameIsExist", method = RequestMethod.GET)
    @AuthorityCheck
    public void userNameIsExist(@RequestParam String username) throws ApiBusinessException {
        try {
            if (serviceManager.getUserService().isExistByUsername(username) != null) {
                String result = "{\"exist\":\"true\"}";
                render(result);
            } else {
                String result = "{\"exist\":\"false\"}";
                render(result);
            }
        } catch (DataBaseException dbe) {
            throw new ApiBusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
    }

    @RequestMapping(value = "/userEmailIsExist", method = RequestMethod.GET)
    public void userEmailIsExist(@RequestParam String email) throws ApiBusinessException {
        try {
            if (serviceManager.getUserService().isExistByEmail(email) != null) {
                String result = "{\"exist\":\"true\"}";
                render(result);
            } else {
                String result = "{\"exist\":\"false\"}";
                render(result);
            }
        } catch (DataBaseException dbe) {
            throw new ApiBusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
    }

    @RequestMapping(value = "/appNameIsExist", method = RequestMethod.GET)
    public void appNameIsExist(@RequestParam int versionId, @RequestParam String appName) throws ApiBusinessException {
        EtApp etApp = null;
        try {
            etApp = serviceManager.getAppService().queryByVersionIdAndName(versionId, appName);
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new ApiBusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        } finally {
            if (etApp != null) {
                String result = "{\"exist\":\"true\"}";
                render(result);
            } else {
                String result = "{\"exist\":\"false\"}";
                render(result);
            }
        }
    }

    @RequestMapping(value = "/versionIsExist", method = RequestMethod.GET)
    public void versionIsExist(@RequestParam int projectId, @RequestParam String versionName) throws ApiBusinessException {
        EtVersion etVersion = null;
        try {
            etVersion = serviceManager.getVersionService().queryVersionByPidAndName(projectId, versionName);
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new ApiBusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        } finally {
            if (etVersion != null) {
                String result = "{\"exist\":\"true\"}";
                render(result);
            } else {
                String result = "{\"exist\":\"false\"}";
                render(result);
            }
        }
    }
}
