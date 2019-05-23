package com.dilatoit.eagletest.api.model;

import com.dilatoit.eagletest.model.EtProjectUser;
import com.google.gson.annotations.Expose;


import java.util.ArrayList;
import java.util.List;

/**
 * 用于承载项目成员信息
 * Created by xueshan.wei on 3/9/2017.
 */
public class ProjectUser {
    //关系id
    @Expose
    private int puid;
    //成员id
    @Expose
    private int uid;
    //项目id
    @Expose
    private int pid;
    //该成员在项目中的角色值
    @Expose
    private int value;
    //成员用户名
    @Expose
    private String username;
    //成员用户邮箱
    @Expose
    private String useremail;
    //成员用户头像
    @Expose
    private String useravatars;

    public ProjectUser(){

    }
    public ProjectUser(EtProjectUser pu){
        if(pu != null) {
            this.puid = pu.getId();
            this.uid = pu.getEtUser().getId();
            this.pid = pu.getEtProject().getId();
            this.value = pu.getProjectRole();
            this.username = pu.getEtUser().getUsername();
            this.useremail = pu.getEtUser().getEmail();
            this.useravatars = pu.getEtUser().getAvatars();
        }
    }
    public static List<ProjectUser> getPUs(List<EtProjectUser> pus){
        if(pus != null){
            List<ProjectUser> projectUsers = new ArrayList<ProjectUser>();
            ProjectUser putemp = null;
            for(EtProjectUser pu : pus){
                putemp = ProjectUser.transformTo(pu);
                projectUsers.add(putemp);
            }
            return projectUsers;
        }
        return null;
    }

    public static ProjectUser transformTo(EtProjectUser projectUser){
        if(projectUser != null){
            ProjectUser pu = new ProjectUser();
            pu.setPU(projectUser);
            return pu;
        }
        return null;
    }
    public void setPU(EtProjectUser pu){
        if(pu != null) {
            this.puid = pu.getId();
            this.uid = pu.getEtUser().getId();
            this.pid = pu.getEtProject().getId();
            this.value = pu.getProjectRole();
            this.username = pu.getEtUser().getUsername();
            this.useremail = pu.getEtUser().getEmail();
            this.useravatars = pu.getEtUser().getAvatars();
        }
    }
    public int getPuid() {
        return puid;
    }

    public void setPuid(int puid) {
        this.puid = puid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUseravatars() {
        return useravatars;
    }

    public void setUseravatars(String useravatars) {
        this.useravatars = useravatars;
    }
}
