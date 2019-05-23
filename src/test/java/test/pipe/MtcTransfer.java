package test.pipe;

import com.dilatoit.engine.engines.mtc.data.MtcTaskConversion;
import org.springframework.beans.factory.annotation.Autowired;
import test.util.BaseTest;

/**
 * Created by xueshan.wei on 3/29/2017.
 */
public class MtcTransfer extends BaseTest{
    @Autowired
    private MtcTaskConversion taskConversion;
    /*@Test
    public void test()throws Exception{

        TaskTransfer transfer = new TaskTransfer();
        Task task = new Task();
        BaseInfo baseInfo = new BaseInfo();
        baseInfo.setName("测试--1");
        baseInfo.setOs("0");
        baseInfo.setApkUrl("http://10.0.40.220:8008/storage/download/apk/e4de728dc4e0eda2b701b0d35dc155df.apk");

        task.setBaseinfo(baseInfo);

        //添加预处理
        Prejob prejob = new Prejob();
        prejob.setReboot(true);
        task.setPrejob(prejob);
        //预处理增加弱网
        Weaknet weaknet = new Weaknet();
        weaknet.setCmd("sh weak_set.sh");
        weaknet.setSetUpScriptUrl("http:\\\\/\\\\/10.0.40.220:8008//storage\\/download\\/weak_dir\\/weak_set.sh");
        weaknet.setTeardownScriptUrl("http:\\\\/\\\\/10.0.40.220:8008\\/storage\\/download\\/weak_dir\\/weak_unset.sh");
        prejob.setWeaknet(weaknet);

        //添加兼容性测试
        Comp comp = new Comp();
        comp.setTime(5);
        comp.setType("monkey");
        TaskTest test = new TaskTest();
        test.setComp(comp);

        //添加脚本测试
        *//*Caset caset = new Caset();
        caset.setFileuri("http://10.0.40.220:8008/storage/download/caseBank/1c373052-0d14-4baa-8bcb-5f832fc92219.py");
        caset.setType("appium");
        caset.setTime("5");

        test.setCaset(caset);*//*

        task.setTest(test);

        List<Mobile> mobiles = new ArrayList<Mobile>();
        *//*Mobile mobile1 = new Mobile();
        mobile1.setOs("android 6.0");
        mobile1.setBrand("Huawei");
        mobile1.setModel("HUAWEI MT7-CL00");
        mobile1.setSn("G2W7N15120024967");
        mobile1.setIp("ip1.1.1.1");
        mobiles.add(mobile1);*//*

        Mobile mobile2 = new Mobile();
        mobile2.setOs("android 4.4.2");
        mobile2.setBrand("Huawei");
        mobile2.setModel("HUAWEI P7-L07");
        mobile2.setSn("022MWW144V004620");
        mobile2.setIp("192.168.0.9");
        mobiles.add(mobile2);

        task.setMobiles(mobiles);

        //String result = transfer.transferToMtc(task);
        String result = taskConversion.conversion(task);

        System.out.println("result = " + result);

    }*/
}
