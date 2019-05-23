package com.dilatoit.eagletest.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

/**
 * EtRole entity. @author xueshan.wei
 */
@Entity
@Table(name = "et_role")
public class EtRole implements java.io.Serializable {

	// Fields

	private Integer id;
	private String rolename;
	private String roleinfo;
	private String rolePermission;

	private Integer roleValue;
	//private List<EtRoleResper> etRoleRespers = new ArrayList<EtRoleResper>();
	private Set<EtUser> etUsers = new HashSet<EtUser>();
	private List<EtResPer> resPers = new ArrayList<EtResPer>();

	// Constructors

	/** default constructor */
	public EtRole() {
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

	@Column(name = "rolename", nullable = false, length = 50)
	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@Column(name = "roleinfo")
	public String getRoleinfo() {
		return this.roleinfo;
	}

	public void setRoleinfo(String roleinfo) {
		this.roleinfo = roleinfo;
	}
    @Column(name = "rolevalue")
    public Integer getRoleValue() {
        return roleValue;
    }

    public void setRoleValue(Integer roleValue) {
        this.roleValue = roleValue;
    }

    @Column(name = "role_permission")
	public String getRolePermission() {
		return this.rolePermission;
	}

	public void setRolePermission(String rolePermission) {
		this.rolePermission = rolePermission;
	}
	/*
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "etRole")
	public List<EtRoleResper> getEtRoleRespers() {
		return this.etRoleRespers;
	}

	public void setEtRoleRespers(List<EtRoleResper> etRoleRespers) {
		this.etRoleRespers = etRoleRespers;
	}
*/
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST}, mappedBy = "etRoles")
    public Set<EtUser> getEtUsers() {
        return etUsers;
    }

    public void setEtUsers(Set<EtUser> etUsers) {
        this.etUsers = etUsers;
    }

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "et_role_resper", joinColumns = {@JoinColumn(name = "role_id")},
        inverseJoinColumns = {@JoinColumn(name = "res_per_id")})
	public List<EtResPer> getResPers() {
		return resPers;
	}

	public void setResPers(List<EtResPer> resPers) {
		this.resPers = resPers;
	}

	@Override
	public String toString() {
		return "EtRole{" +
				"id=" + id +
				", rolename='" + rolename + '\'' +
				", roleinfo='" + roleinfo + '\'' +
				", rolePermission='" + rolePermission + '\'' +
				", roleValue=" + roleValue +
				'}';
	}
}