<%--
  Created by IntelliJ IDEA.
  User: key
  Date: 2019/2/4
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>管理面板-方寸</title>
    <%@include file="_partial/css.jsp"%>
</head>
<body>


<header id="header">
    <nav class="navbar navbar-expand-lg navbar-light bg-light p-3">
        <div class="container font-weight-bold">
            <a class="navbar-brand" href="/">
                <img src="img/fc.png" height="30" alt="">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#adminNav" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <button type="button" data-toggle="modal" data-target="#logoutModal" class="btn btn-danger d-lg-block d-none" >
                注销
            </button>
        </div>
    </nav>
</header>

<div class="container mt-4">
    <div class="row">
        <div class="col-12 col-lg-3 navbar-collapse collapse d-lg-block" id="adminNav">
            <div class="card">
                <div class="card-header">
                    管理面板
                </div>
                <div class="admin-nav list-group">
                    <a href="/admin" class="list-group-item list-group-item-action">控制面板</a>
                    <a href="/admin/user" class=" list-group-item">用户管理</a>
                    <a href="/admin/article" class="list-group-item">文章管理</a>
                    <a href="/admin/category" class="list-group-item">分类管理</a>
                    <a href="/admin/tag" class="list-group-item">标签管理</a>
                    <a href="/admin/comment" class="list-group-item">评论管理</a>
                    <a href="/admin/notice" class="list-group-item">广播管理</a>
                    <button  data-toggle="modal" data-target="#logoutModal"type="button" class="btn btn-danger bg-danger d-lg-none d-block list-group-item">
                        注销
                    </button>
                </div>
            </div>
        </div>
        <div class="col-12 col-md-9">
            <jsp:include page="${contentPage}" />
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">注销登录</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                是否退出该账户？退出之后将不能对网站进行管理。
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="logout-btn">确认</button>
            </div>
        </div>
    </div>
</div>


<%@include file="_partial/script.jsp"%>
</body>
</html>


