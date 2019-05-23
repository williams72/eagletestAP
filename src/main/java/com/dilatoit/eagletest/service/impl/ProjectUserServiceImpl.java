package com.dilatoit.eagletest.service.impl;


import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.enums.ProjectUserRole;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtProject;
import com.dilatoit.eagletest.model.EtProjectUser;
import com.dilatoit.eagletest.model.EtUser;
import com.dilatoit.eagletest.service.ProjectUserService;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by beishan on 2016/11/23.
 */
@Service("projectUserService")
public class ProjectUserServiceImpl extends BaseService<EtProjectUser> implements ProjectUserService {

    @Override
    public List<EtProjectUser> queryAllProjectUserByUserId(Integer userId) {
        Conditions conditions = new Conditions();
        conditions.addCondition("etUser.id", userId, Conditions.Operator.EQUAL);
        try {
            return baseDAO.queryByConditions(EtProjectUser.class, conditions);
        } catch (DataBaseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addMember(Integer currentUserId, Integer userId, Integer projectId, Integer roleValue) throws BusinessException {
        EtProjectUser currentPU = null; //当前要执行添加成员操作的用户在要添加的项目中的身份
        EtProjectUser aimPU = null; //要添加到目标项目的目标成员身份，主要用于检查该用户是否已经在目标项目中
        try {
            currentPU = queryByPidAndUid(projectId, currentUserId);
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new BusinessException(e.getEe());
        }
        if(currentPU != null && currentPU.getProjectRole().intValue() == ProjectUserRole.ADMIN.value()){
            //查询目标用户是否已经是项目成员，避免重复添加
            try {
                aimPU = queryByPidAndUid(projectId, userId);
            } catch (DataBaseException e) {
                e.printStackTrace();
                throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
            }
            if(aimPU != null){
                //该用户已经加入该项目了，不能重复添加
                throw new BusinessException(ExceptionEnum.PROJECT_MEMBER_ADD_EXIST);
            }
            ProjectUserRole projectUserRole = ProjectUserRole.getProjectUserRole(roleValue);
            if(projectUserRole == null){
                //用户角色值错误
                throw new BusinessException(ExceptionEnum.PROJECT_MEMBER_ADD_ROLEVALUE_ERROR);
            }else{
                try {
                    addUser(projectId, userId, projectUserRole);
                } catch (DataBaseException e) {
                    e.printStackTrace();
                    throw new BusinessException(e.getEe());
                }
            }
        }else{
            //该用户没有权限增加用户
            throw new BusinessException(ExceptionEnum.PROJECT_MEMBER_ADD_NOPERMISSION);
        }
    }

    public void addUser(Integer projectId, Integer userId, ProjectUserRole projectUserRole) throws DataBaseException, BusinessException {
        EtProjectUser projectUser = new EtProjectUser();
        EtProject project = new EtProject();
        project.setId(projectId);
        EtUser user = new EtUser();
        user.setId(userId);
        projectUser.setEtUser(user);
        projectUser.setEtProject(project);
        projectUser.setProjectRole(projectUserRole.value());

        this.baseDAO.save(projectUser);

    }

    public void removeUser(Integer projectId, Integer userId) throws DataBaseException, BusinessException {
        EtProjectUser projectUser = queryByPidAndUid(projectId, userId);
        if(projectUser != null){
            baseDAO.delete(projectUser);
        }
    }

    public void changeRole(Integer projectId, Integer userId, ProjectUserRole projectUserRole) throws DataBaseException, BusinessException {
        EtProjectUser projectUser = queryByPidAndUid(projectId, userId);
        projectUser.setProjectRole(projectUserRole.value());
        baseDAO.update(projectUser);
    }

    public void page(DataPage<EtProjectUser> page) throws DataBaseException {
        Conditions conditions = new Conditions();
        page(page, conditions);
    }

    public void page(DataPage<EtProjectUser> page, Conditions conditions) throws DataBaseException {
        baseDAO.page(page, com.dilatoit.eagletest.model.EtProjectUser.class, conditions);
    }

    public EtProjectUser queryByConditions(Conditions conditions) throws DataBaseException{
        List<EtProjectUser> list = baseDAO.queryByConditions(com.dilatoit.eagletest.model.EtProjectUser.class, conditions);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    public EtProjectUser queryByPidAndUid(Integer projectId, Integer userId) throws DataBaseException{
        Conditions conditions = new Conditions();
        conditions.addCondition("etProject.id", projectId, Conditions.Operator.EQUAL);
        conditions.addCondition("etUser.id", userId, Conditions.Operator.EQUAL);
        return queryByConditions(conditions);
    }

    public List<EtProjectUser> queryAllMemberByPid(Integer projectId) throws BusinessException {
        Conditions conditions = new Conditions();
        conditions.addCondition("etProject.id", projectId, Conditions.Operator.EQUAL);
        try {
            return baseDAO.queryByConditions(EtProjectUser.class, conditions);
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
    }
}
