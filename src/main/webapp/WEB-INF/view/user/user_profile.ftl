<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    <title>
        <@spring.message "user.profile"/>
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
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/bootstrap-sweetalert/sweetalert.css">

    <link rel="stylesheet" href="${rc.contextPath}/static/assets/examples/css/pages/profile.css">
    <!-- datatables beg -->
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/datatables-bootstrap/dataTables.bootstrap.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/datatables-fixedheader/dataTables.fixedHeader.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/datatables-responsive/dataTables.responsive.css">
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
<body class="animsition page-profile">
<!--[if lt IE 8]>
<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade
    your browser</a> to improve your experience.</p>
<![endif]-->
<nav class="site-navbar navbar navbar-default navbar-fixed-top navbar-mega" role="navigation">
    <div class="navbar-header">

        <button type="button" class="navbar-toggler collapsed" id="btn_nav_more" data-target="#site-navbar-collapse"
                data-toggle="collapse">
            <i class="icon wb-more-horizontal" aria-hidden="true"></i>
        </button>
        <div class="navbar-brand navbar-brand-center site-gridmenu-toggle" data-toggle="gridmenu">
            <img class="navbar-brand-logo" src="${rc.contextPath}/static/img/logo-img.png" title="Remark">
            <span class="navbar-brand-text hidden-xs-down">
            <@spring.message "common.eagle.test"/>
            </span>
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

                <!-- 导航栏下拉  end-->


            </ul>
            <!-- End Navbar Toolbar -->
            <!-- Navbar Toolbar Right -->
            <ul class="nav navbar-toolbar navbar-right navbar-toolbar-right">

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
        <!--<h1 class="page-title">Page Title</h1>-->
        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <a href="${rc.contextPath}/mainpage">
                    <@spring.message "common.eagle.test"/>
                </a>
            </li>
            <li class="breadcrumb-item active">
                <@spring.message "user.profile"/>
            </li>
        </ol>
    </div>
    <div class="page-content">
        <div class="row">
            <div class="col-lg-3 col-xs-12">
                <!-- Page Widget -->
                <div class="card card-shadow text-xs-center">
                    <div class="card-block">
                        <a class="avatar avatar-lg" href="javascript:void(0)">
                            <img src="${rc.contextPath}/static/img/avatar/${userDetail.avatars}" alt="...">
                        </a>
                        <h4 class="profile-user">
                            ${userDetail.username}
                        </h4>
                        <!--
                        <p class="profile-job">
                            <mark>管理员</mark>
                        </p>
                        -->
                        <p>
                            ${userDetail.email}
                        </p>
                        <div style="width:80%; border-top:1px dashed #8796a4; margin:15px auto;"></div>

                        <p><@spring.message "user.profile.last.login"/>${userDetail.lastlogintime}</p>
                        <!--
                        <div class="profile-social">
                            <a class="icon bd-twitter" href="javascript:void(0)"></a>
                            <a class="icon bd-facebook" href="javascript:void(0)"></a>
                            <a class="icon bd-dribbble" href="javascript:void(0)"></a>
                            <a class="icon bd-github" href="javascript:void(0)"></a>
                        </div>
                        -->
                    </div>
                    <div class="card-footer">
                        <div class="row no-space">
                            <div class="col-xs-4">
                                <strong class="profile-stat-count">
                                    ${userDetail.etTasks?size}
                                </strong>
                                <span>
                                <@spring.message "user.profile.tasks"/>
                                </span>
                            </div>
                            <div class="col-xs-4">
                                <strong class="profile-stat-count">
                                    ${userDetail.etProjects?size}
                                </strong>
                                <span>
                                <@spring.message "user.profile.projects"/>
                                </span>
                            </div>
                            <div class="col-xs-4">
                                <strong class="profile-stat-count">
                                    ${userDetail.etApps?size}
                                </strong>
                                <span>
                                <@spring.message "user.profile.apps"/>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Page Widget -->
            </div>
            <div class="col-lg-9 col-xs-12">
                <!-- Panel -->
                <div class="panel">
                    <div class="panel-body nav-tabs-animate nav-tabs-horizontal" data-plugin="tabs">
                        <ul class="nav nav-tabs nav-tabs-line" role="tablist">
                            <li class="nav-item" role="presentation"><a class="active nav-link" data-toggle="tab"
                                                                        href="#myprofile"
                                                                        aria-controls="activities" role="tab">
                            <@spring.message "user.profile"/>
                            </a>
                            </li>
                            <li class="nav-item" role="presentation"><a class="nav-link" data-toggle="tab"
                                                                        href="#myproject" aria-controls="profile"
                                                                        role="tab">
                            <@spring.message "user.profile.projects"/>
                            </a></li>
                            <li class="nav-item" role="presentation"><a class="nav-link" data-toggle="tab"
                                                                        href="#mychangepwd" aria-controls="messages"
                                                                        role="tab">
                            <@spring.message "user.profile.password"/>
                            </a></li>
                            <li class="nav-item dropdown">
                                <a class="dropdown-toggle nav-link" data-toggle="dropdown" href="#"
                                   aria-expanded="false">Menu </a>
                                <div class="dropdown-menu" role="menu">
                                    <a class="active dropdown-item" data-toggle="tab" href="#myprofile"
                                       aria-controls="activities"
                                       role="tab"><@spring.message "user.profile"/></a>
                                    <a class="dropdown-item" data-toggle="tab" href="#myproject" aria-controls="profile"
                                       role="tab">
                                    <@spring.message "user.profile.projects"/>
                                    </a>
                                    <a class="dropdown-item" data-toggle="tab" href="#mychangepwd"
                                       aria-controls="messages"
                                       role="tab">
                                    <@spring.message "user.profile.password"/>
                                    </a>
                                </div>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active animation-slide-left" id="myprofile" role="tabpanel">
                                <div class="row m-t-30">
                                    <div class="col-xs-12 col-md-2 col-lg-2">
                                    <@spring.message "user.profile.avatar"/>
                                    </div>
                                    <div class="col-xs-12 col-md-10 col-lg-10">
                                        <img src="${rc.contextPath}/static/img/avatar/${userDetail.avatars}" class="avatar avatar-lg"/>
                                        <!--
                                        <a href="javascript:void(0);" data-target="#avatarModal" data-toggle="modal">更换头像</a>
                                        -->
                                    </div>
                                </div>
                                <div class="row m-t-15 p-t-10" style="border-top: 1px dashed #c7c7c3;">
                                    <div class="col-xs-12 col-md-2 col-lg-2">
                                    <@spring.message "user.profile.information"/>
                                    </div>
                                    <div class="col-xs-12 col-md-10 col-lg-10" >
                                        <form autocomplete="off">
                                            <div class="row">
                                                <div class="form-group col-xs-12 col-md-6">
                                                    <label class="form-control-label" for="inputBasicFirstName">
                                                    <@spring.message "user.profile.username"/>
                                                    </label>
                                                    <input type="text" class="form-control" id="inputBasicFirstName" name="inputFirstName" value="${userDetail.username}"
                                                           placeholder="${userDetail.username}" autocomplete="off" disabled/>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="form-group col-xs-12 col-md-6">
                                                    <label class="form-control-label" for="inputBasicEmail">
                                                    <@spring.message "user.profile.email"/>
                                                    </label>
                                                    <input type="email" class="form-control" id="inputBasicEmail" name="inputEmail" value="${userDetail.email}"
                                                           placeholder="${userDetail.email}" autocomplete="off" disabled/>
                                                </div>
                                            </div>
                                            <!--
                                            <div class="row">
                                                <div class="form-group col-xs-12 col-md-6">
                                                    <button type="button" class="btn btn-primary"><@spring.message "user.profile.save"/></button>
                                                </div>
                                            </div>
                                            -->
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane animation-slide-left" id="myproject" role="tabpanel" style="min-height: 450px;">
                                <div class="row">

                                </div>
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th><@spring.message "user.profile.project.name"/></th>
                                        <th><@spring.message "user.profile.project.key"/></th>
                                        <th><@spring.message "user.profile.project.type"/></th>
                                        <!--
                                        <th>成员</th>
                                        -->
                                        <th><@spring.message "user.profile.project.role"/></th>
                                        <th><@spring.message "user.profile.project.time"/></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <#list projectUsers as projectUsers>
                                    <tr>
                                        <td class="p-y-5">
                                            <a href="${rc.contextPath}/project/${projectUsers.etProject.id}">${projectUsers.etProject.projectName}</a>
                                        </td>
                                        <td class="p-y-5">
                                            <span class="tag tag-primary">${projectUsers.etProject.projectKey}</span>
                                        </td>
                                        <td class="p-y-5">
                                            <span class="tag tag-default">
                                                <#if projectUsers.etProject.projectType == 0>
                                                    <@spring.message "system.project.create.FormTypeAnd"/>
                                                <#elseif projectUsers.etProject.projectType == 1>
                                                    <@spring.message "system.project.create.FormTypeIos"/>
                                                </#if>
                                            </span>
                                        </td>
                                        <!--
                                        <td class="p-y-5">
                                            <img class="avatar avatar-xs" src="img/user/u112505.png"/>
                                            &rang;
                                            <img class="avatar avatar-xs" src="img/user/u112506.png"/>
                                            <img class="avatar avatar-xs" src="img/user/u112507.png"/>
                                            <img class="avatar avatar-xs" src="img/user/u112508.png"/>
                                        </td>
                                        -->
                                        <td class="p-y-5">
                                            <span class="tag tag-primary">
                                                <#if projectUsers.projectRole == 1>
                                                    <@spring.message "user.profile.project.role.admin"/>
                                                <#elseif projectUsers.projectRole == 2>
                                                    <@spring.message "user.profile.project.role.member"/>
                                                </#if>
                                            </span>
                                        </td>
                                        <td class="p-y-5">
                                            <i class="icon wb-time"></i>
                                            ${projectUsers.etProject.createTime}
                                        </td>
                                        <td class="p-y-5"></td>
                                    </tr>
                                    </#list>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-pane animation-slide-left" id="mychangepwd" role="tabpanel">
                                <form id="formChangePwd" class="form-horizontal m-t-30">
                                    <div class="form-group row">
                                        <label class="col-xs-12 col-md-2 form-control-label">
                                        <@spring.message "user.profile.password.current"/></label>
                                        <div class="col-md-4 col-xs-12">
                                            <input type="password" class="form-control currentPwd" name="name" placeholder="<@spring.message "user.profile.password.current.text"/>"
                                                   autocomplete="off"
                                            />
                                            <!--
                                            <span class="text-help">您必须提供当前密码才能执行修改密码操作</span>
                                            -->
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-xs-12 col-md-2 form-control-label">
                                        <@spring.message "user.profile.password.new"/></label>
                                        <div class="col-md-4 col-xs-12">
                                            <input type="password" class="maxlength-input form-control newPwd"
                                                   data-plugin="strength" name="name" placeholder="<@spring.message "user.profile.password.new.text"/>"
                                                   autocomplete="off"
                                            />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-xs-12 col-md-2 form-control-label">
                                        <@spring.message "user.profile.password.repeat"/>
                                        </label>
                                        <div class="col-md-4 col-xs-12">
                                            <input type="password" class="form-control repeatPwd" name="name" placeholder="<@spring.message "user.profile.password.repeat.text"/>"
                                                   autocomplete="off"
                                            />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-xs-12 col-md-9 offset-md-2">
                                            <button type="button" id="btn_changePwd" class="btn btn-primary btnChangePwd">
                                            <@spring.message "user.profile.password.change"/>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Panel -->
            </div>
        </div>
    </div>
