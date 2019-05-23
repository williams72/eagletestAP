/**
 * Created by xueshan.wei on 4/20/2017.
 */
$(document).ready(function () {
    var baseUrl = $("#baseUrl").attr("baseUrl");
    //设置toastr 的属性
    toastr.options = {
        "showMethod": "slideDown",
    }
    //全局变量
    var weaknet_id;
    //编辑modal
    var $weaknet_edit_modal = $("#weaknet_edit_modal");
    var $wem_name = $weaknet_edit_modal.find(".name");
    var $wem_desc = $weaknet_edit_modal.find(".desc");
    var $wem_param = $weaknet_edit_modal.find(".param");
    var $wem_submit = $weaknet_edit_modal.find(".submit");

    //新增modal
    var $weaknet_add_modal = $("#weaknet_add_modal");
    var $wam_name = $weaknet_add_modal.find(".name");
    var $wam_desc = $weaknet_add_modal.find(".desc");
    var $wam_param = $weaknet_add_modal.find(".param");
    var $wam_submit = $weaknet_add_modal.find(".submit");

    /**
     * 弱网开关
     */
    $(".weaknet_enable_switch").on("change", function () {
        var wnid = $(this).attr("data-weaknetid");
        var action = "POST";
        if(!$(this).is(":checked")){
            action = "DELETE";
        }
        //发送请求
        $.ajax({
            url:baseUrl + "/api/weaknet/" + wnid + "/availability",
            type:action,
            success:function(data, status){
                //var data1 = eval("("+data+")");
                if(data.code === "00000000"){
                    toastr.success($.i18n.prop("js.weaknet.page.changestatus.success"),"",{timeOut:1500});
                }else{
                    toastr.error($.i18n.prop("js.weaknet.page.error.code") + data.code, $.i18n.prop("js.weaknet.page.error.msg"));
                }
            },
            error:function(){
                toastr.error($.i18n.prop("js.weaknet.page.ajax.error.content"), $.i18n.prop("js.weaknet.page.ajax.error.title"));
            }
        });
    });

    /**
     * 删除弱网项
     */
    $(".weaknet_remove").on("click", function () {
        //获取要删除的弱网项id
        var wnid = $(this).attr("data-weaknetid");
        var $weaknet_item = $(this).parent().parent();
        //发送删除请求
        $.ajax({
            url:baseUrl + "/api/weaknet/" + wnid,
            type:"DELETE",
            success:function(data, status){
                //var data1 = eval("("+data+")");
                if(data.code === "00000000"){
                    toastr.success($.i18n.prop("js.weaknet.page.delete.success"),"",{timeOut:1500});
                    $weaknet_item.remove();
                }else{
                    toastr.error($.i18n.prop("js.weaknet.page.error.code") + data.code, $.i18n.prop("js.weaknet.page.error.msg"))
                }
            },
            error:function(){
                toastr.error($.i18n.prop("js.weaknet.page.ajax.error.content"), $.i18n.prop("js.weaknet.page.ajax.error.title"));
            }
        });
    });

    /**
     * 编辑弱网项
     */
    $(".weaknet_edit").on("click", function () {
       //获取要编辑的弱网项id
        weaknet_id = $(this).attr("data-weaknetid");
        //向后台发送请求获取该弱网项其他内容
        $.ajax({
            url:baseUrl + "/api/weaknet/" + weaknet_id,
            type:"GET",
            success:function(data, status){
                //var data1 = eval("("+data+")");
                if(data.code === "00000000"){
                    //向编辑框添加数据
                    $wem_name.val(data.data.name);
                    $wem_desc.val(data.data.desc);
                    $wem_param.val(data.data.param);
                    //显示编辑框
                    $weaknet_edit_modal.modal("show");
                }else{
                    toastr.error($.i18n.prop("js.weaknet.page.error.code") + data.code, $.i18n.prop("js.weaknet.page.error.msg"))
                }

            },
            error:function(){
                toastr.error($.i18n.prop("js.weaknet.page.ajax.error.content"), $.i18n.prop("js.weaknet.page.ajax.error.title"));
            }
        });
    });

    //点击保存修改
    $wem_submit.click(function () {
        //得到修改后的数据
        var data = {};
        data.name = $wem_name.val();
        data.desc = $wem_desc.val();
        data.param = $wem_param.val();
        //检查内容是否完整
        if(data.name == undefined || data.name == ""){
            toastr.error($.i18n.prop("js.weaknet.page.edit.check.name"), $.i18n.prop("js.weaknet.page.edit.check.title"));
            return;
        }
        if(data.desc == undefined || data.desc == ""){
            toastr.error($.i18n.prop("js.weaknet.page.edit.check.desc"), $.i18n.prop("js.weaknet.page.edit.check.title"));
            return;
        }
        if(data.param == undefined || data.param == ""){
            toastr.error($.i18n.prop("js.weaknet.page.edit.check.param"), $.i18n.prop("js.weaknet.page.edit.check.title"));
            return;
        }
        var weaknet = JSON.stringify(data);
        //发送保存请求{json:escape(str)}
        $.ajax({
            url:baseUrl + "/api/weaknet/" + weaknet_id,
            type:"PUT",
            data:weaknet,
            contentType:"application/json;charset=utf-8",
            success:function(data, status){
                //var data1 = eval("("+data+")");
                if(data.code === "00000000"){
                    toastr.info($.i18n.prop("js.weaknet.page.edit.success"),"",{timeOut:1500});
                    $weaknet_edit_modal.modal("hide");
                    setTimeout(function () {
                        window.location.href = baseUrl + "/weaknets";
                    }, 1000);
                }else{
                    toastr.error($.i18n.prop("js.weaknet.page.error.code") + data.code, $.i18n.prop("js.weaknet.page.error.msg"))
                }
            },
            error:function(){
                toastr.error($.i18n.prop("js.weaknet.page.ajax.error.content"), $.i18n.prop("js.weaknet.page.ajax.error.title"));
            }
        });

    });
    /**
     * 清空添加弹出框
     *
     */
    $("#weaknet_add_btn").click(function () {
        //清空内容
        $wam_name.val("");
        $wam_desc.val("");
        $wam_param.val("");
    });
    /**
     * 添加弱网项
     */
    $wam_submit.click(function () {
        //获取新增弱网项内容
        var weaknet = {};
        weaknet.name = $wam_name.val();
        weaknet.desc = $wam_desc.val();
        weaknet.param = $wam_param.val();

        //检查内容是否完整
        if(weaknet.name == undefined || weaknet.name == ""){
            toastr.error($.i18n.prop("js.weaknet.page.edit.check.name"), $.i18n.prop("js.weaknet.page.edit.check.title"));
            return;
        }
        if(weaknet.desc == undefined || weaknet.desc == ""){
            toastr.error($.i18n.prop("js.weaknet.page.edit.check.desc"), $.i18n.prop("js.weaknet.page.edit.check.title"));
            return;
        }
        if(weaknet.param == undefined || weaknet.param == ""){
            toastr.error($.i18n.prop("js.weaknet.page.edit.check.param"), $.i18n.prop("js.weaknet.page.edit.check.title"));
            return;
        }

        //发送添加请求
        $.ajax({
            url:baseUrl + "/api/weaknet",
            type:"POST",
            data:JSON.stringify(weaknet),
            contentType:"application/json;charset=utf-8",
            success:function(data, status){
                //var data1 = eval("("+data+")");
                if(data.code === "00000000"){
                    toastr.success($.i18n.prop("js.weaknet.page.add.success"),"",{timeOut:1500});
                    $weaknet_add_modal.modal("hide");
                    setTimeout(function () {
                        window.location.href = baseUrl + "/weaknets";
                    }, 1000);
                }else{
                    toastr.error($.i18n.prop("js.weaknet.page.error.code") + data.code, $.i18n.prop("js.weaknet.page.error.msg"))
                }
            },
            error:function(){
                toastr.error($.i18n.prop("js.weaknet.page.ajax.error.content"), $.i18n.prop("js.weaknet.page.ajax.error.title"));
            }
        });

    });

});