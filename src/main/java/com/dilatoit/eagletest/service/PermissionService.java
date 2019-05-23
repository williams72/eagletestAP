package com.dilatoit.eagletest.service;


import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtPermission;

/**
 * Created by beishan on 2016/11/13.
 */
public interface PermissionService {
    /**
     * query by id
     * @param id
     * @return
     * @throws DataBaseException
     */
    EtPermission queryById(Integer id) throws DataBaseException;
}
