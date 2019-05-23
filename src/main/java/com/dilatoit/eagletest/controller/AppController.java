package com.dilatoit.eagletest.controller;


import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.annotation.SystemControllerLog;
import com.dilatoit.eagletest.enums.AppType;
import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.enums.log.SystemLog;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.*;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;
import com.dilatoit.engine.exception.EngineException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Created by beishan on 2016/11/15.
 */
@Controller
@RequestMapping
public class AppController extends BaseController {

    @ModelAttribute
    public void loadNeedData(HttpSession session, Model model) throws BusinessException, EngineException, DataBaseException {
        //加载当前用户信息
        EtUser currentUser = (EtUser) session.getAttribute("currentUser");
        //用户未登录不需要加载
        if (currentUser != null) {
            //加载用户当前正在调试的手机
            List<EtRealMobile> currentRms = serviceManager.getRealMobileService().currentRealMobiles(currentUser.getId());
            model.addAttribute("currentRms", currentRms);
            //加载用户信息
            EtUser userDetail = serviceManager.getUserService().queryUserById(currentUser.getId());
            model.addAttribute("userDetail", userDetail);
            //加载用户的最近三个项目
            EtUserConfig userConfig = userDetail.getEtUserConfig();
            List<String> pids = userConfig.someRecentProject();
            List<EtProject> recentProjects = serviceManager.getProjectService().querySomeProject(pids);
            model.addAttribute("recentProjects", recentProjects);
        }
    }

    /**
     * 转到项目app管理页面
     * @param projectId
     * @param offset
     * @param limit
     * @return
     * @throws DataBaseException
     * @throws EngineException
     * @throws BusinessException
     */
    @RequestMapping(value = "/project/{projectId}/apps")
    @AuthorityCheck
    public ModelAndView manageApp(@PathVariable Integer projectId, @RequestParam(defaultValue = "1") Integer offset,
                                  @RequestParam(defaultValue = "10") Integer limit) throws EngineException, BusinessException{
        ModelAndView mv = new ModelAndView("project/project_app");
        //加载当前项目信息
        EtProject currentProject = null;
        try {
            currentProject = serviceManager.getProjectService().queryById(projectId);
        }catch (DataBaseException dbe){
            throw new BusinessException(ExceptionEnum.PROJECT_NOT_FOUND);
        }
        mv.addObject("currentProject", currentProject);
        //加载当前登录用户在该项目中的用户
        EtProjectUser currentProjectUser = null;
        EtUser currentUser = (EtUser) session.getAttribute("currentUser");
        for(EtProjectUser pu : currentProject.getEtProjectUsers()){
            if(currentUser.getId().equals(pu.getEtUser().getId())){
                currentProjectUser = pu;
            }
        }
        mv.addObject("currentProjectUser", currentProjectUser);
        //加载当前项目app
        DataPage<EtApp> page = new DataPage<EtApp>();
        page.setOffsetLimit(offset, limit);
        Conditions conditions = new Conditions();
        conditions.addCondition("project.id", projectId, Conditions.Operator.EQUAL);
        try{
            serviceManager.getAppService().page(page, conditions);
        }catch (DataBaseException dba){

        }


        mv.addObject("page", page);
        return mv;
    }

    @RequestMapping(value = "/project/{projectId}/appcreate")
    @AuthorityCheck
    public ModelAndView toCreateAppPage(@PathVariable Integer projectId) throws EngineException, DataBaseException, BusinessException{
        ModelAndView mv = new ModelAndView("project/project_app_create");
        //加载当前项目信息
        EtProject currentProject = serviceManager.getProjectService().queryById(projectId);
        mv.addObject("currentProject", currentProject);
        //加载当前登录用户在该项目中的用户
        EtProjectUser currentProjectUser = null;
        EtUser currentUser = (EtUser) session.getAttribute("currentUser");
        for(EtProjectUser pu : currentProject.getEtProjectUsers()){
            if(currentUser.getId().equals(pu.getEtUser().getId())){
                currentProjectUser = pu;
            }
        }
        mv.addObject("currentProjectUser", currentProjectUser);
        //加载当前项目的所有版本
        List<EtVersion> versions = serviceManager.getVersionService().queryAllByProId(projectId);
        mv.addObject("versions", versions);

        return mv;
    }

    @RequestMapping(value = "/project/{projectId}/app", method = RequestMethod.POST)
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.APP_CREATE)
    public String createApp(@PathVariable Integer projectId, EtApp app, @RequestParam String versionId) throws EngineException, DataBaseException, BusinessException{
    //public String createApp(HttpServletRequest request, @PathVariable Integer projectId) throws EngineException, DataBaseException, BusinessException{

        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        String path = request.getSession().getServletContext().getRealPath("/");
        String result;
        // 检查form是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //System.out.println("createApp()--etVersion--"+app.getEtVersion().toString());
            System.out.println(versionId);
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                // 由CommonsMultipartFile继承而来,拥有上面的方法.
                MultipartFile file = multiRequest.getFile(iter.next());

                if (file != null) {
                    String fileName = "temp" + file.getOriginalFilename();
                    path = path + "/uploadtemp/" + fileName;

                    File localFile = new File(path);
                    try{
                        file.transferTo(localFile);

                    }catch (Exception e){

                    }
                    //result = FileUtil.httpUploadAPP("file", localFile, userId, fileType);
                    //EtApp app = new EtApp();
                    EtProject project = new EtProject();
                    project.setId(projectId);
                    /*EtVersion version = new EtVersion();
                    version.setId(1);*/

                    EtUser currentUser = (EtUser) session.getAttribute("currentUser");
                    currentUser = serviceManager.getUserService().queryUserById(currentUser.getId());
                    //app.setAppName(appname);
                    app.setEtUser(currentUser);
                    //app.setEtVersion(version);
                    app.setProject(project);
                    EtVersion etVersion=serviceManager.getVersionService().queryVersionById(Integer.parseInt(versionId));
                    app.setEtVersion(etVersion);
                    AppType appType = null;
                    if(fileName.endsWith(".apk")){
                        appType = AppType.ANDROID;
                    }else{
                        appType = AppType.IOS;
                    }
                    serviceManager.getAppService().addApp(app, localFile, appType.value());
                }
            }
        }
        return "redirect:/project/" + projectId + "/apps";
    }
}
