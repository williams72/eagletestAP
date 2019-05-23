package test.dto;

import com.dilatoit.eagletest.model.EtUser;
import org.junit.Test;

/**
 * Created by xueshan.wei on 5/16/2017.
 */
public class UserDtoTest {

    @Test
    public void testTranslate() throws Exception{
        EtUser user = new EtUser();
        user.setId(1);
        user.setEmail("dfsfsd@tkerj.com");
        //int num1 = null;
        int num2 = true ? 1 : null;
        String re = user.getCreatetime() == null ? "为空" : "不为空";
        long ctime = user.getCreatetime() == null ? 0 : user.getCreatetime().getTime();
        System.out.println(re);
        System.out.println(user);
        //UserDTO userDTO = UserDTOTranslate.translate(user);
        //System.out.println(userDTO);
    }
}
