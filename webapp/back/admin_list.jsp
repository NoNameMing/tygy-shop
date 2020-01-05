<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
    <meta name="description" content="description of your site" />
    <meta name="author" content="author of the site" />
    <title>电商平台后台首页</title>
    <link rel="stylesheet" href="css/bootstrap.css" />
    <link rel="stylesheet" href="css/bootstrap-responsive.css" />
    <link rel="stylesheet" href="css/styles.css" />
    <link rel="stylesheet" href="css/toastr.css" />
    <link rel="stylesheet" href="css/fullcalendar.css" />
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/jquery.knob.js"></script>
    <script src="http://d3js.org/d3.v3.min.js"></script>
    <script src="js/jquery.sparkline.min.js"></script>
    <script src="js/toastr.js"></script>
    <script src="js/jquery.tablesorter.min.js"></script>
    <script src="js/jquery.peity.min.js"></script>
    <script src="js/fullcalendar.min.js"></script>
    <script src="js/gcal.js"></script>
    <script src="js/setup.js"></script>
    <style type="text/css">
        .err_admin_msg{
            color: red;
        }
    </style>
</head>
<body>
<%@include file="header.jsp"%>
<div class="page">
    <div class="page-container">
        <div class="container">
            <div class="row">
                <div class="span12">
                    <a href="#newUserModal" data-toggle="modal" class="btn pull-right">添加管理员</a>
                    <h4 class="header">管理员列表</h4>
                    <span class="err_admin_msg">${err_admin_msg }</span>
                    <table class="table table-striped sortable">
                        <thead>
                        <tr>
                            <th>管理员ID</th>
                            <th>管理员用户名</th>
                            <th>密码</th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${admins }" var="admin">
                        <tr>
                            <td>${admin.id}</td>
                            <td>${admin.name}</td>
                            <td>${admin.password}</td>
                            <td>
                                <div class="btn-group">
                                    <button class="btn">操作</button>
                                    <button data-toggle="dropdown" class="btn dropdown-toggle">
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="javascript:;" onclick="resetPassword(${admin.id})">重置密码</a>
                                            <a href="update_admin.html">修改</a>
                                            <a href="javascript:;" onclick="deleteAdmin(${admin.id})">删除</a></li>
                                    </ul>
                                    <script type="text/javascript">
                                        function deleteAdmin(id) {
                                            if(confirm("delete?")) {
                                                if(confirm("real?")) {
                                                    window.location.href = "delete.admin?id=" + id;
                                                }
                                            }
                                        }
                                        function resetPassword(id) {
                                            if(confirm("sure to change?")) {
                                                window.location.href = "resetPassword.admin?id=" + id;
                                            }
                                        }
                                    </script>
                                </div>
                            </td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="pagination pagination-centered">
                        <ul>
                            <li class="disabled"><a href="#">&laquo;</a></li>
                            <li class="active"><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li><a href="#">&raquo;</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div id="newUserModal" class="modal hide fade">
            <div class="modal-header">
                <button type="button" data-dismiss="modal" aria-hidden="true"
                        class="close">&times;</button>
                <h3>添加管理员</h3>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" action="addAdmin.admin" method="post">
                    <div class="control-group">
                        <label for="inputEmail"  class="control-label">管理员账号</label>
                        <div class="controls">
                            <input id="inputEmail" name="name" type="text" placeholder="请输入管理员账号" />
                        </div>
                    </div>
                    <div class="control-group">
                        <label for="inputCurrentPassword"  class="control-label">管理员密码
                        </label>
                        <div class="controls">
                            <input id="inputCurrentPassword" type="password"
                                   placeholder="请输入密码" name="password"/>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <a href="#" data-dismiss="modal" class="btn">关闭</a><input
                            type="submit" class="btn btn-primary"
                            value="添加" />
                    </div>
                </form>
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