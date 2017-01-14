<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mxia
  Date: 2017/1/12
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Dashboard</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <%@include file="../navbar/css.jsp"%>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="../navbar/head.jsp"%>
    <!-- Left side column. contains the logo and sidebar -->
    <%@include file="../navbar/aside.jsp"%>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <div class="content">
        <div class="box box-solid box-primary">
            <div class="box-header with-border">
                <h3 class="box-title">账户管理</h3>
                <div class="box-tools pull-right">
                    <a href="/user/add" class="btn"><i class="fa fa-plus"></i></a>
                </div>
            </div>
            <div class="box-body">
                <c:if test="${not empty message}">
                    <div class="alert alert-success">
                            ${message}
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    </div>
                </c:if>
                    <table class="table">
                        <thead>
                        <tr>
                            <th>姓名</th>
                            <th>角色</th>
                            <th>#</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${page.items}" var="user">
                            <tr>
                                <td>${user.username}</td>
                                <td>${user.roleName}</td>
                                <td>
                                    <a href="/user/${user.id}/edit" >编辑</a>/
                                    <a href="/user/${user.id}/del" >删除</a>

                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
            </div>
            <!-- /.box-body -->
            <div class="box-footer">
                <ul style="margin:5px 0px" id="pagination" class="pagination pull-right"></ul>
            </div>
            <!-- box-footer -->
        </div>
            <!-- /.box -->
        </div>

    </div>
    <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 2.3.8
        </div>
        <strong>Copyright &copy; 2014-2016 <a href="http://almsaeedstudio.com">Mixaiay</a>.</strong> All rights
        reserved.
    </footer>
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->
<!-- jQuery 2.2.3 -->
<script src="/static/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="/static/dist/js/app.min.js"></script>
<script src="/static/plugins/jquery.twbsPagination.min.js"></script>
<script>
    $(function () {
//分页插件的使用
        $("#pagination").twbsPagination({
            totalPages:${page.totalPage},
            visiblePages:5,
            href:"/user?p={{number}}",
            first:"首页",
            prev:"上一页",
            next:"下一页",
            last:"末页"
        });
    });
</script>

</body>
</html>


