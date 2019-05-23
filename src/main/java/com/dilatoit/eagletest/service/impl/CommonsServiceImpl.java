package com.dilatoit.eagletest.service.impl;


import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.service.CommonsService;
import com.dilatoit.eagletest.util.NoUseClass;
import com.dilatoit.engine.exception.EngineException;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Created by xueshan.wei on 3/6/2017.
 */
@Service("commonsService")
public class CommonsServiceImpl extends BaseService<NoUseClass> implements CommonsService {
    public String uploadCaseFile(String fileFormName, File file,String key) throws BusinessException {
        try{
            return this.enginePipe.commonsPipe().uploadCaseFile(fileFormName, file, key);
        }catch (EngineException ee){
            throw new BusinessException(ExceptionEnum.INNER_SERVER_ERROR);
        }

    }

    public String uploadFile(String fileFormName, File file,String key) throws BusinessException {
        try{
            return this.enginePipe.commonsPipe().uploadFile(fileFormName, file, key);
        }catch (EngineException ee){
            throw new BusinessException(ExceptionEnum.INNER_SERVER_ERROR);
        }

    }

    public String getEngineBaseUri() throws BusinessException {
        try{
            return this.enginePipe.commonsPipe().getPipeUri();
        }catch (EngineException ee){
            throw new BusinessException(ExceptionEnum.INNER_SERVER_ERROR);
        }
    }
}
