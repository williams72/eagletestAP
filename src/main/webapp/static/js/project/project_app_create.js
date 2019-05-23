$(document).ready(function () {
    var baseUrl = $("#baseUrl").attr("baseUrl");

    $("#version").select2({minimumResultsForSearch: -1});

    $("#app_add_form").formValidation({
        framework: "bootstrap4",
        button: {
            selector: '#btn_createAppSubmit',
            disabled: 'disabled'
        },
        icon: null,
        fields: {
            appName: {
                validators: {
                    notEmpty: {
                        message: $.i18n.prop("js.project.appcheck.nameEmpty")
                    },
                    /*特殊字符的校验*/
                    regexp:{
                        regexp:/^[\u4E00-\u9FA5A-Za-z0-9_\\.]+$/,
                        message: $.i18n.prop("js.project.appcheck.nameSpecial")
                    },
                    /*校验appName是否已存在*/
                    callback:{
                        message: $.i18n.prop("js.project.appcheck.nameRepeate"),
                        callback: function (value, validator, $field) {
                            var flag=true;
                            var versionId=$("#version").val();
                            var result =checkAppNameIsExist(versionId,value);
                            if($("#appNameCheck").html()!=""){
                                $("#appNameCheck").html("");
                            }
                            if(result&&value!=''){
                                return false;
                            }else{
                                return true;
                            }
                        }
                    }
                }
            },
            versionId:{
                validators:{
                    notEmpty:{
                        message:$.i18n.prop("js.project.appcheck.versionEmpty")
                    }
                }
            },
            label:{
                validators:{
                    notEmpty:{
                        message:$.i18n.prop("js.project.appcheck.label")
                    },
                    /*特殊字符的校验*/
                    regexp:{
                        regexp:/^[\u4E00-\u9FA5A-Za-z0-9_\\.]+$/,
                        message: $.i18n.prop("js.project.appcheck.labelSpecial")
                    }
                }
            },
            file:{
                validators:{
                    notEmpty:{
                        message:$.i18n.prop("js.project.appcheck.file")
                    }
                }
            }

        },
        err: {
            clazz: 'text-help red-500'
        },
        row: {
            /*valid:'fv-has-success',*/
            valid:'has-success',
            invalid: 'has-danger has-error'
        }

    })

    $("#version").change(function () {
        var versionId=$("#version").val();
        var appName=$("#app_name").val();
        var result=checkAppNameIsExist(versionId,appName);

        if(result){
            $("#app_name").focus();
            $("#app_name").parent().removeClass("has-success");
            $("#app_name").parent().addClass("has-danger");

            if(appName!=""||appName!=content){
                $("#appNameCheck").html($.i18n.prop("js.project.appcheck.nameRepeate"));
            }
            $("#btn_createAppSubmit").addClass("disabled");
            $("#btn_createAppSubmit").attr("disabled", true);
        }else{
            if(appName!=''){
                $("#app_name").parent().removeClass("has-danger");
                $("#appNameCheck").next().next().next().hide();
                $("#app_name").parent().addClass("has-success");
                $("#appNameCheck").html("");
                $("#btn_createAppSubmit").removeClass("disabled");
            }
        }
    });
    /*checkAppNameIsExist*/
    var checkAppNameIsExist=function (versionId,appName) {
        var result=false;

        $.ajax({
            url:baseUrl + "/api/validate/appNameIsExist?versionId=" + versionId + "&appName=" + appName,
            type:"get",
            success:function(data, status){
                if(data.exist=="true"&&appName!=''){
                    result=true;
                }
            },
            error:function(){
            }
        });
        return result;
    };
});