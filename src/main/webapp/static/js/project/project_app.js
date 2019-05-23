/**
 * Created by xueshan.wei on 12/29/2016.
 */
$(document).ready(function () {
    var $inputFile = $('#input-file-now').dropify({
        messages: {
            'default': $.i18n.prop("input.file.message.default"),
            'replace': $.i18n.prop("input.file.message.replace"),
            'remove':  $.i18n.prop("input.file.message.remove"),
            'error':   $.i18n.prop("input.file.message.error")
        },
        error:{
            'fileExtension': $.i18n.prop("input.file.message.extension")
        }
    });
});