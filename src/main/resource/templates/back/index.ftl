<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>管理系统</title>

    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="sticky-header">

<section>

    <#include "./header.ftl"/>
    <!-- main content start-->
    <div class="main-content" >

            <!-- header section start-->
            <div class="header-section">

                <!--toggle button start-->
                <a class="toggle-btn"><i class="fa fa-bars"></i></a>
                <!--toggle button end-->

                <!--notification menu start -->
                <div class="menu-right">
                    <ul class="notification-menu">
                        <li>
                            <a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                <img src="/images/photos/user-avatar.png" alt="" />
                                John Doe
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu dropdown-menu-usermenu pull-right">
                                <li><a href="#"><i class="fa fa-sign-out"></i> Log Out</a></li>
                            </ul>
                        </li>

                    </ul>
                </div>
                <!--notification menu end -->

            </div>
            <!-- header section end-->

        <!-- page heading start-->
        <div class="page-heading">
            模块管理
        </div>
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">

            <table class="table table-striped">
                <caption>一级模块列表</caption>
                <thead>
                    <tr>
                        <th>序号</th>
                        <th>名称</th>
                        <th>二级模块</th>
                    </tr>
                </thead>
                <tbody>
                <#if list??>
                    <#list list as item>
                    <tr>
                        <td>${item_index+1}</td>
                        <td>${item['title']}</td>
                        <td><a href="/back/second.html?col=${item['id']}">查看</a></td>
                    </tr>
                    </#list>
                </#if>
                </tbody>
            </table>

        </div>
        <!--body wrapper end-->

        <#include "./footer.ftl" />


    </div>
    <!-- main content end-->
</section>

</body>
</html>
