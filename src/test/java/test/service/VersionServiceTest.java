package test.service;

import org.junit.Test;
import org.springframework.test.context.web.WebAppConfiguration;
import test.util.BaseTest;

/**
 * Created by xueshan.wei on 12/9/2016.
 */

public class VersionServiceTest extends BaseTest {
    @Test
    public void testChangeVersionStatus() throws Exception{
        serviceManager.getVersionService().changeVersionStatus(29, 3);
    }
}
