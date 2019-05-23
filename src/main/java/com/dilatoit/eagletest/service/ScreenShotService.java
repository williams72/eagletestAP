package com.dilatoit.eagletest.service;

import com.dilatoit.eagletest.exception.ex.BusinessException;

import java.util.List;

/**
 * Created by xueshan.wei on 4/7/2017.
 */
public interface ScreenShotService {
    /**
     * query screent shot from mtc
     * @param taskId
     * @param serialno
     * @return
     * @throws BusinessException
     */
    List<String> queryScreenShot(String taskId, String serialno) throws BusinessException;
}
