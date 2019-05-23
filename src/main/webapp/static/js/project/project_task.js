/**
 * Created by xueshan.wei on 12/9/2016.
 */
$(document).ready(function () {
    var baseUrl = $("#baseUrl").attr("baseUrl");
    var taskIdArray = $("#taskIdArray").attr("taskIdArray");
    var currentProjectId = $("#currentProjectId").attr("currentProjectId");
    var currentProjectName = $("#currentProjectName").attr("currentProjectName");
    /**
     * 每5s检测更新任务状态
     */

    window.setInterval(refresh,5000);

    function refresh() {
        $.ajax({
                url: baseUrl + "/api/project/tasks",
                type: "GET",
                data: {"ids[]": taskIdArray },
                success:function(data){
                    var code = data.code;
                    if(code == "00000000"){
                        var tasks = data.data;
                        for(var i = 0; i < tasks.length; i++){
                            var taskId = tasks[i].taskId;
                            var taskName = tasks[i].taskName;
                            var status = tasks[i].status;
                            var excel = tasks[i].excel;
                            var disable = "";
                            var task_result = tasks[i].result;
                            var failSum = null;
                            var scriptTest = tasks[i].taskParam.scriptTest
                            var scriptType = tasks[i].taskParam.scriptType
                            if(task_result != null){
                                failSum = 0;
                                if(task_result.result.totalSummary.compatibility != null)
                                    failSum += task_result.result.totalSummary.compatibility.summary.fail;
                                if(task_result.result.totalSummary.case != null)
                                    failSum += task_result.result.totalSummary.case.summary.fail;
                                if(task_result.result.totalSummary.travel != null)
                                    failSum += task_result.result.totalSummary.travel.summary.fail;
                            }
                            if( !excel ){
                                disable = "disabled";
                            }
                            switch( status ){
                                case 1:
                                    $("#" + "status" + taskId).html("<span class=\"tag tag-primary\">" + $.i18n.prop("js.project.task.TableWait") + "</span>");
                                    /*$("#" + "icon" + taskId).html("<a class=\"btn btn-danger btn-icon btn-pure p-0 m-r-10 stop_task\" "+
                                        "id=\"btn_stopTask\" "+
                                        "href=\"javascript:void(0);\" "+
                                        "data-taskId=\""+ taskId +"\" "+
                                        "data-projectId=\"" + currentProjectId + "\" "+
                                        "title=\"" + $.i18n.prop("js.project.task.stopTask") + "\"> "+
                                        "<i class=\"icon wb-stop\"></i> </a>");*/
                                    break;
                                case 2:
                                    $("#" + "status" + taskId).html("<span class=\"tag tag-info\">" + $.i18n.prop("js.project.task.TableRunning") + "</span>");
                                    if(tasks[i].taskParam.scriptTest === "1" && tasks[i].taskParam.scriptType === 3){
                                        $("#" + "operation" + taskId).html(
                                            "<a class=\"btn btn-danger btn-icon btn-pure p-0 m-r-10 stop_task\" "+
                                            "id=\"btn_stopTask\" "+
                                            "href=\"javascript:void(0);\" "+
                                            "data-taskId=\""+ taskId +"\" "+
                                            "data-projectId=\"" + currentProjectId + "\" "+
                                            "title=\"" + $.i18n.prop("js.project.task.stopTask") + "\"> "+
                                            "<i class=\"icon wb-stop\"></i> </a>"+
                                            "&nbsp;"+
                                            "<a href=\""+ baseUrl +"/project/"+ currentProjectId +"/task/"+ taskId + "/realtimelog" +"\" "+
                                            "class=\"btn btn-default btn-icon btn-pure p-0 m-r-10\" "+
                                            "id=\"btn_realtimeLogView\" "+
                                            "title=\""+ $.i18n.prop("js.project.task.realtime.log") +"\">"+
                                            "<i class=\"icon wb-eye\"></i></a>"
                                        );
                                    }else {
                                        $("#" + "operation" + taskId).html(
                                            "<a class=\"btn btn-danger btn-icon btn-pure p-0 m-r-10 stop_task\" "+
                                            "id=\"btn_stopTask\" "+
                                            "href=\"javascript:void(0);\" "+
                                            "data-taskId=\""+ taskId +"\" "+
                                            "data-projectId=\"" + currentProjectId + "\" "+
                                            "title=\"" + $.i18n.prop("js.project.task.stopTask") + "\"> "+
                                            "<i class=\"icon wb-stop\"></i> </a>"
                                        );
                                    }
                                    break;
                                case 3:
                                    $("#" + "status" + taskId).html("<span class=\"tag tag-success\">" + $.i18n.prop("js.project.task.TableEnd") + "</span>");
                                    $("#" + "operation" + taskId).html("<a href=\""+ baseUrl +"/project/"+ currentProjectId +"/task/"+ taskId +"\" "+
                                        "class=\"btn btn-default btn-icon btn-pure p-0 m-r-10\" "+
                                        "id=\"btn_reportView\" "+
                                        "title=\""+ $.i18n.prop("js.project.task.TableView") +"\">"+
                                        "<i class=\"icon wb-eye\"></i></a>"+
                                        "&nbsp;"+
                                        "<a href=\""+ excel +"\" "+
                                        "class=\"btn btn-default btn-icon btn-pure p-0 m-r-10 "+disable+"\" "+
                                        "title=\""+ $.i18n.prop("js.project.task.reportDownload") +"\" "+
                                        "id=\"btn_reportDownload\">"+
                                        "<i class=\"icon wb-download\"></i></a>"+
                                        "&nbsp;"+
                                        "<a href=\"javascript:void(0)\"" +
                                        "class=\"btn btn-default btn-icon btn-pure p-0 m-r-10 share_report\"" +
                                        "id=\"btn_share_report\"" +
                                        "data-taskId=\"" + taskId + "\"" +
                                        "data-projectId=\"" + currentProjectId + "\"" +
                                        "data-taskName=\"" + taskName + "\"" +
                                        "data-projectName=\"" + currentProjectName + "\"" +
                                        "data-toggle=\"modal\"" +
                                        "data-target=\"#modal_share_report\">" +
                                        "<i class=\"icon wb-share\"></i></a>");

                                    if( failSum != null && failSum > 0 ){
                                        $("#" + "status" + taskId).html("<span class=\"tag tag-danger\">" + $.i18n.prop("js.project.task.TableStatusFail") + "</span>");
                                        /*$("#" + "result" + taskId).html("<span class=\"tag tag-warning\">" + $.i18n.prop("js.project.task.TableStatusNoRun") + "</span>");*/
                                    }else if ( failSum != null && failSum == 0){
                                        $("#" + "status" + taskId).html("<span class=\"tag tag-success\">" + $.i18n.prop("js.project.task.TableStatusSuccess") + "</span>");
                                    }
                                    break;
                                case 4:
                                    $("#" + "status" + taskId).html("<span class=\"tag tag-warning\">" + $.i18n.prop("js.project.task.TableCancel") + "</span>");
                                    $("#" + "operation" + taskId).html("");
                                    // $("#" + "result" + taskId).html("<span class=\"tag tag-danger\">" + $.i18n.prop("js.project.task.TableCancel") + "</span>");
                                    break;
                            }
                        }
                    }
                },
                error:function(){
                }
            });

        //刷新后按钮事件
        $(".share_report").click(function () {
            var projectId = $(this).attr("data-projectId");
            var taskId = $(this).attr("data-taskId");
            var projectName = $(this).attr("data-projectName");
            var taskName = $(this).attr("data-taskName");
            var share_email = $("#share_email");
            var host = window.location.host;
            var url = host + baseUrl + "/project/" + projectId + "/task/" + taskId + "/report";
            if(!url.startsWith('http://')){
                url = 'http://' + url;
            }
            $("#report_info").html(" ( " + projectName + " - " + taskName + " ) ");
            $("#share_report_url").val(url);
            $("#copy_success").slideUp();
            share_email.attr("data-projectName", projectName);
            share_email.attr("data-taskName", taskName);
            //$("#modal_share_report").modal("show");
        });

        $(".stop_task").click(function () {
            var projectid = $(this).attr("data-projectId");
            var taskid = $(this).attr("data-taskId");
            console.info("tid=" + taskid);
            swal({
                    title: $.i18n.prop("js.project.taskStop.title"),
                    text: "",
                    type: "warning",
                    showCancelButton: true,
                    closeOnConfirm: false,
                    showLoaderOnConfirm: true,
                    //confirmButtonColor: '#DD6B55',
                    confirmButtonText: $.i18n.prop("js.peoject.taskStop.confirm"),
                    cancelButtonText: $.i18n.prop("js.project.taskStop.cancel"),
                    //closeOnCancel: false
                },
                function () {
                    $.ajax({
                        url:baseUrl + "/api/project/" + projectid + "/task/" + taskid,
                        type:"PUT",
                        success:function(data, status){
                            swal($.i18n.prop("js.peoject.taskStop.success"), $.i18n.prop("js.peoject.taskStop.successReport"), "success");
                            window.location.href = baseUrl + "/project/" + projectid + "/tasks";
                        },
                        error:function(){
                            swal($.i18n.prop("js.peoject.taskStop.fail"), $.i18n.prop("js.peoject.taskStop.failReport"), "error");
                        }
                    });
                }
            );
        });
    }

    /**
     * 停止当前任务
     */
    $(".stop_task").click(function () {
        var projectid = $(this).attr("data-projectId");
        var taskid = $(this).attr("data-taskId");
        console.info("tid=" + taskid);
        swal({
                title: $.i18n.prop("js.project.taskStop.title"),
                text: "",
                type: "warning",
                showCancelButton: true,
                closeOnConfirm: false,
                showLoaderOnConfirm: true,
                //confirmButtonColor: '#DD6B55',
                confirmButtonText: $.i18n.prop("js.peoject.taskStop.confirm"),
                cancelButtonText: $.i18n.prop("js.project.taskStop.cancel"),
                //closeOnCancel: false
            },
            function () {
                $.ajax({
                    url:baseUrl + "/api/project/" + projectid + "/task/" + taskid,
                    type:"PUT",
                    success:function(data, status){
                        swal($.i18n.prop("js.peoject.taskStop.success"), $.i18n.prop("js.peoject.taskStop.successReport"), "success");
                        window.location.href = baseUrl + "/project/" + projectid + "/tasks";
                    },
                    error:function(){
                        swal($.i18n.prop("js.peoject.taskStop.fail"), $.i18n.prop("js.peoject.taskStop.failReport"), "error");
                    }
                });
            }
        );
    });


    /**
     * 报告分享
     */
    $(".share_report").click(function () {
        var projectId = $(this).attr("data-projectId");
        var taskId = $(this).attr("data-taskId");
        var projectName = $(this).attr("data-projectName");
        var taskName = $(this).attr("data-taskName");
        var share_email = $("#share_email");
        var host = window.location.host;
        var url = host + baseUrl + "/project/" + projectId + "/task/" + taskId + "/report";
        if(!url.startsWith('http://')){
            url = 'http://' + url;
        }
        $("#report_info").html(" ( " + projectName + " - " + taskName + " ) ");
        $("#share_report_url").val(url);
        $("#copy_success").slideUp();
        share_email.attr("data-projectName", projectName);
        share_email.attr("data-taskName", taskName);
        //$("#modal_share_report").modal("show");
    });

    /**
     * 链接至本地邮箱客户端
     */
    $('#share_email').click(function () {
        var projectName = $(this).attr("data-projectName");
        var taskName = $(this).attr("data-taskName");
        var subject = 'EagleTest - Report - ' + projectName + ' - ' + taskName;
        var body = $('#share_report_url').val();
        var url = 'mailto:' + '?subject=' + subject + '&body=' + body;
        url = encodeURI(url);
        window.location.href = url;
    });

});