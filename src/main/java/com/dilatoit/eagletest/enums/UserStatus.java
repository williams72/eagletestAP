package com.dilatoit.eagletest.enums;

/**
 * Created by xueshan.wei on 11/14/2016.
 */
public enum UserStatus {
    //disable user
    DISABLE(0),
    //enable user
    ENABLE(1);

    private final int status;

    private UserStatus(int status) {
        this.status = status;
    }
    public int value(){
        return this.status;
    }
}
