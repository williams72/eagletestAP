package test.authority;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xueshan.wei on 12/5/2016.
 */
public class SplitPermission {
    @Test
    public void split() throws Exception{
        String permission1 = "user:add,query";
        String permission2 = "project:add";

        List<String> ps = parsePermission(permission1);
        for(String p : ps){
            System.out.println(p);
        }
    }

    public List<String> parsePermission(String permission){
        List<String> result = new ArrayList<String>();
        if(permission != null && permission.length() > 0){
            String rp[] = permission.split(":");
            String resource = rp[0];
            String [] ops = rp[1].split(",");

            for(int i = 0; i < ops.length; i++){
                result.add(resource + ":" + ops[i]);
            }
        }else{
            System.out.println("权限字符串既不能为null，也不能为空！");
        }
        return result;
    }
}
