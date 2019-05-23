package test.service;

import com.dilatoit.eagletest.model.EtResPer;
import com.dilatoit.eagletest.model.EtRole;
import org.junit.Test;
import test.util.BaseTest;

/**
 * Created by beishan on 2016/11/13.
 */
public class RoleServiceTest extends BaseTest {
    @Test
    public void addRole() throws Exception{
        EtRole role = new EtRole();
        role.setRoleinfo("普通员工角色");
        role.setRolename("普通员工");
        role.setRolePermission("");

        serviceManager.getRoleService().save(role);
    }

    @Test
    public void queryRole() throws Exception{
        EtRole role = serviceManager.getRoleService().queryRoleById(2);
        for(EtResPer rp : role.getResPers()){
            System.out.println(rp.getResourcePermission());
        }
    }
}
