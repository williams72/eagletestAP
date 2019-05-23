package test.pipe;

import com.dilatoit.engine.dto.MobileDTO;
import com.dilatoit.engine.enums.MobileOsEnum;
import com.dilatoit.engine.engines.mtc.pipe.MtcMobilePipe;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.util.BaseTest;

import java.util.List;

/**
 * Created by xueshan.wei on 4/11/2017.
 */
public class MobilePipeTest extends BaseTest{
    @Autowired
    MtcMobilePipe mtcMobilePipe;

    @Test
    public void testQueryMobilesByOSType() throws Exception{
        List<MobileDTO> mobileBOList = mtcMobilePipe.queryMobilesByOS(MobileOsEnum.ALL);
        if(mobileBOList != null){
            for(MobileDTO mobileBO : mobileBOList){
                System.out.println(mobileBO.toString());
            }
        }
    }
}
