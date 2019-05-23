/**
 * Created by Salt on 2017/4/24.
 */

$(document).ready(function () {
    $("#site-body a").click(function (){
        var a = $(this).attr("name");
        if (a !== undefined){
            $(this).parent().siblings().removeClass("open");
            $(this).parent().siblings().children().children("li").removeClass("active");
            $(this).parent().parent().parent().siblings().children().children("li").removeClass("active");

            $(this).parent().parent().parent().siblings().children().children().removeClass("open");
            $(this).parent().parent().parent().siblings().children().children().children().children("li").removeClass("active");

            $(this).parent().parent().parent().parent().parent().siblings().children().children("li").removeClass("active");

            $(this).parent().parent().parent().siblings().removeClass("active");
            $(this).parent().siblings().children().children().removeClass("open");
            $(this).parent().siblings().children().children().children().children("li").removeClass("active");
            $("#page").load(a + ".html");
        }
    });
});