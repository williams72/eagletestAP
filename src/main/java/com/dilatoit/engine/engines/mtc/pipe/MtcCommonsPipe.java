package com.dilatoit.engine.engines.mtc.pipe;

import com.dilatoit.engine.exception.EngineException;
import com.dilatoit.engine.pipes.CommonsPipe;
import com.dilatoit.engine.engines.mtc.util.MtcFileUtil;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by xueshan.wei on 11/16/2016.
 */
@Component
public class MtcCommonsPipe extends MtcBasePipe implements CommonsPipe{
    public String uploadApp(File file, String fileType) throws EngineException {
        return MtcFileUtil.httpUploadAPP(getAppUploadUrl(), "file", file, getServerAccountId(), fileType);
    }

    public String uploadFile(String fileFormName, File file , String key) throws EngineException {
        return MtcFileUtil.httpUploadFile(getFileUploadUrl(), fileFormName, file, "weakDir", key);
    }

    public String uploadCaseFile(String fileFormName, File file, String key) throws EngineException {
        return MtcFileUtil.httpUploadFile(getFileUploadUrl(), fileFormName, file, "caseBank", key);
    }

    public String getPipeUri() throws EngineException {
        return this.getBaseUri();
    }
}
