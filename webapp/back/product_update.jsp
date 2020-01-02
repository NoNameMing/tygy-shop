<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>电商平台后台管理</title>
    <link rel="stylesheet" href="css/bootstrap.css" />
    <link rel="stylesheet" href="css/bootstrap-responsive.css" />
    <link rel="stylesheet" href="css/styles.css" />
    <link rel="stylesheet" href="css/toastr.css" />
    <link rel="stylesheet" href="css/fullcalendar.css" />
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/jquery.knob.js"></script>
    <script src="js/jquery.sparkline.min.js"></script>
    <script src="js/toastr.js"></script>
    <script src="js/jquery.tablesorter.min.js"></script>
    <script src="js/jquery.peity.min.js"></script>
    <script src="js/fullcalendar.min.js"></script>
    <script src="js/gcal.js"></script>
    <script src="js/setup.js"></script>
    <script type="text/javascript">

        $(function () {
            // 异步访问
            $.ajax({
                url:"findThree.category",
                dataType:"json",
                success:function(categories){
                    for (i=0;i<categories.length;i++) {
                        var c  = categories[i];
                        $("<option value='"+c.id+"'>" + c.name + "</option>").appendTo("#findThree");
                    }
                }
            });
            // 修改价格
            $("#normalprice").blur(function () {
                $("#memberprice").val(Math.round($(this).val()*.8*100.0)/100.0) ;
            });
        });
    </script>
</head>
<body>
<%@include file="header.jsp"%>
<div class="page">
    <div class="page-container">
        <div class="container">
            <div class="row">
                <div class="span12">
                    <h4 class="header">修改商品</h4>
                    <form action="update.product" method="post">
                        <table class="table table-striped sortable">
                            <thead>
                            <tr>
                                <td>商品名称</td>
                                <td>
                                    <input type="text" name="name" value="${p.name}" />
                                    <input type="hidden" name="id" value="${p.id}" />
                                </td>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th>商品描述</th>
                                <td><textarea rows="8" cols="40" name="desc" >${p.desc }</textarea></td>
                            </tr>
                            <tr>
                                <td>普通价格</td>
                                <td><input id="normalprice" type="text" name="normalprice" value="${p.normalprice }"/></td>
                            </tr>
                            <tr>
                                <td>会员价格</td>
                                <td><input id="memberprice" type="text" name="memberprice" value="${p.memberprice }" readonly="readonly"/></td>
                            </tr>
                            <tr>
                                <td>所属类别</td>
                                <td>
                                    <select name="categoryid" id="findThree">
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td rowspan="2"><input type="submit" value="修改"
                                                       class="btn btn-primary" /></td>
                            </tr>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>
<script src="js/d3-setup.js"></script>
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
