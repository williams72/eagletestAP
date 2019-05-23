<li class="nav-item dropdown">
    <a class="nav-link" id="btn_nav_realMobile" data-toggle="dropdown" href="#" aria-expanded="false" data-animation="fade"
       role="button"><@spring.message "nav.mobile.test"/>
        <i class="icon wb-chevron-down-mini" aria-hidden="true"></i>
    </a>
    <div class="dropdown-menu" role="menu">
        <a class="dropdown-item btn btn-dark" id="btn_nav_newRemote" href="${rc.contextPath}/realmobiles" role="menuitem">
            <i class="icon wb-plus" aria-hidden="true"></i> <@spring.message "nav.mobile.test.new"/>
        </a>

    <#list currentRms as realMobile>
        <div class="dropdown-divider"></div>
        <a class="dropdown-item" id="btn_nav_inRemote" href="${rc.contextPath}/realmobile/${realMobile.id}" role="menuitem">
            <i class="icon wb-mobile"
               aria-hidden="true"></i>
            <@spring.message "nav.mobile.remote"/>（${realMobile.mobileName}）
        </a>
    </#list>

    </div>
</li>