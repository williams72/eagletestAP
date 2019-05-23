<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    <title>${currentTask.taskName}
        <@spring.message "project.ReportTitle"/>
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

    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/blueimp-file-upload/jquery.fileupload.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/dropify/dropify.css">

    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/select2/select2.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/bootstrap-select/bootstrap-select.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/c3/c3.css">

    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/aspieprogress/asPieProgress.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/assets/examples/css/charts/pie-progress.css">

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

<!-- include ie jianrong beg -->
<#include "/other/ie8_incompatible.ftl">
<!-- include ie jianrong end -->
<!-- include nav ftl beg -->
<#include "/project/project_nav.ftl">
<!-- include nav ftl end -->

<!-- project_side beg -->
<div class="site-menubar">
    <div class="site-menubar-body">
        <div>
            <div>
                <ul class="site-menu" data-plugin="menu">
                    <li class="site-menu-category">
                        <h4 class="inline-block">${currentProject.projectName}</h4>
                        <span class="tag tag-success">${currentProject.projectKey}</span>
                    </li>
                    <li class="site-menu-item">
                        <a href="${rc.contextPath}/project/${currentProject.id}/dashboard" id="btn_side_dashbord">
                            <i class="site-menu-icon wb-dashboard" aria-hidden="true"></i>
                            <span class="site-menu-title"><@spring.message "project.dashboard"/></span>
                        </a>
                    </li>
                    <li class="site-menu-item active">
                        <a href="${rc.contextPath}/project/${currentProject.id}/tasks" id="btn_side_task">
                            <i class="site-menu-icon wb-list" aria-hidden="true"></i>
                            <span class="site-menu-title"><@spring.message "project.tasks"/></span>
                        </a>
                    </li>
                    <li class="site-menu-item">
                        <a href="${rc.contextPath}/project/${currentProject.id}/versions" id="btn_side_version">
                            <i class="site-menu-icon wb-code-working" aria-hidden="true"></i>
                            <span class="site-menu-title"><@spring.message "project.version"/></span>
                        </a>
                    </li>
                    <li class="site-menu-item">
                        <a href="${rc.contextPath}/project/${currentProject.id}/apps" id="btn_side_app">
                            <i class="site-menu-icon wb-briefcase" aria-hidden="true"></i>
                            <span class="site-menu-title"><@spring.message "project.builds"/></span>
                        </a>
                    </li>
                <#if currentProjectUser.projectRole == 1>
                    <li class="site-menu-item">
                        <a href="${rc.contextPath}/project/${currentProject.id}/users" id="btn_side_members">
                            <i class="site-menu-icon wb-users" aria-hidden="true"></i>
                            <span class="site-menu-title"><@spring.message "project.members"/></span>
                        </a>
                    </li>
                </#if>
                    <!--
                    <li class="site-menu-item">
                        <a href="${rc.contextPath}/project/${currentProject.id}/setting">
                            <i class="site-menu-icon wb-settings" aria-hidden="true"></i>
                            <span class="site-menu-title"><@spring.message "project.settings"/></span>
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
<!-- project_side end -->
<!-- Page -->
<div class="page">
    <div class="page-header p-t-10 p-b-10">
        <!--<h1 class="page-title">Page Title</h1>-->
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${rc.contextPath}/mainpage">
            <@spring.message "project.ReportContextpathHome"/>
            </a></li>
            <li class="breadcrumb-item"><a
                    href="${rc.contextPath}/project/${currentProject.id}">${currentProject.projectName}</a></li>
            <li class="breadcrumb-item active">
            <@spring.message "project.ReportContextpathTitle"/>
            </li>
        </ol>
    </div>
    <div class="page-content">
        <!-- 结果 tab beg -->
        <div class="nav-tabs-horizontal nav-tabs-inverse nav-tabs-animate" data-plugin="tabs">
            <!-- tab head beg -->
            <#if currentTask.engine == 0>
                <div class="panel">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="icon wb-mobile" aria-hidden="true"></i>
                            <@spring.message "project.report.smarttraversal"/>
                        </h3>
                    </div>
                    <div class="panel-body">
                        <h4 class="m-t-20"><i class="icon wb-medium-point"></i>
                            <@spring.message "project.ResultInfoTable"/></h4>
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th><@spring.message "project.ResultInfoName"/></th>
                                    <th><@spring.message "project.ResultInfoVersion"/></th>
                                    <th><@spring.message "project.ResultInfoTime"/></th>
                                    <th><@spring.message "project.ResultInfoStart"/></th>
                                    <!--<th><@spring.message "project.ResultInfoEndTime"/></th>-->
                                    <th><@spring.message "project.ResultInfoStatus"/></th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>${currentTask.taskName}</td>
                                    <td>${currentTask.etVersion.versionName}</td>
                                    <td>${currentTask.createTime}</td>
                                    <td>${currentTask.starttime}</td>
                                    <!--<td>${currentTask.endtime}</td>-->
                                    <td>
                                        <#if currentTask.status == 0>
                                            <span class="tag tag-primary">
                                                <@spring.message "project.ResultInfoCreate"/>
                                        </span>
                                        <#elseif currentTask.status == 1>
                                            <span class="tag tag-warning">
                                                <@spring.message "project.ResultInfoWait"/>
                                        </span>
                                        <#elseif currentTask.status == 2>
                                            <span class="tag tag-info">
                                                <@spring.message "project.ResultInfoRun"/>
                                        </span>
                                        <#elseif currentTask.status == 3>
                                            <span class="tag tag-success">
                                                <@spring.message "project.ResultInfoEnd"/>
                                        </span>
                                        <#elseif currentTask.status == 4>
                                            <span class="tag tag-danger"><@spring.message "project.ResultInfoCancel"/></span>
                                        </#if>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>

                        <h4 class="m-t-20"><i class="icon wb-medium-point"></i>
                            <@spring.message "project.report.smarttraversal.detail"/></h4>
                        <div class="table-responsive">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th><@spring.message "project.MobilesBrand"/></th>
                                    <th><@spring.message "project.MobilesOS"/></th>
                                    <th><@spring.message "project.report.smarttraversal.begtime"/></th>
                                    <!--<th><@spring.message "project.report.smarttraversal.endtime"/></th>-->
                                    <th><@spring.message "project.MobilesResult"/></th>
                                    <th><@spring.message "project.MobilesOperation"/></th>
                                </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>
                                        --
                                        </td>

                                        <td>
                                        --
                                        </td>

                                        <td>
                                        --
                                        </td>
                                        <!--
                                        <td>
                                        --
                                        </td>
                                        -->
                                        <td>
                                            <#if stResult.result == 0>
                                                <span class="tag tag-success">
                                                    <@spring.message "project.MobilesPass"/>
                                                    </span>
                                            <#elseif stResult.result == 1>
                                                <span class="tag tag-danger">
                                                    <@spring.message "project.MobilesFail"/>
                                                    </span>
                                            <#else >
                                                <span class="tag tag-warning"><@spring.message "project.MobilesNoRun"/></span>
                                            </#if>
                                        </td>
                                        <td>
                                                <a href="${rc.contextPath}/project/${currentProject.id}/task/${currentTask.id}/smarttraversal?resultUrl=${smtResult.resultPath}">
                                                    <@spring.message "project.report.smarttraversal.viewreport"/>
                                                </a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
            <#else >
                <ul class="nav nav-tabs nav-tabs-solid" role="tablist">

                    <li class="nav-item" role="presentation">
                        <a class="nav-link active" data-toggle="tab" href="#result_zongshu"
                           aria-controls="exampleTabsSolidInverseOne" role="tab">
                            <@spring.message "project.ResultTabTitle"/>
                        </a>
                    </li>
                    <#if taskResult.result.totalSummary.compatibility??>
                        <li class="nav-item" role="presentation">
                            <a class="nav-link" data-toggle="tab" href="#result_jianrong"
                               aria-controls="exampleTabsSolidInverseTwo"
                               role="tab">
                                <@spring.message "project.CompatibilityTab"/>
                            </a>
                        </li>
                    </#if>
                    <#if taskResult.result.totalSummary.case??>
                        <li class="nav-item" role="presentation">
                            <a class="nav-link" data-toggle="tab" href="#result_jiaoben"
                               aria-controls="exampleTabsSolidInverseTwo"
                               role="tab">
                                <@spring.message "project.ScriptTab"/>
                            </a>
                        </li>
                    </#if>
                    <#if taskResult.result.totalSummary.travel??>
                        <li class="nav-item" role="presentation">
                            <a class="nav-link" data-toggle="tab" href="#result_bianli"
                               aria-controls="exampleTabsSolidInverseTwo"
                               role="tab">
                                <@spring.message "project.TraverseTab"/>
                            </a>
                        </li>
                    </#if>
                    <li class="nav-item" role="presentation">
                        <a class="nav-link" data-toggle="tab" href="#result_xingneng"
                           aria-controls="exampleTabsSolidInverseTwo"
                           role="tab">
                            <@spring.message "project.PerformanceTab"/>
                        </a>
                    </li>
                    <li class="nav-item" role="presentation">
                        <a class="nav-link" data-toggle="tab" href="#result_zhongduan"
                           aria-controls="exampleTabsSolidInverseTwo"
                           role="tab">
                            <@spring.message "project.MobilesTab"/>
                        </a>
                    </li>
                </ul>
                <!-- tab head end -->
                <!-- tab content beg -->
                <div class="tab-content">
                    <!-- tab zongshu beg -->
                    <div class="tab-pane active animation-scale-up" id="result_zongshu" role="tabpanel">
                        <h4 class="m-t-20"><i class="icon wb-medium-point"></i>
                            <@spring.message "project.ResultInfoTable"/></h4>
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th><@spring.message "project.ResultInfoName"/></th>
                                    <th><@spring.message "project.ResultInfoVersion"/></th>
                                    <th><@spring.message "project.ResultInfoTime"/></th>
                                    <th><@spring.message "project.ResultInfoStart"/></th>
                                    <th><@spring.message "project.ResultInfoEndTime"/></th>
                                    <th><@spring.message "project.ResultInfoStatus"/></th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>${currentTask.taskName}</td>
                                    <td>${currentTask.etVersion.versionName}</td>
                                    <td>${taskResult.result.taskInfo.create_time}</td>
                                    <td>${taskResult.result.taskInfo.start_time}</td>
                                    <td>${taskResult.result.taskInfo.end_time}</td>
                                    <td>
                                        <#if currentTask.status == 0>
                                            <span class="tag tag-primary">
                                                <@spring.message "project.ResultInfoCreate"/>
                                        </span>
                                        <#elseif currentTask.status == 1>
                                            <span class="tag tag-warning">
                                                <@spring.message "project.ResultInfoWait"/>
                                        </span>
                                        <#elseif currentTask.status == 2>
                                            <span class="tag tag-info">
                                                <@spring.message "project.ResultInfoRun"/>
                                        </span>
                                        <#elseif currentTask.status == 3>
                                            <span class="tag tag-success">
                                                <@spring.message "project.ResultInfoEnd"/>
                                        </span>
                                        <#elseif currentTask.status == 4>
                                            <span class="tag tag-danger"><@spring.message "project.ResultInfoCancel"/></span>
                                        </#if>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="row">
                            <!-- 暂时隐藏掉这个 因为没有数据了 beg

                        <div class="col-xs-12 col-md-4 col-lg-4">
                            <h4><i class="icon wb-medium-point"></i>
                            <@spring.message "project.ResultTotalPass"/></h4>
                            <div class="pie-progress pie-progress-sm center-block m-l-30" id="examplePieApi"
                                 data-plugin="pieProgress"
                                 data-barcolor="#fa7a7a" data-goal="100" data-size="150" data-barsize="10"
                                 aria-valuemin="-100" aria-valuemax="250" role="progressbar">
                                <div class="pie-progress-content">
                                    <div class="pie-progress-number">
                                    ${taskResult.result.totalSummary.successRate}%
                                    </div>
                                    <div class="pie-progress-label"><@spring.message "project.ResultChart"/></div>
                                </div>
                            </div>
                        </div>
                        暂时隐藏掉这个 因为没有数据了 end -->
                        <div class="col-xs-12 col-md-8 col-lg-8">
                            <h4><i class="icon wb-medium-point"></i> <@spring.message "project.ResultPerformance"/></h4>
                            <table class="table">
                                <thead>
                                <tr>
                                    <th><@spring.message "project.ResultStart"/>（S）</th>
                                    <th><@spring.message "project.ResultCPU"/>（%）</th>
                                    <th><@spring.message "project.ResultRAM"/>（KB）</th>
                                    <th><@spring.message "project.ResultFlow"/>（BYTES）</th>
                                    <th><@spring.message "project.ResultBattery"/>（MAH）</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>
                                    ${taskResult.result.deviceDetail.performance.launch_time.avg}
                                    </td>
                                    <td>
                                    ${taskResult.result.deviceDetail.performance.cpu_avg.avg}
                                    </td>
                                    <td>
                                    ${taskResult.result.deviceDetail.performance.mem_max.avg}
                                    </td>
                                    <td>
                                    ${taskResult.result.deviceDetail.performance.net_recv.avg}/
                                    ${taskResult.result.deviceDetail.performance.net_send.avg}
                                    </td>
                                    <td>
                                    ${taskResult.result.deviceDetail.performance.power_usage.avg}
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <h4 class="m-t-20"><i class="icon wb-medium-point"></i>
                    <@spring.message "project.ResultPassnumber"/>
                    </h4>
                    <div class="row">
                <#if taskResult.result.totalSummary.compatibility??>
                    <div class="col-xs-12 col-md-4 col-lg-4">
                        <div class="example">
                            <div id="gailan_jianrong"></div>
                        </div>
                    </div>
                </#if>
                <#if taskResult.result.totalSummary.case??>
                    <div class="col-xs-12 col-md-4 col-lg-4">
                        <div class="example">
                            <div id="gailan_case"></div>
                        </div>
                    </div>
                </#if>
                <#if taskResult.result.totalSummary.travel??>
                    <div class="col-xs-12 col-md-4 col-lg-4">
                        <div class="example">
                            <div id="gailan_bianli"></div>
                        </div>
                    </div>
                </#if>
                    </div>
                </div>
                <!-- tab zongshu end -->
                <!-- tab jianrong beg -->
            <#if taskResult.result.totalSummary.compatibility??>
                <div class="tab-pane animation-scale-up" id="result_jianrong" role="tabpanel">
                    <h4><i class="icon wb-medium-point"></i>
                        <@spring.message "project.CompatibilityTab"/></h4>
                    <div class="row">
                        <div class="col-xs-12 col-md-4 col-lg-6">
                            <div class="example">
                                <div id="pie_jianrong"></div>
                            </div>
                        </div>
                        <div class="col-xs-12 col-md-4 col-lg-6">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <h4><i class="icon wb-medium-point"></i> <@spring.message "project.CompatibilityTitle"/></h4>
                        </div>
                        <div class="col-lg-6">
                            <select id="jixingzhanbi_select" data-plugin="selectpicker" class="pull-lg-right show-tick">
                                <option value="1" selected>
                                    <@spring.message "project.CompatibilityBrand"/>
                                </option>
                                <option value="2">
                                    <@spring.message "project.CompatibilityOS"/>
                                </option>
                                <option value="3">
                                    <@spring.message "project.CompatibilityRe"/>
                                </option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12 col-md-10 col-lg-10 offset-lg-2">
                            <div class="example">
                                <div id="bar_jixingzhanbi"></div>
                            </div>
                        </div>
                        <div class="col-xs-12 col-md-4 col-lg-6">
                        </div>
                    </div>
                    <#if taskResult.result.totalSummary.compatibility.issueDetail?? && taskResult.result.totalSummary.compatibility.issueDetail?size gt 0>
                        <h4><i class="icon wb-medium-point"></i>
                            <@spring.message "project.ErrorTitle"/></h4>
                        <div class="row">
                            <div class="col-lg-12">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th><@spring.message "project.ErrorType"/></th>
                                        <th><@spring.message "project.ErrorLocation"/></th>
                                        <th><@spring.message "project.ErrorNumber"/></th>
                                        <th><@spring.message "project.ErrorMoblies"/></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <#list taskResult.result.totalSummary.compatibility.issueDetail?keys as key>
                                        <tr>
                                            <td>${taskResult.result.totalSummary.compatibility.issueDetail[key].title}</td>
                                            <td>${taskResult.result.totalSummary.compatibility.issueDetail[key].desc}</td>
                                            <td>${taskResult.result.totalSummary.compatibility.issueDetail[key].phones?size}</td>
                                            <#list taskResult.result.totalSummary.compatibility.issueDetail[key].phones as phone>
                                                <td>
                                                    <span class="tag tag-info block m-y-3">${phone.model}</span>
                                                </td>
                                            </#list>
                                        </tr>
                                        </#list>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </#if>
                </div>
            </#if>
                <!-- tab jianrong end -->
                <!-- tab jiaoben beg -->
            <#if taskResult.result.totalSummary.case??>
                <div class="tab-pane animation-scale-up" id="result_jiaoben" role="tabpanel">
                    <h4><i class="icon wb-medium-point"></i> <@spring.message "project.ScriptTitle"/></h4>
                    <div class="row">
                        <div class="col-xs-12 col-md-4 col-lg-6">
                            <div class="example">
                                <div id="pie_jiaoben"></div>
                            </div>
                        </div>
                        <div class="col-xs-12 col-md-4 col-lg-6">
                        </div>
                    </div>
                    <#if taskResult.result.totalSummary.case.issueDetail?? && taskResult.result.totalSummary.case.issueDetail?size gt 0>
                        <h4><i class="icon wb-medium-point"></i>
                            <@spring.message "project.ErrorTitle"/>
                        </h4>
                        <div class="row">
                            <div class="col-lg-12">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th><@spring.message "project.ErrorType"/></th>
                                        <th><@spring.message "project.ErrorLocation"/></th>
                                        <th><@spring.message "project.ErrorNumber"/></th>
                                        <th><@spring.message "project.ErrorMoblies"/></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <#list taskResult.result.totalSummary.case.issueDetail?keys as key>
                                        <tr>
                                            <td>${taskResult.result.totalSummary.case.issueDetail[key].title}</td>
                                            <td>${taskResult.result.totalSummary.case.issueDetail[key].desc}</td>
                                            <td>${taskResult.result.totalSummary.case.issueDetail[key].count}</td>
                                            <#list taskResult.result.totalSummary.case.issueDetail[key].phones as phone>
                                                <td>
                                                    <span class="tag tag-info block m-y-3">${phone.model}</span>
                                                </td>
                                            </#list>
                                        </tr>
                                        </#list>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </#if>
                </div>
            </#if>
                <!-- tab jiaoben end -->
                <!-- tab bianli beg -->
            <#if taskResult.result.totalSummary.travel??>
                <div class="tab-pane animation-scale-up" id="result_bianli" role="tabpanel">
                    <h4><i class="icon wb-medium-point"></i><@spring.message "project.TraverseTitle"/></h4>
                    <div class="row">
                        <div class="col-xs-12 col-md-4 col-lg-6">
                            <div class="example">
                                <div id="pie_bianli"></div>
                            </div>
                        </div>
                        <div class="col-xs-12 col-md-4 col-lg-6">
                        </div>
                    </div>
                    <#if taskResult.result.totalSummary.travel.issueDetail?? && taskResult.result.totalSummary.travel.issueDetail?size gt 0>
                        <h4><i class="icon wb-medium-point"></i> <@spring.message "project.ErrorTitle"/></h4>
                        <div class="row">
                            <div class="col-lg-12">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th><@spring.message "project.ErrorType"/></th>
                                        <th><@spring.message "project.ErrorLocation"/></th>
                                        <th><@spring.message "project.ErrorNumber"/></th>
                                        <th><@spring.message "project.ErrorMobiles"/></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <#list taskResult.result.totalSummary.travel.issueDetail?keys as key>
                                        <tr>
                                            <td>${taskResult.result.totalSummary.travel.issueDetail[key].title}</td>
                                            <td>${taskResult.result.totalSummary.travel.issueDetail[key].desc}</td>
                                            <td>${taskResult.result.totalSummary.travel.issueDetail[key].phones?size}</td>
                                            <#list taskResult.result.totalSummary.travel.issueDetail[key].phones as phone>
                                                <td>
                                                    <span class="tag tag-info block m-y-3">${phone.model}</span>
                                                </td>
                                            </#list>
                                        </tr>
                                        </#list>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </#if>
                </div>
            </#if>
                <!-- tab bianli end -->
                <!-- tab xingneng beg -->
                <div class="tab-pane animation-scale-up" id="result_xingneng" role="tabpanel">
                    <h4><i class="icon wb-medium-point"></i> <@spring.message "project.PerformanceTable"/></h4>
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>&nbsp;&nbsp;&nbsp;#&nbsp;&nbsp;&nbsp;</th>
                                <th><@spring.message "project.PerformanceStart"/></th>
                                <th><@spring.message "project.PerformanceCPU"/></th>
                                <th><@spring.message "project.PerformanceRAM"/></th>
                                <th><@spring.message "project.PerformanceFlow"/></th>
                                <th><@spring.message "project.PerformanceBattery"/></th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>
                                <@spring.message "project.PerformanceAVG"/>
                                </td>
                                <td>
                                ${taskResult.result.deviceDetail.performance.launch_time.avg}
                                </td>
                                <td>
                                ${taskResult.result.deviceDetail.performance.cpu_avg.avg}
                                </td>
                                <td>
                                ${taskResult.result.deviceDetail.performance.mem_max.avg}
                                </td>
                                <td>
                                ${taskResult.result.deviceDetail.performance.net_recv.avg}/
                                ${taskResult.result.deviceDetail.performance.net_send.avg}
                                </td>
                                <td>
                                ${taskResult.result.deviceDetail.performance.power_usage.avg}
                                </td>
                            </tr>
                            <tr>
                                <td>
                                <@spring.message "project.PerformanceBest"/>
                                </td>
                                <td>
                                ${taskResult.result.deviceDetail.performance.launch_time.min_device.name}<br/>
                                ${taskResult.result.deviceDetail.performance.launch_time.min_device.performance.launch_time}
                                </td>
                                <td>
                                ${taskResult.result.deviceDetail.performance.cpu_avg.min_device.name}<br/>
                                ${taskResult.result.deviceDetail.performance.cpu_avg.min_device.performance.cpu_avg}
                                </td>
                                <td>
                                ${taskResult.result.deviceDetail.performance.mem_max.min_device.name}<br/>
                                ${taskResult.result.deviceDetail.performance.mem_max.min_device.performance.mem_max}
                                </td>
                                <td>
                                ${taskResult.result.deviceDetail.performance.net_recv.min_device.performance.net_recv}/
                                ${taskResult.result.deviceDetail.performance.net_send.min_device.performance.net_send}
                                </td>
                                <td>
                                ${taskResult.result.deviceDetail.performance.power_usage.min_device.name}<br/>
                                ${taskResult.result.deviceDetail.performance.power_usage.min_device.performance.power_usage}
                                </td>
                            </tr>
                            <tr>
                                <td>
                                <@spring.message "project.PerformanceWorst"/>
                                </td>
                                <td>
                                ${taskResult.result.deviceDetail.performance.launch_time.max_device.name}<br/>
                                ${taskResult.result.deviceDetail.performance.launch_time.max_device.performance.launch_time}
                                </td>
                                <td>
                                ${taskResult.result.deviceDetail.performance.cpu_avg.max_device.performance.cpu_avg}
                                </td>
                                <td>
                                ${taskResult.result.deviceDetail.performance.mem_max.max_device.name}<br/>
                                ${taskResult.result.deviceDetail.performance.mem_max.max_device.performance.mem_max}
                                </td>
                                <td>
                                ${taskResult.result.deviceDetail.performance.net_recv.max_device.performance.net_recv}/
                                ${taskResult.result.deviceDetail.performance.net_send.max_device.performance.net_send}
                                </td>
                                <td>
                                ${taskResult.result.deviceDetail.performance.power_usage.max_device.name}<br/>
                                ${taskResult.result.deviceDetail.performance.power_usage.max_device.performance.power_usage}
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <h4><i class="icon wb-medium-point"></i>
                    <@spring.message "project.PerformanceDetail"/>&nbsp;<@spring.message "project.ChartFive"/>
                    </h4>
                    <div class="row">
                        <div class="col-md-12 col-lg-6">
                            <h5 class="inline-block"><@spring.message "project.ChartStart"/></h5>

                                <div id="performance_start"></div>
                            </div>
                            <div class="col-md-12 col-lg-6">
                                <h5 class="inline-block"><@spring.message "project.ChartCPU"/></h5>
                                <div id="performance_cpu"></div>
                            </div>
                            <div class="col-md-12 col-lg-6">
                                <h5 class="inline-block"><@spring.message "project.ChartRAM"/></h5>

                                <div id="performance_mem"></div>
                            </div>
                            <div class="col-md-12 col-lg-6">
                                <h5 class="inline-block"><@spring.message "project.ChartFlow"/></h5>

                                <div id="performance_traffic"></div>
                            </div>
                            <div class="col-md-12 col-lg-6">
                                <h5 class="inline-block"><@spring.message "project.ChartBattery"/></h5>

                                <div id="performance_elect"></div>
                            </div>
                        </div>
                    </div>
                    <!-- tab xingneng end -->
                    <!-- tab zhongduan beg -->
                    <div class="tab-pane animation-scale-up" id="result_zhongduan" role="tabpanel">
                        <!-- 设备筛选 beg-->
                        <!--
                        <div class="panel m-b-0">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                <@spring.message "project.MobilesFilter"/>
                                </h3>
                                <div class="panel-actions">
                                    <a class="panel-action icon wb-minus" data-toggle="panel-collapse" aria-expanded="true"
                                       aria-hidden="true"></a>
                                </div>
                            </div>
                            <div class="panel-body p-b-20">-->
                        <!-- 筛选区 beg -->
                        <!--
                                <div class="row">
                                    <div class="col-md-12 col-lg-12">
                                        <div class="row"
                                             style="margin-top:10px; border-bottom:1px dashed #8796a4; padding-bottom:5px;">
                                            <div class="col-xs-12 col-md-2 col-lg-1">
                                                <button type="button" class="btn btn-primary btn-xs">
                                                <@spring.message "project.MobilesBrand"/>
                                                </button>
                                            </div>
                                            <div class="col-xs-12 col-md-10 col-lg-10">
                                                <div style="margin:0px 5px" class="inline">
                                                    <input type="checkbox" class="icheckbox-primary" id="brand[0]"
                                                           name="inputiCheckColorCheckboxes"
                                                           data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                                                    <label for="brand[0]" style="margin-left:5px;">全部</label>
                                                </div>
                                                <div style="margin:0px 5px" class="inline">
                                                    <input type="checkbox" class="icheckbox-primary" id="brand[1]"
                                                           name="inputiCheckColorCheckboxes"
                                                           data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                                                    <label for="brand[1]" style="margin-left:5px;">华为</label>
                                                </div>
                                                <div style="margin:0px 5px" class="inline">
                                                    <input type="checkbox" class="icheckbox-primary" id="brand[2]"
                                                           name="inputiCheckColorCheckboxes"
                                                           data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                                                    <label for="brand[2]" style="margin-left:5px;">苹果</label>
                                                </div>
                                                <div style="margin:0px 5px" class="inline">
                                                    <input type="checkbox" class="icheckbox-primary" id="brand[3]"
                                                           name="inputiCheckColorCheckboxes"
                                                           data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                                                    <label for="brand[3]" style="margin-left:5px;">中兴</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row"
                                             style="margin-top:10px; border-bottom:1px dashed #8796a4; padding-bottom:5px;">
                                            <div class="col-xs-12 col-md-2 col-lg-1">
                                                <button type="button" class="btn btn-primary btn-xs">系统版本</button>
                                            </div>
                                            <div class="col-xs-12 col-md-10 col-lg-10">
                                                <div style="margin:0px 5px" class="inline">
                                                    <input type="checkbox" class="icheckbox-primary" id="os[0]"
                                                           name="inputiCheckColorCheckboxes"
                                                           data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                                                    <label for="os[0]" style="margin-left:5px;">全部</label>
                                                </div>
                                                <div style="margin:0px 5px" class="inline">
                                                    <input type="checkbox" class="icheckbox-primary" id="os[1]"
                                                           name="inputiCheckColorCheckboxes"
                                                           data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                                                    <label for="os[1]" style="margin-left:5px;">Android 5.0</label>
                                                </div>
                                                <div style="margin:0px 5px" class="inline">
                                                    <input type="checkbox" class="icheckbox-primary" id="os[2]"
                                                           name="inputiCheckColorCheckboxes"
                                                           data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                                                    <label for="os[2]" style="margin-left:5px;">Android 6.0</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row"
                                             style="margin-top:10px; border-bottom:1px dashed #8796a4; padding-bottom:5px;">
                                            <div class="col-xs-12 col-md-2 col-lg-1">
                                                <button type="button" class="btn btn-primary btn-xs">测试结果</button>
                                            </div>
                                            <div class="col-xs-12 col-md-10 col-lg-10">
                                                <div style="margin:0px 5px" class="inline">
                                                    <input type="checkbox" class="icheckbox-primary" id="status[0]"
                                                           name="inputiCheckColorCheckboxes"
                                                           data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                                                    <label for="status[0]" style="margin-left:5px;">全部</label>
                                                </div>
                                                <div style="margin:0px 5px" class="inline">
                                                    <input type="checkbox" class="icheckbox-primary" id="status[1]"
                                                           name="inputiCheckColorCheckboxes"
                                                           data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                                                    <label for="status[1]" style="margin-left:5px;">通过</label>
                                                </div>
                                                <div style="margin:0px 5px" class="inline">
                                                    <input type="checkbox" class="icheckbox-primary" id="status[2]"
                                                           name="inputiCheckColorCheckboxes"
                                                           data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>
                                                    <label for="status[2]" style="margin-left:5px;">未通过</label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                -->
                        <!-- 筛选区 end -->
                        <!--</div>
                    </div>-->
                        <!-- 设备筛选 end-->
                        <div class="panel">
                            <div class="panel-heading">
                                <h3 class="panel-title"><@spring.message "project.MobilesList"/></h3>
                                <!--
                                <ul class="panel-actions panel-actions-keep">
                                    <li>
                                        <a href="${taskResult.result.taskExcelReport}" class="btn btn-primary btn-xs">
                                        <@spring.message "project.MobilesDownload"/>
                                        </a>
                                    </li>
                                </ul>
                                -->
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th><@spring.message "project.MobilesBrand"/></th>
                                            <th><@spring.message "project.MobilesOS"/></th>
                                            <th><@spring.message "project.MobilesResult"/></th>
                                            <th><@spring.message "project.MobilesStart"/>(S)</th>
                                            <th><@spring.message "project.MobilesCPU"/> (%)</th>
                                            <th><@spring.message "project.MobilesFlow"/></th>
                                            <th><@spring.message "project.MobilesBattery"/> (MAH)</th>
                                            <th><@spring.message "project.MobilesOperation"/></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                            <#list  taskResult.result.deviceDetail.result.all as phone>
                                            <tr>
                                                <td>
                                                ${phone.model}
                                                </td>
                                                <td>
                                                ${phone.os}
                                                </td>
                                                <td>
                                                    <#if phone.setup == "pass" && phone.install == "pass" && phone.run == "pass" && phone.uninstall == "pass" && phone.teardown == "pass">
                                                        <span class="tag tag-success">
                                                            <@spring.message "project.MobilesPass"/>
                                                    </span>
                                                    <#elseif phone.setup == "fail" || phone.install == "fail" || phone.run == "fail" || phone.uninstall == "fail" || phone.teardown == "fail">
                                                        <span class="tag tag-danger">
                                                            <@spring.message "project.MobilesFail"/>
                                                    </span>
                                                    <#else >
                                                        <span class="tag tag-warning"><@spring.message "project.MobilesNoRun"/></span>
                                                    </#if>
                                                </td>
                                                <td>
                                                ${phone.performance.launch_time!"~"}
                                                </td>
                                                <td>
                                                ${phone.performance.cpu_avg!"~"}
                                                </td>
                                                <td>
                                                ${phone.performance.net_recv!"~"}/
                                                ${phone.performance.net_send!"~"}
                                                </td>
                                                <td>
                                                ${phone.performance.power_usage!"~"}
                                                </td>
                                                <td>
                                                    <a href="${rc.contextPath}/project/${currentProject.id}/task/${currentTask.id}/mobile/${phone.serial_number}">
                                                        <@spring.message "project.MobilesView"/>
                                                    </a>
                                                </td>
                                            </tr>
                                            </#list>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- tab zongshu end -->
                </div>
                <!-- tab content end -->
            </#if>
        </div>
        <!-- 结果 tab end -->
    </div>
