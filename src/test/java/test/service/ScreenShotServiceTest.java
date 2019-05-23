package test.service;

import org.junit.Test;
import test.util.BaseTest;

/**
 * Created by xueshan.wei on 4/7/2017.
 */
public class ScreenShotServiceTest extends BaseTest {

    @Test
    public void testGetScreenShot() throws Exception{
        serviceManager.getScreenShotService().queryScreenShot("154", "022MWW144V004620");
    }
}
