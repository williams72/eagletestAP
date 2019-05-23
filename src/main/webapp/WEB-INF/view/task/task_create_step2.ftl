<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    <title>
    <@spring.message "project.createtwo.title"/>
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

    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/icheck/icheck.css">
    <!-- datatables beg -->
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/datatables-bootstrap/dataTables.bootstrap.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/datatables-fixedheader/dataTables.fixedHeader.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/datatables-responsive/dataTables.responsive.css">
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
                <@spring.message "project.createtwo.ContextpathHome"/>
                </a></li>
                <li class="breadcrumb-item"><a href="${rc.contextPath}/project/${currentProject.id}">${currentProject.projectName}</a></li>
                <li class="breadcrumb-item active">
                <@spring.message "project.createtwo.ContextpathTitle"/>
                </li>
            </ol>
        </div>
        <!-- create task beg-->
        <div class="panel m-b-0">
            <header class="panel-heading">
                <div class="panel-title">
                    <i class="icon wb-add-file"></i>
                <@spring.message "project.createtwo.TableTitle"/>
                </div>
            </header>
            <div class="panel-body">

                <div class="pearls row">
                    <div class="pearl done col-xs-4 m-b-30">
                        <span class="pearl-number">1</span>
                        <span class="pearl-title"><@spring.message "project.createtwo.Onestep"/></span>
                    </div>
                    <div class="pearl current col-xs-4">
                        <span class="pearl-number">2</span>
                        <span class="pearl-title"><@spring.message "project.createtwo.Twostep"/></span>
                    </div>
                    <div class="pearl col-xs-4">
                        <span class="pearl-number">3</span>
                        <span class="pearl-title"><@spring.message "project.createtwo.Threestep"/></span>
                    </div>
                </div>
                <!-- fenge -->
                <div class="row" style="border-top:1px dashed #8796a4; margin:20px 0px;"></div>
                <!-- 筛选区 beg -->
                <!--
                <h5 class="m-b-15">
                    <i class="icon wb-order"></i>&nbsp;
                <@spring.message "project.createtwo.MobileFilter"/>
                </h5>
                -->
                <!--
                <div id="filters">
                    暂时隐藏掉
                </div>
                -->
                <!--
                <div class="row m-x-0" style="margin-top:10px; border-bottom:1px dashed #8796a4; padding-bottom:5px;">
                    <div class="col-xs-12 col-md-2 col-lg-1">
                        <button type="button" class="btn btn-primary btn-xs">品牌</button>
                    </div>
                    <div class="col-xs-12 col-md-10 col-lg-10">
                        <div style="margin:0px 5px" class="inline filterItem">
                            <input type="checkbox" class="icheckbox-primary" id="brand[0]"
                                   name="inputiCheckColorCheckboxes"
                                   data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                            <label for="brand[0]" style="margin-left:5px;">全部</label>
                        </div>
                        <div style="margin:0px 5px" class="inline">
                            <input type="checkbox" class="icheckbox-primary" id="brand[1]"
                                   name="inputiCheckColorCheckboxes"
                                   data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                            <label for="brand[1]" style="margin-left:5px;">华为</label>
                        </div>
                        <div style="margin:0px 5px" class="inline">
                            <input type="checkbox" class="icheckbox-primary" id="brand[2]"
                                   name="inputiCheckColorCheckboxes"
                                   data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                            <label for="brand[2]" style="margin-left:5px;">苹果</label>
                        </div>
                        <div style="margin:0px 5px" class="inline">
                            <input type="checkbox" class="icheckbox-primary" id="brand[3]"
                                   name="inputiCheckColorCheckboxes"
                                   data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                            <label for="brand[3]" style="margin-left:5px;">中兴</label>
                        </div>
                    </div>
                </div>
                <div class="row m-x-0" style="margin-top:10px; border-bottom:1px dashed #8796a4; padding-bottom:5px;">
                    <div class="col-xs-12 col-md-2 col-lg-1">
                        <button type="button" class="btn btn-primary btn-xs">系统版本</button>
                    </div>
                    <div class="col-xs-12 col-md-10 col-lg-10">
                        <div style="margin:0px 5px" class="inline">
                            <input type="checkbox" class="icheckbox-primary" id="os[0]"
                                   name="inputiCheckColorCheckboxes"
                                   data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                            <label for="os[0]" style="margin-left:5px;">全部</label>
                        </div>
                        <div style="margin:0px 5px" class="inline">
                            <input type="checkbox" class="icheckbox-primary" id="os[1]"
                                   name="inputiCheckColorCheckboxes"
                                   data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                            <label for="os[1]" style="margin-left:5px;">Android 5.0</label>
                        </div>
                        <div style="margin:0px 5px" class="inline">
                            <input type="checkbox" class="icheckbox-primary" id="os[2]"
                                   name="inputiCheckColorCheckboxes"
                                   data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                            <label for="os[2]" style="margin-left:5px;">Android 6.0</label>
                        </div>
                    </div>
                </div>
                <div class="row m-x-0" style="margin-top:10px; border-bottom:1px dashed #8796a4; padding-bottom:5px;">
                    <div class="col-xs-12 col-md-2 col-lg-1">
                        <button type="button" class="btn btn-primary btn-xs">状态</button>
                    </div>
                    <div class="col-xs-12 col-md-10 col-lg-10">
                        <div style="margin:0px 5px" class="inline">
                            <input type="checkbox" class="icheckbox-primary" id="status[0]"
                                   name="inputiCheckColorCheckboxes"
                                   data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                            <label for="status[0]" style="margin-left:5px;">全部</label>
                        </div>
                        <div style="margin:0px 5px" class="inline">
                            <input type="checkbox" class="icheckbox-primary" id="status[1]"
                                   name="inputiCheckColorCheckboxes"
                                   data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                            <label for="status[1]" style="margin-left:5px;">空闲</label>
                        </div>
                        <div style="margin:0px 5px" class="inline">
                            <input type="checkbox" class="icheckbox-primary" id="status[2]"
                                   name="inputiCheckColorCheckboxes"
                                   data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                            <label for="status[2]" style="margin-left:5px;">使用中</label>
                        </div>
                    </div>
                </div>
                <div class="row m-x-0" style="margin-top:10px; border-bottom:1px dashed #8796a4; padding-bottom:5px;">
                    <div class="col-xs-12 col-md-2 col-lg-1">
                        <button type="button" class="btn btn-primary btn-xs">分辨率</button>
                    </div>
                    <div class="col-xs-12 col-md-10 col-lg-10">
                        <div style="margin:0px 5px" class="inline">
                            <input type="checkbox" class="icheckbox-primary" id="fenbianlv[0]"
                                   name="inputiCheckColorCheckboxes"
                                   data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                            <label for="fenbianlv[0]" style="margin-left:5px;">全部</label>
                        </div>
                        <div style="margin:0px 5px" class="inline">
                            <input type="checkbox" class="icheckbox-primary" id="fenbianlv[1]"
                                   name="inputiCheckColorCheckboxes"
                                   data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                            <label for="fenbianlv[1]" style="margin-left:5px;">1920*1080</label>
                        </div>
                        <div style="margin:0px 5px" class="inline">
                            <input type="checkbox" class="icheckbox-primary" id="fenbianlv[2]"
                                   name="inputiCheckColorCheckboxes"
                                   data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                            <label for="fenbianlv[2]" style="margin-left:5px;">1280*720</label>
                        </div>
                    </div>
                </div>
                -->
                <!-- 筛选区 end -->
                <!-- fenge
                <div class="row" style="border-top:1px dashed #8796a4; margin:20px 0px;"></div>
                -->
                <h5 class="m-b-15 m-t-30">
                    <i class="icon wb-mobile"></i>&nbsp;
                <@spring.message "project.createtwo.MobileSelect"/>
                </h5>

                <div class="row">
                    <div class="col-md-6 col-lg-6">
                        <div class="row">
                            <div class="col-md-12 col-lg-12">
                                <h6><@spring.message "project.createtwo.Enable"/></h6>
                            </div>
                        </div>
                        <div class="h-450" data-plugin="scrollable">
                            <div data-role="container">
                                <div data-role="content">
                                    <form id="step2_form" action="${rc.contextPath}/project/${currentProject.id}/createtask_3" method="post">
                                        <div id="mobiles">

                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-6">
                        <div class="row">
                            <div class="col-md-12 col-lg-12">
                                <h6><@spring.message "project.createtwo.Selected"/> <span id="yixuan_num" class="tag tag-pill tag-primary">0</span> </h6>
                            </div>
                        </div>
                        <div class="h-450" data-plugin="scrollable">
                            <div data-role="container">
                                <div id="yixuan_content" data-role="content">
                                    <!-- 每个品牌 beg-->
                                    <!--
                                    <div id="yixuan_huawei" class="p-b-5 m-b-5 .yixuan_brand">
                                        <div class="row">
                                            <div class="col-xs-12 col-md-12 col-lg-12">
                                                <span id="yixuan_huawei_title" class="tag tag-primary tag-round">
                                                    华为
                                                    <i id="yixuan_huawei_num">1</i>
                                                </span>
                                            </div>
                                        </div>
                                        <div class="row m-t-10">
                                            <div id="yixuan_huawei_content" class="col-xs-12 col-md-12 col-lg-12 .yixuan_brand_content">
                                                <div style="margin:0px 5px" class="inline-block">
                                                    <input type="checkbox" class="icheckbox-primary"
                                                           id="yixuan_huawei_id" name="inputiCheckColorCheckboxes"
                                                           data-plugin="iCheck"
                                                           data-checkbox-class="icheckbox_flat-blue" checked/>
                                                    <label for="yixuan_huawei_id" style="margin-left:5px;">华为
                                                        mate7</label>
                                                </div>
                                            </div>
                                        </div>2
                                    </div>
                                    -->
                                    <!-- 每个品牌 end -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row" style="margin-top:10px;">
                    <div class="pull-xs-right m-r-80">
                        <button id="step2_submit" type="button" class="btn btn-primary ladda-button" data-style="slide-right"
                                data-plugin="ladda">
                            <span class="ladda-label"><@spring.message "project.createtwo.Next"/><i class="icon wb-arrow-right m-l-10"
                                                            aria-hidden="true"></i></span>
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <!-- create task end-->
    </div>
