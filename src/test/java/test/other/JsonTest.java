package test.other;

import com.dilatoit.eagletest.util.GsonUtils;
import com.google.gson.Gson;
import com.dilatoit.engine.engines.mtc.util.JsonTools;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by xueshan.wei on 11/25/2016.
 */
public class JsonTest {

    @Test
    public void test(){
        String str = "{\"status\":\"success\",\"appInfo\":{\"package_name\":\"fm.qingting.qtradio\",\"app_name\":\"\u873b\u8713FM\",\"version\":\"5.1.9\",\"version_code\":\"519\",\"icon\":\"http:\\/\\/10.0.40.49:8001\\/storage\\/download\\/apk-info\\/99373666caa60263287993c6fe9b775f.png\",\"build_number\":\"0.0.2.7\",\"sdk_version\":\"8\",\"package_activity\":\"fm.qingting.qtradio.QTRadioActivity\",\"size\":8.89,\"md5\":\"d2c5e5a78ec9f337964efde98304fad3\",\"sha1\":\"56d6254e07b0a3e1101777ff4c0a0f8c155696d0\",\"bcs_url\":\"http:\\/\\/10.0.40.49:8001\\/storage\\/download\\/apk\\/d2c5e5a78ec9f337964efde98304fad3.apk\"}}";
        System.out.println(str);
        Gson gson = new Gson();
        Map map = JsonTools.toMap(str);
        Map info = (Map) map.get("appInfo");
        System.out.println(gson.toJson(info));

        System.out.println(info.get("app_name"));
    }

    @Test
    public void test2(){
        for(int i = 0; i < 10; i++)
            System.out.println(UUID.randomUUID());
    }

    @Test
    public void test3(){
        String name = "tempcases.zip";
        System.out.println(name.substring(name.lastIndexOf(".")));
    }

    @Test
    public void testForeachList() throws Exception{
        List<String > list = null;
        for(String s : list){
            System.out.println(s);
        }
    }

    @Test
    public void testMobileReturnResult() throws Exception{
        String result = "{\"filter\":[{\"key\":\"brand\",\"value\":\"品牌\",\"options\":[\"全部\"]},{\"key\":\"os\",\"value\":\"操作系统\",\"options\":[\"全部\"]},{\"key\":\"status\",\"value\":\"状态\",\"options\":[\"全部\"]},{\"key\":\"resolution\",\"value\":\"分辨率\",\"options\":[\"全部\"]}],\"mobile\":null,\"status\":\"success\"}";
        Gson gson = new Gson();
        Map map = gson.fromJson(result, Map.class);
        if(map.containsKey("status") && "success".equals(map.get("status"))){
            System.out.println("接口调用正常");
            List mobiles = (List) map.get("mobile");
            if(mobiles != null){
                System.out.println(mobiles.size());
            }else {
                System.out.println("mobiles null");
            }
        }
    }

    @Test
    public void testStrZhuanYi() throws Exception{
        String str = "str:\\\\";
        System.out.println(str);
        System.out.println(GsonUtils.toJsonString(str.toString()));
    }

