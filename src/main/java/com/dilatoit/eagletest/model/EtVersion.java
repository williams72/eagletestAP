package com.dilatoit.eagletest.model;

import javax.persistence.*;
import java.util.Date;

/**
 * EtVersion entity. @author xueshan.wei
 */
@Entity
@Table(name = "et_version")
public class EtVersion implements java.io.Serializable {

	// Fields

	private Integer id;
	private EtProject etProject;
	private String versionName;
	private Integer versionStatus;
	private Date createTime;

	// Constructors

	/** default constructor */
	public EtVersion() {
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
	@JoinColumn(name = "project_id", nullable = false)
	public EtProject getEtProject() {
		return this.etProject;
	}

	public void setEtProject(EtProject etProject) {
		this.etProject = etProject;
	}

	@Column(name = "version_name", nullable = false, length = 50)
	public String getVersionName() {
		return this.versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	@Column(name = "version_status", nullable = false)
	public Integer getVersionStatus() {
		return versionStatus;
	}

	public void setVersionStatus(Integer versionStatus) {
		this.versionStatus = versionStatus;
	}

	@Column(name = "create_time", nullable = false)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "EtVersion{" +
				"id=" + id +
				", versionName='" + versionName + '\'' +
				", versionStatus=" + versionStatus +
				", createTime=" + createTime +
				'}';
	}
}