package test.service;

import com.dilatoit.eagletest.enums.ProjectUserRole;
import com.dilatoit.eagletest.model.EtProject;
import com.dilatoit.eagletest.model.EtProjectUser;
import com.dilatoit.eagletest.model.EtUser;
import org.junit.Test;
import test.util.BaseTest;

import java.util.List;

/**
 * Created by xueshan.wei on 11/24/2016.
 */
public class ProjectServiceTest extends BaseTest {
    /**
     * 测试查询一个项目是否存在by 项目名称
     * @throws Exception
     */
    @Test
    public void testExistByProjectName() throws Exception{
        EtProject project = serviceManager.getProjectService().isExistByProjectName("安卓项目12");
        if(project != null){
            System.out.println("项目存在");
        }else{
            System.out.println("项目不存在");
        }
    }

    /**
     * 查询一个项目是否存在通过项目key
     * @throws Exception
     */
    @Test
    public void testExistByProjectKey() throws Exception{
        EtProject project = serviceManager.getProjectService().isExistByProjectKey("AN1");
        if(project != null){
            System.out.println("项目存在");
        }else{
            System.out.println("项目不存在");
        }
    }

    /**
     * 查询一个项目是否存在通过项目name 和 key
     * @throws Exception
     */
    @Test
    public void testExistByProjectNameAndKey() throws Exception{
        EtProject project = serviceManager.getProjectService().isExistByProjectNameAndKey("安卓项目12", "AN1");
        if(project != null){
            System.out.println("项目存在");
        }else{
            System.out.println("项目不存在");
        }
    }
    /**
     * 新建一个项目，并设置项目拥有者
     * @throws Exception
     */
    @Test
    public void createNewProject() throws Exception{
        EtProject project = new EtProject();
        project.setProjectKey("PR1");
        project.setProjectName("项目1124001");

        try{
            serviceManager.getProjectService().addProject(project, 11);
            System.out.println("创建项目成功 ！");
        }catch (Exception e){
            System.out.println("创建项目失败 ！");
        }

    }

    /**
     * 想项目中添加成员
     * @throws Exception
     */
    @Test
    public void addUser() throws Exception{
        try{
            //serviceManager.getProjectService().addUser(2, 10, ProjectUserRole.ADMIN);
            serviceManager.getProjectUserService().addMember(15, 24, 18, 7);
            System.out.println("添加成功 ！");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("添加失败 ！");
        }
    }

    @Test
    public void removeUser() throws Exception{
        try{

        }catch (Exception e){
            e.printStackTrace();

        }
    }

    /**
     * 显示项目中的所有用户以及他们的角色
     * @throws Exception
     */
    @Test
    public void queryUserAndRole() throws Exception{
        try{
            EtProject project = serviceManager.getProjectService().queryById(18);
            List<EtProjectUser> list = project.getEtProjectUsers();
            if(list != null && list.size() > 0){
                for(EtProjectUser pu : list){
                    System.out.println(pu.getEtUser().getUsername());
                    String rolename = null;
                    switch (pu.getProjectRole()){
                        case 0 : rolename = ProjectUserRole.OWNER.rolename();break;
                        case 1 : rolename = ProjectUserRole.ADMIN.rolename();break;
                        case 2 : rolename = ProjectUserRole.TESTER.rolename();break;
                        case 3 : rolename = ProjectUserRole.VIEWER.rolename();break;
                        default: rolename = "不知道";break;
                    }
                    System.out.println(rolename);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("查询失败 ！");
        }
    }

    @Test
    public void queryAllUser() throws Exception{
        EtProject project = serviceManager.getProjectService().queryById(2);
        for(EtUser u : project.getEtUsers()){
            System.out.println(u.getUsername());
        }
    }

    @Test
    public void testQueryMemeber() throws Exception{
        EtProjectUser projectUser = serviceManager.getProjectUserService().queryByPidAndUid(18, 15);
        if(projectUser != null){
            System.out.println("用户存在于当前项目");
        }else{
            System.out.println("用户不存在于当前项目");
        }

    }
}
