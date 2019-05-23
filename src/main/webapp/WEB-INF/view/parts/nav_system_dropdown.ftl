<#list userDetail.etRoles as role>
    <#if role.roleValue == 1>
    <li class="nav-item dropdown">
        <a class="nav-link" id="btn_nav_sysManage" data-toggle="dropdown" href="#" aria-expanded="false" data-animation="fade"
           role="button"><@spring.message "nav.system.management"/>
            <i class="icon wb-chevron-down-mini" aria-hidden="true"></i>
        </a>
        <div class="dropdown-menu" role="menu">
            <a class="dropdown-item" id="btn_nav_sysMobile" href="${rc.contextPath}/mobiles" role="menuitem"><i
                    class="icon wb-mobile"
                    aria-hidden="true"></i>
                <@spring.message "nav.system.mobiles"/></a>
            <a class="dropdown-item" id="btn_nav_sysProject" href="${rc.contextPath}/projects" role="menuitem"><i
                    class="icon wb-list"
                    aria-hidden="true"></i>
                <@spring.message "nav.system.projects"/></a>
            <a class="dropdown-item" id="btn_nav_sysUser" href="${rc.contextPath}/users" role="menuitem"><i
                    class="icon wb-users"
                    aria-hidden="true"></i>
                <@spring.message "nav.system.users"/></a>
            <a class="dropdown-item" id="btn_nav_sysLib" href="${rc.contextPath}/python/libraries" role="menuitem"><i
                    class="icon wb-library"
                    aria-hidden="true"></i>
                <@spring.message "nav.system.python.libraries"/></a>

            <div class="dropdown-divider"></div>
            <a class="dropdown-item" id="btn_nav_sysLog" href="${rc.contextPath}/logs" role="menuitem"><i
                    class="icon wb-order"
                    aria-hidden="true"></i>
                <@spring.message "nav.system.logs"/></a>
            <a class="dropdown-item" id="btn_nav_sysSetting" href="${rc.contextPath}/setting" role="menuitem"><i
                    class="icon wb-settings"
                    aria-hidden="true"></i>
                <@spring.message "nav.system.settings"/></a>
        </div>
    </li>
        <#break >
    </#if>
</#list>