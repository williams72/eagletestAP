<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    <title>
        <@spring.message "system.pythonlib.create.title"/>
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
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/dropify/dropify.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/bootstrap-select/bootstrap-select.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/webui-popover/webui-popover.css">

    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/icheck/icheck.css">
    <!-- Fonts -->
    <link rel="stylesheet" href="${rc.contextPath}/static/global/fonts/web-icons/web-icons.min.css">
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
<!-- ie8_incompatible.ftl include beg -->
<#include "/other/ie8_incompatible.ftl">
<!-- ie8_incompatible.ftl include end -->
<!-- sys_nav.ftl include beg -->
<#include "/system/sys_nav.ftl">
<!-- sys_nav.ftl include end -->
<!-- sys_project_side beg -->
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

                    <li class="site-menu-item active">
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
</div>
<!-- sys_project_side end -->

<!-- Page -->
<div class="page">
    <div class="page-header p-t-10 p-b-10">
        <!--<h1 class="page-title">Page Title</h1>-->
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${rc.contextPath}/mainpage">
            <@spring.message "common.eagle.test"/>
            </a></li>
            <li class="breadcrumb-item"><a href="${rc.contextPath}/python/libraries">
            <@spring.message "system.pythonlib.manage.title"/>
            </a></li>
            <li class="breadcrumb-item active"><@spring.message "system.pythonlib.create.title"/></li>
        </ol>
    </div>
    <div class="page-content">
        <div class="panel">
            <div class="panel-heading">
                <h3 class="panel-title">新增Python库</h3>
            </div>
            <div class="panel-body">
                <!-- 添加lib beg -->
                <form action="" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <label class="form-control-label inline-block">
                            <!--<i class="icon wb-copy"></i>-->
                            &nbsp;新增库方式</label>
                        <span class="text-help inline-block text-xs-left">
                            <a href="#" class="btn btn-sm btn-icon btn-pure btn-default on-default"
                               data-html="true"
                               data-content="1) 上传库文件方式需将库文件打包zip上传；<br/>
                               2) pip安装方式将在服务器重启后失效；"
                               data-trigger="hover" data-toggle="popover"
                               tabindex="0">
                                <i class="icon wb-help-circle"></i>
                            </a>
                        </span>
                        <div>
                            <div class="inline-block m-r-20">
                                <input type="radio" id="radio_zip"
                                       name="visibility"
                                       class="icheckbox-primary"
                                       data-radio-class="iradio_flat-blue"
                                       data-plugin="iCheck" value="0" checked />
                                <label class="m-l-5" for="radio_zip">
                                    上传库文件方式
                                </label>
                            </div>
                            <div class="inline-block">
                                <input type="radio" id="radio_pip"
                                       name="visibility"
                                       class="icheckbox-primary"
                                       data-plugin="iCheck"
                                       data-radio-class="iradio_flat-blue"
                                       value="1" />
                                <label class="m-l-5" for="radio_pip">
                                    pip安装方式
                                </label>
                            </div>

                        </div>
                    </div>
                    <div class="form-group" id="pip_cmd_area" style="display:none;">
                        <input type="text" class="form-control" id="pip_cmd" placeholder="请输入pip安装命令"/>
                    </div>

                    <div class="form-group" id="zip_file_area">
                        <label class="col-xs-12 col-md-2 form-control-label"><i
                                class="icon wb-upload"></i>&nbsp;
                            选择库文件</label>
                        <input type="file"
                               id="script_file"
                               name="file"
                               data-allowed-file-extensions="zip"
                               data-errors-position="outside"
                               data-default-file=""
                               required/>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-12 col-md-2 col-lg-2 form-control-label"><i
                                class="icon wb-tag"></i> &nbsp;添加描述</label>
                        <input type="text" name="label" class="form-control" />
                    </div>

                    <div class="form-group">
                        <button id="btn_createAppSubmit" type="submit" class="btn btn-primary">提交</button>
                    </div>
                </form>
                <!-- 添加lib end -->
            </div>
        </div>

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
<script src="${rc.contextPath}/static/global/vendor/dropify/dropify.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/bootstrap-select/bootstrap-select.js"></script>
<script src="${rc.contextPath}/static/global/vendor/icheck/icheck.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/webui-popover/jquery.webui-popover.min.js"></script>

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
<script src="${rc.contextPath}/static/assets/js/Site.js"></script>u
<script src="${rc.contextPath}/static/global/js/Plugin/asscrollable.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/slidepanel.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/switchery.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/panel.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/dropify.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/bootstrap-select.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/icheck.js"></script>
<script src="${rc.contextPath}/static/assets/examples/js/uikit/tooltip-popover.js"></script>
<script src="${rc.contextPath}/static/js/common/jquery.i18n.properties.js"></script>
<script src="${rc.contextPath}/static/js/common/i18n_setting.js"></script>
<script src="${rc.contextPath}/static/js/system/sys_pythonlib_create.js"></script>

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