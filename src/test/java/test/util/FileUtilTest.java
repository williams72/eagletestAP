package test.util;

import com.dilatoit.eagletest.util.FileUtil;
import net.sf.json.JSONObject;
import org.junit.Test;
import java.io.File;
import java.io.IOException;


/**
 * Created by Salt on 2017/9/24.
 */
public class FileUtilTest {
    @Test
    public void  testUnzipFile() throws IOException{
        File file = new File("C:/Users/Salt/Desktop/Script.zip");
        String unZipPath = FileUtil.unZipFile(file.getAbsolutePath(), "C:/Users/Salt/Desktop");
        System.out.println(unZipPath);
    }

    @Test
    public void testGetFileLines()throws IOException{
        String filePath = "D:/IdeaProjects/eagletest/target/eagletest/static/et_data/rf_log/208-0123456789ABCDEF-log.txt";
        int count = FileUtil.getFileLines(filePath);
        System.out.println(count);
    }

    @Test
    public void testRefreshFile()throws IOException{
        String localFilePath = "D:/IdeaProjects/eagletest/target/eagletest/static/et_data/rf_log/log.txt";
        String serverFileUrl = "http://10.0.40.49:8001/storage/download/job-result/1277_result/result/monkey_robotFramework/robotFramework_log.log";
        FileUtil.refreshFile(localFilePath, serverFileUrl);
    }

    @Test
    public void testMtcServerFileIsExist(){
        String serverFileUrl = "http://10.0.40.49:8001/storage/download/job-result/1280_result/result/monkey_robotFramework/robot_framework_result/debug.txt";
        if(FileUtil.mtcServerFileIsExist(serverFileUrl)){
            System.out.println("存在的!");
        }else {
            System.out.println("不存在的！");
        }

    }

    @Test
    public void test(){
        String json = "{\"status\":\"success\",\"logDetail\":{\"0123456789ABCDEF\":[\"http:\\/\\/10.0.40.49:8001\\/storage\\/download\\/job-result\\/1280_result\\/result\\/monkey_robotFramework\\/robotFramework_log.log\",\"http:\\/\\/10.0.40.49:8001\\/storage\\/download\\/job-result\\/1280_result\\/result\\/monkey_robotFramework\\/robot_framework_result\\/debug.txt\"]}}";
        JSONObject jsonObject = JSONObject.fromObject(json);
        System.out.println(jsonObject.get("status"));
        System.out.println(jsonObject.getJSONObject("logDetail").getJSONArray("0123456789ABCDEF").get(0));
    }

}
