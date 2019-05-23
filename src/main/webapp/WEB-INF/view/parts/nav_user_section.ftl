<!-- 个人中心 beg -->
<li class="nav-item dropdown">
    <a class="nav-link navbar-avatar" id="btn_nav_currentUser" data-toggle="dropdown" href="#" aria-expanded="false"
       data-animation="scale-up" role="button">
              <span class="avatar avatar-online">
                <img src="${rc.contextPath}/static/img/avatar/${currentUser.avatars}" alt="${currentUser.username}">
                <i></i>
              </span>
    </a>
    <div class="dropdown-menu" role="menu">

        <a class="dropdown-item" id="btn_nav_profile" href="${rc.contextPath}/user/${currentUser.id}" role="menuitem"><i class="icon wb-user"
                                                                                                    aria-hidden="true"></i>
        <@spring.message "nav.user.profile"/>
        </a>
        <!--
        <a class="dropdown-item" href="javascript:void(0)" role="menuitem"><i class="icon wb-settings"
                                                                              aria-hidden="true"></i>
            设置</a>
        <div class="dropdown-divider" role="presentation"></div>
        -->
        <a class="dropdown-item" id="btn_nav_logout" href="${rc.contextPath}/logout" role="menuitem"><i class="icon wb-power"
                                                                                    aria-hidden="true"></i>
        <@spring.message "nav.user.logout"/></a>
    </div>
</li>
<li class="nav-item">
    <span style="float:left; padding-top: 8px; padding-right: 20px; color:#fff;">
        <#if userDetail.etRoles[0].roleValue == 1>
            <@spring.message "nav.user.role.admin"/>
        <#else >
            <@spring.message "nav.user.role.staff"/>
        </#if>
    </span>
</li>
<!-- 个人中心 end -->