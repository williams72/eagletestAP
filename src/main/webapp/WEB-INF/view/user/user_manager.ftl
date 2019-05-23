<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    <title>
    <@spring.message "system.user.title"/>
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

    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/jquery-strength/jquery-strength.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/icheck/icheck.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/bootstrap-maxlength/bootstrap-maxlength.css">

    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/bootstrap-sweetalert/sweetalert.css">

    <link rel="stylesheet" href="${rc.contextPath}/static/assets/css/forms/validation.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/formvalidation/formValidation.css">


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

<!-- sysNavHeader.ftl include beg -->
<#include "/system/sys_nav.ftl">
<!-- sysNavHeader.ftl include end -->

<!-- sys_user_side beg -->
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
                    <li class="site-menu-item">
                        <a href="${rc.contextPath}/projects">
                            <i class="site-menu-icon wb-list" aria-hidden="true" id="btn_side_project"></i>
                            <span class="site-menu-title"><@spring.message "system.leftMenu.project"/></span>
                        </a>
                    </li>
                    <li class="site-menu-item active">
                        <a href="${rc.contextPath}/users">
                            <i class="site-menu-icon wb-users" aria-hidden="true" id="btn_side_user"></i>
                            <span class="site-menu-title"><@spring.message "system.leftMenu.user"/></span>
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
</div>
<!-- sys_user_side end -->

