/**
 * Created by xueshan.wei on 1/18/2017.
 */
$(document).ready(function () {
    var baseUrl = $("#baseUrl").attr("baseUrl");

    //设置ajax 请求同步
    $.ajaxSettings.async = false;
    //加载系统语言
    var system_language = {};
    var url = baseUrl + "/api/common/language"
    $.getJSON(url, function (data) {
        system_language = data.data;
    });
    console.info("国际化文件" + system_language);
    jQuery.i18n.properties({
        name:'strings',
        path:baseUrl + '/static/i18n/',
        mode:'map',
        language:system_language.language,
        callback: function() {
            console.info("回调");
            //var test1 = jQuery.i18n.prop('testname1');
        }
    });
});