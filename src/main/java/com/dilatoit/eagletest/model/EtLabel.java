package com.dilatoit.eagletest.model;

import java.util.*;
import javax.persistence.*;

/**
 * EtLabel entity. @author xueshan.wei
 */
@Entity
@Table(name = "et_label")
public class EtLabel implements java.io.Serializable {

	// Fields

	private Integer id;
	private EtProject etProject;
	private String labelName;
	private Short labelType;
	private Date createtime;
	private List<EtApp> etApps = new ArrayList<EtApp>();

	// Constructors

	/** default constructor */
	public EtLabel() {

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

	@Column(name = "label_name", nullable = false, length = 20)
	public String getLabelName() {
		return this.labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	@Column(name = "label_type")
	public Short getLabelType() {
		return this.labelType;
	}

	public void setLabelType(Short labelType) {
		this.labelType = labelType;
	}

	@Column(name = "createtime", nullable = false, length = 19)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@ManyToMany(mappedBy = "etLabels")
	public List<EtApp> getEtApps() {
		return etApps;
	}

	public void setEtApps(List<EtApp> etApps) {
		this.etApps = etApps;
	}

    @Override
    public String toString() {
        return "EtLabel{" +
                "id=" + id +
                ", labelName='" + labelName + '\'' +
                ", labelType=" + labelType +
                ", createtime=" + createtime +
                '}';
    }
}