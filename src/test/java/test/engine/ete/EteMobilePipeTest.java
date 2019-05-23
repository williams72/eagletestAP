package test.engine.ete;

import com.dilatoit.engine.dto.MobileDTO;
import com.dilatoit.engine.engines.ete.pipe.EteMobilePipe;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.util.BaseTest;

import java.util.List;

/**
 * Created by xueshan.wei on 6/15/2017.
 */
public class EteMobilePipeTest extends BaseTest {
    @Autowired
    private EteMobilePipe eteMobilePipe;
    @Test
    public void testQueryOnlineMobile() throws Exception{
        List<MobileDTO> mobileDTOS = eteMobilePipe.queryMobiles();
        mobileDTOS.forEach(item -> System.out.println(item));
    }
}
