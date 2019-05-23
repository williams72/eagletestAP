<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    <title><@spring.message "system.project.title"/></title>
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

    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/jquery-strength/jquery-strength.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/icheck/icheck.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/bootstrap-maxlength/bootstrap-maxlength.css">

    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/bootstrap-sweetalert/sweetalert.css">
    <!-- datatables end -->
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
<!-- ie8_incompatible.ftl include beg -->
<#include "/other/ie8_incompatible.ftl">
<!-- ie8_incompatible.ftl include end -->
<!-- sys_nav.ftl include beg -->
<#include "/system/sys_nav.ftl">
<!-- sys_nav.ftl include end -->
<!-- sys_project_side beg -->
<div class="site-menubar">
    <div class="site-menubar-body">
        <div>
            <div>
                <ul class="site-menu" data-plugin="menu">
                    <li class="site-menu-category">

                    </li>
                    <li class="site-menu-item">
                        <a href="${rc.contextPath}/mobiles" id="btn_side_mobile">
                            <i class="site-menu-icon wb-mobile" aria-hidden="true"></i>
                            <span class="site-menu-title"><@spring.message "system.leftMenu.mobile"/></span>
                        </a>
                    </li>
                    <li class="site-menu-item active">
                        <a href="${rc.contextPath}/projects">
                            <i class="site-menu-icon wb-list" aria-hidden="true" id="btn_side_project"></i>
                            <span class="site-menu-title"><@spring.message "system.leftMenu.project"/></span>
                        </a>
                    </li>
                    <li class="site-menu-item">
                        <a href="${rc.contextPath}/users">
                            <i class="site-menu-icon wb-users" aria-hidden="true" id="btn_side_user"></i>
                            <span class="site-menu-title"><@spring.message "system.leftMenu.user"/></span>
                        </a>
                    </li>

                    <li class="site-menu-item">
                        <a href="${rc.contextPath}/libraries">
                            <i class="site-menu-icon wb-library" aria-hidden="true" id="btn_side_user"></i>
                            <span class="site-menu-title"><@spring.message "system.leftMenu.library"/></span>
                        </a>
                    </li>

                    <li class="site-menu-item">
                        <a href="${rc.contextPath}/logs" id="btn_side_log">
                            <i class="site-menu-icon wb-order" aria-hidden="true"></i>
                            <span class="site-menu-title"><@spring.message "system.leftMenu.log"/></span>
                        </a>
                    </li>
                    <li class="site-menu-item has-sub">
                        <a href="javascript:void(0)" id="btn_side_setting">
                            <i class="site-menu-icon wb-settings" aria-hidden="true"></i>
                            <span class="site-menu-title"><@spring.message "system.leftMenu.setting"/></span>
                            <span class="site-menu-arrow"></span>
                        </a>
                        <ul class="site-menu-sub">
                            <li class="site-menu-item">
                                <a class="animsition-link" href="${rc.contextPath}/setting" id="btn_side_setting_language">
                                    <span class="site-menu-title"><@spring.message "system.leftMenu.setting.language"/></span>
                                </a>
                            </li>
                            <li class="site-menu-item">
                                <a class="animsition-link" href="${rc.contextPath}/weaknets" id="btn_side_setting_weaknet">
                                    <span class="site-menu-title"><@spring.message "system.leftMenu.setting.Network"/></span>
                                </a>
                            </li>
                        </ul>
                    </li>
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
<!-- sys_project_side end -->
<!-- Page -->
<div class="page">
    <div class="page-header p-t-10 p-b-10">
        <!--<h1 class="page-title">Page Title</h1>-->
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a
                    href="${rc.contextPath}"><@spring.message "system.project.contextPathHome"/></a></li>
            <li class="breadcrumb-item active"><@spring.message "system.project.contextPathTitle"/></li>
        </ol>
    </div>
    <div class="page-content">
        <div class="panel m-b-0" style="min-height: 450px;">
            <div class="panel-heading">
                <h3 class="panel-title"><i class="icon wb-list"></i><@spring.message "system.project.RightTabletitle"/></h3>
                <div class="panel-actions">

                </div>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-2 col-lg-2">
                        <a class="btn btn-primary" id="btn_createProject" href="${rc.contextPath}/projectcreate">
                            <i class="icon wb-plus"></i>&nbsp;<@spring.message "system.project.RightTableBtn"/>
                        </a>
                    </div>
                </div>
                <!-- 项目列表 beg -->
                <div class="example table-responsive">
                    <table class="table m-b-0">
                        <thead>
                        <tr>
                            <#--<th class="p-0"><@spring.message "system.project.TableIcon"/></th>-->
                            <th class="p-0"><@spring.message "system.project.TableProjectName"/></th>
                            <th class="p-0"><@spring.message "system.project.TableKey"/></th>
                            <th class="p-0"><@spring.message "system.project.TableType"/></th>
                            <th class="p-0"><@spring.message "moreproject.list.head.time"/></th>
                            <th class="p-0"><@spring.message "system.project.TableMember"/></th>
                            <th class="p-0"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list page.data as project>
                        <tr>
                            <#--<td>
                                <img class="avatar avatar-xs" src="${rc.contextPath}/static/img/avatar/u112506.png"
                                     data-container="body"
                                     title="">
                            </td>-->
                            <td>${project.projectName}</td>
                            <td>
                                <span class="tag tag-danger">${project.projectKey}</span>
                            </td>
                            <td>
                                <#if project.projectType == 0>
                                    <span class="tag tag-default"><@spring.message "system.project.create.FormTypeAnd"/></span>
                                <#elseif project.projectType == 1>
                                    <span class="tag tag-default"><@spring.message "system.project.create.FormTypeIos"/></span>
                                </#if>
                            </td>
                            <td>
                                <span class="text-muted"><i class="wb wb-time"></i> ${project.createTime}</span>
                            </td>
                            <td>
                                <#list project.etProjectUsers as pu>
                                    <#if pu.projectRole == 1>
                                        <img class="avatar avatar-xs"
                                             src="${rc.contextPath}/static/img/avatar/${pu.etUser.avatars}"
                                             title="${pu.etUser.email}"/>
                                    </#if>
                                </#list>
                                <#if project.etProjectUsers?size gt 1>
                                    &gt;
                                </#if>
                                <#list project.etProjectUsers as pu>
                                    <#if pu.projectRole == 2>
                                        <img class="avatar avatar-xs"
                                             src="${rc.contextPath}/static/img/avatar/${pu.etUser.avatars}"
                                             title="${pu.etUser.email}"/>
                                    </#if>
                                </#list>
                            </td>
                            <td>
                                <div class="pull-xs-right">
                                    <!--
                                    <button data-projectId="${project.id}" class="btn btn-xs btn-success" type="button">编辑</button>
                                    <button data-projectId="${project.id}" class="btn btn-xs btn-danger" type="button">删除</button>
                                    -->
                                </div>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                        <tfoot>
                        <#assign pageNum = ((page.rows - 1)/ page.limit)?int  + 1>
                        <tr>
                            <td colspan="3">
                            <@spring.message "system.project.TableTotal"/>
                                &nbsp;${pageNum}&nbsp;<@spring.message "system.project.TablePage"/>， ${page.rows}&nbsp;<@spring.message "system.project.TableProject"/>
                            </td>
                            <td colspan="4" class="p-b-0">
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
                                                <span aria-hidden="true"><@spring.message "system.project.TablePrevious"/></span>
                                            </a>
                                        </li>
                                    <#else >
                                        <li class="page-item">
                                            <a class="page-link" href="${rc.contextPath}/projects?offset=1&limit=${page.limit}" aria-label="First">
                                                <span aria-hidden="true"><@spring.message "project.task.topPage"/></span>
                                            </a>
                                        </li>
                                        <li class="page-item">
                                            <a class="page-link"
                                               href="${rc.contextPath}/projects?offset=${page.offset - 1}&limit=${page.limit}"
                                               aria-label="Previous">
                                                <span aria-hidden="true"><@spring.message "system.project.TablePrevious"/></span>
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
                                                <a class="page-link" href="${rc.contextPath}/projects?offset=${num}&limit=${page.limit}">
                                                ${num}
                                                </a>
                                            </li>
                                        </#if>
                                    </#list>

                                    <#if page.offset == pageNum>
                                        <li class="page-item disabled">
                                            <a class="page-link " href="javascript:void(0)" aria-label="Next">
                                                <span aria-hidden="true"><@spring.message "system.project.TableNext"/></span>
                                            </a>
                                        </li>
                                        <li class="page-item disabled">
                                            <a class="page-link" href="javascript:void(0)" aria-label="Tail">
                                                <span aria-hidden="true"><@spring.message "project.task.endPage"/></span>
                                            </a>
                                        </li>
                                    <#else >
                                        <li class="page-item">
                                            <a class="page-link"
                                               href="${rc.contextPath}/projects?offset=${page.offset + 1}&limit=${page.limit}"
                                               aria-label="Next">
                                                <span aria-hidden="true"><@spring.message "system.project.TableNext"/></span>
                                            </a>
                                        </li>
                                        <li class="page-item">
                                            <a class="page-link" href="${rc.contextPath}/projects?offset=${pageNum}&limit=${page.limit}" aria-label="Tail">
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
                <!-- 项目列表 end -->
                <!-- 新建项目 modal beg -->
                <div class="modal fade modal-3d-sign" id="project_add_modal" aria-hidden="true"
                     aria-labelledby="exampleModalTitle" role="dialog" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">×</span>
                                </button>
                                <h4 class="modal-title">新建项目</h4>
                            </div>
                            <div class="modal-body">
                                <form class="form-horizontal">
                                    <div class="form-group row m-b-10">
                                        <label class="col-xs-12 col-md-3 form-control-label">用户名：</label>
                                        <div class="col-md-7 col-xs-12">
                                            <input type="text" id="user_add_username"
                                                   class="form-control maxlength-input"
                                                   data-placement="bottom-right-inside" name="name" placeholder="请输入用户名"
                                                   autocomplete="off"
                                            />
                                        </div>
                                    </div>
                                    <div id="" class="row animate animation-slide-top m-y-5" style="display: none;">
                                        <div class="offset-md-3 col-md-9 col-lg-9">
                                            <span class="red-700"><i class="icon wb-warning"></i> 该用户名已经被使用</span>
                                        </div>
                                    </div>
                                    <div class="form-group row m-b-10">
                                        <label class="col-xs-12 col-md-3 form-control-label">邮箱：</label>
                                        <div class="col-md-7 col-xs-12">
                                            <input type="text" id="user_add_email" class="form-control maxlength-input"
                                                   data-plugin="maxlength"
                                                   data-placement="bottom-right-inside" maxlength="10" name="name"
                                                   placeholder="请输入邮箱" autocomplete="off"
                                            />
                                        </div>
                                    </div>
                                    <div id="" class="row animate animation-slide-top m-y-5" style="display: none;">
                                        <div class="offset-md-3 col-md-9 col-lg-9">
                                            <span class="red-700"><i class="icon wb-warning"></i> 该邮箱已经被使用</span>
                                        </div>
                                    </div>
                                    <div class="form-group row m-b-10">
                                        <label class="col-xs-12 col-md-3 form-control-label">密码：</label>
                                        <div class="col-md-7 col-xs-12">
                                            <input type="password" id="user_add_password"
                                                   class="maxlength-input form-control"
                                                   data-plugin="strength" name="name" placeholder="请输入密码"
                                                   autocomplete="off"
                                            />
                                        </div>
                                    </div>
                                    <div id="" class="row animate animation-slide-top m-y-5" style="display: none;">
                                        <div class="offset-md-3 col-md-9 col-lg-9">
                                            <span class="red-700"><i class="icon wb-warning"></i> 密码强度太低</span>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button id="user_add_submit" type="button" class="btn btn-primary">添加用户</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 新建项目 modal end -->

            </div>
        </div>

    </div>
</div>
<!-- End Page -->
<input type="hidden" id="baseUrl" baseUrl="${rc.contextPath}"/>
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
<script src="${rc.contextPath}/static/global/vendor/bootstrap-maxlength/bootstrap-maxlength.js"></script>

<script src="${rc.contextPath}/static/global/vendor/icheck/icheck.min.js"></script>


<script src="${rc.contextPath}/static/global/vendor/jquery-strength/password_strength.js"></script>
<script src="${rc.contextPath}/static/global/vendor/jquery-strength/jquery-strength.min.js"></script>
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

<!-- datatables end-->
<script>
    Config.set('assets', '${rc.contextPath}/static/assets');
</script>
<!-- Page -->
<script src="${rc.contextPath}/static/assets/js/Site.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/asscrollable.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/slidepanel.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/switchery.js"></script>

<script src="${rc.contextPath}/static/global/js/Plugin/panel.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/icheck.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/bootstrap-maxlength.js"></script>

<script src="${rc.contextPath}/static/global/js/Plugin/jquery-strength.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/bootstrap-sweetalert.js"></script>
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