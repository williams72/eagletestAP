package com.dilatoit.eagletest.enums;

public enum ExceptionEnum {
    /**
     * user operator exception
     */
    // user not login
    USER_NOT_LOGIN(10000001, "用户未登录"),

    //token time out
    TOKEN_OUTTIME(10000002, "token 失效"),
    //token is bad
    TOKEN_ERROR(10000003, "token 不存在"),
    //user is disable
    USER_DISABLE(10010001, "用户已被禁用"),

    //don`t have permission
    NO_PERMISSION_ERROR(10020001, "没有相关权限"),
    //user is not exist
    USER_IS_NOT_EXIST(10030001, "用户不存在"),
    //user is have
    USER_IS_EXIST(10030002, "用户存在"),
    //the email is have used
    USER_EMAIL_IS_USED(10030003, "邮箱已经被使用"),
    //the username is used
    USER_NAME_IS_USED(10030004, "用户名已被使用"),
    //user login fail
    USER_AUTHENTICATION_ERROR(10030001, "用户名或者密码错误"),
    //user pwd error
    USER_PASSWORD_ERROR(10030002, "密码错误"),
    /**
     * Parameter exceptioin
     */
    //parameter is missing
    PARAM_MISS(20000001, "参数缺失"),

    PARAM_ERROR(20000002, "参数错误"),
    //json format is error
    JSON_FORMAT_ERROR(20010001, "json 格式化错误"),

    /**
     * Business operator exception
     */
    //business error
    BUSINESS_EXCEPTION(30000001, "业务出错"),

    BUSINESS_TWO_PWD_NOT_EQUAL(30050001, "两次输入的密码不一致"),

    BUSINESS_ROLE_NOT_EXIST(30050002, "用户角色不存在"),

    BUSINESS_OLD_PWD_ERROR(30050003, "旧密码错误"),

    QUERY_ENTITY_NOT_FOUND(30060001, "查询的对象没发现"),

    //Realmobile error
    REALMOBILE_TIMEOUT(60000001, "调试已经结束"),
    REALMOBILE_NOT_EXIST(60000002, "调试不存在"),
    Mobile_NOT_EXIST(60000003,"真机不存在"),
    /**
     * System error
     */
    RESOURCE_NOT_FOUND(40000001, "资源不存在"),

    NUll_OBJECT_ERROR(40020001, "空对象错误"),

    MTC_API_CONFIG_FILE_ERROR(40030001, "mtcapi*.properties 配置文件出错"),

    MTC_CONFIG_ERROR(40040001, "mtc 服务配置错误"),
    MTC_CONFIG_API_ERROR(40050001, "mtc api 配置错误"),

    WEAKNET_CONFIG_ERROR(40060001, "弱网配置项出错"),

    /**
     * project
     */
    PROJECT_NOT_FOUND(50000001, "项目不存在"),
    PROJECT_CREATE_USERNOTEXSIT(50010001, "项目指定的管理员不存在"),
    PROJECT_CREATE_NAMEEXIST(50010002, "项目名已经存在"),
    PROJECT_CREATE_KEYEXIST(50010003, "项目key已经存在"),

    PROJECT_MEMBER_ADD_NOPERMISSION(50020001, "当前用户没有权限添加成员"),
    PROJECT_MEMBER_ADD_ROLEVALUE_ERROR(50020002, "项目成员角色错误"),
    PROJECT_MEMBER_ADD_EXIST(50020003, "该用户已经在目标项目中"),
    PROJECT_MEMBER_QUERY_NOTEXIST(50030001, "该用户不在该项目中"),

    PROJECT_VERSION_QUERY_NOTEXIST(50040001, "该版本不存在"),
    PROJECT_VERSION_QUERY_EXIST(50040002, "项目版本名称不能重复"),

    APP_IS_NOT_EXIST(50050001,"运行包不存在"),
    APP_SAVE_ERROR(50050002,"运行包保存失败"),
    APP_POST_ERROR(50050003,"运行包上传失败"),

    //task
    TASK_SCRIPTFILE_SAVE_ERROR(50060001,"保存脚本失败"),
    TASK_SYNOSTATUES_ERROR(50060002,"同步任务失败"),
    TASK_NULL_SCRIPTFILE_ERROR(50060002,"上传脚本为空"),

    //net simulation
    NET_SIMULATION_NOT_EXIST(60000001, "网络模拟不存在"),
    NET_SIMULATION_DISABLE(60000002, "网络模拟不可用"),
    NET_SIMULATION_FAIL(60000003, "网络模拟失败"),
    NET_SIMULATION_Clear_FAIL(60000004, "清除网络模拟环境失败"),


    /**
     * database operator exception
     */
    DB_INSERT_RESULT_ERROR(70000001, "数据插入错误"),
    DB_UPDATE_RESULT_ERROR(70000002, "db update error"),
    DB_DELETE_RESULT_ERROR(70000003, "db delete error"),
    DB_QUERY_RESULT_ERROR(70000004, "db query error"),

    DB_CONNECT_ERROR(70010001, "db connect error"),

    DB_QUERY_PAGE_ERROR(70020001, "db query page error"),

    /**
     * inner system operator exception
     */
    INNER_SERVER_NORESPONSE(8000001, "inner server is not response"),
    INNER_SERVER_ERROR(80010001, "inner server has a error"),

    ENGINE_ERROR(80020001, "Engine has a error"),
    ENGINE_CONFIG_ERROR(80021001, "Engine config has error"),
    ENGINE_COMMON_PIPE_ERROR(80022001, "Engine common pipe has a error"),
    ENGINE_MOBILE_PIPE_ERROR(80023001, "Engine mobile pipe has a error"),
    ENGINE_PIPE_ACCESS_ERROR(80024001, "Engine pipe access has a error"),
    ENGINE_REALMOBILE_PIPE_ERROR(80025001, "Engine realmobile pipe has a error"),
    ENGINE_TASK_PIPE_ERROR(80026001, "Engine task pipe has a error"),

    ENGINE_TASK_CONVERSION_ERROR(80030001, "Engine task conversion error"),

    PAGE_NOT_FOUND(90010001, "page not found"),
    /**
     * not know error
     */
    NOT_KNOW_ERROR(90000001, "not know error !");


    private final int code;
    private final String message;

    private ExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public static ExceptionEnum stateOf(int index) {
        for (ExceptionEnum state : values()) {
            if (state.getCode() == index) {
                return state;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }

    public String getContent(){
        return code + "," + message;
    }

}
