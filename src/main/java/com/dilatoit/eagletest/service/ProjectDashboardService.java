package com.dilatoit.eagletest.service;

import com.dilatoit.eagletest.exception.ex.DataBaseException;

import java.util.Map;

/**
 * Created by xueshan.wei on 1/16/2017.
 */
public interface ProjectDashboardService {
    /**
     * 版本类型成功率
     * @param projectId
     * @return
     * @throws DataBaseException
     */
    Map rateOfVersionAndSubtaskType(Integer projectId) throws DataBaseException;
}
