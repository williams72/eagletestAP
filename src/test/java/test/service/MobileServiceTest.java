package test.service;

import com.dilatoit.engine.enums.MobileOsEnum;
import org.junit.Test;
import test.util.BaseTest;

/**
 * Created by beishan on 2016/11/15.
 */
public class MobileServiceTest extends BaseTest {

    @Test
    public void testQueryMobiles() throws Exception{
        serviceManager.getMobileService().queryMobiles();
    }
    @Test
    public void testEngineMtc() throws Exception{
        serviceManager.getMobileService().httpRename("", "");
    }
    @Test
    public void getMobileInfo() throws Exception{
        String result = serviceManager.getMobileService().httpGetMobileInfo();
        System.out.println(result);
    }
    @Test
    public void getMobileInfoByOsType() throws Exception{
        String result = serviceManager.getMobileService().httphttpGetMobileInfoByOS(MobileOsEnum.IOS);
        System.out.println(result);
    }

    @Test
    public void rename() throws Exception{
        String result = serviceManager.getMobileService().httpRename("2a2a7bc", "静娜a");
        System.out.println(result);
    }

    @Test
    public void reboot() throws Exception{
        String result = serviceManager.getMobileService().httpReboot("2a2a7bc");
        System.out.println(result);
    }
}
