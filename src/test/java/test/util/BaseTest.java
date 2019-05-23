package test.util;

/**
 * Created by beishan on 2016/11/12.
 */
import com.dilatoit.eagletest.dao.impl.BaseDAO;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.dilatoit.eagletest.service.impl.ServiceManager;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml", "classpath:spring/springmvc-servlet.xml"})
public class BaseTest {
    @Autowired
    protected ServiceManager serviceManager;

    @Resource(name="baseDAO")
    protected BaseDAO baseDAO;
}
