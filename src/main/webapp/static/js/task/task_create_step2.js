/**
 * Created by xueshan.wei on 11/28/2016.
 */
$(document).ready(function () {
    //接口查询设备
    var baseUrl = $("#baseUrl").attr("baseUrl");
    var engine = $("#engine").attr("engine");
    var projectType = $("#projectType").attr("os");
    var os;
    var mobiles;
    // 接口数据，1：安卓， 2：IOS
    if(projectType === "0"){
        os = 1;
    }else {
        os = 2;
    }

    /**
     * 初始化可选手机列表
     * init mobiles and filter
     * @param mobileinfo
     */
    var mobileNotBusy = '<i class="icon wb-unlock m-l-10 inline-block"></i>&nbsp;';
    var mobileBusy = '<i style="color:#FF5200;" class="icon wb-lock m-l-10"></i>&nbsp;';

    var initMobiles = function (mobiles) {
        var brands = [];
        //可选手机按品牌过滤
        for(var i = 0, mlength = mobiles.length; i < mlength; i++){
            $.each(mobiles[i], function (name, value) {
                if(name === "brand"){
                    if(i === 0){
                        brands.push(value);
                    }else if(i > 0 && isBrandDuplicate(brands, value) === true){
                        console.info("true");
                        brands.push(value);
                    }
                }
            });
        }
        //添加可选手机
        for(var j = 0, blength = brands.length; j < blength; j++){
            var brandBefore = createMobileBrandBefore(brands[j]);
            var brandAfter = createMobileBrandAfter();
            var items = [];
            for(var m = 0,length = mobiles.length; m < length; m++){
                if(mobiles[m].brand === brands[j]){
                    items += createMobileItem(mobiles[m], m);
                }
            }

            var brandnode = brandBefore + items + brandAfter;
            $("#mobiles").append(brandnode);
        }
        $(".kexuan_mobile").iCheck({
            checkboxClass: 'icheckbox_flat-grey',
            radioClass: 'iradio_flat'
        });

        //添加可选手机过滤 选择器
        /*for (var i = 0, len = mobileinfo.filter.length; i < len; i++) {
            var filter = mobileinfo.filter[i];
            if (filter.value == "品牌") {
                brands = filter.options;
            }
            var before = createFilterLineBefore(filter.value);
            var after = createFilterLineAfter();

            var items = '';
            for (var j = 0, lenj = filter.options.length; j < lenj; j++) {
                items += createFilterItem(filter.options[j], i, j);
            }
            var filterLineNode = before + items + after;
            $("#filters").append(filterLineNode);
        }
        $(".filterItem").iCheck({
            checkboxClass: 'icheckbox_flat-blue',
            radioClass: 'iradio_flat'
        });

        //添加可选手机

        for (var n = 1, nlen = brands.length; n < nlen; n++) {
            var brandBefore = createMobileBrandBefore(brands[n]);
            var brandAfter = createMobileBrandAfter();
            var items = [];

            for (var m = 0, mlen = mobileinfo.mobile.length; m < mlen; m++) {
                if (mobileinfo.mobile[m].brand == brands[n]) {
                    items += createMobileItem(mobileinfo.mobile[m]);
                }
            }

            var brandnode = brandBefore + items + brandAfter;
            $("#mobiles").append(brandnode);
        }

        $(".kexuan_mobile").iCheck({
            checkboxClass: 'icheckbox_flat-grey',
            radioClass: 'iradio_flat'
        });*/

    };

    $.ajax({
        url:baseUrl + "/api/mobiles",
        type:"get",
        data:{
            "engine": engine,
            "os": os
        },
        success:function (data) {
            if(data.code === "00000000"){
                console.info("获取手机列表成功");
                mobiles = data.data;
                console.info(mobiles);
                //初始化筛选框 和 可选手机
                //initMobiles(mobiles);
            }
        },
        error:function () {
            console.info("获取手机列表失败")
        }

    });

    var isBrandDuplicate = function (brands, v) {
        var result = false;
        $.each(brands, function (index, value) {
            if(v === value){
                result = false;
                return result;
            } else {
                result = true;
            }
        });
        return result;
    };

    var filterMobile = function (filters, mobiles) {
        console.info("筛选手机-----------------------------");
        //1、移除所有可选手机
        /*
        for(var j = 0, jlen = mobiles.length; j < jlen; j++){
            console.info(mobiles[j].model);
        }*/
        //2、先过滤品牌
        var newMobiles = filterMobileBrand(filters.filter[0].value, mobiles);


        //3、过滤分辨率
        var newMobiles2 = filterMobileResolution(filters.filter[1].value, newMobiles);

        for(var i = 0, len = newMobiles2.length; i < len; i++){
            console.info(newMobiles2[i].model);
        }

    };

    var filterMobileBrand = function (brands, mobiles) {
        var b_index = 0;
        var newMobiles = [];
        var newMobileIndex = 0;
        if(brands.length > 0){
            if(brands[0] == "全部"){
                b_index ++;
            }
            var len = brands.length;
            for(b_index; b_index < len; b_index ++){
                var brand = brands[b_index];
                for(var i = 0, ilen = mobiles.length; i < ilen; i++){
                    var mobile = mobiles[i];
                    if(mobile.brand == brand){
                        newMobiles[newMobileIndex ++] = mobile;
                    }
                }
            }
        }
        return newMobiles;
    };

    var filterMobileResolution = function (resolutions, mobiles) {
        var b_index = 0;
        var newMobiles = [];
        var newMobileIndex = 0;
        if(resolutions.length > 0){
            if(resolutions[0] == "全部"){
                b_index ++;
            }
            var len = resolutions.length;
            for(b_index; b_index < len; b_index ++){
                var item = resolutions[b_index];
                for(var i = 0, ilen = mobiles.length; i < ilen; i++){
                    var mobile = mobiles[i];
                    if(mobile.resolution == item){
                        newMobiles[newMobileIndex ++] = mobile;
                    }
                }
            }
        }
        return newMobiles;
    };

    var filterMobileOs = function (oss, mobiles) {

    };

    var filterMobilebusy = function (busy, mobiles) {

    };


    var createMobileItem = function (mobile, m) {
        var mobilebusy;
        if(mobile.busy === false){
            mobilebusy = mobileNotBusy;
        }
        else{
            mobilebusy = mobileBusy;
        }

        return '<div style="margin:0px 5px" class="inline-block">'
            + '<input type="checkbox" class="icheckbox-grey kexuan_mobile"'
            + 'id="kexuan_' + m + '"'
            + 'name="mobile[]"'
            + 'value="'
            + mobile.name + '@#'
            + mobile.brand + '@#'
            + mobile.model + '@#'
            + mobile.os + '@#'
            + mobile.serialno
            + '"'
            + 'data-plugin="iCheck"'
            + 'data-id="' + m + '"'
            + 'data-os="' + mobile.os + '"'
            + 'data-serialNumber="' + mobile.serialno + '"'
            + 'data-model="' + mobile.model + '"'
            + 'data-mobile-name="' + mobile.name + '"'
            + 'data-brand="' + mobile.brand + '"'
            + 'data-busy="' + mobile.busy + '"'
            + 'data-checkbox-class="icheckbox_flat-blue"/>'
            + '<label for="kexuan_' + m + '" style="margin:0 0 3px 0;">'
            + mobilebusy
            + mobile.name + "&nbsp;(" + mobile.os + ")&nbsp;"
            + '</label>'
            + '</div>'
    }

    var createMobileBrandBefore = function (brand) {
        return '<div class="p-b-5 m-b-5">'
            + '<div class="row">'
            + '<div class="col-xs-12 col-md-12 col-lg-12">'
            + '<span class="tag tag-primary tag-round">'
            + brand
            + '</span>'
            + '</div>'
            + '</div>'
            + '<div class="row m-t-10">'
            + '<div class="col-xs-12 col-md-12 col-lg-12">';
    };

    var createMobileBrandAfter = function () {
        return '</div>'
            + '</div>'
            + '</div>';
    };

    var createFilterItem = function (filterItem, i, j) {
        return '<div style="margin:0px 5px" class="inline filterItem">'
            + '<input type="checkbox" class="icheckbox-primary" id="filterItem' + i + j + '"'
            + 'name="inputiCheckColorCheckboxes"'
            + 'data-plugin="iCheck" data-checkbox-class="icheckbox_flat-blue"/>'
            + '<label for="filterItem' + i + j + '" style="margin-left:5px;">' + filterItem + '</label>'
            + '</div>';
    };

    var createFilterLineBefore = function (name) {
        return '<div class="row m-x-0" style="margin-top:10px; border-bottom:1px dashed #8796a4; padding-bottom:5px;">'
            + '<div class="col-xs-12 col-md-2 col-lg-1">'
            + '<button type="button" class="btn btn-primary btn-xs">' + name + '</button>'
            + '</div>'
            + '<div class="col-xs-12 col-md-10 col-lg-10">';
    };

    var createFilterLineAfter = function () {
        return '</div>'
            + '</div>';
    };




    //过滤后结果呈现
    //filterMobile(filter, mobiles);

    var addMonkeyJobItem = function (brand, model, os, serialNumber, busy) {
        return {
            "brand": brand,
            "model": model,
            "os": os,
            "serialNumber": serialNumber,
            "busy":busy
        };
    };

    initMobiles(mobiles);
    /**
     * 可选手机 点击事件
     */
    $(".kexuan_mobile").on("ifChanged", function () {
        var mobile_id = $(this).attr("data-id");
        var mobile_name = $(this).attr("data-mobile-name");
        var mobile_brand = $(this).attr("data-brand");
        var mobile_os = $(this).attr("data-os");
        var mobile_model = $(this).attr("data-model");
        var mobile_serialNumber = $(this).attr("data-serialNumber");
        var mobile_busy = $(this).attr("data-busy");
        if ($(this).is(':checked')) {
            //添加到已选手机

            addMobile(mobile_id, mobile_name, mobile_brand, mobile_os, mobile_busy);

            addMonkeyJobItem();

        } else {
            //从已选手机中删除
            removeMobile(mobile_id, mobile_brand);
        }
    });
    /**
     * 向已选手机框添加选中手机
     * @param id
     * @param name
     * @param brand
     * @param os
     * @param status
     */
    var addMobile = function (id, name, brand, os, busy) {
        // 1、检查是否已经存在该品牌节点
        if (!isExistBrandNode(brand)) {
            //品牌节点不存在，先创建品牌节点
            var brandnode = createYixuanBrandNode(brand);
            $("#yixuan_content").append(brandnode);
        }
        // 2、向品牌节点添加手机
        var mnode = createYixuanMobileNode(id, name, brand, os, busy);
        var brandnodeid = "yixuan_" + brand + "_content";
        $("#" + brandnodeid).append(mnode);

        // 3、品牌节点总数增加1
        brandNumAdd(brand);

        // 4、给该添加的手机添加ifChange 事件
        addIfChangeEvent(id, brand);

        // 5、添加iCheck样式
        var aimid = "yixuan_" + brand + "_" + id;
        addICheck(aimid);
    };

    /**
     * 增加事件
     * @param aimid
     * @param id
     */
    var addIfChangeEvent = function (id, brand) {

        $("#yixuan_" + brand + "_" + id).bind("ifChanged", function () {
            if (!$(this).is(':checked')) {
                $("#kexuan_" + id).iCheck('uncheck'); //此时已经触发，移除手机事件
                //removeMobile(id, brand);
            } else {
                //去除已选
            }
        });
    }
    /**
     * 从已选手机框移除手机
     * @param id
     */
    var removeMobile = function (id, brand) {
        $("#yixuan_" + brand + "_" + id).parent().parent().remove();
        brandNumMinus(brand);
    };

    /**
     * 创建手机节点
     * @param id
     * @param name
     * @param brand
     * @param os
     * @param busy
     * @returns {string}
     */
    var createYixuanMobileNode = function (id, name, brand, os, busy) {
        var mobilebusy;
        if(busy === "false"){
            mobilebusy = mobileNotBusy;
        }
        else{
            mobilebusy = mobileBusy;
        }
        return "<div style='margin:0px 5px' class='inline-block'>"
            + "<input type='checkbox' class='yixuan_mobile'"
            + " id=yixuan_" + brand + "_" + id
            + " data-kexuanid='" + id + "'"
            + " checked/>"
            + "<label for='yixuan_" + brand + "_" + id + "' style='margin: 0 0 3px 0;'>"
            + mobilebusy
            + name + "&nbsp;(" + os + ")&nbsp;"
            + "</label>"
            + "</div>";
    };
    /**
     * 创建品牌节点
     * @param brand
     * @returns {string}
     */
    var createYixuanBrandNode = function (brand) {
        return "<div id='yixuan_" + brand + "' class='p-b-5 m-b-5'>"
            + "<div class='row'>"
            + "<div class='col-xs-12 col-md-12 col-lg-12'>"
            + "   <span id='yixuan_" + brand + "_title' class='tag tag-primary tag-round'>"
            + brand
            + "    <i id='yixuan_" + brand + "_num'>0</i>"
            + "   </span>"
            + "   </div>"
            + "   </div>"
            + "   <div class='row m-t-10'>"
            + "    <div id='yixuan_" + brand + "_content' class='col-xs-12 col-md-12 col-lg-12'>"
            + "</div>"
            + "</div>"
            + "</div>";
    };
    /**
     * 判断是否存在该品牌节点
     * @param brand
     * @returns {boolean}
     */
    var isExistBrandNode = function (brand) {
        var nodeid = "yixuan_" + brand;
        if ($("#" + nodeid).length) {
            return true;
        } else {
            return false;
        }
    };
    /**
     * 品牌节点数字加1
     * @param brand
     */
    var brandNumAdd = function (brand) {
        var num = parseInt($("#yixuan_" + brand + "_num").text());
        var newnum = num + 1;
        $("#yixuan_" + brand + "_num").text(newnum);

        var yixuannum = parseInt($("#yixuan_num").text());
        var newyixuannum = yixuannum + 1;
        $("#yixuan_num").text(newyixuannum);
    };
    /**
     * 品牌节点数字减少1
     * 如果减少到0 则删除该品牌节点
     * @param brand
     */
    var brandNumMinus = function (brand) {
        console.info("减少数字");
        var num = parseInt($("#yixuan_" + brand + "_num").text());

        var newnum = num - 1;

        if (newnum <= 0) {
            // 该品牌节点内不存在手机了，删除该品牌节点
            $("#yixuan_" + brand).remove();
        } else {
            $("#yixuan_" + brand + "_num").text(newnum);
        }

        var yixuannum = parseInt($("#yixuan_num").text());
        var newyixuannum = yixuannum - 1;
        $("#yixuan_num").text(newyixuannum);
    };
    /**
     * 添加iCheck 样式
     * @param id
     */
    var addICheck = function (id) {
        $("#" + id).iCheck({
            checkboxClass: 'icheckbox_flat-grey',
            radioClass: 'iradio_flat'
        });
    };
    
    $("#step2_submit").click(function () {
        var num = $("#yixuan_num").text();
        if( num > 0 ){
            $("#step2_form").submit();
        }else{
            swal($.i18n.prop("project.createtask.step2.input"),"","warning");
        }

    });


});