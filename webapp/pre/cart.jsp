<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        $(document).ready(function () {
            $(".inline").colorbox({
                inline: true,
                width: "50%"
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
    <link rel="stylesheet" href="css/ddsmoothmenu.css"/>
    <link rel="stylesheet" href="css/elastislide.css"/>
    <link rel="stylesheet" href="css/home_flexslider.css"/>

    <link rel="stylesheet" href="css/light_box.css"/>
    <script src="js/html5.js"></script>


</head>
<body>
<div class="mainContainer sixteen container">
    <!--Header Block-->
    <%@include file="header.jsp" %>
</div>
<!--Content Block-->
<section class="content-wrapper">
    <div class="content-container container">
        <div class="col-1-layout">
            <c:forEach items="${items}" var="ci">
                <form class="shopping-cart-table">
                    <li>
                        <div class="img-box">
                            <img src="images/cart_img.png" title="" alt=""/>
                        </div>
                        <a class="edit-btn" href="#" title="编辑">${ci.product.name}</a>
                    </li>
                    <li>
                        <div class="remove-item-btn">
                            <a href="delete.cartitem?id=${ci.id}" title="Remove">
                                <img src="images/delete_item_btn.png" title="删除" alt="删除"/>
                            </a>
                        </div>
                        <div class="add-to-cart-box">
                                <span class="qty-box"> <label>购买数量：</label>
                                    <span>${ci.pcount }</span>
                                    <input type="hidden" value="${ci.id}" id="id" name="id"/>
                                    <a>
                                        <a onclick="update(${ci.id}, document.getElementById('${ci.id}qty').value)">确认数量</a>
                                        <script>
                                            function update(id, cnt) {
                                                window.location.href = "update.cartitem?id=" + id + "&" + "cnt=" + cnt;
                                            }
                                        </script>
                                    </a>
                                </span>
                        </div>
                        <form>
                            <input class="inputclass" id="${ci.id}inputDesc" type="button" value="-">
                            <input type="text" id="${ci.id}qty" name="qty" value="${ci.pcount}"/>
                            <input class="inputclass" id="${ci.id}inputAdd" type="button" value="+">
                        </form>
                        <script type="text/javascript">
                            $(function number() {
                                document.getElementById("${ci.id}inputDesc").onclick = function () {
                                    if (this.form.qty.value > 1) {
                                        this.form.qty.value--;
                                    };
                                };

                                document.getElementById("${ci.id}inputAdd").onclick = function () {
                                    this.form.qty.value++;
                                };
                            });
                        </script>
                        <div class="pro-price">¥${ci.memberprice }</div>
                    </li>
                </form>
            </c:forEach>
        </div>
        <div class="news-letter-container">
            <div class="free-shipping-block">
                <h1>平价果蔬平台</h1>
                <p>为你选择最好的！</p>
            </div>
<%--            <div class="news-letter-block">--%>
<%--                <input class="submit-btn" type="submit" value="Submit" title="Submit" />--%>
<%--            </div>--%>
            <div class="news-letter-block">
                <a href="insert.order?uid=${user.id}&addr=${user.addr}" id="${ci.id}" >
                    下单
                </a>
            </div>
        </div>
    </div>
</section>
<!--页脚开始-->
<section class="footer-wrapper">
    <%@include file="footer.jsp" %>
</section>
<!--页脚结束-->
</body>
</html>