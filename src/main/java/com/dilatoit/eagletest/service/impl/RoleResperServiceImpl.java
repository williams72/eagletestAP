package com.dilatoit.eagletest.service.impl;

import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtResPer;
import com.dilatoit.eagletest.model.EtRole;
import com.dilatoit.eagletest.model.EtRoleResper;
import com.dilatoit.eagletest.service.RoleResperService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by beishan on 2016/12/5.
 */
@Service("roleResperService")
public class RoleResperServiceImpl extends BaseService<EtRoleResper> implements RoleResperService {
    public Integer addRoleResper(Integer roleId, Integer resPerId) throws DataBaseException {
        EtRole role = new EtRole();
        role.setId(roleId);

        EtResPer resPer = new EtResPer();
        resPer.setId(resPerId);

        EtRoleResper roleResper = new EtRoleResper();
        roleResper.setEtRole(role);
        roleResper.setEtResPer(resPer);

        return baseDAO.save(roleResper);
    }

    public EtRoleResper queryById(Integer id) throws DataBaseException {
        return (EtRoleResper) baseDAO.queryById(com.dilatoit.eagletest.model.EtRoleResper.class, id);
    }

    public List<EtRoleResper> queryAll() throws DataBaseException {
        return baseDAO.queryAll(com.dilatoit.eagletest.model.EtRoleResper.class);
    }
}
