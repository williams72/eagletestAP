package com.dilatoit.eagletest.model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

/**
 * EtProjectUser entity. @author xueshan.wei
 */
@Entity
@Table(name = "et_project_user")
public class EtProjectUser implements java.io.Serializable {

	// Fields

	@Expose
	private Integer id;
	@Expose
	private EtUser etUser;
	@Expose
	private EtProject etProject;
	@Expose
	private Integer projectRole;

	// Constructors

	/** default constructor */
	public EtProjectUser() {
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	public EtUser getEtUser() {
		return this.etUser;
	}

	public void setEtUser(EtUser etUser) {
		this.etUser = etUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id", nullable = false)
	public EtProject getEtProject() {
		return this.etProject;
	}

	public void setEtProject(EtProject etProject) {
		this.etProject = etProject;
	}

	@Column(name = "project_role", nullable = false)
	public Integer getProjectRole() {
		return this.projectRole;
	}

	public void setProjectRole(Integer projectRole) {
		this.projectRole = projectRole;
	}

	@Override
	public String toString() {
		return "EtProjectUser{" +
				"id=" + id +
				", projectRole=" + projectRole +
				'}';
	}
}