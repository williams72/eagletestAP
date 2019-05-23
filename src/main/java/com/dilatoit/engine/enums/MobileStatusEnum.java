package com.dilatoit.engine.enums;

/**
 * Created by xueshan.wei on 5/27/2017.
 */
public enum MobileStatusEnum {
    ONLINE("device", 0), //在线
    OFFLINE("offline", 1), //离线（出现异常或其他）
    UNKNOWN("unknown", 2), //不在线
    UNAUTHORIZED("unauthorized", 3), //在线但是未认证
    WORKING_TASK("working_task", 4), // 执行任务中
    WORKING_REAL("working_real", 5) //真机调试中
    ;
    private String name;
    private int value;

    MobileStatusEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public int value(){
        return value;
    }

    public String getName(){
        return name;
    }

    /**
     * 返回手机对应的状态
     * 返回 0 表示不知道什么状态
     * @param name
     * @return
     */
    public static int getValue(String name){
        if(ONLINE.getName().equals(name)){
            return ONLINE.value();
        }else if(OFFLINE.getName().equals(name)){
            return OFFLINE.value();
        }else if(UNKNOWN.getName().equals(name)){
            return UNKNOWN.value();
        }else if(UNAUTHORIZED.getName().equals(name)){
            return UNAUTHORIZED.value();
        }
        return 0;
    }
}
