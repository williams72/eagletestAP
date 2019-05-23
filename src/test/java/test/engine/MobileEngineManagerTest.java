package test.engine;

import com.dilatoit.engine.MobileEngineManager;
import com.dilatoit.engine.dto.MobileDTO;
import com.dilatoit.engine.enums.EngineEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.util.BaseTest;

import java.util.List;

/**
 * Created by xueshan.wei on 6/15/2017.
 */
public class MobileEngineManagerTest extends BaseTest {
    @Autowired
    private MobileEngineManager mobileEngineManager;
    @Test
    public void testQueryMobiles() throws Exception{
        long time1 = System.currentTimeMillis();
        List<MobileDTO> mobiles = mobileEngineManager.getAllEngineMobiles();
        System.out.println("花费时间：" + (System.currentTimeMillis() - time1));
        mobiles.forEach(item -> System.out.println(item));
    }

    @Test
    public void testQueryMobilesFromEngine() throws Exception{
        List<MobileDTO> mobiles = mobileEngineManager.getAllMobileByEngine(EngineEnum.ENGINE_MTCE);
        mobiles.forEach(item -> System.out.println(item));
    }
}
