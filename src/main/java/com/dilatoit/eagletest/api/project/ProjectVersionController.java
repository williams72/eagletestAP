package com.dilatoit.eagletest.api.project;

import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.annotation.SystemControllerLog;
import com.dilatoit.eagletest.api.model.Version;
import com.dilatoit.eagletest.api.base.BaseController;
import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.enums.log.SystemLog;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.api.ApiBusinessException;
import com.dilatoit.eagletest.exception.ex.api.ApiParameterException;
import com.dilatoit.eagletest.model.EtVersion;
import com.dilatoit.eagletest.validate.api.ApiResult;
import com.dilatoit.eagletest.validate.api.AddVersion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by xueshan.wei on 3/9/2017.
 */
@Api(value = "project-version", description = "项目版本管理")
@Controller(value = "apiProjectVersionController")
@RequestMapping(value = "/api")
@Scope("prototype")
public class ProjectVersionController extends BaseController {

    /**
     * query project version`s info
     * @param projectId
     * @param versionId
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/project/{projectId}/version/{versionId}", method = RequestMethod.GET)
    @ApiOperation(value = "查询项目版本信息", notes = "查询某个项目下某个版本的信息",
            httpMethod = "GET", response = ApiResult.class)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "projectId",value = "项目id",required = true,dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "versionId",value = "版本id",required = true,dataType = "Integer")})
    @AuthorityCheck
    public void queryProjectSingleVersion(@PathVariable Integer projectId,
                                          @PathVariable Integer versionId) throws ApiBusinessException{
        try {
            EtVersion version = serviceManager.getVersionService().queryVersionById(versionId);
            if(version != null){
                Version version1 = new Version(version);
                this.renderResult("查询项目版本信息成功", version1);
            }else{
                throw new ApiBusinessException(ExceptionEnum.PROJECT_VERSION_QUERY_NOTEXIST);
            }
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
    }

    /**
     * 增加版本项目
     * @param projectId 要增加版本的项目id
     * @param version 新版本数据承载实体
     * @param bindingResult 参数校验结果
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/project/{projectId}/version", method = RequestMethod.POST)
    @ApiOperation(value = "增加项目版本", notes = "用于向一个项目添加新版本",
            httpMethod = "POST", response = ApiResult.class)
    @ApiImplicitParam(paramType = "path", name = "projectId", value = "项目id",required = true,dataType = "Integer")
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.VERSION_CREATE)
    public void addProjectVersion(@PathVariable Integer projectId,
                                  @Valid @RequestBody AddVersion version, BindingResult bindingResult) throws ApiBusinessException{
        if(bindingResult.hasErrors()){
            throw new ApiParameterException(ExceptionEnum.PARAM_ERROR, bindingResult);
        }
        EtVersion version1 = new EtVersion();
        version1.setVersionName(version.getName());
        version1.setVersionStatus(version.getStatus());
        try {
            Integer newVersionId = serviceManager.getVersionService().addVersion(version1, projectId);
            version1 = serviceManager.getVersionService().queryVersionById(newVersionId);
            Version apiVersion = new Version(version1);
            this.renderResult("添加项目版本成功", apiVersion);
        } catch (BusinessException be){
            throw new ApiBusinessException(be.getEe());
        }
    }
}
