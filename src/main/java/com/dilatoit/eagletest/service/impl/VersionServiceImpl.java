package com.dilatoit.eagletest.service.impl;

import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.enums.version.VersionStatus;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtProject;
import com.dilatoit.eagletest.model.EtVersion;
import com.dilatoit.eagletest.service.VersionService;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * Created by beishan on 2016/11/13.
 */
@Service("versionService")
public class VersionServiceImpl extends BaseService<EtVersion> implements VersionService {
    public void changeVersionStatus(Integer versionId, Integer status) throws DataBaseException, BusinessException {
        VersionStatus versionStatus = null;
        switch (status){
            case 1: versionStatus = VersionStatus.IN_DEVELOPING; break;
            case 2: versionStatus = VersionStatus.IN_TESTING; break;
            case 3: versionStatus = VersionStatus.IN_GA; break;
            default:
                throw new BusinessException(ExceptionEnum.PARAM_ERROR);
        }
        EtVersion version = (EtVersion) baseDAO.queryById(com.dilatoit.eagletest.model.EtVersion.class, versionId);
        if(version == null){
            throw new BusinessException(ExceptionEnum.QUERY_ENTITY_NOT_FOUND);
        }else{
            version.setVersionStatus(versionStatus.value());
            baseDAO.update(version);
        }
    }

    public void page(DataPage<EtVersion> page) throws DataBaseException {
        Conditions conditions = new Conditions();
        conditions.addOrderBy("createTime", false);
        page(page, conditions);
    }

    public void page(DataPage<EtVersion> page, Conditions conditions) throws DataBaseException {
        baseDAO.page(page, com.dilatoit.eagletest.model.EtVersion.class, conditions);
    }

    public Integer addVersion(EtVersion version, Integer projectId) throws BusinessException {
        //检查要添加的版本是否已经存在
        EtVersion vcheck = this.queryVersionByPidAndName(projectId, version.getVersionName());
        if(vcheck == null){
            EtProject project = new EtProject();
            project.setId(projectId);

            version.setEtProject(project);
            version.setCreateTime(new Date());
            try {
                return baseDAO.save(version);
            } catch (DataBaseException e) {
                e.printStackTrace();
                throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
            }
        }else{
            throw new BusinessException(ExceptionEnum.PROJECT_VERSION_QUERY_EXIST);
        }

    }

    public List<EtVersion> queryAllByProId(Integer projectId) throws DataBaseException {
        Conditions conditions = new Conditions();
        conditions.addCondition("etProject.id", projectId, Conditions.Operator.EQUAL);
        return baseDAO.queryByConditions(com.dilatoit.eagletest.model.EtVersion.class, conditions);
    }

    public EtVersion queryVersionById(Integer versionId) throws BusinessException {
        try {
            return (EtVersion) baseDAO.queryById(EtVersion.class, versionId);
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
    }

    public EtVersion queryVersionByPidAndName(int pid, String versionName) throws BusinessException {
        System.out.println("queryVersionByPidAndName()--versionName:"+versionName);
        Conditions conditions = new Conditions();
        conditions.addCondition("etProject.id", pid, Conditions.Operator.EQUAL);
        conditions.addCondition("versionName", versionName, Conditions.Operator.EQUAL);
        try {
            List<EtVersion> list = baseDAO.queryByConditions(EtVersion.class, conditions);
            if(list != null && list.size() > 0){
                return list.get(0);
            }
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
        return null;
    }
}
