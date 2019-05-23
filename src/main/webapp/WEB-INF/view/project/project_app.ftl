<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    <title><@spring.message "project.build.title"/></title>
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
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/icheck/icheck.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/bootstrap-sweetalert/sweetalert.css">
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
            <li class="breadcrumb-item"><a href="${rc.contextPath}/mainpage"><@spring.message "common.eagle.test"/></a></li>
            <li class="breadcrumb-item"><a href="${rc.contextPath}/project/${currentProject.id}">${currentProject.projectName}</a></li>
            <li class="breadcrumb-item active"><@spring.message "project.build.title"/></li>
        </ol>
    </div>
    <div class="page-content">
        <!-- 管理运行包 beg -->
        <div class="panel">
            <div class="panel-heading">
                <h3 class="panel-title"><i class="icon wb-briefcase"></i> <@spring.message "project.build.title"/></h3>
                <!--
                <div class="panel-actions">
                    <a class="panel-action icon wb-minus" data-toggle="panel-collapse" aria-expanded="true" aria-hidden="true"></a>
                </div>
                -->
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-2 col-lg-2">
                        <a class="btn btn-primary btn-sm" href="${rc.contextPath}/project/${currentProject.id}/appcreate" id="btn_createApp">
                            <i class="icon wb-plus"></i>&nbsp;<@spring.message "project.build.create"/>
                        </a>
                    </div>
                </div>
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th><@spring.message "project.build.table.build"/></th>
                            <th><@spring.message "project.build.table.label"/></th>
                            <th><@spring.message "project.build.table.version"/></th>
                            <th><@spring.message "project.build.table.visibility"/></th>
                            <th><@spring.message "project.build.table.user"/></th>
                            <th><@spring.message "project.build.table.create.time"/></th>
                            <th><@spring.message "project.build.table.operation"/></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#assign appnum = 0>
                        <#list page.data as app>
                            <#if app.visibility == 1 || app.etUser.id == currentUser.id>
                                <#assign appnum = appnum + 1>
                            <tr>
                                <td>
                                ${app.appName}
                                </td>
                                <td>
                                    <span class="tag tag-success">${app.label}</span>
                                </td>
                                <td>
                                ${app.etVersion.versionName}
                                </td>
                                <td>
                                    <#if app.visibility == 0>
                                        <i class="icon fa-lock font-size-18"></i>&nbsp;
                                        <@spring.message "project.build.table.private"/>
                                    <#else >
                                        <i class="icon fa-unlock-alt font-size-18"></i>&nbsp;
                                        <@spring.message "project.build.table.public"/>
                                    </#if>
                                </td>
                                <td>
                                    <img src="${rc.contextPath}/static/img/avatar/${app.etUser.avatars}"
                                         class="avatar avatar-xs"/>
                                ${app.etUser.email}
                                </td>
                                <td>
                                    <i class="icon wb-time"></i> ${app.createTime}
                                </td>
                                <td>
                                    <a href="${app.appAddress}" class="btn btn-sm btn-default  btn-icon btn-pure p-y-0"
                                       id="btn_appDownload"
                                       title="<@spring.message "project.build.table.operation.download"/>"><i class="icon wb-download"></i>
                                    </a>

                                    <a href="#" class="btn btn-sm btn-default btn-icon btn-pure p-y-0 app_edit"
                                       id="btn_appEdit"
                                       data-toggle="modal"
                                       data-appId="${app.id}"
                                       data-appVisibility="${app.visibility}"
                                       title="<@spring.message "project.build.table.operation.edit"/>">
                                        <i class="icon wb-edit"></i>
                                    </a>

                                    <a href="#" class="btn btn-sm btn-default  btn-icon btn-pure p-y-0"
                                       id="btn_appDelete"
                                       title="<@spring.message "project.build.table.operation.delete"/>"><i class="icon wb-trash"></i>
                                    </a>
                                </td>
                            </tr>
                            </#if>
                        </#list>
                        </tbody>
                        <tfoot>

                        <#assign pageNum = ((page.rows - 1)/ page.limit)?int  + 1>
                        <tr>
                            <td colspan="3">
                            <@spring.message "common.table.total"/> ${pageNum}&nbsp;<@spring.message "common.table.page"/>，${appnum}&nbsp;<@spring.message "project.build.table.number"/>
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
                                                <span aria-hidden="true"><@spring.message "common.table.previous"/></span>
                                            </a>
                                        </li>
                                    <#else >
                                        <li class="page-item">
                                            <a class="page-link" href="${rc.contextPath}/project/${currentProject.id}/apps?offset=1&limit=${page.limit}" aria-label="First">
                                                <span aria-hidden="true"><@spring.message "project.task.topPage"/></span>
                                            </a>
                                        </li>
                                        <li class="page-item">
                                            <a class="page-link" href="${rc.contextPath}/project/${currentProject.id}/apps?offset=${page.offset - 1}&limit=${page.limit}" aria-label="Previous">
                                                <span aria-hidden="true"><@spring.message "common.table.previous"/></span>
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
                                                <a class="page-link" href="${rc.contextPath}/project/${currentProject.id}/apps?offset=${num}&limit=${page.limit}">
                                                ${num}
                                                </a>
                                            </li>
                                        </#if>
                                    </#list>

                                    <#if page.offset == pageNum>
                                        <li class="page-item disabled">
                                            <a class="page-link " href="javascript:void(0)" aria-label="Next">
                                                <span aria-hidden="true"><@spring.message "common.table.next"/></span>
                                            </a>
                                        </li>
                                        <li class="page-item disabled">
                                            <a class="page-link" href="javascript:void(0)" aria-label="Tail">
                                                <span aria-hidden="true"><@spring.message "common.table.next"/></span>
                                            </a>
                                        </li>
                                    <#else >
                                        <li class="page-item">
                                            <a class="page-link" href="${rc.contextPath}/project/${currentProject.id}/apps?offset=${page.offset + 1}&limit=${page.limit}" aria-label="Next">
                                                <span aria-hidden="true"><@spring.message "common.table.next"/></span>
                                            </a>
                                        </li>
                                        <li class="page-item">
                                            <a class="page-link" href="${rc.contextPath}/project/${currentProject.id}/apps?offset=${pageNum}&limit=${page.limit}" aria-label="Tail">
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

                <!-- modal app edit beg -->
                <div class="modal modal-fade-in-scale-up"
                     id="modal_app_edit" aria-hidden="true"
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
                                <h4 class="modal-title"><@spring.message "project.build.edit"/></h4>
                            </div>
                            <div class="modal-body">
                                <form class="form-horizontal">
                                    <div class="form-group row m-b-10">
                                        <label class="col-xs-12 col-md-3"><@spring.message "project.build.edit.visibility"/></label>
                                        <div class="col-xs-12 col-md-7">
                                            <input type="radio"
                                                   class="icheckbox-primary"
                                                   id="app_visibility_1"
                                                   name="app_visibility"
                                                   data-plugin="iCheck"
                                                   data-radio-class="iradio_flat-blue"
                                                   value="1"
                                            />
                                            <label for="app_visibility_1"><@spring.message "project.build.edit.visibility.public"/></label>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <input type="radio"
                                                   class="icheckbox-primary"
                                                   id="app_visibility_0"
                                                   name="app_visibility"
                                                   data-plugin="iCheck"
                                                   data-radio-class="iradio_flat-blue"
                                                   value="0"
                                            />
                                            <label for="app_visibility_0"><@spring.message "project.build.edit.visibility.private"/></label>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button"
                                        class="btn btn-default"
                                        data-dismiss="modal">
                                <@spring.message "common.close"/>
                                </button>
                                <button type="button"
                                        class="btn btn-primary"
                                        id="btn_appEditSubmit">
                                <@spring.message "common.save"/>
                                </button>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- modal app edit end -->

            </div>
        </div>
        <!-- 管理运行包 end -->
    </div>
</div>
<!-- End Page -->
<input type="hidden" id="baseUrl" baseUrl="${rc.contextPath}"/>
<input type="hidden" id="projectId" projectId="${currentProject.id}">
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
<script src="${rc.contextPath}/static/global/vendor/webui-popover/jquery.webui-popover.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/icheck/icheck.min.js"></script>
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
<script src="${rc.contextPath}/static/global/js/Plugin/icheck.js"></script>
<script src="${rc.contextPath}/static/js/common/jquery.i18n.properties.js"></script>
<script src="${rc.contextPath}/static/js/common/i18n_setting.js"></script>
<script src="${rc.contextPath}/static/js/project/project_app_edit.js"></script>




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