<!-- Page -->
<div class="page">
    <div class="page-header p-t-10 p-b-10">
        <!--<h1 class="page-title">Page Title</h1>-->
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${rc.contextPath}/mainpage">
            <@spring.message "system.user.ContextPathHome"/>
            </a></li>
            <li class="breadcrumb-item active">
            <@spring.message "system.user.ContextTitle"/>
            </li>
        </ol>
    </div>
    <div class="page-content">
        <div class="panel">
            <div class="panel-heading">
                <h3 class="panel-title">
                    <i class="icon wb-users"></i><@spring.message "system.user.TableTitle"/>
                </h3>
                <div class="panel-actions">

                </div>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-2 col-lg-2">
                        <button id="btn_add_user" class="btn btn-primary btn-sm" type="button"
                                data-toggle="modal" data-target="#user_add_modal">
                            <i class="icon wb-user-add"></i>
                        <@spring.message "system.user.TableBtn"/>
                        </button>
                    </div>
                </div>
                <!-- 用户列表 beg -->
                <div class="example table-responsive">
                    <table class="table m-b-0">
                        <thead>
                        <tr>
                            <th></th>
                            <th><@spring.message "system.user.TableUsername"/></th>
                            <th><@spring.message "system.user.TableEmail"/></th>
                            <th><@spring.message "system.user.TableRole"/></th>
                            <!--<th>用户状态</th>-->
                        <#--<th><@spring.message "system.user.TableOperate"/></th>-->
                            <th><@spring.message "system.user.TableOperate"/></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list page.data as user>
                        <tr>
                            <td>
                                <img class="avatar avatar-xs" src="${rc.contextPath}/static/img/avatar/${user.avatars}"
                                     data-container="body"
                                     title="">
                            </td>
                            <td><a href="${rc.contextPath}/system/user/${user.id}">${user.username}</a></td>
                            <td>${user.email}</td>
                            <td>
                                <span class="tag tag-default">
                                    <#if user.etRoles[0].roleValue == 1>
                                        <@spring.message "system.user.TableRoleAdmin"/>
                                    <#else >
                                        <@spring.message "system.user.TableRoleStaff"/>
                                    </#if>
                                </span>
                            </td>
                            <!--
                            <td>-->
                            <#if user.status == 1>
                                <!-- 用户为激活状态-->
                                <!--  <i class="icon wb-unlock"></i> 激活-->
                            <#else >
                                <!-- 用户为未激活状态 -->
                                <!-- <i style="color:#FF5200;" class="icon wb-lock"></i> 未激活-->
                            </#if>
                            <!-- </td>-->

                        <#--<td>
                            <!--
                            <a href="#" data-userid="${user.id}" class="btn btn-sm btn-icon btn-pure btn-default p-0 m-r-10" title="编辑用户"><i class="icon wb-edit" aria-hidden="true"></i></a>
                            &ndash;&gt;
                            <#if user.id == userDetail.id>

                            <#else >
                                <a href="#" id="btn_deleteUser" data-userid="${user.id}"
                                   class="btn btn-sm btn-icon btn-pure btn-default p-0"
                                   title="<@spring.message "system.user.TableDeleteText"/>"><i class="icon wb-trash"
                                                                                               aria-hidden="true"></i></a>
                            </#if>
                        </td>-->
                            <td id="user_status_${user.id}">
                                <#if user.id == userDetail.id>

                                <#else >
                                    <#if user.status == 1>
                                        <!-- 用户为激活状态时 显示禁用按钮-->
                                        <button data-userid="${user.id}" class="btn btn-xs btn-danger user_disable_btn"
                                                id="btn_disableUser" type="button">
                                            <@spring.message "system.user.TableStatusoff"/>
                                        </button>
                                    <#else >
                                        <!-- 用户为未激活状态时 显示生效按钮 -->
                                        <button data-userid="${user.id}" class="btn btn-xs btn-success user_enable_btn"
                                                id="btn_enableUser" type="button">
                                            <@spring.message "system.user.TableStatuson"/>
                                        </button>
                                    </#if>
                                </#if>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                        <tfoot>
                        <#assign pageNum = ((page.rows - 1)/ page.limit)?int  + 1>
                        <tr>
                            <td colspan="3">
                            <@spring.message "system.user.TableTotal"/>
                                &nbsp;${pageNum}&nbsp;<@spring.message "system.user.TablePage"/>， ${page.rows}&nbsp;<@spring.message "system.user.TableUsers"/>
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
                                                    <span aria-hidden="true">
                                                        <@spring.message "system.user.TablePrevious"/>
                                                    </span>
                                            </a>
                                        </li>
                                    <#else >
                                        <li class="page-item">
                                            <a class="page-link" href="${rc.contextPath}/users?offset=1&limit=${page.limit}" aria-label="First">
                                                <span aria-hidden="true"><@spring.message "project.task.topPage"/></span>
                                            </a>
                                        </li>
                                        <li class="page-item">
                                            <a class="page-link"
                                               href="${rc.contextPath}/users?offset=${page.offset - 1}&limit=${page.limit}"
                                               aria-label="Previous">
                                                    <span aria-hidden="true">
                                                        <@spring.message "system.user.TablePrevious"/>
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
                                                <a class="page-link" href="${rc.contextPath}/users?offset=${num}&limit=${page.limit}">
                                                ${num}
                                                </a>
                                            </li>
                                        </#if>
                                    </#list>

                                    <#if page.offset == pageNum>
                                        <li class="page-item disabled">
                                            <a class="page-link " href="javascript:void(0)" aria-label="Next">
                                                    <span aria-hidden="true">
                                                        <@spring.message "system.user.TableNext"/>
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
                                            <a class="page-link"
                                               href="${rc.contextPath}/users?offset=${page.offset + 1}&limit=${page.limit}"
                                               aria-label="Next">
                                                    <span aria-hidden="true">
                                                        <@spring.message "system.user.TableNext"/>
                                                    </span>
                                            </a>
                                        </li>
                                        <li class="page-item">
                                            <a class="page-link"
                                               href="${rc.contextPath}/users?offset=${pageNum}&limit=${page.limit}"
                                               aria-label="Tail">
                                                <span aria-hidden="true"><@spring.message "project.task.endPage"/></span>
                                            </a>
                                        </li>
                                    </#if>

                                        </li>
                                    </ul>
                                </nav>

                            </td>
                        </tr>
                        </tfoot>
                    </table>
                </div>
                <!-- 用户列表 end -->
                <!-- 添加用户 modal beg -->
                <div class="modal fade modal-3d-sign" id="user_add_modal" aria-hidden="true"
                     aria-labelledby="exampleModalTitle" role="dialog" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">×</span>
                                </button>
                                <h4 class="modal-title">
                                <@spring.message "system.user.PanelTitle"/>
                                </h4>
                            </div>
                            <div class="modal-body">
                                <form class="form-horizontal" id="user_add_form">
                                    <div class="form-group row m-b-10">
                                        <label class="col-xs-12 col-md-3 form-control-label">
                                        <@spring.message "system.user.PanelUsername"/>
                                        </label>
                                        <div class="col-md-7 col-xs-12">
                                            <input type="text"
                                                   id="user_add_username"
                                                   class="form-control maxlength-input username"
                                                   data-placement="bottom-right-inside"
                                                   name="user_name"
                                                   placeholder="<@spring.message "system.user.PanelUsernameText"/>"
                                                   autocomplete="off"
                                            />
                                        </div>
                                    </div>
                                    <div class="row animate animation-slide-top m-y-5 usernameCheck"
                                               style="display: none;">
                                        <div class="offset-md-3 col-md-9 col-lg-9">
                                            <span class="red-700"><i class="icon wb-warning"></i>
                                                <span class="usernameCheckContent"><@spring.message "system.user.PanelUsernameUsed"/></span>
                                            </span>
                                        </div>
                                    </div>
                                    <div class="form-group row m-b-10">
                                        <label class="col-xs-12 col-md-3 form-control-label">
                                        <@spring.message "system.user.PanelEmail"/>
                                        </label>
                                        <div class="col-md-7 col-xs-12">
                                            <input type="text"
                                                   id="user_add_email"
                                                   class="form-control maxlength-input email"
                                                   data-plugin="maxlength"
                                                   data-placement="bottom-right-inside"
                                                   name="user_email"
                                                   placeholder="<@spring.message "system.user.PanelEmailText"/>"
                                                   autocomplete="off"                                            />
                                        </div>
                                    </div>
                                    <div class="form-group row m-b-10">
                                        <label class="col-xs-12 col-md-3 form-control-label">
                                        <@spring.message "system.user.PanelPassword"/>
                                        </label>
                                        <div class="col-md-7 col-xs-12">
                                            <input type="password"
                                                   id="user_add_password"
                                                   class="maxlength-input form-control password"
                                                   data-plugin="strength"
                                                   name="user_password"
                                                   placeholder="<@spring.message "system.user.PanelPasswordText"/>"
                                                   autocomplete="new-password"
                                            />
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <div class="text-xs-right">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">
                                            <@spring.message "system.user.PanelCancel"/>
                                            </button>
                                            <button id="user_add_submit" type="submit" class="btn btn-primary">
                                            <@spring.message "system.user.PanelAdd"/>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 添加用户 modal end -->

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
<script src="${rc.contextPath}/static/js/common/jquery.i18n.properties.js"></script>
<script src="${rc.contextPath}/static/js/common/i18n_setting.js"></script>

<script src="${rc.contextPath}/static/global/vendor/formvalidation/formValidation.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/formvalidation/framework/bootstrap4.js"></script>
<script src="${rc.contextPath}/static/assets/examples/js/forms/validation.js"></script>
<script src="${rc.contextPath}/static/js/system/sys_user_manager.js"></script>

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