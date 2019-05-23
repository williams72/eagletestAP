package test.service;

import org.junit.Test;
import test.util.BaseTest;

/**
 * Created by beishan on 2016/12/5.
 */
public class ResPerServiceTest extends BaseTest {

    @Test
    public void addResPer() throws Exception{
        for(int i = 2; i <= 5; i++){
            for(int j = 1; j <= 4; j++){
                serviceManager.getResourcePermissionService().addResourcePermission(i, j);
            }
        }
    }

    @Test
    public void addRoleResper() throws Exception{
        for(int i = 1; i <= 20; i++){
            serviceManager.getRoleResperService().addRoleResper(1, i);
        }
    }
}
