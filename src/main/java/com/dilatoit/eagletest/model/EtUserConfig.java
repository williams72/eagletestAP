package com.dilatoit.eagletest.model;


import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * EtUserConfig entity. @author xueshan.wei
 */
@Entity
@Table(name = "et_user_config")
public class EtUserConfig implements java.io.Serializable {

    // Fields

    private Integer id;
    private String lastViewProject;
    private String recentViewProject;

    // Constructors

    /**
     * default constructor
     */
    public EtUserConfig() {
    }


    // Property accessors
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "last_view_project", length = 100)
    public String getLastViewProject() {
        return lastViewProject;
    }

    public void setLastViewProject(String lastViewProject) {
        this.lastViewProject = lastViewProject;
    }

    @Column(name = "recent_view_project")
    public String getRecentViewProject() {
        return recentViewProject;
    }

    public void setRecentViewProject(String recentViewProject) {
        this.recentViewProject = recentViewProject;
    }

    public String updateRecentProject(String projectId) {
        if(StringUtils.isNotBlank(projectId)) {
            if (StringUtils.isNotBlank(this.recentViewProject)) {
                //String temp = projectId;
                StringBuffer temp = new StringBuffer(projectId);
                String[] ps = recentViewProject.split(",");
                int count = 0;
                for (String p : ps) {
                    if (!projectId.equals(p)) {
                        temp.append(',');
                        temp.append(p);
                        count++;
                        if(count == 2){
                            break;
                        }
                    }
                }
                this.recentViewProject = temp.toString();
            } else {
                this.recentViewProject = projectId;
            }
        }
        return this.recentViewProject;
    }

    public List<String> someRecentProject(){
        if(StringUtils.isNotBlank(recentViewProject)){
            List<String> recentP = new ArrayList<String>();
            String [] ps = recentViewProject.split(",");
            for(int i = 0; i < 3 && i < ps.length; i++){
                if(StringUtils.isNumeric(ps[i])){
                    recentP.add(ps[i]);
                }
            }
            return recentP;
        }
        return null;
    }

    @Override
    public String toString() {
        return "EtUserConfig{" +
                "id=" + id +
                ", lastViewProject='" + lastViewProject + '\'' +
                ", recentViewProject='" + recentViewProject + '\'' +
                '}';
    }
}