package com.dilatoit.eagletest.dto;

import com.google.gson.annotations.Expose;

/**
 * Created by xueshan.wei on 5/11/2017.
 */
public class UserDTO {
    @Expose
    private Integer id;
    @Expose
    private String username;
    @Expose
    private String email;
    @Expose
    private Integer status;
    @Expose
    private String realname;
    @Expose
    private long createtime;
    @Expose
    private long lastmodifedtime;
    @Expose
    private long lastlogintime;
    @Expose
    private String avatars;
    @Expose
    private String sessionId;

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", realname='" + realname + '\'' +
                ", createtime=" + createtime +
                ", lastmodifedtime=" + lastmodifedtime +
                ", lastlogintime=" + lastlogintime +
                ", avatars='" + avatars + '\'' +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }

    public long getLastmodifedtime() {
        return lastmodifedtime;
    }

    public void setLastmodifedtime(long lastmodifedtime) {
        this.lastmodifedtime = lastmodifedtime;
    }

    public long getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(long lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getAvatars() {
        return avatars;
    }

    public void setAvatars(String avatars) {
        this.avatars = avatars;
    }
}
