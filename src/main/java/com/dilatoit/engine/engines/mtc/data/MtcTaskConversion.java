package com.dilatoit.engine.engines.mtc.data;

import com.dilatoit.eagletest.config.WeaknetConfig;
import com.dilatoit.eagletest.exception.ex.ConfigException;
import com.dilatoit.engine.dto.EngineTaskDTO;
import com.dilatoit.engine.dto.EngineTaskMobileDTO;
import com.dilatoit.engine.engines.mtc.data.task.*;
import com.dilatoit.engine.exception.EngineException;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xueshan.wei on 4/1/2017.
 */
@Component
@Scope("singleton")
public class MtcTaskConversion {
    //日志记录类
    private static final Logger logger = LoggerFactory.getLogger(MtcTaskConversion.class);
    @Autowired
    private WeaknetConfig weaknetConfig;

    public String conversion(EngineTaskDTO engineTask) throws EngineException {
        MtcTask mtcTask = new MtcTask();

        //设置基础信息
        mtcTask.setApkUrl(engineTask.getAppUrl());
        mtcTask.setOs(String.valueOf(engineTask.getOsType()));
        mtcTask.setUserId("1");
        MtcTaskInfo taskInfo = new MtcTaskInfo();
        taskInfo.setTaskName(engineTask.getTaskName());
        mtcTask.setTaskInfo(taskInfo);

        String[] opt = engineTask.getOptInfo().split(",");
        MtcOptInfo optInfo = new MtcOptInfo();
        if(opt.length == 2){
            optInfo.getLogin().setUsername(opt[0]);
            optInfo.getLogin().setPassword(opt[1]);
        }
        mtcTask.setOptInfo(optInfo);


        //设置三种测试
        MtcTaskList mtcTaskList = new MtcTaskList();
        //设置兼容测试
        if(engineTask.isCompatibility()){
            MtcSetUp mtcCompSetUp = null;
            MtcTeardown mtcCompTeardown = null;
            MtcMobile mtcMobile = null;
            MtcCompJob mtcCompJob = null;
            MtcCompJobInfo mtcCompJobInfo = null;

            MtcComp mtcComp = new MtcComp();
            MtcMonkey mtcMonkey = new MtcMonkey();

            List<MtcCompJob> mtcCompJobList = new ArrayList<MtcCompJob>();

            for(EngineTaskMobileDTO mobile : engineTask.getMobiles()){
                mtcCompJob = new MtcCompJob();
                mtcCompJobInfo = new MtcCompJobInfo();

                //设置job基础信息
                String monkeyType = null;
                if(engineTask.getCompatibilityType() == 0){
                    monkeyType = "monkey";
                }else {
                    monkeyType = "smartMonkey";
                }
                mtcCompJobInfo.setRunType(monkeyType);
                mtcCompJobInfo.setTestTime(String.valueOf(engineTask.getCompatibilityTime()));

                //设置前处理后处理
                if(engineTask.isPrejob()){

                    mtcCompSetUp = new MtcSetUp();
                    MtcEnv env = new MtcEnv(true);//这里默认设置为clean
                    mtcCompSetUp.setEnv(env);

                    mtcCompSetUp.setReboot(engineTask.isReboot());

                    mtcCompTeardown = new MtcTeardown();
                    mtcCompTeardown.setReboot(engineTask.isReboot());
                    //这里默认设置为true
                    mtcCompTeardown.setCleanApk(true);

                    //是否设置了网络模拟
                    if(engineTask.isNetsimulation()){
                        setWeaknetScript(engineTask.getNetsimulationData(), mtcCompSetUp, mtcCompTeardown, mobile);
                    }

                    mtcCompJobInfo.setMtcSetUp(mtcCompSetUp);
                    mtcCompJobInfo.setTeardown(mtcCompTeardown);
                }
                mtcMobile = new MtcMobile(mobile.getBrand(),
                        mobile.getModel(), mobile.getOs(), mobile.getSerialno());
                mtcCompJob.setJobInfo(mtcCompJobInfo);
                mtcCompJob.setMtcMobile(mtcMobile);
                mtcCompJobList.add(mtcCompJob);

            }
            mtcMonkey.setJobList(mtcCompJobList);
            mtcComp.setMtcMonkey(mtcMonkey);
            mtcTaskList.setComp(mtcComp);
        }
        //设置脚本测试
        if(engineTask.isScript()){
            MtcCaseType mtcCaseType = new MtcCaseType();
            List<MtcCaseJob> mtcCaseJobList = new ArrayList<MtcCaseJob>();

            MtcMobile mtcCaseMobile = null;
            MtcCaseJob mtcCaseJob = null;
            MtcSetUp mtcCaseSetUp = null;
            MtcTeardown mtcCaseTeardown = null;
            for(EngineTaskMobileDTO mobile : engineTask.getMobiles()){
                mtcCaseJob = new MtcCaseJob();

                MtcCaseJobInfo mtcCaseJobInfo = new MtcCaseJobInfo();
                mtcCaseJobInfo.setTaskCaseUrl(engineTask.getScriptUrl());
                // rf设置脚本参数
                if(engineTask.getScriptType() == ScriptFrameTypeEnum.ROBOTFRAMEWORK.value()){
                    mtcCaseJobInfo.setRunCmd(engineTask.getScriptCmd());
                }

                //设置前处理后处理
                if(engineTask.isPrejob()){
                    mtcCaseSetUp = new MtcSetUp();
                    MtcEnv env = new MtcEnv(true);//这里默认设置为clean
                    mtcCaseSetUp.setEnv(env);

                    mtcCaseSetUp.setReboot(engineTask.isReboot());

                    mtcCaseTeardown = new MtcTeardown();
                    mtcCaseTeardown.setReboot(engineTask.isReboot());
                    //这里默认设置为true
                    mtcCaseTeardown.setCleanApk(true);
                    //是否有网络模拟
                    if(engineTask.isNetsimulation()){
                        setWeaknetScript(engineTask.getNetsimulationData(), mtcCaseSetUp, mtcCaseTeardown, mobile);
                    }

                    mtcCaseJobInfo.setSetUp(mtcCaseSetUp);
                    mtcCaseJobInfo.setTeardown(mtcCaseTeardown);
                }

                mtcCaseJob.setCaseJobInfo(mtcCaseJobInfo);
                mtcCaseMobile = new MtcMobile(mobile.getBrand(), mobile.getModel(),
                            mobile.getOs(), mobile.getSerialno());
                mtcCaseJob.setMtcMobile(mtcCaseMobile);
                mtcCaseJobList.add(mtcCaseJob);
            }
            mtcCaseType.setCaseJobList(mtcCaseJobList);
            MtcCase mtcCase = null;
            try{
                mtcCase = new MtcCase(ScriptFrameTypeEnum.indexName(engineTask.getScriptType()), mtcCaseType);
            }catch (EngineException ee){
                throw new EngineException(ee.getEe());
            }
            mtcTaskList.setMtcCase(mtcCase);
        }
        //设置遍历测试
        if(engineTask.isTraversal()){
            MtcTraversal mtcTraversal = new MtcTraversal();
            MtcTraversal2 mtcTraversal2 = new MtcTraversal2();
            List<MtcTraversalJob> traversalJobList = new ArrayList<MtcTraversalJob>();


            MtcMobile mtcMobile = null;
            MtcTraversalJob mtcTraversalJob = null;
            MtcTraversalJobInfo traversalJobInfo = null;
            MtcSetUp mtcTravelSetUp = null;
            MtcTeardown mtcTravelTeardown = null;

            for(EngineTaskMobileDTO mobile : engineTask.getMobiles()){

                mtcTraversalJob = new MtcTraversalJob();
                traversalJobInfo = new MtcTraversalJobInfo();

                traversalJobInfo.setTestTime(engineTask.getTraversalTime());

                if(engineTask.isPrejob()){

                    mtcTravelSetUp = new MtcSetUp();
                    MtcEnv env = new MtcEnv(true);//这里默认设置为clean
                    mtcTravelSetUp.setEnv(env);
                    mtcTravelSetUp.setReboot(engineTask.isReboot());

                    mtcTravelTeardown = new MtcTeardown();
                    mtcTravelTeardown.setReboot(engineTask.isReboot());
                    //这里默认设置为true
                    mtcTravelTeardown.setCleanApk(true);
                    //是否存在网络模拟
                    if(engineTask.isNetsimulation()){
                        setWeaknetScript(engineTask.getNetsimulationData(), mtcTravelSetUp, mtcTravelTeardown, mobile);
                    }
                    traversalJobInfo.setSetUp(mtcTravelSetUp);
                    traversalJobInfo.setTeardown(mtcTravelTeardown);
                }

                mtcTraversalJob.setTraversalJobInfo(traversalJobInfo);
                mtcMobile = new MtcMobile(mobile.getBrand(), mobile.getModel(),
                                mobile.getOs(), mobile.getSerialno());
                mtcTraversalJob.setMobile(mtcMobile);
                traversalJobList.add(mtcTraversalJob);
            }

            mtcTraversal2.setJobList(traversalJobList);
            mtcTraversal.setTravel(mtcTraversal2);
            mtcTaskList.setTraversal(mtcTraversal);
        }
        mtcTask.setTaskList(mtcTaskList);

        //返回json 结构字符串
        Gson gson = new Gson();
        return gson.toJson(mtcTask);
    }

