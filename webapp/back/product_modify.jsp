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
</head>
<%@include file="header.jsp"%>
<body>
<div class="page">
    <div class="page-container">
        <div class="container">
            <div class="row">
                <div class="span12">
                    <h4 class="header">商品类别描述修改</h4>
                    <form action="update.product" method="post">
                        <table class="table table-striped sortable">
                            <tbody>
                            <tr>
                                <th>商品新名称</th>
                                <td>
                                    <input type="text" name="name" placeholder="请输入商品新名称"/>
                                    <input type="hidden" name="id" value=${p.id } />
                                </td>
                            </tr>
                            <tr>
                                <th>商品新描述</th>
                                <td><textarea rows="8" cols="40" name="desc" placeholder="请输入商品新描述"></textarea></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <input class="btn btn-success" type="submit" value="添加" />&nbsp;&nbsp;&nbsp;
                                    <input class="btn btn-danger" type="reset" value="重置">
                                </td>
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
