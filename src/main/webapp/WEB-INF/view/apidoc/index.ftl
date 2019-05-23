<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>EagleTest API DOC</title>
    <link rel="icon" type="image/png" href="${rc.contextPath}/static/swagger/images/logo-img2.ico" sizes="32x32"/>
    <link href='${rc.contextPath}/static/swagger/css/typography.css' media='screen' rel='stylesheet' type='text/css'/>
    <link href='${rc.contextPath}/static/swagger/css/reset.css' media='screen' rel='stylesheet' type='text/css'/>
    <link href='${rc.contextPath}/static/swagger/css/screen.css' media='screen' rel='stylesheet' type='text/css'/>
    <link href='${rc.contextPath}/static/swagger/css/reset.css' media='print' rel='stylesheet' type='text/css'/>
    <link href='${rc.contextPath}/static/swagger/css/print.css' media='print' rel='stylesheet' type='text/css'/>

    <script src='${rc.contextPath}/static/swagger/lib/object-assign-pollyfill.js' type='text/javascript'></script>
    <script src='${rc.contextPath}/static/swagger/lib/jquery-1.8.0.min.js' type='text/javascript'></script>
    <script src='${rc.contextPath}/static/swagger/lib/jquery.slideto.min.js' type='text/javascript'></script>
    <script src='${rc.contextPath}/static/swagger/lib/jquery.wiggle.min.js' type='text/javascript'></script>
    <script src='${rc.contextPath}/static/swagger/lib/jquery.ba-bbq.min.js' type='text/javascript'></script>
    <script src='${rc.contextPath}/static/swagger/lib/handlebars-4.0.5.js' type='text/javascript'></script>
    <script src='${rc.contextPath}/static/swagger/lib/lodash.min.js' type='text/javascript'></script>
    <script src='${rc.contextPath}/static/swagger/lib/backbone-min.js' type='text/javascript'></script>
    <script src='${rc.contextPath}/static/swagger/swagger-ui.js' type='text/javascript'></script>
    <script src='${rc.contextPath}/static/swagger/lib/highlight.9.1.0.pack.js' type='text/javascript'></script>
    <script src='${rc.contextPath}/static/swagger/lib/highlight.9.1.0.pack_extended.js' type='text/javascript'></script>
    <script src='${rc.contextPath}/static/swagger/lib/jsoneditor.min.js' type='text/javascript'></script>
    <script src='${rc.contextPath}/static/swagger/lib/marked.js' type='text/javascript'></script>
    <script src='${rc.contextPath}/static/swagger/lib/swagger-oauth.js' type='text/javascript'></script>

    <script type="text/javascript">
        $(function () {
            var url = window.location.search.match(/url=([^&]+)/);
            if (url && url.length > 1) {
                url = decodeURIComponent(url[1]);
            } else {
                //url = "http://petstore.swagger.io/v2/swagger.json";
                url = "${rc.contextPath}/v2/api-docs";
            }

            hljs.configure({
                highlightSizeThreshold: 5000
            });

            // Pre load translate...
            if (window.SwaggerTranslator) {
                window.SwaggerTranslator.translate();
            }
            window.swaggerUi = new SwaggerUi({
                url: url,
                dom_id: "swagger-ui-container",
                supportedSubmitMethods: ['get', 'post', 'put', 'delete', 'patch'],
                onComplete: function (swaggerApi, swaggerUi) {
                    if (typeof initOAuth == "function") {
                        initOAuth({
                            clientId: "your-client-id",
                            clientSecret: "your-client-secret-if-required",
                            realm: "your-realms",
                            appName: "your-app-name",
                            scopeSeparator: " ",
                            additionalQueryStringParams: {}
                        });
                    }

                    if (window.SwaggerTranslator) {
                        window.SwaggerTranslator.translate();
                    }
                },
                onFailure: function (data) {
                    log("Unable to Load SwaggerUI");
                },
                docExpansion: "none",
                jsonEditor: false,
                defaultModelRendering: 'schema',
                showRequestHeaders: false
            });

            window.swaggerUi.load();

            function log() {
                if ('console' in window) {
                    console.log.apply(console, arguments);
                }
            }
        });
    </script>
</head>

<body class="swagger-section">
<div id='header'>
    <div class="swagger-ui-wrap">
        <a id="logo" href="http://swagger.io"><img class="logo__img" alt="swagger" height="30" width="30"
                                                   src="${rc.contextPath}/static/swagger/images/logo-img.png"/>
            <span class="logo__title">EagleTest API DOC</span>
        </a>
        <form id='api_selector'>
            <div class='input'><input placeholder="请输入API" id="input_baseUrl" name="baseUrl"
                                      type="text"/></div>
            <div id='auth_container'></div>
            <div class='input'><a id="explore" class="header__btn" href="#" data-sw-translate>搜索</a></div>
        </form>
    </div>
</div>

<div id="message-bar" class="swagger-ui-wrap" data-sw-translate>&nbsp;</div>
<div id="swagger-ui-container" class="swagger-ui-wrap"></div>
</body>
</html>
