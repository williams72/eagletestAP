package com.dilatoit.eagletest.service;

import com.dilatoit.eagletest.exception.ex.BusinessException;
import java.io.File;

/**
 * Created by xueshan.wei on 3/6/2017.
 */
public interface CommonsService {
    /**
     * upload case file
     * @param fileFormName
     * @param file
     * @param key
     * @return
     * @throws BusinessException
     */
    public String uploadCaseFile(String fileFormName, File file, String key) throws BusinessException;

    /**
     *
     * @param fileFormName
     * @param file
     * @param key
     * @return
     * @throws BusinessException
     */
    public String uploadFile(String fileFormName, File file,String key) throws BusinessException;

    /**
     * 得到当前使用引擎的uri
     * @return
     * @throws BusinessException
     */
    public String getEngineBaseUri() throws BusinessException;
}
