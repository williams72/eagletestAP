package com.dilatoit.eagletest.service.impl;

import com.dilatoit.commons.GsonUtils;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.service.ScreenShotService;
import com.dilatoit.eagletest.util.NoUseClass;
import com.dilatoit.engine.exception.EngineException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by xueshan.wei on 4/7/2017.
 */
@Service("screenShotService")
public class ScreenShotServiceImpl extends BaseService<NoUseClass> implements ScreenShotService {

    public List<String> queryScreenShot(String taskId, String serialno) throws BusinessException {
        try {
            String result = enginePipe.taskPipe().queryTaskMobileResult(taskId, serialno);
            Map map  = GsonUtils.toMap(result);
            Map mResult = (Map) map.get("result");
            Map mLog = (Map) mResult.get("log");
            Map mComp = (Map) mLog.get("compatibility");
            return (List<String>) mComp.get("screenshot");
        } catch (EngineException e) {
            e.printStackTrace();
            throw new BusinessException(e.getEe());
        }
    }
}
