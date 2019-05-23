<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    <title>
        <@spring.message "weaknet.page.title"/>
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
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/bootstrap-select/bootstrap-select.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/css/toastr.css">

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

<!-- sysNavHeader.ftl include beg -->
<#include "/system/sys_nav.ftl">
<!-- sysNavHeader.ftl include end -->

<!-- sys_setting_weaknet_side beg -->
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

                    <li class="site-menu-item">
                        <a href="${rc.contextPath}/logs" id="btn_side_log">
                            <i class="site-menu-icon wb-order" aria-hidden="true"></i>
                            <span class="site-menu-title"><@spring.message "system.leftMenu.log"/></span>
                        </a>
                    </li>
                    <li class="site-menu-item has-sub open active">
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
                            <li class="site-menu-item active">
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
<!-- sys_setting_weaknet_side end -->

<!-- Page -->
<div class="page">
    <div class="page-header p-t-10 p-b-10">
        <!--<h1 class="page-title">Page Title</h1>-->
        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <a href="${rc.contextPath}/mainpage"><@spring.message "system.setting.breadcrumb.title"/></a>
            </li>
            <li class="breadcrumb-item active">
            <@spring.message "system.setting.title"/>
            </li>
            <li class="breadcrumb-item active">
            <@spring.message "system.setting.breadcrumb.network"/>
            </li>
        </ol>
    </div>
    <div class="page-content">
        <div class="panel">
            <div class="panel-heading">
                <h3 class="panel-title"><@spring.message "weaknet.page.content.title"/></h3>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-12 col-lg-12">
                        <!--
                        <button id="weaknet_add_btn"
                                class="btn btn-primary btn-sm"
                                data-toggle="modal"
                                data-target="#weaknet_add_modal">
                            <i class="icon wb-plus"></i>
                            <@spring.message "weaknet.page.content.btn.add"/>
                        </button>
                        -->
                    </div>
                </div>
                <!-- 弱网列表 beg -->
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <th>
                        <@spring.message "weaknet.page.content.table.col.name"/>
                        </th>
                        <th>
                        <@spring.message "weaknet.page.content.table.col.desc"/>
                        </th>
                        <th>
                        <@spring.message "weaknet.page.content.table.col.status"/>
                        </th>
                        <!--
                        <th>
                        <@spring.message "weaknet.page.content.table.col.setting"/>
                        </th>
                        -->
                        </thead>
                        <tbody>
                        <#list page.data as weaknet>
                        <tr>
                            <#if weaknet.sysdefault>
                                <td>
                                    <@spring.message "weaknet.type.default.${weaknet.key}.name"/>
                                </td>
                                <td>
                                    <@spring.message "weaknet.type.default.${weaknet.key}.desc"/>
                                </td>
                            <#else >
                                <td>
                                    ${weaknet.name}
                                </td>
                                <td>
                                    ${weaknet.desc}
                                </td>
                            </#if>

                            <td>
                                <input type="checkbox"
                                       class="weaknet_enable_switch"
                                       data-weaknetid="${weaknet.id}"
                                       data-plugin="switchery"
                                       data-size="small"
                                       <#if weaknet.enable>
                                       checked
                                       </#if>
                                />
                            </td>
                            <!--
                            <td>
                                <#if !weaknet.sysdefault>
                                <a href="javascript:void(0);"
                                   data-weaknetid="${weaknet.id}"
                                   class="weaknet_edit btn btn-sm btn-icon btn-pure btn-default p-0 m-r-10"
                                   title="<@spring.message "weaknet.page.content.table.col.edit"/>">
                                    <i class="icon wb-edit" aria-hidden="true">
                                    </i>
                                </a>
                                <a href="javascript:void(0);"
                                   data-weaknetid="${weaknet.id}"
                                   class="weaknet_remove btn btn-sm btn-icon btn-pure btn-danger p-0 m-r-10"
                                   title="<@spring.message "weaknet.page.content.table.col.remove"/>">
                                    <i class="icon wb-trash" aria-hidden="true"></i>
                                </a>
                                </#if>
                            </td>
                            -->
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
                <!-- 弱网列表 end -->
            </div>
        </div>
        <!-- 添加弱网项 modal beg -->
        <div id="weaknet_add_modal"
             class="modal fade modal-3d-sign"
             aria-hidden="true"
             aria-labelledby="exampleModalTitle"
             role="dialog"
             tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button"
                                class="close"
                                data-dismiss="modal"
                                aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                        <h4 class="modal-title">添加</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <div class="form-group row m-b-10">
                                <label class="col-xs-12 col-md-2 form-control-label">名称：</label>
                                <div class="col-md-9 col-xs-12">
                                    <input type="text"
                                           class="form-control name"
                                           data-placement="bottom-right-inside"
                                           name="name"
                                           placeholder="请输入设置项名称"
                                           autocomplete="off"
                                    />
                                </div>
                            </div>
                            <div class="row animate animation-slide-top m-y-5 usernameCheck"
                                 style="display: none;">
                                <div class="offset-md-3 col-md-9 col-lg-9">
                            <span class="red-700">
                                <i class="icon wb-warning"></i>
                                <span class="nameCheckContent">该名称已经存在</span>
                            </span>
                                </div>
                            </div>
                            <div class="form-group row m-b-10">
                                <label class="col-xs-12 col-md-2 form-control-label">描述：</label>
                                <div class="col-md-9 col-xs-12">
                              <textarea class="form-control desc"
                                        rows="3"
                                        name="desc"
                                        placeholder="请输入描述..."
                              ></textarea>
                                </div>
                            </div>
                            <div class="form-group row m-b-10">
                                <label class="col-xs-12 col-md-2 form-control-label">参数：</label>
                                <div class="col-md-9 col-xs-12">
                              <textarea class="form-control param"
                                        rows="7"
                                        name="param"
                                        placeholder="请输入参数..."
                              ></textarea>
                                </div>
                            </div>
                            <div id="" class="row animate animation-slide-top m-y-5 emailCheck" style="display: none;">
                                <div class="offset-md-3 col-md-9 col-lg-9">
                            <span class="red-700"><i class="icon wb-warning"></i>
                                <span class="emailCheckContent">参数不能为空</span>
                            </span>
                                </div>
                            </div>
                            <!--
                            <div class="form-group row m-b-10">
                                <label class="col-xs-12 col-md-3 form-control-label">是否启用：</label>
                                <div class="col-md-8 col-xs-12">
                                    <input type="checkbox"
                                           class="form-control"
                                           data-plugin="switchery"
                                           data-size="small"
                                           autocomplete="off"
                                           checked
                                    />
                                </div>
                            </div>
                            -->
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary submit">保存</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- 添加弱网项 modal end -->

        <!-- 修改弱网项 modal beg -->
        <div id="weaknet_edit_modal"
             class="modal fade modal-3d-sign"
             aria-hidden="true"
             aria-labelledby="exampleModalTitle"
             role="dialog"
             tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button"
                                class="close"
                                data-dismiss="modal"
                                aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                        <h4 class="modal-title">修改</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <div class="form-group row m-b-10">
                                <label class="col-xs-12 col-md-2 form-control-label">名称：</label>
                                <div class="col-md-9 col-xs-12">
                                    <input type="text"
                                           class="form-control name"
                                           data-placement="bottom-right-inside"
                                           name="name"
                                           placeholder="请输入设置项名称"
                                           autocomplete="off"
                                    />
                                </div>
                            </div>
                            <div class="row animate animation-slide-top m-y-5 usernameCheck"
                                 style="display: none;">
                                <div class="offset-md-3 col-md-9 col-lg-9">
                            <span class="red-700">
                                <i class="icon wb-warning"></i>
                                <span class="nameCheckContent">该名称已经存在</span>
                            </span>
                                </div>
                            </div>
                            <div class="form-group row m-b-10">
                                <label class="col-xs-12 col-md-2 form-control-label">描述：</label>
                                <div class="col-md-9 col-xs-12">
                              <textarea class="form-control desc"
                                        rows="3"
                                        name="desc"
                                        placeholder="请输入描述..."
                              ></textarea>
                                </div>
                            </div>
                            <div class="form-group row m-b-10">
                                <label class="col-xs-12 col-md-2 form-control-label">参数：</label>
                                <div class="col-md-9 col-xs-12">
                              <textarea class="form-control param"
                                        rows="7"
                                        name="param"
                                        placeholder="请输入参数..."
                              ></textarea>
                                </div>
                            </div>
                            <div id="" class="row animate animation-slide-top m-y-5 emailCheck" style="display: none;">
                                <div class="offset-md-3 col-md-9 col-lg-9">
                            <span class="red-700"><i class="icon wb-warning"></i>
                                <span class="emailCheckContent">参数不能为空</span>
                            </span>
                                </div>
                            </div>
                            <!--
                            <div class="form-group row m-b-10">
                                <label class="col-xs-12 col-md-3 form-control-label">是否启用：</label>
                                <div class="col-md-8 col-xs-12">
                                    <input type="checkbox"
                                           class="form-control"
                                           data-plugin="switchery"
                                           data-size="small"
                                           autocomplete="off"
                                           checked
                                    />
                                </div>
                            </div>
                            -->
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary submit">保存</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- 修改弱网项 modal end -->

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
<script src="${rc.contextPath}/static/global/vendor/bootstrap-select/bootstrap-select.js"></script>
<script src="${rc.contextPath}/static/global/vendor/toastr/toastr.js"></script>

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
<script src="${rc.contextPath}/static/global/js/Plugin/bootstrap-select.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/panel.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/toastr.js"></script>
<script src="${rc.contextPath}/static/js/common/jquery.i18n.properties.js"></script>
<script src="${rc.contextPath}/static/js/common/i18n_setting.js"></script>
<script src="${rc.contextPath}/static/js/system/sys_weaknet.js?v=${jsVersion}"></script>
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