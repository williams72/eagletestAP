package test.util;

import com.dilatoit.eagletest.util.SysConvert;
import org.junit.Test;

/**
 * Created by Salt on 2017/9/13.
 */
public class SysConvertTest {
    @Test
    public void  testHextoString(){
        String hex = "433a2f6c6f67";
        String str = SysConvert.hexToString(hex);
        System.out.println(str);
    }
}
