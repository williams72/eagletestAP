package com.dilatoit.eagletest.service.impl;

import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtRole;
import com.dilatoit.eagletest.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * Created by beishan on 2016/11/13.
 */
@Service("roleService")
public class RoleServiceImpl extends BaseService<EtRole> implements RoleService {
    public void save(EtRole role) throws Exception {
        this.baseDAO.save(role);
    }

    public void queryAll() throws Exception {
        this.baseDAO.queryAll(com.dilatoit.eagletest.model.EtRole.class);
    }

    public EtRole queryRoleById(Integer roleId) throws DataBaseException {
        try {
            return (EtRole) this.baseDAO.queryById(com.dilatoit.eagletest.model.EtRole.class, roleId);
        }catch (Exception e){
            throw new DataBaseException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
    }
}
