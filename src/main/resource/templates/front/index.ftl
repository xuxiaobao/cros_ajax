<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>网站模版</title>

    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="horizontal-menu-page">

<section>

    <#--导航栏-->
    <#include "./header.ftl" />

    <!--body wrapper start-->
    <div class="wrapper text-center">
        ${module['detail']!''}
    </div>
    <!--body wrapper end-->

    <!--footer section start-->
    <#include "./footer.ftl" />
    <!--footer section end-->

</section>

</body>
</html>
