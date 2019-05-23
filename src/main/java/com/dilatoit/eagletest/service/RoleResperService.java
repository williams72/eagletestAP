package com.dilatoit.eagletest.service;


import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtRoleResper;

import java.util.List;

/**
 * Created by beishan on 2016/12/5.
 */
public interface RoleResperService {
    /**
     * add role resper
     * @param roleId
     * @param resPerId
     * @return
     * @throws DataBaseException
     */
    Integer addRoleResper(Integer roleId, Integer resPerId) throws DataBaseException;

    /**
     * query by id
     * @param id
     * @return
     * @throws DataBaseException
     */
    EtRoleResper queryById(Integer id) throws DataBaseException;

    /**
     * query all
     * @return
     * @throws DataBaseException
     */
    List<EtRoleResper> queryAll() throws DataBaseException;
}
