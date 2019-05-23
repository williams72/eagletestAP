<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    <title>
    <@spring.message "project.version.TableTitle"/>
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
                    <li class="site-menu-item active">
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
            <li class="breadcrumb-item"><a href="${rc.contextPath}/mainpage">
            <@spring.message "common.eagle.test"/>
            </a></li>
            <li class="breadcrumb-item"><a href="${rc.contextPath}/project/${currentProject.id}">${currentProject.projectName}</a></li>
            <li class="breadcrumb-item active">
            <@spring.message "project.version"/>
            </li>
        </ol>
    </div>
    <div class="page-content">
        <!-- 版本管理 beg-->
        <div class="panel">
            <header class="panel-heading">
                <h3 class="panel-title"><i class="icon wb-code-working"></i><@spring.message "project.version.TableTitle"/></h3>
            </header>
            <div class="panel-body">
                <form id="version_add_form" action="${rc.contextPath}/project/${currentProject.id}/version" method="post" autocomplete="off">
                    <div class="row">
                        <div class="form-group col-xs-12 col-md-7">
                            <label class="form-control-label" for="versionName">
                            <@spring.message "project.version.TableVersionName"/>
                            </label>
                            <input class="form-control" id="versionName" name="versionName" placeholder="<@spring.message "project.version.TableVersionText"/>" required>
                        </div>
                        <div class="form-group col-xs-12 col-md-3">
                            <label class="form-control-label block" for="versionStatus">
                            <@spring.message "project.version.TableStatus"/>
                            </label><#---->
                            <select name="versionStatus" id="versionStatus" data-projectid="${currentProject.id}"
                                    data-plugin="select2" class="form-control show-tick"
                                    placeholder="<@spring.message "project.version.TableStatusText"/>">
                                <option value="1" selected>
                                    <@spring.message "project.version.TableStatus.dev"/>
                                </option>
                                <option value="2">
                                    <@spring.message "project.version.TableStatus.test"/>
                                </option>
                                <option value="3">
                                    <@spring.message "project.version.TableStatus.released"/>
                                </option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <button id="btn_createBuildSubmit" type="submit" class="btn btn-primary">
                        <@spring.message "project.version.TableBtn"/>
                        </button>
                    </div>
                </form>
                <h5><@spring.message "project.version.TableVersion"/>&nbsp;<span class="tag tag-pill tag-success">${page.data?size}</span></h5>
                <div class="">
                    <table class="table">
                        <thead>
                        <tr>
                            <th style="width:40%">
                            <@spring.message "project.version.TableName"/>
                            </th>
                            <th style="width:30%">
                            <@spring.message "project.version.TableTime"/>
                            </th>
                            <th style="width:30%">
                            <@spring.message "project.version.TableOperation"/>
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list page.data as pv>
                        <tr>
                            <td>
                                ${pv.versionName}
                            </td>
                            <td>
                                <i class="icon wb-time"></i> &nbsp;${pv.createTime}
                            </td>
                            <td class="p-y-3">
                                <select data-versionid="${pv.id}" data-projectid="${currentProject.id}"
                                        data-plugin="selectpicker" class="show-tick versionStatusChange">
                                    <#if pv.versionStatus == 1>
                                        <option value="1" selected>
                                            <@spring.message "project.version.TableStatus.dev"/>
                                        </option>
                                        <option value="2">
                                            <@spring.message "project.version.TableStatus.test"/>
                                        </option>
                                        <option value="3">
                                            <@spring.message "project.version.TableStatus.released"/>
                                        </option>
                                    <#elseif pv.versionStatus == 2>
                                        <option value="1">
                                            <@spring.message "project.version.TableStatus.dev"/>
                                        </option>
                                        <option value="2" selected><@spring.message "project.version.TableStatus.test"/></option>
                                        <option value="3">
                                            <@spring.message "project.version.TableStatus.released"/>
                                        </option>
                                    <#elseif pv.versionStatus == 3>
                                        <option value="1">
                                            <@spring.message "project.version.TableStatus.dev"/>
                                        </option>
                                        <option value="2">
                                            <@spring.message "project.version.TableStatus.test"/>
                                        </option>
                                        <option value="3" selected>
                                            <@spring.message "project.version.TableStatus.released"/>
                                        </option>
                                    </#if>
                                </select>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                        <tfoot>
                        <#assign pageNum = ((page.rows - 1)/ page.limit)?int  + 1>
                        <tr>
                            <td colspan="1">
                            <@spring.message "project.version.TableTotal"/>&nbsp;${pageNum}&nbsp;<@spring.message "project.version.Tablepage"/>， ${page.rows} &nbsp;<@spring.message "project.version.TableVersions"/>
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
                                                <span aria-hidden="true">
                                                    <@spring.message "project.version.TablePrevious"/>
                                                </span>
                                            </a>
                                        </li>
                                    <#else >
                                        <li class="page-item">
                                            <a class="page-link" href="${rc.contextPath}/project/${currentProject.id}/versions?offset=1&limit=${page.limit}" aria-label="First">
                                                <span aria-hidden="true"><@spring.message "project.task.topPage"/></span>
                                            </a>
                                        </li>
                                        <li class="page-item">
                                            <a class="page-link" href="${rc.contextPath}/project/${currentProject.id}/versions?offset=${page.offset - 1}&limit=${page.limit}" aria-label="Previous">
                                                <span aria-hidden="true"><@spring.message "project.version.TablePrevious"/></span>
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
                                                <a class="page-link" href="${rc.contextPath}/project/${currentProject.id}/versions?offset=${num}&limit=${page.limit}">
                                                ${num}
                                                </a>
                                            </li>
                                        </#if>
                                    </#list>

                                    <#if page.offset == pageNum>
                                        <li class="page-item disabled">
                                            <a class="page-link " href="javascript:void(0)" aria-label="Next">
                                                <span aria-hidden="true">
                                                    <@spring.message "project.version.TableNext"/>
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
                                            <a class="page-link" href="${rc.contextPath}/project/${currentProject.id}/versions?offset=${page.offset + 1}&limit=${page.limit}" aria-label="Next">
                                                <span aria-hidden="true">
                                                    <@spring.message "project.version.TableNext"/>
                                                </span>
                                            </a>
                                        </li>
                                        <li class="page-item">
                                            <a class="page-link" href="${rc.contextPath}/project/${currentProject.id}/versions?offset=${pageNum}&limit=${page.limit}" aria-label="Tail">
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
            </div>
        </div>
        <!-- 版本管理 end-->
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
<script src="${rc.contextPath}/static/global/vendor/select2/select2.full.js"></script>
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

<script src="${rc.contextPath}/static/global/vendor/formvalidation/formValidation.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/formvalidation/framework/bootstrap4.js"></script>
<script src="${rc.contextPath}/static/assets/examples/js/forms/validation.js"></script>
<script src="${rc.contextPath}/static/js/project/project_version.js"></script>

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