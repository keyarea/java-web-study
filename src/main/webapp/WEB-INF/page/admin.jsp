<%--
  Created by IntelliJ IDEA.
  User: key
  Date: 2019/2/4
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <button type="button" class="btn btn-danger d-lg-block d-none">
                注销
            </button>
        </div>
    </nav>
</header>

<div class="container mt-4">
    <div class="row">
        <div class="col-12 col-lg-3 navbar-collapse collapse d-lg-block" id="adminNav">
            <div class="admin-nav list-group navbar-nav">
                <a  class=" list-group-item bg-light"><strong>管理面板</strong></a>
                <a href="#" class="list-group-item list-group-item-action">控制面板</a>
                <a href="#" class=" list-group-item">用户管理</a>
                <a href="#" class="list-group-item">文章管理</a>
                <a href="#" class="list-group-item">分类管理</a>
                <a href="#" class="list-group-item">标签管理</a>
                <a href="#" class="list-group-item">评论管理</a>
                <a href="#" class="list-group-item">广播管理</a>
                <button type="button" class="btn btn-danger bg-danger d-lg-none d-block list-group-item">
                    注销
                </button>
            </div>
        </div>
        <div class="col-12 col-md-9">
            <h1>hello world</h1>
        </div>
    </div>
</div>


<%@include file="_partial/script.jsp"%>
</body>
</html>


