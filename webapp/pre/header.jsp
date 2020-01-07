<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
%>

<script type="text/javascript">

    $(function () {
        // 异步访问
        $.ajax({
            url:"findThree.category",
            dataType:"json",
            success:function(categories){
                for (i=0;i<categories.length;i++) {
                    var c  = categories[i];
                    $("<li>" + c.name + "</li>").appendTo("#findThree");
                }
            }
        });
    });

</script>

<script>
    function logout(){
        if(confirm('确认要注销么？')){
            window.location.href="logout.user";
        }
    }
</script>

<div class="header-wrapper">
    <header class="container">
        <div class="head-right">
            <ul class="top-nav">
                <li class=""><a href="404_error.html" title="我的账户">我的账户</a></li>
                <li class="my-wishlist"><a href="404_error.html" title="我的收藏">我的收藏</a></li>
<%--                <li class="contact-us"><a href="contact_us.html" title="联系我们">联系我们</a></li>--%>
                <li class="contact"><a href="javascript:void(0);" onclick="logout()">注销</a></li>
                <li class="checkout"><a href="findByUserId.cartitem?userid=${user.id }" title="我的购物车">我的购物车</a></li>
                <li class="log-in"><a href="user_login.jsp" title="登录">登录</a></li>
                <li class="log-in"><a href="user_register.jsp" title="登录">注册</a></li>
                <li class="log-in"><a href="<%=path%>/back/logout.admin" title="后台首页">后台首页</a></li>
            </ul>
            <ul class="currencyBox">
                <li id="header_currancy" class="currency"><a
                        class="mainCurrency" href="#">币种: RMB</a>
                    <div id="currancyBox" class="currency_detial">
                        <a href="#">￥</a> <a href="#"></a> <a href="#">$</a>
                    </div></li>
            </ul>
            <section class="header-bottom">
                <div class="cart-block">
                    <ul>
                        <li>(2)</li>
                        <li><a href="cart.html" title="Cart"><img title="Item"
                                                                  alt="Item" src="images/item_icon.png" /></a></li>
                        <li>Item</li>
                    </ul>
                    <div id="minicart" class="remain_cart" style="display: none;">
                        <p class="empty">购物车中有(2)件商品</p>
                        <ol>
                            <li>
                                <div class="img-block">
                                    <img src="images/small_img.png" title="" alt="" />
                                </div>
                                <div class="detail-block">
                                    <h4>
                                        <a href="#" title="Htc Mobile 1120">Htc Mobile 1120</a>
                                    </h4>
                                    <p>
                                        <strong>1</strong> x $900.00
                                    </p>
                                    <a href="#" title="Details">Details</a>
                                </div>
                                <div class="edit-delete-block">
                                    <a href="#" title="编辑"><img src="images/edit_icon.png"
                                                                alt="编辑" title="编辑" /></a> <a href="#" title="删除"><img
                                        src="images/delete_item_btn.png" alt="删除" title="删除" /></a>
                                </div>
                            </li>
                            <li>
                                <div class="img-block">
                                    <img src="images/small_img.png" title="" alt="" />
                                </div>
                                <div class="detail-block">
                                    <h4>
                                        <a href="#" title="Htc Mobile 1120">Htc Mobile 1120</a>
                                    </h4>
                                    <p>
                                        <strong>1</strong> x $900.00
                                    </p>
                                    <a href="#" title="Details">Details</a>
                                </div>
                                <div class="edit-delete-block">
                                    <a href="#" title="编辑"><img src="images/edit_icon.png"
                                                                alt="编辑" title="编辑" /></a> <a href="#" title="删除"><img
                                        src="images/delete_item_btn.png" alt="删除" title="删除" /></a>
                                </div>
                            </li>
                            <li>
                                <div class="total-block">
                                    总计：<span>￥1,900.00</span>
                                </div> <a href="cart.html" title="付款" class="orange-btn">付款</a>
                                <div class="clear"></div>
                            </li>
                        </ol>
                    </div>
                </div>
                <div class="search-block">
                    <input type="text" placeholder="搜索商品" /> <input type="submit"
                                                                    value="搜索" title="搜索商品" />
                </div>
            </section>
        </div>
        <h1 class="logo">
            <a href="index.jsp" title="Logo"> <img title="Logo"
                                                    alt="Logo" src="images/logo.jpg" />
            </a>
        </h1>
        <nav id="smoothmenu1" class="ddsmoothmenu mainMenu">
            <ul id="nav">
                <li class="active"><a href="index.product" title="Home">首页</a></li>
                <li class=""><a href="category.html" title="商品类别">商品类别</a>
                    <ul id="findThree">
<%--                        <li><a href="category.html">女装</a></li>--%>
<%--                        <li><a href="category.html">男装</a></li>--%>
<%--                        <li><a href="category.html">饰品</a></li>--%>
<%--                        <li><a href="category.html">移动设备</a>--%>
<%--                            <ul>--%>
<%--                                <li><a href="category.html">二级类别</a></li>--%>
<%--                                <li><a href="category.html">二级类别</a></li>--%>
<%--                                <li><a href="category.html">二级类别</a></li>--%>
<%--                                <li><a href="category.html">二级类别</a></li>--%>
<%--                                <li><a href="category.html">二级类别</a></li>--%>
<%--                                <li><a href="category.html">二级类别</a></li>--%>
<%--                            </ul></li>--%>
<%--                        <li><a href="category.html">鞋</a></li>--%>
<%--                        <li><a href="category.html">其他</a></li>--%>
                    </ul></li>
                <li class=""><a href="blog.html" title="博客">博客</a></li>
                <li class=""><a href="faq.html" title="FAQ">FAQ</a></li>
                <li class=""><a href="about_us.html" title="关于我们">关于我们</a></li>
                <li class=""><a href="404_error.html" title="Pages">Pages</a></li>
                <li class=""><a href="contact_us.html" title="联系我们">联系我们</a></li>
            </ul>
        </nav>

        <div class="mobMenu">
            <h1>
                <span>菜单</span> <a class="menuBox highlight"
                                   href="javascript:void(0);">ccc</a> <span class="clearfix"></span>
            </h1>
            <div id="menuInnner" style="display: none;">
                <ul class="accordion">
                    <li class="active"><a href="detail.product" title="主页">主页</a></li>
                    <li class="parent"><a href="category.html" title="类别">类别</a>
                        <ul>
                            <li><a href="category.html">女装</a></li>
                            <li><a href="category.html">男装</a></li>
                            <li><a href="category.html">饰品</a></li>
                            <li><a href="category.html">移动设备</a>
                                <ul>
                                    <li><a href="category.html">二级类别</a></li>
                                    <li><a href="category.html">二级类别</a></li>
                                    <li><a href="category.html">二级类别</a></li>
                                    <li><a href="category.html">二级类别</a></li>
                                    <li><a href="category.html">二级类别</a></li>
                                    <li><a href="category.html">二级类别</a></li>
                                </ul></li>
                            <li><a href="category.html">鞋</a></li>
                            <li><a href="category.html">其他</a></li>
                        </ul></li>
                    <li class=""><a href="blog.html" title="博客">博客</a></li>
                    <li class=""><a href="faq.html" title="Faq">Faq</a></li>
                    <li class=""><a href="about_us.html" title="关于我们">关于我们</a></li>
                    <li class=""><a href="404_error.html" title="Pages">Pages</a></li>
                    <li class=""><a href="contact_us.html" title="联系我们">联系我们</a></li>
                    <span class="clearfix"></span>
                </ul>

            </div>
        </div>

    </header>
</div>