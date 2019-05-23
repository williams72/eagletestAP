package com.dilatoit.eagletest.service.impl;

import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtLog;
import com.dilatoit.eagletest.service.LogService;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xueshan.wei on 11/14/2016.
 */
@Service("logService")
public class LogServiceImpl extends BaseService<EtLog> implements LogService {
    public void save(EtLog log) throws DataBaseException {
        this.baseDAO.save(log);
    }

    public void delete(EtLog log) throws DataBaseException {
        this.baseDAO.delete(log);
    }

    public List<EtLog> queryAll() throws DataBaseException {
        return this.baseDAO.queryAll(com.dilatoit.eagletest.model.EtLog.class);
    }

    public void page(DataPage<EtLog> page) throws BusinessException {
        Conditions conditions = new Conditions();
        conditions.addOrderBy("id", false);
        this.page(page, conditions);
    }

    public void page(DataPage<EtLog> page, Conditions conditions) throws BusinessException {
        try{
            baseDAO.page(page, com.dilatoit.eagletest.model.EtLog.class, conditions);
        }catch(DataBaseException dbe){
            throw new BusinessException(ExceptionEnum.DB_QUERY_PAGE_ERROR);
        }
    }
}
