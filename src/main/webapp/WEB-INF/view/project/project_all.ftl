<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    <title>
        <@spring.message "moreproject.title"/>
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
    <!-- Fonts -->
    <link rel="stylesheet" href="${rc.contextPath}/static/global/fonts/web-icons/web-icons.min.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/fonts/brand-icons/brand-icons.min.css">
    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Roboto:300,400,500,300italic'>
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

<nav class="site-navbar navbar navbar-default navbar-fixed-top navbar-mega" role="navigation">
    <div class="navbar-header">

        <button type="button" class="navbar-toggler collapsed" id="btn_nav_more" data-target="#site-navbar-collapse"
                data-toggle="collapse">
            <i class="icon wb-more-horizontal" aria-hidden="true"></i>
        </button>
        <div class="navbar-brand navbar-brand-center" >
            <img class="navbar-brand-logo" src="${rc.contextPath}/static/img/logo-img.png" title="EagleTest">
            <span class="navbar-brand-text hidden-xs-down"> <@spring.message "common.eagle.test"/></span>
        </div>

    </div>
    <div class="navbar-container container-fluid">
        <!-- Navbar Collapse -->
        <div class="collapse navbar-collapse navbar-collapse-toolbar" id="site-navbar-collapse">
            <!-- Navbar Toolbar -->
            <ul class="nav navbar-toolbar">

                <!-- 导航栏下拉  beg-->
                <!-- nav dropmenu project beg -->
            <#include "/parts/nav_project_dropdown.ftl">
                <!-- nav dropmenu project end -->
                <!-- nav dropmenu realmobile beg -->
            <#include "/parts/nav_realmobile_dropdown.ftl">
                <!-- nav dropmenu realmobile end -->

                <!-- include header nav sys item beg -->
            <#include "/parts/nav_system_dropdown.ftl">
                <!-- include header nav sys item end -->

            <#if currentProject.id != null>
                <li class="nav-item">
                    <a class="btn btn-primary btn-ms" id="btn_nav_createTask" style="margin-top: 0.466rem; margin-bottom: 0 auto"  href="${rc.contextPath}/project/${currentProject.id}/createtask"><@spring.message "project.nav.create.task"/></a>
                </li>
            </#if>


                <!-- 导航栏下拉  end-->

            </ul>
            <!-- End Navbar Toolbar -->
            <!-- Navbar Toolbar Right -->
            <ul class="nav navbar-toolbar navbar-right navbar-toolbar-right">
                <!-- 帮助 beg -->
            <#include "/parts/nav_help_dropdown.ftl">
                <!-- 帮助 end -->

                <!-- 个人中心 beg -->
            <#include "/parts/nav_user_section.ftl">
                <!-- 个人中心 end -->
                <#--<li class="nav-item hidden-sm-down" id="toggleFullscreen">
                    <a class="nav-link icon icon-fullscreen" id="btn_nav_fullScreen" data-toggle="fullscreen" href="#" role="button" title="全屏">
                        <span class="sr-only">Toggle fullscreen</span>
                    </a>
                </li>-->
                <li class="nav-item dropdown">
                    &nbsp;&nbsp;
                </li>

            </ul>
            <!-- End Navbar Toolbar Right -->
        </div>
        <!-- End Navbar Collapse -->

    </div>
</nav>


<!-- Page -->
<div class="page" style="margin-left:0px;">
    <div class="page-header p-t-10 p-b-10">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${rc.contextPath}/mainpage">
            <@spring.message "moreproject.breadcrumb.Home"/>
            </a></li>
            <li class="breadcrumb-item active">
            <@spring.message "moreproject.breadcrumb.active"/>
            </li>
        </ol>
    </div>
    <div class="page-content container-fluid">
        <div class="panel m-b-0" style="min-height: 500px;">
            <div class="panel-heading">
                <h3 class="panel-title"><@spring.message "moreproject.panel.title"/>
                </h3>
                <div class="panel-actions">
                    <div class="input-search input-group-sm">
                        <button type="submit" class="input-search-btn">
                            <i class="icon wb-search" aria-hidden="true"></i>
                        </button>
                        <input type="text" class="form-control" name="" placeholder="<@spring.message "moreproject.panel.search.htext"/>">
                    </div>
                </div>
            </div>
            <div class="panel-body">
                <#if projects?size == 0>
                <!-- 用户没有项目提示用户 beg -->
                <div class="h-300 text-lg-center">
                    <span class="block m-t-30 font-size-24 "><i class="icon wb-warning"></i>
                        <@spring.message "moreproject.noproject.help"/>
                    </span>
                </div>
                <!-- 用户没有项目提示用户 end -->
                <#else >
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                            <tr>
                                <th><@spring.message "moreproject.list.head.project"/></th>
                                <th><@spring.message "moreproject.list.head.key"/></th>
                                <th><@spring.message "moreproject.list.head.type"/></th>
                                <th><@spring.message "moreproject.list.head.admin"/></th>
                                <th><@spring.message "moreproject.list.head.time"/></th>
                            </tr>
                            </thead>
                            <tbody>
                                <#list projects as project>
                                <tr>
                                    <#--<td>
                                        <img class="avatar avatar-xs" src="${rc.contextPath}/static/img/avatar/u112506.png" data-toggle="tooltip"
                                             data-original-title="${project.projectName}" data-container="body"
                                             title="">
                                    </td>-->
                                    <td><a href="${rc.contextPath}/project/${project.id}">${project.projectName}</a></td>
                                    <td>
                                        <span class="tag tag-primary">${project.projectKey}</span>
                                    </td>
                                    <td>
                                        <#if project.projectType == 0>
                                            <span class="tag tag-default"><@spring.message "system.project.create.FormTypeAnd"/></span>
                                        <#elseif project.projectType == 1>
                                            <span class="tag tag-default"><@spring.message "system.project.create.FormTypeIos"/></span>
                                        </#if>
                                    </td>
                                    <td>
                                    ${project.etProjectUsers[0].etUser.email}
                                    </td>
                                    <td>
                                        <span class="text-muted"><i class="wb wb-time"></i> ${project.createTime}</span>
                                    </td>
                                </tr>
                                </#list>
                            </tbody>
                        </table>
                    </div>
                </#if>
            </div>
        </div>
    </div>
</div>
<!-- End Page -->
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
<!-- Plugins -->
<script src="${rc.contextPath}/static/global/vendor/switchery/switchery.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/intro-js/intro.js"></script>
<script src="${rc.contextPath}/static/global/vendor/screenfull/screenfull.js"></script>
<script src="${rc.contextPath}/static/global/vendor/slidepanel/jquery-slidePanel.js"></script>
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
<script src="${rc.contextPath}/static/global/js/Plugin/datatables.js"></script>
<script src="${rc.contextPath}/static/js/datatable.js"></script>
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