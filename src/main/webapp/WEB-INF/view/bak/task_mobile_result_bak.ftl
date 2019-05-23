<!DOCTYPE html>
<html class="no-js css-menubar" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="author" content="">
    <title><@spring.message "project.DetailTitle"/></title>
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

    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/blueimp-file-upload/jquery.fileupload.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/dropify/dropify.css">

    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/select2/select2.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/bootstrap-select/bootstrap-select.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/c3/c3.css">

    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/aspieprogress/asPieProgress.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/assets/examples/css/charts/pie-progress.css">

    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/icheck/icheck.css">
    <link rel="stylesheet" href="${rc.contextPath}/static/global/vendor/plyr/plyr.css">


    <link rel="stylesheet" href="${rc.contextPath}/static/assets/examples/css/advanced/scrollable.css">
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

<!-- include sitemenu ftl beg -->
<#include "/project/project_side.ftl">
<!-- include sitemenu ftl end -->
<!-- Page -->
<div class="page">
    <div class="page-header p-t-10 p-b-10">
        <!--<h1 class="page-title">Page Title</h1>-->
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${rc.contextPath}/mainpage">
            <@spring.message "project.DetailContextPathHome"/>
            </a></li>
            <li class="breadcrumb-item"><a href="${rc.contextPath}/project/${currentProject.id}">${currentProject.projectName}</a></li>
            <li class="breadcrumb-item"><a href="${rc.contextPath}/project/${currentProject.id}/task/${currentTask.id}">
            <@spring.message "project.DetailContextPath"/>（${currentTask.taskName}）</a></li>
            <li class="breadcrumb-item active">
            <@spring.message "project.DetailContextPathTitle"/>
            </li>
        </ol>
    </div>
    <div class="page-content">
        <div class="panel">
            <div class="panel-heading">
                <h3 class="panel-title"><i class="icon wb-mobile" aria-hidden="true"></i>
                <@spring.message "project.DetailTable"/>
                </h3>
                <div class="panel-actions">
                    <a class="panel-action icon wb-minus" data-toggle="panel-collapse" aria-expanded="true"
                       aria-hidden="true"></a>
                </div>
            </div>
            <div class="panel-body">
                <!-- 顶部切换手机 beg -->
                <div class="row">
                    <div class="col-md-6">
                        <h5 class="inline-block">
                        <@spring.message "project.DetailMobile"/>
                        </h5>${taskMobileResult.result.device.name}
                    </div>
                    <div class="col-md-6">
                        <div class="form-group row">
                            <label class="m-b-0 col-xs-12 col-md-4 form-control-label text-lg-right">
                            <@spring.message "project.DetailSelect"/>
                            </label>
                            <div class="col-md-8 col-xs-12">
                            <select id="phone_select" class="form-control" data-plugin="select2">
                                <#list taskResult.result.deviceDetail.result.all as phone>
                                    <#if currentPhone == phone.serial_number>
                                        <option value="${phone.serial_number}" selected>${phone.model}</option>
                                    <#else >
                                        <option value="${phone.serial_number}">${phone.model}</option>
                                    </#if>
                                </#list>
                            </select>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 顶部切换手机 end -->
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th><@spring.message "project.DetailType"/></th>
                            <th><@spring.message "project.DetailInstall"/></th>
                            <th><@spring.message "project.DetailRun"/></th>
                            <th><@spring.message "project.DetailUnstall"/></th>
                            <th><@spring.message "project.DetailStart"/>(MS)</th>
                            <th><@spring.message "project.DetailCPU"/>(%)</th>
                            <th><@spring.message "project.DetailRAM"/>(KB)</th>
                            <th><@spring.message "project.DetailFlow"/></th>
                            <th><@spring.message "project.DetailBattery"/>(MAH)</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if taskMobileResult.result.device.detail.compatibility??>
                        <tr>
                            <td>
                                ${taskMobileResult.result.device.detail.compatibility.cnName}
                            </td>
                            <td>
                                <#if taskMobileResult.result.device.detail.compatibility.mtcInstall == "pass">
                                    <@spring.message "project.report.chart.Success"/>
                                <#elseif taskMobileResult.result.device.detail.compatibility.mtcInstall == "fail">
                                    <@spring.message "project.report.chart.Fail"/>
                                <#elseif taskMobileResult.result.device.detail.compatibility.mtcInstall == "notRun">
                                    <@spring.message "project.report.chart.NotRun"/>
                                </#if>
                            </td>
                            <td>
                                <#if taskMobileResult.result.device.detail.compatibility.stability == "pass">
                                    <@spring.message "project.report.chart.Success"/>
                                <#elseif taskMobileResult.result.device.detail.compatibility.stability == "fail">
                                    <@spring.message "project.report.chart.Fail"/>
                                <#elseif taskMobileResult.result.device.detail.compatibility.stability == "notRun">
                                    <@spring.message "project.report.chart.NotRun"/>
                                </#if>
                            </td>
                            <td>
                                <#if taskMobileResult.result.device.detail.compatibility.uninstall == "pass">
                                    <@spring.message "project.report.chart.Success"/>
                                <#elseif taskMobileResult.result.device.detail.compatibility.uninstall == "fail">
                                    <@spring.message "project.report.chart.Fail"/>
                                <#elseif taskMobileResult.result.device.detail.compatibility.uninstall == "notRun">
                                    <@spring.message "project.report.chart.NotRun"/>
                                </#if>
                            </td>
                            <td>
                            ${taskMobileResult.result.device.detail.compatibility.launch_time}
                            </td>
                            <td>
                            ${taskMobileResult.result.device.detail.compatibility.cup_avg}
                            </td>
                            <td>
                            ${taskMobileResult.result.device.detail.compatibility.mem_max}
                            </td>
                            <td>
                            ${taskMobileResult.result.device.detail.compatibility.net_recv} /
                            ${taskMobileResult.result.device.detail.compatibility.net_send}
                            </td>
                            <td>
                            ${taskMobileResult.result.device.detail.compatibility.power_usage}
                            </td>
                        </tr>
                        </#if>

                        <#if taskMobileResult.result.device.detail.case??>
                        <tr>
                            <td>
                            ${taskMobileResult.result.device.detail.case.cnName}
                            </td>
                            <td>
                                <#if taskMobileResult.result.device.detail.case.mtcInstall == "pass">
                                    <@spring.message "project.report.chart.Success"/>
                                <#elseif taskMobileResult.result.device.detail.case.mtcInstall == "fail">
                                    <@spring.message "project.report.chart.Fail"/>
                                <#elseif taskMobileResult.result.device.detail.case.mtcInstall == "notRun">
                                    <@spring.message "project.report.chart.NotRun"/>
                                </#if>
                            </td>
                            <td>
                                <#if taskMobileResult.result.device.detail.case.stability == "pass">
                                    <@spring.message "project.report.chart.Success"/>
                                <#elseif taskMobileResult.result.device.detail.case.stability == "fail">
                                    <@spring.message "project.report.chart.Fail"/>
                                <#elseif taskMobileResult.result.device.detail.case.stability == "notRun">
                                    <@spring.message "project.report.chart.NotRun"/>
                                </#if>
                            </td>
                            <td>
                                <#if taskMobileResult.result.device.detail.case.uninstall == "pass">
                                    <@spring.message "project.report.chart.Success"/>
                                <#elseif taskMobileResult.result.device.detail.case.uninstall == "fail">
                                    <@spring.message "project.report.chart.Fail"/>
                                <#elseif taskMobileResult.result.device.detail.case.uninstall == "notRun">
                                    <@spring.message "project.report.chart.NotRun"/>
                                </#if>
                            </td>
                            <td>
                            ${taskMobileResult.result.device.detail.case.launch_time}
                            </td>
                            <td>
                            ${taskMobileResult.result.device.detail.case.cup_avg}
                            </td>
                            <td>
                            ${taskMobileResult.result.device.detail.case.mem_max}
                            </td>
                            <td>
                            ${taskMobileResult.result.device.detail.case.net_recv} /
                            ${taskMobileResult.result.device.detail.case.net_send}
                            </td>
                            <td>
                            ${taskMobileResult.result.device.detail.case.power_usage}
                            </td>
                        </tr>
                        </#if>

                        <#if taskMobileResult.result.device.detail.travel??>
                        <tr>
                            <td>
                            ${taskMobileResult.result.device.detail.travel.cnName}
                            </td>
                            <td>
                                <#if taskMobileResult.result.device.detail.travel.mtcInstall == "pass">
                                    <@spring.message "project.report.chart.Success"/>
                                <#elseif taskMobileResult.result.device.detail.travel.mtcInstall == "fail">
                                    <@spring.message "project.report.chart.Fail"/>
                                <#elseif taskMobileResult.result.device.detail.travel.mtcInstall == "notRun">
                                    <@spring.message "project.report.chart.NotRun"/>
                                </#if>
                            </td>
                            <td>
                                <#if taskMobileResult.result.device.detail.travel.stability == "pass">
                                    <@spring.message "project.report.chart.Success"/>
                                <#elseif taskMobileResult.result.device.detail.travel.stability == "fail">
                                    <@spring.message "project.report.chart.Fail"/>
                                <#elseif taskMobileResult.result.device.detail.travel.stability == "notRun">
                                    <@spring.message "project.report.chart.NotRun"/>
                                </#if>
                            </td>
                            <td>
                                <#if taskMobileResult.result.device.detail.travel.uninstall == "pass">
                                    <@spring.message "project.report.chart.Success"/>
                                <#elseif taskMobileResult.result.device.detail.travel.uninstall == "fail">
                                    <@spring.message "project.report.chart.Fail"/>
                                <#elseif taskMobileResult.result.device.detail.travel.uninstall == "notRun">
                                    <@spring.message "project.report.chart.NotRun"/>
                                </#if>
                            </td>
                            <td>
                            ${taskMobileResult.result.device.detail.travel.launch_time}
                            </td>
                            <td>
                            ${taskMobileResult.result.device.detail.travel.cup_avg}
                            </td>
                            <td>
                            ${taskMobileResult.result.device.detail.travel.mem_max}
                            </td>
                            <td>
                            ${taskMobileResult.result.device.detail.travel.net_recv} /
                            ${taskMobileResult.result.device.detail.travel.net_send}
                            </td>
                            <td>
                            ${taskMobileResult.result.device.detail.travel.power_usage}
                            </td>
                        </tr>
                        </#if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- 结果 tab beg -->
        <div class="nav-tabs-horizontal nav-tabs-inverse nav-tabs-animate" data-plugin="tabs">
            <ul class="nav nav-tabs nav-tabs-solid" role="tablist">
                <#if taskMobileResult.result.log.compatibility??>
                    <li class="nav-item" role="presentation">
                        <a class="nav-link active" data-toggle="tab" href="#mobile_result_jianrong"
                           aria-controls="exampleTabsSolidInverseTwo"
                           role="tab">
                            <@spring.message "project.DetailCompatibility"/>
                        </a>
                    </li>
                </#if>
                <#if taskMobileResult.result.log.case??>
                <li class="nav-item" role="presentation">
                    <a class="nav-link " data-toggle="tab" href="#mobile_result_jiaoben"
                       aria-controls="exampleTabsSolidInverseOne" role="tab">
                        <@spring.message "project.DetailScript"/>
                    </a>
                </li>
                </#if>
                <#if taskMobileResult.result.log.travel??>
                <li class="nav-item" role="presentation">
                    <a class="nav-link" data-toggle="tab" href="#mobile_result_bianli"
                       aria-controls="exampleTabsSolidInverseTwo"
                       role="tab">
                        <@spring.message "project.DetailTravel"/>
                    </a>
                </li>
                </#if>
            </ul>
            <div class="tab-content">
                <#if taskMobileResult.result.log.compatibility??>
                <div class="tab-pane active animation-slide-top" id="mobile_result_jianrong" role="tabpanel">
                    <div class="nav-tabs-horizontal nav-tabs-animate" data-plugin="tabs">
                        <ul class="nav nav-tabs nav-tabs-line" role="tablist">
                            <li class="nav-item" role="presentation"><a class="nav-link active" data-toggle="tab" href="#m_r_jr_screenshot"
                                                                        aria-controls="exampleTabsLineOne" role="tab"><@spring.message "project.DetailComScreen"/></a></li>
                            <li class="nav-item" role="presentation"><a class="nav-link" data-toggle="tab" href="#m_r_jr_installlog"
                                                                        aria-controls="exampleTabsLineTwo" role="tab">
                                <@spring.message "project.DetailComInstall"/>
                            </a></li>
                            <li class="nav-item" role="presentation"><a class="nav-link" data-toggle="tab" href="#m_r_jr_logcat"
                                                                        aria-controls="exampleTabsLineThree" role="tab">
                                <@spring.message "project.DetailComLogcat"/>
                            </a></li>
                            <li class="nav-item" role="presentation"><a class="nav-link" data-toggle="tab" href="#m_r_jr_shelllog"
                                                                        aria-controls="exampleTabsLineFour" role="tab">
                                <@spring.message "project.DetailComLog"/>
                            </a></li>
                            <li class="nav-item" role="presentation"><a class="nav-link" data-toggle="tab" href="#m_r_jr_xingneng"
                                                                        aria-controls="exampleTabsLineFour" role="tab">
                                <@spring.message "project.DetailComPerfor"/>
                            </a></li>
                            <li class="nav-item" role="presentation"><a class="nav-link" data-toggle="tab" href="#m_r_jr_video"
                                                                        aria-controls="exampleTabsLineFour" role="tab">
                                <@spring.message "project.DetailComVideo"/>
                            </a></li>
                        </ul>
                        <div class="tab-content p-t-20">
                            <div class="tab-pane active animation-scale-up" id="m_r_jr_screenshot" role="tabpanel">
                                <div class="row">
                                    <#list taskMobileResult.result.log.compatibility.screenshot as screenshot>
                                    <div class="col-md-2 col-lg-2 m-t-15">
                                        <img src="${screenshot}" class="img-rounded" style="width:100%;"/>
                                    </div>
                                    </#list>
                                </div>
                            </div>
                            <div class="tab-pane animation-scale-up" id="m_r_jr_installlog" role="tabpanel">
                                <#list taskMobileResult.result.log.compatibility.installLogContent as installLog>
                                    <p>${installLog}</p>
                                </#list>
                            </div>
                            <div class="tab-pane animation-scale-up" id="m_r_jr_logcat" role="tabpanel">
                                <div>
                                    <a href="${taskMobileResult.result.log.compatibility.logcat}" class="btn btn-xs btn-primary"> <i class="icon wb-download"></i> 下载logcat</a>
                                </div>
                                <iframe style="width:100%;height:460px;border:0;padding:0;margin:0;overflow:hidden;"
                                      src="http://10.0.40.49:8001/reportDetail/logcat?url=${taskMobileResult.result.log.compatibility.logcat}">
                                </iframe>
                            </div>
                            <div class="tab-pane animation-scale-up" id="m_r_jr_shelllog" role="tabpanel">
                                <div class="row bg-dark p-10">
                                    <div class="col-md-12 col-lg-12">
                                        <div class="h-450" data-skin="scrollable-inverse" data-plugin="scrollable">
                                            <div data-role="container" style="min-width: 500px;">
                                                <div data-role="content" style="min-width: 500px;">
                                                    <#list taskMobileResult.result.log.compatibility.monkeyLogContent as mokeyLog>
                                                        <p>${mokeyLog}</p>
                                                    </#list>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane animation-scale-up" id="m_r_jr_xingneng" role="tabpanel">
                                <h4><i class="icon wb-medium-point"></i>
                                    <@spring.message "project.DetailComCPU"/></h4>
                                <div class="row">
                                    <div class="col-md-12 col-lg-12">
                                        <div id="m_r_jr_xingneng_cpu"></div>
                                    </div>
                                </div>
                                <h4><i class="icon wb-medium-point"></i> <@spring.message "project.DetailComRAM"/></h4>
                                <div class="row">
                                    <div class="col-md-12 col-lg-12">
                                        <div id="m_r_jr_xingneng_mem"></div>
                                    </div>
                                </div>
                                <h4><i class="icon wb-medium-point"></i> <@spring.message "project.DetailComFlow"/></h4>
                                <div class="row">
                                    <div class="col-md-12 col-lg-12">
                                        <div id="m_r_jr_xingneng_liuliang"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane animation-scale-up" id="m_r_jr_video" role="tabpanel">
                                <div class="row">
                                    <#list taskMobileResult.result.log.compatibility.mp4File as video>
                                    <div class="col-md-4 col-lg-3">
                                        <div class="cover player" data-plugin="plyr">
                                            <video controls>
                                                <source type="video/mp4" src="${video}">
                                                <!-- Fallback For Browsers That Don'T Support The <Video> Element -->
                                                <a href="${video}">下载屏幕录像</a>
                                            </video>
                                        </div>
                                    </div>
                                    </#list>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </#if>
                <#if taskMobileResult.result.log.case??>
                <div class="tab-pane  animation-slide-top" id="mobile_result_jiaoben" role="tabpanel">
                    <div class="nav-tabs-horizontal nav-tabs-animate" data-plugin="tabs">
                        <ul class="nav nav-tabs nav-tabs-line" role="tablist">
                            <li class="nav-item" role="presentation"><a class="nav-link active" data-toggle="tab" href="#m_r_j_screenshot"
                                                                        aria-controls="exampleTabsLineOne" role="tab"><@spring.message "project.DetailScriptScreen"/></a></li>
                            <li class="nav-item" role="presentation"><a class="nav-link" data-toggle="tab" href="#m_r_j_installlog"
                                                                        aria-controls="exampleTabsLineTwo" role="tab">
                                <@spring.message "project.DetailScriptInstall"/>
                            </a></li>
                            <li class="nav-item" role="presentation"><a class="nav-link" data-toggle="tab" href="#m_r_j_logcat"
                                                                        aria-controls="exampleTabsLineThree" role="tab">
                                <@spring.message "project.DetailScriptLogcat"/>
                            </a></li>
                            <li class="nav-item" role="presentation"><a class="nav-link" data-toggle="tab" href="#m_r_j_shelllog"
                                                                        aria-controls="exampleTabsLineFour" role="tab">
                                <@spring.message "project.DetailScriptLog"/>
                            </a></li>
                            <li class="nav-item" role="presentation"><a class="nav-link" data-toggle="tab" href="#m_r_j_xingneng"
                                                                        aria-controls="exampleTabsLineFour" role="tab"><@spring.message "project.DetailScriptPerfor"/></a></li>
                            <li class="nav-item" role="presentation"><a class="nav-link" data-toggle="tab" href="#m_r_j_video"
                                                                        aria-controls="exampleTabsLineFour" role="tab">
                                <@spring.message "project.DetailScriptVideo"/>
                            </a></li>
                        </ul>
                        <div class="tab-content p-t-20">
                            <div class="tab-pane active animation-scale-up" id="m_r_j_screenshot" role="tabpanel">
                                <div class="row">
                                    <#list taskMobileResult.result.log.case.screenshot as screenshot>
                                        <div class="col-md-2 col-lg-2 m-t-15">
                                            <img src="${screenshot}" class="img-rounded" style="width:100%;"/>
                                        </div>
                                    </#list>
                                </div>
                            </div>
                            <div class="tab-pane animation-scale-up" id="m_r_j_installlog" role="tabpanel">
                                <div class="row bg-dark p-10">
                                    <div class="col-md-12 col-lg-12">
                                        <div class="h-450" data-skin="scrollable-inverse" data-plugin="scrollable">
                                            <div data-role="container" style="min-width: 500px;">
                                                <div data-role="content" style="min-width: 500px;">
                                                    <#list taskMobileResult.result.log.case.installLogContent as installLog>
                                                        <p>${installLog}</p>
                                                    </#list>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane animation-scale-up" id="m_r_j_logcat" role="tabpanel">
                                <#list taskMobileResult.result.log.case.logcatContent as logcatLog>
                                    <p>${logcatLog}</p>
                                </#list>
                            </div>
                            <div class="tab-pane animation-scale-up" id="m_r_j_shelllog" role="tabpanel">
                                <#list taskMobileResult.result.log.case.monkeyLogContent as mokeyLog>
                                    <p>${mokeyLog}</p>
                                </#list>
                            </div>
                            <div class="tab-pane animation-scale-up" id="m_r_j_xingneng" role="tabpanel">
                                <h4><i class="icon wb-medium-point"></i>
                                    <@spring.message "project.DetailScriptCPU"/></h4>
                                <div class="row">
                                    <div class="col-md-12 col-lg-12">
                                        <div id="m_r_j_xingneng_cpu"></div>
                                    </div>
                                </div>
                                <h4><i class="icon wb-medium-point"></i>
                                    <@spring.message "project.DetailScriptRAM"/></h4>
                                <div class="row">
                                    <div class="col-md-12 col-lg-12">
                                        <div id="m_r_j_xingneng_mem"></div>
                                    </div>
                                </div>
                                <h4><i class="icon wb-medium-point"></i>
                                    <@spring.message "project.DetailScriptFlow"/></h4>
                                <div class="row">
                                    <div class="col-md-12 col-lg-12">
                                        <div id="m_r_j_xingneng_liuliang"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane animation-scale-up" id="m_r_j_video" role="tabpanel">
                                <div class="row">
                                    <#list taskMobileResult.result.log.case.mp4File as video>
                                        <div class="col-md-4 col-lg-3">
                                            <div class="cover player" data-plugin="plyr">
                                                <video controls>
                                                    <source type="video/mp4" src="${video}">
                                                    <!-- Fallback For Browsers That Don'T Support The <Video> Element -->
                                                    <a href="${video}">下载屏幕录像</a>
                                                </video>
                                            </div>
                                        </div>
                                    </#list>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </#if>
                <#if taskMobileResult.result.log.travel??>
                <div class="tab-pane animation-slide-top" id="mobile_result_bianli" role="tabpanel">
                    <div class="nav-tabs-horizontal nav-tabs-animate" data-plugin="tabs">
                        <ul class="nav nav-tabs nav-tabs-line" role="tablist">
                            <li class="nav-item" role="presentation"><a class="nav-link active" data-toggle="tab" href="#m_r_b_screenshot"
                                                                        aria-controls="exampleTabsLineOne" role="tab"><@spring.message "project.DetailTravelScreen"/></a></li>
                            <li class="nav-item" role="presentation"><a class="nav-link" data-toggle="tab" href="#m_r_b_installlog"
                                                                        aria-controls="exampleTabsLineTwo" role="tab">
                                <@spring.message "project.DetailTravelInstall"/>
                            </a></li>
                            <li class="nav-item" role="presentation"><a class="nav-link" data-toggle="tab" href="#m_r_b_logcat"
                                                                        aria-controls="exampleTabsLineThree" role="tab">
                                <@spring.message "project.DetailTravelLogcat"/>
                            </a></li>
                            <li class="nav-item" role="presentation"><a class="nav-link" data-toggle="tab" href="#m_r_b_xingneng"
                                                                        aria-controls="exampleTabsLineFour" role="tab">
                                <@spring.message "project.DetailTravelPerfor"/>
                            </a></li>
                            <li class="nav-item" role="presentation"><a class="nav-link" data-toggle="tab" href="#m_r_b_video"
                                                                        aria-controls="exampleTabsLineFour" role="tab">
                                <@spring.message "project.DetailTravelVideo"/>
                            </a></li>
                        </ul>
                        <div class="tab-content p-t-20">
                            <div class="tab-pane active animation-scale-up" id="m_r_b_screenshot" role="tabpanel">
                                <div class="row">
                                <#list taskMobileResult.result.log.travel.screenshot as screenshot>
                                    <div class="col-md-2 col-lg-2 m-t-15">
                                        <img src="${screenshot}" class="img-rounded" style="width:100%;"/>
                                    </div>
                                </#list>
                                </div>
                            </div>
                            <div class="tab-pane animation-scale-up" id="m_r_b_installlog" role="tabpanel">
                                <div class="row bg-dark p-10">
                                    <div class="col-md-12 col-lg-12">
                                        <div class="h-450" data-skin="scrollable-inverse" data-plugin="scrollable">
                                            <div data-role="container" style="min-width: 500px;">
                                                <div data-role="content" style="min-width: 500px;">
                                                    <#list taskMobileResult.result.log.travel.installLogContent as installLog>
                                                        <p>${installLog}</p>
                                                    </#list>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane animation-scale-up" id="m_r_b_logcat" role="tabpanel">
                                <#list taskMobileResult.result.log.travel.logcatContent as logcatLog>
                                    <p>${logcatLog}</p>
                                </#list>
                            </div>
                            <div class="tab-pane animation-scale-up" id="m_r_b_xingneng" role="tabpanel">
                                <h4><i class="icon wb-medium-point"></i> <@spring.message "project.DetailTravelCPU"/></h4>
                                <div class="row">
                                    <div class="col-md-12 col-lg-12">
                                        <div id="m_r_b_xingneng_cpu"></div>
                                    </div>
                                </div>
                                <h4><i class="icon wb-medium-point"></i> <@spring.message "project.DetailTravelRAM"/></h4>
                                <div class="row">
                                    <div class="col-md-12 col-lg-12">
                                        <div id="m_r_b_xingneng_mem"></div>
                                    </div>
                                </div>
                                <h4><i class="icon wb-medium-point"></i>
                                    <@spring.message "project.DetailTravelFlow"/></h4>
                                <div class="row">
                                    <div class="col-md-12 col-lg-12">
                                        <div id="m_r_b_xingneng_liuliang"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane animation-scale-up" id="m_r_b_video" role="tabpanel">
                                <#list taskMobileResult.result.log.travel.mp4File as video>
                                    <div class="col-md-4 col-lg-3">
                                        <div class="cover player" data-plugin="plyr">
                                            <video controls>
                                                <source type="video/mp4" src="${video}">
                                                <!-- Fallback For Browsers That Don'T Support The <Video> Element -->
                                                <a href="${video}">下载屏幕录像</a>
                                            </video>
                                        </div>
                                    </div>
                                </#list>
                            </div>
                        </div>
                    </div>
                </div>
                </#if>
            </div>
        </div>
        <!-- 结果 tab end -->
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
<script src="${rc.contextPath}/static/global/vendor/d3/d3.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/c3/c3.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/aspieprogress/jquery-asPieProgress.js"></script>

