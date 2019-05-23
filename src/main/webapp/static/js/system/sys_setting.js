/**
 * Created by xueshan.wei on 1/20/2017.
 */
$(document).ready(function () {
    var baseUrl = $("#baseUrl").attr("baseUrl");

    $("#systemLanguage").change(function () {
        var lan = $(this).val();
        $.ajax({
            url:baseUrl + "/api/common/language",
            type:"put",
            data:{
                "language":lan
            },
            success:function(data, status){
                window.location.href = baseUrl + "/setting";
            },
            error:function(){

            }
        });
    });
});