package test;


import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtMobile;
import com.dilatoit.eagletest.model.EtRole;
import com.dilatoit.eagletest.service.impl.EgMobileService;
import com.dilatoit.eagletest.util.DataPage;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import test.util.BaseTest;

import java.util.List;

/**
 * Created by Salt on 2017/10/23.
 */
public class DAOTest extends BaseTest{
    @Autowired
    EgMobileService egMobileService;
    @Test
    public void testQueryByName() throws DataBaseException{
        EtMobile etMobile = egMobileService.queryByName("serialNumber", "G2W7N15120024967");
        System.out.println(etMobile.toString());
    }

    @Test
    public void testExecuteNativeSqlQuery() throws DataBaseException{
        String sql = "select * from et_role e where e.rolevalue = ? and e.role_permission = ?";
        String[] param = {"1", "1"};
        List list = baseDAO.executeNativeSqlQuery(sql, param);
        System.out.println(list.size());
    }

    @Test
    public void testQueryByHql()throws DataBaseException{
        String hql = "from " + com.dilatoit.eagletest.model.EtRole.class.getName() + " e where e.rolePermission = ? and e.roleValue = ?";
        Object[] param = {"1", 1};
        List<EtRole> etRolesList = baseDAO.queryByHql(hql, param);
        System.out.println(etRolesList.get(0).toString());

    }

    @Test
    public void testQueryByPage()throws DataBaseException{
        String hql = "from " + com.dilatoit.eagletest.model.EtTask.class.getName() + " e where e.etProject.id = ? and e.status = ?";
        Object[] param = {36, 3};
        DataPage dataPage = baseDAO.queryByPage(hql, param, 5, 10);
        System.out.println(dataPage.toString());
    }
}
