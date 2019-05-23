/**
 * Created by xueshan.wei on 2/8/2017.
 */
$(document).ready(function () {
    var baseUrl = $("#baseUrl").attr("baseUrl");
    var currentUserId = $("#currentUserId").attr("currentUserId");
    var $formChangePwd = $("#formChangePwd");

    var $currentPwd = $formChangePwd.find(".currentPwd");
    var $newPwd = $formChangePwd.find(".newPwd");
    var $repeatPwd = $formChangePwd.find(".repeatPwd");
    var $btnChangePwd = $formChangePwd.find(".btnChangePwd");

    $btnChangePwd.click(function () {
        var newPwdContent = $newPwd.val().trim();
        var repeatPwdContent = $repeatPwd.val().trim();
        var currentPwdContent = $currentPwd.val().trim();

        if(currentPwdContent == undefined || currentPwdContent == ""){
            swal($.i18n.prop("js.user.profile.pwd.current.notBlank"),"", "error");
        }else if(newPwdContent == undefined || newPwdContent == ""){
            swal($.i18n.prop("js.user.profile.pwd.new.notBlank"),"", "error");
        }else if(repeatPwdContent == undefined || repeatPwdContent == ""){
            swal($.i18n.prop("js.user.profile.pwd.repeat.notBlank"),"", "error");
        }else if(newPwdContent != repeatPwdContent){
            swal($.i18n.prop("js.user.profile.pwd.two.notEqual"),"", "error");
        }else{
            //提交表单，更改密码
            console.info(currentPwdContent + "---" + newPwdContent);
            $.ajax({
                url:baseUrl + "/api/user/" + currentUserId + "/password",
                type:"put",
                data:{
                    "oldPwd":currentPwdContent,
                    "newPwd":newPwdContent
                },
                success:function (data, status) {
                    swal($.i18n.prop("js.user.profile.pwd.change.success"),"", "success");
                    window.location.href = baseUrl + "/login";
                },
                error:function () {
                    swal($.i18n.prop("js.user.profile.pwd.change.fail"),"", "error");
                }
            });
        }
    });
});