<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>富文本编辑器</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body class="container" style="padding: 50px;">
    <#include "./header.ftl"/>
    <div id="main">
        ${module.detail}
    </div>
    <div id="footer">

    </div>
    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
    <script src="/js/jquery.3.2.1.js"></script>
    <!-- 包括所有已编译的插件 -->
    <script src="/js/bootstrap.min.js"></script>
</body>
</html>