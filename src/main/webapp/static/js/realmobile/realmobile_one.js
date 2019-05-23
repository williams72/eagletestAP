/**
 * Created by xueshan.wei on 11/22/2016.
 */
$(document).ready(function () {
    var baseUrl = $("#baseUrl").attr("baseUrl");

    /**
     * 续借手机
     */
    $("#btn_renewRm").click(function () {
        var rmid = $(this).attr("data-rmid");
        swal({
                title: $.i18n.prop("js.rm.one.renew.title"),
                text: "",
                type: "warning",
                showCancelButton: true,
                closeOnConfirm: false,
                showLoaderOnConfirm: true,
                //confirmButtonColor: '#DD6B55',
                confirmButtonText: $.i18n.prop("js.rm.one.renew.confirm"),
                cancelButtonText: $.i18n.prop("js.rm.one.renew.cancel"),
                //closeOnCancel: false
            },
            function () {
                $.ajax({
                    url:baseUrl + "/realmobile/" + rmid,
                    type:"put",
                    success:function(data, status){
                        console.info(data.renewData);
                        console.info(data);
                        //swal("success", "", "success");
                        swal($.i18n.prop("js.rm.one.renew.success"), "", "success");
                        window.location.href = baseUrl + "/realmobile/" + rmid;
                    },
                    error:function(){

                    }
                });
            }
        );
    });
    /**
     * 停止真机调试
     */
    $("#btn_stopRm").click(function () {
        var rmid = $(this).attr("data-rmid");
        swal({
                title: $.i18n.prop("js.rm.one.stop.title"),
                text: "",
                type: "warning",
                showCancelButton: true,
                showConfirmButton:true,
                closeOnConfirm: false,
                //showLoaderOnConfirm: true,
                //confirmButtonColor: '#DD6B55',
                confirmButtonText: $.i18n.prop("js.rm.one.stop.confirm"),
                cancelButtonText: $.i18n.prop("js.rm.one.stop.cancel"),
                //closeOnCancel: false
            },
            function () {
                $.ajax({
                    url:baseUrl + "/realmobile/" + rmid,
                    type:"delete",
                    success:function(data, status){
                        if(data.code === "00000000"){
                            swal($.i18n.prop("js.rm.one.stop.success"), "", "success");
                            window.location.href = baseUrl + "/realmobiles";
                        }else {

                            swal($.i18n.prop("js.rm.one.stop.fail"), "", "error");
                        }
                    },
                    error:function(){

                    }
                });
            }
        );
    });

    /**
     * 设置网络模拟
     */
    $(".net_simulation").click( function () {
        var rmId = $(this).attr("data-rmid");
        var nsId = $(this).attr("data-nsId");
        var nsKey = $(this).attr("data-nsKey");
        var nsIsDefault = $(this).attr("data-nsIsDefault");

        $.ajax({
            url:baseUrl + "/api/remotemobile/" + rmId + "/netsimulation",
            type:"POST",
            data: {
                "nsid": nsId
            },
            success:function (data, status) {
                if(data.code === "00000000"){
                    toastr.success($.i18n.prop("js.rm.one.setNetSimulation.success"),"",{timeOut:1500});
                    if(nsIsDefault){
                        $("#signal").html('<i class="icon wb-signal">'+ "&nbsp;&nbsp;" + $.i18n.prop("js.rm.one.NetSimulation.key." + nsKey) + '</i>');
                    }
                    else {
                        $("#signal").html('<i class="icon wb-signal">'+ "&nbsp;&nbsp;" + nsKey + '</i>');
                    }

                    $("#signal").show();
                }else {
                    toastr.error($.i18n.prop("js.weaknet.page.error.code") + data.code, $.i18n.prop("js.weaknet.page.error.msg"));
                }
            },
            error:function(){
                toastr.error($.i18n.prop("js.weaknet.page.ajax.error.content"), $.i18n.prop("js.weaknet.page.ajax.error.title"));
            }
        });
    });

    /**
     * 停止网络模拟
     */
    $("#remove_net_simulation").click(function () {
        var rmId = $(this).attr("data-rmid");
        $.ajax({
           url:baseUrl + "/api/remotemobile/" + rmId + "/netsimulation",
            type:"DELETE",
            success:function (data, status) {
                if(data.code === "00000000"){
                    toastr.success($.i18n.prop("js.rm.one.removeNetSimulation.success"),"",{timeOut:1500});
                    $("#signal").hide();
                }else {
                    toastr.error($.i18n.prop("js.weaknet.page.error.code") + data.code, $.i18n.prop("js.weaknet.page.error.msg"));
                }
            },
            error:function(){
                toastr.error($.i18n.prop("js.weaknet.page.ajax.error.content"), $.i18n.prop("js.weaknet.page.ajax.error.title"));
            }
        });
    });

    var intDiff = parseInt($("#remainTime").val());//倒计时总秒数量
    function timer(intDiff){
        window.setInterval(function(){
            var day=0,
                hour=0,
                minute=0,
                second=0;//时间默认值
            if(intDiff > 0){
                minute = Math.floor(intDiff / 60);
                second = Math.floor(intDiff) - (minute * 60);
            }else{
                window.location.href = baseUrl + "/realmobiles";
            }
            if(intDiff === 180){
                toastr.error($.i18n.prop("js.rm.one.timeWarning.text"),"",{timeOut:179000});
            }
            if (minute <= 9) minute = '0' + minute;
            if (second <= 9) second = '0' + second;
            var time = minute+ "&nbsp;" + $.i18n.prop("js.rm.one.diff.minute")+ "&nbsp;" + second+ "&nbsp;" + $.i18n.prop("js.rm.one.diff.sec");
            $("#remianTimeDaojishi").html(time);
            intDiff--;
        }, 1000);
    }
    timer(intDiff);
});