<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    <title>
        <@spring.message "RemoteMobiles.Title"/>
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
                    <li class="site-menu-item active">
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
                    <li class="site-menu-item">
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
            <li class="breadcrumb-item"><a href="${rc.contextPath}/mainpage">
            <@spring.message "RemoteMobiles.Contextpath.Home"/>
            </a></li>
            <li class="breadcrumb-item">
            <@spring.message "RemoteMobiles.Contextpath.Title"/>
            </li>
        </ol>
    </div>
    <div class="page-content">
        <!-- 设备筛选 beg-->
        <div class="panel">
            <div class="panel-heading">
                <h3 class="panel-title">
                <@spring.message "RemoteMobiles.MobileFilter"/>
                </h3>
                <div class="panel-actions">
                    <a class="panel-action icon wb-minus" data-toggle="panel-collapse" aria-expanded="true"
                       aria-hidden="true"></a>
                </div>
            </div>
            <div class="panel-body p-b-20">
                <!-- 筛选区 beg -->
                <div class="row">
                    <div class="col-md-12 col-lg-12" id="filterContent">
                    </div>
                </div>
                <!-- 筛选区 end -->
            </div>
        </div>
        <!-- 设备筛选 end-->

        <!-- 设备 beg-->
        <div class="row" id="mobileContent">

        </div>
        <!-- 设备 end-->

        <!-- 分页 beg -->

        <div class="row">
            <div class="col-md-3 col-lg-3">
                <span class="inline-block p-10" style=" margin-top: 1rem;">
                    <@spring.message "system.mobile.TableTotal"/><span id="mobiles_num"></span><@spring.message "system.mobile.TableMobile"/>
                </span>
            </div>
            <!--
            <div class="col-xs-12 col-md-9 col-lg-9">
                <nav>
                    <ul class="pagination pagination-gap pagination-sm">
                        <li class="disabled page-item">
                            <a class="page-link" href="javascript:void(0)" aria-label="Previous">
                                <span aria-hidden="true">上一页</span>
                            </a>
                        </li>
                        <li class="active page-item"><a class="page-link" href="javascript:void(0)">1 <span
                                class="sr-only">(current)</span></a></li>
                        <li class="page-item"><a class="page-link" href="javascript:void(0)">2</a></li>
                        <li class="page-item"><a class="page-link" href="javascript:void(0)">3</a></li>
                        <li class="page-item"><a class="page-link" href="javascript:void(0)">4</a></li>
                        <li class="page-item"><a class="page-link" href="javascript:void(0)">5</a></li>
                        <li class="page-item">
                            <a class="page-link" href="javascript:void(0)" aria-label="Next">
                                <span aria-hidden="true">下一页</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
            -->
        </div>
        <!-- 分页 end -->

        <!-- 调试 modal beg -->
        <div class="modal fade modal-3d-sign" id="rmobile_tiaoshi_modal" aria-hidden="true"
             data-tiaoshi-time="1"
             aria-labelledby="exampleModalTitle" role="dialog" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                        <h4 class="modal-title"><@spring.message "RemoteMobiles.Panel.Title"/></h4>
                    </div>
                    <div class="modal-body">
                        <div class="row p-y-10">
                            <div class="col-md-3 col-lg-3">
                            <@spring.message "RemoteMobiles.Panel.Mobile"/>
                            </div>
                            <div id="cur_mobilename" class="col-md-9 col-lg-9">

                            </div>
                        </div>
                        <div class="row p-y-10">
                            <div class="col-md-3 col-lg-3">
                            <@spring.message "RemoteMobiles.Panel.Time"/>
                            </div>
                            <div class="col-md-9 col-lg-9">
                                <form id="tiaoshi_form">
                                    <div class="inline-block tiaoshi_time_radio" data-tiaoshi-time="1">
                                        <input type="radio" class="icheckbox-primary" id="tiaoshi_time_lentth_1"
                                               name="tiaoshi_time" value="1"
                                               data-plugin="iCheck" data-radio-class="iradio_flat-blue"
                                               checked
                                        />
                                        <label class="m-l-5" for="tiaoshi_time_lentth_1">
                                        <@spring.message "RemoteMobiles.Panel.Three"/>
                                        </label>
                                    </div>
                                    <div class="inline-block m-l-15 tiaoshi_time_radio" data-tiaoshi-time="2">
                                        <input type="radio" class="icheckbox-primary tiaoshi_time_radio" id="tiaoshi_time_lentth_2"
                                               name="tiaoshi_time" value="2"
                                               data-plugin="iCheck" data-radio-class="iradio_flat-blue"
                                        />
                                        <label class="m-l-5" for="tiaoshi_time_lentth_2">
                                        <@spring.message "RemoteMobiles.Panel.Four"/>
                                        </label>
                                    </div>
                                    <div class="inline-block m-l-15 tiaoshi_time_radio" data-tiaoshi-time="3">
                                        <input type="radio" class="icheckbox-primary " id="tiaoshi_time_lentth_3"
                                               name="tiaoshi_time" value="3"
                                               data-plugin="iCheck" data-radio-class="iradio_flat-blue"
                                        />
                                        <label class="m-l-5" for="tiaoshi_time_lentth_3">
                                        <@spring.message "RemoteMobiles.Panel.Six"/>
                                        </label>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div id="tiaoshi_warning" class="row animate animation-slide-top" style="display: none;">
                            <div class="offset-md-3 col-md-9 col-lg-9">
                                <span class="red-700"><i class="icon wb-warning"></i> 请先选择时长</span>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">
                        <@spring.message "RemoteMobiles.Panel.Cancel"/>
                        </button>
                        <button type="button" class="btn btn-primary" id="btn_rmobileStart">
                        <@spring.message "RemoteMobiles.Panel.Remote"/>
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <!-- 调试 modal end -->
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
    Config.set('assets', '${rc.contextPath}/static/assets');
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
<script src="${rc.contextPath}/static/js/common/jquery.i18n.properties.js"></script>
<script src="${rc.contextPath}/static/js/common/i18n_setting.js"></script>

<script src="${rc.contextPath}/static/js/realmobile/realmobile_library.js"></script>
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