package com.dilatoit.eagletest.service;

import com.dilatoit.eagletest.enums.ProjectUserRole;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtProject;
import com.dilatoit.eagletest.query.model.ProjectQuery;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;
import com.dilatoit.eagletest.validate.api.UpdateProject;

import java.util.List;


/**
 * Created by beishan on 2016/11/13.
 */
public interface ProjectService {
    /**
     * query some projects by projectQuery
     * @param projectQuery
     * @return
     * @throws BusinessException
     */
    List<EtProject> querySomeProjects(ProjectQuery projectQuery) throws BusinessException;
    /**
     *
     * @param ids
     * @return
     * @throws DataBaseException
     */
    List<EtProject> querySomeProject(List<String> ids) throws DataBaseException;
    /**
     * query all project
     * @return
     * @throws DataBaseException
     */
    List<EtProject> queryAll() throws DataBaseException;

    /**
     * query all by conditions
     * @param conditions
     * @return
     * @throws DataBaseException
     */
    List<EtProject> queryAllByConditions(Conditions conditions) throws DataBaseException;
    /**
     * add a project
     * @param project
     * @throws DataBaseException
     * @throws BusinessException
     */
    Integer addProject(EtProject project, Integer userId) throws BusinessException;

    /**
     * delete a user
     * @param projectId
     * @throws DataBaseException
     * @throws BusinessException
     */
    void deleteProject(Integer projectId) throws BusinessException;

    /**
     * query by page
     * @param page
     * @throws DataBaseException
     * @throws BusinessException
     */
    void page(DataPage<EtProject> page) throws DataBaseException, BusinessException;

    /**
     * query page by conditions
     * @param page
     * @throws DataBaseException
     * @throws BusinessException
     */
    void page(DataPage<EtProject> page, Conditions conditions) throws DataBaseException, BusinessException;

    /**
     * add a user to project
     * @param userId
     * @param projectUserRole
     * @throws DataBaseException
     * @throws BusinessException
     */
    void addUser(Integer projectId, Integer userId, ProjectUserRole projectUserRole) throws DataBaseException, BusinessException;

    /**
     * remove a user in project
     * @param projectId
     * @param userId
     * @throws DataBaseException
     */
    void removeUser(Integer projectId, Integer userId) throws DataBaseException;
    /**
     * query project by id
     * @param projectId
     * @return
     * @throws DataBaseException
     */
    EtProject queryById(Integer projectId) throws DataBaseException;

    /**
     * query a project is exist by project name
     * @param projectName
     * @return
     * @throws DataBaseException
     */
    EtProject isExistByProjectName(String projectName) throws DataBaseException;

    /**
     * query a project is exist by project key
     * @param projectKey
     * @return
     * @throws DataBaseException
     */
    EtProject isExistByProjectKey(String projectKey) throws DataBaseException;

    /**
     * query a project is exist by project name and key
     * @param projectName
     * @param projectKey
     * @return
     * @throws DataBaseException
     */
    EtProject isExistByProjectNameAndKey(String projectName, String projectKey) throws DataBaseException;

    /**
     * update project
     * @param updateProject
     * @return
     * @throws BusinessException
     */
    EtProject updateProject(Integer projectId, UpdateProject updateProject) throws BusinessException;
}
