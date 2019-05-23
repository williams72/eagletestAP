package test.service;

import com.dilatoit.eagletest.model.EtLog;
import org.junit.Test;
import test.util.BaseTest;

import java.util.Date;

/**
 * Created by xueshan.wei on 11/14/2016.
 */
public class LogServiceTest extends BaseTest {
    @Test
    public void addLog() throws Exception{
        EtLog log = new EtLog();
        log.setLogType(1);
        log.setOperateTime(new Date());
        log.setIp("10.0.40.40");
        log.setOperation("测试log service");
        log.setOperator("xueshan.wei");
        log.setParam("param");
        log.setUrl("/test");

        serviceManager.getLogService().save(log);
    }
}
