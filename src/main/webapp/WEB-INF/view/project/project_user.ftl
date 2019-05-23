<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    <title><@spring.message "project.member.title"/></title>
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
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/select2/select2.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/bootstrap-sweetalert/sweetalert.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/bootstrap-select/bootstrap-select.css">
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
                    <li class="site-menu-item active">
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
            <@spring.message "project.member.contextPathHome"/>
            </a></li>
            <li class="breadcrumb-item"><a href="${rc.contextPath}/project/${currentProject.id}">${currentProject.projectName}</a></li>
            <li class="breadcrumb-item active"><@spring.message "project.member.contextPathtitle"/></li>
        </ol>
    </div>
    <div class="page-content">

        <!-- datatables beg-->
        <!-- Panel FixedHeader -->
        <div class="panel" style="min-height: 450px;">
            <header class="panel-heading">
                <h3 class="panel-title"><i class="icon wb-users"></i> <@spring.message "project.member.rightTitle"/></h3>
            </header>
            <div class="panel-body">
                <form action="${rc.contextPath}/project/${currentProject.id}/user" method="post" autocomplete="off">
                    <div class="row">
                        <div class="form-group col-xs-12 col-md-7">
                            <label class="form-control-label" for="projectMember">
                            <@spring.message "project.member.selectmember"/>
                            </label>
                            <select name="userId" id="projectMember" class="form-control"
                                    required>
                                <option></option>
                                <#list users as user>
                                    <option value="${user.id},${user.avatars}">${user.username}/${user.email}</option>
                                </#list>
                            </select>
                        </div>
                        <div class="form-group col-xs-12 col-md-5">
                            <label class="form-control-label" for="projectMemberRole"><@spring.message "project.member.selectrole"/></label>
                            <select name="roleValue" id="projectMemberRole" class="form-control" data-plugin="select2"
                                    data-placeholder="<@spring.message "project.member.selectroletext"/>" required>
                                <option></option>
                                <option value="1"><@spring.message "project.member.roleMananger"/></option>
                                <!--<option value="3">观察者</option>-->
                                <option value="2">
                                <@spring.message "project.member.roleMember"/>
                                </option>

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <button id="btn_addUserSubmit" type="submit" class="btn btn-primary">
                        <@spring.message "project.member.addBtn"/>
                        </button>
                    </div>
                </form>
                <!--
                <h5>管理员&nbsp;<span class="tag tag-pill tag-success">1</span></h5>
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th style="width:40%"></th>
                            <th style="width:30%"></th>
                            <th style="width:30%"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                <img src="./global/portraits/3.jpg" class="avatar avatar-sm"/>
                                管理员1
                            </td>
                            <td>
                                <span class="tag tag-danger">管理员</span>
                            </td>
                            <td>
                                <button type="button" class="btn btn-danger btn-xs"><i class="icon wb-close"></i>移除</button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                -->
                <h5><@spring.message "project.member.memberlistTitle"/>&nbsp;<span class="tag tag-pill tag-success">${page.data?size}</span></h5>
                <div class="">
                    <table class="table">
                        <thead>
                        <tr>
                            <th style="width:40%"></th>
                            <th style="width:30%"></th>
                            <th style="width:30%"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list page.data as projectUser>
                        <tr>
                            <td>
                                <img src="${rc.contextPath}/static/img/avatar/${projectUser.etUser.avatars}" class="avatar avatar-sm"/>
                                ${projectUser.etUser.username}&nbsp;&nbsp;
                                <small>${projectUser.etUser.email}</small>
                            </td>
                            <td>
                                <select data-userid="${projectUser.etUser.id}" data-projectid="${currentProject.id}"
                                        data-plugin="selectpicker" class="show-tick projectUserChange">
                                    <#if projectUser.projectRole == 1>
                                        <option value="1" selected>
                                            <@spring.message "project.member.memberlistManangerRole"/>
                                        </option>
                                        <option value="2">
                                            <@spring.message "project.member.memberlistMemberRole"/>
                                        </option>
                                        <!--<option value="3">观察者</option>-->
                                    <#elseif projectUser.projectRole == 2>
                                        <option value="1"><@spring.message "project.member.memberlistManangerRole"/></option>
                                        <option value="2" selected><@spring.message "project.member.memberlistMemberRole"/></option>
                                        <!--<option value="3">观察者</option>-->
                                    </#if>
                                    <!--
                                        <option value="1">管理员</option>
                                        <option value="2">测试者</option>
                                        <option value="3" selected>观察者</option>
                                    -->
                                </select>
                            </td>
                            <td>
                                <!--
                                <button data-userid="${projectUser.etUser.id}" data-projectid="${currentProject.id}" type="button" class="btn btn-danger btn-xs"><i class="icon wb-close"></i>移除</button>
                                -->
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                        <tfoot>
                        <#assign pageNum = ((page.rows - 1)/ page.limit)?int  + 1>
                        <tr>
                            <td>
                            <@spring.message "project.member.memberlistTotal"/>&nbsp;${pageNum}&nbsp;<@spring.message "project.member.memberlistPage"/>， ${page.rows}&nbsp;<@spring.message "project.member.memberlistNumber"/>
                            </td>
                            <td colspan="2" class="p-b-0">
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
                                                <span aria-hidden="true"><@spring.message "project.member.memberlistPrevious"/></span>
                                            </a>
                                        </li>
                                    <#else >
                                        <li class="page-item">
                                            <a class="page-link" href="${rc.contextPath}/project/${currentProject.id}/users?offset=1&limit=${page.limit}" aria-label="First">
                                                <span aria-hidden="true"><@spring.message "project.task.topPage"/></span>
                                            </a>
                                        </li>
                                        <li class="page-item">
                                            <a class="page-link" href="${rc.contextPath}/project/${currentProject.id}/users?offset=${page.offset - 1}&limit=${page.limit}" aria-label="Previous">
                                                <span aria-hidden="true">
                                                    <@spring.message "project.member.memberlistPrevious"/>
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
                                                <a class="page-link" href="${rc.contextPath}/project/${currentProject.id}/users?offset=${num}&limit=${page.limit}">
                                                ${num}
                                                </a>
                                            </li>
                                        </#if>
                                    </#list>

                                    <#if page.offset == pageNum>
                                        <li class="page-item disabled">
                                            <a class="page-link " href="javascript:void(0)" aria-label="Next">
                                                <span aria-hidden="true">
                                                    <@spring.message "project.member.memberlistNext"/>
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
                                            <a class="page-link" href="${rc.contextPath}/project/${currentProject.id}/users?offset=${page.offset + 1}&limit=${page.limit}" aria-label="Next">
                                                <span aria-hidden="true">
                                                    <@spring.message "project.member.memberlistNext"/>
                                                </span>
                                            </a>
                                        </li>
                                        <li class="page-item">
                                            <a class="page-link" href="${rc.contextPath}/project/${currentProject.id}/users?offset=${pageNum}&limit=${page.limit}" aria-label="Tail">
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
    </div>
</div>
<!-- End Page -->
<input type="hidden" id="baseUrl" baseUrl="${rc.contextPath}"/>
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
<script src="${rc.contextPath}/static/global/vendor/bootstrap-select/bootstrap-select.js"></script>
<script src="${rc.contextPath}/static/global/vendor/select2/select2.full.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/bootstrap-sweetalert/sweetalert.js"></script>

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
<script src="${rc.contextPath}/static/global/js/Plugin/select2.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/bootstrap-select.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/bootstrap-sweetalert.js"></script>
<script src="${rc.contextPath}/static/js/common/jquery.i18n.properties.js"></script>
<script src="${rc.contextPath}/static/js/common/i18n_setting.js"></script>
<script src="${rc.contextPath}/static/js/project/project_user.js"></script>
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