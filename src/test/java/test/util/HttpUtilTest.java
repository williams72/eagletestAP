package test.util;

import com.dilatoit.engine.engines.mtc.util.HttpUtil;
import org.junit.Test;

/**
 * Created by xueshan.wei on 11/16/2016.
 */
public class HttpUtilTest {
    @Test
    public void test()throws Exception{
        String url = "http://10.0.40.50:8001/mobile/getMobileInfo";
        String param = "type=ios";
        HttpUtil.sendPost(url, param);
    }
}
