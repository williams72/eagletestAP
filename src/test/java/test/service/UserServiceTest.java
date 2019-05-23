package test.service;

import com.dilatoit.eagletest.model.EtRole;
import com.dilatoit.eagletest.model.EtUser;
import com.dilatoit.eagletest.model.EtUserConfig;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;
import org.junit.Test;
import test.util.BaseTest;

import java.util.Date;
import java.util.List;

/**
 * Created by beishan on 2016/11/12.
 */
public class UserServiceTest extends BaseTest{

    @Test
    public void queryUserById() throws Exception{
        EtUser user = serviceManager.getUserService().queryUserById(14);
        System.out.println(user.getEtRoles().size());
    }

    @Test
    public void deleteUser() throws Exception{
        try{
            serviceManager.getUserService().deleteUser(10);
            System.out.println("删除成功 ！");
        }catch (Exception e){
            System.out.println("删除失败 ！");
        }
    }

    @Test
    public void changePassword() throws Exception{
        try{
            serviceManager.getUserService().changePassword(25,"123456");
            System.out.println("修改成功");

        }catch(Exception e){
            System.out.println("修改失败");
        }


    }




    /**
     * 分页查询用户测试
     * @throws Exception
     */
    @Test
    public void queryPage() throws Exception{
        Conditions conditions = new Conditions();
        conditions.addOrderBy("username", false);
        DataPage<EtUser> page = new DataPage<EtUser>();
        page.setOffset(1);
        page.setLimit(5);
        serviceManager.getUserService().page(page, conditions);
        System.out.println("总数据：" + page.getRows());
        for(EtUser u : page.getData()){
            System.out.println(u.getUsername());
        }
    }

    @Test
    public void isExistByEmailAndAccount() throws Exception{
        EtUser user = serviceManager.getUserService().isExistByUsernameOrEmail("admin@test.com");
        if(user != null){
            System.out.println("查出了");
        }else{
            System.out.println("no .....");
        }
    }
    /**
     *
     *
     * @throws Exception
     */
    @Test
    public void loginByUsernameOrEmail() throws Exception{
        /*if(serviceManager.getUserService().loginByUsernameOrEmail("admin", "123456")){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }*/
    }
    @Test
    public void loginByUsername() throws Exception{
        /*if(serviceManager.getUserService().loginByUsername("beishan", "123456")){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }*/
    }
    @Test
    public void loginByEmail() throws Exception{
        /*if(serviceManager.getUserService().loginByEmail("312251611@qq.com", "123456")){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }*/
    }
    @Test
    public void queryByUsername() throws Exception{
        EtUser u = serviceManager.getUserService().isExistByUsername("beishan");
        if(u != null){
            System.out.println(u.getUsername());
        }
    }
    @Test
    public void test() throws Exception{
        EtUser u = serviceManager.getUserService().queryUserById(1);
        for(EtRole r : u.getEtRoles()){
            System.out.println(r.getRolename());
        }
    }
    @Test
    public void addRole() throws Exception{
        serviceManager.getUserService().addRole(1, 2);
    }

    @Test
    public void removeRole() throws Exception{
        serviceManager.getUserService().removeRole(1, 2);
    }
    @Test
    public void addUser() throws Exception{
        EtUser user = new EtUser();
        user.setUsername("用户1");
        user.setPassword("123456");
        user.setEmail("31225122336@qq.com");

        serviceManager.getUserService().addUser(user);
    }
    @Test
    public void testSaveUser() throws Exception{
        EtUser user = new EtUser();
        user.setCreatetime(new Date());
        user.setDept("部门");
        user.setEmail("312251611@qq.com");
        user.setLastlogintime(new Date());
        user.setLastmodifiedtime(new Date());
        user.setPassword("123456");
        user.setPhonenum("34213213");
        user.setRealname("beishan2");
        user.setStatus(1);
        user.setUsername("real name");

        EtUserConfig config = new EtUserConfig();
        //config.setId(1);
        user.setEtUserConfig(config);

        EtRole role = serviceManager.getRoleService().queryRoleById(1);
        user.getEtRoles().add(role);

        serviceManager.getUserService().saveUser(user);
    }

    @Test
    public void testQueryAll() throws Exception{
        List<EtUser> users = serviceManager.getUserService().queryAll();
        for(EtUser u : users){
            System.out.println(u.getId() + "------" + u.getUsername());
        }
    }

    @Test
    public void testDisableUser() throws Exception{
        serviceManager.getUserService().disableUser(3);
    }

    @Test
    public void testEnableUser() throws  Exception{
        serviceManager.getUserService().enableUser(1);
    }
}
