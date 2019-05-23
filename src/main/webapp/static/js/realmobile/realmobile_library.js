/**
 * Created by xueshan.wei on 11/18/2016.
 */
$(document).ready(function (){
    var baseUrl = $("#baseUrl").attr("baseUrl");


    $("#btn_rmobileStart").click(function () {
        var serialNumber = $("#rmobile_tiaoshi_modal").attr("data-serialNumber");
        var mobilename = $("#rmobile_tiaoshi_modal").attr("data-mobilename");

        var time = $("input[name='tiaoshi_time']:checked").val();
        if(time == null){
            $("#tiaoshi_warning").show();
        }else{
            $("#tiaoshi_warning").hide();
            console.info(serialNumber + " " + time);
            $.ajax({
                url:baseUrl + "/realmobile",
                type:"post",
                data:{
                    "serialNumber":serialNumber,
                    "mobilename":mobilename,
                    "time":time
                },
                success:function(data, status){
                    $("#rmobile_tiaoshi_modal").modal("hide");
                    //var data1 = eval("("+data+")");
                    swal($.i18n.prop("js.rm.rentSuccess"), "", "success");
                    window.location.href = baseUrl + "/realmobile/" + data.id;
                    ///realmobile/{realMobileId}
                },
                error:function(){

                }
            });
        }

    });


    //设置ajax 请求同步
    $.ajaxSettings.async = false;
    //加载手机数据
    var mobileInfos = {};
    var url = baseUrl + "/mobiles/android"
    $.getJSON(url, function (data) {
        mobileInfos = data;
    });
    console.info(mobileInfos);
    var filter = mobileInfos.filter;
    var mobiles = mobileInfos.mobile;
    //初始化 单个设备模板

    var getMobileTemplete = function (mobile) {
        //not busy model
        var mobileNotBusy = '<i title="' + $.i18n.prop("js.rm.dev.enable") + '" class="icon wb-unlock m-l-10 inline-block"></i>';
        //busy model
        var mobileBusy = '<i title="' + $.i18n.prop("js.rm.dev.disable") + '" style="color:#FF5200;" class="icon wb-lock m-l-10"></i>';
        var mobileStatus;
        var btndisable = "";
        if (mobile.status == "空闲") {
            mobileStatus = mobileNotBusy;

        } else {
            mobileStatus = mobileBusy;
            btndisable = "disabled";
        }

        return '<!-- 每个设备 beg --> <div class="col-xs-4 col-md-3 col-lg-2">'
            + '<div class="panel panel-bordered">'
            + '<div class="panel-heading p-3">'
            + mobileStatus
            + '<span style="position:absolute; width:110px; margin-left:10px; white-space:nowrap; overflow:hidden; -o-text-overflow:ellipsis; text-overflow:ellipsis;" class="m-l-15" title="'+mobile.name+'">'
            + mobile.name
            + '</span>'
            + '</div>'
            + '<div class="panel-body p-5" style="height: 180px; overflow: hidden;">'
            + '<figure class="overlay overlay-hover">'
            + '<img class="overlay-figure" src="' + mobile.screen_shot_url + '" style="width:100%;"'
            + 'onerror="this.src=\'' + baseUrl + '/static/img/phonenopage.png\'"'
            + 'alt="...">'
            + '<figcaption class="overlay-panel overlay-background overlay-fade p-5 font-size-12">'
            + '<p class="m-y-10">' + $.i18n.prop("js.rm.dev.model") + mobile.model + '</p>'
            + '<p class="m-y-10">' + $.i18n.prop("js.rm.dev.resolution") + mobile.resolution + '</p>'
            + '<p class="m-y-10">' + $.i18n.prop("js.rm.dev.os") + mobile.os + '</p>'
            + '</figcaption>'
            + '</figure>'
            + '</div>'
            + '<div class="panel-footer p-5">'
            + '<div style="width:100%;" class="btn-group btn-group-xs" aria-label="Extra-small button group" role="group">'
            + '<button data-serialNumber="' + mobile.serial_number + '"'
            + 'data-mobilename="' + mobile.name + '"'
            + 'style="width:100%;" type="button"'
            + 'class="btn btn-success rmobile_tiaoshi" id="btn_start" '
            + btndisable
            + '>'
            + $.i18n.prop("js.rm.dev.beginDebugBtn")
            + '</button>'
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
        $(".rmobile_tiaoshi").on("click", function(){
            var serialNumber = $(this).attr("data-serialNumber");
            var mobilename = $(this).attr("data-mobilename");
            console.info(serialNumber);
            $("#rmobile_tiaoshi_modal").attr("data-serialNumber", serialNumber);
            $("#rmobile_tiaoshi_modal").attr("data-mobilename", mobilename);
            $("#cur_mobilename").html(mobilename);
            $("#rmobile_tiaoshi_modal").modal("show");

        });
    };
    drawFilter(filter);
    drawMobile(mobiles);
});