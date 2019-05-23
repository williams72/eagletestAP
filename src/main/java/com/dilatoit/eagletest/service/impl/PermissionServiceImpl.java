package com.dilatoit.eagletest.service.impl;

import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtPermission;
import com.dilatoit.eagletest.service.PermissionService;
import org.springframework.stereotype.Service;

/**
 * Created by beishan on 2016/11/13.
 */
@Service("permissionService")
public class PermissionServiceImpl extends BaseService<EtPermission> implements PermissionService {
    public EtPermission queryById(Integer id) throws DataBaseException {
        return (EtPermission) baseDAO.queryById(com.dilatoit.eagletest.model.EtPermission.class, id);
    }
}
