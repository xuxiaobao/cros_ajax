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
    <link href="/dist/summernote.css" rel="stylesheet" type="text/css"/>

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
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                <#if list??>
                    <#list list as item>
                    <tr>
                        <td>${item_index+1}</td>
                        <td>${item['title']}</td>
                        <td><a href="/index.html?col=${item['id']}" target="_blank">查看</a></td>
                        <td><a onclick="editFun(${item['id']})">编辑</a></td>
                    </tr>
                    </#list>
                </#if>
                </tbody>
            </table>

            <!-- 模态框（Modal） -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form role="form" id="editForm">
                            <div class="hidden">
                                <input type="text" class="form-control" name="id" id="id">
                            </div>
                            <div class="form-group">
                                <label for="title">标题</label>
                                <input type="text" class="form-control" name="title" id="title" placeholder="请输入标题">
                            </div>
                            <div class="form-group">
                                <label for="title">模块详情</label>
                                <div id="editor">

                                </div>
                            </div>
                            <button type="submit" class="btn btn-default">提交</button>
                        </form>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div>
            <!-- /.modal -->
        </div>
        <!--body wrapper end-->

        <#include "./footer.ftl" />


    </div>
    <!-- main content end-->
</section>
<script>
    $().ready(function () {
        $("#editor").summernote({
            height:400,                 // set editor height
            callbacks : {
                onImageUpload: function(files,editor, $editable) {      //onImageUpload代表图片上传事件，默认将图片变为base64的那个事件
                    var data=new FormData();        //html5提供的formdata对象，将图片加载为数据的容器
                    data.append('file',files[0]);  //加载选中的第一张图片，并给这图片数据标记一个'image_up'的名称
                    //调用上传图片
                    $.ajax({
                        url: '/upload',     //上传图片请求的路径
                        method: 'POST',            //方法
                        data:data,                 //数据
                        processData: false,        //告诉jQuery不要加工数据
                        contentType: false,        //<code class="javascript comments"> 告诉jQuery,在request head里不要设置Content-Type
                        success: function(data) {  //图片上传成功之后，对返回来的数据要做的事情
                            $("#editor").summernote('insertImage',data.url);       //调用内部api——insertImage以路径的形式插入图片到文本编辑区
                        }
                    });
                }
            }
            //上传图片回调结束
        });


        $('#editform').validate({
            rules: {
                title: {
                    required: true,
                    maxlength: 5
                }
            },
            messages: {
                title: {
                    required: "标题不能为空",
                    maxlength: "最长5个字符"
                }
            },
            submitHandler : function () {
                var formData = $('#editForm').serialize();
                var detail = $('#editor').code();
                var param = formData+"&detail="+detail;
                $.ajax({
                    url:'/module/edit',
                    type:'post',
                    contentType: "application/json",
                    dataType:'json',
                    data:param,
                    success:function (data) {
                        myAlert(data.data);
                    }
                })
            }
        });
    });
    function editFun(id) {
        $('#id').val(id);
        $.ajax({
            url: '/module/col',
            type: 'get',
            dataType: 'json',
            data: {'id':id},
            success: function (resp) {
                if (resp.code == '0') {
                    $('#title').val(resp.data.title);
                    $('#editor').html(resp.data.title);
                    $('#myModal').modal('show');
                } else {
                    myAlert(resp.data);
                }
            }
        })
    }
</script>
</body>
</html>
