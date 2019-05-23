package com.dilatoit.eagletest.model;

import javax.persistence.*;

/**
 * EtUserRole entity. @author xueshan.wei
 */
@Entity
@Table(name = "et_user_role")
public class EtUserRole implements java.io.Serializable {

	// Fields

	private Integer id;
	private EtUser etUser;
	private EtRole etRole;

	// Constructors

	/** default constructor */
	public EtUserRole() {
	}

	/** full constructor */
	public EtUserRole(EtUser etUser, EtRole etRole) {
		this.etUser = etUser;
		this.etRole = etRole;
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
	@JoinColumn(name = "user_id", nullable = false)
	public EtUser getEtUser() {
		return this.etUser;
	}

	public void setEtUser(EtUser etUser) {
		this.etUser = etUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	public EtRole getEtRole() {
		return this.etRole;
	}

	public void setEtRole(EtRole etRole) {
		this.etRole = etRole;
	}

	@Override
	public String toString() {
		return "EtUserRole{" +
				"id=" + id +
				'}';
	}
}