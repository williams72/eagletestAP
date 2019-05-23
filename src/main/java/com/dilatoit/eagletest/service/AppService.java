package com.dilatoit.eagletest.service;



import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtApp;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;
import com.dilatoit.engine.exception.EngineException;

import java.io.File;
import java.util.List;


/**
 * Created by beishan on 2016/11/13.
 */
public interface AppService {
    /**
     * query a app by id
     * @param id
     * @return
     * @throws DataBaseException
     */
    EtApp queryById(Integer id) throws DataBaseException;

    /**
     * query a app by versionId and appName
     * @param versionId
     * @param appName
     * @return
     * @throws DataBaseException
     */
    EtApp queryByVersionIdAndName(int versionId,String appName)throws DataBaseException;
    /**
     * query apps by conditions
     * @param conditions
     * @return
     * @throws DataBaseException
     */
    List<EtApp> queryByConditions(Conditions conditions) throws DataBaseException;
    /**
     * query all apps
     * @return
     * @throws DataBaseException
     */
    List<EtApp> queryAll() throws DataBaseException;
    /**
     * query page
     * @param page
     * @throws DataBaseException
     */
    void page(DataPage<EtApp> page) throws DataBaseException;

    /**
     * query page by conditions
     * @param page
     * @param conditions
     * @throws DataBaseException
     */
    void page(DataPage<EtApp> page, Conditions conditions) throws DataBaseException;

    /**
     *
     * @return
     * @throws EngineException
     * @throws DataBaseException
     * @throws BusinessException
     */
    Integer addApp(EtApp app, File file, String fileType) throws EngineException, DataBaseException;

    /**
     *
     * @param app
     * @throws DataBaseException
     */
    void updateApp(EtApp app) throws DataBaseException;

    /**
     *
     * @param appId
     * @param newVisibility
     * @throws BusinessException
     */
    void changeVisibility(Integer appId, Integer newVisibility) throws BusinessException;
}
