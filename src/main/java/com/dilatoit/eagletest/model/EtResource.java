package com.dilatoit.eagletest.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * EtResource entity. @author xueshan.wei
 */
@Entity
@Table(name = "et_resource")
public class EtResource implements java.io.Serializable {

	// Fields

	private Integer id;
	private String resourceName;
	private List<EtResPer> etResPers = new ArrayList<EtResPer>();

	// Constructors

	/** default constructor */
	public EtResource() {
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

	@Column(name = "resource_name", nullable = false, length = 50)
	public String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "etResource")
	public List<EtResPer> getEtResPers() {
		return this.etResPers;
	}

	public void setEtResPers(List<EtResPer> etResPers) {
		this.etResPers = etResPers;
	}

	@Override
	public String toString() {
		return "EtResource{" +
				"id=" + id +
				", resourceName='" + resourceName + '\'' +
				'}';
	}
}