package com.dilatoit.eagletest.service;


import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.model.EtSmartTraversalTask;

import java.util.List;

/**
 * Created by xueshan.wei on 5/18/2017.
 */
public interface SmartTraversalTaskService {
    int save(EtSmartTraversalTask stt) throws BusinessException;

    List<EtSmartTraversalTask> queryAllByParrentTaskId(int parrentTaskId) throws BusinessException;

    EtSmartTraversalTask queryById(Integer stId)throws BusinessException;

    /**
     * 同步任务状态，主要是向远端执行端查询任务执行状态，并同步更新状态,
     * 如果一个父任务的所有子智能遍历任务都执行完毕的话，则返回true,否则返回false
     * @param parrentTaskId
     * @return
     * @throws BusinessException
     */
    boolean synoTaskStatus(int parrentTaskId) throws BusinessException;
    /**
     * 创建SmartTraversal 任务
     * @return
     * @throws BusinessException
     */
    EtSmartTraversalTask create(int parentTaskId, String appUrl, String serialno, String brand, String model, String os) throws BusinessException;

}
