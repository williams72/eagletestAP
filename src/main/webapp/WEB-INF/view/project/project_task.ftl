<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    <title>
        <@spring.message "project.task.title"/>
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
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/bootstrap-sweetalert/sweetalert.css">

    <!-- Fonts -->
    <link rel="stylesheet" href="${rc.contextPath}/static/global/fonts/web-icons/web-icons.min.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/fonts/brand-icons/brand-icons.min.css">
    <!-- datatables beg -->
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/datatables-bootstrap/dataTables.bootstrap.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/datatables-fixedheader/dataTables.fixedHeader.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/datatables-responsive/dataTables.responsive.css">
    <!-- datatables end -->
 <#--   <!-- progress bar beg&ndash;&gt;
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/progress-bar/pro-bars.min.css">
    <script src="${rc.contextPath}/static/global/vendor/progress-bar/appear.min.js"></script>
    <script src="${rc.contextPath}/static/global/vendor/progress-bar/pro-bars.js"></script>
    <!-- progress bar end&ndash;&gt;-->
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
<!-- include nav ftl beg -->
<#include "/project/project_nav.ftl">
<!-- include nav ftl end -->

<!-- project_side beg -->
<div class="site-menubar">
    <div class="site-menubar-body">
        <div>
            <div>
                <ul class="site-menu" data-plugin="menu">
                    <li class="site-menu-category">
                        <h4 class="inline-block">${currentProject.projectName}</h4>
                        <span class="tag tag-success">${currentProject.projectKey}</span>
                    </li>
                    <li class="site-menu-item">
                        <a href="${rc.contextPath}/project/${currentProject.id}/dashboard" id="btn_side_dashbord">
                            <i class="site-menu-icon wb-dashboard" aria-hidden="true"></i>
                            <span class="site-menu-title"><@spring.message "project.dashboard"/></span>
                        </a>
                    </li>
                    <li class="site-menu-item active">
                        <a href="${rc.contextPath}/project/${currentProject.id}/tasks" id="btn_side_task">
                            <i class="site-menu-icon wb-list" aria-hidden="true"></i>
                            <span class="site-menu-title"><@spring.message "project.tasks"/></span>
                        </a>
                    </li>
                    <li class="site-menu-item">
                        <a href="${rc.contextPath}/project/${currentProject.id}/versions" id="btn_side_version">
                            <i class="site-menu-icon wb-code-working" aria-hidden="true"></i>
                            <span class="site-menu-title"><@spring.message "project.version"/></span>
                        </a>
                    </li>
                    <li class="site-menu-item">
                        <a href="${rc.contextPath}/project/${currentProject.id}/apps" id="btn_side_app">
                            <i class="site-menu-icon wb-briefcase" aria-hidden="true"></i>
                            <span class="site-menu-title"><@spring.message "project.builds"/></span>
                        </a>
                    </li>
                <#if currentProjectUser.projectRole == 1>
                    <li class="site-menu-item">
                        <a href="${rc.contextPath}/project/${currentProject.id}/users" id="btn_side_members">
                            <i class="site-menu-icon wb-users" aria-hidden="true"></i>
                            <span class="site-menu-title"><@spring.message "project.members"/></span>
                        </a>
                    </li>
                </#if>
                    <!--
                    <li class="site-menu-item">
                        <a href="${rc.contextPath}/project/${currentProject.id}/setting">
                            <i class="site-menu-icon wb-settings" aria-hidden="true"></i>
                            <span class="site-menu-title"><@spring.message "project.settings"/></span>
                        </a>
                    </li>
                    -->
                </ul>
            </div>
        </div>
    </div>
    <!--
    <div class="site-menubar-footer">
        <div class="site-menubar-section" style="margin-top:10px; margin-bottom: 10px;">
            <h5>
                Milestone
                <span class="pull-xs-right">30%</span>
            </h5>
            <div class="progress progress-xs">
                <div class="progress-bar active" style="width: 30%;" role="progressbar"></div>
            </div>
            <h5>
                Release
                <span class="pull-xs-right">60%</span>
            </h5>
            <div class="progress progress-xs">
                <div class="progress-bar progress-bar-warning" style="width: 60%;" role="progressbar"></div>
            </div>
        </div>
    </div>
    -->
</div>
<!-- project_side end -->

