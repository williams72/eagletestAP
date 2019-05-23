package com.dilatoit.eagletest.model;

import com.google.gson.annotations.Expose;

import java.util.*;
import javax.persistence.*;

/**
 * EtProject entity. @author xueshan.wei
 */
@Entity
@Table(name = "et_project")
public class EtProject implements java.io.Serializable {
	@Expose
	private Integer id;

	@Expose
	private String projectName;

	@Expose
	private String projectKey;

	@Expose
	private Integer projectType;

	@Expose
	private String projectIntro;

	@Expose
	private Integer active;

	@Expose
	private Date createTime;

	@Expose
	private Date modifyTime;

	private List<EtTask> etTasks = new ArrayList<>();
	private List<EtVersion> etVersions = new ArrayList<>();
	private List<EtLabel> etLabels = new ArrayList<>();
	private Set<EtUser> etUsers = new HashSet<>();

    private List<EtProjectUser> etProjectUsers = new ArrayList<EtProjectUser>();
	// Constructors

	/** default constructor */
	public EtProject() {
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

	@Column(name = "name", nullable = false, length = 50)
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	@Column(name = "label", nullable = false, length = 10)
	public String getProjectKey() {
		return this.projectKey;
	}

	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}

	@Column(name = "type")
	public Integer getProjectType() {
		return projectType;
	}

	@Column(name = "description", length = 50)
	public String getProjectIntro() {
		return this.projectIntro;
	}

	public void setProjectIntro(String projectIntro) {
		this.projectIntro = projectIntro;
	}

	public void setProjectType(Integer projectType) {
		this.projectType = projectType;
	}

	@Column(name = "active")
	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	@Column(name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "modify_time")
	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "etProject")
	public List<EtTask> getEtTasks() {
		return this.etTasks;
	}

	public void setEtTasks(List<EtTask> etTasks) {
		this.etTasks = etTasks;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "etProject")
	public List<EtVersion> getEtVersions() {
		return this.etVersions;
	}

	public void setEtVersions(List<EtVersion> etVersions) {
		this.etVersions = etVersions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "etProject")
	public List<EtLabel> getEtLabels() {
		return this.etLabels;
	}

	public void setEtLabels(List<EtLabel> etLabels) {
		this.etLabels = etLabels;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "et_project_user",
			joinColumns = {@JoinColumn(name = "project_id")},
			inverseJoinColumns = {@JoinColumn(name = "user_id")})
	public Set<EtUser> getEtUsers() {
		return etUsers;
	}

	public void setEtUsers(Set<EtUser> etUsers) {
		this.etUsers = etUsers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "etProject")
	public List<EtProjectUser> getEtProjectUsers() {
		return etProjectUsers;
	}

	public void setEtProjectUsers(List<EtProjectUser> etProjectUsers) {
		this.etProjectUsers = etProjectUsers;
	}

}