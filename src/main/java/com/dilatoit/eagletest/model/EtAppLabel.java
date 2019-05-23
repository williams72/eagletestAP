package com.dilatoit.eagletest.model;

import javax.persistence.*;

/**
 * EtAppLabel entity. @author xueshan.wei
 */
@Entity
@Table(name = "et_app_label")
public class EtAppLabel implements java.io.Serializable {

	// Fields

	private Integer id;
	private EtLabel etLabel;
	private EtApp etApp;

	// Constructors

	/** default constructor */
	public EtAppLabel() {
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
	@JoinColumn(name = "label_id", nullable = false)
	public EtLabel getEtLabel() {
		return this.etLabel;
	}

	public void setEtLabel(EtLabel etLabel) {
		this.etLabel = etLabel;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "app_id", nullable = false)
	public EtApp getEtApp() {
		return this.etApp;
	}

	public void setEtApp(EtApp etApp) {
		this.etApp = etApp;
	}

	@Override
	public String toString() {
		return "EtAppLabel{" +
				"id=" + id +
				", etLabel=" + etLabel +
				", etApp=" + etApp +
				'}';
	}
}