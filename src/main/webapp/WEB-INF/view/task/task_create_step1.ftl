<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    <title>
        <@spring.message "project.createone.title"/>
    </title>
    <!-- title logo beg -->
    <#include "/parts/nav_title_logo.ftl">
    <!-- title logo end -->
    <!-- golbal css beg -->
    <#include "/parts/css_global.ftl">
    <!-- golbal css end -->
    <!-- Plugins -->
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/animsition/animsition.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/asscrollable/asScrollable.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/switchery/switchery.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/intro-js/introjs.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/slidepanel/slidePanel.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/flag-icon-css/flag-icon.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/ladda/ladda.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/assets/examples/css/uikit/buttons.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/bootstrap-sweetalert/sweetalert.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/webui-popover/webui-popover.css">

    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/select2/select2.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/icheck/icheck.css">

    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/bootstrap-maxlength/bootstrap-maxlength.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/bootstrap-datepicker/bootstrap-datepicker.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/bootstrap-select/bootstrap-select.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/multi-select/multi-select.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/jstree/jstree.min.css">
    <!-- Fonts -->
    <link rel="stylesheet" href="${rc.contextPath}/static/global/fonts/web-icons/web-icons.min.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/fonts/brand-icons/brand-icons.min.css">
    <!--[if lt IE 9]>
    <script src="${rc.contextPath}/static/global/vendor/html5shiv/html5shiv.min.js"></script>
    <![endif]-->
    <!--[if lt IE 10]>
    <script src="${rc.contextPath}/static/global/vendor/media-match/media.match.min.js"></script>
    <script src="${rc.contextPath}/static/global/vendor/respond/respond.min.js"></script>
    <![endif]-->
    <!-- Scripts -->
    <script src="${rc.contextPath}/static/global/vendor/breakpoints/breakpoints.js"></script>
    <script>
        Breakpoints();
    </script>
