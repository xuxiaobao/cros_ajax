<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header col-sm-4">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/index.html">
                <img src="images/logo.png" alt="">
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse col-sm-8" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav" style="padding: 50px;">
                <#if menus??>
                    <#if menus['0']??>
                        <#list menus['0']?split(",") as menu>
                            <#if menus[menu]??>
                                <li class="dropdown <#if menu?number = v>active</#if>">
                                    <a href="/col.html?col=${menu}" class="dropdown-toggle" data-toggle="dropdown">${moduleMap[menu]}<b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <#list (menus[menu])?split(",") as child>
                                            <li><a href="/col.html?col=${child}">${moduleMap[child]}</a></li>
                                        </#list>
                                    </ul>
                                </li>
                            <#elseif menu == '1'>
                                <li class="<#if menu?number = v>active</#if>"><a href="/index.html">首页</a></li>
                            <#else>
                                <li class="<#if menu?number = v>active</#if>"><a href="/col.html?col=${menu}">${moduleMap[menu]}</a></li>
                            </#if>
                        </#list>
                    </#if>
                </#if>
            </ul>
            <#--


            <ul class="nav navbar-nav" style="padding: 50px;">
                <li ><a href="index.html">首页</a></li>
                <li class="active"><a href="#">关于我们</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">全网营销<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">网站建设</a></li>
                        <li><a href="#">搜索引擎优化</a></li>
                        <li><a href="#">软文发布</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">微信运营<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">技术开发</a></li>
                        <li><a href="#">活动策划</a></li>
                        <li><a href="#">大号推广</a></li>
                    </ul>
                </li>
                <li><a href="#">媒体资源</a></li>
                <li><a href="#">客户案例</a></li>
                <li><a href="#">新闻资讯</a></li>
                <li><a href="#">联系我们</a></li>
            </ul>


             -->


        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>