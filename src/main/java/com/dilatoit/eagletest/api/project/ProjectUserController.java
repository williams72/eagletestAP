package com.dilatoit.eagletest.api.project;


import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.annotation.SystemControllerLog;
import com.dilatoit.eagletest.api.base.BaseController;
import com.dilatoit.eagletest.api.model.ApiPageData;
import com.dilatoit.eagletest.api.model.ProjectUser;
import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.enums.log.SystemLog;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.exception.ex.api.ApiBusinessException;
import com.dilatoit.eagletest.exception.ex.api.ApiParameterException;
import com.dilatoit.eagletest.model.EtProjectUser;
import com.dilatoit.eagletest.model.EtUser;
import com.dilatoit.eagletest.query.model.BaseQuery;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;
import com.dilatoit.eagletest.validate.api.ApiResult;
import com.dilatoit.eagletest.validate.api.UserToProject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * Created by xueshan.wei on 3/8/2017.
 */
@Api(value = "project-user", description = "项目成员")
@RequestMapping(value = "/api")
@Controller(value = "apiProjectUserController")
@Scope("prototype")
public class ProjectUserController extends BaseController {

    /**
     * add a project member
     * @param userToProject
     * @param bindingResult
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/project/{projectId}/member", method = RequestMethod.POST)
    @ApiOperation(value = "增加项目成员", notes = "用于向一个项目添加一个用户", httpMethod = "POST", response = ApiResult.class)
    //@ApiImplicitParam(name = "userToProject",value = "项目成员实体",dataType = "UserToProject")
    @SystemControllerLog(systemLog = SystemLog.PROJECT_USER_ADD)
    @AuthorityCheck
    public void addUserToProject(@Valid @RequestBody UserToProject userToProject, BindingResult bindingResult) throws ApiBusinessException {
        if(bindingResult.hasErrors()){
            throw new ApiParameterException(ExceptionEnum.PARAM_ERROR, bindingResult);
        }
        //获取当前登录的用户
        EtUser currentUser = this.getCurrentUser();

        try {
            serviceManager.getProjectUserService().addMember(currentUser.getId(),
                    userToProject.getUid(),
                    userToProject.getPid(),
                    userToProject.getValue());
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
        this.renderResult("添加项目成员成功");
    }

    /**
     * query a project`s member info
     * @param projectId
     * @param baseQuery
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/project/{projectId}/members", method = RequestMethod.GET)
    @ApiOperation(value = "查询项目的成员", notes = "用于查看项目的成员", httpMethod = "GET",
        response = ApiResult.class)
    @ApiImplicitParam(name = "projectId",value = "项目id",required = true,dataType = "Integer",paramType = "path")
    @AuthorityCheck
    public void queryProjectUsers(@PathVariable Integer projectId, BaseQuery baseQuery)
            throws ApiBusinessException{
        DataPage<EtProjectUser> page = new DataPage<EtProjectUser>();
        page.setOffsetLimit(baseQuery.getOffset(), baseQuery.getLimit());
        Conditions conditions = new Conditions();
        conditions.addCondition("etProject.id", projectId, Conditions.Operator.EQUAL);
        try {
            serviceManager.getProjectUserService().page(page, conditions);
            ApiPageData apd = new ApiPageData(page.getRows(), page.getLimit(), page.getOffset(), ProjectUser.getPUs(page.getData()));
            this.renderResult("查询项目成员成功", apd);
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new ApiBusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }

    }

    /**
     * query a member`s info
     * @param projectId
     * @param userId
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/project/{projectId}/member/{userId}", method = RequestMethod.GET)
    @ApiOperation(value = "查询某个项目成员信息", notes = "用户查看某个项目中某个成员的信息",
            httpMethod = "GET", response = ApiResult.class)
    @ApiImplicitParams({@ApiImplicitParam(name="projectId",value = "项目id",required = true,dataType = "Integer",paramType = "path"),
            @ApiImplicitParam(name = "userId",value = "用户id",required = true,dataType = "Integer",paramType = "path")})
    @AuthorityCheck
    public void qureyProjectSingleUser(@PathVariable Integer projectId,
                                       @PathVariable Integer userId) throws ApiBusinessException{
        try {
            EtProjectUser pu = serviceManager.getProjectUserService().queryByPidAndUid(projectId, userId);
            if(pu != null){
                ProjectUser projectUser = new ProjectUser(pu);
                this.renderResult("查询项目成员信息成功", projectUser);
            }else{
                throw new ApiBusinessException(ExceptionEnum.PROJECT_MEMBER_QUERY_NOTEXIST);
            }

        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new ApiBusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
    }
}
