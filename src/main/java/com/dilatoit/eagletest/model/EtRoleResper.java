package com.dilatoit.eagletest.model;

import javax.persistence.*;

/**
 * EtRoleResper entity. @author xueshan.wei
 */
@Entity
@Table(name = "et_role_resper")
public class EtRoleResper implements java.io.Serializable {

	// Fields

	private Integer id;
	private EtRole etRole;
	private EtResPer etResPer;

	// Constructors

	/** default constructor */
	public EtRoleResper() {
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
	@JoinColumn(name = "role_id", nullable = false)
	public EtRole getEtRole() {
		return this.etRole;
	}

	public void setEtRole(EtRole etRole) {
		this.etRole = etRole;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "res_per_id", nullable = false)
	public EtResPer getEtResPer() {
		return this.etResPer;
	}

	public void setEtResPer(EtResPer etResPer) {
		this.etResPer = etResPer;
	}

	@Override
	public String toString() {
		return "EtRoleResper{" +
				"id=" + id +
				'}';
	}
}