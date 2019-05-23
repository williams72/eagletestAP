package test.other;

import com.dilatoit.eagletest.model.EtTestType;
import com.dilatoit.eagletest.model.EtUser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xueshan.wei on 11/21/2016.
 */
public class Zengqingfor {

    @Test
    public void testStringBufferAndStringTime() throws Exception{
        StringBuffer sb = new StringBuffer();
        String s = "";
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            s += i;
        }
        long time2 = System.currentTimeMillis();
        System.out.println("String 用时为：" + (time2 - time1));

        long time3 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sb.append(i);
        }
        long time4 = System.currentTimeMillis();
        System.out.println("StringBuffer 用时为：" + (time4 - time3));
    }

    @Test
    public void testStringBufferAppend() throws Exception{
        StringBuffer temp = new StringBuffer("01");
        String [] strs = {"12", "32", "07", "23"};
        for(String str : strs){
            temp.append(',');
            temp.append(str);
        }
        System.out.println(temp.toString());
    }

    @Test
    public void tettt() throws Exception{
        EtTestType testType = new EtTestType();
        List<EtTestType> list = new ArrayList<EtTestType>();

        testType.setId(1);
        list.add(testType);

        testType = new EtTestType();
        testType.setId(2);
        list.add(testType);

        testType = new EtTestType();
        testType.setId(3);
        list.add(testType);

        for(EtTestType t : list){
            System.out.println(t.getId());
        }
    }
    @Test
    public void foraa(){
        List<EtUser> list = null;
        for(EtUser u : list){
            System.out.println("hhhh");
        }
        System.out.println("完毕");
    }

    @Test
    public void test(){
        Double d = 0.0d;
        if(d == 0){
            System.out.println("d = 0");
        }else{
            System.out.println("d != 0");
        }

        Double a = 0.23, b, c;
        b = a * 100;
        c = a * 100.0;
        System.out.println("b = " + b);
        System.out.println("c = " + c);
    }

}
