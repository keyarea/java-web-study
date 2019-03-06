<%--
  Created by IntelliJ IDEA.
  User: key
  Date: 2019/3/6
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<div class="card">
    <div class="card-header">
        <strong>管理面板</strong>
    </div>
    <div class="admin-nav list-group">
        <a href="/admin" class="list-group-item ${param.navParam eq "index" ? "list-group-item-action" : ""}">系统概况</a>
        <a href="/admin/user" class=" list-group-item ${param.navParam eq "user" ? "list-group-item-action" : ""}">用户管理</a>
        <a href="/admin/article" class="list-group-item ${param.navParam eq "article" ? "list-group-item-action" : ""}">文章管理</a>
        <a href="/admin/category" class="list-group-item ${param.navParam eq "category" ? "list-group-item-action" : ""}">分类管理</a>
        <a href="/admin/tag" class="list-group-item ${param.navParam eq "tag" ? "list-group-item-action" : ""}">标签管理</a>
        <a href="/admin/comment" class="list-group-item ${param.navParam eq "comment" ? "list-group-item-action" : ""}">评论管理</a>
        <a href="/admin/notice" class="list-group-item ${param.navParam eq "notice" ? "list-group-item-action" : ""}">广播管理</a>
        <button  data-toggle="modal" data-target="#logoutModal" type="button" class="btn btn-danger bg-danger d-lg-none d-block list-group-item">
            注销
        </button>
    </div>
</div>