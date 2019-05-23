package com.dilatoit.eagletest.service;

import com.dilatoit.eagletest.dto.WeaknetDTO;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtWeaknet;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;

import java.util.List;

/**
 * weaknet service
 * Created by xueshan.wei on 4/14/2017.
 */
public interface WeaknetService {

    /**
     * 设置弱网项可用性
     * @param wnid
     * @param availability 可用不可用
     * @throws DataBaseException
     * @throws BusinessException
     */
    void changeAvailability(Integer wnid, boolean availability) throws DataBaseException, BusinessException;
    /**
     * 删除弱网项
     * @param wnid
     * @throws DataBaseException
     * @throws BusinessException
     */
    void delete(Integer wnid) throws DataBaseException, BusinessException;
    /**
     * 更新弱网项
     * @param name 弱网名称
     * @param desc 描述
     * @param param 参数
     * @return 更新后的对象
     * @throws DataBaseException
     * @throws BusinessException
     */
    WeaknetDTO update(Integer wnid, String name, String desc, String param) throws DataBaseException, BusinessException;

    /**
     * 添加弱网项
     * @param name 名称
     * @param desc 描述
     * @param param 参数
     * @return id
     * @throws DataBaseException 数据库异常
     */
    Integer add(String name, String desc, String param) throws DataBaseException, BusinessException;
    /**
     * 查询所有可用的弱网项
     * @return enable list | null (没有可用)
     * @throws DataBaseException
     */
    List<EtWeaknet> queryAllEnable() throws DataBaseException;

    /**
     * 根据key查询
     * @param key
     * @return model | null 不存在
     * @throws DataBaseException
     */
    EtWeaknet queryByKey(String key) throws DataBaseException;

    /**
     *
     * @param id
     * @return
     * @throws DataBaseException
     */
    EtWeaknet queryById(Integer id) throws DataBaseException;

    /**
     * 查询所有弱网项
     * @return list of WeaknetDTO | null
     * @throws DataBaseException
     */
    List<WeaknetDTO> queryAllToDTO() throws DataBaseException;

    /**
     * 分页查询
     * @param page
     * @throws DataBaseException
     */
    void queryPage(DataPage<WeaknetDTO> page, Conditions conditions) throws DataBaseException;

    /**
     * 查询单个
     * @return Object | null
     * @throws DataBaseException
     */
    WeaknetDTO querySingleById(Integer id) throws DataBaseException;
}
