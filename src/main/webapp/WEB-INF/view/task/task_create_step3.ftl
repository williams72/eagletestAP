<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    <title>
    <@spring.message "project.createthree.title"/>
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
<!-- include ie jianrong beg -->
<#include "/other/ie8_incompatible.ftl">
<!-- include ie jianrong end -->
<!-- include createTaskNavHeader.ftl beg -->
<#include "/task/task_create_nav.ftl"/>
<!-- include createTaskNavHeader.ftl end -->
<!-- Page -->
<div class="page" style="margin-left:0px;">
    <div class="page-content p-t-15 container-fluid">
        <div class="page-header" style="padding:0px 0px 10px 0px;">
            <!--<h1 class="page-title">Page Title</h1>-->
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${rc.contextPath}/mainpage">
                <@spring.message "project.createthree.ContextpathHome"/>
                </a></li>
                <li class="breadcrumb-item"><a href="${rc.contextPath}/project/${currentProject.id}">${currentProject.projectName}</a></li>
                <li class="breadcrumb-item active">
                <@spring.message "project.createthree.ContextpathTitle"/>
                </li>
            </ol>
        </div>
        <!-- create task beg-->
        <div class="panel m-b-0">
            <header class="panel-heading">
                <div class="panel-title">
                <@spring.message "project.createthree.TableTitle"/>
                </div>
            </header>
            <div class="panel-body h-450">
                <div class="pearls row">
                    <div class="pearl done col-xs-4">
                        <span class="pearl-number">1</span>
                        <span class="pearl-title"><@spring.message "project.createthree.Onestep"/></span>
                    </div>
                    <div class="pearl done col-xs-4">
                        <span class="pearl-number">2</span>
                        <span class="pearl-title"><@spring.message "project.createthree.Twostep"/></span>
                    </div>
                    <div class="pearl done col-xs-4">
                        <span class="pearl-number">3</span>
                        <span class="pearl-title"><@spring.message "project.createthree.Threestep"/></span>
                    </div>
                </div>
                <!-- fenge -->
                <div class="row" style="border-top:1px dashed #8796a4; margin:20px 0px;"></div>
                <div class="row">
                    <div class="col-lg-8 offset-lg-3">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="">
                                    <h3 class=""><i class="icon wb-emoticon"></i>
                                    <@spring.message "project.createthree.Message"/>
                                    </h3>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <table class="">
                                    <thead>
                                    <tr>
                                        <td colspan="2">
                                            <i class="icon wb-order"></i> <@spring.message "project.createthree.Task"/>
                                        </td>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td><@spring.message "project.createthree.Taskname"/>&nbsp;</td>
                                        <td>${newTask.taskName}</td>
                                    </tr>
                                    <tr>
                                        <td><@spring.message "project.createthree.Build"/>&nbsp;</td>
                                        <td>${newTask.etApp.appName}/${newTask.etApp.etVersion.versionName}</td>
                                    </tr>
                                    <tr>
                                        <td><@spring.message "project.createthree.CreateTime"/>&nbsp;</td>
                                        <td>${newTask.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                                    </tr>
                                    <tr>
                                        <td><@spring.message "project.createthree.Infomation"/>&nbsp;</td>
                                        <td>
                                            <a href="${rc.contextPath}/project/${currentProject.id}/tasks"><@spring.message "project.createthree.Link"/></a>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <!-- create task end-->
    </div>
</div>
<!-- End Page -->
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