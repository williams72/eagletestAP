/**
 * Created by xueshan.wei on 1/5/2017.
 */
$(document).ready(function () {
    var baseUrl = $("#baseUrl").attr("baseUrl");
    var currentProjectId = $("#currentProjectId").attr("currentProjectId");
    var currentProjectType = $("#currentProjectType").attr("currentProjectType");
    $("#versionPiePro").asPieProgress('start');
    //$.ajaxSettings.async = false;
    //加载手机数据

    var initMobileInfo = function (mobiles) {
        var freeMobile = 0;
        var mobileNum = 0;
        for(index in mobiles){
            mobileNum ++;
            var mobile = mobiles[index];
            if(mobile.busy === false){
                freeMobile ++;
            }
        }

        $("#mobileInfoKongxian").html(freeMobile);
        $("#mobileInfoTotal").html(mobileNum);
        var rateValue = 0;
        if(mobileNum != 0){
            rateValue = parseInt((freeMobile/mobileNum) * 100);
        }
        $("#mobileInfo").asPieProgress("go", rateValue);
    };

    //接口数据，1：安卓， 2：IOS
    var osType;
    if(currentProjectType == 0){
        osType = 1;
    }else{
        osType = 2;
    }

    var mobiles;
    $.ajax({
        url:baseUrl + "/api/mobiles",
        type:"get",
        data:{
            "engine": 1,
            "os": osType
        },
        success:function (data) {
            if(data.code === "00000000"){
                console.info("获取手机列表成功");
                mobiles = data.data;
                console.info(mobiles);
                //初始化手机信息
                initMobileInfo(mobiles);
            }
        },
        error:function () {
            console.info("获取手机列表失败")
        }

    });

    //设置ajax 请求同步
    //$.ajaxSettings.async = false;
    //加载版本类型测试成功率
    //var rate = {};
    var formatRate = function (data) {
        var newRate = {
            "rate_com":[$.i18n.prop("js.project.dash.rate_com")],
            "rate_case":[$.i18n.prop("js.project.dash.rate_case")],
            "rate_travel":[$.i18n.prop("js.project.dash.rate_travel")]
        }
        for(index in data.rate.rate_com){
            newRate.rate_com.push(data.rate.rate_com[index]);
        }
        for(index in data.rate.rate_case){
            newRate.rate_case.push(data.rate.rate_case[index]);
        }
        for(index in data.rate.rate_travel){
            newRate.rate_travel.push(data.rate.rate_travel[index]);
        }

        return newRate;
    };
    var initRate = function (rate){
        var newRate = formatRate(rate);
        var version_tongji = c3.generate({
            bindto: '#version_tongji',
            data: {
                columns: [
                    newRate.rate_com,
                    newRate.rate_case,
                    newRate.rate_travel
                ]
            },
            /*
             size: {
             height: 280
             },*/
            /*color: {
             pattern: [Config.colors("primary", 500), Config.colors("blue-grey", 200)]
             },*/
            axis: {
                x: {
                    type: 'category',
                    categories: rate.versionsName
                },
                y: {
                    max: 100,
                    min: 0,
                    padding: {top: 12, bottom: 5},
                    show: true,
                    /* 加%单位

                     tick: {
                     // format: d3.format("%")
                     }
                     */
                }
                /*
                tooltip: {
                    format: {
                        title: function (d) { return 'Data ' + d; },
                        value: function (value, ratio, id) {
                            var format = id === '兼容性测试' ? d3.format(',') : d3.format('%');
                            return format(value);
                        }
                    }
                }
                */
            }
        });
    };
    var url = baseUrl + "/project/" + currentProjectId + "/versubrate";
    $.getJSON(url, function (data) {
        initRate(data);
    });






});