</head>
<body class="animsition">
<!-- include ie jianrong beg -->
<#include "/other/ie8_incompatible.ftl">
<!-- include ie jianrong end -->
<!-- include createTaskNavHeader.ftl beg -->
<#include "/task/task_create_nav.ftl"/>
<!-- include createTaskNavHeader.ftl end -->
<!-- Page -->
<div class="page" style="margin-left:0px;">
    <div class="page-content p-t-15 container-fluid">
        <div class="page-header" style="padding:0px 0px 10px 0px;">
            <!--<h1 class="page-title">Page Title</h1>-->
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${rc.contextPath}/mainpage">
                <@spring.message "project.createone.ContextpathHome"/>
                </a></li>
                <li class="breadcrumb-item"><a href="${rc.contextPath}/project/${currentProject.id}">${currentProject.projectName}</a></li>
                <li class="breadcrumb-item active">
                <@spring.message "project.createone.ContextpathTitle"/>
                </li>
            </ol>
        </div>
        <!-- create task beg-->
        <div class="panel m-b-0">
            <header class="panel-heading">
                <div class="panel-title">
                    <i class="icon wb-add-file"></i>
                <@spring.message "project.createone.TableTitle"/>
                </div>
            </header>
            <div class="panel-body">
                <div class="pearls row m-b-30">
                    <div class="pearl current col-xs-4">
                        <span class="pearl-number">1</span>
                        <span class="pearl-title">
                        <@spring.message "project.createone.Onestep"/>
                        </span>
                    </div>
                    <div class="pearl col-xs-4">
                        <span class="pearl-number">2</span>
                        <span class="pearl-title">
                        <@spring.message "project.createone.Twostep"/>
                        </span>
                    </div>
                    <div class="pearl col-xs-4">
                        <span class="pearl-number">3</span>
                        <span class="pearl-title">
                        <@spring.message "project.createone.Threestep"/>
                        </span>
                    </div>
                </div>
                <!-- fenge -->
                <div class="row" style="border-top:1px dashed #8796a4; margin:20px 0px;"></div>
                <!-- step 1 beg-->
                <div class="row" style="margin-top:30px;">
                    <form class="form-horizontal col-lg-12"
                          id="task_step1_form"
                          action="${rc.contextPath}/project/${currentProject.id}/createtask_2"
                          method="post"
                          enctype="multipart/form-data">
                        <h5>
                            <i class="icon wb-order"></i>&nbsp;
                        <@spring.message "project.createone.TableInfoTitle"/>
                        </h5>
                        <!-- task name beg -->
                        <div class="form-group row">
                            <label class="col-xs-12 col-md-2 col-lg-2 form-control-label"><@spring.message "project.createone.TableName"/></label>
                            <div class="col-xs-10 col-md-7 col-lg-5">
                                <input id="task_name" type="text" class="maxlength-input form-control" data-plugin="maxlength"
                                       data-placement="bottom-left-inside" maxlength="20"
                                       name="taskName"
                                       placeholder="<@spring.message "project.createone.TableNameText"/>" autocomplete="off"
                                       required
                                />

                                <div class="col-xs-12 col-md-12 col-lg-12" id="task_name_check" style="display: none;">
                                    <small class="red-500">
                                        <i class="icon wb-warning"></i>
                                        <span id="task_name_check_content"></span>
                                    </small>
                                </div>
                            </div>
                        </div>

                        <!-- task name end -->
                        <!-- task app build beg -->
                        <div class="form-group row">
                            <label class="col-xs-12 col-md-2 col-lg-2 form-control-label">
                            <@spring.message "project.createone.TableBuild"/>
                            </label>
                            <div class="col-xs-12 col-md-4 col-lg-3">
                                <select class="form-control" data-plugin="select2"
                                        name="appId"
                                        id="task_app"
                                        data-placeholder="<@spring.message "project.createone.TableBuildText"/>"
                                        data-allow-clear="true"
                                        required>
                                    <option></option>
                                <#list apps as app>
                                    <#if app.project.id == currentProject.id && (app.visibility == 1 || app.etUser.id == currentUser.id)>
                                        <option value="${app.id}">${app.appName}/${app.etVersion.versionName}</option>
                                    </#if>
                                </#list>
                                </select>

                                <div class="col-xs-12 col-md-12 col-lg-12" id="task_app_check" style="display: none;">
                                    <small class="red-500">
                                        <i class="icon wb-warning"></i>
                                        <span id="task_app_check_content"></span>
                                    </small>
                                </div>
                            </div>
                        </div>
                        <!-- task app build end -->

                        <!--fenge -->
                        <div class="row" style="border-top:1px dashed #8796a4; margin:20px 0px;"></div>

                        <!--prejob beg -->
                        <h5>
                            <i class="icon wb-order"></i>&nbsp;
                            <@spring.message "project.createone.prejob"/>
                        </h5>
                        <div class="form-group row">
                            <label class="col-xs-12 col-md-2 col-lg-1 form-control-label"></label>
                            <div class="col-xs-12 col-md-10 col-lg-10">
                                <div class="row">
                                    <div class="col-xs-6 col-md-4 col-lg-4">
                                        <input type="checkbox"
                                               class="icheckbox-primary"
                                               id="task_restart"
                                               name="isReboot"
                                               value="1"
                                               data-plugin="iCheck"
                                               data-checkbox-class="icheckbox_flat-blue"/>
                                        <label id="task_restart_label" for="task_restart">
                                        <@spring.message "project.createone.prejob.restart"/>
                                        </label>
                                    </div>
                                </div>

                                <div class="row" style="margin-top:15px;">
                                    <div class="col-xs-6 col-md-4 col-lg-4">
                                        <#if weaknets?? && (weaknets?size > 0)>
                                            <input type="checkbox"
                                                   class="icheckbox-primary"
                                                   id="task_weakNetwork"
                                                   name="isNetSimulation"
                                                   data-plugin="iCheck"
                                                   value="1"
                                                   data-checkbox-class="icheckbox_flat-blue"/>
                                            <label for="task_weakNetwork"><@spring.message "project.createone.prejob.networkSimulation"/></label>
                                        <#else >
                                            <input type="checkbox"
                                                   disabled="disabled"
                                                   class="icheckbox-primary"
                                                   id="task_weakNetwork"
                                                   name="isNetSimulation"
                                                   data-plugin="iCheck"
                                                   value="1"
                                                   data-checkbox-class="icheckbox_flat-blue"/>
                                            <label for="task_weakNetwork"><@spring.message "project.createone.prejob.networkSimulation"/></label>

                                            <a href="javascript:void(0)" class="btn btn-sm btn-icon btn-pure btn-default on-default"
                                               data-content="<@spring.message "weaknet.option.null"/>"
                                               data-trigger="hover" data-toggle="popover"
                                               tabindex="0">
                                                <i class="icon wb-help-circle"></i>
                                            </a>

                                        </#if>

                                    </div>
                                </div>
                                <div id="task_network_Select" style="margin-top:15px; margin-left: 50px; display: none;">
                                    <div class="col-xs-12 col-md-2 col-lg-1">
                                    <@spring.message "project.createone.prejob.networkSetting"/>
                                    </div>
                                    <div class="col-lg-3 col-md-6">
                                        <select class="show-tick" name="netSimulationType"
                                                data-plugin="selectpicker">
                                            <#list weaknets as weaknet>
                                                <#if weaknet.sysdefault>
                                                    <option value="${weaknet.key}">&nbsp;
                                                    <@spring.message "createone.weaknet.option.${weaknet.key}"/>
                                                    </option>
                                                </#if>
                                            </#list>
                                        </select>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <!--prejob end -->

                        <!-- fenge -->
                        <div class="row" style="border-top:1px dashed #8796a4; margin:20px 0px;"></div>

                        <!-- testType beg -->
                        <h5>
                            <i class="icon wb-order"></i>&nbsp;
                            <@spring.message "project.createone.TableFunction"/>
                        </h5>
                        <div class="form-group row">
                            <label class="col-xs-12 col-md-2 col-lg-1 form-control-label"></label>
                            <div class="col-xs-12 col-md-10 col-lg-10">

                                <#--<!-- 分组测试 &ndash;&gt;
                                <div class="row">
                                    <div class="col-xs-6 col-md-4 col-lg-4">
                                        <input type="radio" class="icheckbox-primary " id="test_single" name="test_group"
                                               data-plugin="iCheck" data-radio-class="iradio_flat-blue" checked/>
                                        <label for="test_single" style="margin-right: 50px"><@spring.message "project.createone.singleTest"/></label>

                                        <input type="radio" class="icheckbox-primary" id="test_combinatorial" name="test_group"
                                               data-plugin="iCheck" data-radio-class="iradio_flat-blue" />
                                        <label for="test_combinatorial"><@spring.message "project.createone.combinatorialTest"/> </label>
                                    </div>
                                </div>-->

                                <!-- 兼容测试 -->
                                <div class="row" style="margin-top:30px;">
                                    <div class="col-xs-6 col-md-4 col-lg-4">
                                        <input type="checkbox" class="icheckbox-primary"
                                               id="task_compatibility"
                                               name="compatibilityTest"
                                               value="1"
                                               data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                                        <label id="task_btn_compatibility_label" for="task_compatibility">
                                            <@spring.message "project.createone.Compatibility"/>
                                        </label>
                                    </div>
                                    <div class="col-xs-6 col-md-8 col-lg-8">

                                    </div>

                                </div>

                                <!-- 兼容测试隐藏区 -->
                                <div id="task_compatibility_area" style="display: none; margin-left: 50px">
                                    <!-- 兼容类型 -->
                                    <div class="row" style="margin-top:15px;">
                                        <div class="col-xs-12 col-md-2 col-lg-1">
                                            <label class="form-control-label p-0" for="task_compatibility_type"><@spring.message "project.createone.Compatibility.type"/></label>
                                        </div>
                                        <div class="col-xs-12 col-md-10 col-lg-11">
                                            <input type="radio"
                                                   class="icheckbox-primary"
                                                   id="task_monkey_normal"
                                                   name="compatibilityType"
                                                   data-plugin="iCheck"
                                                   value="0"
                                                   data-radio-class="iradio_flat-blue"
                                                   checked/>
                                            <label for="task_monkey_normal">Monkey</label>
                                            <a href="javascript:void(0)" class="btn btn-sm btn-icon btn-pure btn-default on-default"
                                               data-content="<@spring.message "project.createone.Compatibility.monkey.help"/>"
                                               data-trigger="hover" data-toggle="popover"
                                               tabindex="0" style="margin-right: 40px">
                                                <i class="icon wb-help-circle"></i>
                                            </a>
                                        <#if currentProject.projectType == 0>

                                            <input type="radio"
                                                   class="icheckbox-primary"
                                                   id="task_monkey_smart"
                                                   name="compatibilityType"
                                                   data-plugin="iCheck"
                                                   value="1"
                                                   data-radio-class="iradio_flat-blue" />
                                            <label for="task_monkey_smart">SmartMonkey</label>
                                            <a href="javascript:void(0)" class="btn btn-sm btn-icon btn-pure btn-default on-default"
                                               data-content="<@spring.message "project.createone.Compatibility.smartmonkey.help"/>"
                                               data-trigger="hover" data-toggle="popover"
                                               tabindex="0">
                                                <i class="icon wb-help-circle"></i>
                                            </a>
                                        </#if>
                                        </div>
                                    </div>

                                    <!-- 兼容时间 -->
                                    <div class="row" style="margin-top:15px;">
                                        <div class="col-xs-12 col-md-2 col-lg-1">
                                            <label class="form-control-label p-0" for="task_compatibility_area">
                                            <@spring.message "project.createone.CompatibilityTime"/>
                                            </label>
                                        </div>
                                        <div class="col-xs-12 col-md-4 col-lg-4">
                                            <input id="task_compatibility_time"
                                                   type="text" class="form-control" value="20"
                                                   name="compatibilityTime" autocomplete="off"
                                            />

                                            <div class="col-xs-12 col-md-12 col-lg-12" id="task_compatibility_time_check" style="display: none;">
                                                <small class="red-500">
                                                    <i class="icon wb-warning"></i>
                                                    <span id="task_compatibility_time_check_content"></span>
                                                </small>
                                            </div>

                                            <span class="text-help"><@spring.message "project.createone.TravelText"/></span>

                                        </div>
                                    </div>

                                    <!-- 兼容高级 -->
                                    <div class="row" style="margin-top:15px;">
                                        <div class="col-xs-12 col-md-2 col-lg-1">
                                            <label class="form-control-label p-0" for="task_btn_optInfo">
                                            <@spring.message "project.createone.CompatibilitySet"/>
                                            </label>
                                        </div>
                                        <div class="col-xs-12 col-md-3 col-lg-3">
                                            <div class="pull-xs-left m-r-20">
                                                <input id="task_btn_optInfo" type="checkbox"
                                                       name="inputiCheckBasicCheckboxes" data-plugin="switchery"
                                                />
                                            </div>
                                        </div>

                                    </div>

                                    <!-- 兼容高级隐藏区 -->
                                    <div id="task_optInfo_area" class="row" style="margin-top:15px; display: none;">
                                        <div class="col-xs-12 col-md-2 col-lg-1">
                                            <label class="form-control-label p-0"><@spring.message "project.createone.CompatibilityLogin"/></label>
                                        </div>
                                        <div class="col-xs-12 col-md-5 col-lg-5">
                                        <textarea class="maxlength-textarea form-control" data-plugin="maxlength"
                                                  name = "optInfo"
                                                  data-placement="bottom-right-inside"
                                                  maxlength="250" rows="4" placeholder="<@spring.message "project.createone.CompatibilitText"/>"></textarea>
                                        </div>
                                        <div class="col-xs-12 col-md-6 col-lg-6">
                                            <p><@spring.message "project.createone.CompatibilityTipone"/></p>
                                            <p><@spring.message "project.createone.CompatibilityTiptwo"/></p>
                                            <p><@spring.message "project.createone.CompatibilityTipthree"/></p>
                                        </div>
                                    </div>
                                </div>

                                <!-- 自动化脚本测试 -->
                                <div class="row" style="margin-top:15px;">
                                    <div class="col-xs-6 col-md-4 col-lg-4">
                                        <input type="checkbox" class="icheckbox-primary"
                                               id="task_script"
                                               name="scriptTest"
                                               value="1"
                                               data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                                        <label for="task_script">
                                        <@spring.message "project.createone.Case"/>
                                        </label>
                                    </div>
                                    <div class="col-xs-6 col-md-8 col-lg-8">

                                    </div>
                                </div>

                                <!-- 自动化脚本测试隐藏区 -->
                                <div id="task_script_area" style="display: none; margin-left: 50px">

                                    <!-- 脚本测试类型 -->
                                    <div class="row" style="margin-top:15px;">
                                        <div class="col-xs-12 col-md-2 col-lg-1">
                                            <label class="p-t-3"><@spring.message "project.createone.CaseStructure"/></label>
                                        </div>
                                        <div class="col-xs-12 col-md-10 col-lg-11">
                                            <#if currentProject.projectType == 0>

                                                <input type="radio" class="icheckbox-primary"
                                                       id="script_robotFramework"
                                                       name="scriptType"
                                                       value="3"
                                                       data-plugin="iCheck"
                                                       data-radio-class="iradio_flat-blue"
                                                       checked/>
                                                <label for="script_robotFramework" style="margin-right: 30px">RobotFramework</label>

                                                <input type="radio" class="icheckbox-primary"
                                                       id="script_appium"
                                                       name="scriptType"
                                                       value="0"
                                                       data-plugin="iCheck"
                                                       data-radio-class="iradio_flat-blue" />
                                                <label for="script_appium" style="margin-right: 30px">Appium</label>

                                                <input type="radio" class="icheckbox-primary"
                                                       id="script_robotium"
                                                       name="scriptType"
                                                       value="1"
                                                       data-plugin="iCheck"
                                                       data-radio-class="iradio_flat-blue"/>
                                                <label for="script_robotium" style="margin-right: 30px">Robotium</label>

                                                <input type="radio" class="icheckbox-primary"
                                                       id="script_uiautomator"
                                                       name="scriptType"
                                                       value="2"
                                                       data-plugin="iCheck"
                                                       data-radio-class="iradio_flat-blue"/>
                                                <label for="script_uiautomator" style="margin-right: 30px">Uiautomator</label>

                                            <#else >
                                                <input type="radio" class="icheckbox-primary"
                                                       id="script_robotFramework"
                                                       name="scriptType"
                                                       value="3"
                                                       data-plugin="iCheck"
                                                       data-radio-class="iradio_flat-blue"
                                                       checked/>
                                                <label for="script_robotFramework" style="margin-right: 30px">RobotFramework</label>

                                            <input type="radio" class="icheckbox-primary"
                                                   id="script_appium"
                                                   name="scriptType"
                                                   value="0"
                                                   data-plugin="iCheck"
                                                   data-radio-class="iradio_flat-blue" />
                                            <label for="script_appium" style="margin-right: 30px">Appium</label>
                                            </#if>
                                        </div>
                                    </div>
                                    <!-- 脚本上传 -->
                                    <div class="row" style="margin-top:15px;" id="script_file_upload">
                                        <div class="col-xs-12 col-md-2 col-lg-1">
                                            <label class="form-control-label p-0"><@spring.message "project.createone.CaseUpload"/></label>
                                        </div>
                                        <div class="col-xs-12 col-md-5 col-lg-4">
                                            <div  class="input-group input-group-file" data-plugin="inputGroupFile">
                                                <input id="script_file_text" type="text" class="form-control" readonly=""
                                                       placeholder="<@spring.message "project.createone.CaseUploadtext"/>">
                                                <span class="input-group-btn">
                                                    <span class="btn btn-primary btn-file" id="btn_script_file_upload">
                                                        <i class="icon wb-upload" aria-hidden="true"></i>
                                                        <input id="script_file" type="file" name="attachFileNames" multiple="multiple">
                                                    </span>
                                                </span>
                                            </div>
                                            <div class="col-xs-12 col-md-12 col-lg-12" id="script_file_check" style="display: none;">
                                                <small class="red-500">
                                                    <i class="icon wb-warning"></i>
                                                    <span id="script_file_check_content"></span>
                                                </small>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- rf 脚本目录树 隐藏区 -->
                                    <div class="row" style="display: none; margin-top:5px" id="rf_script_tree_area">
                                        <div class="col-md-12 col-xs-12 offset-md-2 offset-lg-1 p-l-30" style="margin-top:5px">
                                            <div id="file_tree"></div>
                                            <input type="hidden" id="scriptCmd" name="scriptCmd" value="">
                                            <div class="col-md-12 col-xs-12 p-0" id="file_tree_check" style="display: none;">
                                                <small class="red-500">
                                                    <i class="icon wb-warning"></i>
                                                    <span id="file_tree_check_content"></span>
                                                </small>
                                            </div>
                                        </div>

                                        <div class="col-xs-12 col-md-2 col-lg-1" style="margin-top:17px">
                                            <label class="p-t-3">Tags</label>
                                        </div>

                                        <div class="col-xs-12 col-md-5 col-lg-4" style="margin-top:15px">
                                            <select class="show-tick" data-plugin="selectpicker" id="rf_script_tag" multiple data-selected-text-format="count > 3"  title="<@spring.message "task.create.stepone.tag.title"/>">

                                            </select>
                                        </div>

                                    </div>
                                </div>
                                <#if currentProject.projectType == 0>
                                    <!-- 遍历测试 -->
                                    <div class="row" style="margin-top:15px;">
                                        <div class="col-xs-6 col-md-4 col-lg-4">
                                            <input type="checkbox" class="icheckbox-primary"
                                                   id="task_traversal"
                                                   name="traversalTest"
                                                   value="1"
                                                   data-plugin="iCheck"
                                                   data-checkbox-class="icheckbox_flat-blue"/>
                                            <label for="task_traversal">
                                                <@spring.message "project.createone.Travel"/>
                                            </label>
                                        </div>
                                        <div class="col-xs-6 col-md-8 col-lg-8">

                                        </div>
                                    </div>

                                    <!-- 遍历测试隐藏区 -->
                                    <div id="task_traversal_area" style="display: none; margin-left: 50px">
                                        <div class="row" style="margin-top:15px;">
                                            <div class="col-xs-12 col-md-2 col-lg-1">
                                                <label class="form-control-label p-0" for="testtime"><@spring.message "project.createone.TravelTime"/></label>
                                            </div>
                                            <div class="col-xs-12 col-md-4 col-lg-4">
                                                <input id="task_traversal_time" type="text"
                                                       class="form-control" value="20"
                                                       name="traversalTime"
                                                       autocomplete="off"
                                                />
                                                <div class="col-xs-12 col-md-12 col-lg-12" id="task_traversal_time_check" style="display: none;">
                                                    <small class="red-500">
                                                        <i class="icon wb-warning"></i>
                                                        <span id="task_traversal_time_check_content"></span>
                                                    </small>
                                                </div>

                                                <span class="text-help"><@spring.message "project.createone.TravelText"/></span>
                                            </div>
                                        </div>
                                    </div>

                                    <!-- 智能遍历 -->
                                    <#--<div id="smart_traversal_check" class="row" style="margin-top:15px;">
                                        <div class="col-xs-6 col-md-4 col-lg-4">
                                            <input type="checkbox" class="icheckbox-primary" id="task_smartTraversal" name="smartTraversalTest" value="1"
                                                   data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                                            <label for="task_smartTraversal"><@spring.message "project.createone.SmartTraversal"/></label>
                                        </div>
                                    </div>-->
                                </#if>

                                <div class="col-xs-12 col-md-12 col-lg-12 p-0 m-t-10" id="task_type_check" style="display: none;">
                                    <small class="red-500"><i class="icon wb-warning"></i>
                                        <span id="task_type_check_content"></span>
                                    </small>
                                </div>
                            </div>
                        </div>
                        <!-- testType end -->

                        <!-- 第一步提交按钮 -->
                        <div class="row" style="margin-top:10px;">
                            <div class="pull-xs-right">
                                <button id="task_step1_submit" type="button" class="btn btn-primary ladda-button"
                                        data-style="slide-right"
                                        data-plugin="ladda">
                                    <span class="ladda-label">
                                        <@spring.message "project.createone.Next"/>
                                        <i class="icon wb-arrow-right m-l-10"
                                           aria-hidden="true"></i></span>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
                <!-- step 1 end-->
            </div>
        </div>
        <!-- create task end-->
    </div>
