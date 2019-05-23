package com.dilatoit.eagletest.service;

import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtResource;

/**
 * Created by beishan on 2016/11/13.
 */
public interface ResourceService {
    /**
     * query by id
     * @param id
     * @return
     * @throws DataBaseException
     */
    EtResource queryById(Integer id) throws DataBaseException;
}
