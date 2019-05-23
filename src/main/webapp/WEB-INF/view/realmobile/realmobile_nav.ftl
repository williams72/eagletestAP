<!--[if lt IE 8]>
<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->
<nav class="site-navbar navbar navbar-default navbar-fixed-top navbar-mega" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggler hamburger hamburger-close navbar-toggler-left hided"
                id="btn_nav_menubar_s"
                data-toggle="menubar">
            <span class="sr-only">Toggle navigation</span>
            <span class="hamburger-bar"></span>
        </button>
        <button type="button" class="navbar-toggler collapsed" id="btn_nav_more" data-target="#site-navbar-collapse"
                data-toggle="collapse">
            <i class="icon wb-more-horizontal" aria-hidden="true"></i>
        </button>
        <div class="navbar-brand navbar-brand-center " >
            <img class="navbar-brand-logo" src="${rc.contextPath}/static/img/logo-img.png" title="Remark">
            <span class="navbar-brand-text hidden-xs-down">
                <@spring.message "common.eagle.test"/>
            </span>
        </div>

    </div>
    <div class="navbar-container container-fluid">
        <!-- Navbar Collapse -->
        <div class="collapse navbar-collapse navbar-collapse-toolbar" id="site-navbar-collapse">
            <!-- Navbar Toolbar -->
            <ul class="nav navbar-toolbar">
                <li class="nav-item hidden-float" id="toggleMenubar">
                    <a class="nav-link" id="btn_nav_menubar_l" data-toggle="menubar" href="#" role="button">
                        <i class="icon hamburger web-menu">
                            <span class="sr-only">Toggle menubar</span>
                            <span class="hamburger-bar"></span>
                        </i>
                    </a>
                </li>
                <!-- 导航栏下拉  beg-->
                <!-- nav dropmenu project beg -->
                <#include "/parts/nav_project_dropdown.ftl">
                <!-- nav dropmenu project end -->
                <!-- nav dropmenu realmobile beg -->
                <#include "/parts/nav_realmobile_dropdown.ftl">
                <!-- nav dropmenu realmobile end -->

                <!-- include header nav sys item beg -->
                <#include "/parts/nav_system_dropdown.ftl">
                <!-- include header nav sys item end -->
                <!-- 导航栏下拉  end-->
            </ul>
            <!-- End Navbar Toolbar -->
            <!-- Navbar Toolbar Right -->
            <ul class="nav navbar-toolbar navbar-right navbar-toolbar-right">

                <!--帮助 beg-->
                <#include "/parts/nav_help_dropdown.ftl">
                <!--帮助 end-->

                <!-- 个人中心 beg -->
                <#include "/parts/nav_user_section.ftl">
                <!-- 个人中心 end -->
                <#--<li class="nav-item hidden-sm-down" id="toggleFullscreen">
                    <a class="nav-link icon icon-fullscreen"  id="btn_nav_fullScreen" data-toggle="fullscreen" href="#" role="button" title="全屏">
                        <span class="sr-only">Toggle fullscreen</span>
                    </a>
                </li>-->
                <li class="nav-item dropdown">
                    &nbsp;&nbsp;
                </li>

            </ul>
            <!-- End Navbar Toolbar Right -->
        </div>
        <!-- End Navbar Collapse -->

    </div>
</nav>
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

</div>