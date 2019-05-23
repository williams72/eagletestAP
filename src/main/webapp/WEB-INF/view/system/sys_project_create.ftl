<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    <title><@spring.message "system.project.create.title"/></title>
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
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/bootstrap-select/bootstrap-select.css">
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
            <li class="breadcrumb-item">
                <a href="${rc.contextPath}/mainpage">
                    <@spring.message "system.project.create.contextPathHome"/>
                </a>
            </li>
            <li class="breadcrumb-item">
                <a href="${rc.contextPath}/projects">
                <@spring.message "system.project.create.contextPathTitle"/>
                </a>
            </li>
            <li class="breadcrumb-item active">
            <@spring.message "system.project.create.contextPathSub"/>
            </li>
        </ol>
    </div>
    <div class="page-content">
        <div class="panel">
            <div class="panel-heading">
                <h3 class="panel-title"><@spring.message "system.project.create.RightFormtitle"/></h3>
                <div class="panel-actions">

                </div>
            </div>
            <div class="panel-body">
                <form id="project_add_form" autocomplete="off">
                    <div class="form-group">
                        <label class="form-control-label" for="newProName">
                        <@spring.message "system.project.create.FormProjectname"/>
                        </label>
                        <input type="text" class="form-control maxlength-input" data-plugin="maxlength"
                               data-placement="bottom-right-inside" maxlength="20" id="newProName" name="newProName"
                               placeholder="<@spring.message "system.project.create.FormProjectText"/>" autocomplete="off" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" for="newProKey">
                            <@spring.message "system.project.create.FormKey"/>
                        </label>
                        <input type="text" class="form-control maxlength-input" data-plugin="maxlength"
                               data-placement="bottom-right-inside" maxlength="6" id="newProKey" name="newProKey"
                               placeholder="<@spring.message "system.project.create.FormKeyText"/>" autocomplete="off" />
                        <span class="text-help"><i class="icon wb-info-circle"></i>
                        <@spring.message "system.project.create.FormKeyInfo"/>
                        </span>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label">
                            <@spring.message "system.project.create.FormType"/>
                        </label>
                        <div id="newProType">
                            <div class="radio-custom radio-default radio-inline">
                                <input type="radio" id="inputBasicMale" value="0" name="newProType" checked/>
                                <label for="inputBasicMale">
                                <@spring.message "system.project.create.FormTypeAnd"/>
                                </label>
                            </div>
                            <div class="radio-custom radio-default radio-inline">
                                <input type="radio" id="inputBasicFemale" value="1" name="newProType"  />
                                <label for="inputBasicFemale">
                                <@spring.message "system.project.create.FormTypeIos"/>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" for="newProAdmin">
                        <@spring.message "system.project.create.FormMember"/>
                        </label>
                        <select id="newProAdmin" name="newProAdmin" class="form-control" data-allow-clear="true" data-plugin="select2" style="width: 100%">
                            <option></option>
                            <#list users as user>
                                <option value="${user.id},${user.avatars}">${user.username}/${user.email}</option>
                            </#list>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" for="newProInfo"><@spring.message "system.project.create.FormDecription"/></label>
                        <textarea id="newProInfo" name="newProInfo" class="form-control" cols="10" rows="4" placeholder="<@spring.message "system.project.create.FormDecriptionText"/>"></textarea>
                    </div>
                    <!--
                    <div class="form-group">
                        <div class="checkbox-custom checkbox-default">
                            <input type="checkbox" id="inputBasicRemember" name="inputCheckbox" checked autocomplete="off"
                            />
                            <label for="inputBasicRemember">项目创建后通知该管理员</label>
                        </div>
                    </div>
                    -->
                    <div class="form-group">
                        <button id="btn_createProjectSubmit" type="submit" class="btn btn-primary">
                        <@spring.message "system.project.create.FormAdd"/>
                        </button>
                    </div>
                </form>
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

<script src="${rc.contextPath}/static/global/vendor/select2/select2.full.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/select2/select2.full.js"></script>
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
<script src="${rc.contextPath}/static/global/js/Plugin/select2.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/jquery-strength.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/bootstrap-sweetalert.js"></script>
<script src="${rc.contextPath}/static/js/common/jquery.i18n.properties.js"></script>
<script src="${rc.contextPath}/static/js/common/i18n_setting.js"></script>


<script src="${rc.contextPath}/static/global/vendor/formvalidation/formValidation.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/formvalidation/framework/bootstrap4.js"></script>
<script src="${rc.contextPath}/static/assets/examples/js/forms/validation.js"></script>
<script src="${rc.contextPath}/static/js/system/sys_project_create.js"></script>
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