<!-- Page -->
<div class="page">
    <div class="page-header p-t-10 p-b-10">
        <!--<h1 class="page-title">Page Title</h1>-->
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${rc.contextPath}/mainpage">
            <@spring.message "project.task.ContextpathHome"/>
            </a></li>
            <li class="breadcrumb-item"><a href="${rc.contextPath}/project/${currentProject.id}">${currentProject.projectName}</a></li>
            <li class="breadcrumb-item active">
            <@spring.message "project.task.ContextpathTitle"/>
            </li>
        </ol>
    </div>
    <div class="page-content">

        <!-- datatables beg-->
        <!-- Panel FixedHeader -->
        <div class="panel">
            <header class="panel-heading">
                <h3 class="panel-title"><i class="icon wb-list"></i><@spring.message "project.task.title"/></h3>
            </header>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-2 col-lg-2">
                        <a class="btn btn-primary" id="btn_creatTask" href="${rc.contextPath}/project/${currentProject.id}/createtask">
                            <i class="icon wb-plus"></i>&nbsp;<@spring.message "project.task.TableBtn"/>
                        </a>
                    </div>
                </div>
                <div class="example">
                    <table class="table m-b-0">
                        <thead>
                        <tr>
                            <th>
                            <@spring.message "project.task.TableName"/>
                            </th>
                            <th>
                            <@spring.message "project.task.TableVersion"/>
                            </th>
                            <th>
                            <@spring.message "project.task.TableBuild"/>
                            </th>
                            <th>
                            <@spring.message "project.task.TableType"/>
                            </th>
                            <th>
                            <@spring.message "project.task.TableCreater"/>
                            </th>
                            <th>
                            <@spring.message "project.task.TableTime"/>
                            </th>
                            <th>
                            <@spring.message "project.task.TableStatus"/>
                            </th>
                            <#--<th>
                            <@spring.message "project.task.TableResult"/>
                            </th>-->
                            <th>
                                <@spring.message "project.task.TableOperation"/>
                            </th>
                        </tr>
                        </thead>
                        <tbody >
                        <#list page.data as task>
                        <tr >
                            <td>
                                ${task.taskName}
                            </td>
                            <td>${task.etVersion.versionName}</td>
                            <td>
                                ${task.etApp.appName}
                            </td>
                            <td>
                                <#if task.hasNetSimulation == 1>
                                <span class="tag tag-primary">
                                    <i class="icon wb-signal" title='<@spring.message "createone.weaknet.option.${task.netSimulation.key}"/>'></i>
                                </span>
                                </#if>
                                <#list task.testTypes as testtype>
                                    <#switch testtype.shortKey>
                                        <#case "COMP">
                                            <span class="tag tag-info" title="${taskParamList[task_index].compatibilityTime}min">${testtype.shortKey}</span>
                                            <#break>
                                        <#case "TRA">
                                            <span class="tag tag-info" title="${taskParamList[task_index].traversalTime}min">${testtype.shortKey}</span>
                                            <#break>
                                        <#case "CASE">
                                            <span class="tag tag-info">${testtype.shortKey}</span>
                                            <#break>
                                    </#switch>
                                </#list>
                            </td>
                            <td>
                                <img class="avatar avatar-xs"
                                     src="${rc.contextPath}/static/img/avatar/${task.etUser.avatars}"
                                     title="${task.etUser.email}"
                                />
                                ${task.etUser.username}
                            </td>
                            <td>
                                <i class="icon wb-time"></i> <span title="${task.createTime}">${task.createTime?string("MM-dd HH:mm")}</span>
                            </td>
                            <td id="status${task.id}">
                                <#if task.status == 0>
                                    <span class="tag tag-default">
                                        <@spring.message "project.task.TableCreate"/>
                                    </span>
                                <#elseif task.status == 1>
                                    <span class="tag tag-primary"><@spring.message "project.task.TableWait"/></span>
                                <#elseif task.status == 2>
                                    <span class="tag tag-info"><@spring.message "project.task.TableRunning"/></span>
                                <#elseif task.status == 3>
                                    <#assign failSum=null>
                                    <#if  taskResultList[task_index]??>
                                        <#assign failSum=0>
                                        <#if taskResultList[task_index].result.totalSummary.compatibility??>
                                            <#assign failSum+=taskResultList[task_index].result.totalSummary.compatibility.summary.fail>
                                        </#if>
                                        <#if taskResultList[task_index].result.totalSummary.case??>
                                            <#assign failSum+=taskResultList[task_index].result.totalSummary.case.summary.fail>
                                        </#if>
                                        <#if taskResultList[task_index].result.totalSummary.travel??>
                                            <#assign failSum+=taskResultList[task_index].result.totalSummary.travel.summary.fail>
                                        </#if>
                                    </#if>

                                    <#if (failSum??) && (failSum > 0)>
                                        <span class="tag tag-danger">
                                            <@spring.message "project.task.TableStatusFail"/>
                                    </span>
                                    <#elseif (failSum??) && (failSum == 0)>
                                        <span class="tag tag-success">
                                            <@spring.message "project.task.TableStatusSuccess"/>
                                    </span>
                                    </#if>
                                    <#--<span class="tag tag-success">
                                        <@spring.message "project.task.TableEnd"/>
                                    </span>-->
                                <#elseif task.status == 4>
                                    <span class="tag tag-warning">
                                        <@spring.message "project.task.TableCancel"/>
                                    </span>
                                </#if>
                            </td>
                       <#--     <td id="result${task.id}">
                                <#assign failSum=null>
                                <#list taskResultList as result>
                                    <#if task_index == result_index>
                                        <#if  result??>
                                            <#assign failSum=0>
                                            <#if result.result.totalSummary.compatibility??>
                                                <#assign failSum+=result.result.totalSummary.compatibility.summary.fail>
                                            </#if>
                                            <#if result.result.totalSummary.case??>
                                                <#assign failSum+=result.result.totalSummary.case.summary.fail>
                                            </#if>
                                            <#if result.result.totalSummary.travel??>
                                                <#assign failSum+=result.result.totalSummary.travel.summary.fail>
                                            </#if>
                                        </#if>
                                        <#if (task.status == 4) >
                                            &lt;#&ndash;<span class="tag tag-warning">
                                                <@spring.message "project.MobilesNoRun"/>
                                            </span>&ndash;&gt;
                                            <span class="tag tag-danger">
                                                <@spring.message "project.task.TableCancel"/>
                                            </span>
                                        <#elseif (task.status == 3) && (failSum > 0) && (failSum??)>
                                            <span class="tag tag-danger">
                                                <@spring.message "project.task.TableStatusFail"/>
                                            </span>
                                        <#elseif (task.status == 3) && (failSum == 0) && (failSum??)>
                                            <span class="tag tag-success">
                                                <@spring.message "project.task.TableStatusSuccess"/>
                                            </span>
                                        <#else >
                                            <div class="pro-bar-container color-nephriti">
                                                <div class="pro-bar bar-100 color-concrete" data-pro-bar-percent="20" data-pro-bar-delay="100">
                                                    <div class="pro-bar-candy candy-ltr"></div>
                                                </div>
                                            </div>
                                        </#if>
                                    </#if>
                                </#list>
                            </td>-->
                            <td id="operation${task.id}">
                                    <#if task.status == 3>
                                        <a href="${rc.contextPath}/project/${currentProject.id}/task/${task.id}"
                                           class="btn btn-default btn-icon btn-pure p-0 m-r-10"
                                           id="btn_reportView"
                                           title="<@spring.message "project.task.TableView"/>">
                                            <i class="icon wb-eye"></i>
                                        </a>
                                        <a href="${task.excel}" class="btn btn-default btn-icon btn-pure p-0 m-r-10 <#if !task.excel?? || task.excel == "">disabled</#if>" title="<@spring.message "project.task.reportDownload"/>" id="btn_reportDownload">
                                            <i class="icon wb-download"></i>
                                        </a>

                                        <a href="javascript:void(0)"
                                            class="btn btn-default btn-icon btn-pure p-0 m-r-10 share_report"
                                            id="btn_share_report"
                                            title="<@spring.message "project.task.share.report"/>"
                                            data-taskId="${task.id}"
                                            data-projectId="${currentProject.id}"
                                            data-taskName="${task.taskName}"
                                            data-projectName="${currentProject.projectName}"
                                            data-toggle="modal"
                                            data-target="#modal_share_report">

                                            <i class="icon wb-share"></i>
                                        </a>

                                    <#elseif task.status == 4>
                                    <#elseif task.status == 2 && taskParamList[task_index].scriptTest == "1" && taskParamList[task_index].scriptType == 3>
                                        <a href="javascript:void(0);"
                                           class="btn btn-danger btn-icon btn-pure p-0 m-r-10 stop_task"
                                           id="btn_stopTask"
                                           data-taskId="${task.id}"
                                           data-projectId="${currentProject.id}"
                                           title="<@spring.message "project.task.stopTask"/>">
                                            <i class="icon wb-stop"></i>
                                        </a>
                                        <a href="${rc.contextPath}/project/${currentProject.id}/task/${task.id}/realtimelog"
                                           class="btn btn-default btn-icon btn-pure p-0 m-r-10 realtime_log"
                                           id="btn_realtime_log"
                                           title="<@spring.message "project.task.view.details"/>">
                                        <i class="icon wb-eye"></i>

                                    <#else >
                                        <a href="javascript:void(0);"
                                           class="btn btn-danger btn-icon btn-pure p-0 m-r-10 stop_task"
                                           id="btn_stopTask"
                                           data-taskId="${task.id}"
                                           data-projectId="${currentProject.id}"
                                           title="<@spring.message "project.task.stopTask"/>">
                                            <i class="icon wb-stop"></i>
                                        </a>
                                    </#if>
                            </td>

                        </tr>
                        </#list>
                        </tbody>
                        <tfoot>
                        <#assign pageNum = ((page.rows - 1)/ page.limit)?int  + 1>
                        <tr>
                            <td colspan="3">
                            <@spring.message "project.task.TableTotal"/>&nbsp;${pageNum}&nbsp;<@spring.message "project.task.TablePage"/>， ${page.rows}&nbsp; <@spring.message "project.task.TableTasks"/>
                            </td>
                            <td colspan="5" class="p-b-0">
                                <nav class="pull-xs-right">
                                    <ul class="pagination pagination-sm m-0 pagination-no-border">

                                    <#if page.offset == 1>
                                        <li class="page-item disabled">
                                            <a class="page-link" href="javascript:void(0)" aria-label="First">
                                                <span aria-hidden="true"><@spring.message "project.task.topPage"/></span>
                                            </a>
                                        </li>
                                        <li class="page-item disabled">
                                            <a class="page-link" href="javascript:void(0)" aria-label="Previous">
                                                <span aria-hidden="true">
                                                    <@spring.message "project.task.TablePrevious"/>
                                                </span>
                                            </a>
                                        </li>
                                    <#else >
                                        <li class="page-item">
                                            <a class="page-link" href="${rc.contextPath}/project/${currentProject.id}/tasks?offset=1&limit=${page.limit}" aria-label="First">
                                                <span aria-hidden="true"><@spring.message "project.task.topPage"/></span>
                                            </a>
                                        </li>
                                        <li class="page-item">
                                            <a class="page-link" href="${rc.contextPath}/project/${currentProject.id}/tasks?offset=${page.offset - 1}&limit=${page.limit}" aria-label="Previous">
                                                <span aria-hidden="true">
                                                    <@spring.message "project.task.TablePrevious"/>
                                                </span>
                                            </a>
                                        </li>
                                    </#if>

                                    <#assign begNum = 1>
                                    <#assign endNum = pageNum>
                                    <#if page.offset - 2 gt 0>
                                        <#if pageNum - page.offset lt 2 &&  pageNum gte 5>
                                            <#assign begNum = pageNum - 4>
                                        <#else >
                                            <#assign begNum = page.offset - 2>
                                        </#if>

                                    </#if>
                                    <#if pageNum - page.offset gte 2>
                                        <#assign endNum = begNum + 4>
                                        <#if endNum gt pageNum>
                                            <#assign endNum = pageNum>
                                        </#if>
                                    </#if>
                                    <#list begNum..endNum as num>
                                        <#if num == page.offset>
                                            <li class="page-item active">
                                                <a class="page-link" href="javascript:void(0)">
                                                ${num}
                                                </a>
                                            </li>
                                        <#else >
                                            <li class="page-item">
                                                <a class="page-link" href="${rc.contextPath}/project/${currentProject.id}/tasks?offset=${num}&limit=${page.limit}">
                                                ${num}
                                                </a>
                                            </li>
                                        </#if>
                                    </#list>

                                    <#if page.offset == pageNum>
                                        <li class="page-item disabled">
                                            <a class="page-link " href="javascript:void(0)" aria-label="Next">
                                                <span aria-hidden="true">
                                                    <@spring.message "project.task.TableNext"/>
                                                </span>
                                            </a>
                                        </li>
                                        <li class="page-item disabled">
                                            <a class="page-link" href="javascript:void(0)" aria-label="Tail">
                                                <span aria-hidden="true"><@spring.message "project.task.endPage"/></span>
                                            </a>
                                        </li>
                                    <#else >
                                        <li class="page-item">
                                            <a class="page-link" href="${rc.contextPath}/project/${currentProject.id}/tasks?offset=${page.offset + 1}&limit=${page.limit}" aria-label="Next">
                                                <span aria-hidden="true">
                                                    <@spring.message "project.task.TableNext"/>
                                                </span>
                                            </a>
                                        </li>
                                        <li class="page-item">
                                            <a class="page-link" href="${rc.contextPath}/project/${currentProject.id}/tasks?offset=${pageNum}&limit=${page.limit}" aria-label="Tail">
                                                <span aria-hidden="true"><@spring.message "project.task.endPage"/></span>
                                            </a>
                                        </li>
                                    </#if>
                                    </ul>
                                </nav>

                            </td>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
        </div>
        <!-- End Panel FixedHeader -->
        <!-- datatables end-->

        <div class="modal modal-3d-sign" id="modal_share_report" aria-hidden="true"
             role="dialog" tabindex="-1">
            <div class="modal-dialog modal-center">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button"
                                class="close"
                                data-dismiss="modal"
                                aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                        <h4 class="modal-title"><i class="icon wb-share"></i>&nbsp;<@spring.message "project.task.share.report"/><span id="report_info"></span></h4>
                    </div>
                    <div class="modal-body col-md-12 col-xs-12 ">

                        <div class="col-md-7 col-xs-10" style="margin-top: 10px">
                            <input id="share_report_url"
                                   class="form-control"
                                   type="text"
                                   readonly="readonly"
                            />
                        </div>
                        <div class="col-md-5 col-xs-12" style="margin-top: 10px; padding: 0">
                            <div class="col-md-6 col-xs-3">
                                <a id="btn_copy_url" class="btn btn-default" data-clipboard-action="copy" data-clipboard-target="#share_report_url">
                                    <@spring.message "project.task.copy.url"/>
                                </a>
                                <div class="col-md-12 col-xs-12" id="copy_success" style=" display: none; text-align: center">
                                    <span class="tag tag-success"><@spring.message "project.task.copy.success"/></span>
                                </div>
                            </div>
                            <div class="col-md-6 col-xs-3">
                                <button class="btn btn-primary" id="share_email" data-taskName="" data-projectName="">
                                    <i class="icon wb-envelope"></i>&nbsp;<@spring.message "porject.task.share.email"/>
                                </button>
                            </div>

                        </div>
                    </div>
                    <div class="modal-footer">

                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<!-- End Page -->
