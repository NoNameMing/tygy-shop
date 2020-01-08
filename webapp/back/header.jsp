<%@ page import="com.neuedu.shop.pojo.Admin" %>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    Admin admin = (Admin) session.getAttribute("admin");
    if (admin == null) {
        // 挑战到登陆页面去登陆
        response.sendRedirect("admin_login.jsp");
        return;
    }
    String path = request.getContextPath();
%>
<!-- header -->

<script>
    function logout(){
        if(confirm('确认要注销么？')){
            if(confirm('注销成功！')){
                window.location.href="logout.admin";
            }else{
                alert('请三思');
            }
        }
    }
</script>

<div id="in-nav">
    <div class="container">
        <div class="row">
            <div class="span12">
                <ul class="pull-right">
                    <li><a href="<%=path%>/pre/user_register.jsp" target="_blank">前台用户注册</a></li>
                    <li><a href="<%=path%>/pre/index.product" target="_blank">前台首页</a></li>
<%--                    <li><a href="#">链接2</a></li>--%>
                    <li><a href="admin_login.jsp">登录</a></li>
                    <li><a href="javascript:void(0);" onclick="logout()">注销</a></li>
                    <li>
                        <c:choose>
                            <c:when test="${admin != null}">
                                <span>欢迎${admin.name }</span>
                            </c:when>
                            <c:otherwise>
                                <span>请您登陆</span>
                            </c:otherwise>
                        </c:choose>
                    </li>
                    <%--                    <li><a href="regist.html">管理员注册</a></li>--%>
                </ul>
                <h4>
                    <a id="logo" href="index.jsp"> 电商平台后台<strong>管理</strong>
                    </a>
                </h4>
            </div>
        </div>
    </div>

</div>
<div id="in-sub-nav">
    <div class="container">
        <div class="row">
            <div class="span12">
                <ul>
                    <li><a href="index.jsp" class="active"><i class="batch home"></i><br />主页</a></li>
                    <li><span class="label label-important pull-right">08</span><a
                            href="findAll.admin"><i class="batch stream"></i><br />管理员列表</a></li>
                    <li><a href="findAll.user"><i class="batch users"></i><br />用户列表</a></li>
                    <li><a href="findAll.category"><i class="batch forms"></i><br />类别列表</a></li>
                    <li><a href="findAll.product"><i class="batch quill"></i><br />商品列表</a></li>
                    <li><span class="label label-important pull-right">04</span><a
                            href="findAll.order"><i class="batch plane"></i><br />订单列表</a></li>
                    <li><a href=""><i class="batch calendar"></i><br />其它扩展功能</a></li>
                    <li><a href=""><i class="batch settings"></i><br />系统设置</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>