</div>
<!-- End Page -->
<input type="hidden" id="baseUrl" baseUrl="${rc.contextPath}"/>

<!-- Footer -->
<#include "/parts/footer_all.ftl">
<!-- Core  -->
<script src="${rc.contextPath}/static/global/vendor/babel-external-helpers/babel-external-helpers.js"></script>
<script src="${rc.contextPath}/static/global/vendor/jquery/jquery.js"></script>
<script src="${rc.contextPath}/static/global/vendor/tether/tether.js"></script>
<script src="${rc.contextPath}/static/global/vendor/bootstrap/bootstrap.js"></script>
<script src="${rc.contextPath}/static/global/vendor/animsition/animsition.js"></script>
<script src="${rc.contextPath}/static/global/vendor/mousewheel/jquery.mousewheel.js"></script>
<script src="${rc.contextPath}/static/global/vendor/asscrollbar/jquery-asScrollbar.js"></script>
<script src="${rc.contextPath}/static/global/vendor/asscrollable/jquery-asScrollable.js"></script>
<script src="${rc.contextPath}/static/global/vendor/ashoverscroll/jquery-asHoverScroll.js"></script>
<script src="${rc.contextPath}/static/global/vendor/bootstrap-select/bootstrap-select.js"></script>
<!-- Plugins -->
<script src="${rc.contextPath}/static/global/vendor/switchery/switchery.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/intro-js/intro.js"></script>
<script src="${rc.contextPath}/static/global/vendor/screenfull/screenfull.js"></script>
<script src="${rc.contextPath}/static/global/vendor/slidepanel/jquery-slidePanel.js"></script>
<script src="${rc.contextPath}/static/global/vendor/ladda/spin.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/ladda/ladda.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/select2/select2.full.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/icheck/icheck.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/bootstrap-sweetalert/sweetalert.js"></script>
<script src="${rc.contextPath}/static/global/vendor/bootstrap-maxlength/bootstrap-maxlength.js"></script>
<script src="${rc.contextPath}/static/global/vendor/webui-popover/jquery.webui-popover.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/jstree/jstree.min.js"></script>