    @Test
    public void testWeak() throws Exception{
        String str = "{\n" +
        "    \"down\": {\n" +
                "        \"rate\": 780,\n" +
                "        \"loss\": {\n" +
                "            \"percentage\": 0.0,\n" +
                "            \"correlation\": 0.0\n" +
                "        },\n" +
                "        \"delay\": {\n" +
                "            \"delay\": 100,\n" +
                "            \"jitter\": 0,\n" +
                "            \"correlation\": 0.0\n" +
                "        },\n" +
                "        \"corruption\": {\n" +
                "            \"percentage\": 0.0,\n" +
                "            \"correlation\": 0.0\n" +
                "        },\n" +
                "        \"reorder\": {\n" +
                "            \"percentage\": 0.0,\n" +
                "            \"correlation\": 0.0,\n" +
                "            \"gap\": 0\n" +
                "        },\n" +
                "        \"iptables_options\": []\n" +
                "    },\n" +
                "    \"up\": {\n" +
                "        \"rate\": 330,\n" +
                "        \"loss\": {\n" +
                "            \"percentage\": 0.0,\n" +
                "            \"correlation\": 0.0\n" +
                "        },\n" +
                "        \"delay\": {\n" +
                "            \"delay\": 100,\n" +
                "            \"jitter\": 0,\n" +
                "            \"correlation\": 0.0\n" +
                "        },\n" +
                "        \"corruption\": {\n" +
                "            \"percentage\": 0.0,\n" +
                "            \"correlation\": 0.0\n" +
                "        },\n" +
                "        \"reorder\": {\n" +
                "            \"percentage\": 0.0,\n" +
                "            \"correlation\": 0.0,\n" +
                "            \"gap\": 0\n" +
                "        },\n" +
                "        \"iptables_options\": []\n" +
                "    }\n" +
                "}";
        String str2 = "{\n" +
                "    \"down\": {\n" +
                "        \"rate\": 35,\n" +
                "        \"loss\": {\n" +
                "            \"percentage\": 0.0,\n" +
                "            \"correlation\": 0.0\n" +
                "        },\n" +
                "        \"delay\": {\n" +
                "            \"delay\": 650,\n" +
                "            \"jitter\": 0,\n" +
                "            \"correlation\": 0.0\n" +
                "        },\n" +
                "        \"corruption\": {\n" +
                "            \"percentage\": 0.0,\n" +
                "            \"correlation\": 0.0\n" +
                "        },\n" +
                "        \"reorder\": {\n" +
                "            \"percentage\": 0.0,\n" +
                "            \"correlation\": 0.0,\n" +
                "            \"gap\": 0\n" +
                "        },\n" +
                "        \"iptables_options\": []\n" +
                "    },\n" +
                "    \"up\": {\n" +
                "        \"rate\": 32,\n" +
                "        \"loss\": {\n" +
                "            \"percentage\": 0.0,\n" +
                "            \"correlation\": 0.0\n" +
                "        },\n" +
                "        \"delay\": {\n" +
                "            \"delay\": 650,\n" +
                "            \"jitter\": 0,\n" +
                "            \"correlation\": 0.0\n" +
                "        },\n" +
                "        \"corruption\": {\n" +
                "            \"percentage\": 0.0,\n" +
                "            \"correlation\": 0.0\n" +
                "        },\n" +
                "        \"reorder\": {\n" +
                "            \"percentage\": 0.0,\n" +
                "            \"correlation\": 0.0,\n" +
                "            \"gap\": 0\n" +
                "        },\n" +
                "        \"iptables_options\": []\n" +
                "    }\n" +
                "}";

        String heigh_delay = "{\n" +
                "    \"down\": {\n" +
                "        \"rate\": 780,\n" +
                "        \"loss\": {\n" +
                "            \"percentage\": 0.0,\n" +
                "            \"correlation\": 0.0\n" +
                "        },\n" +
                "        \"delay\": {\n" +
                "            \"delay\": 100,\n" +
                "            \"jitter\": 0,\n" +
                "            \"correlation\": 0.0\n" +
                "        },\n" +
                "        \"corruption\": {\n" +
                "            \"percentage\": 0.0,\n" +
                "            \"correlation\": 0.0\n" +
                "        },\n" +
                "        \"reorder\": {\n" +
                "            \"percentage\": 0.0,\n" +
                "            \"correlation\": 0.0,\n" +
                "            \"gap\": 0\n" +
                "        },\n" +
                "        \"iptables_options\": []\n" +
                "    },\n" +
                "    \"up\": {\n" +
                "        \"rate\": 330,\n" +
                "        \"loss\": {\n" +
                "            \"percentage\": 0.0,\n" +
                "            \"correlation\": 0.0\n" +
                "        },\n" +
                "        \"delay\": {\n" +
                "            \"delay\": 100,\n" +
                "            \"jitter\": 0,\n" +
                "            \"correlation\": 0.0\n" +
                "        },\n" +
                "        \"corruption\": {\n" +
                "            \"percentage\": 0.0,\n" +
                "            \"correlation\": 0.0\n" +
                "        },\n" +
                "        \"reorder\": {\n" +
                "            \"percentage\": 0.0,\n" +
                "            \"correlation\": 0.0,\n" +
                "            \"gap\": 0\n" +
                "        },\n" +
                "        \"iptables_options\": []\n" +
                "    }\n" +
                "}";

        String heigh_lose =  "{\n" +
                "    \"down\": {\n" +
                "        \"rate\": 780,\n" +
                "        \"loss\": {\n" +
                "            \"percentage\": 0.8,\n" +
                "            \"correlation\": 0.0\n" +
                "        },\n" +
                "        \"delay\": {\n" +
                "            \"delay\": 100,\n" +
                "            \"jitter\": 0,\n" +
                "            \"correlation\": 0.0\n" +
                "        },\n" +
                "        \"corruption\": {\n" +
                "            \"percentage\": 0.0,\n" +
                "            \"correlation\": 0.0\n" +
                "        },\n" +
                "        \"reorder\": {\n" +
                "            \"percentage\": 0.0,\n" +
                "            \"correlation\": 0.0,\n" +
                "            \"gap\": 0\n" +
                "        },\n" +
                "        \"iptables_options\": []\n" +
                "    },\n" +
                "    \"up\": {\n" +
                "        \"rate\": 330,\n" +
                "        \"loss\": {\n" +
                "            \"percentage\": 0.8,\n" +
                "            \"correlation\": 0.0\n" +
                "        },\n" +
                "        \"delay\": {\n" +
                "            \"delay\": 100,\n" +
                "            \"jitter\": 0,\n" +
                "            \"correlation\": 0.0\n" +
                "        },\n" +
                "        \"corruption\": {\n" +
                "            \"percentage\": 0.0,\n" +
                "            \"correlation\": 0.0\n" +
                "        },\n" +
                "        \"reorder\": {\n" +
                "            \"percentage\": 0.0,\n" +
                "            \"correlation\": 0.0,\n" +
                "            \"gap\": 0\n" +
                "        },\n" +
                "        \"iptables_options\": []\n" +
                "    }\n" +
                "}";
        str2 = StringUtils.deleteWhitespace(str2);
        str = StringUtils.deleteWhitespace(str);
        heigh_delay = StringUtils.deleteWhitespace(heigh_delay);
        heigh_lose = StringUtils.deleteWhitespace(heigh_lose);

        System.out.println(str.length());
        System.out.println(str);
        System.out.println(str2.length());
        System.out.println(str2);
        System.out.println(heigh_delay.length());
        System.out.println(heigh_delay);
        System.out.println(heigh_lose.length());
        System.out.println(heigh_lose);
    }
}
