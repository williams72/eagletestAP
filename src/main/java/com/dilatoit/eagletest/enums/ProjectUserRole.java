package com.dilatoit.eagletest.enums;

/**
 * Created by xueshan.wei on 11/23/2016.
 */

/**
 * 项目成员 角色枚举类
 */
public enum ProjectUserRole {
    OWNER(0, "拥有者"), //项目拥有者
    ADMIN(1, "管理员"), //项目管理员
    TESTER(2, "测试者"), //项目测试者
    VIEWER(3, "观察者"); //项目观察者
    private int rolevalue;
    private String rolename;
    private ProjectUserRole(int rolevalue, String rolename){
        this.rolevalue = rolevalue;
        this.rolename = rolename;
    }

    public int value(){
        return rolevalue;
    }

    public String rolename(){
        return rolename;
    }

    public static ProjectUserRole getProjectUserRole(int roleValue){
        ProjectUserRole projectUserRole = null;
        switch (roleValue){
            case 0: projectUserRole = OWNER; break;
            case 1: projectUserRole = ADMIN; break;
            case 2: projectUserRole = TESTER; break;
            case 3: projectUserRole = VIEWER; break;
            default:break;
        }
        return projectUserRole;
    }
}
