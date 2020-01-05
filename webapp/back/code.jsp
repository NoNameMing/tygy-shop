<%--
  Created by IntelliJ IDEA.
  User: wangxiaoming
  Date: 2020/1/4
  Time: 10:59 上午
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
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
        <script type="text/javascript">
            $(function(){
                $("#img").click(function(){
                    $(this).attr("src","code.code?"+new Date()+Math.random());
                });
            });
        </script>
    </head>
    <body>
        <img id="img" alt="" src="code.code">
    </body>
</html>