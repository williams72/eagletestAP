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
<!-- sys_user_side end -->

<!-- Page -->
<div class="page">
    <div class="page-header p-t-10 p-b-10">
        <!--<h1 class="page-title">Page Title</h1>-->
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${rc.contextPath}/mainpage">
            <@spring.message "system.user.ContextPathHome"/>
            </a></li>
            <li class="breadcrumb-item active"><a href="${rc.contextPath}/users">
            <@spring.message "system.user.ContextTitle"/>
            </a></li>
            <li class="breadcrumb-item active">
            ${systemUserDetail.username}
            </li>
        </ol>
    </div>
    <div class="page-content">
        <div class="panel">
            <div class="panel-heading">
                <h3 class="panel-title">
                ${systemUserDetail.username}
                </h3>
                <div class="panel-actions">
                    <div class="dropdown">
                        <!-- 操作下拉按钮 -->
                        <a class="panel-action" href="#" id="btn_userOpertion" data-toggle="dropdown">
                            <i class="icon wb-dropdown"></i>
                        <@spring.message "system.user.Detail.UserOpertion"/>
                        </a>


                        <div class="dropdown-menu dropdown-menu-bullet dropdown-menu-right" aria-labelledby="examplePanelDropdown"
                             role="menu">

                            <!-- 编辑用户信息 -->
                            <#--<a class="dropdown-item"
                               id="btn_userEdit"
                               href="javascript:void(0)"
                               data-toggle="modal"
                               data-target="#modal_user_edit"
                               role="menuitem">
                                <i class="icon wb-edit" aria-hidden="true"></i>
                                <@spring.message "system.user.Detail.UserEdit"/>
                            </a>-->

                            <!-- 重置密码 -->
                            <a class="dropdown-item"
                               id="btn_resetPwd"
                               href="javascript:void(0)"
                               data-toggle="modal"
                               data-target="#modal_user_pwd_edit"
                               role="menuitem">
                                <i class="icon wb-pencil" aria-hidden="true"></i>
                                <@spring.message "system.user.Detail.ResetPwd"/>
                            </a>

                        </div>
                    </div>
                </div>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-sm-6 col-md-6 col-lg-6">
                        <h4><i class="icon wb-order"></i>&nbsp;&nbsp;<@spring.message "system.user.Detail.AccountDetail"/></h4>
                        <p><@spring.message "system.user.Detail.ImgHead"/><img src="${rc.contextPath}/static/img/avatar/${systemUserDetail.avatars}" class="avatar avatar-xs"/> </p>
                        <p><@spring.message "system.user.Detail.UserName"/>${systemUserDetail.username}</p>
                        <p><@spring.message "system.user.Detail.Email"/>${systemUserDetail.email}</p>
                        <p><@spring.message "system.user.Detail.UserRole"/>
                            <span class="tag tag-primary">

                                <#if systemUserDetail.etRoles[0].roleValue == 1>
                                        <@spring.message "system.user.TableRoleAdmin"/>
                                    <#else >
                                    <@spring.message "system.user.TableRoleStaff"/>
                                </#if>

                            </span>
                        </p>
                    </div>
                    <div class="col-sm-6 col-md-6 col-lg-6">
                        <h4><i class="icon wb-stats-bars"></i>&nbsp;&nbsp;<@spring.message "system.user.Detail.Statistics"/></h4>

                        <p><@spring.message "system.user.Detail.LastLoginTime"/>${systemUserDetail.lastlogintime}</p>
                    </div>
                </div>

                <#--<div class="row m-t-15">
                    <div class="col-sm-6 col-md-6 col-lg-6">
                        <h4><i class="icon wb-user"></i>&nbsp;&nbsp;<@spring.message "system.user.Detail.UserRole"/></h4>
                    </div>
                    <div class="col-sm-6 col-md-6 col-lg-6">

                    </div>
                </div>-->

                <!-- modal user info edit beg-->
                <div class="modal modal-3d-sign" id="modal_user_edit" aria-hidden="true"
                     role="dialog" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button"
                                        class="close"
                                        data-dismiss="modal"
                                        aria-label="Close">
                                    <span aria-hidden="true">×</span>
                                </button>
                                <h4 class="modal-title"><@spring.message "system.user.Detail.ModifyInfo"/></h4>
                            </div>
                            <div class="modal-body">

                            </div>
                            <div class="modal-footer">
                                <button type="button"
                                        class="btn btn-default"
                                        data-dismiss="modal">
                                <@spring.message "system.user.Detail.ModalColse"/>
                                </button>
                                <button type="button"
                                        class="btn btn-primary">
                                <@spring.message "system.user.Detail.SaveChanges"/>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- modal user info edit end-->

                <!-- modal user pwd reset beg-->
                <div class="modal modal-3d-sign" id="modal_user_pwd_edit" aria-hidden="true"
                     role="dialog" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button"
                                        class="close"
                                        data-dismiss="modal"
                                        aria-label="Close">
                                    <span aria-hidden="true">×</span>
                                </button>
                                <h4 class="modal-title"><@spring.message "system.user.Detail.ResetPwd"/></h4>
                            </div>
                            <div class="modal-body">
                                <form class="form-horizontal">
                                    <div class="form-group row m-b-10">
                                        <label class="col-xs-12 col-md-3 form-control-label"><@spring.message "system.user.Detail.NewPwd"/> </label>
                                        <div class="col-md-7 col-xs-12">
                                            <input id="user_pwd_reset"
                                                   class="maxlength-input form-control password"
                                                   type="password"
                                                   placeholder="<@spring.message "system.user.Detail.EnterNewPwd"/>"
                                                   autocomplete="off"
                                            />
                                        </div>
                                    </div>

                                    <div class="row animate animation-slide-top m-y-5 passwordCheck" style="display: none;">
                                        <div class="offset-md-3 col-md-9 col-lg-9">
                                            <span class="red-700"><i class="icon wb-warning"></i>
                                                <span class="passwordCheckContent"><@spring.message "system.user.PanelUsernameUsed"/></span>
                                            </span>
                                        </div>
                                    </div>

                                    <div class="form-group row m-b-10">
                                        <label class="col-xs-12 col-md-3 form-control-label"><@spring.message "system.user.Detail.ConfirmNewPwd"/></label>
                                        <div class="col-xs-12 col-md-7">
                                            <input type="password"
                                                   id="user_cpwd_reset"
                                                   class="maxlength-input form-control cpassword"
                                                   placeholder="<@spring.message "system.user.Detail.EnterConfirmNewPwd"/>"
                                                   autocomplete="off"
                                            />
                                        </div>
                                    </div>

                                    <div class="row animate animation-slide-top m-y-5 cpasswordCheck" style="display: none;">
                                        <div class="offset-md-3 col-md-9 col-lg-9">
                                            <span class="red-700"><i class="icon wb-warning"></i>
                                                <span class="cpasswordCheckContent"><@spring.message "system.user.PanelUsernameUsed"/></span>
                                            </span>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button"
                                        id="btn_cacel"
                                        class="btn btn-default"
                                        data-dismiss="modal">
                                <@spring.message "system.user.Detail.ModalColse"/>
                                </button>
                                <button type="button"
                                        class="btn btn-primary"
                                        id="btn_resetPwdSubmit">
                                <@spring.message "system.user.Detail.SaveChanges"/>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- modal user pwd reset end-->

            </div>
        </div>
    </div>
</div>

<!-- End Page -->
<input type="hidden" id="baseUrl" baseUrl="${rc.contextPath}"/>
<input type="hidden" id="userId" userId="${systemUserDetail.id}"/>

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

<script src="${rc.contextPath}/static/js/system/sys_user_manager.js"></script>
<script src="${rc.contextPath}/static/js/user/user_reset_pwd.js"></script>
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