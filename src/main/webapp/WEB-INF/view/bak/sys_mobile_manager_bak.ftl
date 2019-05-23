<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    <title>设备管理</title>
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
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/bootstrap-maxlength/bootstrap-maxlength.css">

    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/bootstrap-sweetalert/sweetalert.css">
    <!-- datatables beg -->
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/datatables-bootstrap/dataTables.bootstrap.css">
    <link rel="stylesheet"
          href="${rc.contextPath}/static/global/vendor/datatables-fixedheader/dataTables.fixedHeader.css">
    <link rel="stylesheet"
          href="${rc.contextPath}/static/global/vendor/datatables-responsive/dataTables.responsive.css">
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
<!-- ie8jianrong.ftl include beg -->
<#include "/other/ie8_incompatible.ftl">
<!-- ie8jianrong.ftl include end -->
<!-- sys_nav.ftl include beg -->
<#include "/system/sys_nav.ftl">
<!-- sys_nav.ftl include end -->
<!-- Page -->
<div class="page">
    <div class="page-header p-t-10 p-b-10">
        <!--<h1 class="page-title">Page Title</h1>-->
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="../index.html">系统管理</a></li>
            <li class="breadcrumb-item active">设备管理</li>
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
                            <#assign brand_num = 0>
                            <#list mobiles.filter[0].options as brand_name>
                                <#assign brand_num = brand_num + 1>
                                <div style="margin:0px 5px" class="inline">
                                    <input type="checkbox" class="icheckbox-primary" id="brand[${brand_num}]"
                                           name="inputiCheckColorCheckboxes"
                                           data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                                    <label for="brand[1]" style="margin-left:5px;">${brand_name}</label>
                                </div>
                            </#list>
                            </div>
                        </div>
                        <div class="row" style="margin-top:10px; border-bottom:1px dashed #8796a4; padding-bottom:5px;">
                            <div class="col-xs-12 col-md-2 col-lg-1">
                                <button type="button" class="btn btn-primary btn-xs">系统版本</button>
                            </div>
                            <div class="col-xs-12 col-md-10 col-lg-10">
                            <#list mobiles.filter[1].options as os_name>
                                <div style="margin:0px 5px" class="inline">
                                    <input type="checkbox" class="icheckbox-primary" id="os[0]"
                                           name="inputiCheckColorCheckboxes"
                                           data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                                    <label for="os[0]" style="margin-left:5px;">${os_name}</label>
                                </div>
                            </#list>
                            </div>
                        </div>
                        <div class="row" style="margin-top:10px; border-bottom:1px dashed #8796a4; padding-bottom:5px;">
                            <div class="col-xs-12 col-md-2 col-lg-1">
                                <button type="button" class="btn btn-primary btn-xs">状态</button>
                            </div>
                            <div class="col-xs-12 col-md-10 col-lg-10">
                            <#list mobiles.filter[2].options as status_name>
                                <div style="margin:0px 5px" class="inline">
                                    <input type="checkbox" class="icheckbox-primary" id="status[0]"
                                           name="inputiCheckColorCheckboxes"
                                           data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                                    <label for="status[0]" style="margin-left:5px;">${status_name}</label>
                                </div>
                            </#list>
                            </div>
                        </div>
                        <div class="row" style="margin-top:10px; border-bottom:1px dashed #8796a4; padding-bottom:5px;">
                            <div class="col-xs-12 col-md-2 col-lg-1">
                                <button type="button" class="btn btn-primary btn-xs">分辨率</button>
                            </div>
                            <div class="col-xs-12 col-md-10 col-lg-10">
                            <#list mobiles.filter[3].options as resolution_name>
                                <div style="margin:0px 5px" class="inline">
                                    <input type="checkbox" class="icheckbox-primary" id="fenbianlv[0]"
                                           name="inputiCheckColorCheckboxes"
                                           data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                                    <label for="fenbianlv[0]" style="margin-left:5px;">${resolution_name}</label>
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
        <#list mobiles.mobile as emobile>
            <!-- 每个设备 beg -->
            <div class="col-xs-4 col-md-3 col-lg-2">
                <div class="panel panel-bordered">
                    <div class="panel-heading p-3">
                        <#if emobile.status == "空闲">
                            <i title="该设备可用" class="icon wb-unlock m-l-10 inline-block"></i>
                        <#else >
                            <i title="该设备已被占用" style="color:#FF5200;" class="icon wb-lock m-l-10"></i>
                        </#if>
                        <span class="m-l-15">
                        ${emobile.name}
                        </span>

                        <div class="panel-actions" style="right: 0px;">
                            <a class="panel-action icon wb-edit caozuo_edit" title="自定义名称"
                               data-serialNumber="${emobile.serial_number}" data-target="#mobile_caozuo_edit"
                               data-toggle="modal"></a>
                        </div>
                    </div>
                    <div class="panel-body p-5" style="height: 180px; overflow: hidden;">
                        <figure class="overlay overlay-hover">
                            <img class="overlay-figure" src="${emobile.screen_shot_url}" style="width:100%;"
                                 onerror="this.src='${rc.contextPath}/satic/img/phonenopage.png'"
                                 alt="...">
                            <figcaption class="overlay-panel overlay-background overlay-fade p-5 font-size-12"
                                        style="background-color:rgba(0,0,0, 0.6);">
                                <p class="m-y-10">机型：${emobile.model}</p>
                                <p class="m-y-10">分辨率：${emobile.resolution}</p>
                                <p class="m-y-10">系统版本：${emobile.os}</p>
                                <p class="m-y-10">当前执行：${emobile.curentTask}</p>
                            </figcaption>
                        </figure>
                    </div>
                    <div class="panel-footer p-5">
                        <div style="width:100%;" class="btn-group btn-group-xs" aria-label="Extra-small button group"
                             role="group">
                            <button data-serialNumber="${emobile.serial_number}" style="width:40%;" type="button"
                                    data-target="#exampleNiftyFadeScale"
                                    data-toggle="modal" class="btn btn-default caozuo_chongqi">重启
                            </button>
                            <button data-serialNumber="${emobile.serial_number}" style="width:60%;"
                                    type="button" class="btn btn-default caozuo_stop"
                                    <#if emobile.status == "空闲">
                                        disabled
                                    </#if>
                            >停止任务</button>
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
                <span class="inline-block p-10" style=" margin-top: 1rem;">共${mobiles.mobile?size}部手机</span>
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
        <div class="modal fade modal-3d-sign" id="mobile_caozuo_edit" aria-hidden="true"
             aria-labelledby="exampleModalTitle" role="dialog" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                        <h4 class="modal-title">自定义设备名称</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" id="caozuo_m_form">
                            <div class="form-group row">
                                <label class="col-xs-12 col-md-3 form-control-label">名称：</label>
                                <div class="col-md-7 col-xs-12">
                                    <input id="mobile_edit_name" type="text" class="form-control maxlength-input"
                                           data-plugin="maxlength"
                                           data-placement="bottom-right-inside" maxlength="10" name="name"
                                           placeholder="请输入自定义名称" autocomplete="off"
                                    />
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" id="caozuo_m_save">保存更改</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Modal -->
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
<script src="${rc.contextPath}/static/global/vendor/bootstrap-maxlength/bootstrap-maxlength.js"></script>

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
<script src="${rc.contextPath}/static/global/js/Plugin/bootstrap-maxlength.js"></script>

<script src="${rc.contextPath}/static/global/js/Plugin/bootstrap-sweetalert.js"></script>
<script src="${rc.contextPath}/static/js/system/sys_mobile_manage.js" type="text/javascript"></script>
<!--<script>
(function(document, window, $) {
  'use strict';
  var Site = window.Site;
  $(document).ready(function() {
    Site.run();
  });
})(document, window, jQuery);
</script>-->
</body>
</html>