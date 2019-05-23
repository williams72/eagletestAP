package com.dilatoit.eagletest.service;


import com.dilatoit.eagletest.enums.ProjectUserRole;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtProjectUser;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;

import java.util.List;

/**
 * Created by beishan on 2016/11/23.
 */
public interface ProjectUserService {

    /**
     * 向一个项目添加成员
     * @param currentUserId 当前的操作人id
     * @param userId 要加入项目的成员的id
     * @param projectId 要加入的项目的id
     * @param roleValue 要加入的项目的用户的角色
     * @throws BusinessException
     */
    void addMember(Integer currentUserId, Integer userId, Integer projectId, Integer roleValue) throws BusinessException;
    /**
     * add a user to project
     * @param projectId
     * @param userId
     * @param projectUserRole
     * @throws DataBaseException
     * @throws BusinessException
     */
    public void addUser(Integer projectId, Integer userId, ProjectUserRole projectUserRole) throws DataBaseException, BusinessException;

    /**
     * remove a user from project
     * @param projectId
     * @param userId
     * @throws DataBaseException
     * @throws BusinessException
     */
    public void removeUser(Integer projectId, Integer userId) throws DataBaseException, BusinessException;

    /**
     * change a user`s role in project
     * @param projectId
     * @param userId
     * @param projectUserRole
     * @throws DataBaseException
     * @throws BusinessException
     */
    public void changeRole(Integer projectId, Integer userId, ProjectUserRole projectUserRole) throws DataBaseException, BusinessException;

    /**
     * query page
     * @param page
     * @throws DataBaseException
     */
    public void page(DataPage<EtProjectUser> page) throws DataBaseException;

    /**
     * query page by conditions
     * @param page
     * @param conditions
     * @throws DataBaseException
     */
    public void page(DataPage<EtProjectUser> page, Conditions conditions) throws DataBaseException;

    List<EtProjectUser> queryAllProjectUserByUserId(Integer userId);
    /**
     * query projectUser by pid and uid
     * @param projectId
     * @param userId
     * @return
     * @throws DataBaseException
     */
    EtProjectUser queryByPidAndUid(Integer projectId, Integer userId) throws DataBaseException;

    /**
     * query project all member by project id
     * @param projectId
     * @return
     * @throws BusinessException
     */
    List<EtProjectUser> queryAllMemberByPid(Integer projectId) throws BusinessException;
}