</div>
<!-- End Page -->
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
<script src="${rc.contextPath}/static/global/vendor/d3/d3.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/c3/c3.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/aspieprogress/jquery-asPieProgress.js"></script>
<script src="${rc.contextPath}/static/global/vendor/bootstrap-select/bootstrap-select.js"></script>

<script src="${rc.contextPath}/static/global/vendor/matchheight/jquery.matchHeight-min.js"></script>
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
<script>
    Config.set('assets', '${rc.contextPath}/static/assets');
</script>
<!-- Page -->
<script src="${rc.contextPath}/static/assets/js/Site.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/asscrollable.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/slidepanel.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/switchery.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/panel.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/bootstrap-select.js"></script>

<script src="${rc.contextPath}/static/js/task/task_result.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/tabs.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/aspieprogress.js"></script>

<script src="${rc.contextPath}/static/global/js/Plugin/icheck.js"></script>
<!-- datatables beg-->
<script src="${rc.contextPath}/static/global/vendor/datatables/jquery.dataTables.js"></script>
<script src="${rc.contextPath}/static/global/vendor/datatables-fixedheader/dataTables.fixedHeader.js"></script>
<script src="${rc.contextPath}/static/global/vendor/datatables-bootstrap/dataTables.bootstrap.js"></script>
<script src="${rc.contextPath}/static/global/vendor/datatables-responsive/dataTables.responsive.js"></script>
<script src="${rc.contextPath}/static/global/vendor/datatables-tabletools/dataTables.tableTools.js"></script>
<script src="${rc.contextPath}/static/js/datatable.js"></script>

