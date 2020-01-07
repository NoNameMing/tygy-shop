<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
        isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>电商平台用户登录</title>

    <!--js-->
    <script src="js/jquery-1.8.2.min.js"></script>
    <script src="js/common.js"></script>
    <script src="js/jquery.easing.1.3.js"></script>
    <script src="js/ddsmoothmenu.js"></script>
    <script src="js/jquery.flexslider.js"></script>
    <script src="js/jquery.elastislide.js"></script>
    <script src="js/jquery.jcarousel.min.js"></script>
    <script src="js/jquery.accordion.js"></script>
    <script src="js/light_box.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $(".inline").colorbox({
                inline : true,
                width : "50%"
            });
        });
    </script>
    <!--end js-->

    <!-- Mobile Specific Metas ================================================== -->
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">

    <!-- CSS -->

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/orange.css">
    <link rel="stylesheet" href="css/skeleton.css">
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/ddsmoothmenu.css" />
    <link rel="stylesheet" href="css/elastislide.css" />
    <link rel="stylesheet" href="css/home_flexslider.css" />

    <link rel="stylesheet" href="css/light_box.css" />
    <script src="js/html5.js"></script>


</head>
<body>
<div class="mainContainer sixteen container">
    <!--Header Block-->
    <%@include file="header.jsp"%>
    <!--Content Block-->
    <section class="content-wrapper">
        <div class="content-container container">
            <div class="main">
                <h1 class="page-title">登录|注册</h1>
                <div class="account-login">
                    <div class="col-1 new-users">
                        <div class="content">
                            <h2>新用户</h2>
                            <p>By creating an account with our store, you will be able
                                to move through the checkout process faster, store multiple
                                shipping addresses, view and track your orders in your account
                                and more.</p>
                        </div>
                        <div class="buttons-set">
                            <a class="orange-btn" title="Create an Account"
                               href="user_register.jsp"><span><span>新建用户</span></span></a>
                            <div class="clear"></div>
                        </div>
                    </div>
                    <div class="col-2 registered-users">
                        <div class="content">
                            <h2>登录</h2>
                            <p>如果您是我们的会员，请登录</p>
                            <form class="form-horizontal" action="login.user" method="post">
                                <li><label class="required" for="email">用户名<em>*</em>
                                </label>
                                    <div class="input-box">
                                        <input type="text" title="用户名" name="name"
                                               class="input-text required-entry validate-email" value="" />
                                        <span class="error_msg">${error_msg }</span>
                                    </div>
                                    <div class="clear"></div></li>
                                <li><label class="required" for="pass">密码<em>*</em></label>
                                    <div class="input-box">
                                        <input type="password" title="密码" name="pwd"
                                               class="input-text required-entry validate-password" />
                                    </div>
                                    <div class="clear"></div></li>
                                <li><label for="inputPassword" class="control-label">验证码
                                    <em>*</em>
                                </label>
                                    <div class="controls">
                                        <input id="inputvalidate" style="width: 100px" name="inputcode"
                                               name="inputcode" type="text" placeholder="请输验证码" /> <a
                                            href="javascript:;" id="code"><img src="<%=path %>/back/code.code"
                                                                               id="img">看不清，换一个</a><br>
                                        <script type="text/javascript">
                                            $(function(){
                                                $("#code").click(function(){
                                                    $("#img").attr("src","<%=path %>/back/code.code?"+new Date()+Math.random());
                                                });
                                            });

                                        </script>
                                        <span class="error_msg">${code_msg }</span>
                                    </div></li>
                                <div class="buttons-set">
                                    <a class="f-left" href="#">忘记密码?</a>
                                    <input class="orange-btn" title="登录" type="submit" value="登录"/>
                                    </input>
                                    <div class="clear"></div>
                                </div>
                            </form>
                            <p class="required">* 必填项</p>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
            <div class="clearfix"></div>
            <div class="news-letter-container">
                <div class="free-shipping-block">
                    <h1>ENJOY FREE SHIPPING</h1>
                    <p>on all orders as our holiday gift for you!</p>
                </div>
                <div class="news-letter-block">
                    <h2>SIGN UP FOR OUR NEWSLETTER</h2>
                    <input type="text" value="Enter email address" title="" /> <input
                        type="submit" value="Submit" title="Submit" />
                </div>
            </div>
        </div>
    </section>
</div>
<!--页脚开始-->
<section class="footer-wrapper">
    <%@include file="footer.jsp"%>
</section>
<!--页脚结束-->
</body>
</html>