<script src="${rc.contextPath}/static/global/vendor/matchheight/jquery.matchHeight-min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/icheck/icheck.min.js"></script>
<script src="${rc.contextPath}/static/global/vendor/select2/select2.full.min.js"></script>

<script src="${rc.contextPath}/static/global/vendor/plyr/plyr.js"></script>
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

<script src="${rc.contextPath}/static/global/js/Plugin/tabs.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/aspieprogress.js"></script>

<script src="${rc.contextPath}/static/global/js/Plugin/icheck.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/select2.js"></script>
<script src="${rc.contextPath}/static/global/js/Plugin/plyr.js"></script>

<script src="${rc.contextPath}/static/js/task/taks_mobile_result.js"></script>

<script src="${rc.contextPath}/static/assets/examples/js/advanced/scrollable.js"></script>
<!-- datatables beg-->
<script src="${rc.contextPath}/static/global/vendor/datatables/jquery.dataTables.js"></script>
<script src="${rc.contextPath}/static/global/vendor/datatables-fixedheader/dataTables.fixedHeader.js"></script>
<script src="${rc.contextPath}/static/global/vendor/datatables-bootstrap/dataTables.bootstrap.js"></script>
<script src="${rc.contextPath}/static/global/vendor/datatables-responsive/dataTables.responsive.js"></script>
<script src="${rc.contextPath}/static/global/vendor/datatables-tabletools/dataTables.tableTools.js"></script>
<script src="${rc.contextPath}/static/js/datatable.js"></script>

