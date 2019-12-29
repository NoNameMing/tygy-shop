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
                    <h4 class="header">子类别添加</h4>
                    <form action="addChild.category" method="post">
                        <table class="table table-striped sortable">
                            <tbody>
                                <tr>
                                    <th>类别名称</th>
                                    <td><input type="text" name="name" /></td>
                                </tr>
                                <tr>
                                    <th>类别描述</th>
                                    <td><textarea rows="8" cols="40" name="desc"></textarea></td>
                                </tr>
                                <tr>
                                    <th>所属类别</th>
                                    <td><input type="hidden" name="pid" value=${c.id } /><span>${c.name }</span></td>
                                </tr>
                                <tr>
                                    <td rowspan="2"><input type="submit" value="添加"
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
