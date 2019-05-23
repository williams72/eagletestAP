package com.dilatoit.eagletest.service.impl;

import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.enums.ProjectUserRole;
import com.dilatoit.eagletest.enums.common.ModelActive;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtProject;
import com.dilatoit.eagletest.model.EtUser;
import com.dilatoit.eagletest.query.model.ProjectQuery;
import com.dilatoit.eagletest.service.ProjectService;
import com.dilatoit.eagletest.service.ProjectUserService;
import com.dilatoit.eagletest.service.UserService;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;
import com.dilatoit.eagletest.validate.api.UpdateProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by beishan on 2016/11/13.
 */
@Service("projectService")
public class ProjectServiceImpl extends BaseService<EtProject> implements ProjectService {
    @Autowired
    private UserService userService;
    @Autowired
    private ProjectUserService projectUserService;

    public List<EtProject> querySomeProjects(ProjectQuery projectQuery) throws BusinessException {
        Conditions conditions = new Conditions();
        conditions.addCondition("active", ModelActive.ACTIVE.value(), Conditions.Operator.EQUAL);
        if(projectQuery.getName() != null){
            conditions.addCondition("projectName", projectQuery.getName(), Conditions.Operator.EQUAL);
        }
        if(projectQuery.getKey() != null){
            conditions.addCondition("projectKey", projectQuery.getKey(), Conditions.Operator.EQUAL);
        }
        try{
            return queryAllByConditions(conditions);
        }catch (DataBaseException dbe){
            throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
    }

    public List<EtProject> querySomeProject(List<String> ids) throws DataBaseException {
        List<EtProject> ps = new ArrayList<EtProject>();
        if(ids != null){
            EtProject temp = null;
            for(String id : ids){
                temp = this.queryById(Integer.parseInt(id));
                ps.add(temp);
            }
            return ps;
        }
        return null;
    }

    public List<EtProject> queryAll() throws DataBaseException {
        return baseDAO.queryAll(com.dilatoit.eagletest.model.EtProject.class);
    }

    public List<EtProject> queryAllByConditions(Conditions conditions) throws DataBaseException {
        conditions.addCondition("active", ModelActive.ACTIVE.value(), Conditions.Operator.EQUAL);
        return baseDAO.queryByConditions(com.dilatoit.eagletest.model.EtProject.class, conditions);
    }

    public Integer addProject(EtProject project, Integer userId) throws BusinessException {
        //新建项目
        //查询项目名称和key是否重复
        try{
            EtProject existProjectByName = isExistByProjectName(project.getProjectName());
            EtProject existProjectBykey = isExistByProjectKey(project.getProjectKey());
            if(existProjectByName != null){
                throw new BusinessException(ExceptionEnum.PROJECT_CREATE_NAMEEXIST);
            }
            if(existProjectBykey != null){
                throw new BusinessException(ExceptionEnum.PROJECT_CREATE_KEYEXIST);
            }

            //查询要设置为管理员的用户是否存在
            EtUser user = userService.isExistById(userId);
            if(user == null){
                throw new BusinessException(ExceptionEnum.PROJECT_CREATE_USERNOTEXSIT);
            }
            //设置项目内容
            project.setCreateTime(new Date());
            project.setActive(ModelActive.ACTIVE.value());
            //保存项目
            Integer projectId = addProject(project);

            //设置项目拥有者
            projectUserService.addUser(projectId, userId, ProjectUserRole.ADMIN);
            return projectId;
        }catch (DataBaseException dbe){
            throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }


    }

    private Integer addProject(EtProject project) throws DataBaseException, BusinessException{
        if(project != null){
            return baseDAO.save(project);
        }
        throw new BusinessException(ExceptionEnum.NUll_OBJECT_ERROR);
    }

    public void deleteProject(Integer projectId) throws BusinessException {
        EtProject projectCheck = null;
        try {
            projectCheck = queryById(projectId);
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
        if(projectCheck != null){
            try {
                //baseDAO.delete(projectCheck);
                projectCheck.setActive(ModelActive.ACTIVE.value());
                baseDAO.update(projectCheck);
            } catch (DataBaseException e) {
                e.printStackTrace();
                throw new BusinessException(ExceptionEnum.DB_DELETE_RESULT_ERROR);
            }
        }else{
            throw new BusinessException(ExceptionEnum.PROJECT_NOT_FOUND);
        }
    }

    public void page(DataPage<EtProject> page) throws DataBaseException, BusinessException {
        Conditions conditions = new Conditions();
        page(page, conditions);
    }

    public void page(DataPage<EtProject> page, Conditions conditions) throws DataBaseException, BusinessException {
        conditions.addCondition("active", ModelActive.ACTIVE.value(), Conditions.Operator.EQUAL);
        conditions.addOrderBy("id",false);
        baseDAO.page(page, com.dilatoit.eagletest.model.EtProject.class, conditions);
    }

    public void addUser(Integer projectId, Integer userId, ProjectUserRole projectUserRole) throws DataBaseException, BusinessException {
        projectUserService.addUser(projectId, userId, projectUserRole);
    }

    public void removeUser(Integer projectId, Integer userId) throws DataBaseException {
        EtProject project = queryById(projectId);

    }

    public EtProject queryById(Integer projectId) throws DataBaseException {
        return (EtProject) this.baseDAO.queryById(com.dilatoit.eagletest.model.EtProject.class, projectId);
    }

    public EtProject isExistByProjectName(String projectName) throws DataBaseException {
        EtProject project = null;
        Conditions conditions = new Conditions();
        conditions.addCondition("projectName", projectName, Conditions.Operator.EQUAL);
        List<EtProject> list = queryAllByConditions(conditions);
        if(list != null && list.size() > 0){
            project = list.get(0);
        }
        return project;
    }

    public EtProject isExistByProjectKey(String projectKey) throws DataBaseException {
        EtProject project = null;
        Conditions conditions = new Conditions();
        conditions.addCondition("projectKey", projectKey, Conditions.Operator.EQUAL);
        List<EtProject> list = queryAllByConditions(conditions);
        if(list != null && list.size() > 0){
            project = list.get(0);
        }
        return project;
    }

    public EtProject isExistByProjectNameAndKey(String projectName, String projectKey) throws DataBaseException {
        EtProject project = null;
        Conditions conditions = new Conditions();
        conditions.addCondition("projectName", projectName, Conditions.Operator.EQUAL);
        conditions.addCondition("projectKey", projectKey, Conditions.Operator.EQUAL);
        List<EtProject> list = queryAllByConditions(conditions);
        if(list != null && list.size() > 0){
            project = list.get(0);
        }
        return project;
    }

    public EtProject updateProject(Integer projectId, UpdateProject updateProject) throws BusinessException {
        //判断要修改的项目是否存在
        EtProject projectCheck = null;
        try {
            projectCheck = queryById(projectId);

            if(projectCheck != null){
                projectCheck.setProjectName(updateProject.getName());
                projectCheck.setProjectKey(updateProject.getKey());
                projectCheck.setProjectIntro(updateProject.getDesc());

                baseDAO.update(projectCheck);
            }else{
                throw new BusinessException(ExceptionEnum.PROJECT_NOT_FOUND);
            }
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
        return projectCheck;
    }
}
