package com.dilatoit.eagletest.service;

import com.dilatoit.eagletest.api.model.Version;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtVersion;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;

import java.util.List;


/**
 * Created by beishan on 2016/11/13.
 */
public interface VersionService {
    /**
     * query page
     * @param page
     * @throws DataBaseException
     */
    public void page(DataPage<EtVersion> page) throws DataBaseException;

    /**
     * query page by conditions
     * @param page
     * @param conditions
     * @throws DataBaseException
     */
    public void page(DataPage<EtVersion> page, Conditions conditions) throws DataBaseException;

    /**
     * create version
     * @param version
     * @param projectId
     * @return
     * @throws DataBaseException
     */
    public Integer addVersion(EtVersion version, Integer projectId) throws BusinessException;

    /**
     *
     * @param projectId
     * @return
     * @throws DataBaseException
     */
    public List<EtVersion> queryAllByProId(Integer projectId) throws DataBaseException;

    /**
     * change version status
     * @param versionId
     * @param status
     * @throws DataBaseException
     * @throws BusinessException
     */
    void changeVersionStatus(Integer versionId, Integer status) throws DataBaseException, BusinessException;

    /**
     * query a version by versionId
     * @param versionId
     * @return
     * @throws BusinessException
     */
    EtVersion queryVersionById(Integer versionId) throws BusinessException;

    /**
     * query a version by version name
     * @param versionName
     * @return
     * @throws BusinessException
     */
    EtVersion queryVersionByPidAndName(int pid, String versionName) throws BusinessException;
}
