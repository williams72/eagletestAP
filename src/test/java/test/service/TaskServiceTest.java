package test.service;

import org.junit.Test;
import test.util.BaseTest;

/**
 * Created by xueshan.wei on 12/6/2016.
 */
public class TaskServiceTest extends BaseTest {
    @Test
    public void queryTaskResult() throws Exception{
        System.out.println(serviceManager.getTaskService().queryTaskResult(1));
    }

    @Test
    public void testSyon()throws Exception{
        serviceManager.getTaskService().synoSubTask(12);
    }
    @Test
    public void testSynoSubtask() throws Exception{
        String result = "{\"status\": \"success\", \"result\": {\"os\": \"1\", \"deviceDetail\": {\"subTaskResult\": {"
                    + "\"compatibility\": [\""
                    +"{\"serial_number\": \"57d6baae\", \"install\": \"2\", \"uninstall\": \"2\", \"stability\": \"2\", \"cpu_avg\": \"4.34091\", \"mem_max\": \"113208\", \"net_recv\": \"0\", \"net_send\": \"0\", \"power_usage\": \"0.2\", \"launch_time\": \"210\", \"model\": \"ONE A2001\", \"os\": \"android 5.1.1\", \"brand\": \"OnePlus\", \"resolution\": \"0x0\"},"
                +"{\"serial_number\": \"2a2a7bc\", \"install\": \"3\", \"uninstall\": \"4\", \"stability\": \"4\", \"cpu_avg\": \"-1\", \"mem_max\": \"-1\", \"net_recv\": \"-1\", \"net_send\": \"-1\", \"power_usage\": \"-1\", \"launch_time\": \"-1\", \"model\": \"vivo X5Max L\", \"os\": \"android 4.4.4\", \"brand\": \"vivo\", \"resolution\": \"1080x1920\"},"
                +"{\"serial_number\": \"85OACM6V4WCZ\", \"install\": \"2\", \"uninstall\": \"2\", \"stability\": \"2\", \"cpu_avg\": \"3.02273\", \"mem_max\": \"77231\", \"net_recv\": \"0\", \"net_send\": \"0\", \"power_usage\": \"0\", \"launch_time\": \"454\", \"model\": \"MX5\", \"os\": \"android 5.1\", \"brand\": \"Meizu\", \"resolution\": \"1080x1920\""
                +"}],\"case\": ["
                +"{\"serial_number\": \"57d6baae\", \"install\": \"2\", \"uninstall\": \"2\", \"stability\": \"3\", \"cpu_avg\": \"1.6\", \"mem_max\": \"67065\", \"net_recv\": \"0\", \"net_send\": \"0\", \"power_usage\": \"0\", \"launch_time\": \"261\", \"model\": \"ONE A2001\", \"os\": \"android 5.1.1\", \"brand\": \"OnePlus\", \"resolution\": \"0x0\"},"
                +"{\"serial_number\": \"2a2a7bc\", \"install\": \"3\", \"uninstall\": \"4\", \"stability\": \"4\", \"cpu_avg\": \"-1\", \"mem_max\": \"-1\", \"net_recv\": \"-1\", \"net_send\": \"-1\", \"power_usage\": \"-1\", \"launch_time\": \"-1\", \"model\": \"vivo X5Max L\", \"os\": \"android 4.4.4\", \"brand\": \"vivo\", \"resolution\": \"1080x1920\"},"
                +"{\"serial_number\": \"85OACM6V4WCZ\", \"install\": \"2\", \"uninstall\": \"2\", \"stability\": \"3\", \"cpu_avg\": \"0\", \"mem_max\": \"51116\", \"net_recv\": \"0\", \"net_send\": \"0\", \"power_usage\": \"0\", \"launch_time\": \"238\", \"model\": \"MX5\", \"os\": \"android 5.1\", \"brand\": \"Meizu\", \"resolution\": \"1080x1920\""
                +"}],\"travel\": [{\"serial_number\": \"57d6baae\", \"install\": \"2\", \"uninstall\": \"2\", \"stability\": \"2\", \"cpu_avg\": \"4.45833\", \"mem_max\": \"94119\", \"net_recv\": \"0\", \"net_send\": \"0\", \"power_usage\": \"0.38\", \"launch_time\": \"350\", \"model\": \"ONE A2001\", \"os\": \"android 5.1.1\", \"brand\": \"OnePlus\", \"resolution\": \"0x0\"},"
                +"{\"serial_number\": \"2a2a7bc\", \"install\": \"3\", \"uninstall\": \"4\", \"stability\": \"4\", \"cpu_avg\": \"-1\", \"mem_max\": \"-1\", \"net_recv\": \"-1\", \"net_send\": \"-1\", \"power_usage\": \"-1\", \"launch_time\": \"-1\", \"model\": \"vivo X5Max L\", \"os\": \"android 4.4.4\", \"brand\": \"vivo\", \"resolution\": \"1080x1920\"},"
                +"{\"serial_number\": \"85OACM6V4WCZ\", \"install\": \"2\", \"uninstall\": \"2\", \"stability\": \"2\", \"cpu_avg\": \"3.76\", \"mem_max\": \"52124\", \"net_recv\": \"0\", \"net_send\": \"0\", \"power_usage\": \"0\", \"launch_time\": \"569\", \"model\": \"MX5\", \"os\": \"android 5.1\", \"brand\": \"Meizu\", \"resolution\": \"1080x1920\"}]}},"
                +"\"taskExcelReport\": \"\"}}";

        String result2 = "{\"status\": \"success\",\"result\": {\"os\": \"1\",\"deviceDetail\": {\"subTaskResult\": {\"compatibility\": [ {\"serial_number\": \"57d6baae\",\"install\": \"2\",\"uninstall\": \"2\",\"stability\": \"2\",\"cpu_avg\": \"4.34091\",\"mem_max\": \"113208\",\"net_recv\": \"0\",\"net_send\": \"0\",\"power_usage\": \"0.2\",\"launch_time\": \"210\",\"model\": \"ONE A2001\",\"os\": \"android 5.1.1\",\"brand\": \"OnePlus\",\"resolution\": \"0x0\"},{\"serial_number\": \"2a2a7bc\",\"install\": \"3\",\"uninstall\": \"4\",\"stability\": \"4\",\"cpu_avg\": \"-1\",\"mem_max\": \"-1\",\"net_recv\": \"-1\",\"net_send\": \"-1\",\"power_usage\": \"-1\",\"launch_time\": \"-1\",\"model\": \"vivo X5Max L\",\"os\": \"android 4.4.4\",\"brand\": \"vivo\",\"resolution\": \"1080x1920\"},{\"serial_number\": \"85OACM6V4WCZ\",\"install\": \"2\",\"uninstall\": \"2\",\"stability\": \"2\",\"cpu_avg\": \"3.02273\",\"mem_max\": \"77231\",\"net_recv\": \"0\",\"net_send\": \"0\",\"power_usage\": \"0\",\"launch_time\": \"454\",\"model\": \"MX5\",\"os\": \"android 5.1\",\"brand\": \"Meizu\",\"resolution\": \"1080x1920\"}],\"case\": [ {\"serial_number\": \"57d6baae\",\"install\": \"2\",\"uninstall\": \"2\",\"stability\": \"3\",\"cpu_avg\": \"1.6\",\"mem_max\": \"67065\",\"net_recv\": \"0\",\"net_send\": \"0\",\"power_usage\": \"0\",\"launch_time\": \"261\",\"model\": \"ONE A2001\",\"os\": \"android 5.1.1\",\"brand\": \"OnePlus\",\"resolution\": \"0x0\"},{\"serial_number\": \"2a2a7bc\",\"install\": \"3\",\"uninstall\": \"4\",\"stability\": \"4\",\"cpu_avg\": \"-1\",\"mem_max\": \"-1\",\"net_recv\": \"-1\",\"net_send\": \"-1\",\"power_usage\": \"-1\",\"launch_time\": \"-1\",\"model\": \"vivo X5Max L\",\"os\": \"android 4.4.4\",\"brand\": \"vivo\",\"resolution\": \"1080x1920\"},{\"serial_number\": \"85OACM6V4WCZ\",\"install\": \"2\",\"uninstall\": \"2\",\"stability\": \"3\",\"cpu_avg\": \"0\",\"mem_max\": \"51116\",\"net_recv\": \"0\",\"net_send\": \"0\",\"power_usage\": \"0\",\"launch_time\": \"238\",\"model\": \"MX5\",\"os\": \"android 5.1\",\"brand\": \"Meizu\",\"resolution\": \"1080x1920\"}],\"travel\": [ {\"serial_number\": \"57d6baae\",\"install\": \"2\",\"uninstall\": \"2\",\"stability\": \"2\",\"cpu_avg\": \"4.45833\",\"mem_max\": \"94119\",\"net_recv\": \"0\",\"net_send\": \"0\",\"power_usage\": \"0.38\",\"launch_time\": \"350\",\"model\": \"ONE A2001\",\"os\": \"android 5.1.1\",\"brand\": \"OnePlus\",\"resolution\": \"0x0\"},{\"serial_number\": \"2a2a7bc\",\"install\": \"3\",\"uninstall\": \"4\",\"stability\": \"4\",\"cpu_avg\": \"-1\",\"mem_max\": \"-1\",\"net_recv\": \"-1\",\"net_send\": \"-1\",\"power_usage\": \"-1\",\"launch_time\": \"-1\",\"model\": \"vivo X5Max L\",\"os\": \"android 4.4.4\",\"brand\": \"vivo\",\"resolution\": \"1080x1920\"},{\"serial_number\": \"85OACM6V4WCZ\",\"install\": \"2\",\"uninstall\": \"2\",\"stability\": \"2\",\"cpu_avg\": \"3.76\",\"mem_max\": \"52124\",\"net_recv\": \"0\",\"net_send\": \"0\",\"power_usage\": \"0\",\"launch_time\": \"569\",\"model\": \"MX5\",\"os\": \"android 5.1\",\"brand\": \"Meizu\",\"resolution\": \"1080x1920\"}]}},\"taskExcelReport\": \"\"}}";

        String result3 = "{\n" +
                "  \"status\": \"success\",\n" +
                "  \"result\": {\n" +
                "    \"runSummary\": {\n" +
                "      \"compatibility\": {\n" +
                "        \"installError\": 1,\n" +
                "        \"runError\": 0,\n" +
                "        \"uninstallError\": 0,\n" +
                "        \"notRun\": 0,\n" +
                "        \"pass\": 2\n" +
                "      },\n" +
                "      \"case\": {\n" +
                "        \"installError\": 1,\n" +
                "        \"runError\": 2,\n" +
                "        \"uninstallError\": 0,\n" +
                "        \"notRun\": 0,\n" +
                "        \"pass\": 0\n" +
                "      },\n" +
                "      \"travel\": {\n" +
                "        \"installError\": 1,\n" +
                "        \"runError\": 0,\n" +
                "        \"uninstallError\": 0,\n" +
                "        \"notRun\": 0,\n" +
                "        \"pass\": 2\n" +
                "      }\n" +
                "    },\n" +
                "    \"tab\": {\n" +
                "      \"summary\": \"结果综述\",\n" +
                "      \"compatibility\": \"兼容测试报告\",\n" +
                "      \"case\": \"脚本测试报告\",\n" +
                "      \"travel\": \"遍历测试报告\",\n" +
                "      \"performance\": \"性能报告\",\n" +
                "      \"devices\": \"终端列表\"\n" +
                "    },\n" +
                "    \"os\": \"1\",\n" +
                "    \"deviceDetail\": {\n" +
                "      \"result\": {\n" +
                "        \"all\": [\n" +
                "          {\n" +
                "            \"name\": \"ONE A2001(android 5.1.1)\",\n" +
                "            \"result\": \"fail\",\n" +
                "            \"install\": \"pass\",\n" +
                "            \"monkey\": \"fail\",\n" +
                "            \"uninstall\": \"pass\",\n" +
                "            \"model\": \"ONE A2001\",\n" +
                "            \"os\": \"android 5.1.1\",\n" +
                "            \"fail_cause\": null,\n" +
                "            \"brand\": \"OnePlus\",\n" +
                "            \"serial_number\": \"57d6baae\",\n" +
                "            \"resolution\": \"0x0\",\n" +
                "            \"performance\": null\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"vivo X5Max L(android 4.4.4)\",\n" +
                "            \"result\": \"fail\",\n" +
                "            \"install\": \"fail\",\n" +
                "            \"monkey\": \"fail\",\n" +
                "            \"uninstall\": \"fail\",\n" +
                "            \"model\": \"vivo X5Max L\",\n" +
                "            \"os\": \"android 4.4.4\",\n" +
                "            \"fail_cause\": null,\n" +
                "            \"brand\": \"vivo\",\n" +
                "            \"serial_number\": \"2a2a7bc\",\n" +
                "            \"resolution\": \"1080x1920\",\n" +
                "            \"performance\": null\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"MX5(android 5.1)\",\n" +
                "            \"result\": \"fail\",\n" +
                "            \"install\": \"pass\",\n" +
                "            \"monkey\": \"fail\",\n" +
                "            \"uninstall\": \"pass\",\n" +
                "            \"model\": \"MX5\",\n" +
                "            \"os\": \"android 5.1\",\n" +
                "            \"fail_cause\": null,\n" +
                "            \"brand\": \"Meizu\",\n" +
                "            \"serial_number\": \"85OACM6V4WCZ\",\n" +
                "            \"resolution\": \"1080x1920\",\n" +
                "            \"performance\": null\n" +
                "          }\n" +
                "        ],\n" +
                "        \"fail\": [\n" +
                "          {\n" +
                "            \"name\": \"ONE A2001(android 5.1.1)\",\n" +
                "            \"result\": \"fail\",\n" +
                "            \"install\": \"pass\",\n" +
                "            \"monkey\": \"fail\",\n" +
                "            \"uninstall\": \"pass\",\n" +
                "            \"model\": \"ONE A2001\",\n" +
                "            \"os\": \"android 5.1.1\",\n" +
                "            \"fail_cause\": null,\n" +
                "            \"brand\": \"OnePlus\",\n" +
                "            \"serial_number\": \"57d6baae\",\n" +
                "            \"resolution\": \"0x0\",\n" +
                "            \"performance\": null\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"vivo X5Max L(android 4.4.4)\",\n" +
                "            \"result\": \"fail\",\n" +
                "            \"install\": \"fail\",\n" +
                "            \"monkey\": \"fail\",\n" +
                "            \"uninstall\": \"fail\",\n" +
                "            \"model\": \"vivo X5Max L\",\n" +
                "            \"os\": \"android 4.4.4\",\n" +
                "            \"fail_cause\": null,\n" +
                "            \"brand\": \"vivo\",\n" +
                "            \"serial_number\": \"2a2a7bc\",\n" +
                "            \"resolution\": \"1080x1920\",\n" +
                "            \"performance\": null\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"MX5(android 5.1)\",\n" +
                "            \"result\": \"fail\",\n" +
                "            \"install\": \"pass\",\n" +
                "            \"monkey\": \"fail\",\n" +
                "            \"uninstall\": \"pass\",\n" +
                "            \"model\": \"MX5\",\n" +
                "            \"os\": \"android 5.1\",\n" +
                "            \"fail_cause\": null,\n" +
                "            \"brand\": \"Meizu\",\n" +
                "            \"serial_number\": \"85OACM6V4WCZ\",\n" +
                "            \"resolution\": \"1080x1920\",\n" +
                "            \"performance\": null\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      \"brand\": {\n" +
                "        \"OnePlus\": [\n" +
                "          {\n" +
                "            \"name\": \"ONE A2001(android 5.1.1)\",\n" +
                "            \"result\": \"fail\",\n" +
                "            \"install\": \"pass\",\n" +
                "            \"monkey\": \"fail\",\n" +
                "            \"uninstall\": \"pass\",\n" +
                "            \"model\": \"ONE A2001\",\n" +
                "            \"os\": \"android 5.1.1\",\n" +
                "            \"fail_cause\": null,\n" +
                "            \"brand\": \"OnePlus\",\n" +
                "            \"serial_number\": \"57d6baae\",\n" +
                "            \"resolution\": \"0x0\",\n" +
                "            \"performance\": null\n" +
                "          }\n" +
                "        ],\n" +
                "        \"vivo\": [\n" +
                "          {\n" +
                "            \"name\": \"vivo X5Max L(android 4.4.4)\",\n" +
                "            \"result\": \"fail\",\n" +
                "            \"install\": \"fail\",\n" +
                "            \"monkey\": \"fail\",\n" +
                "            \"uninstall\": \"fail\",\n" +
                "            \"model\": \"vivo X5Max L\",\n" +
                "            \"os\": \"android 4.4.4\",\n" +
                "            \"fail_cause\": null,\n" +
                "            \"brand\": \"vivo\",\n" +
                "            \"serial_number\": \"2a2a7bc\",\n" +
                "            \"resolution\": \"1080x1920\",\n" +
                "            \"performance\": null\n" +
                "          }\n" +
                "        ],\n" +
                "        \"Meizu\": [\n" +
                "          {\n" +
                "            \"name\": \"MX5(android 5.1)\",\n" +
                "            \"result\": \"fail\",\n" +
                "            \"install\": \"pass\",\n" +
                "            \"monkey\": \"fail\",\n" +
                "            \"uninstall\": \"pass\",\n" +
                "            \"model\": \"MX5\",\n" +
                "            \"os\": \"android 5.1\",\n" +
                "            \"fail_cause\": null,\n" +
                "            \"brand\": \"Meizu\",\n" +
                "            \"serial_number\": \"85OACM6V4WCZ\",\n" +
                "            \"resolution\": \"1080x1920\",\n" +
                "            \"performance\": null\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      \"os\": {\n" +
                "        \"android 5.1.1\": [\n" +
                "          {\n" +
                "            \"name\": \"ONE A2001(android 5.1.1)\",\n" +
                "            \"result\": \"fail\",\n" +
                "            \"install\": \"pass\",\n" +
                "            \"monkey\": \"fail\",\n" +
                "            \"uninstall\": \"pass\",\n" +
                "            \"model\": \"ONE A2001\",\n" +
                "            \"os\": \"android 5.1.1\",\n" +
                "            \"fail_cause\": null,\n" +
                "            \"brand\": \"OnePlus\",\n" +
                "            \"serial_number\": \"57d6baae\",\n" +
                "            \"resolution\": \"0x0\",\n" +
                "            \"performance\": null\n" +
                "          }\n" +
                "        ],\n" +
                "        \"android 4.4.4\": [\n" +
                "          {\n" +
                "            \"name\": \"vivo X5Max L(android 4.4.4)\",\n" +
                "            \"result\": \"fail\",\n" +
                "            \"install\": \"fail\",\n" +
                "            \"monkey\": \"fail\",\n" +
                "            \"uninstall\": \"fail\",\n" +
                "            \"model\": \"vivo X5Max L\",\n" +
                "            \"os\": \"android 4.4.4\",\n" +
                "            \"fail_cause\": null,\n" +
                "            \"brand\": \"vivo\",\n" +
                "            \"serial_number\": \"2a2a7bc\",\n" +
                "            \"resolution\": \"1080x1920\",\n" +
                "            \"performance\": null\n" +
                "          }\n" +
                "        ],\n" +
                "        \"android 5.1\": [\n" +
                "          {\n" +
                "            \"name\": \"MX5(android 5.1)\",\n" +
                "            \"result\": \"fail\",\n" +
                "            \"install\": \"pass\",\n" +
                "            \"monkey\": \"fail\",\n" +
                "            \"uninstall\": \"pass\",\n" +
                "            \"model\": \"MX5\",\n" +
                "            \"os\": \"android 5.1\",\n" +
                "            \"fail_cause\": null,\n" +
                "            \"brand\": \"Meizu\",\n" +
                "            \"serial_number\": \"85OACM6V4WCZ\",\n" +
                "            \"resolution\": \"1080x1920\",\n" +
                "            \"performance\": null\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      \"resolution\": {\n" +
                "        \"0x0\": [\n" +
                "          {\n" +
                "            \"name\": \"ONE A2001(android 5.1.1)\",\n" +
                "            \"result\": \"fail\",\n" +
                "            \"install\": \"pass\",\n" +
                "            \"monkey\": \"fail\",\n" +
                "            \"uninstall\": \"pass\",\n" +
                "            \"model\": \"ONE A2001\",\n" +
                "            \"os\": \"android 5.1.1\",\n" +
                "            \"fail_cause\": null,\n" +
                "            \"brand\": \"OnePlus\",\n" +
                "            \"serial_number\": \"57d6baae\",\n" +
                "            \"resolution\": \"0x0\",\n" +
                "            \"performance\": null\n" +
                "          }\n" +
                "        ],\n" +
                "        \"1080x1920\": [\n" +
                "          {\n" +
                "            \"name\": \"vivo X5Max L(android 4.4.4)\",\n" +
                "            \"result\": \"fail\",\n" +
                "            \"install\": \"fail\",\n" +
                "            \"monkey\": \"fail\",\n" +
                "            \"uninstall\": \"fail\",\n" +
                "            \"model\": \"vivo X5Max L\",\n" +
                "            \"os\": \"android 4.4.4\",\n" +
                "            \"fail_cause\": null,\n" +
                "            \"brand\": \"vivo\",\n" +
                "            \"serial_number\": \"2a2a7bc\",\n" +
                "            \"resolution\": \"1080x1920\",\n" +
                "            \"performance\": null\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"MX5(android 5.1)\",\n" +
                "            \"result\": \"fail\",\n" +
                "            \"install\": \"pass\",\n" +
                "            \"monkey\": \"fail\",\n" +
                "            \"uninstall\": \"pass\",\n" +
                "            \"model\": \"MX5\",\n" +
                "            \"os\": \"android 5.1\",\n" +
                "            \"fail_cause\": null,\n" +
                "            \"brand\": \"Meizu\",\n" +
                "            \"serial_number\": \"85OACM6V4WCZ\",\n" +
                "            \"resolution\": \"1080x1920\",\n" +
                "            \"performance\": null\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      \"isSelectModel\": null,\n" +
                "      \"performance\": {\n" +
                "        \"cpu_avg\": {\n" +
                "          \"avg\": 0,\n" +
                "          \"count\": 0,\n" +
                "          \"min\": -1,\n" +
                "          \"max\": -1,\n" +
                "          \"min_device\": null,\n" +
                "          \"max_device\": null,\n" +
                "          \"worst_5\": []\n" +
                "        },\n" +
                "        \"mem_max\": {\n" +
                "          \"avg\": 0,\n" +
                "          \"count\": 0,\n" +
                "          \"min\": -1,\n" +
                "          \"max\": -1,\n" +
                "          \"min_device\": null,\n" +
                "          \"max_device\": null,\n" +
                "          \"worst_5\": []\n" +
                "        },\n" +
                "        \"net_recv\": {\n" +
                "          \"avg\": 0,\n" +
                "          \"count\": 0,\n" +
                "          \"min\": -1,\n" +
                "          \"max\": -1,\n" +
                "          \"min_device\": null,\n" +
                "          \"max_device\": null,\n" +
                "          \"worst_5\": []\n" +
                "        },\n" +
                "        \"net_send\": {\n" +
                "          \"avg\": 0,\n" +
                "          \"count\": 0,\n" +
                "          \"min\": -1,\n" +
                "          \"max\": -1,\n" +
                "          \"min_device\": null,\n" +
                "          \"max_device\": null,\n" +
                "          \"worst_5\": []\n" +
                "        },\n" +
                "        \"power_usage\": {\n" +
                "          \"avg\": 0,\n" +
                "          \"count\": 0,\n" +
                "          \"min\": -1,\n" +
                "          \"max\": -1,\n" +
                "          \"min_device\": null,\n" +
                "          \"max_device\": null,\n" +
                "          \"worst_5\": []\n" +
                "        },\n" +
                "        \"launch_time\": {\n" +
                "          \"avg\": 0,\n" +
                "          \"count\": 0,\n" +
                "          \"min\": -1,\n" +
                "          \"max\": -1,\n" +
                "          \"min_device\": null,\n" +
                "          \"max_device\": null,\n" +
                "          \"worst_5\": []\n" +
                "        }\n" +
                "      },\n" +
                "      \"subTaskResult\": {\n" +
                "        \"compatibility\": [\n" +
                "          {\n" +
                "            \"serial_number\": \"57d6baae\",\n" +
                "            \"install\": \"2\",\n" +
                "            \"uninstall\": \"2\",\n" +
                "            \"stability\": \"2\",\n" +
                "            \"cpu_avg\": \"4.34091\",\n" +
                "            \"mem_max\": \"113208\",\n" +
                "            \"net_recv\": \"0\",\n" +
                "            \"net_send\": \"0\",\n" +
                "            \"power_usage\": \"0.2\",\n" +
                "            \"launch_time\": \"210\",\n" +
                "            \"model\": \"ONE A2001\",\n" +
                "            \"os\": \"android 5.1.1\",\n" +
                "            \"brand\": \"OnePlus\",\n" +
                "            \"resolution\": \"0x0\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"serial_number\": \"2a2a7bc\",\n" +
                "            \"install\": \"3\",\n" +
                "            \"uninstall\": \"4\",\n" +
                "            \"stability\": \"4\",\n" +
                "            \"cpu_avg\": \"-1\",\n" +
                "            \"mem_max\": \"-1\",\n" +
                "            \"net_recv\": \"-1\",\n" +
                "            \"net_send\": \"-1\",\n" +
                "            \"power_usage\": \"-1\",\n" +
                "            \"launch_time\": \"-1\",\n" +
                "            \"model\": \"vivo X5Max L\",\n" +
                "            \"os\": \"android 4.4.4\",\n" +
                "            \"brand\": \"vivo\",\n" +
                "            \"resolution\": \"1080x1920\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"serial_number\": \"85OACM6V4WCZ\",\n" +
                "            \"install\": \"2\",\n" +
                "            \"uninstall\": \"2\",\n" +
                "            \"stability\": \"2\",\n" +
                "            \"cpu_avg\": \"3.02273\",\n" +
                "            \"mem_max\": \"77231\",\n" +
                "            \"net_recv\": \"0\",\n" +
                "            \"net_send\": \"0\",\n" +
                "            \"power_usage\": \"0\",\n" +
                "            \"launch_time\": \"454\",\n" +
                "            \"model\": \"MX5\",\n" +
                "            \"os\": \"android 5.1\",\n" +
                "            \"brand\": \"Meizu\",\n" +
                "            \"resolution\": \"1080x1920\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"case\": [\n" +
                "          {\n" +
                "            \"serial_number\": \"57d6baae\",\n" +
                "            \"install\": \"2\",\n" +
                "            \"uninstall\": \"2\",\n" +
                "            \"stability\": \"3\",\n" +
                "            \"cpu_avg\": \"1.6\",\n" +
                "            \"mem_max\": \"67065\",\n" +
                "            \"net_recv\": \"0\",\n" +
                "            \"net_send\": \"0\",\n" +
                "            \"power_usage\": \"0\",\n" +
                "            \"launch_time\": \"261\",\n" +
                "            \"model\": \"ONE A2001\",\n" +
                "            \"os\": \"android 5.1.1\",\n" +
                "            \"brand\": \"OnePlus\",\n" +
                "            \"resolution\": \"0x0\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"serial_number\": \"2a2a7bc\",\n" +
                "            \"install\": \"3\",\n" +
                "            \"uninstall\": \"4\",\n" +
                "            \"stability\": \"4\",\n" +
                "            \"cpu_avg\": \"-1\",\n" +
                "            \"mem_max\": \"-1\",\n" +
                "            \"net_recv\": \"-1\",\n" +
                "            \"net_send\": \"-1\",\n" +
                "            \"power_usage\": \"-1\",\n" +
                "            \"launch_time\": \"-1\",\n" +
                "            \"model\": \"vivo X5Max L\",\n" +
                "            \"os\": \"android 4.4.4\",\n" +
                "            \"brand\": \"vivo\",\n" +
                "            \"resolution\": \"1080x1920\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"serial_number\": \"85OACM6V4WCZ\",\n" +
                "            \"install\": \"2\",\n" +
                "            \"uninstall\": \"2\",\n" +
                "            \"stability\": \"3\",\n" +
                "            \"cpu_avg\": \"0\",\n" +
                "            \"mem_max\": \"51116\",\n" +
                "            \"net_recv\": \"0\",\n" +
                "            \"net_send\": \"0\",\n" +
                "            \"power_usage\": \"0\",\n" +
                "            \"launch_time\": \"238\",\n" +
                "            \"model\": \"MX5\",\n" +
                "            \"os\": \"android 5.1\",\n" +
                "            \"brand\": \"Meizu\",\n" +
                "            \"resolution\": \"1080x1920\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"travel\": [\n" +
                "          {\n" +
                "            \"serial_number\": \"57d6baae\",\n" +
                "            \"install\": \"2\",\n" +
                "            \"uninstall\": \"2\",\n" +
                "            \"stability\": \"2\",\n" +
                "            \"cpu_avg\": \"4.45833\",\n" +
                "            \"mem_max\": \"94119\",\n" +
                "            \"net_recv\": \"0\",\n" +
                "            \"net_send\": \"0\",\n" +
                "            \"power_usage\": \"0.38\",\n" +
                "            \"launch_time\": \"350\",\n" +
                "            \"model\": \"ONE A2001\",\n" +
                "            \"os\": \"android 5.1.1\",\n" +
                "            \"brand\": \"OnePlus\",\n" +
                "            \"resolution\": \"0x0\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"serial_number\": \"2a2a7bc\",\n" +
                "            \"install\": \"3\",\n" +
                "            \"uninstall\": \"4\",\n" +
                "            \"stability\": \"4\",\n" +
                "            \"cpu_avg\": \"-1\",\n" +
                "            \"mem_max\": \"-1\",\n" +
                "            \"net_recv\": \"-1\",\n" +
                "            \"net_send\": \"-1\",\n" +
                "            \"power_usage\": \"-1\",\n" +
                "            \"launch_time\": \"-1\",\n" +
                "            \"model\": \"vivo X5Max L\",\n" +
                "            \"os\": \"android 4.4.4\",\n" +
                "            \"brand\": \"vivo\",\n" +
                "            \"resolution\": \"1080x1920\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"serial_number\": \"85OACM6V4WCZ\",\n" +
                "            \"install\": \"2\",\n" +
                "            \"uninstall\": \"2\",\n" +
                "            \"stability\": \"2\",\n" +
                "            \"cpu_avg\": \"3.76\",\n" +
                "            \"mem_max\": \"52124\",\n" +
                "            \"net_recv\": \"0\",\n" +
                "            \"net_send\": \"0\",\n" +
                "            \"power_usage\": \"0\",\n" +
                "            \"launch_time\": \"569\",\n" +
                "            \"model\": \"MX5\",\n" +
                "            \"os\": \"android 5.1\",\n" +
                "            \"brand\": \"Meizu\",\n" +
                "            \"resolution\": \"1080x1920\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    },\n" +
                "    \"taskExcelReport\": \"\"\n" +
                "  }\n" +
                "}";
        serviceManager.getTaskService().synoSubTask(1, result3);
    }
}
