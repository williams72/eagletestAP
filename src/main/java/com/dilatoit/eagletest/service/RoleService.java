package com.dilatoit.eagletest.service;

import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtRole;

/**
 * Created by beishan on 2016/11/13.
 */
public interface RoleService {
    /**
     * save a role entity
     * @param role
     * @throws Exception
     */
    public void save(EtRole role) throws Exception;

    /**
     * query all user
     * @throws Exception
     */
    public void queryAll() throws Exception;

    /**
     * query role by roleId
     * @param roleId
     * @throws Exception
     */
    public EtRole queryRoleById(Integer roleId) throws DataBaseException;
}
