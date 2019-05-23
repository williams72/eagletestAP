package com.dilatoit.engine.pipes;

import com.dilatoit.engine.exception.EngineException;

import java.io.File;

/**
 * Created by xueshan.wei on 11/16/2016.
 */
public interface CommonsPipe {
    /**
     * upload app
     * @return
     * @throws EngineException
     */
    public String uploadApp(File file, String fileType) throws EngineException;

    /**
     * upload file
     * @param fileFormName
     * @param file
     * @param key
     * @return
     * @throws EngineException
     */
    public String uploadFile(String fileFormName, File file, String key) throws EngineException;

    /**
     *
     * @param fileForName
     * @param file
     * @param key
     * @return
     * @throws EngineException
     */
    public String uploadCaseFile(String fileForName, File file, String key)throws EngineException;

    /**
     * get the pipe uri config
     * @return
     * @throws EngineException
     */
    public String getPipeUri() throws EngineException;
}
