package test.other;

import org.junit.Test;

/**
 * Created by xueshan.wei on 11/21/2016.
 */
public class ExceptionTest {
    @Test
    public void test1(){
        if(test2()){
            System.out.println("正确");
        }else{
            System.out.println("错误");
        }
    }

    public boolean test2(){
        System.out.println("异常捕获之前");
        try{
            test3();
            System.out.println("不抛出异常执行");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("一场之后");
        }
        System.out.println("异常捕获之后");
        return false;
    }

    public void test3() throws Exception{
        throw new Exception("hahah");
    }

    public void test4(){

    }
}
