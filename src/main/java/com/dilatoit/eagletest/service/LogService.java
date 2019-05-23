package com.dilatoit.eagletest.service;


import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtLog;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;

import java.util.List;

/**
 * Created by xueshan.wei on 11/14/2016.
 */
public interface LogService {
    /**
     * save a log
     * @param log
     * @throws DataBaseException
     */
    public void save(EtLog log) throws DataBaseException;

    /**
     * delete a log
     * @param log
     * @throws DataBaseException
     */
    public void delete(EtLog log) throws DataBaseException;

    /**
     * query all log
     * @return
     * @throws DataBaseException
     */
    public List<EtLog> queryAll() throws DataBaseException;

    /**
     * query log by page
     * @param page
     * @throws DataBaseException
     */
    public void page(DataPage<EtLog> page) throws BusinessException;

    /**
     * query log by page and conditions
     * @param page
     * @param conditions
     * @throws DataBaseException
     */
    public void page(DataPage<EtLog> page, Conditions conditions) throws BusinessException;
}
