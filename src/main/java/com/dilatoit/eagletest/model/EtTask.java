package com.dilatoit.eagletest.model;

import java.util.*;
import javax.persistence.*;

/**
 * EtTask entity. @author xueshan.wei
 */
@Entity
@Table(name = "et_task")
public class EtTask implements java.io.Serializable {

	// Fields

	private Integer id;
	private EtUser etUser;
	private EtProject etProject;
	private EtVersion etVersion;
	private EtApp etApp;
	private String taskId;
	private String taskName;
	private Integer engine;
	private Integer os;
	private Integer status;
	private String taskParam;
	private Integer isAbort;
	private Date createTime;
	private String pdf;
	private String excel;
	private Date starttime;
	private Date endtime;
	private Integer syno;
	private String taskType;
	private String result;
	private Integer finalResult;

	private Integer hasNetSimulation;
	private EtWeaknet netSimulation;

	private Set<EtSubtask> subtaskSet = new HashSet<EtSubtask>();
	private List<EtTestType> testTypes = new ArrayList<EtTestType>();
	// Constructors

	/** default constructor */
	public EtTask() {
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
	@JoinColumn(name = "project_id", nullable = false)
	public EtProject getEtProject() {
		return this.etProject;
	}

	public void setEtProject(EtProject etProject) {
		this.etProject = etProject;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "version_id", nullable = false)
	public EtVersion getEtVersion() {
		return this.etVersion;
	}

	public void setEtVersion(EtVersion etVersion) {
		this.etVersion = etVersion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "app_id", nullable = false)
	public EtApp getEtApp() {
		return this.etApp;
	}

	public void setEtApp(EtApp etApp) {
		this.etApp = etApp;
	}

	@Column(name = "task_id", nullable = false)
	public String getTaskId() {
		return this.taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	@Column(name = "task_name", nullable = false, length = 50)
	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Column(name = "engine", nullable = false, length = 10)
	public Integer getEngine() {
		return engine;
	}

	public void setEngine(Integer engine) {
		this.engine = engine;
	}

	@Column(name = "os", nullable = false, length = 10)
	public Integer getOs() {
		return this.os;
	}

	public void setOs(Integer os) {
		this.os = os;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "task_param", nullable = false, length = 16777215)
	public String getTaskParam() {
		return this.taskParam;
	}

	public void setTaskParam(String taskParam) {
		this.taskParam = taskParam;
	}

	@Column(name = "task_type")
	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	@Column(name = "is_abort")
	public Integer getIsAbort() {
		return this.isAbort;
	}

	public void setIsAbort(Integer isAbort) {
		this.isAbort = isAbort;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "pdf")
	public String getPdf() {
		return this.pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	@Column(name = "excel")
	public String getExcel() {
		return this.excel;
	}

	public void setExcel(String excel) {
		this.excel = excel;
	}

	@Column(name = "starttime", length = 19)
	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	@Column(name = "endtime", length = 19)
	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	@Column(name = "syno")
	public Integer getSyno() {
		return syno;
	}

	public void setSyno(Integer syno) {
		this.syno = syno;
	}

	@Column(name = "result")
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "task")
    public Set<EtSubtask> getSubtaskSet() {
        return subtaskSet;
    }

    @Column(name = "final_result")
	public Integer getFinalResult() {
		return finalResult;
	}
	public void setFinalResult(Integer finalResult) {
		this.finalResult = finalResult;
	}


	public void setSubtaskSet(Set<EtSubtask> subtaskSet) {
        this.subtaskSet = subtaskSet;
    }

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
	@JoinTable(name = "et_task_testtype", joinColumns = {@JoinColumn(name = "task_id")},
			inverseJoinColumns = {@JoinColumn(name = "testtype_id")})
	public List<EtTestType> getTestTypes() {
		return testTypes;
	}

	public void setTestTypes(List<EtTestType> testTypes) {
		this.testTypes = testTypes;
	}

	@Column(name = "is_net_simulation", nullable = false)
	public Integer getHasNetSimulation() {
		return hasNetSimulation;
	}

	public void setHasNetSimulation(Integer hasNetSimulation) {
		this.hasNetSimulation = hasNetSimulation;
	}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "net_simulation_id")
	public EtWeaknet getNetSimulation() {
		return netSimulation;
	}

	public void setNetSimulation(EtWeaknet netSimulation) {
		this.netSimulation = netSimulation;
	}

	@Override
	public String toString() {
		return "EtTask{" +
				"id=" + id +
				", etUser=" + etUser +
				", etProject=" + etProject +
				", etVersion=" + etVersion +
				", etApp=" + etApp +
				", taskId='" + taskId + '\'' +
				", taskName='" + taskName + '\'' +
				", os=" + os +
				", status=" + status +
				", taskParam='" + taskParam + '\'' +
				", isAbort=" + isAbort +
				", createTime=" + createTime +
				", pdf='" + pdf + '\'' +
				", excel='" + excel + '\'' +
				", starttime=" + starttime +
				", endtime=" + endtime +
				", syno=" + syno +
				", taskType='" + taskType + '\'' +
				", result='" + result + '\'' +
				", hasNetSimulation=" + hasNetSimulation +
				", netSimulation=" + netSimulation +
				", subtaskSet=" + subtaskSet +
				", testTypes=" + testTypes +
				'}';
	}
}