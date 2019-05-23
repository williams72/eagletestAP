package test.other;

import org.junit.Test;

/**
 * Created by xueshan.wei on 12/8/2016.
 */
public class RegixTest {

    @Test
    public void test3() throws Exception{
        String str = "8,null";

        String [] strs = str.split(",");

        System.out.println(strs[0] + strs.length);
        System.out.println(Integer.parseInt(strs[0]));
    }
    @Test
    public void test()throws Exception{
        String str = "jiaoyan|beishan";
        String strs [] = str.split("|");
        for(String s : strs){
            System.out.println(s);
        }
    }

    @Test
    public  void test2() throws Exception{
        String s = "/project/5/createtask_1";
        s = s.replaceFirst("createtask_1", "createtask");
        System.out.println(s);
    }
}
