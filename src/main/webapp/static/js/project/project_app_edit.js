/**
 * Created by Salt on 2017/4/13.
 */
$(document).ready(function () {
    var baseUrl = $("#baseUrl").attr("baseUrl");
    var projectId = $("#projectId").attr("projectId");
    var appId;
    $(".app_edit").click(function () {
        appId = $(this).attr("data-appId");
        var appVisibility = $(this).attr("data-appVisibility");
        console.info(appVisibility);
        if(appVisibility === "1"){
            $("input[name='app_visibility'][value='1']").iCheck('check');
        }
        else {
            $("input[name='app_visibility'][value='0']").iCheck('check');
        }
        $("#modal_app_edit").modal("show");
    });

    $("#btn_appEditSubmit").click(function () {
        var newVisibility = $('input:radio[name="app_visibility"]:checked').val();
        $.ajax({
            url: baseUrl + "/api/project/" + projectId + "/app/" + appId + "/visibility",
            type: "PUT",
            data: {
                "newVisibility": newVisibility
            },
            success: function (data, status) {
                console.info(data.code);
                if(data.code === "00000000")
                {
                    $("#modal_app_edit").modal("hide");
                    swal($.i18n.prop("js.project.appedit.success"), "", "success");
                    window.location.href = baseUrl + "/project/" + projectId + "/apps?offset=1&limit=10";
                }else {
                    $("#modal_app_edit").modal("hide");
                    swal({
                        title: $.i18n.prop("js.project.appedit.fail"),
                        text:$.i18n.prop("js.project.appedit.tryAgain"),
                        type:"error"},
                    function(){
                        window.location.href = baseUrl + "/project/" + projectId + "/apps?offset=1&limit=10";
                    });

                }

            },
            error: function (data) {
                console.info(data);
            }
        });

    });


})