<li class="nav-item dropdown">
    <a class="nav-link" id="btn_nav_project" data-toggle="dropdown" href="#" aria-expanded="false" data-animation="fade"
       role="button">
        <@spring.message "nav.projects"/>
        <i class="icon wb-chevron-down-mini" aria-hidden="true"></i>
    </a>
    <div class="dropdown-menu" role="menu">

    <#list recentProjects as recentProject>
        <a class="dropdown-item" id="btn_nav_recentProject" href="${rc.contextPath}/project/${recentProject.id}" role="menuitem">
            <span style="position:absolute; width:100px; white-space:nowrap; overflow:hidden; -o-text-overflow:ellipsis; text-overflow:ellipsis;" title="${recentProject.projectName}">
                ${recentProject.projectName}
            </span>
            <span class="tag tag-default" style="margin-left:110px;" >
            <#if recentProject.projectType == 1>
                <@spring.message "system.project.create.FormTypeIos"/>
            <#else >
                <@spring.message "system.project.create.FormTypeAnd"/>
            </#if>
            </span>
        </a>
    </#list>
    <#if recentProjects??>
        <div class="dropdown-divider"></div>
    </#if>
        <a class="dropdown-item" id="btn_nav_moreProject" href="${rc.contextPath}/moreproject" role="menuitem"><i
                class="icon wb-more-horizontal" aria-hidden="true"></i> <@spring.message "nav.project.more"/></a>
    </div>
</li>