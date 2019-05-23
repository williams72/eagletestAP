package com.dilatoit.eagletest.api.project;


import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.annotation.SystemControllerLog;
import com.dilatoit.eagletest.api.base.BaseController;
import com.dilatoit.eagletest.dto.AppDTO;
import com.dilatoit.eagletest.dto.translate.AppDTOTranslate;
import com.dilatoit.eagletest.enums.AppType;
import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.enums.log.SystemLog;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.exception.ex.api.ApiBusinessException;
import com.dilatoit.eagletest.model.EtApp;
import com.dilatoit.eagletest.model.EtProject;
import com.dilatoit.eagletest.model.EtUser;
import com.dilatoit.eagletest.model.EtVersion;
import com.dilatoit.eagletest.validate.api.ApiResult;
import com.dilatoit.engine.exception.EngineException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


/**
 * Created by Salt on 2017/4/17.
 */
@Controller(value = "apiAppController")
@RequestMapping(value = "/api")
@Api(value = "App相关API",description = "App相关API")
@Scope("prototype")
public class ProjectAppController extends BaseController {

    /**
     *
     * @param appId
     * @param newVisibility
     * @throws ApiBusinessException
     */
    @ApiOperation(value = "修改app属性", notes = "修改app属性接口", httpMethod = "PUT", response = ApiResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "projectId", value = "项目id", required = true, dataType = "Integer",paramType = "path"),
            @ApiImplicitParam(name = "appId", value = "APPid", required = true, dataType = "Integer",paramType = "path"),
            @ApiImplicitParam(name = "newVisibility", value = "可见性", required = true, dataType = "Integer",paramType = "query")})
    @RequestMapping(value = "/project/{projectId}/app/{appId}/visibility", method = RequestMethod.PUT)
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.APP_UPDATE)
    public void changeVisibility(@PathVariable Integer projectId, @PathVariable Integer appId, @RequestParam Integer newVisibility) throws ApiBusinessException {
        try{
            serviceManager.getAppService().changeVisibility(appId, newVisibility);
        }catch (BusinessException e){
            throw new ApiBusinessException(e.getEe());
        }
        apiResult.reset();
        this.apiResult.setMsg("属性修改成功");
        this.renderObj(apiResult);
    }

    /**
     *
     * @param projectId
     * @param userId
     * @param appName
     * @param visibility
     * @param label
     * @param versionId
     * @throws ApiBusinessException
     * @throws EngineException
     */
    @ApiOperation(value = "上传app文件", notes = "上传app文件接口", httpMethod = "POST", response = ApiResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "projectId", value = "项目id", required = true, dataType = "Integer",paramType = "path"),
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "Integer",paramType = "path"),
            @ApiImplicitParam(name = "appName", value = "appName", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "versionId", value = "版本id", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "label", value = "标签", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "visibility", value = "可见性", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "file", value = "app文件", required =true, dataType = "file",paramType = "query"),})
    @RequestMapping(value = "/project/{projectId}/user/{userId}/app", method = RequestMethod.POST)
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.APP_CREATE)
    public void submitApp(@PathVariable Integer projectId, @PathVariable Integer userId, @RequestParam String appName,
                          @RequestParam Integer visibility, @RequestParam String label, @RequestParam Integer versionId,
                          @RequestParam MultipartFile file) throws ApiBusinessException, EngineException{

        if (file != null) {
            String path = System.getProperty("user.home");
            String fileName = "temp" + file.getOriginalFilename();
            path = path + "/" + fileName;
            File localFile = new File(path);
            try {
                file.transferTo(localFile);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ApiBusinessException(ExceptionEnum.APP_SAVE_ERROR);
            }
            if (file.getSize() > 0) {
                EtApp etApp = new EtApp();
                EtProject project = new EtProject();
                project.setId(projectId);
                EtUser etUser = new EtUser();
                etUser.setId(userId);
                EtVersion etVersion = new EtVersion();
                etVersion.setId(versionId);
                //存储实体参数
                etApp.setProject(project);
                etApp.setEtUser(etUser);
                etApp.setEtVersion(etVersion);
                etApp.setAppName(appName);
                etApp.setLabel(label);
                etApp.setVisibility(visibility);

                AppType appType = null;
                if(fileName.endsWith(".apk")){
                    appType = AppType.ANDROID;
                }else{
                    appType = AppType.IOS;
                }
                try{
                    serviceManager.getAppService().addApp(etApp, localFile, appType.value());
                }catch (DataBaseException e){
                    e.printStackTrace();
                }catch (EngineException e){
                    throw new EngineException(e.getEe());
                }
                AppDTO appDTO = AppDTOTranslate.translate(etApp);
                this.renderResult("上传app成功", appDTO);
            }
        }else {
            throw new ApiBusinessException(ExceptionEnum.NUll_OBJECT_ERROR);
        }

    }

    /*@RequestMapping(value = "/project/{pid}/app/{appid}/visibility2", method = RequestMethod.PUT)
    public void changeVisibility(@Valid AppVisibilityValidate appVisibilityValidate, BindingResult bindingResult) throws ApiBusinessException{
        if (bindingResult.hasErrors()) {
            throw new ApiParameterException(ExceptionEnum.PARAM_ERROR, bindingResult);
        } else {
            System.out.println(appVisibilityValidate);
        }
    }

    @RequestMapping(value = "/project/{pid}/app/{appid}/visibility3", method = RequestMethod.POST)
    public void chageVisibility3(@Valid @RequestBody AppVisibilityValidate appVisibilityValidate, BindingResult bindingResult) throws ApiBusinessException{
        if (bindingResult.hasErrors()) {
            throw new ApiParameterException(ExceptionEnum.PARAM_ERROR, bindingResult);
        } else {
            System.out.println(appVisibilityValidate);
        }
    }*/
}
