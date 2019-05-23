<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    <title><@spring.message "system.log.Title"/></title>
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

<!-- sys_mobile_side beg -->
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

                    <li class="site-menu-item active">
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
<!-- sys_moblie_side end -->

<!-- Page -->
<div class="page">
    <div class="page-header p-t-10 p-b-10">
        <!--<h1 class="page-title">Page Title</h1>-->
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${rc.contextPath}/mainpage">
            <@spring.message "system.log.ContextpathHome"/>
            </a></li>
            <li class="breadcrumb-item active">
            <@spring.message "system.log.ContextpathTitle"/>
            </li>
        </ol>
    </div>
    <div class="page-content">
        <div class="panel" style="min-height: 450px;">
            <div class="panel-heading">
                <h3 class="panel-title"><i class="icon wb-order"></i><@spring.message "system.log.TableTitle"/></h3>
                <div class="panel-actions">

                </div>
            </div>
            <div class="panel-body">
                <!-- log list beg -->
                <div class="example table-responsive">
                    <table class="table m-b-0">
                        <thead>
                        <tr>
                            <th width="13%" class="p-l-6"><@spring.message "system.log.TableUser"/></th>
                            <th width="10%" class="p-l-6"><@spring.message "system.log.TableCode"/></th>
                            <th width="16%" class="p-l-6"><@spring.message "system.log.TableOperation"/></th>
                            <th width="16%" class="p-l-6"><@spring.message "system.log.TableIP"/></th>
                            <th width="25%" class="p-l-6"><@spring.message "system.log.TableUrl"/></th>
                            <th width="20%" class="p-l-6"><@spring.message "system.log.TableTime"/></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list page.data as log>
                        <tr>
                            <td>
                            ${log.operator}
                            </td>
                            <td>
                            ${log.operationCode}
                            </td>
                            <td>
                                <@spring.message "${log.operationCode}"></@spring.message>
                            </td>
                            <td>
                            ${log.ip}
                            </td>
                            <td>
                            ${log.url}
                            </td>
                            <td>
                                <i class="icon wb-time"></i>&nbsp;
                            ${log.operateTime}
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                        <tfoot>
                        <#assign pageNum = ((page.rows - 1)/ page.limit)?int  + 1>
                        <tr>
                            <td colspan="3">
                            <@spring.message "system.log.TableTotal"/>
                                &nbsp;${pageNum}&nbsp;<@spring.message "system.log.TablePage"/>， ${page.rows}&nbsp;<@spring.message "system.log.TableLog"/>
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
                                                        <@spring.message "system.log.TablePrevious"/>
                                                    </span>
                                            </a>
                                        </li>
                                    <#else >
                                        <li class="page-item">
                                            <a class="page-link" href="${rc.contextPath}/logs?offset=1&limit=${page.limit}" aria-label="First">
                                                <span aria-hidden="true"><@spring.message "project.task.topPage"/></span>
                                            </a>
                                        </li>
                                        <li class="page-item">
                                            <a class="page-link"
                                               href="${rc.contextPath}/logs?offset=${page.offset - 1}&limit=${page.limit}"
                                               aria-label="Previous">
                                                <span aria-hidden="true"><@spring.message "system.log.TablePrevious"/></span>
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
                                                <a class="page-link"
                                                   href="${rc.contextPath}/logs?offset=${num}&limit=${page.limit}">
                                                ${num}
                                                </a>
                                            </li>
                                        </#if>
                                    </#list>

                                    <#if page.offset == pageNum>
                                        <li class="page-item disabled">
                                            <a class="page-link " href="javascript:void(0)" aria-label="Next">
                                                    <span aria-hidden="true">
                                                        <@spring.message "system.log.TableNext"/>
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
                                               href="${rc.contextPath}/logs?offset=${page.offset + 1}&limit=${page.limit}"
                                               aria-label="Next">
                                                    <span aria-hidden="true">
                                                        <@spring.message "system.log.TableNext"/>
                                                    </span>
                                            </a>
                                        </li>
                                        <li class="page-item">
                                            <a class="page-link"
                                               href="${rc.contextPath}/logs?offset=${pageNum}&limit=${page.limit}" aria-label="Tail">
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
                <!-- log list end -->

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