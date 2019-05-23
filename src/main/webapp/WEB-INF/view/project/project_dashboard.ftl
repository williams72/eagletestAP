<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    <title>
    <@spring.message "project.dashboard"/>
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
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/chartist/chartist.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/chartist-plugin-tooltip/chartist-plugin-tooltip.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/jquery-selective/jquery-selective.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/aspieprogress/asPieProgress.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/c3/c3.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/assets/examples/css/dashboard/team.css">

    <!-- Fonts -->
    <link rel="stylesheet" href="${rc.contextPath}/static/global/fonts/web-icons/web-icons.min.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/fonts/font-awesome/font-awesome.css">
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
                    <li class="site-menu-item active">
                        <a href="${rc.contextPath}/project/${currentProject.id}/dashboard" id="btn_side_dashbord">
                            <i class="site-menu-icon wb-dashboard" aria-hidden="true"></i>
                            <span class="site-menu-title"><@spring.message "project.dashboard"/></span>
                        </a>
                    </li>
                    <li class="site-menu-item">
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
            <li class="breadcrumb-item"><a href="${rc.contextPath}/mainpage"><@spring.message "common.eagle.test"/></a></li>
            <li class="breadcrumb-item"><a href="${rc.contextPath}/project/${currentProject.id}">${currentProject.projectName}</a></li>
            <li class="breadcrumb-item active">
            <@spring.message "project.dashboard"/>
            </li>
        </ol>
    </div>
    <div class="page-content">
        <!-- dashboard beg -->
        <div class="row" data-plugin="matchHeight" data-by-row="true">
            <!-- 2个图 beg-->
            <div class="col-xxl-3 col-lg-12 col-xs-12">
                <div class="row h-full" data-plugin="matchHeight">
                    <div class="col-xxl-12 col-lg-6 col-sm-6 col-xs-12">
                        <div class="card card-shadow card-completed-options">
                            <div class="card-block p-30">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <div class="counter text-xs-left blue-grey-700">
                                            <div class="counter-label m-t-10">
                                            <@spring.message "project.dashboard.versions"/>
                                            </div>
                                            <div class="counter-number font-size-40 m-t-10">
                                                ${notReleaseVersion}/${versionNum}
                                            </div>
                                        </div>
                                    </div>
                                    <#if versionNum == 0>
                                        <#assign rate = 0>
                                    <#else >
                                        <#assign rate = (notReleaseVersion/versionNum)* 100?int>
                                    </#if>
                                    <div class="col-xs-6">
                                        <div id="versionPiePro" class="pie-progress pie-progress-sm" data-plugin="pieProgress" data-valuemax="100"
                                             data-barcolor="#57c7d4" data-size="100" data-barsize="10"
                                             data-goal="${rate}" aria-valuenow="${rate}" role="progressbar">
                        <span class="pie-progress-number blue-grey-700 font-size-20">
                          ${rate}%
                        </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xxl-12 col-lg-6 col-sm-6 col-xs-12">
                        <div class="card card-shadow card-completed-options">
                            <div class="card-block p-30">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <div class="counter text-xs-left blue-grey-700">
                                            <div class="counter-label m-t-10">
                                            <@spring.message "project.dashboard.mobiles"/>
                                            </div>
                                            <div class="counter-number font-size-40 m-t-10">
                                                <span id="mobileInfoKongxian"></span>/<span id="mobileInfoTotal"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-6">
                                        <div id="mobileInfo" class="pie-progress pie-progress-sm" data-plugin="pieProgress" data-valuemax="100"
                                             data-barcolor="#62a8ea" data-size="100" data-barsize="10"
                                             role="progressbar">
                        <span class="pie-progress-number blue-grey-700 font-size-20">
                          0%
                        </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--
                    <div class="col-xxl-12 col-lg-4 col-sm-4 col-xs-12">
                        <div class="card card-shadow card-completed-options">
                            <div class="card-block p-30">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <div class="counter text-xs-left blue-grey-700">
                                            <div class="counter-label m-t-10">Cards Completed
                                            </div>
                                            <div class="counter-number font-size-40 m-t-10">
                                                1,358
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-6">
                                        <div class="pie-progress pie-progress-sm" data-plugin="pieProgress" data-valuemax="100"
                                             data-barcolor="#926dde" data-size="100" data-barsize="10"
                                             data-goal="56" aria-valuenow="56" role="progressbar">
                        <span class="pie-progress-number blue-grey-700 font-size-20">
                          56%
                        </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    -->
                </div>
            </div>
            <!-- 2个图 end-->
            <!-- 测试通过率 beg -->
            <div class="col-lg-12 col-xxl-9 col-xs-12">
                <div id="teamCompletedWidget" class="card card-shadow example-responsive">
                    <div class="card-block p-20 p-b-25">
                        <h4 class="card-title">
                        <@spring.message "project.dashboard.rate"/>
                        </h4>
                        <div id="version_tongji"></div>
                    </div>
                </div>
            </div>
            <!-- 测试通过率 end -->
        </div>
        <!-- dashboard end -->
    </div>
</div>
<!-- End Page -->
<input type="hidden" id="baseUrl" baseUrl="${rc.contextPath}"/>
<input type="hidden" id="currentProjectId" currentProjectId="${currentProject.id}"/>
<input type="hidden" id="currentProjectType" currentProjectType="${currentProject.projectType}"/>
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
<script src="${rc.contextPath}/static/global/vendor/chartist/chartist.js"></script>
<script src="${rc.contextPath}/static/global/vendor/chartist-plugin-tooltip/chartist-plugin-tooltip.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/aspieprogress/jquery-asPieProgress.js"></script>
<script src="${rc.contextPath}/static/global/vendor/matchheight/jquery.matchHeight-min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/jquery-selective/jquery-selective.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/d3/d3.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/c3/c3.min.js"></script>
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
<script src="${rc.contextPath}/static/global/js/Plugin/matchheight.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/aspieprogress.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/asscrollable.js"></script>
<script src="${rc.contextPath}/static/assets/examples/js/dashboard/team.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/panel.js"></script>
<script src="${rc.contextPath}/static/js/common/jquery.i18n.properties.js"></script>
<script src="${rc.contextPath}/static/js/common/i18n_setting.js"></script>

<script src="${rc.contextPath}/static/js/project/project_dashboard.js?v=${jsVersion}"></script>
<script>
    (function(document, window, $) {
        'use strict';
        var Site = window.Site;
        $(document).ready(function() {
            Site.run();
        });
    })(document, window, jQuery);
</script>
</body>
</html>