<!-- Scripts -->
<script src="${rc.contextPath}/static/global/js/State.js"></script>
<script src="${rc.contextPath}/static/global/js/Component.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin.js"></script>
<script src="${rc.contextPath}/static/global/js/Base.js"></script>
<script src="${rc.contextPath}/static/global/js/Config.js"></script>
<script src="${rc.contextPath}/static/assets/js/Section/Menubar.js"></script>
<script src="${rc.contextPath}/static/assets/js/Section/GridMenu.js"></script>
<script src="${rc.contextPath}/static/assets/js/Section/Sidebar.js"></script>
<script src="${rc.contextPath}/static/assets/js/Section/PageAside.js"></script>
<script src="${rc.contextPath}/static/assets/js/Plugin/menu.js"></script>
<script src="${rc.contextPath}/static/global/js/config/colors.js"></script>
<script src="${rc.contextPath}/static/assets/js/config/tour.js"></script>

<!-- datatables beg-->
<script src="${rc.contextPath}/static/global/vendor/datatables/jquery.dataTables.js"></script>
<script src="${rc.contextPath}/static/global/vendor/datatables-fixedheader/dataTables.fixedHeader.js"></script>
<script src="${rc.contextPath}/static/global/vendor/datatables-bootstrap/dataTables.bootstrap.js"></script>
<script src="${rc.contextPath}/static/global/vendor/datatables-responsive/dataTables.responsive.js"></script>
<script src="${rc.contextPath}/static/global/vendor/datatables-tabletools/dataTables.tableTools.js"></script>
<!-- datatables end-->
<script>
    Config.set('assets', '${rc.contextPath}/static/assets');
</script>
<!-- Page -->
<script src="${rc.contextPath}/static/assets/js/Site.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/asscrollable.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/slidepanel.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/switchery.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/datatables.js"></script>
<script src="${rc.contextPath}/static/js/datatable.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/loading-button.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/more-button.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/ladda.js"></script>
<script src="${rc.contextPath}/static/assets/examples/js/uikit/tooltip-popover.js"></script>

<script src="${rc.contextPath}/static/global/js/Plugin/input-group-file.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/bootstrap-select.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/select2.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/icheck.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/bootstrap-maxlength.js"></script>
<script src="${rc.contextPath}/static/js/common/jquery.i18n.properties.js"></script>
<script src="${rc.contextPath}/static/js/common/i18n_setting.js"></script>
<script src="${rc.contextPath}/static/js/task/task_create_step1.js"></script>

<script>
    (function (document, window, $) {
        'use strict';
        var Site = window.Site;
        $(document).ready(function () {
            Site.run();
        });
    })(document, window, jQuery);
</script>
</body>
</html>