</div>
<!-- End Page -->

<input type="hidden" id="baseUrl" baseUrl="${rc.contextPath}"/>
<input type="hidden" id="engine" engine="${engine}"/>
<input type="hidden" id="projectType" os="${projectType}"/>

<!-- Footer -->
<#include "/parts/footer_all.ftl">
<!-- Core  -->
<script src="${rc.contextPath}/static/global/vendor/babel-external-helpers/babel-external-helpers.js"></script>
<script src="${rc.contextPath}/static/global/vendor/jquery/jquery.js"></script>
<script src="${rc.contextPath}/static/global/vendor/tether/tether.js"></script>
<script src="${rc.contextPath}/static/global/vendor/bootstrap/bootstrap.js"></script>
<script src="${rc.contextPath}/static/global/vendor/bootstrap-sweetalert/sweetalert.js"></script>
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
    Config.set('assets', '${rc.contextPath}/static/assets');
</script>
<!-- Page -->
<script src="${rc.contextPath}/static/assets/js/Site.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/asscrollable.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/slidepanel.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/switchery.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/datatables.js"></script>
<script src="${rc.contextPath}/static/js/datatable.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/input-group-file.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/ladda.js"></script>

<script src="${rc.contextPath}/static/global/js/Plugin/icheck.js"></script>

<script src="${rc.contextPath}/static/js/common/jquery.i18n.properties.js"></script>
<script src="${rc.contextPath}/static/js/common/i18n_setting.js"></script>
<script src="${rc.contextPath}/static/js/task/task_create_step2.js"></script>

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