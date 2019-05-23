/**
 * Created by Salt on 2017/9/18.
 */
$(document).ready(function () {

    var $inputFile = $('#script_file').dropify({
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

    $('#radio_pip').on('ifChanged', function () {
        if($(this).is(':checked')){
            $('#zip_file_area').slideUp();
            $('#pip_cmd_area').slideDown();
        }
    });

    $('#radio_zip').on('ifChanged', function () {
        if($(this).is(':checked')){
            $('#zip_file_area').slideDown();
            $('#pip_cmd_area').slideUp();
        }
    })
});