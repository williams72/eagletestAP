package com.dilatoit.eagletest.api.project;

import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.annotation.SystemControllerLog;
import com.dilatoit.eagletest.api.model.ApiPageData;
import com.dilatoit.eagletest.api.base.BaseController;
import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.enums.log.SystemLog;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.exception.ex.api.ApiBusinessException;
import com.dilatoit.eagletest.exception.ex.api.ApiParameterException;
import com.dilatoit.eagletest.model.EtProject;
import com.dilatoit.eagletest.query.model.BaseQuery;
import com.dilatoit.eagletest.query.model.ProjectQuery;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;
import com.dilatoit.eagletest.validate.api.ApiResult;
import com.dilatoit.eagletest.validate.api.AddProject;
import com.dilatoit.eagletest.validate.api.UpdateProject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by xueshan.wei on 2/8/2017.
 */
@Api(value = "/project", description = "项目相关")
@Controller(value = "apiProjectController")
@RequestMapping("/api")
@Scope("prototype")
public class ProjectController extends BaseController {
    @RequestMapping(value = "/project/{projectId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除项目", notes = "用于删除一个项目",
            httpMethod = "DELETE", response = ApiResult.class)
    @ApiImplicitParam(name = "projectId", value = "项目id", required = true, dataType = "Integer", paramType = "path")
    @AuthorityCheck(permission = "project:delete")
    @SystemControllerLog(systemLog = SystemLog.PROJECT_DELETE)
    public void deleteProject(@PathVariable Integer projectId) throws ApiBusinessException {
        try {
            serviceManager.getProjectService().deleteProject(projectId);
            this.renderResult("删除项目成功");
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
    }

    @RequestMapping(value = "/project/{projectId}", method = RequestMethod.PUT)
    @ApiOperation(value = "修改项目信息", notes = "用于修改项目的一些信息，name、key、desc",
            httpMethod = "PUT", response = ApiResult.class)
    @ApiImplicitParam(name = "projectId", value = "项目id", required = true, dataType = "Integer", paramType = "path")
    @AuthorityCheck(permission = "project:update")
    @SystemControllerLog(systemLog = SystemLog.PROJECT_UPDATE)
    public void updateProject(@PathVariable Integer projectId, @Valid @RequestBody UpdateProject updateProject) throws ApiBusinessException {
        try {
            EtProject project = serviceManager.getProjectService().updateProject(projectId, updateProject);
            this.renderResult("更新项目信息成功", project);
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
    }

    /**
     * 分页查询项目
     *
     * @param baseQuery
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询多个项目信息", notes = "用于分页查询多个项目信息",
            httpMethod = "GET", response = ApiResult.class)
    @AuthorityCheck
    public void queryProjectPage(BaseQuery baseQuery) throws ApiBusinessException {
        DataPage<EtProject> page = new DataPage<EtProject>();
        page.setOffsetLimit(baseQuery.getOffset(), baseQuery.getLimit());
        Conditions conditions = new Conditions();
        conditions.addOrderBy("createTime", false);
        try {
            serviceManager.getProjectService().page(page, conditions);
            ApiPageData apiPageData = new ApiPageData(page.getRows(), page.getLimit(),
                    page.getOffset(), page.getData());
            this.renderResult("分页查询项目信息成功", apiPageData);
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new ApiBusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
    }

    /**
     * 查询单个项目
     *
     * @param projectId
     * @throws BusinessException
     */
    @RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET)
    @ApiOperation(value = "查询某个项目", response = ApiResult.class, httpMethod = "GET", notes = "返回单个项目的信息")
    @ApiImplicitParam(name = "projectId", value = "项目id", required = true, dataType = "Integer", paramType = "path")
    @AuthorityCheck
    public void querySingleProject(@PathVariable Integer projectId) throws ApiBusinessException {
        try {
            EtProject project = serviceManager.getProjectService().queryById(projectId);
            if (project == null) {
                throw new ApiBusinessException(ExceptionEnum.PROJECT_NOT_FOUND);
            }
            this.renderResult("查询单个项目信息成功", project);
        } catch (DataBaseException dbe) {
            throw new ApiBusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
    }

    /**
     * 条件查询项目
     *
     * @param projectQuery
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/projects/query", method = RequestMethod.GET)
    @ApiOperation(value = "条件查询项目", response = ApiResult.class, httpMethod = "GET", notes = "返回查询到的项目数组")
    @AuthorityCheck
    public void queryProjects(ProjectQuery projectQuery) throws ApiBusinessException {
        List<EtProject> projects = null;
        try {
            projects = serviceManager.getProjectService().querySomeProjects(projectQuery);
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
        apiResult.reset();
        apiResult.setApiResult("查询多个项目信息成功", projects);
        renderObj(apiResult);
    }

    /**
     * add a new project
     *
     * @param addProject
     * @param bindingResult
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/project", method = RequestMethod.POST)
    @ApiOperation(value = "增加一个项目", notes = "用于增加一个项目", httpMethod = "POST", response = ApiResult.class)
    //@ApiImplicitParam(value = "新增项目实体", name = "addProject", dataType = "AddProject")
    @SystemControllerLog(systemLog = SystemLog.PROJECT_CREATE)
    @AuthorityCheck(permission = "project:add")
    public void addProject(@Valid @RequestBody AddProject addProject, BindingResult bindingResult) throws ApiBusinessException {
        if (bindingResult.hasErrors()) {
            throw new ApiParameterException(ExceptionEnum.PARAM_ERROR, bindingResult);
        } else {
            EtProject project = new EtProject();
            project.setProjectName(addProject.getName());
            project.setProjectKey(addProject.getKey());
            project.setProjectType(addProject.getType());
            project.setProjectIntro(addProject.getDesc());
            System.out.println(project.toString());
            try {
                Integer newProjectId = serviceManager.getProjectService().addProject(project, addProject.getAdminId());
                project = serviceManager.getProjectService().queryById(newProjectId);
                renderResult("新建项目成功", project);
            } catch (DataBaseException e) {
                e.printStackTrace();
                throw new ApiBusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
            } catch (BusinessException e) {
                e.printStackTrace();
                throw new ApiBusinessException(e.getEe());
            }
        }
    }

    /**
     * 查询所有项目name-Key
     *
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/allprojects", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有项目", response = ApiResult.class, httpMethod = "GET", notes = "返回所有项目信息")
    @AuthorityCheck
    public void queryAllProjects() throws ApiBusinessException {
        List<EtProject> etProjectList;
        try {
            etProjectList = serviceManager.getProjectService().queryAll();
            renderResult("查询所有项目成功", etProjectList);
        } catch (DataBaseException e) {
            e.printStackTrace();
        }
    }
}
