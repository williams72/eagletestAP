package com.dilatoit.eagletest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * EtApp entity. @author xueshan.wei
 */
@Entity
@Table(name = "et_app")
public class EtApp implements java.io.Serializable {

	// Fields

	private Integer id;
	private EtUser etUser;
	private EtVersion etVersion;
	private EtProject project;
	private String appAddress;
	private String packageName;
	private String appName;
	private String appRealName;
	private String version;
	private String versionCode;
	private String icon;
	private String buildNumber;
	private String sdkVersion;
	private String packageActivity;
	private Double size;
	private String md5;
    private Date createTime;
	private Integer visibility;
	private List<EtLabel> etLabels = new ArrayList<EtLabel>();
	private List<EtTask> etTasks = new ArrayList<EtTask>();

	private String label;

    @Override
    public String toString() {
        return "EtApp{" +
                "id=" + id +
                ", appAddress='" + appAddress + '\'' +
                ", packageName='" + packageName + '\'' +
                ", appName='" + appName + '\'' +
                ", appRealName='" + appRealName + '\'' +
                ", version='" + version + '\'' +
                ", versionCode='" + versionCode + '\'' +
                ", icon='" + icon + '\'' +
                ", buildNumber='" + buildNumber + '\'' +
                ", sdkVersion='" + sdkVersion + '\'' +
                ", packageActivity='" + packageActivity + '\'' +
                ", size=" + size +
                ", md5='" + md5 + '\'' +
                ", createTime=" + createTime +
                ", visibility=" + visibility +
                ", label='" + label + '\'' +
                '}';
    }

    // Constructors

	/** default constructor */
	public EtApp() {
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
    @JoinColumn(name = "project_id")
    public EtProject getProject() {
        return project;
    }

    public void setProject(EtProject project) {
        this.project = project;
    }
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "version_id")
	public EtVersion getEtVersion() {
		return this.etVersion;
	}

	public void setEtVersion(EtVersion etVersion) {
		this.etVersion = etVersion;
	}

	@Column(name = "app_address")
	public String getAppAddress() {
		return this.appAddress;
	}

	public void setAppAddress(String appAddress) {
		this.appAddress = appAddress;
	}

	@Column(name = "package_name", length = 100)
	public String getPackageName() {
		return this.packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	@Column(name = "app_name", length = 50)
	public String getAppName() {
		return this.appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	@Column(name = "version", length = 25)
	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

    @Column(name = "version_code", length = 50)
	public String getVersionCode() {
		return this.versionCode;
	}

	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}

	@Column(name = "icon")
	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Column(name = "build_number", length = 25)
	public String getBuildNumber() {
		return this.buildNumber;
	}

	public void setBuildNumber(String buildNumber) {
		this.buildNumber = buildNumber;
	}

	@Column(name = "sdk_version")
	public String getSdkVersion() {
		return this.sdkVersion;
	}

	public void setSdkVersion(String sdkVersion) {
		this.sdkVersion = sdkVersion;
	}

	@Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "package_activity", length = 50)
	public String getPackageActivity() {
		return this.packageActivity;
	}

	public void setPackageActivity(String packageActivity) {
		this.packageActivity = packageActivity;
	}

	@Column(name = "size", precision = 22, scale = 0)
	public Double getSize() {
		return this.size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	@Column(name = "md5", length = 50)
	public String getMd5() {
		return this.md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "et_app_label", joinColumns = {@JoinColumn(name = "app_id")},
                    inverseJoinColumns = {@JoinColumn(name = "label_id")})
	public List<EtLabel> getEtLabels() {
		return etLabels;
	}

	public void setEtLabels(List<EtLabel> etLabels) {
		this.etLabels = etLabels;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "etApp")
	public List<EtTask> getEtTasks() {
		return this.etTasks;
	}

	public void setEtTasks(List<EtTask> etTasks) {
		this.etTasks = etTasks;
	}

	@Column(name = "app_real_name")
    public String getAppRealName() {
        return appRealName;
    }

    public void setAppRealName(String appRealName) {
        this.appRealName = appRealName;
    }

    @Column(name = "visibility")
    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    @Column(name = "label")
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}