    private void setWeaknetScript(String setupDate, MtcSetUp setUp, MtcTeardown teardown,
                                  EngineTaskMobileDTO mobile) throws EngineException{
        //添加前处理弱网设置脚本
        List<MtcScript> scriptListSetUp = new ArrayList<MtcScript>();
        MtcScript scriptSetUp = new MtcScript();
        try {
            scriptSetUp.setScriptUrl(weaknetConfig.getStartScriptLocation());
        } catch (ConfigException e) {
            e.printStackTrace();
            throw new EngineException(e.getEe());
        }
        //弱网脚本命令
        String setUPcmd = null;
        String tearCmd = null;
        try {
            // TODO: 5/3/2017 弱网设置的参数数据也可以从这里设置 
            setUPcmd = weaknetConfig.getStartCmd() + " " + weaknetConfig.getServerUrl() + " " + mobile.getIp() + " " + setupDate;
            tearCmd = weaknetConfig.getEndCmd() + " " + weaknetConfig.getServerUrl() + " " + mobile.getIp();
        }catch (ConfigException ce){
            logger.error("从weaknet.properties文件中读取脚本设置命令失败，请检查弱网配置文件");
            throw new EngineException(ce.getEe());
        }
        scriptSetUp.setScriptCmd(setUPcmd);
        scriptListSetUp.add(scriptSetUp);
        setUp.setMtcScripts(scriptListSetUp);

        //添加后处理取消弱网设置脚本
        List<MtcScript> scriptTeardownList = new ArrayList<MtcScript>();
        MtcScript scriptTeardown = new MtcScript();
        try {
            scriptTeardown.setScriptUrl(weaknetConfig.getEndScriptLocation());
        } catch (ConfigException e) {
            e.printStackTrace();
            throw new EngineException(e.getEe());
        }

        scriptTeardown.setScriptCmd(tearCmd);
        scriptTeardownList.add(scriptTeardown);
        teardown.setMtcScripts(scriptTeardownList);
    }
}
