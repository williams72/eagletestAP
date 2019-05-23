package com.dilatoit.eagletest.service.impl;

import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtSmartTraversalTask;
import com.dilatoit.eagletest.model.EtTask;
import com.dilatoit.eagletest.service.SmartTraversalTaskService;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.engine.engines.ete.utils.SmartTraversal;
import com.dilatoit.engine.engines.ete.utils.SmartTraversalStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by xueshan.wei on 5/18/2017.
 */
@Service(value = "smartTraversalTaskService")
public class SmartTraversalTaskServiceImpl extends BaseService<EtSmartTraversalTask> implements SmartTraversalTaskService {
    //@Resource(name = "smartEngine")
    //private SmartTraversalEngine smartTraversalEngine = new SmartTraversalEngine();

    @Override
    public int save(EtSmartTraversalTask stt) throws BusinessException {
        // TODO: 5/18/2017 need 
        try {
            return baseDAO.save(stt);
        } catch (DataBaseException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public boolean synoTaskStatus(int parrentTaskId) throws BusinessException {
        List<EtSmartTraversalTask> sts = queryAllByParrentTaskId(parrentTaskId);
        boolean flag = true;
        if(sts != null && sts.size() > 0){
            for(EtSmartTraversalTask st : sts){
                if(!(st.getStatus() == SmartTraversalStatus.CANCELLED.value()) &&
                        !(st.getStatus() == SmartTraversalStatus.CANCELLED.value()) &&
                        !(st.getStatus() == SmartTraversalStatus.ERROR.value())){
                    //子任务没有执行完毕，远端查询是否执行完毕
                    /*SmartTraversal smartTraversal = smartTraversalEngine.queryResult(st.getEteJobId());
                    if(smartTraversal != null){
                        //远端查询到任务信息，则继续判断执行情况，木有查到则置为ERROR
                        if(smartTraversal.getStatus() == SmartTraversalStatus.CANCELLED.value() ||
                                smartTraversal.getStatus() == SmartTraversalStatus.COMPLETED.value()){
                            //子任务执行完毕,更新状态
                            st.setBegTime(smartTraversal.getBeginTime());
                            st.setEndTime(smartTraversal.getEndTime());
                            st.setResult(smartTraversal.getResult());
                            st.setStatus(smartTraversal.getStatus());
                        }else{
                            flag = false;
                        }
                    }else {
                        //远端木有查询到子任务的信息，则置为错误
                        st.setResult(SmartTraversalResult.FAIL.value());
                        st.setStatus(SmartTraversalStatus.ERROR.value());
                    }*/
                    //更新状态
                    try {
                        baseDAO.update(st);
                    } catch (DataBaseException e) {
                        e.printStackTrace();
                        //这里不处理，即使本次保存失败，下次也可以再次同步
                    }
                }
            }
        }else {
            //没有子任务了，也返回true，这样下次就不需同步了
            flag = true;
        }

        return flag;
    }

    @Override
    public List<EtSmartTraversalTask> queryAllByParrentTaskId(int parrentTaskId) throws BusinessException {
        Conditions conditions = new Conditions();
        conditions.addCondition("task.id", parrentTaskId, Conditions.Operator.EQUAL);
        try{
            return baseDAO.queryByConditions(com.dilatoit.eagletest.model.EtSmartTraversalTask.class, conditions);
        }catch (DataBaseException e){
            e.printStackTrace();
            throw new BusinessException(e.getEe());
        }

    }

    @Override
    public EtSmartTraversalTask queryById(Integer stId) throws BusinessException {
        EtSmartTraversalTask smartTraversalTask = null;
        try {
            smartTraversalTask = (EtSmartTraversalTask) baseDAO.queryById(com.dilatoit.eagletest.model.EtSmartTraversalTask.class, stId);
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new BusinessException(e.getEe());
        }
        return smartTraversalTask;
    }

    @Override
    public EtSmartTraversalTask create(int parentTaskId, String appUrl, String serialno, String brand, String model, String os) throws BusinessException {
        EtSmartTraversalTask smartTraversalTask = null;
        /*SmartTraversal smartTraversal = smartTraversalEngine.start(appUrl, serialno);
        if(smartTraversal != null){
            smartTraversalTask = new EtSmartTraversalTask();
            smartTraversalTask.setAppUrl(appUrl);
            smartTraversalTask.setSerialno(serialno);
            EtTask task = new EtTask();
            task.setId(parentTaskId);
            Date date = new Date();
            smartTraversalTask.setTask(task);
            smartTraversalTask.setEteJobId(smartTraversal.getId());
            smartTraversalTask.setReport("http://10.0.40.231:8081" + smartTraversal.getResultPath());
            smartTraversalTask.setCreateTime(date);
            smartTraversalTask.setBrand(brand);
            smartTraversalTask.setModel(model);
            smartTraversalTask.setOs(os);
            smartTraversalTask.setStatus(SmartTraversalStatus.RUNNING.value());
            try {
                //保存到数据库
                int newSTTId = this.save(smartTraversalTask);
                if(newSTTId != -1){
                    try {
                        smartTraversalTask = (EtSmartTraversalTask) baseDAO.queryById(EtSmartTraversalTask.class, newSTTId);
                    } catch (DataBaseException e) {
                        e.printStackTrace();
                    }
                }
            } catch (BusinessException e) {
                e.printStackTrace();
                throw e;
            }
        }*/

        return smartTraversalTask;
    }
}
