package com.dilatoit.eagletest.model;

import javax.persistence.*;

/**
 * EtPermission entity. @author xueshan.wei
 */
@Entity
@Table(name = "et_permission")
public class EtPermission implements java.io.Serializable {

	// Fields

	private Integer id;
	private String permissionStr;
	private String permissionInfo;

	// Constructors

	/** default constructor */
	public EtPermission() {
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

	@Column(name = "permission_str", nullable = false, length = 20)
	public String getPermissionStr() {
		return this.permissionStr;
	}

	public void setPermissionStr(String permissionStr) {
		this.permissionStr = permissionStr;
	}

	@Column(name = "permission_info", length = 50)
	public String getPermissionInfo() {
		return this.permissionInfo;
	}

	public void setPermissionInfo(String permissionInfo) {
		this.permissionInfo = permissionInfo;
	}

	@Override
	public String toString() {
		return "EtPermission{" +
				"id=" + id +
				", permissionStr='" + permissionStr + '\'' +
				", permissionInfo='" + permissionInfo + '\'' +
				'}';
	}
}