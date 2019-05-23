package com.dilatoit.eagletest.enums.log;

/**
 * Created by xueshan.wei on 12/9/2016.
 */
public enum SystemLog {
    LOG_DEFAULT("00000000", "默认日志内容"),
    USER_LOGIN("10000001", "用户登入"),
    USER_LOGOUT("10000002", "用户登出"),

    USER_UPDATE_PWD("10010001", "用户修改密码"),
    USER_UPDATE_PROFILE("10010002", "用户修改个人资料"),

    USER_ADD("10020001", "新增用户"),
    USER_DELETE("10020002", "删除用户"),
    USER_QUERY("10020003", "查询单个用户"),

    USER_UPDATE("10020004", "更新用户"),
    USER_DISABLE("10020005", "禁用用户"),
    USER_ENABLE("10020006", "解禁用户"),
    USERS_QUERY("10020007", "查询多个用户"),

    TASK_CREATE("20000001", "创建任务"),
    TASK_DELETE("20000002", "删除任务"),
    TASK_CHECK("20000003", "查看任务结果"),
    TASK_STOP("20000004", "停止任务"),
    TASK_SYS_STOP("20000005", "管理员停止任务"),

    PROJECT_CREATE("30000001", "创建项目"),
    PROJECT_DELETE("30000002", "删除项目"),
    PROJECT_UPDATE("30000003", "更新项目"),
    PROJECT_QUERY("30000004", "查询项目"),

    PROJECT_USER_ADD("30010004", "项目添加成员"),
    PROJECT_USER_CHANGE_ROLE("30010005", "项目更改成员身份"),
    PROJECT_USER_REMOVE("30010006", "项目移除成员"),

    APP_CREATE("40000001", "新建（上传）运行包"),
    APP_DELETE("40000002", "删除运行包"),
    APP_UPDATE("40000003", "更新运行包属性"),
    APP_QUERY("40000004", "查看项目app"),

    VERSION_CREATE("50000001", "新建版本"),
    VERSION_DELETE("50000002", "删除版本"),
    VERSION_UPDATE_STATUS("50000003", "更新版本状态"),
    VERSION_QUERY("50000004", "查看版本信息"),

    REALMOBILE_RENT("60000001", "借用真机"),
    REALMOBILE_RENEW("60000002", "续借真机"),
    REALMOBILE_STOP("60000003", "停止调试真机"),
    REALMOBILE_SYS_STOP("60000004", "管理员停止真机调试"),
    REALMOBILE_QUERY_ALL("60000005", "查询所有真机信息"),
    REALMOBILE_QUERY_INFO("60000006", "查询某个真机的信息"),

    MOBILE_RENAME("70000001", "重命名手机"),
    MOBILE_REBOOT("70000002", "重启手机"),
    MOBILE_STOP_TASK("70000003", "管理员停止手机任务"),
    MOBILE_QUERY("70010001", "查询在线手机"),

    LOG_QUERY("80000001", "日志查询"),

    SYSTEM_USER_PWD_UPDATE("80010001", "管理员修改用户密码"),

    SYSTEM_CONFIG_LANGUAGE_UPDATE("90010001", "更改系统语言"),
    SYSTEM_CONFIG_LANGUAGE_QUERY("90010002", "查询系统语言"),

    WEAKNET_QUERY("90020001", "弱网查询"),
    WEAKNET_UPDATE("90020002", "弱网项修改"),
    WEAKNET_DELETE("90020003", "弱网项删除"),
    WEAKNET_ADD("90020004", "弱网增加");

    private String code;
    private String name;

    SystemLog(String code, String name){
        this.code = code;
        this.name = name;
    }
    public String getCode(){
        return code;
    }
    public String getName(){
        return name;
    }
}
