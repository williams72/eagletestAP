package test.service;

import com.google.gson.Gson;
import org.junit.Test;
import test.util.BaseTest;

import java.util.Map;

/**
 * Created by xueshan.wei on 1/16/2017.
 */
public class ProjectDashboardServiceTest extends BaseTest {
    @Test
    public void tongjiVersionSubtaskRate() throws Exception{
        Map result = serviceManager.getProjectDashboardService().rateOfVersionAndSubtaskType(12);
        System.out.println(result.toString());
        Gson gson = new Gson();
        System.out.println(gson.toJson(result));
    }
}