<!-- datatables end-->

<script>
    (function(document, window, $) {
        'use strict';
        var Site = window.Site;
        $(document).ready(function() {
            Site.run();
        });
    })(document, window, jQuery);
</script>

<script type="text/javascript">
    $(document).ready(function () {
        //切换手机
        $("#phone_select").change(function () {
            var phone_serialNumber = $(this).val();
            window.location.href = "${rc.contextPath}/project/${currentProject.id}/task/${currentTask.id}/mobile/" + phone_serialNumber;
        });
        var taskMobileResult = ${resultMobile};
        //解析cpu 占用数据
        var parseCpuData = function (data) {
            var cpu_tu = [];
            cpu_tu.push("<@spring.message "project.DetailTravelCPU"/>");
            for(var index in data){
                var str = data[index];
                cpu_tu.push(parseCpuP(str));
            }
            return cpu_tu;
        };
        var parseCpuP = function (data) {
            return data.substring(0, data.length - 1);
        };
        //解析内存占用数据
        var parseMemData = function (data) {
            var mem_tu = [];
            mem_tu.push("<@spring.message "project.DetailTravelRAM"/>");
            for(var index in data){
                mem_tu.push(data[index]);
            }
            return mem_tu;
        };
        //解析网络数据
        var parseNetData = function (data) {
            var net_send = [];
            var net_recive = [];
            net_send.push("<@spring.message "project.DetailFolwUpward"/>");
            net_recive.push("<@spring.message "project.DetailFolwDownward"/>");
            for(var index in data.send){
                net_send.push(data.send[index]);
            }
            for(var index in data.recv){
                net_recive.push(data.recv[index]);
            }
            var net_data = [];
            net_data.push(net_send);
            net_data.push(net_recive);
            return net_data;
        };
    <#if taskMobileResult.result.device.detail.compatibility??>
        //load compatibility logcat content
        $("#compatibility_logcat_content").load("/reportDetail/logcat?t=&url=${taskMobileResult.result.log.compatibility.logcat}");
        <!-- compatibility performance detail -->

        var jianrong_cpu_data_pre = taskMobileResult.result.device.detail.compatibility.performance.all.cpu.section;
        var jianrong_mem_data_pre = taskMobileResult.result.device.detail.compatibility.performance.all.mem.section;
        var jianrong_net_data_pre = taskMobileResult.result.device.detail.compatibility.performance.all.net.raw;


        var jianrong_cpu_data = parseCpuData(jianrong_cpu_data_pre);
        var jianrong_mem_data = parseMemData(jianrong_mem_data_pre);
        var jianrong_net_data = parseNetData(jianrong_net_data_pre);
        var jianrong_cpu_bar = c3.generate({
            bindto: '#m_r_jr_xingneng_cpu',
            data: {
                columns: [
                    jianrong_cpu_data
                ]
            },
            size: {
                height: 280
            },
            /*color: {
             pattern: [Config.colors("primary", 500), Config.colors("blue-grey", 200)]
             },*/
            axis: {
                y: {
                    min: 0,
                    padding: {top:0, bottom:10}
                }
            }
        });
        var jianrong_mem_bar = c3.generate({
            bindto: '#m_r_jr_xingneng_mem',
            data: {
                columns: [
                    jianrong_mem_data
                ]
            },
            size: {
                height: 280
            },
            /*color: {
             pattern: [Config.colors("primary", 500), Config.colors("blue-grey", 200)]
             },*/
            /*axis: {
                x: {
                    type: 'category',
                    categories: ['mobile1', 'mobile2', 'mobile3', 'mobile4', 'mobile5']
                }
            }*/
        });
        var jianrong_net_bar = c3.generate({
            bindto: '#m_r_jr_xingneng_liuliang',
            data: {
                columns: jianrong_net_data
            },
            size: {
                height: 280
            },
            /*color: {
             pattern: [Config.colors("primary", 500), Config.colors("blue-grey", 200)]
             },*/
            /*axis: {
                x: {
                    type: 'category',
                    categories: ['mobile1', 'mobile2', 'mobile3', 'mobile4', 'mobile5']
                }
            }*/
        });
    </#if>

    <#if taskMobileResult.result.device.detail.case??>
        <!-- case performance detail -->
        var jiaoben_cpu_data_pre = taskMobileResult.result.device.detail.case.performance.all.cpu.section;
        var jiaoben_mem_data_pre = taskMobileResult.result.device.detail.case.performance.all.mem.section;
        var jiaoben_net_data_pre = taskMobileResult.result.device.detail.case.performance.all.net.raw;


        var jiaoben_cpu_data = parseCpuData(jiaoben_cpu_data_pre);
        var jiaoben_mem_data = parseMemData(jiaoben_mem_data_pre);
        var jiaoben_net_data = parseNetData(jiaoben_net_data_pre);
        var jiaoben_cpu_bar = c3.generate({
            bindto: '#m_r_j_xingneng_cpu',
            data: {
                columns: [
                    jiaoben_cpu_data
                ]
            },
            size: {
                height: 280
            },
            /*color: {
             pattern: [Config.colors("primary", 500), Config.colors("blue-grey", 200)]
             },*/
            /*axis: {
                x: {
                    type: 'category',
                    categories: ['mobile1', 'mobile2', 'mobile3', 'mobile4', 'mobile5']
                }
            }*/
            axis: {
                y: {
                    min: 0,
                    padding: {top:0, bottom:10}
                }
            }
        });
        var jiaoben_mem_bar = c3.generate({
            bindto: '#m_r_j_xingneng_mem',
            data: {
                columns: [
                    jiaoben_mem_data
                ]
            },
            size: {
                height: 280
            },
            /*color: {
             pattern: [Config.colors("primary", 500), Config.colors("blue-grey", 200)]
             },*/
            /*axis: {
                x: {
                    type: 'category',
                    categories: ['mobile1', 'mobile2', 'mobile3', 'mobile4', 'mobile5']
                }
            }*/
        });
        var jiaoben_net_bar = c3.generate({
            bindto: '#m_r_j_xingneng_liuliang',
            data: {
                columns: jiaoben_net_data
            },
            size: {
                height: 280
            },
            /*color: {
             pattern: [Config.colors("primary", 500), Config.colors("blue-grey", 200)]
             },*/
            /*axis: {
                x: {
                    type: 'category',
                    categories: ['mobile1', 'mobile2', 'mobile3', 'mobile4', 'mobile5']
                }
            }*/
        });
    </#if>

    <#if taskMobileResult.result.device.detail.travel??>
        <!-- travel performance detail -->
        var travel_cpu_data_pre = taskMobileResult.result.device.detail.travel.performance.all.cpu.section;
        var travel_mem_data_pre = taskMobileResult.result.device.detail.travel.performance.all.mem.section;
        var travel_net_data_pre = taskMobileResult.result.device.detail.travel.performance.all.net.raw;


        var travel_cpu_data = parseCpuData(travel_cpu_data_pre);
        var travel_mem_data = parseMemData(travel_mem_data_pre);
        var travel_net_data = parseNetData(travel_net_data_pre);
        var travel_cpu_bar = c3.generate({
            bindto: '#m_r_b_xingneng_cpu',
            data: {
                columns: [
                    travel_cpu_data
                ]
            },
            size: {
                height: 280
            },
            axis: {
                y: {
                    min: 0,
                    padding: {top:0, bottom:10}
                }
            }
            /*color: {
             pattern: [Config.colors("primary", 500), Config.colors("blue-grey", 200)]
             },*/
            /*axis: {
                x: {
                    type: 'category',
                    categories: ['mobile1', 'mobile2', 'mobile3', 'mobile4', 'mobile5']
                }
            }*/
        });
        var travel_mem_bar = c3.generate({
            bindto: '#m_r_b_xingneng_mem',
            data: {
                columns: [
                    travel_mem_data
                ]
            },
            size: {
                height: 280
            },
            /*color: {
             pattern: [Config.colors("primary", 500), Config.colors("blue-grey", 200)]
             },*/
            /*axis: {
                x: {
                    type: 'category',
                    categories: ['mobile1', 'mobile2', 'mobile3', 'mobile4', 'mobile5']
                }
            }*/
        });
        var travel_net_bar = c3.generate({
            bindto: '#m_r_b_xingneng_liuliang',
            data: {
                columns: travel_net_data
            },
            size: {
                height: 280
            },
            /*color: {
             pattern: [Config.colors("primary", 500), Config.colors("blue-grey", 200)]
             },*/
            /*axis: {
                x: {
                    type: 'category',
                    categories: ['mobile1', 'mobile2', 'mobile3', 'mobile4', 'mobile5']
                }
            }*/
        });
    </#if>
    });
</script>
</body>
</html>