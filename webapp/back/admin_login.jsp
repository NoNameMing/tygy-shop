<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
    <meta name="description" content="description of your site" />
    <meta name="author" content="author of the site" />
    <title>电商平台后台管理登录页面</title>
    <link rel="stylesheet" href="css/bootstrap.css" />
    <link rel="stylesheet" href="css/bootstrap-responsive.css" />

    <link rel="stylesheet" href="css/styles.css" />
    <link rel="stylesheet" href="css/toastr.css" />
    <link rel="stylesheet" href="css/fullcalendar.css" />
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/jquery.knob.js"></script>
    <!-- <script src="http://d3js.org/d3.v3.min.js"></script> -->
    <script src="js/jquery.sparkline.min.js"></script>
    <script src="js/toastr.js"></script>
    <script src="js/jquery.tablesorter.min.js"></script>
    <script src="js/jquery.peity.min.js"></script>
    <script src="js/fullcalendar.min.js"></script>
    <script src="js/gcal.js"></script>
    <script src="js/setup.js"></script>
    <style type="text/css">
        .err_msg{
            color: red;
        }
    </style>
    <script type="text/javascript">
        $(function(){
            $("#code").click(function(){
                $("#img").attr("src","code.code?"+new Date()+Math.random());
            });
        });
    </script>

</head>
<body>
<div id="in-nav">
    <div class="container">
        <div class="row">
            <div class="span12">
                <ul class="pull-right">
                    <li><a href="<%=request.getContextPath() %>/pre/index.product">前台首页</a></li>
                    <li><a href="admin_login.jsp">登录</a></li>
                </ul>
                <h4>
                    <a id="logo" href="index.jsp"> 电商平台<strong>管理员登录</strong></a>
                </h4>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="span6 offset2">
            <div class="login">
                <form class="form-horizontal" action="login.admin" method="post">
                    <div class="control-group">
                        <div class="controls">
                            <h4>登录</h4>
                        </div>
                    </div>
                    <div class="control-group">
                        <label for="inputEmail" class="control-label">用户名 </label>
                        <div class="controls">
                            <input id="inputEmail" name="name" type="text"
                                   placeholder="请输入用户名" />
                        </div>
                    </div>
                    <div class="control-group">
                        <label for="inputPassword" class="control-label">密码 </label>
                        <div class="controls">
                            <input id="inputPassword" name="pwd" type="password"
                                   placeholder="请输入密码" />
                            <br />
                            <span class="err_msg">${error_msg }</span>
                        </div>
                    </div>
                    <div class="control-group">
                        <label for="inputPassword" class="control-label">验证码 </label>
                        <div class="controls">
                            <input id="inputvalidate" style="width:100px" name="inputcode" type="text"
                                   placeholder="请输验证码" />
                            <a href="javascript:;" id="code"><img src="code.code" id="img">看不清，换一个</a><br />
                            <span class="err_msg">${code_msg }</span>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <input type="submit" class="btn" value="登录">
                            <input type="button" class="btn" value="注册" onclick="window.location.href='add_admin.html'">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    protocol = window.location.protocol === 'http:' ? 'ws://' : 'wss://';
    address = protocol + window.location.host + window.location.pathname
        + '/ws';
    socket = new WebSocket(address);
    socket.onmessage = function(msg) {
        msg.data == 'reload' && window.location.reload()
    }
</script>
</html>