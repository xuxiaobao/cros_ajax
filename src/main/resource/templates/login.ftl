<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>后台登陆</title>

    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="login-body">

<div class="container">

    <form class="form-signin" id="login">
        <div class="form-signin-heading text-center">
            <h1 class="sign-title">登陆</h1>
            <img src="/images/login-logo.png" alt=""/>
        </div>
        <div class="login-wrap" id="login">
            <input type="text" class="form-control" name="username" placeholder="用户名" autofocus>
            <input type="password" class="form-control" name="password" placeholder="密码">

            <button class="btn btn-lg btn-login btn-block" type="submit">
                <i class="fa fa-check"></i>
            </button>
        </div>

    </form>

</div>




<div class='modal fade' id='myModal' tabindex='-1' role='dialog' aria-labelledby='myModalLabel' aria-hidden='true'>
    <div class='modal-dialog'>
        <div class='modal-content'>
            <div class='modal-header'>
                <button type='button' class='close' data-dismiss='modal' aria-hidden='true'>×</button>
            </div>
            <div class='modal-body'>按下 ESC 按钮退出。</div>
            <div class='modal-footer'>
                <button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>
            </div>
        </div>
    </div>
</div>


<!-- Placed js at the end of the document so the pages load faster -->

<!-- Placed js at the end of the document so the pages load faster -->
<script src="/js/jquery-1.10.2.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/modernizr.min.js"></script>
<script type="text/javascript" src="/js/jquery.validate.min.js"></script>
<script src="/js/validation-init.js"></script>
<script src="/js/common.js"></script>
<script>
    $().ready(function () {
        $('#login').validate({
            rules:{
                username: {
                    required: true
                },
                password: {
                    required: true
                }
            },
            messages: {
                username: {
                    required: "请输入用户名",
                },
                password: {
                    required: "请输入密码"
                }
            },
            submitHandler: function(form) {
                var formData = $('#login').serialize();
                $.ajax({
                    async:true,
                    url: "/api/login",
                    type: 'post',
                    dataType: 'json',
                    data:formData,
                    success: function (resp) {
                        if (resp.code == '0') {
                            window.location.href = "/back/home.html";
                        } else {
                            myAlert(resp.data);
                        }
                    }
                })
            }
        });
    })
</script>
</body>
</html>
