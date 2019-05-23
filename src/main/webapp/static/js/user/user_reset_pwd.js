/**
 * Created by Salt on 3/14/2017.
 */

$(document).ready(function () {
    var baseUrl = $("#baseUrl").attr("baseUrl");
    var userId = $("#userId").attr("userId");

    $userPwdEdit = $("#modal_user_pwd_edit");
    var userPwdCheck = {
        password: false,
        cpassword: false
    };

    /**
     * 实时检测新密码
     */
    var $password = $userPwdEdit.find(".password");
    var $passwordCheck = $userPwdEdit.find(".passwordCheck");
    $password.blur(function () {
        var content = $(this).val();

        var $passwordCheckContent = $userPwdEdit.find(".passwordCheckContent");
        var reg = /^[a-zA-Z]([a-zA-Z0-9]*[-_.]?[a-zA-Z0-9]+)+@([\w-]+\.)+[a-zA-Z]{2,}$/i;//正则表达式
        if(content == undefined || content == ""){
            userPwdCheck.password = false;
            $passwordCheckContent.html($.i18n.prop("js.project.user.check.pwd1"));
            $passwordCheck.show();
        }


        else if(content.length < 6){
            userPwdCheck.password = false;
            $passwordCheckContent.html($.i18n.prop("js.project.user.check.pwd2"));
            $passwordCheck.show();



        }else{
            userPwdCheck.password = true;
            $passwordCheck.hide();
        }

        console.info("password = " + userPwdCheck.password)

    });

    /**
     * 实时检测第二遍密码
     */
    var $cpassword = $userPwdEdit.find(".cpassword");
    var $cpasswordCheck = $userPwdEdit.find(".cpasswordCheck");
    $cpassword.blur(function () {
        var content = $(this).val();

        var $cpasswordCheckContent = $userPwdEdit.find(".cpasswordCheckContent");
        var reg = /^[a-zA-Z]([a-zA-Z0-9]*[-_.]?[a-zA-Z0-9]+)+@([\w-]+\.)+[a-zA-Z]{2,}$/i;//正则表达式
        if(content == undefined || content == ""){
            userPwdCheck.cpassword = false;
            $cpasswordCheckContent.html($.i18n.prop("js.project.user.check.pwd1"));
            $cpasswordCheck.show();
        }
        else if($password.val() != $cpassword.val()){
            userPwdCheck.cpassword = false;
            $cpasswordCheckContent.html($.i18n.prop("js.project.user.check.pwd3"));
            $cpasswordCheck.show();

        }else{
            userPwdCheck.cpassword = true;
            $cpasswordCheck.hide();
        }

        console.info("cpassword = " + userPwdCheck.cpassword)

    });


    /**
     * 重置密码表单
     */
    $("#btn_userOpertion").click(function () {
        console.info("点击重置密码");

        $password.val("");
        $passwordCheck.hide();
        $cpassword.val("");
        $cpasswordCheck.hide();
    });
    /**
     * 修改密码
     */
    $("#btn_resetPwdSubmit").click(function () {


        var user_pwd =  $password.val();
        if (userPwdCheck.password && userPwdCheck.cpassword) {
            $.ajax({
                url: baseUrl + "/api/system/user/" + userId + "/password",
                type: "PUT",
                data: {
                    "newPwd": user_pwd
                },
                success: function (data, status) {
                    $("#modal_user_pwd_edit").modal("hide");
                    console.info(data);
                    swal($.i18n.prop("js.project.user.pwdreset.success"), "", "success");
                    window.location.href = baseUrl + "/users?offset=1&limit=10";

                },
                error: function (data) {
                    console.info(data);
                }
            });
        } else {
            swal($.i18n.prop("js.project.user.check.error"), "", "error");
        }
    });

});