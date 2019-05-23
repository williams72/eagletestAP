package com.dilatoit.eagletest.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * EtResPer entity. @author xueshan.wei
 */
@Entity
@Table(name = "et_res_per")
public class EtResPer implements java.io.Serializable {

	// Fields

	private Integer id;
	private EtPermission etPermission;
	private EtResource etResource;
	private String resourcePermission;
	private List<EtRoleResper> etRoleRespers = new ArrayList<EtRoleResper>();
	private List<EtRole> roles = new ArrayList<EtRole>();
	// Constructors

	/** default constructor */
	public EtResPer() {
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "permission_id", nullable = false)
	public EtPermission getEtPermission() {
		return this.etPermission;
	}

	public void setEtPermission(EtPermission etPermission) {
		this.etPermission = etPermission;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resource_id", nullable = false)
	public EtResource getEtResource() {
		return this.etResource;
	}

	public void setEtResource(EtResource etResource) {
		this.etResource = etResource;
	}

	@Column(name = "resource_permission", nullable = false, length = 50)
	public String getResourcePermission() {
		return this.resourcePermission;
	}

	public void setResourcePermission(String resourcePermission) {
		this.resourcePermission = resourcePermission;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "etResPer")
	public List<EtRoleResper> getEtRoleRespers() {
		return this.etRoleRespers;
	}

	public void setEtRoleRespers(List<EtRoleResper> etRoleRespers) {
		this.etRoleRespers = etRoleRespers;
	}

	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "resPers")
	public List<EtRole> getRoles() {
		return roles;
	}

	public void setRoles(List<EtRole> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "EtResPer{" +
				"id=" + id +
				", resourcePermission='" + resourcePermission + '\'' +
				'}';
	}
}