<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>

<html>
<head>
    <meta charset="utf-8">
    <title>电商平台首页</title>
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

    <!-- CSS ================================================== -->

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
            <div class="col-1-layout">
                <c:forEach items="${items}" var="ci">
                    <ul class="shopping-cart-table">
                        <li>
                            <div class="img-box">
                                <img src="images/cart_img.png" title="" alt="" />
                            </div> <a class="edit-btn" href="#" title="编辑">编辑</a>
                        </li>
                        <li>
                            <div class="remove-item-btn">
                                <a href="#" title="Remove"><img
                                        src="images/delete_item_btn.png" title="删除" alt="删除" /></a>
                            </div>
                            <div class="pro-name">${ci.product.name}</div>
                            <div class="pro-qty">
                                <input type="text" value="1" />
                            </div>
                            <div class="pro-price">¥${ci.memberprice }</div>
                        </li>
                    </ul>
                </c:forEach>
            </div>
        </div>
    </section>
<!--页脚开始-->
<section class="footer-wrapper">
    <%@include file="footer.jsp"%>
</section>
<!--页脚结束-->
</body>
</html>