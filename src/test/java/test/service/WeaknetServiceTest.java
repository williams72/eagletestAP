package test.service;

import com.dilatoit.eagletest.dto.WeaknetDTO;
import com.dilatoit.eagletest.model.EtWeaknet;
import org.junit.Test;
import test.util.BaseTest;

import java.util.List;

/**
 * Created by xueshan.wei on 4/14/2017.
 */
public class WeaknetServiceTest extends BaseTest {

    @Test
    public void testChangeAvailability() throws Exception{
        serviceManager.getWeaknetService().changeAvailability(6, false);
    }
    @Test
    public void testAdd() throws Exception{
        serviceManager.getWeaknetService().add("测试", "测试用", "参数");
    }

    @Test
    public void testQuerySingle() throws Exception{
        WeaknetDTO weaknetDTO = serviceManager.getWeaknetService().querySingleById(100);
        if(weaknetDTO != null){
            System.out.println("查询到了");
        }else {
            System.out.println("查询失败");
        }
    }
    @Test
    public void testQueryAllEnable() throws Exception{
        List<EtWeaknet> list = serviceManager.getWeaknetService().queryAllEnable();
        if(list != null){
            System.out.println("有");
            for(EtWeaknet weaknet : list){
                System.out.println(weaknet.toString());
            }
        }else{
            System.out.println("没有");
        }
    }

    @Test
    public void testQueryByKey() throws Exception{
        EtWeaknet weaknet = serviceManager.getWeaknetService().queryByKey("2G");
        if(weaknet != null){
            System.out.println(weaknet);
        }
    }
}
