package test.service;

import com.dilatoit.eagletest.model.EtRealMobile;
import com.dilatoit.engine.enums.RealMobileTime;
import org.junit.Test;
import test.util.BaseTest;

import java.util.List;

/**
 * Created by xueshan.wei on 11/21/2016.
 */
public class RealMobileServiceTest extends BaseTest{

    @Test
    public void stopAll() throws Exception{
        String sid = "2a2a7bc";
        String result = serviceManager.getRealMobileService().httpStopAllRealmobile(sid);
        System.out.println("result = " + result);
    }
    @Test
    public void rentRM() throws Exception{
        String serialNubmer = "85OACM6V4WCZ";
        //String serialNubmer = "501d190d";
        Integer result = serviceManager.getRealMobileService().httpRentRealMobile(1, serialNubmer, "", RealMobileTime.TIME_1);

        System.out.println(result);
    }

    @Test
    public void rminfoRight() throws Exception{
        String result = serviceManager.getRealMobileService().httpGetRealMobileInfo(31);
        System.out.println(result);
    }

    @Test
    public void rminfoError() throws Exception{
        String result = serviceManager.getRealMobileService().httpGetRealMobileInfo(1);
        System.out.println(result);
    }

    @Test
    public void renewalRm() throws Exception{
        Long time = null;
        String result = serviceManager.getRealMobileService().httpRenewalRealMobile(31, time);
        System.out.println(result);
    }

    @Test
    public void stopRm() throws Exception{
        String result = serviceManager.getRealMobileService().httpStopRealMobile(11);
    }

    @Test
    public void allCurrentRms() throws Exception{
        List<EtRealMobile> list = serviceManager.getRealMobileService().currentRealMobiles(1);
        System.out.println(list.size());
        for(EtRealMobile realMobile : list){
            System.out.println(realMobile.getRealDevId());
        }
    }
}
