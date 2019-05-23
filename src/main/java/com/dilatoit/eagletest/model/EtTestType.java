package com.dilatoit.eagletest.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xueshan.wei on 3/22/2017.
 */
@Entity
@Table(name = "et_test_type")
public class EtTestType {

    private Integer id;
    private String name;
    private String i18nCode;
    private String shortKey;
    private String desc;

    private Set<EtTask> tasks = new HashSet<EtTask>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "i18n_code", nullable = false)
    public String getI18nCode() {
        return i18nCode;
    }

    public void setI18nCode(String i18nCode) {
        this.i18nCode = i18nCode;
    }

    @Column(name = "short_key", nullable = false)
    public String getShortKey() {
        return shortKey;
    }

    public void setShortKey(String shortKey) {
        this.shortKey = shortKey;
    }
    @Column(name = "desc")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "et_task_testtype", joinColumns = {@JoinColumn(name = "testtype_id")},
            inverseJoinColumns = {@JoinColumn(name = "task_id")})
    public Set<EtTask> getTasks() {
        return tasks;
    }

    public void setTasks(Set<EtTask> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "EtTestType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", i18nCode='" + i18nCode + '\'' +
                ", shortKey='" + shortKey + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
