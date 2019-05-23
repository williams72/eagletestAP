package test.util;

import com.dilatoit.engine.dto.translate.EngineTaskTranslate;
import com.dilatoit.eagletest.validate.formtask.Mobile;
import com.dilatoit.eagletest.validate.formtask.Task;
import com.dilatoit.engine.dto.EngineTaskDTO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/16.
 */
public class EngineTaskTranslateTest {
    @Test
    public void testEngineTaskTranslate(){
        Task task = new Task();
        EngineTaskDTO engineTaskDTO = new EngineTaskDTO();
        task.setTaskName("testName");
        task.setTaskOS(0);
        task.setAppId(8);
        task.setAppUrl("http://10.0.40.49:8001/storage/download/apk/e4de728dc4e0eda2b701b0d35dc155df.apk");
        task.setIsReboot("1");
        task.setIsNetSimulation("0");
        task.setNetSimulationType("2G");
        task.setNetSimulationData("testData");
        task.setCompatibilityTest("1");
        task.setCompatibilityTime(5);
        task.setCompatibilityType(0);
        task.setScriptTest("0");
        task.setScriptType(0);
        task.setScriptUrl("testUrl");
        task.setTraversalTest("1");
        task.setTraversalTime(15);
        task.setSmartTraversalTest("0");
        task.setEngine(1);
        List<Mobile> mobiles = new ArrayList<>();
        Mobile mobile = new Mobile();
        mobile.setBrand("锤子");
        mobile.setModel("T3");
        mobile.setOs("Android 8");
        mobile.setSn("asdasfqwfafsdad");
        mobiles.add(mobile);
        task.setMobiles(mobiles);
        engineTaskDTO =  EngineTaskTranslate.translate(task);
    }
}
