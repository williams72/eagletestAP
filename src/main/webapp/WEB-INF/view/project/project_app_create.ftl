<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    <title>
        <@spring.message "project.build.upload"/>
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
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/dropify/dropify.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/bootstrap-select/bootstrap-select.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/webui-popover/webui-popover.css">

    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/select2/select2.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/bootstrap-select/bootstrap-select.css">

    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/icheck/icheck.css">
    <!-- Fonts -->
    <link rel="stylesheet" href="${rc.contextPath}/static/global/fonts/web-icons/web-icons.min.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/fonts/brand-icons/brand-icons.min.css">
    <!-- datatables beg -->
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/datatables-bootstrap/dataTables.bootstrap.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/datatables-fixedheader/dataTables.fixedHeader.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/datatables-responsive/dataTables.responsive.css">

    <link rel="stylesheet" href="${rc.contextPath}/static/assets/css/forms/validation.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/formvalidation/formValidation.css">

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
                    <li class="site-menu-item active">
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
            <@spring.message "common.eagle.test"/>
            </a></li>
            <li class="breadcrumb-item"><a href="${rc.contextPath}/project/${currentProject.id}">${currentProject.projectName}</a></li>
            <li class="breadcrumb-item"><a href="${rc.contextPath}/project/${currentProject.id}/apps">
            <@spring.message "project.build.title"/>
            </a></li>
            <li class="breadcrumb-item active"><@spring.message "project.build.upload"/></li>
        </ol>
    </div>
    <div class="page-content">
        <!-- 添加运行包 beg -->
        <div class="panel">
            <div class="panel-heading">
                <h3 class="panel-title"><i class="icon wb-upload"></i>
                <@spring.message "project.build.upload"/>
                </h3>
                <!--
                <div class="panel-actions">
                    <a class="panel-action icon wb-minus" data-toggle="panel-collapse" aria-expanded="true" aria-hidden="true"></a>
                </div>
                -->
            </div>
            <div class="panel-body">
                <!-- 添加运行包 beg-->
                <form id="app_add_form" action="${rc.contextPath}/project/${currentProject.id}/app" method="post" enctype="multipart/form-data">
                    <input type="text" name="fileType" value="apk" hidden/>
                    <div class="row">
                        <div class="col-xs-12 col-md-6 col-lg-6">
                            <div class="form-group">
                                <label class="col-xs-12 col-md-3 col-lg-3 form-control-label"><i
                                        class="icon wb-order"></i>&nbsp;
                                <@spring.message "project.build.upload.name"/></label>
                                <input type="text" name="appName" id="app_name" class="form-control" required/>
                                <small id="appNameCheck" class="text-help red-500"></small>
                            </div>
                        </div>
                        <div class="col-xs-12 col-md-3 col-lg-3">
                            <div class="form-group">
                                <label class="form-control-label block" for="versionStatus">
                                <@spring.message "project.build.upload.version"/>
                                </label>
                                <select name="versionId" id="version"
                                        data-plugin="select2" class="form-control show-tick"
                                        title="<@spring.message "project.build.upload.version.title"/>" required>
                                    <#list versions as version>
                                        <option value="${version.id}">
                                        ${version.versionName}
                                        </option>
                                    </#list>
                                </select>
                            </div>
                        </div>

                    </div>
                    <div class="form-group">
                        <label class="col-xs-12 col-md-2 col-lg-2 form-control-label"><i
                                class="icon wb-tag"></i> &nbsp;<@spring.message "project.build.upload.version.label"/></label>
                        <input type="text" name="label" class="form-control" required/>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-12 col-md-2 form-control-label"><i
                                class="icon wb-upload"></i>&nbsp;
                        <@spring.message "project.build.upload.select.file"/></label>
                        <input type="file"
                               id="input-file-now"
                               name="file"
                               data-allowed-file-extensions="<#if currentProject.projectType == 0>apk<#else >ipa</#if>"
                               data-errors-position="outside"
                               data-default-file=""
                               required/>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label inline-block"><@spring.message "project.build.upload.visibility"/></label>
                        <span class="text-help inline-block text-xs-left">
                            <a href="#" class="btn btn-sm btn-icon btn-pure btn-default on-default"
                               data-content="<@spring.message "project.build.upload.visibility.help"/>"
                               data-trigger="hover" data-toggle="popover"
                               tabindex="0">
                                <i class="icon wb-help-circle"></i>
                            </a>
                        </span>
                        <div>
                            <div class="inline-block m-r-20">
                                <input type="radio" id="appvpu"
                                       name="visibility"
                                       class="icheckbox-primary"
                                       data-radio-class="iradio_flat-blue"
                                       data-plugin="iCheck" value="1" checked />
                                <label class="m-l-5" for="appvpu">
                                    <i class="icon wb-unlock"></i>&nbsp;&nbsp;
                                <@spring.message "project.build.upload.public"/>
                                </label>
                            </div>
                            <div class="inline-block">
                                <input type="radio" id="appvpr"
                                       name="visibility"
                                       class="icheckbox-primary"
                                       data-plugin="iCheck"
                                       data-radio-class="iradio_flat-blue"
                                       value="0" />
                                <label class="m-l-5" for="appvpr">
                                    <i class="icon wb-lock"></i>&nbsp;&nbsp;
                                <@spring.message "project.build.upload.private"/>
                                </label>
                            </div>

                        </div>
                    </div>
                    <div class="form-group">
                        <button id="btn_createAppSubmit" type="submit" class="btn btn-primary"><@spring.message "common.save"/></button>
                    </div>
                </form>
                <!-- 添加运行包 end-->
            </div>
        </div>
        <!-- 添加运行包 end -->
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
<script src="${rc.contextPath}/static/global/vendor/dropify/dropify.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/bootstrap-select/bootstrap-select.js"></script>
<script src="${rc.contextPath}/static/global/vendor/icheck/icheck.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/webui-popover/jquery.webui-popover.min.js"></script>

<script src="${rc.contextPath}/static/global/vendor/select2/select2.full.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/select2/select2.full.js"></script>


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
<script src="${rc.contextPath}/static/global/js/Plugin/panel.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/dropify.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/bootstrap-select.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/icheck.js"></script>
<script src="${rc.contextPath}/static/assets/examples/js/uikit/tooltip-popover.js"></script>
<script src="${rc.contextPath}/static/js/common/jquery.i18n.properties.js"></script>
<script src="${rc.contextPath}/static/js/common/i18n_setting.js"></script>
<script src="${rc.contextPath}/static/js/project/project_app.js"></script>

<script src="${rc.contextPath}/static/global/vendor/formvalidation/formValidation.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/formvalidation/framework/bootstrap4.js"></script>
<script src="${rc.contextPath}/static/assets/examples/js/forms/validation.js"></script>
<script src="${rc.contextPath}/static/js/project/project_app_create.js"></script>

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