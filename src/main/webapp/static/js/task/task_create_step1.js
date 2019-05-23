/**
 * Created by xueshan.wei on 11/28/2016.
 */
$(document).ready(function () {
    var baseUrl = $('#baseUrl').attr('baseUrl');

    // 任务名称实时检测
    $('#task_name').blur(function () {
        taskNameCheck();
    });

    // 运行包实时检测
    $('#task_app').on("select2:close", function () {
        taskAppCheck();
    });

    //兼容时间实时检测
    $('#task_compatibility_time').blur(function () {
        taskCompatibilityTimeCheck();
    });

    //遍历时间实时检测
    $('#task_traversal_time').blur(function () {
        taskTraversalTimeCheck();
    });

    /**
     * 提交按钮表单校验
     */
    $('#task_step1_submit').click(function () {
        var taskName = taskNameCheck();
        var taskApp = taskAppCheck();
        var taskType = taskTypeCheck();
        var taskCompatibilityTime = true;
        var scriptFile = true;
        var fileTree = true;
        var taskTraversalTime = true;

        var compatibility = $('#task_compatibility').is(':checked');
        var script = $('#task_script').is(':checked');
        var traversal = $('#task_traversal').is(':checked');

        if(compatibility){
            taskCompatibilityTime = taskCompatibilityTimeCheck();
        }
        if(script){
            scriptFile = scriptFileCheck();
            if($('#script_robotFramework').is(':checked')){
                fileTree = fileTreeCheck();
            }
        }
        if(traversal){
            taskTraversalTime = taskTraversalTimeCheck();
        }

        if(!(taskName && taskApp && taskType && taskCompatibilityTime && scriptFile && fileTree && taskTraversalTime)){
            return;
        }
        // 设置脚本命令
        setScriptcmd();
        $('#task_step1_form').submit();

    });

    // 弱网选项
    $('#task_weakNetwork').on('ifChanged', function () {
        if($(this).is(':checked')){
            $('#task_network_Select').slideDown();
        }else{
            $('#task_network_Select').slideUp();
        }
    });

    // 单项测试
    /*var testGroup = false;
    $('#test_single').on('ifChanged', function () {
        if($(this).is(':checked')){
            $('#smart_traversal_check').slideDown();
            testGroup = false;
            $('#task_compatibility').iCheck('uncheck');
            $('#task_script').iCheck('uncheck');
            $('#task_traversal').iCheck('uncheck');
            $('#task_smartTraversal').iCheck('uncheck');
        }
    });*/

    // 组合测试
    /*$('#test_combinatorial').on('ifChanged', function () {
        if($(this).is(':checked')){
            testGroup = true;
            $('#smart_traversal_check').slideUp();
        }
    });*/

    // 遍历测试
    $('#task_compatibility').on('ifChanged', function () {
        taskTypeCheck();
        if($(this).is(':checked')){
            /*if(!testGroup)
            {
                $('#task_script').iCheck('uncheck');
                $('#task_traversal').iCheck('uncheck');
                $('#task_smartTraversal').iCheck('uncheck');
            }*/
            $('#task_compatibility_area').slideDown();
        }else{
            $('#task_compatibility_area').slideUp();
        }
    });

    // 遍历高级
    $('#task_btn_optInfo').change(function () {

        if($(this).is(':checked')){
            $('#task_optInfo_area').slideDown();
        }else{
            $('#task_optInfo_area').slideUp();
        }
    });

    // 脚本测试
    $('#task_script').on('ifChanged', function () {
        taskTypeCheck();
        //var scriptFile = $('#script_file');
        if($(this).is(':checked')){
            /*if(!testGroup)
            {
                $('#task_compatibility').iCheck('uncheck');
                $('#task_traversal').iCheck('uncheck');
                $('#task_smartTraversal').iCheck('uncheck');
            }*/
            $('#task_script_area').slideDown();
        }else{
            $('#task_script_area').slideUp();
        }
    });

    // RF脚本
    $('#script_robotFramework').on('ifChanged', function () {
       $('#script_file').val('');
       $('#script_file_text').val('');
       $('#rf_script_tree_area').slideUp();
    });

    // 遍历测试
    $('#task_traversal').on('ifChanged', function () {
        taskTypeCheck();
        if($(this).is(':checked')){
            /*if(!testGroup)
            {
                $('#task_compatibility').iCheck('uncheck');
                $('#task_script').iCheck('uncheck');
                $('#task_smartTraversal').iCheck('uncheck');

            }*/
            $('#task_traversal_area').slideDown();

        }else{
            taskTypeCheck();
            $('#task_traversal_area').slideUp();
        }
    });

    /*// 智能遍历测试
    $('#task_smartTraversal').on('ifChanged', function () {
        if($(this).is(':checked')){
            if(!testGroup)
            {
                $('#task_compatibility').iCheck('uncheck');
                $('#task_script').iCheck('uncheck');
                $('#task_traversal').iCheck('uncheck');
            }
        }else{
            taskTypeCheck();
        }
    });*/

    // RF脚本文件目录结构树
    $('#file_tree').jstree({
        'core': {
            'data': []
        },
        checkbox: {
            //three_state : false, // to avoid that fact that checking a node also check others
            //whole_node : false,  // to avoid checking the box just clicking the node
            tie_selection : false // for checking without selecting and selecting without checking
        },
        'plugins': ['checkbox']
    }).on('check_node.jstree uncheck_node.jstree', function (event, data) {
        fileTreeCheck();
    });

    // 点击上传按钮时，重置文件框内容
    $('#btn_script_file_upload').click(function () {
        $('#script_file').val('');
        $('#script_file_text').val('');
        $('#rf_script_tree_area').slideUp();
    });

    var tree_root_id = '';  //定义根目录
    var rf_tags = new Set();  //定义tag为初始化set集合
    // 文件框内容变化, ajax获取树结构
    $('#script_file').change(function () {
        var file_tree = $('#file_tree');
        //文件框值发生变化就清除tree和tag
        file_tree.jstree().settings.core.data = [];
        file_tree.jstree().refresh(true);
        rf_tags.clear();
        $('#rf_script_tag').html('');

        if($('#script_robotFramework').is(':checked')){
            if($(this).val() !== ''){

                var formData = new FormData();
                formData.append('file', document.getElementById('script_file').files[0]);

                $.ajax({
                    url: baseUrl + '/api/common/file/analysis',
                    type: 'POST',
                    async: false,
                    contentType: false,
                    processData: false,
                    data: formData,
                    success: function (data) {
                        if(data.code === '00000000'){
                            console.log(data.data);
                            file_tree.jstree().settings.core.data = data.data;
                            tree_root_id = data.data.id;
                            file_tree.jstree('refresh');
                            //file_tree.jstree('check_node', $('#' + tree_root_id));

                            getTags(data.data);
                            setTags();
                            $('#rf_script_tree_area').slideDown();
                            setTimeout(checkAll, 300);
                        }else {
                            swal($.i18n.prop('task.create.step1.file.form.error'),'','warning');
                            $('#script_file').val('');
                            $('#rf_script_tree_area').slideUp();
                        }
                    },
                    fail: function () {

                    }
                });

            }else {

                $('#rf_script_tree_area').slideUp();
            }
        }else {
            $('#rf_script_tree_area').slideUp();
        }
    });

    function taskNameCheck() {
        var task_name = $('#task_name');
        var taskName = task_name.val().trim();
        var task_name_check = $('#task_name_check');
        var task_name_check_content = $('#task_name_check_content');
        var regName = /^[\u4E00-\u9FA5A-Za-z0-9_]+$/;   // 正则：中文、字母、数字和下划线组成

        if(taskName === undefined || taskName === ''){
            task_name.parent().parent().addClass('has-danger');
            task_name_check_content.html($.i18n.prop('task.create.step1.name.empty'));
            task_name_check.slideDown();
            return false;
        }else if(!regName.test(taskName)){
            task_name.parent().parent().addClass('has-danger');
            task_name_check_content.html($.i18n.prop('task.create.step1.name.form.error'));
            task_name_check.slideDown();
            return false;
        }else {
            task_name.parent().parent().removeClass('has-danger');
            task_name_check.slideUp();
            return true;
        }
    }

    function taskAppCheck() {
        var task_app = $('#task_app');
        var taskApp = task_app.val().trim();
        var task_app_check = $('#task_app_check');
        var task_app_check_content = $('#task_app_check_content');
        if(taskApp === undefined || taskApp === ''){
            task_app.parent().parent().addClass('has-danger has-error');
            task_app_check_content.html($.i18n.prop('task.create.step1.app.empty'));
            task_app_check.slideDown();
            return false;
        }else {
            task_app.parent().parent().removeClass('has-danger has-error');
            task_app_check.slideUp();
            return true;
        }
    }

    function taskCompatibilityTimeCheck() {
        var task_compatibility_time = $('#task_compatibility_time');
        var compatibilityTime = task_compatibility_time.val().trim();
        var task_compatibility_time_check = $('#task_compatibility_time_check');
        var task_compatibility_time_check_content = $('#task_compatibility_time_check_content');
        var regTime = /^[0-9]+$/;   // 正则：由数字组成

        if(compatibilityTime === undefined || compatibilityTime === ''){
            task_compatibility_time.parent().parent().addClass('has-danger');
            task_compatibility_time_check_content.html($.i18n.prop('task.create.step1.time.empty'));
            task_compatibility_time_check.slideDown();
            return false;
        }else if(!regTime.test(compatibilityTime)){
            task_compatibility_time.parent().parent().addClass('has-danger');
            task_compatibility_time_check_content.html($.i18n.prop('task.create.step1.time.form.error'));
            task_compatibility_time_check.slideDown();
            return false;
        }else if(compatibilityTime < 5 || compatibilityTime > 10080){
            task_compatibility_time.parent().parent().addClass('has-danger');
            task_compatibility_time_check_content.html($.i18n.prop('task.create.step1.time.error'));
            task_compatibility_time_check.slideDown();
            return false;
        }else {
            task_compatibility_time.parent().parent().removeClass('has-danger');
            task_compatibility_time_check.slideUp();
            return true;
        }
    }

    function scriptFileCheck() {
        var scriptFile = $('#script_file').val();
        if(scriptFile === undefined || scriptFile === ''){
            $('#script_file_upload').addClass('has-danger');
            $('#script_file_check_content').html($.i18n.prop('task.create.step1.file.empty'));
            $('#script_file_check').slideDown();
            return false;
        }else {
            $('#script_file_upload').removeClass('has-danger');
            $('#script_file_check').slideUp();
            return true;
        }
    }
    
    function fileTreeCheck() {
        var c = $('#file_tree').jstree('get_checked');
        if(c.length === 0){
            $('#file_tree_check_content').html($.i18n.prop('task.create.step1.case.least.one'));
            $('#file_tree_check').slideDown();
            return false;
        }else {
            $('#file_tree_check').slideUp();
            return true;
        }
    }

    function taskTraversalTimeCheck() {
        var task_traversal_time = $('#task_traversal_time');
        var traversalTime = task_traversal_time.val();
        var task_traversal_time_check = $('#task_traversal_time_check');
        var task_traversal_time_check_content = $('#task_traversal_time_check_content');
        var regTime = /^[0-9]+$/;   // 正则：由数字组成
        if(traversalTime === undefined || traversalTime === ''){
            task_traversal_time.parent().parent().addClass('has-danger');
            task_traversal_time_check_content.html($.i18n.prop('task.create.step1.time.empty'));
            task_traversal_time_check.slideDown();
            return false;
        }else if(!regTime.test(traversalTime)){
            task_traversal_time.parent().parent().addClass('has-danger');
            task_traversal_time_check_content.html($.i18n.prop('task.create.step1.time.form.error'));
            task_traversal_time_check.slideDown();
            return false;
        }else if(traversalTime < 5 || traversalTime > 10080){
            task_traversal_time.parent().parent().addClass('has-danger');
            task_traversal_time_check_content.html($.i18n.prop('task.create.step1.time.error'));
            task_traversal_time_check.slideDown();
            return false;
        }else {
            task_traversal_time.parent().parent().removeClass('has-danger');
            task_traversal_time_check.slideUp();
            return true
        }
    }

    function taskTypeCheck() {
        var compatibility = $('#task_compatibility').is(':checked');
        var script = $('#task_script').is(':checked');
        var traversal = $('#task_traversal').is(':checked');
        var smartTraversal = $('#task_smartTraversal').is(':checked');
        if(compatibility === false && script === false && traversal === false && smartTraversal === false){
            $('#task_type_check_content').html($.i18n.prop('task.create.step1.testtype.empty'));
            $('#task_type_check').slideDown();
            return false;
        }else {
            $('#task_type_check').slideUp();
            return true;
        }

    }

    // 根据选中的目录生成脚本命令
    function setScriptcmd() {
        var tags = $('#rf_script_tag').val();  //如果未选中为null
        var selectedTreeArr = $('#file_tree').jstree('get_checked');

        var scriptCmd = 'pybot --outputdir {$resultPath}  --debugfile {$resultPath}/debug.txt';
        var case_param = '';
        if(tags !== null){
            $.each(tags, function (index, value) {
                scriptCmd += ' --include ' + value;
            })
        }
        $.each(selectedTreeArr, function (index, value) {
            if (value.startsWith('$case:')) {
                re = new RegExp('/', 'g');
                var case_value = value.replace('$case:/', '').replace('.txt', '').replace(re, '.');
                var suite_value = case_value.substr(0, case_value.lastIndexOf('.'));
                case_param += ' --suite ' + suite_value + ' --test ' + case_value;
            }
        });

        scriptCmd += case_param + ' {$casePath}' + tree_root_id + "/";

        $('#scriptCmd').val(scriptCmd);

    }

    // 获取脚本文件中的tag
    function getTags(fileTree) {
        $.each(fileTree, function (key, item) {
            if (key === 'icon' && item === 'wb-folder') {
                for (var i = 0; i < fileTree.children.length; i++) {
                    getTags(fileTree.children[i])
                }
            } else if (key === 'icon' && item === 'wb-file') {
                for (var j = 0; j < fileTree.children.length; j++) {
                    getTags(fileTree.children[j])
                }
            } else if (key === 'icon' && item === 'wb-extension') {
                rf_tags.add(fileTree.tag);
                //console.log(rf_tags.elements);
            }
        });

    }

    // 更新dom中的tag
    function setTags() {
        var element = '';
        var rf_script_tag = $('#rf_script_tag');
        if(rf_tags.containsValue(undefined)){
            rf_tags.remove(undefined);
        }
        rf_script_tag.html('');
        $.each(rf_tags.elements, function (index, values) {
            element = '<option value=\"' + values +'\">&nbsp; ' + values + '</option>';
            rf_script_tag.append(element);
        });

        rf_script_tag.selectpicker('refresh');
    }

    // 模拟java Set集合
    function Set() {
        this.elements = [];
        //获取Set元素个数
        this.size = function() {
            return this.elements.length;
        };

        //判断Set是否为空
        this.isEmpty = function() {
            return (this.elements.length < 1);
        };

        //清除Set
        this.clear = function() {
            this.elements = [];
        };
        //增加一个元素，不重复
        this.add = function(value) {
            //alert(this.containsKey(_key));
            if(this.containsValue(value)){
                this.remove(value);
            }
            this.elements.push(value);
        };
        //移除一个值
        this.remove = function(value) {
            var bln = false;
            try {

                for (i = 0; i < this.elements.length; i++) {

                    if (this.elements[i] == value) {

                        this.elements.splice(i, 1);

                        return true;
                    }
                }
            } catch (e) {
                bln = false;
            }
            return bln;
        };

        //移除一个值,索引
        this.kill=function (index){
            this.remove(this.get(index));
        };

        //查看是否包含一个值
        this.containsValue = function(value) {
            var bln = false;
            try {
                for (i = 0; i < this.elements.length; i++) {
                    if (this.elements[i] == value) {
                        bln = true;
                    }
                }
            } catch (e) {
                bln = false;
            }
            return bln;
        }

    }

    function checkAll() {
        $('#file_tree').jstree('check_all');
        fileTreeCheck();
    }

});