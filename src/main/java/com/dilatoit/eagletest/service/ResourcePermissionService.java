package com.dilatoit.eagletest.service;

import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtResPer;

import java.util.List;

/**
 * Created by beishan on 2016/12/5.
 */
public interface ResourcePermissionService {
    /**
     * add a resource permission
     * @param resourceId
     * @param permissionId
     * @return
     * @throws DataBaseException
     */
    Integer addResourcePermission(Integer resourceId, Integer permissionId) throws DataBaseException;

    /**
     * query all resource permission
     * @return
     * @throws DataBaseException
     */
    List<EtResPer> queryAll() throws DataBaseException;
}
