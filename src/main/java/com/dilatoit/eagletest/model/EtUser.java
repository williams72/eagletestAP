package com.dilatoit.eagletest.model;

import com.google.gson.annotations.Expose;

import java.util.*;
import javax.persistence.*;

/**
 * EtUser entity. @author xueshan.wei
 */
@Entity
@Table(name = "et_user")
public class EtUser implements java.io.Serializable {

	// Fields

	@Expose
	private Integer id;
	private EtUserConfig etUserConfig;
	@Expose
	private String username;
	@Expose
	private String email;
	private String password;
	@Expose
	private String phonenum;
	@Expose
	private Integer status;
	@Expose
	private String realname;
	private String dept;
	@Expose
	private Date createtime;
	@Expose
	private Date lastmodifiedtime;
	@Expose
	private Date lastlogintime;
	@Expose
	private String avatars;
	private Set<EtRole> etRoles = new HashSet<EtRole>();
	private List<EtProject> etProjects = new ArrayList<EtProject>();
	private List<EtTask> etTasks = new ArrayList<EtTask>();
	private List<EtApp> etApps = new ArrayList<EtApp>();
	private List<EtRealMobile> realMobiles = new ArrayList<EtRealMobile>();

	// Constructors

	/** default constructor */
	public EtUser() {
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

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_config_id", nullable = false)
	public EtUserConfig getEtUserConfig() {
		return this.etUserConfig;
	}

	public void setEtUserConfig(EtUserConfig etUserConfig) {
		this.etUserConfig = etUserConfig;
	}

	@Column(name = "username", nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "email", nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "phonenum", length = 11)
	public String getPhonenum() {
		return this.phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "realname", length = 50)
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "dept", length = 50)
	public String getDept() {
		return this.dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Column(name = "createtime", nullable = false, length = 19)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Column(name = "lastmodifiedtime", length = 19)
	public Date getLastmodifiedtime() {
		return this.lastmodifiedtime;
	}

	public void setLastmodifiedtime(Date lastmodifiedtime) {
		this.lastmodifiedtime = lastmodifiedtime;
	}

	@Column(name = "lastlogintime", length = 19)
	public Date getLastlogintime() {
		return this.lastlogintime;
	}

	public void setLastlogintime(Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "et_user_role", joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    public Set<EtRole> getEtRoles() {
        return etRoles;
    }

    public void setEtRoles(Set<EtRole> etRoles) {
        this.etRoles = etRoles;
    }

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
	@JoinTable(name = "et_project_user", joinColumns = {@JoinColumn(name = "user_id")},
			inverseJoinColumns = {@JoinColumn(name = "project_id")})
    public List<EtProject> getEtProjects() {
        return etProjects;
    }

    public void setEtProjects(List<EtProject> etProjects) {
        this.etProjects = etProjects;
    }

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "etUser")
	public List<EtTask> getEtTasks() {
		return this.etTasks;
	}

	public void setEtTasks(List<EtTask> etTasks) {
		this.etTasks = etTasks;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "etUser")
	public List<EtApp> getEtApps() {
		return this.etApps;
	}

	public void setEtApps(List<EtApp> etApps) {
		this.etApps = etApps;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "etUser")
	public List<EtRealMobile> getRealMobiles() {
		return realMobiles;
	}

	public void setRealMobiles(List<EtRealMobile> realMobiles) {
		this.realMobiles = realMobiles;
	}

	@Column(name = "avatars")
    public String getAvatars() {
        return avatars;
    }

    public void setAvatars(String avatars) {
        this.avatars = avatars;
    }

	@Override
	public String toString() {
		return "EtUser{" +
				"id=" + id +
				", username='" + username + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", phonenum='" + phonenum + '\'' +
				", status=" + status +
				", realname='" + realname + '\'' +
				", dept='" + dept + '\'' +
				", createtime=" + createtime +
				", lastmodifiedtime=" + lastmodifiedtime +
				", lastlogintime=" + lastlogintime +
				", avatars='" + avatars + '\'' +
				'}';
	}
}