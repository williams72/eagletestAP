/**
 * Created by xueshan.wei on 11/25/2016.
 */
$(document).ready(function () {
    var baseUrl = $("#baseUrl").attr("baseUrl");

    //自定义select2 样式，选择管理员，添加头像显示
    function formatState (state) {
        if (!state.id) { return state.text; }
        var str = state.element.value;
        var arr = str.split(",");
        var $state = $(
            '<span class="text-xs-center"><img src="' + baseUrl + '/static/img/avatar/'
            + arr[1] + '" class="avatar avatar-xs" /> '
            + '' + state.text + '</span>'
        );
        return $state;
    };

    function formatSelection(data, container) {
        if(data.text != $.i18n.prop("js.project.member.select2.placeholder")){
            var str = data.element.value;
            var arr = str.split(",");
            var $state = $(
                '<span class="text-xs-center"><img src="' + baseUrl + '/static/img/avatar/'
                + arr[1] + '" class="avatar avatar-xs" /> '
                + '' + data.text + '</span>'
            );
            return $state;
        }
        return data.text;
    }
    $("#projectMember").select2({
        placeholder: $.i18n.prop("js.project.member.select2.placeholder"),
        templateResult:formatState,
        templateSelection:formatSelection
    });


    $(".projectUserChange").change(function () {
        var rolevalue = $(this).val();
        var projectId = $(this).attr("data-projectid");
        var userid = $(this).attr("data-userid");
        console.info(rolevalue);
        $.ajax({
            url:baseUrl + "/project/" + projectId + "/user/" + userid,
            type:"put",
            data:{
                "roleValue":rolevalue
            },
            success:function(data, status){
                console.info(data.renewData);
                console.info(data);
                swal($.i18n.prop("js.project.member.changeSuccess"), "", "success");

            },
            error:function(){

            }
        });
    });
});