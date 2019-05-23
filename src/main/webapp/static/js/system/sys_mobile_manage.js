/**
 * Created by xueshan.wei on 11/1/2016.
 */

$(document).ready(function () {
    var mobile_manager = {

    }
    var global_sid_more = "";
    var global_currentTaskId = "";
    var baseUrl = $("#baseUrl").attr("baseUrl");


    //编辑手机名称

    $("#btn_mobileRename").click(function (){
        var serialNumber = $("#mobile_edit_name").attr("data-serialNumber");
        var name = $("#mobile_edit_name").val();
        //校验重命名手机名是否包含特殊字符
        var containSpecial = /^[\u4E00-\u9FA5A-Za-z0-9_ ]+$/;
        if(!containSpecial.test(name)){
            swal($.i18n.prop("js.mobile.edit.containspecial"),"","warning");
        }else {
            $.ajax({
                url:baseUrl + "/mobile/" + serialNumber,
                type:"put",
                data:{
                    "name":name
                },
                success:function(data, status){
                    $("#mobile_caozuo_edit").modal("hide");
                    swal($.i18n.prop("js.mobile.edit.success"), $.i18n.prop("js.mobile.edit.successText"), "success");
                    window.location.href = baseUrl + "/mobiles";
                },
                error:function(){
                    $("#mobile_caozuo_edit").modal("hide");
                    swal($.i18n.prop("js.mobile.edit.fail"), $.i18n.prop("js.mobile.edit.failText"), "error");
                }
            });
        }
    });

    //设置ajax 请求同步
    $.ajaxSettings.async = false;
    //加载手机数据
    var mobileInfos = {};
    var url = baseUrl + "/mobiles/all"
    $.getJSON(url, function (data) {
        mobileInfos = data;
    });
    console.info(mobileInfos);
    var filter = mobileInfos.filter;
    var mobiles = mobileInfos.mobile;
    //初始化 单个设备模板

    var getMobileTemplete = function (mobile) {
        //not busy model
        var mobileNotBusy = '<i title="' + $.i18n.prop("js.mobile.dev.enable") + '" class="icon wb-unlock m-l-10 inline-block"></i>';
        //busy model
        var mobileBusy = '<i title="' + $.i18n.prop("js.mobile.dev.disable") + '" style="color:#FF5200;" class="icon wb-lock m-l-10"></i>';
        var mobileStatus;
        var chongceBtndisable = "";
        var mobile_more_caozuo_dis = "disabled";
        if (mobile.status == "空闲") {
            mobileStatus = mobileNotBusy;
            chongceBtndisable = "disabled"
        } else {
            mobileStatus = mobileBusy;
            mobile_more_caozuo_dis = "";
        }

        return '<!-- 每个设备 beg --> <div class="col-xs-4 col-md-3 col-lg-2">'
            + '<div class="panel panel-bordered">'
            + '<div class="panel-heading p-3">'
            + mobileStatus
            + '<span style="position:absolute; width:90px; margin-left:10px; white-space:nowrap; overflow:hidden; -o-text-overflow:ellipsis; text-overflow:ellipsis;" class="m-l-15" title="'+mobile.name+'">'
            + mobile.name
            + '</span>'
            + '<div class="panel-actions" style="right: 0px;">'
            + '<a class="panel-action icon wb-edit caozuo_edit" title="' + $.i18n.prop("js.mobile.dev.editTitle") + '"'
            + 'data-serialNumber="' + mobile.serial_number + '"  data-target="#mobile_caozuo_edit"'
            + 'data-toggle="modal"></a>'
            + '</div>'
            + '</div>'
            + '<div class="panel-body p-5" style="height: 180px; overflow: hidden;">'
            + '<figure class="overlay overlay-hover">'
            + '<img class="overlay-figure" src="' + mobile.screen_shot_url + '" style="width:100%;"'
            + 'onerror="this.src=\'' + baseUrl + '/static/img/phonenopage.png\'"'
            + 'alt="...">'
            + '<figcaption class="overlay-panel overlay-background overlay-fade p-5 font-size-12">'
            + '<p class="m-y-10">' + $.i18n.prop("js.mobile.dev.model") + mobile.model + '</p>'
            + '<p class="m-y-10">' + $.i18n.prop("js.mobile.dev.resolution") + mobile.resolution + '</p>'
            + '<p class="m-y-10">' + $.i18n.prop("js.mobile.dev.os") + mobile.os + '</p>'
            + '</figcaption>'
            + '</figure>'
            + '</div>'
            + '<div class="panel-footer p-5">'
            + '<div style="width:100%;" class="btn-group btn-group-xs" aria-label="Extra-small button group" role="group">'
            //+ '<button data-serialNumber="' + mobile.serial_number + '" style="width:40%;" type="button" class="btn btn-default caozuo_chongqi">' + $.i18n.prop("js.mobile.dev.btnReboot") + '</button>'
            //+ '<button data-serialNumber="' + mobile.serial_number + '" style="width:60%;" type="button" class="btn btn-default caozuo_stop" ' + chongceBtndisable + '>' + $.i18n.prop("js.mobile.dev.btnStop") + '</button>'

            + '<button data-serialNumber="'
            + mobile.serial_number
            + '" style="width:50%;" type="button" class="btn btn-default caozuo_chongqi">'
            + $.i18n.prop("js.mobile.dev.btnReboot")
            + '<i class="icon wb-reload"></i> </button>'
            + '<button style="width:50%;" data-sid="'
            + mobile.serial_number
            + '" data-currentTaskId="'
            + mobile.currentTaskId
            + '" data-taskType="'
            + mobile.taskType
            + '" type="button" data-target="#mobile_caozuo_stop" data-toggle="modal" class="btn btn-default caozuo_more" '
            + mobile_more_caozuo_dis
            + ' >'
            + $.i18n.prop("js.mobile.dev.btnOperation")
            +'<i class="icon wb-chevron-down-mini"></i></button>'
            + '</div>'
            + '</div>'
            + '</div>'
            + '</div>'
            + '<!-- 每个设备 end -->';
    };

    //初始化过滤器
    var drawFilter = function (filters) {
        var $filterContent = $("#filterContent");
        $filterContent.children().remove();
        var filterLine;
        for (index in filters) {
            filterLine = getFilterLine(filters[index]);
            $filterContent.append(filterLine);
        }
        //添加iCheck 样式
        $(".filterItem").iCheck({
            checkboxClass: 'icheckbox_flat-blue',
            radioClass: 'iradio_flat'
        });

        //绑定ifChange事件
        $(".filterCheckItem").on("ifChanged", function () {
            var itemType = $(this).attr("itemType");
            var itemKey = $(this).attr("filterdata-key");
            console.info(itemType);
            if ($(this).is(':checked')) {
                //添加到已选手机
                if(itemType == "all"){
                    $("." + itemKey + "_only").each(function () {
                        $(this).iCheck('uncheck');
                    });
                }else{
                    $("." + itemKey + "_all").iCheck('uncheck');
                }
            } else {
                //从已选手机中删除
                if(itemType == "all") {

                }else{
                    var allFlag = true;
                    $("." + itemKey + "_only").each(function () {
                        if($(this).is(':checked')){
                            allFlag = false;
                        }
                    });
                    if(allFlag){
                        //所有非all 标签全部未选中
                        $("." + itemKey + "_all").iCheck('check');
                    }
                }
            }
            //重置filters
            var filters1 = [];

            $('input:checkbox').each(function () {
                var key = $(this).attr("filterdata-key");
                var value = $(this).attr("filterdata-value");
                if ($(this).is(':checked') == true) {
                    filters1 = createFilter(filters1, key, value);
                }
            });
            //通过新的筛选器筛选手机
            var newMobiles = filterMobiles(filters1, mobiles);
            drawMobile(newMobiles);
        });
    };
    var filterMobiles = function (filters, mobiles) {

        var newMobiles = mobiles;
        //循环手机
        for (filters_index in filters) {
            var filter = filters[filters_index];

            newMobiles = isSuitMobile(filter, newMobiles);

        }
        return newMobiles;
    };
    var isSuitMobile = function (filter, mobiles) {
        //循环filters
        var newMobiles = [];
        for (options_index in filter.options) {
            var option = filter.options[options_index];
            if (option == "全部") {
                return mobiles;
            } else{
                for(mobiles_index in mobiles){
                    var mobile = mobiles[mobiles_index];
                    if(mobile[filter.key] == option){
                        newMobiles.push(mobile);
                    }
                }
            }
        }
        return newMobiles;
    };
    //var filters = [];
    //filters.push()
    var createFilter = function (filter, key, value) {
        //判断是否已经存在该key
        var existKey = false;
        var existFilter;
        for (index in filter) {
            existFilter = filter[index];
            if (key == existFilter.key) {
                existKey = true;
                break;
            }
        }
        if (existKey == true) {
            existFilter.options.push(value);
            //filter.push(existFilter);
        } else {
            var filterTemp = {
                "key": key,
                "options": []
            };
            filterTemp.options.push(value);
            filter.push(filterTemp);
        }
        return filter;

    };

    var getFilterLine = function (filter) {
        var filterLineBefore = '<div class="row" style="margin-top:10px; border-bottom:1px dashed #8796a4; padding-bottom:5px;">'
            + '<div class="col-xs-12 col-md-2 col-lg-1">'
            + '<button type="button" class="btn btn-primary btn-xs">' + $.i18n.prop('js.filter.' + filter.key) + '</button>'
            + '</div>'
            + '<div class="col-xs-12 col-md-10 col-lg-10">';
        var filterLineAfter = '</div></div>';
        var filterItems = "";
        for (index in filter.options) {
            filterItems += getFilterItem(index, filter.key, filter.options[index]);
        }
        return filterLineBefore + filterItems + filterLineAfter;

    };
    var getFilterItem = function (index, key, option) {
        var checked = "";
        var item = "only";
        var itemClass = "";
        var real_option = option; // 先保存国际化前的选项值
        if (option == "全部") {
            option = $.i18n.prop("js.filter.all");
            checked = "checked";
            item = "all";
            itemClass = "filterCheckItem " + key + "_all";
        }else{
            itemClass = "filterCheckItem " + key + "_only";
        }
        //国际化 转换 手机状态
        if(option == "空闲"){
            option = $.i18n.prop("js.filter.status.enable");
        }else if(option == "占用"){
            option = $.i18n.prop("js.filter.status.disable");
        }
        return '<div style="margin:0px 5px"  class="inline filterItem">'
            + '<input type="checkbox" class="'+ itemClass + '" id="' + key + '[' + index + ']" name="inputiCheckColorCheckboxes"'
            + 'filterdata-key="' + key
            + '" filterdata-value="' + real_option + '"'
            + ' itemType="' + item + '"'
            + checked + '/>'
            + '<label for="' + key + '[' + index + ']" style="margin-left:5px;">' + option + '</label>'
            + '</div>';
    };
    //初始化手机
    var drawMobile = function (mobiles) {
        var $mobileContent = $("#mobileContent");
        $("#mobiles_num").html(mobiles.length);
        $mobileContent.children().remove();
        for (index in mobiles) {
            var $mobileModel = getMobileTemplete(mobiles[index])
            $mobileContent.append($mobileModel);
        }
        //添加点击事件
        $(".caozuo_edit").on("click", function (){
            var serialnumber = $(this).attr("data-serialNumber");
            console.info(serialnumber);
            $("#mobile_edit_name").attr("data-serialNumber", serialnumber);
        });
        //bind reboot mobile event
        /**
         * 重启手机
         */
        $(".caozuo_chongqi").on("click", function () {
            var sn = $(this).attr("data-serialNumber");
            swal({
                    title: $.i18n.prop("js.mobile.reboot.swal.title"),
                    //text: $.i18n.prop("js.mobile.reboot.swal.text"),
                    text: "",
                    type: "warning",
                    showCancelButton: true,
                    closeOnConfirm: false,
                    showLoaderOnConfirm: true,
                    //confirmButtonColor: '#DD6B55',
                    confirmButtonText: $.i18n.prop("js.mobile.reboot.swal.confirm"),
                    cancelButtonText: $.i18n.prop("js.mobile.reboot.swal.cancel"),
                    //closeOnCancel: false
                },
                function () {
                    $.ajax({
                        url:baseUrl + "/mobilereboot",
                        type:"post",
                        data:{
                            "serialNumber":sn
                        },
                        success:function(data, status){
                            swal($.i18n.prop("js.mobile.reboot.success.title"), $.i18n.prop("js.mobile.reboot.success.text"), "success");
                            window.location.href = baseUrl + "/mobiles";
                        },
                        error:function(){
                            swal($.i18n.prop("js.mobile.reboot.fail.title"), $.i18n.prop("js.mobile.reboot.fail.text"), "error");
                        }
                    });
                }
            );
            console.info(sn);
        });

        /**
         * 停止任务
         */
        $(".caozuo_stop").on("click",function () {
            var sn = $(this).attr("data-serialNumber");
            swal({
                    title: $.i18n.prop("js.mobile.stoptask.swal.title"),
                    text: $.i18n.prop("js.mobile.stoptask.swal.text"),
                    type: "warning",
                    showCancelButton: true,
                    closeOnConfirm: false,
                    showLoaderOnConfirm: true,
                    //confirmButtonColor: '#DD6B55',
                    confirmButtonText: $.i18n.prop("js.mobile.stoptask.swal.confirm"),
                    cancelButtonText: $.i18n.prop("js.mobile.stoptask.swal.cancel"),
                    //closeOnCancel: false
                },
                function () {
                    $.ajax({
                        url:baseUrl + "/mobiletask/" + sn,
                        type:"DELETE",
                        success:function(data, status){
                            swal($.i18n.prop("js.mobile.stoptask.stopsuccess"), $.i18n.prop("js.mobile.stoptask.stopsuccessText"), "success");
                            window.location.href = baseUrl + "/mobiles";
                        },
                        error:function(){
                            swal($.i18n.prop("js.mobile.stoptask.stopfail"), $.i18n.prop("js.mobile.stoptask.stopfailText"), "error");
                        }
                    });
                }
            );
            console.info(sn);

        });

        $(".caozuo_more").on("click", function () {
            console.info("点击更多操作");
            var data_sid = $(this).attr("data-sid");
            var data_task_type = $(this).attr("data-taskType");
            var data_currentTaskId = $(this).attr("data-currentTaskId");

            global_sid_more = data_sid;
            global_currentTaskId = data_currentTaskId;


            var mobile_status;
            if(data_task_type == 0){
                mobile_status = $.i18n.prop("js.moblie.operation.tasktype0");
                $(".modal_cuozuo_1").hide();
                $("#mcz_1").iCheck("check");
                $(".modal_cuozuo_2").show();
            }else{
                mobile_status = $.i18n.prop("js.moblie.operation.tasktype1");
                $(".modal_cuozuo_1").show();
                $("#mcz_0").iCheck('check');
                $(".modal_cuozuo_2").hide();
            }
            $("#modal_mobile_status").html(mobile_status);

            $("#mobile_caozuo_more").modal("show");
        });
    };
    drawFilter(filter);
    drawMobile(mobiles);

    $("#btn_rmobileShell").click(function () {
        var stop_type = $("[name = stop_type]:radio:checked").val();
        console.info("global_sid=" + global_sid_more);
        console.info("stop_type=" + stop_type);

        //执行ajax 操作
        var url = "";
        var method = "";
        if(stop_type == 0){
            url = baseUrl + "/api/remotemobile?sid="+ global_sid_more;
        }else if(stop_type == 1){
            url = baseUrl + "/api/mobile/" + global_sid_more + "/task/" + global_currentTaskId;
        }else if(stop_type == 2){
            url = baseUrl + "/api/mobile/" + global_sid_more + "/tasks";
        }else{
            swal("出错了", "", "error");
        }

        $.ajax({
            url:url,
            type:"DELETE",
            success:function(data, status){
                swal($.i18n.prop("js.mobile.stoptask.stopsuccess"), $.i18n.prop("js.mobile.stoptask.stopsuccessText"), "success");
                window.location.href = baseUrl + "/mobiles";
            },
            error:function(){
                swal($.i18n.prop("js.mobile.stoptask.stopfail"), $.i18n.prop("js.mobile.stoptask.stopfailText"), "error");
            }
        });

    });
});