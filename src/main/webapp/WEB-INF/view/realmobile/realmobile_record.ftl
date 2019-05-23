<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    <title><@spring.message "rm.logs.title"/></title>
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
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/bootstrap-sweetalert/sweetalert.css">

    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/icheck/icheck.css">
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
<body class="animsition">
<!-- include header nav and left site menu  beg -->
<#include "/realmobile/realmobile_nav.ftl">
<!-- include header nav and left site menu  end -->

<!-- realmoblie_side beg -->
<div class="site-menubar">
    <div class="site-menubar-body">
        <div>
            <div>
                <ul class="site-menu" data-plugin="menu">
                    <li class="site-menu-category">
                        <h4>
                        <@spring.message "nav.mobile.test"/>
                        </h4>
                    </li>
                    <li class="site-menu-item">
                        <a href="${rc.contextPath}/realmobiles" id="btn_side_remote" >
                            <i class="site-menu-icon wb-dashboard" aria-hidden="true"></i>
                            <span class="site-menu-title"><@spring.message "RemoteMobiles.left.Mobile"/></span>
                        </a>
                    </li>
                <#list currentRms as realMobile>
                    <li class="site-menu-item">
                        <a href="${rc.contextPath}/realmobile/${realMobile.id}" id="btn_side_currentRM">
                            <i class="site-menu-icon wb-mobile" aria-hidden="true"></i>
                            <span class="site-menu-title">${realMobile.mobileName}&nbsp;&nbsp;</span>
                        </a>
                    </li>
                </#list>
                    <li class="site-menu-item active">
                        <a href="${rc.contextPath}/realmobilelogs" id="btn_side_remoteLog">
                            <i class="site-menu-icon wb-order" aria-hidden="true"></i>
                            <span class="site-menu-title">
                            <@spring.message "RemoteMobiles.left.Log"/>
                            </span>
                        </a>
                    </li>
                    <!--
                    <li class="site-menu-item">
                        <a href="javascript:void(0)">
                            <i class="site-menu-icon wb-settings" aria-hidden="true"></i>
                            <span class="site-menu-title">调试设置</span>
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
<!-- realmoblie_side end -->

<!-- Page -->
<div class="page">
<div class="page-header p-t-10 p-b-10">
    <!--<h1 class="page-title">Page Title</h1>-->
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="${rc.contextPath}/mainpage"><@spring.message "rm.logs.breadcrumb.title"/></a></li>
        <li class="breadcrumb-item"><a href="${rc.contextPath}/realmobiles"><@spring.message "rm.logs.breadcrumb.s1"/></a></li>
        <li class="breadcrumb-item active"><@spring.message "rm.logs.breadcrumb.active"/></li>
    </ol>
</div>
<div class="page-content">

    <!-- datatables beg-->
    <!-- Panel FixedHeader -->
    <div class="panel">
        <header class="panel-heading">
            <h3 class="panel-title"><i class="icon wb-order"></i> <@spring.message "rm.logs.panel.title"/></h3>
        </header>
        <div class="panel-body">
            <div class="example">
                <table class="table m-b-0">
                    <thead>
                    <tr>
                        <th>
                        <@spring.message "rm.logs.panel.list.head.name"/>
                        </th>
                        <th>
                        <@spring.message "rm.logs.panel.list.head.user"/>
                        </th>
                        <th>
                        <@spring.message "rm.logs.panel.list.head.begtime"/>
                        </th>
                        <th>
                        <@spring.message "rm.logs.panel.list.head.endtime"/>
                        </th>
                    </tr>
                    </thead>
                    <tbody >
                    <#list page.data as rmrecord>
                    <tr >
                        <td>
                        ${rmrecord.mobileName}
                        </td>
                        <td>
                            <img class="avatar avatar-xs" src="${rc.contextPath}/static/img/avatar/${rmrecord.etUser.avatars}"/>
                            ${rmrecord.etUser.email}
                        </td>
                        <td>
                            <i class="icon wb-time"></i>&nbsp;
                        ${rmrecord.beginTime}
                        </td>
                        <td>
                            <i class="icon wb-time"></i>&nbsp;
                            ${rmrecord.endTime}
                        </td>
                    </tr>
                    </#list>
                    </tbody>
                    <tfoot>
                    <#assign pageNum = ((page.rows - 1)/ page.limit)?int  + 1>
                    <tr>
                        <td colspan="3">
                        <@spring.message "rm.logs.panel.list.total"/>&nbsp; ${pageNum}&nbsp;<@spring.message "rm.logs.panel.list.page"/>， ${page.rows} &nbsp;<@spring.message "rm.logs.panel.list.item"/>
                        </td>
                        <td colspan="4" class="p-b-0">
                            <nav class="pull-xs-right">
                                <ul class="pagination pagination-sm m-0 pagination-no-border">

                                <#if page.offset == 1>
                                    <li class="page-item disabled">
                                        <a class="page-link" href="javascript:void(0)" aria-label="Previous">
                                            <span aria-hidden="true"><@spring.message "rm.logs.panel.list.Previous"/></span>
                                        </a>
                                    </li>
                                <#else >
                                    <li class="page-item">
                                        <a class="page-link" href="${rc.contextPath}/realmobilelogs?offset=${page.offset - 1}&limit=${page.limit}" aria-label="Previous">
                                            <span aria-hidden="true">
                                                <@spring.message "rm.logs.panel.list.Previous"/>
                                            </span>
                                        </a>
                                    </li>
                                </#if>
                                    </li>
                                <#list 1..pageNum as num>
                                    <#if num == page.offset>
                                        <li class="page-item active">
                                            <a class="page-link" href="javascript:void(0)">
                                            ${num}
                                            </a>
                                        </li>
                                    <#else >
                                        <li class="page-item">
                                            <a class="page-link" href="${rc.contextPath}/realmobilelogs?offset=${num}&limit=${page.limit}">
                                            ${num}
                                            </a>
                                        </li>
                                    </#if>
                                </#list>

                                <#if page.offset == pageNum>
                                    <li class="page-item disabled">
                                        <a class="page-link " href="javascript:void(0)" aria-label="Next">
                                            <span aria-hidden="true"><@spring.message "rm.logs.panel.list.Next"/></span>
                                        </a>
                                    </li>
                                <#else >
                                    <li class="page-item">
                                        <a class="page-link" href="${rc.contextPath}/realmobilelogs?offset=${page.offset + 1}&limit=${page.limit}" aria-label="Next">
                                            <span aria-hidden="true">
                                                <@spring.message "rm.logs.panel.list.Next"/>
                                            </span>
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
    <!-- End Panel FixedHeader -->
    <!-- datatables end-->
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

<script src="${rc.contextPath}/static/global/vendor/bootstrap-sweetalert/sweetalert.js"></script>
<script src="${rc.contextPath}/static/global/vendor/icheck/icheck.min.js"></script>
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
    Config.set('assets', '${rc.contextPath}/assets');
</script>
<!-- Page -->
<script src="${rc.contextPath}/static/assets/js/Site.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/asscrollable.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/slidepanel.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/switchery.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/datatables.js"></script>
<script src="${rc.contextPath}/static/js/datatable.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/panel.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/icheck.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/bootstrap-sweetalert.js"></script>

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