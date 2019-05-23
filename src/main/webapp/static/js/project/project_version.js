/**
 * Created by xueshan.wei on 12/9/2016.
 */
$(document).ready(function () {
    var baseUrl = $("#baseUrl").attr("baseUrl");

    $("#versionStatus").select2({minimumResultsForSearch: -1});

    $("#version_add_form").formValidation({

        framework: "bootstrap4",
        button: {
            selector: '#btn_createBuildSubmit',
            disabled: 'disabled'
        },
        icon: null,
        fields: {
            versionName: {
                validators: {
                    notEmpty: {
                        message: $.i18n.prop("js.project.v.checkNameEmpty")
                    },
                    /*特殊字符的校验*/
                    regexp: {
                        regexp: /^[\u4E00-\u9FA5A-Za-z0-9_\\.]+$/,
                        message: $.i18n.prop("js.project.v.checkNameSpecial")
                    },
                    /*校验版本名是否已存在*/
                    callback: {
                        message: $.i18n.prop("js.project.v.checkNameRepeat"),
                        callback: function (value, validator, $field) {
                            var projectId = $("#versionStatus").attr("data-projectid");
                            var result = checkVersionIsExist(projectId, value);
                            if (result && value != '') {
                                return false;
                            } else {
                                return true;
                            }
                        }
                    }
                }
            },
            versionStatus: {
                validators: {
                    notEmpty: {
                        message: $.i18n.prop("js.project.v.checkVersion")
                    }
                }
            }
        },
        err: {
            clazz: 'text-help red-500'
        },
        row: {
            valid: 'has-success',
            invalid: 'has-danger has-error'
        }
    })

    $(".versionStatusChange").change(function () {
        var versionStatus = $(this).val();
        var projectId = $(this).attr("data-projectid");
        var versionid = $(this).attr("data-versionid");
        $.ajax({
            url: baseUrl + "/project/" + projectId + "/version/" + versionid,
            type: "put",
            data: {
                "status": versionStatus
            },
            success: function (data, status) {
                swal($.i18n.prop("js.project.v.changeSuccess"), "", "success");

            },
            error: function () {

            }
        });
    });

    /*checkVersionIsExist*/
    var checkVersionIsExist = function (projectId, versionName) {
        var result = false;
        $.ajax({
            url: baseUrl + "/api/validate/versionIsExist?projectId=" + projectId + "&versionName=" + versionName,
            type: "get",
            success: function (data, status) {
                if (data.exist == "true") {
                    result = true;
                }
            },
            error: function () {
            }
        });
        return result;
    };

});