</div>
<!-- End Page -->
<!-- change avatar modal beg -->
<div class="modal fade modal-fade-in-scale-up" id="avatarModal"
     role="dialog" tabindex="-1" aria-labelledby="examplePositionCenter">
    <div class="modal-dialog modal-center">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title">更换头像</h4>
            </div>
            <div class="modal-body">
                <h4>选择头像</h4>
                <div class="row">
                    <div class="col-lg-12">
                        <a href="#">
                            <img class="avatar img-bordered img-bordered-green" src="img/user/u112503.png"/>
                        </a>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>

</div>
<!-- change avatar modal end -->
<input type="hidden" id="baseUrl" baseUrl="${rc.contextPath}"/>
<input type="hidden" id="currentUserId" currentUserId="${currentUser.id}"/>
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
<script src="${rc.contextPath}/static/global/vendor/bootstrap-sweetalert/sweetalert.js"></script>

<script src="${rc.contextPath}/static/global/vendor/jquery-strength/password_strength.js"></script>
<script src="${rc.contextPath}/static/global/vendor/jquery-strength/jquery-strength.min.js"></script>

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

<script src="${rc.contextPath}/static/global/js/Plugin/responsive-tabs.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/tabs.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/bootstrap-sweetalert.js"></script>
<script src="${rc.contextPath}/static/js/common/jquery.i18n.properties.js"></script>
<script src="${rc.contextPath}/static/js/common/i18n_setting.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/jquery-strength.js"></script>
<script src="${rc.contextPath}/static/js/user/user_profile.js"></script>

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