<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    <title><@spring.message "project.task.mobile.realtimelog.title"/></title>
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

    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/blueimp-file-upload/jquery.fileupload.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/dropify/dropify.css">

    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/select2/select2.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/bootstrap-select/bootstrap-select.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/c3/c3.css">

    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/aspieprogress/asPieProgress.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/assets/examples/css/charts/pie-progress.css">

    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/icheck/icheck.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/plyr/plyr.css">


    <link rel="stylesheet" href="${rc.contextPath}/static/assets/examples/css/advanced/scrollable.css">
    <!-- Fonts -->
    <link rel="stylesheet" href="${rc.contextPath}/static/global/fonts/web-icons/web-icons.min.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/fonts/brand-icons/brand-icons.min.css">
    <!-- datatables beg -->
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/datatables-bootstrap/dataTables.bootstrap.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/datatables-fixedheader/dataTables.fixedHeader.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/datatables-responsive/dataTables.responsive.css">
    <!-- datatables end -->
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

                </ul>
            </div>
        </div>
    </div>

</div>
<!-- project_side end -->
<!-- Page -->
<div class="page">
    <div class="page-header p-t-10 p-b-10">
        <!--<h1 class="page-title">Page Title</h1>-->
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${rc.contextPath}/mainpage">
            <@spring.message "project.DetailContextPathHome"/>
            </a></li>
            <li class="breadcrumb-item"><a href="${rc.contextPath}/project/${currentProject.id}">${currentProject.projectName}</a></li>
            <li class="breadcrumb-item">${currentTask.taskName}</li>
            <li class="breadcrumb-item active">
                <@spring.message "project.task.mobile.realtimelog.title"/>
            </li>
        </ol>
    </div>
    <div class="page-content p-b-10">
        <div class="panel m-b-10">
            <div class="panel-heading">
                <h3 class="panel-title"><i class="icon wb-mobile" aria-hidden="true"></i>
                    <@spring.message "project.task.mobile.realtimelog.title"/>
                </h3>
                <div class="panel-actions panel-actions-keep">
                    <a class="panel-action icon wb-expand" data-toggle="panel-fullscreen" aria-hidden="true"></a>
                </div>
            </div>
            <div class="panel-body">
                <!-- 顶部切换手机 beg -->
                <div class="row">
                    <div class="col-md-6">
                        <h5 class="inline-block">
                        <@spring.message "project.DetailMobile"/>
                        </h5>${currentMobile.name}&nbsp;&nbsp;(${currentMobile.sn})
                    </div>
                    <div class="col-md-6">
                        <div class="form-group row m-0">
                            <label class="m-b-0 col-xs-12 col-md-4 form-control-label text-lg-right">
                            <@spring.message "project.DetailSelect"/>
                            </label>
                            <div class="col-md-8 col-xs-12">
                            <select id="mobile_select" class="form-control" data-plugin="select2">
                                <#list mobileList as mobile>
                                    <#if currentMobile.sn == mobile.sn>
                                        <option value="${mobile.sn}" selected>${mobile.name}</option>
                                    <#else >
                                        <option value="${mobile.sn}">${mobile.name}</option>
                                    </#if>
                                </#list>
                            </select>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 顶部切换手机 end -->

                <div class="nav-tabs-horizontal nav-tabs-animate" data-plugin="tabs">
                    <ul class="nav nav-tabs nav-tabs-line" role="tablist">
                        <li class="nav-item" role="presentation"><a class="nav-link active" data-toggle="tab" href="#m_debuglog"
                                                                    aria-controls="exampleTabsLineFour" role="tab"><@spring.message "project.task.mobile.realtimelog.debuglog"/></a></li>

                        <li class="nav-item" role="presentation"><a class="nav-link" data-toggle="tab" href="#m_scriptlog"
                                                                    aria-controls="exampleTabsLineTwo" role="tab"><@spring.message "project.task.mobile.realtimelog.scriptlog"/></a></li>
                    </ul>
                    <div class="tab-content p-t-20">
                        <div class="tab-pane animation-scale-up  active" id="m_debuglog" role="tabpanel">
                            <div class="example m-0" style="background-color: #526069">
                                <div class="col-md-12 col-lg-12">
                                    <div class="h-450" style="overflow: auto;">
                                        <div id="debuglog_container" data-role="container" style="min-width: 500px;">
                                            <div data-role="content" style="min-width: 500px; color: #FFFFFF;">
                                                <p>**************** Debug log **************** <br/></p>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="tab-pane animation-scale-up" id="m_scriptlog" role="tabpanel">
                            <div class="example m-0" style="background-color: #526069">
                                <div class="col-md-12 col-lg-12">
                                    <div class="h-450" style="overflow: auto;">
                                        <div id="scriptlog_container" data-role="container" style="min-width: 500px;">
                                            <div data-role="content" style="min-width: 500px; color: #FFFFFF;">
                                                <p>**************** Script log **************** <br/></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </div>
                </div>

            </div>
        </div>

    </div>
</div>
<!-- End Page -->
<input type="hidden" id="baseUrl" baseUrl="${rc.contextPath}"/>
<input type="hidden" id="currentProjectId" currentProjectId="${currentProject.id}"/>
<input type="hidden" id="currentTaskId" currentTaskId="${currentTask.id}"/>
<input type="hidden" id="taskId" taskId="${currentTask.id}"/>
<input type="hidden" id="currentMobileSerialNum" currentMobileSerialNum="${currentMobile.sn}"/>


<!-- include footer ftl beg -->
<#include "/parts/footer_right.ftl">
<!-- include footer ftl end -->

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
<!-- Plugins -->
<script src="${rc.contextPath}/static/global/vendor/switchery/switchery.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/intro-js/intro.js"></script>
<script src="${rc.contextPath}/static/global/vendor/screenfull/screenfull.js"></script>
<script src="${rc.contextPath}/static/global/vendor/slidepanel/jquery-slidePanel.js"></script>
<script src="${rc.contextPath}/static/global/vendor/d3/d3.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/c3/c3.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/aspieprogress/jquery-asPieProgress.js"></script>

<script src="${rc.contextPath}/static/global/vendor/matchheight/jquery.matchHeight-min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/icheck/icheck.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/select2/select2.full.min.js"></script>

<script src="${rc.contextPath}/static/global/vendor/plyr/plyr.js"></script>
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
<script src="${rc.contextPath}/static/global/js/Plugin/jquery-lazyload.js"></script>
<script>
    Config.set('assets', '${rc.contextPath}/static/assets');
</script>
<!-- Page -->
<script src="${rc.contextPath}/static/assets/js/Site.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/asscrollable.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/slidepanel.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/switchery.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/panel.js"></script>

<script src="${rc.contextPath}/static/global/js/Plugin/tabs.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/aspieprogress.js"></script>

<script src="${rc.contextPath}/static/global/js/Plugin/icheck.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/select2.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/plyr.js"></script>

<script src="${rc.contextPath}/static/assets/examples/js/advanced/scrollable.js"></script>

<script src="${rc.contextPath}/static/js/task/task_mobile_realtimelog.js"></script>
</body>
</html>