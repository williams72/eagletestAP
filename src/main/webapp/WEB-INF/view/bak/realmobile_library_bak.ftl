<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    <title>真机调试</title>
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
<#include "/realmobile/realmobile_nav_side.ftl">
<!-- include header nav and left site menu  end -->
<!-- Page -->
<div class="page">
    <div class="page-header p-t-10 p-b-10">
        <!--<h1 class="page-title">Page Title</h1>-->
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="../index.html">锐测盒子</a></li>
            <li class="breadcrumb-item"><a href="../index.html">真机调试</a></li>
            <li class="breadcrumb-item active">真机库</li>
        </ol>
    </div>
    <div class="page-content">
        <!-- 设备筛选 beg-->
        <div class="panel">
            <div class="panel-heading">
                <h3 class="panel-title">设备筛选</h3>
                <div class="panel-actions">
                    <a class="panel-action icon wb-minus" data-toggle="panel-collapse" aria-expanded="true"
                       aria-hidden="true"></a>
                </div>
            </div>
            <div class="panel-body p-b-20">
                <!-- 筛选区 beg -->
                <div class="row">
                    <div class="col-md-12 col-lg-12">
                        <div class="row" style="margin-top:10px; border-bottom:1px dashed #8796a4; padding-bottom:5px;">
                            <div class="col-xs-12 col-md-2 col-lg-1">
                                <button type="button" class="btn btn-primary btn-xs">品牌</button>
                            </div>
                            <div class="col-xs-12 col-md-10 col-lg-10">
                                <#list realmobiles.filter[0].options as rm_brand>
                                <div style="margin:0px 5px" class="inline">
                                    <input type="checkbox" class="icheckbox-primary" id="brand[0]"
                                           name="inputiCheckColorCheckboxes"
                                           data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                                    <label for="brand[0]" style="margin-left:5px;">${rm_brand}</label>
                                </div>
                                </#list>
                            </div>
                        </div>
                        <div class="row" style="margin-top:10px; border-bottom:1px dashed #8796a4; padding-bottom:5px;">
                            <div class="col-xs-12 col-md-2 col-lg-1">
                                <button type="button" class="btn btn-primary btn-xs">系统版本</button>
                            </div>
                            <div class="col-xs-12 col-md-10 col-lg-10">
                                <#list realmobiles.filter[1].options as rm_os>
                                <div style="margin:0px 5px" class="inline">
                                    <input type="checkbox" class="icheckbox-primary" id="os[0]"
                                           name="inputiCheckColorCheckboxes"
                                           data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                                    <label for="os[0]" style="margin-left:5px;">${rm_os}</label>
                                </div>
                                </#list>
                            </div>
                        </div>
                        <div class="row" style="margin-top:10px; border-bottom:1px dashed #8796a4; padding-bottom:5px;">
                            <div class="col-xs-12 col-md-2 col-lg-1">
                                <button type="button" class="btn btn-primary btn-xs">状态</button>
                            </div>
                            <div class="col-xs-12 col-md-10 col-lg-10">
                                <#list realmobiles.filter[2].options as rm_status>
                                <div style="margin:0px 5px" class="inline">
                                    <input type="checkbox" class="icheckbox-primary" id="status[0]"
                                           name="inputiCheckColorCheckboxes"
                                           data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                                    <label for="status[0]" style="margin-left:5px;">${rm_status}</label>
                                </div>
                                </#list>
                            </div>
                        </div>
                        <div class="row" style="margin-top:10px; border-bottom:1px dashed #8796a4; padding-bottom:5px;">
                            <div class="col-xs-12 col-md-2 col-lg-1">
                                <button type="button" class="btn btn-primary btn-xs">分辨率</button>
                            </div>
                            <div class="col-xs-12 col-md-10 col-lg-10">
                                <#list realmobiles.filter[3].options as rm_fenbianlv>
                                <div style="margin:0px 5px" class="inline">
                                    <input type="checkbox" class="icheckbox-primary" id="fenbianlv[0]"
                                           name="inputiCheckColorCheckboxes"
                                           data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                                    <label for="fenbianlv[0]" style="margin-left:5px;">${rm_fenbianlv}</label>
                                </div>
                                </#list>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 筛选区 end -->
            </div>
        </div>
        <!-- 设备筛选 end-->

        <!-- 设备 beg-->
        <div class="row">
            <#list realmobiles.mobile as rmobile>
            <!-- 每个设备 beg 可用-->
            <div class="col-xs-4 col-md-3 col-lg-2">
                <div class="panel panel-bordered">
                    <div class="panel-heading" style="padding:3px;">
                        <#if rmobile.status == "空闲">
                            <!-- 设备可用 -->
                            <i title="该设备可用" class="icon wb-unlock m-l-10 inline-block"></i>
                        <#else >
                            <!-- 设备不可用 -->
                            <i title="该设备已被占用" style="color:#FF5200;" class="icon wb-lock m-l-10"></i>
                        </#if>
                        <span class="m-l-15">
                            ${rmobile.name}
                        </span>
                    </div>
                    <div class="panel-body" style="height: 180px; padding:5px; overflow: hidden;">
                        <figure class="overlay overlay-hover">
                            <img class="overlay-figure" src="${rmobile.screen_shot_url}" style="width:100%;"
                                 onerror="this.src='${rc.contextPath}/satic/img/phonenopage.png'"
                                 alt="...">
                            <figcaption class="overlay-panel overlay-background overlay-fade p-5 font-size-12">
                                <p class="m-y-10">${rmobile.model}</p>
                                <p class="m-y-10">${rmobile.resolution}</p>
                                <p class="m-y-10">${rmobile.os}</p>
                                <p class="m-y-10">当前执行：${rmobile.curentTask}</p>
                            </figcaption>
                        </figure>
                    </div>
                    <div class="panel-footer" style="padding:5px;">
                        <div style="width:100%;" class="btn-group btn-group-xs" aria-label="Extra-small button group"
                             role="group">
                            <button data-serialNumber="${rmobile.serial_number}"
                                    data-mobilename="${rmobile.name}"
                                    style="width:100%;" type="button"
                                    class="btn btn-success rmobile_tiaoshi"
                                    <#if rmobile.status == "占用">disabled</#if>
                                    >
                                开始调试
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 每个设备 end -->
            </#list>
        </div>
        <!-- 设备 end-->

        <!-- 分页 beg -->
        <div class="row">
            <div class="col-md-3 col-lg-3">
                <span class="inline-block p-10" style=" margin-top: 1rem;">
                    共<span id="mobiles_num"></span>部手机
                </span>
            </div>
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
                        <h4 class="modal-title">选择调试时长</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row p-y-10">
                            <div class="col-md-3 col-lg-3">
                                当前选择手机：
                            </div>
                            <div id="cur_mobilename" class="col-md-9 col-lg-9">

                            </div>
                        </div>
                        <div class="row p-y-10">
                            <div class="col-md-3 col-lg-3">
                                选择时长：
                            </div>
                            <div class="col-md-9 col-lg-9">
                                <form id="tiaoshi_form">
                                    <div class="inline-block tiaoshi_time_radio" data-tiaoshi-time="1">
                                        <input type="radio" class="icheckbox-primary" id="tiaoshi_time_lentth_1"
                                               name="tiaoshi_time" value="1"
                                               data-plugin="iCheck" data-radio-class="iradio_flat-blue"
                                        />
                                        <label class="m-l-5" for="tiaoshi_time_lentth_1">30 分钟</label>
                                    </div>
                                    <div class="inline-block m-l-15 tiaoshi_time_radio" data-tiaoshi-time="2">
                                        <input type="radio" class="icheckbox-primary tiaoshi_time_radio" id="tiaoshi_time_lentth_2"
                                               name="tiaoshi_time" value="2"
                                               data-plugin="iCheck" data-radio-class="iradio_flat-blue"
                                        />
                                        <label class="m-l-5" for="tiaoshi_time_lentth_2">45 分钟</label>
                                    </div>
                                    <div class="inline-block m-l-15 tiaoshi_time_radio" data-tiaoshi-time="3">
                                        <input type="radio" class="icheckbox-primary " id="tiaoshi_time_lentth_3"
                                               name="tiaoshi_time" value="3"
                                               data-plugin="iCheck" data-radio-class="iradio_flat-blue"
                                        />
                                        <label class="m-l-5" for="tiaoshi_time_lentth_3">60 分钟</label>
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
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-primary" id="rmobile_start">开始调试</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- 调试 modal end -->
    </div>
</div>
<!-- End Page -->
<input type="hidden" id="baseUrl" baseUrl="${rc.contextPath}"/>
<!-- Footer -->
<footer class="site-footer">
    <div class="site-footer-legal">© 2016 <a
            href="http://themeforest.net/item/remark-responsive-bootstrap-admin-template/11989202">Remark</a></div>
    <div class="site-footer-right">
        Crafted with <i class="red-600 wb wb-heart"></i> by <a href="http://themeforest.net/user/amazingSurge">amazingSurge</a>
    </div>
</footer>
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