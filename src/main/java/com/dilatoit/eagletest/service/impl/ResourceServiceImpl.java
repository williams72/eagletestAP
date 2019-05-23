package com.dilatoit.eagletest.service.impl;


import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtResource;
import com.dilatoit.eagletest.service.ResourceService;
import org.springframework.stereotype.Service;

/**
 * Created by beishan on 2016/11/13.
 */
@Service("resourceService")
public class ResourceServiceImpl extends BaseService<EtResource> implements ResourceService {
    public EtResource queryById(Integer id) throws DataBaseException {
        return (EtResource) baseDAO.queryById(com.dilatoit.eagletest.model.EtResource.class, id);
    }
}
