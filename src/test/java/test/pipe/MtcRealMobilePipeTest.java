package test.pipe;

import com.dilatoit.engine.engines.mtc.pipe.MtcRealMobilePipe;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.util.BaseTest;

/**
 * Created by xueshan.wei on 11/21/2016.
 */
public class MtcRealMobilePipeTest extends BaseTest{
    @Autowired
    MtcRealMobilePipe mtcRealMobilePipe;
    @Test
    public void stop() throws Exception{
        mtcRealMobilePipe.stop("83");
    }
}