<!-- datatables end-->
<script type="text/javascript">
    $(document).ready(function () {
        //概览 兼容
    <#if taskResult.result.totalSummary.compatibility??>
        var $gailan_jianrong = c3.generate({
            bindto: '#gailan_jianrong',
            data: {
                // iris data from R
                columns: [
                    ['<@spring.message "project.report.chart.NotRun"/>', ${taskResult.result.totalSummary.compatibility.summary.notRun}],
                    ['<@spring.message "project.report.chart.Fail"/>', ${taskResult.result.totalSummary.compatibility.summary.fail}],
                    ['<@spring.message "project.report.chart.Success"/>', ${taskResult.result.totalSummary.compatibility.summary.pass}]
                ],
                type: 'donut',
            },
            color: {
                pattern: ["#526069",
                    "#E9595B",
                    "#009933"]
            },
            legend: {
                position: 'bottom'
            },
            size: {
                width: 200,
                height: 200
            },
            donut: {
                title: "<@spring.message "project.report.chart.com.Title"/>",
                width: 10,
                label: {
                    show: false
                }
            }
        });
    </#if>
        //概览 case
    <#if taskResult.result.totalSummary.case??>
        var $gailan_case = c3.generate({
            bindto: '#gailan_case',
            data: {
                // iris data from R
                columns: [
                    ['<@spring.message "project.report.chart.NotRun"/>', ${taskResult.result.totalSummary.case.summary.notRun}],
                    ['<@spring.message "project.report.chart.Fail"/>', ${taskResult.result.totalSummary.case.summary.fail}],
                    ['<@spring.message "project.report.chart.Success"/>', ${taskResult.result.totalSummary.case.summary.pass}]
                ],
                type: 'donut',
            },
            color: {
                pattern: ["#526069",
                    "#E9595B",
                    "#009933"]
            },
            legend: {
                position: 'bottom'
            },
            size: {
                width: 200,
                height: 200
            },
            donut: {
                title: "<@spring.message "project.report.chart.case.Title"/>",
                width: 10,
                label: {
                    show: false
                }
            }
        });
    </#if>
        //概览 遍历
    <#if taskResult.result.totalSummary.travel??>
        var $gailan_bianli = c3.generate({
            bindto: '#gailan_bianli',
            data: {
                // iris data from R
                columns: [
                    ['<@spring.message "project.report.chart.NotRun"/>', ${taskResult.result.totalSummary.travel.summary.notRun}],
                    ['<@spring.message "project.report.chart.Fail"/>', ${taskResult.result.totalSummary.travel.summary.fail}],
                    ['<@spring.message "project.report.chart.Success"/>', ${taskResult.result.totalSummary.travel.summary.pass}]
                ],
                type: 'donut',
            },
            color: {
                pattern: ["#526069",
                    "#E9595B",
                    "#009933"]
            },
            legend: {
                position: 'bottom'
            },
            size: {
                width: 200,
                height: 200
            },
            donut: {
                title: "<@spring.message "project.report.chart.travel.Title"/>",
                width: 10,
                label: {
                    show: false
                }
            }
        });
    </#if>

        var $taskResult = ${result};

    <#if taskResult.result.totalSummary.compatibility??>
        var $pie_jianrong = c3.generate({
            bindto: '#pie_jianrong',
            data: {
                // iris data from R
                columns: [
                    ['<@spring.message "project.report.chart.pass"/>', ${taskResult.result.totalSummary.compatibility.summary.pass}],
                    ['<@spring.message "project.report.chart.run_error"/>', ${taskResult.result.totalSummary.compatibility.summary.fail}]
                ],
                /*columns: [
                    ['<@spring.message "project.report.chart.pass"/>', ${taskResult.result.totalSummary.compatibility.summary.pass}],
                    ['<@spring.message "project.report.chart.run_error"/>', ${taskResult.result.totalSummary.compatibility.summary.runError}],
                    ['<@spring.message "project.report.chart.notRun"/>', ${taskResult.result.totalSummary.compatibility.summary.notRun}],
                    ['<@spring.message "project.report.chart.install_error"/>', ${taskResult.result.totalSummary.compatibility.summary.installError}],
                    ['<@spring.message "project.report.chart.uninstall_error"/>', ${taskResult.result.totalSummary.compatibility.summary.uninstallError}]
                ],*/
                type: 'pie',
            },
            color: {
                pattern: ["#009933",
                    "#E9595B",
                    "#526069",
                    "#ffe642",
                    "#2c41ff"
                ]
            },
            legend: {
                position: 'bottom'
            },
            size: {
                width: 300,
                height: 300
            },
            pie: {
                label: {
                    show: false
                },
                onclick: function (d, i) {
                },
                onmouseover: function (d, i) {
                },
                onmouseout: function (d, i) {
                }
            }
        });

        var getTermObj = function (devTermObj, option) {
            var cpyDev = devTermObj.subTaskResult.compatibility;
            //var cpyDev = devTermObj.result.all;
            var filterName = [];
            var passNumArr = [];
            var failNumArr = [];
            passNumArr.push("<@spring.message "project.report.pass"/>");
            failNumArr.push("<@spring.message "project.report.notPass"/>");
            // get filter
            for (var filter in devTermObj[option]) {
                filterName.push(filter);
                var passObj = [];
                var failObj = [];

                // get value
                var i = 0, len = cpyDev.length;
                for (i; i < len; i++) {
                    if (cpyDev[i][option] == filter) {
                        if (cpyDev[i].install == "pass" && cpyDev[i].uninstall == "pass" && cpyDev[i].stability == "pass") {
                            passObj.push(cpyDev[i]);
                        } else {
                            failObj.push(cpyDev[i]);
                        }
                    }
                }
                passNumArr.push(passObj.length);
                failNumArr.push(failObj.length);
            }
            return {
                filterName: filterName,
                passNumArr: passNumArr,
                failNumArr: failNumArr
            }
        }
        var data_jixing_brand = getTermObj($taskResult.result.deviceDetail, "brand");
        var data_jixing_os = getTermObj($taskResult.result.deviceDetail, "os");
        var data_jixing_resolution = getTermObj($taskResult.result.deviceDetail, "resolution");
        var change_select = function (aim, data) {
            aim.load({
                columns: [
                    data.passNumArr,
                    data.failNumArr
                ],
                categories: data.filterName
            });
        }
        var $bar_jixingzhanbi = c3.generate({
            bindto: '#bar_jixingzhanbi',
            size: {
                height: 340,
                width: 600
            },
            data: {
                columns: [
                    data_jixing_brand.passNumArr,
                    data_jixing_brand.failNumArr
                ],
                type: 'bar',
                groups: [
                    ['<@spring.message "project.report.pass"/>', '<@spring.message "project.report.notPass"/>']
                ]
            },
            color: {
                pattern: ["#5CD29D",
                    "#E9595B"
                ]
            },
            bar: {
                width: {
                    ratio: 0.5 // this makes bar width 50% of length between ticks
                }
                // or
                //width: 100 // this makes bar width 100px
            },
            axis: {
                x: {
                    type: 'category',
                    categories: data_jixing_brand.filterName
                }
            }
        });
        $("#jixingzhanbi_select").change(function () {
            var filter = $(this).val();
            if (filter == 1) {
                change_select($bar_jixingzhanbi, data_jixing_brand);
            } else if (filter == 2) {
                change_select($bar_jixingzhanbi, data_jixing_os);
            } else {
                change_select($bar_jixingzhanbi, data_jixing_resolution);
            }
        });

    </#if>

    <#if taskResult.result.totalSummary.case??>
        var $pie_jiaoben = c3.generate({
            bindto: '#pie_jiaoben',
            data: {
                // iris data from R
                columns: [
                    ['<@spring.message "project.report.chart.pass"/>', ${taskResult.result.totalSummary.case.summary.pass}],
                    ['<@spring.message "project.report.chart.run_error"/>', ${taskResult.result.totalSummary.case.summary.fail}]
                ],
                /*columns: [
                    ['<@spring.message "project.report.chart.pass"/>', ${taskResult.result.totalSummary.case.summary.pass}],
                    ['<@spring.message "project.report.chart.run_error"/>', ${taskResult.result.totalSummary.case.summary.runError}],
                    ['<@spring.message "project.report.chart.notRun"/>', ${taskResult.result.totalSummary.case.summary.notRun}],
                    ['<@spring.message "project.report.chart.install_error"/>', ${taskResult.result.totalSummary.case.summary.installError}],
                    ['<@spring.message "project.report.chart.uninstall_error"/>', ${taskResult.result.totalSummary.case.summary.uninstallError}]
                ],*/
                type: 'pie',
            },
            color: {
                pattern: ["#009933",
                    "#E9595B",
                    "#526069",
                    "#ffe642",
                    "#2c41ff"
                ]
            },
            legend: {
                position: 'bottom'
            },
            size: {
                width: 300,
                height: 300
            },
            pie: {
                label: {
                    show: false
                },
                onclick: function (d, i) {
                },
                onmouseover: function (d, i) {
                },
                onmouseout: function (d, i) {
                }
            }
        });
    </#if>

    <#if taskResult.result.totalSummary.travel??>
        var $pie_jiaoben = c3.generate({
            bindto: '#pie_bianli',
            data: {
                // iris data from R
                columns: [
                    ['<@spring.message "project.report.chart.pass"/>', ${taskResult.result.totalSummary.travel.summary.pass}],
                    ['<@spring.message "project.report.chart.run_error"/>', ${taskResult.result.totalSummary.travel.summary.fail}]
                ],
                /*columns: [
                    ['<@spring.message "project.report.chart.pass"/>', ${taskResult.result.totalSummary.travel.summary.pass}],
                    ['<@spring.message "project.report.chart.run_error"/>', ${taskResult.result.totalSummary.travel.summary.runError}],
                    ['<@spring.message "project.report.chart.notRun"/>', ${taskResult.result.totalSummary.travel.summary.notRun}],
                    ['<@spring.message "project.report.chart.install_error"/>', ${taskResult.result.totalSummary.travel.summary.installError}],
                    ['<@spring.message "project.report.chart.uninstall_error"/>', ${taskResult.result.totalSummary.travel.summary.uninstallError}]
                ],*/
                type: 'pie',
            },
            color: {
                pattern: ["#009933",
                    "#E9595B",
                    "#526069",
                    "#ffe642",
                    "#2c41ff"
                ]
            },
            legend: {
                position: 'bottom'
            },
            size: {
                width: 300,
                height: 300
            },
            pie: {
                label: {
                    show: false
                },
                onclick: function (d, i) {
                },
                onmouseover: function (d, i) {
                },
                onmouseout: function (d, i) {
                }
            }
        });
    </#if>

        var $pieProgress = $("#examplePieApi");
        //$pieProgress.asPieProgress('start');
        //var rate = '${taskResult.result.totalSummary.successRate}%'
        //$pieProgress.asPieProgress('go', rate);
        var performance = {};
        /*var parsePf = function (performance) {
            for(phone in performance.cpu_avg.worst_5){
                console.info()
            }
        };*/

        //性能图表
        var performance = $taskResult.result.deviceDetail.performance;
        var parsePf = function (performance) {
            var performance_data = {
                cpu:{
                    name:[],
                    value:["<@spring.message "project.report.chart.per.CPU"/>"]
                },
                mem:{
                    name:[],
                    value:["<@spring.message "project.report.chart.per.MEM"/>"]
                },
                power:{
                    name:[],
                    value:["<@spring.message "project.report.chart.per.Bat"/>"]
                },
                launch_time:{
                    name:[],
                    value:["<@spring.message "project.report.chart.per.Lau"/>"]
                },
                net:{
                    name:[],
                    value:["<@spring.message "project.report.chart.per.NET"/>"]
                },
            };
            for(index in performance.cpu_avg.worst_5){
                var phone = performance.cpu_avg.worst_5[index];
                performance_data.cpu.name.push(phone.name);
                performance_data.cpu.value.push(phone.performance.cpu_avg);
            }
            for(index in performance.mem_max.worst_5){
                var phone = performance.mem_max.worst_5[index];
                performance_data.mem.name.push(phone.name);
                performance_data.mem.value.push(phone.performance.mem_max);
            }
            for(index in performance.power_usage.worst_5){
                var phone = performance.power_usage.worst_5[index];
                performance_data.power.name.push(phone.name);
                performance_data.power.value.push(phone.performance.power_usage);
            }
            for(index in performance.launch_time.worst_5){
                var phone = performance.launch_time.worst_5[index];
                performance_data.launch_time.name.push(phone.name);
                performance_data.launch_time.value.push(phone.performance.launch_time);
            }
            for(index in performance.net_send.worst_5){
                var phone = performance.net_send.worst_5[index];
                performance_data.net.name.push(phone.name);
                performance_data.net.value.push(phone.performance.net_send);
            }
            return performance_data;
        };
        var performance_data = parsePf(performance);

        var per_cpu = c3.generate({
            bindto: '#performance_cpu',
            data: {
                columns: [
                    performance_data.cpu.value
                ],
                type: 'bar',
            },
            size: {
                width: 400,
                height: 280
            },
            /*color: {
             pattern: [Config.colors("primary", 500), Config.colors("blue-grey", 200)]
             },*/
            axis: {
                x: {
                    type: 'category',
                    categories: performance_data.cpu.name
                }
            },
            bar: {
                width: {
                    ratio: 0.5 // this makes bar width 50% of length between ticks
                }
            }
        });

        var per_mem = c3.generate({
            bindto: '#performance_mem',
            data: {
                columns: [
                    performance_data.mem.value
                ],
                type: 'bar',
            },
            size: {
                width: 400,
                height: 280
            },
            /*color: {
             pattern: [Config.colors("primary", 500), Config.colors("blue-grey", 200)]
             },*/
            axis: {
                x: {
                    type: 'category',
                    categories: performance_data.mem.name
                }
            },
            bar: {
                width: {
                    ratio: 0.5 // this makes bar width 50% of length between ticks
                }
            }
        });

        var per_net = c3.generate({
            bindto: '#performance_traffic',
            data: {
                columns: [
                    performance_data.net.value
                ],
                type: 'bar',
            },
            size: {
                width: 400,
                height: 280
            },
            /*color: {
             pattern: [Config.colors("primary", 500), Config.colors("blue-grey", 200)]
             },*/
            axis: {
                x: {
                    type: 'category',
                    categories: performance_data.net.name
                }
            },
            bar: {
                width: {
                    ratio: 0.5 // this makes bar width 50% of length between ticks
                }
            }
        });

        var per_power = c3.generate({
            bindto: '#performance_elect',
            data: {
                columns: [
                    performance_data.power.value
                ],
                type: 'bar',
            },
            size: {
                width: 400,
                height: 280
            },
            /*color: {
             pattern: [Config.colors("primary", 500), Config.colors("blue-grey", 200)]
             },*/
            axis: {
                x: {
                    type: 'category',
                    categories: performance_data.power.name
                }
            },
            bar: {
                width: {
                    ratio: 0.5 // this makes bar width 50% of length between ticks
                }
            }
        });

        var per_launch = c3.generate({
            bindto: '#performance_start',
            data: {
                columns: [
                    performance_data.launch_time.value
                ],
                type: 'bar',
            },
            size: {
                width: 400,
                height: 280
            },
            /*color: {
             pattern: [Config.colors("primary", 500), Config.colors("blue-grey", 200)]
             },*/
            axis: {
                x: {
                    type: 'category',
                    categories: performance_data.launch_time.name
                }
            },
            bar: {
                width: {
                    ratio: 0.5 // this makes bar width 50% of length between ticks
                }
            }
        });



    });
</script>
</body>
</html>