package com.dilatoit.eagletest.service.impl;

import com.dilatoit.eagletest.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by beishan on 2016/11/12.
 */
@Service
public class ServiceManager {
    @Autowired
    private UserService userService;
    @Autowired
    private AppService appService;
    @Autowired
    private LabelService labelService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private VersionService versionService;
    @Autowired
    private LogService logService;
    @Autowired
    private RealMobileService realMobileService;
    @Autowired
    private MobileService mobileService;
    @Autowired
    private ProjectUserService projectUserService;
    @Autowired
    private ResourcePermissionService resourcePermissionService;
    @Autowired
    private RoleResperService roleResperService;
    @Autowired
    private SystemConfigService systemConfigService;
    @Autowired
    private SubtaskService subtaskService;
    @Autowired
    private ProjectDashboardService projectDashboardService;
    @Autowired
    private CommonsService commonsService;
    @Autowired
    private ScreenShotService screenShotService;
    @Autowired
    private WeaknetService weaknetService;
    @Autowired
    private NetSimulationService netSimulationService;
    @Autowired
    private SmartTraversalTaskService smartTraversalTaskService;

    public SmartTraversalTaskService getSmartTraversalTaskService() {
        return smartTraversalTaskService;
    }

    public WeaknetService getWeaknetService() {
        return weaknetService;
    }

    public ScreenShotService getScreenShotService() {
        return screenShotService;
    }

    public UserService getUserService() {
        return userService;
    }

    public AppService getAppService() {
        return appService;
    }

    public LabelService getLabelService() {
        return labelService;
    }

    public PermissionService getPermissionService() {
        return permissionService;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public ResourceService getResourceService() {
        return resourceService;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public VersionService getVersionService() {
        return versionService;
    }

    public LogService getLogService() {
        return logService;
    }

    public RealMobileService getRealMobileService() {
        return realMobileService;
    }

    public MobileService getMobileService() {
        return mobileService;
    }

    public ProjectUserService getProjectUserService() {
        return projectUserService;
    }

    public ResourcePermissionService getResourcePermissionService() {
        return resourcePermissionService;
    }

    public RoleResperService getRoleResperService() {
        return roleResperService;
    }

    public SystemConfigService getSystemConfigService() {
        return systemConfigService;
    }

    public SubtaskService getSubtaskService() {
        return subtaskService;
    }

    public ProjectDashboardService getProjectDashboardService() {
        return projectDashboardService;
    }

    public CommonsService getCommonsService() {
        return commonsService;
    }

    public NetSimulationService getNetSimulationService(){ return netSimulationService;}
}
