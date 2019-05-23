package test.util;

import com.dilatoit.eagletest.util.Tools;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Salt on 2017/10/25.
 */
public class ToolsTest {
    @Test
    public void testGetTempPath(){
        try{
            File file = File.createTempFile("test123", ".class");
            System.out.println(file.getAbsolutePath());
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(System.getenv("TMP"));
    }
}
