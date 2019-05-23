package test.http;

import com.dilatoit.netsimulation.http.HttpUtils;
import com.dilatoit.netsimulation.http.SimpleParamEntity;
import org.junit.Test;

import java.util.List;

/**
 * Created by xueshan.wei on 5/12/2017.
 */
public class HttpUtilsTest {
    @Test
    public void testSendGet() throws Exception{
        String url = "http://localhost:8080/api/smtl";
        String params = null;
        String result = HttpUtils.sendGet(url, params);
        System.out.println(result);
    }

    @Test
    public void testSendPost() throws Exception{
        String url = "http://localhost:8080/api/smtl43";
        List<SimpleParamEntity> params = null;
        String result = HttpUtils.sendPost(url, params);
        System.out.println(result);
    }

    @Test
    public void testDeletePost() throws Exception{
        String url = "http://localhost:8080/api/smtl";
        String params = null;
        String result = HttpUtils.sendDelete(url);
        System.out.println(result);
    }
    @Test
    public void testgetRFLogPost() throws Exception{
        String url = "http://10.0.40.49:8001/task/getRFLog";
        String params = "{" +
                "\"taskId\":\"884\",\n" +
                "\"serialNumber\":\"0123456789ABCDEF\"" +
                "}";

        String result = HttpUtils.sendJsonPost(url, params);
        System.out.println(result);
    }
}
