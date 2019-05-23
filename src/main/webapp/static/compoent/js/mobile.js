/**
 * Created by xueshan.wei on 10/26/2016.
 */
$(document).ready(function (){
    $(".mobile").mouseenter(function(){
        console.info("。。。。。");
        var $mobile = $(this).children("div.mobile_cover");
        $mobile.addClass("mobile_cover_show");
        //$mobile.show();
        $mobile.animate({left:'170px'},500);

        var $mobile_btn = $(this).find("div.mobile_footer_2");
        $mobile_btn.animate({top:'210px'}, 300);

        var $mobile_body_cover = $(this).find("div.mobile_body_cover");
        $mobile_body_cover.animate({left:'0px'}, 300);

    });
    $(".mobile").mouseleave(function (){
        var $mobile = $(this).children("div.mobile_cover");
        $mobile.animate({left:'0px'},0);
        $mobile.removeClass("mobile_cover_show");
        //$mobile.hide();
        var $mobile_btn = $(this).find("div.mobile_footer_2");
        $mobile_btn.animate({top:'240px'}, 300);
        var $mobile_body_cover = $(this).find("div.mobile_body_cover");
        $mobile_body_cover.animate({left:'160px'}, 300);

    });
});