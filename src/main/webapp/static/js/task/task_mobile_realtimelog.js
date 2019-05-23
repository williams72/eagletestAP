/**
 * Created by Salt on 2017/9/12.
 */
$(document).ready(function () {
    var baseUrl = $('#baseUrl').attr('baseUrl');
    var currentProjectId = $('#currentProjectId').attr('currentProjectId');
    var currentTaskId = $('#currentTaskId').attr('currentTaskId');
    var taskId = $('#taskId').attr('taskId');
    var currentMobileSerialNum = $('#currentMobileSerialNum').attr('currentMobileSerialNum');

    var log_file = '';
    var debug_file = '';
    var log_file_path = '';
    var debug_file_path = '';

    getLogFilePath();
    updateLogFile();
    var timerRefreshLog =  window.setInterval(refreshLog, 100);
    var timerRefreshDebug =  window.setInterval(refreshDebug, 100);



    //切换手机
    $('#mobile_select').change(function () {
        var mobile_serialNum = $(this).val();
        window.location.href = baseUrl + '/project/' + currentProjectId + '/task/' + currentTaskId + '/realtimelog?serialNum=' + mobile_serialNum;
    });

    //16进制转换
    function stringToHex(str) {
        var hex = '';
        for (var i = 0; i < str.length; i++){
            hex += str.charCodeAt(i).toString(16);
        }
        return hex;
    }

    //实时更新日志文件
    function updateLogFile() {
        console.log('等待文件' + log_file + ',' + debug_file);
        if(log_file !== '' || debug_file !== ''){
            console.log('updateFile!');
            $.ajax({
                url: baseUrl + '/api/rflog',
                type: 'PUT',
                data:{
                    'taskId': taskId,
                    'serialNum': currentMobileSerialNum,
                    'logFile': log_file,
                    'debugFile': debug_file
                },
                success:function (data) {
                    if(data.code === "00000000"){
                        log_file_path = data.data.logFilePath;
                        debug_file_path = data.data.debugFilePath;
                        setTimeout(updateLogFile, 100);
                    }
                },
                error:function () {
                }
            });
        }else {
            setTimeout(updateLogFile, 100);
        }

    }

    function getLogFilePath() {
        console.log('getLog!');
        $.ajax({
            url: baseUrl + '/api/rflog',
            type: 'GET',
            data: {
                'taskId': taskId,
                'serialNum': currentMobileSerialNum
            },
            success:function (data) {
                if(data.code === '00000000'){
                    var result = data.data;
                    if('status' in result){
                        for(var key in result.logDetail){
                            if(key === currentMobileSerialNum)
                            var filePath = result.logDetail[key];
                            log_file = filePath[0];
                            debug_file = filePath[1];
                        }
                        if(log_file === '' || debug_file === ''){
                            // clearInterval(timerGetFilePath);
                            // window.setInterval(updateLogFile, 3000);
                            setTimeout(getLogFilePath, 100);
                        }
                    }
                }else {
                    setTimeout(getLogFilePath, 100);
                }
            },
            error:function () {
            }
        });
    }
    function refreshLog() {
        if(log_file_path !== ''){
            clearInterval(timerRefreshLog);
            console.log('refreshLog!');
            log_file_path = stringToHex(log_file_path);
            var curPath = window.document.location.href;
            var pos = curPath.indexOf(window.document.location.pathname);
            var localhostPath=curPath.substring(7, pos);
            var websoket_log = new WebSocket('ws://'+ localhostPath + baseUrl + '/websocket/log/' + log_file_path);
            var scriptlog_container = $('#scriptlog_container');
            var scriptlog_container_div = scriptlog_container.find('div');
            websoket_log.onmessage = function (event) {
                scriptlog_container_div.append(event.data);
                scriptlog_container.scrollTop(scriptlog_container_div.height() - scriptlog_container.height());
            };
            // 关闭页面前关闭websoket
            window.onbeforeunload = function () {
                websoket_log.close();
            };
        }

    }

    function refreshDebug() {
        if(debug_file_path !== ''){
            clearInterval(timerRefreshDebug);
            console.log('refreshDebug!');
            debug_file_path = stringToHex(debug_file_path);
            var curPath = window.document.location.href;
            var pos = curPath.indexOf(window.document.location.pathname);
            var localhostPath=curPath.substring(7, pos);
            var websoket_debug = new WebSocket('ws://' + localhostPath + baseUrl + '/websocket/log/' + debug_file_path);
            var debuglog_container = $('#debuglog_container');
            var debuglog_container_div = debuglog_container.find('div');
            websoket_debug.onmessage = function (event) {
                debuglog_container_div.append(event.data);
                debuglog_container.scrollTop(debuglog_container_div.height() - debuglog_container.height());
            };

            // 关闭页面前关闭websoket
            window.onbeforeunload = function () {
                websoket_debug.close();
            };
        }

    }
});