<input type="hidden" id="baseUrl" baseUrl="${rc.contextPath}"/>
<input type="hidden" id="taskIdArray" taskIdArray="${idList}"/>
<input type="hidden" id="currentProjectId" currentProjectId="${currentProject.id}"/>
<input type="hidden" id="currentProjectName" currentProjectName="${currentProject.projectName}"/>
<!-- include footer ftl beg -->
<#include "/parts/footer_right.ftl">
<!-- include footer ftl end -->

<!-- include core js ftl beg -->
<#include "/parts/js_core.ftl">
<!-- include core js ftl end -->

<!-- Plugins -->
<script src="${rc.contextPath}/static/global/vendor/switchery/switchery.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/intro-js/intro.js"></script>
<script src="${rc.contextPath}/static/global/vendor/screenfull/screenfull.js"></script>
<script src="${rc.contextPath}/static/global/vendor/slidepanel/jquery-slidePanel.js"></script>
<script src="${rc.contextPath}/static/global/vendor/bootstrap-sweetalert/sweetalert.js"></script>
<script src="${rc.contextPath}/static/global/vendor/clipboard/clipboard.js"></script>

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
<script>
    Config.set('assets', '${rc.contextPath}/static/assets');
</script>
<!-- Page -->
<script src="${rc.contextPath}/static/assets/js/Site.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/asscrollable.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/slidepanel.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/switchery.js"></script>
<script src="${rc.contextPath}/static/js/project/project_task.js?v=${jsVersion}"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/bootstrap-sweetalert.js"></script>

<script src="${rc.contextPath}/static/js/common/jquery.i18n.properties.js"></script>
<script src="${rc.contextPath}/static/js/common/i18n_setting.js"></script>

<script>
    (function(document, window, $) {
        'use strict';
        var Site = window.Site;
        $(document).ready(function() {
            Site.run();
        });
    })(document, window, jQuery);

    /**
     * 复制内容至粘贴板事件
     */
    var clipboard = new Clipboard('#btn_copy_url');
    clipboard.on('success', function(e) {
        $('#copy_success').slideDown();
        console.log(e);
    });
    clipboard.on('error', function(e) {
        console.log(e);
    });
</script>
</body>
</html>