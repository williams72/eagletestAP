$(document).ready(function() {
    var baseUrl = $("#baseUrl").attr("baseUrl");
    $userAddModal = $("#user_add_modal");

    $('#user_add_form').formValidation({
        framework: "bootstrap4",
        button: {
            selector: '#user_add_submit',
            disabled: 'disabled'
        },
        icon: null,
        fields: {
            user_name: {
                validators: {
                    notEmpty: {
                        message: $.i18n.prop("js.project.user.check.name1")
                    },
                    /*用户名特殊字符的校验*/
                    regexp:{
                        regexp:/^[\u4E00-\u9FA5A-Za-z0-9_]+$/,
                        message: $.i18n.prop("js.project.user.check.name.containSpecial")
                    },
                    /*校验用户名是否已存在*/
                    callback:{
                        message: $.i18n.prop("js.project.user.check.name2"),
                        callback: function (value, validator, $field) {
                            var result=false;
                            $.ajax({
                                url:baseUrl + "/api/validate/userNameIsExist?username=" + value,
                                type:"GET",
                                async : false,
                                success:function(data, status){

                                    //var data1 = eval("("+data+")");
                                    //var data2 = JSON.parse(data);
                                    if(data.exist == "true"){
                                        result = true;
                                    }
                                },
                                error:function(){
                                    //这里应该报错
                                }
                            });
                            if(result&&value!=''){
                                return false;
                            }else{
                                return true;
                            }
                        }
                    }
                }
            },
            user_email: {
                validators: {
                    notEmpty: {
                        message: $.i18n.prop("js.project.user.check.email1")
                    },
                    regexp:{
                        regexp:/^[a-zA-Z]([a-zA-Z0-9]*[-_.]?[a-zA-Z0-9]+)+@([\w-]+\.)+[a-zA-Z]{2,}$/i,
                        message: $.i18n.prop("js.project.user.check.email2")
                    },
                    /*校验邮箱是否已注册*/
                    callback:{
                        message:$.i18n.prop("js.project.user.check.email3"),
                        callback: function (value, validator, $field) {
                            var result = false;
                            $.ajax({
                                url:baseUrl + "/api/validate/userEmailIsExist?email=" + value,
                                type:"GET",
                                async : false,
                                success:function(data, status){
                                    if(data.exist == "true"){
                                        result = true;
                                    }
                                },
                                error:function(){
                                    //这里应该报错
                                }
                            });
                            if(result&&value!=''){
                                return false;
                            }else{
                                return true;
                            }
                        }
                    }
                }
            },
            user_password: {
                validators: {
                    notEmpty: {
                        message: $.i18n.prop("js.project.user.check.pwd1")
                    },
                    stringLength: {
                        min:6,
                        message: $.i18n.prop("js.project.user.check.pwd2")
                    }
                }
            }
        },
        err: {
            clazz: 'text-help red-500'
        },
        row: {
            invalid: 'has-danger'
        }
    }).on('success.form.fv', function(e) {
        // Prevent form submission
        e.preventDefault();

        var $form = $(e.target),
            fv    = $form.data('formValidation');

        var user = {};

        user.account = $("#user_add_username").val();
        user.email = $("#user_add_email").val();
        user.password = $("#user_add_password").val();

        // Use Ajax to submit form data
        $.ajax({
            url: baseUrl + "/api/user",
            type: "post",
            data: JSON.stringify(user),
            contentType:"application/json;charset=utf-8",
            success: function (data, status) {
                if(data.code === "00000000"){
                    $("#user_add_modal").modal("hide");
                    console.info(data);
                    swal($.i18n.prop("js.project.user.success"), "", "success");
                    window.location.href = baseUrl + "/users?offset=1&limit=10";
                }else{
                    swal($.i18n.prop("js.weaknet.page.error.code") + data.code, $.i18n.prop("js.weaknet.page.error.msg") + data.msg, "error");
                }
            },
            error: function () {

            }
        });
    });

    /**
     * 重置新增用户表单
     */
    $("#btn_add_user").click(function () {
        console.info("点击新增用户");
        $("#user_add_username").val("");
        $("#user_add_email").val("");
        $("#user_add_password").val("");
    });

    /**
     * 禁用用户
     */
    function disable(userid) {
        $.ajax({
            url: baseUrl + "/api/user/"+ userid +"/access",
            type: "delete",
            success: function (data, status) {
                if(data.code === "00000000"){
                    console.info(data);
                    $("#user_status_"+userid).html("<button data-userid=\""+userid+"\" "+
                        "class=\"btn btn-xs btn-success user_enable_btn\" "+
                        "id=\"btn_enableUser\" "+
                        "type=\"button\">"+
                        $.i18n.prop("js.system.user.TableStatuson")+
                        "</button>");
                    $(".user_enable_btn").click(function () {
                        var userid = $(this).attr("data-userid");
                        enableUser(userid);
                    });
                }
            },
            error: function () {

            }
        });
    }
    $(".user_disable_btn").click(function () {
        var userid = $(this).attr("data-userid");
        disable(userid);
    });

    /**
     * 生效用户
     */
    function enableUser(userid) {
        $.ajax({
            url: baseUrl + "/api/user/"+ userid +"/access",
            type: "post",
            success: function (data, status) {
                if(data.code === "00000000") {
                    $("#user_status_"+userid).html("<button data-userid=\""+userid+"\" "+
                        "class=\"btn btn-xs btn-danger user_disable_btn\" "+
                        "id=\"btn_disableUser\" "+
                        "type=\"button\">"+
                        $.i18n.prop("js.system.user.TableStatusoff")+
                        "</button>");
                    $(".user_disable_btn").click(function () {
                        var userid = $(this).attr("data-userid");
                        disable(userid);
                    });
                }
            },
            error: function () {

            }
        });
    }
    $(".user_enable_btn").click(function () {
        var userid = $(this).attr("data-userid");
        enableUser(userid);
    });

});


