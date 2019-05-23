package test.engine;

import com.dilatoit.engine.EngineManager;
import com.dilatoit.engine.dto.EngineCreateTaskResultDTO;
import com.dilatoit.engine.dto.EngineTaskDTO;
import com.dilatoit.engine.dto.EngineTaskMobileDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.util.BaseTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xueshan.wei on 6/16/2017.
 */
public class EngineManagerTest extends BaseTest {
    @Autowired
    private EngineManager engineManager;
    @Test
    public void testCreateTask() throws Exception{
        EngineTaskDTO engineTaskDTO = new EngineTaskDTO();
        //引擎设置为ETE
        engineTaskDTO.setEngine(0);
        engineTaskDTO.setTaskName("测试1");
        engineTaskDTO.setAppUrl("http://10.0.40.49:8001/storage/download/apk/e4de728dc4e0eda2b701b0d35dc155df.apk");
        engineTaskDTO.setOsType(0);
        engineTaskDTO.setReboot(true);
        engineTaskDTO.setNetsimulation(false);
        engineTaskDTO.setCompatibility(true);
        engineTaskDTO.setCompatibilityTime(3);
        engineTaskDTO.setCompatibilityType(0);

        EngineTaskMobileDTO m1 = new EngineTaskMobileDTO();
        m1.setBrand("Xiaomi");
        m1.setModel("2013023");
        m1.setOs("android 4.4.2");
        m1.setSerialno("G2W7N15120024967");
        //m1.setSerialno("0123456789ABCDEF");
        m1.setIp("192.168.0.1");

        List<EngineTaskMobileDTO> mobiles = new ArrayList<>();
        mobiles.add(m1);

        engineTaskDTO.setMobiles(mobiles);

        EngineCreateTaskResultDTO e = engineManager.getTaskEngineManager().createTask(engineTaskDTO);
        System.out.println(e);
    }
}
