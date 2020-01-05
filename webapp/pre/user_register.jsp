<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>电商平台用户注册页面</title>

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

    <script src="js/city.json.js"></script>
    <script src="js/Popt.js"></script>
    <script src="js/citySet.js"></script>

    <%-- 送货地址的样式 --%>
    <style type="text/css">
        * {
            word-wrap: break-word;
        }
        .wrap {
            width: 100px;
            height: 30px;
            margin: 200px auto;
            border: 0;
            position: relative;
        }

        .input {
            position: relative;
            top: 0;
            left: 0;
            width: 180px;
            margin: 0;
            padding-left: 5px;
            height: 30px;
            line-height: 30px;
            font-size: 12px;
            border: 1px solid #c9cacb;
        }

        ._citys {
            width: 450px;
            display: inline-block;
            border: 2px solid #eee;
            padding: 5px;
            position: relative;
            background-color: #fefefe;
        }

        ._citys span {
            color: #FE6732;
            height: 15px;
            width: 15px;
            line-height: 15px;
            text-align: center;
            border-radius: 3px;
            position: absolute;
            right: 10px;
            top: 10px;
            border: 1px solid #FE6732;
            cursor: pointer;
        }

        ._citys0 {
            width: 95%;
            height: 34px;
            line-height: 34px;
            display: inline-block;
            border-bottom: 2px solid #FE6732;
            padding: 0px 5px;
            font-size: 14px;
            font-weight: bold;
            margin-left: 6px;
            color: #444;

        }

        ._citys0 li {
            display: inline-block;
            line-height: 34px;
            font-size: 15px;
            color: #888;
            width: 80px;
            text-align: center;
            cursor: pointer;
        }

        ._citys1 {
            width: 100%;
            display: inline-block;
            padding: 10px 0;
        }

        ._citys1 a {
            width: 83px;
            height: 35px;
            display: inline-block;
            background-color: #f5f5f5;
            color: #666;
            margin-left: 6px;
            margin-top: 3px;
            line-height: 35px;
            text-align: center;
            cursor: pointer;
            font-size: 12px;
            border-radius: 5px;
            overflow: hidden;
        }

        ._citys1 a:hover {
            color: #fff;
            background-color: #FE6732;
        }

        .AreaS {
            background-color: #FE6732 !important;
            color: #fff !important;
        }
        #addr2{
            font-family: "微软雅黑";
        }
    </style>

    <script type="text/javascript">
        $(document).ready(function() {
            $(".inline").colorbox({
                inline : true,
                width : "50%"
            });
        });
    </script>
    <!--end js-->

    <!-- CSS ================================================== -->
    <style type="text/css">
        * {
            font-family: "微软雅黑";
        }
    </style>
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
    </div>
    <!--Content Block-->
    <section class="content-wrapper">
        <div class="content-container container">
            <div class="main">
                <form action="register.user" method="post">
                    <h1 class="page-title">新建用户</h1>
                    <div class="fieldset">
                        <h2 class="legend">个人信息</h2>
                        <ul class="form-list">
                            <li class="fields">
                                <div class="customer-name">
                                    <div class="input-box name-firstname">
                                        <label for="firstname">用户名<em>*</em></label> <input
                                            type="text" class="required-entry input-text" title="用户名"
                                            placeholder="请输入用户名" name="name" id="firstname" required="required">
                                    </div>
                                    <div class="clear"></div>

                                </div>
                            </li>
                            <li class="fields">
                                <div class="customer-name">
                                    <div class="input-box name-firstname">
                                        <label for="firstname">电话<em>*</em></label> <input
                                            type="text" class="required-entry input-text" title="电话"
                                            placeholder="请输入电话号码" name="phone" id="firstname" required="required">
                                    </div>
                                    <div class="clear"></div>

                                </div>
                            </li>
                            <li>
                                <div class="input-box">
                                    <label class="required" for="email_address">送货地址<em>*</em>
                                    </label>
<%--                                    <textarea rows="10"--%>
<%--                                              class="input-text validate-email required-entry" cols="35"--%>
<%--                                              name="addr" id="email_address" required="required"></textarea>--%>
                                    <input class="input" id="city" type="text" placeholder="请选择"
                                           autocomplete="off" readonly="true" />
                                    <textarea class="input-text validate-email required-entry"
                                            rows="10" cols="35" name="addr2"
                                            id="addr2" placeholder="详细地址" required="required"></textarea>
                                </div>
                                <script type="text/javascript">
                                    $("#button").click(function(){
                                        alert($("#city").val() + "/" + $("#addr2").val());
                                    });
                                    $("#city").click(function(e) {
                                        SelCity(this, e);
                                    });
                                </script>
                                <div class="clear"></div>
                            </li>
                            <li class="control">
                                <div class="input-box">
                                    <input type="checkbox" class="checkbox" id="is_subscribed"
                                           value="1" title="Sign Up for Newsletter" name="is_subscribed">
                                    <label for="is_subscribed">Sign Up for Newsletter</label>
                                </div>
                                <div class="clear"></div>
                            </li>
                        </ul>
                        <h2 class="legend">注册登录信息</h2>
                        <ul class="form-list">
                            <li class="fields">
                                <div class="customer-name">
                                    <div class="input-box name-firstname">
                                        <label for="pwd1">密码<em>*</em></label> <input
                                            type="password" class="required-entry input-text" title="密码"
                                            placeholder="请输入密码" name="password" id="pwd1" required="required">
                                    </div>
                                    <div class="input-box name-lastname">
                                        <label for="pwd2">确认密码<em>*</em></label> <input
                                            type="password" class="required-entry input-text"
                                            title="确认密码" placeholder="请再次输入密码" id="pwd2" required="required">
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            </li>
                        </ul>
                        <div class="buttons-set">
                            <p class="required">* 必填项</p>
                            <a href="account_login.html" title="返回" class="f-left">&laquo;
                                返回</a> <input type="submit" value="注册" class="orange-btn" />
                            <div class="clear"></div>
                        </div>
                    </div>
                </form>
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
                        type="submit" value="注册" title="注册" />
                </div>
            </div>
        </div>
    </section>
</div>
<!--Footer Block-->
<section class="footer-wrapper">
    <%@include file="footer.jsp"%>
</section>
</body>
</html>