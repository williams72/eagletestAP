package com.dilatoit.eagletest.service.impl;


import com.dilatoit.eagletest.config.WeaknetConfig;
import com.dilatoit.eagletest.dto.WeaknetDTO;
import com.dilatoit.eagletest.dto.translate.WeaknetDTOTranslate;
import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.enums.common.ModelFiledBooleanEnum;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtWeaknet;
import com.dilatoit.eagletest.service.WeaknetService;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by xueshan.wei on 4/14/2017.
 */
@Service("weaknetService")
public class WeaknetServiceImpl extends BaseService<EtWeaknet> implements WeaknetService {
    @Autowired
    private WeaknetConfig weaknetConfig;

    @Override
    public void changeAvailability(Integer wnid, boolean availability) throws DataBaseException, BusinessException {
        EtWeaknet weaknet = (EtWeaknet) baseDAO.queryById(com.dilatoit.eagletest.model.EtWeaknet.class, wnid);
        if(weaknet == null){
            throw new BusinessException(ExceptionEnum.QUERY_ENTITY_NOT_FOUND);
        }
        weaknet.setEnable(availability ? ModelFiledBooleanEnum.TRUE.value() : ModelFiledBooleanEnum.FALSE.value());

        baseDAO.update(weaknet);
    }

    @Override
    public void delete(Integer wnid) throws DataBaseException, BusinessException {
        EtWeaknet weaknet = (EtWeaknet) baseDAO.queryById(com.dilatoit.eagletest.model.EtWeaknet.class, wnid);
        if(weaknet == null){
            throw new BusinessException(ExceptionEnum.QUERY_ENTITY_NOT_FOUND);
        }
        baseDAO.delete(weaknet);
    }

    @Override
    public WeaknetDTO update(Integer wnid, String name, String desc, String param) throws DataBaseException, BusinessException {
        EtWeaknet weaknet = (EtWeaknet) baseDAO.queryById(com.dilatoit.eagletest.model.EtWeaknet.class, wnid);
        if(weaknet == null){
            throw new BusinessException(ExceptionEnum.QUERY_ENTITY_NOT_FOUND);
        }
        weaknet.setName(name);
        weaknet.setDesc(desc);
        weaknet.setParam(param);

        baseDAO.update(weaknet);
        return WeaknetDTOTranslate.translate(weaknet);
    }

    @Override
    public Integer add(String name, String desc, String param) throws DataBaseException, BusinessException {
        EtWeaknet weaknet = new EtWeaknet();
        weaknet.setName(name);
        weaknet.setParam(param);
        weaknet.setDesc(desc);

        Date nowDate = new Date();
        weaknet.setModifyTime(nowDate);
        weaknet.setCreateTime(nowDate);
        weaknet.setSystemDefault(ModelFiledBooleanEnum.FALSE.value());

        weaknet.setEnable(ModelFiledBooleanEnum.TRUE.value());
        //这里默认设置为default
        weaknet.setKey("default");

        return baseDAO.save(weaknet);
    }

    @Override
    public WeaknetDTO querySingleById(Integer id) throws DataBaseException {
        EtWeaknet weaknet = (EtWeaknet) baseDAO.queryById(com.dilatoit.eagletest.model.EtWeaknet.class, id);

        return WeaknetDTOTranslate.translate(weaknet);
    }

    @Override
    public List<WeaknetDTO> queryAllToDTO() throws DataBaseException {
        return null;
    }

    @Override
    public void queryPage(DataPage<WeaknetDTO> page, Conditions conditions) throws DataBaseException {

        DataPage<EtWeaknet> pageDB = new DataPage<>();
        pageDB.setOffsetLimit(page.getOffset(), page.getLimit());
        baseDAO.page(pageDB, com.dilatoit.eagletest.model.EtWeaknet.class, conditions);
        page.setRows(pageDB.getRows());
        page.setData(WeaknetDTOTranslate.translateList(pageDB.getData()));
    }

    public List<EtWeaknet> queryAllEnable() throws DataBaseException {
        Conditions conditions = new Conditions();
        conditions.addCondition("enable", ModelFiledBooleanEnum.TRUE.value(), Conditions.Operator.EQUAL);
        return baseDAO.queryByConditions(com.dilatoit.eagletest.model.EtWeaknet.class, conditions);
    }

    public EtWeaknet queryByKey(String key) throws DataBaseException {
        Conditions conditions = new Conditions();
        conditions.addCondition("key", key, Conditions.Operator.EQUAL);
        List<EtWeaknet> list =  baseDAO.queryByConditions(com.dilatoit.eagletest.model.EtWeaknet.class, conditions);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public EtWeaknet queryById(Integer id) throws DataBaseException {
        EtWeaknet weaknet = (EtWeaknet) baseDAO.queryById(com.dilatoit.eagletest.model.EtWeaknet.class, id);
        return weaknet;
    }
}
