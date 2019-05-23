package com.dilatoit.eagletest.service.impl;


import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtApp;
import com.dilatoit.eagletest.service.AppService;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;
import com.dilatoit.engine.engines.mtc.util.JsonTools;
import com.dilatoit.engine.exception.EngineException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by beishan on 2016/11/13.
 */
@Service("appService")
public class AppServiceImpl extends BaseService<EtApp> implements AppService {
    public EtApp queryById(Integer id) throws DataBaseException {
        return (EtApp) baseDAO.queryById(com.dilatoit.eagletest.model.EtApp.class, id);
    }

    public EtApp queryByVersionIdAndName(int versionId, String appName) throws DataBaseException {
        Conditions conditions = new Conditions();
        conditions.addCondition("etVersion.id", versionId, Conditions.Operator.EQUAL);
        conditions.addCondition("appName", appName, Conditions.Operator.EQUAL);
        List<EtApp> list = baseDAO.queryByConditions(EtApp.class, conditions);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public List<EtApp> queryByConditions(Conditions conditions) throws DataBaseException {
        return baseDAO.queryByConditions(com.dilatoit.eagletest.model.EtApp.class, conditions);
    }

    public List<EtApp> queryAll() throws DataBaseException {
        return baseDAO.queryAll(com.dilatoit.eagletest.model.EtApp.class);
    }

    public void page(DataPage<EtApp> page) throws DataBaseException {
        Conditions conditions = new Conditions();
        page(page, conditions);
    }

    public void page(DataPage<EtApp> page, Conditions conditions) throws DataBaseException {
        baseDAO.page(page, com.dilatoit.eagletest.model.EtApp.class, conditions);
    }

    public Integer addApp(EtApp app, File file, String fileType) throws EngineException, DataBaseException {

        //mtc 上传app
        String resultStr = this.enginePipe.commonsPipe().uploadApp(file, fileType);
        System.out.println(resultStr);
        Map result = JsonTools.toMap(resultStr);
        app.setCreateTime(new Date());

        Map appInfo = (Map) result.get("appInfo");

        app.setAppAddress(appInfo.get("bcs_url").toString());
        //app.setAppName(appInfo.get("").toString());
        //app.setBuildNumber(appInfo.get("build_number").toString());
        //app.setIcon(appInfo.get("icon").toString());
        //app.setMd5(appInfo.get("md5").toString());
        //app.setPackageActivity(appInfo.get("package_activity").toString());
        //app.setPackageName(appInfo.get("package_name").toString());
        //app.setSdkVersion(appInfo.get("sdk_version").toString());
        app.setAppRealName(appInfo.get("app_name").toString());
        //app.setSize();

        return baseDAO.save(app);
    }

    @Override
    public void updateApp(EtApp app) throws DataBaseException {
        this.baseDAO.update(app);
    }

    @Override
    public void changeVisibility(Integer appId, Integer newVisibility) throws BusinessException {
        try {
            EtApp app = this.queryById(appId);
            if (app != null) {
                app.setVisibility(newVisibility);
                updateApp(app);
            } else {
                throw new BusinessException(ExceptionEnum.APP_IS_NOT_EXIST);
            }
        } catch (DataBaseException dbe) {
            throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
    }


}
