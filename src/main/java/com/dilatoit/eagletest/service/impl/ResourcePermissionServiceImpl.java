package com.dilatoit.eagletest.service.impl;

import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtPermission;
import com.dilatoit.eagletest.model.EtResPer;
import com.dilatoit.eagletest.model.EtResource;
import com.dilatoit.eagletest.service.PermissionService;
import com.dilatoit.eagletest.service.ResourcePermissionService;
import com.dilatoit.eagletest.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by beishan on 2016/12/5.
 */
@Service("resourcePermissionService")
public class ResourcePermissionServiceImpl extends BaseService<EtResPer> implements ResourcePermissionService {
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private PermissionService permissionService;

    public Integer addResourcePermission(Integer resourceId, Integer permissionId) throws DataBaseException {
        EtResource resource = resourceService.queryById(resourceId);

        EtPermission permission = permissionService.queryById(permissionId);

        EtResPer resPer = new EtResPer();
        resPer.setEtResource(resource);
        resPer.setEtPermission(permission);
        resPer.setResourcePermission(resource.getResourceName() + ":" + permission.getPermissionStr());

        return baseDAO.save(resPer);
    }

    public List<EtResPer> queryAll() throws DataBaseException {
        return baseDAO.queryAll(com.dilatoit.eagletest.model.EtResPer.class);
    }
}
