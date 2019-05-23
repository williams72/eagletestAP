package test.netsimulation;

import com.dilatoit.netsimulation.service.NetSimulation;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xueshan.wei on 5/12/2017.
 */
public class NetSimulationTest {
    @Test
    public void testCheckIsInSimulation() throws Exception{
        NetSimulation netSimulation = new NetSimulation();
        boolean isShaped = netSimulation.checkIsInNetSimulation("192.168.0.103");
        Assert.assertTrue(isShaped);
    }

    @Test
    public void testSetSimulation() throws Exception{
        NetSimulation netSimulation = new NetSimulation();
        String param = "{\"down\":{\"rate\":400,\"loss\":{\"percentage\":5.0,\"correlation\":0.0},\"delay\":{\"delay\":15,\"jitter\":0,\"correlation\":0.0},\"corruption\":{\"percentage\":0.0,\"correlation\":0.0},\"reorder\":{\"percentage\":0.0,\"correlation\":0.0,\"gap\":0}},\"up\":{\"rate\":200,\"loss\":{\"percentage\":1.0,\"correlation\":0.0},\"delay\":{\"delay\":10,\"jitter\":0,\"correlation\":0.0},\"corruption\":{\"percentage\":0.0,\"correlation\":0.0},\"reorder\":{\"percentage\":0.0,\"correlation\":0.0,\"gap\":0}}}";
        boolean result = netSimulation.setNetSimulation("192.168.0.103", param);
        System.out.println("result = " + result);
    }

    @Test
    public void testRemoveSimulation() throws Exception{
        NetSimulation netSimulation = new NetSimulation();
        boolean result = netSimulation.removeNetSimulation("192.168.0.103");
        System.out.println(result);
    }


}
