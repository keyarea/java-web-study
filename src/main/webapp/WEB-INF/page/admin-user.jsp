<%--
  Created by IntelliJ IDEA.
  User: key
  Date: 2019/3/6
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/page/_partial/admin/head.jsp"/>
<body>


<jsp:include page="/WEB-INF/page/_partial/admin/header.jsp" />

<div class="container mt-4">
    <div class="row justify-content-md-center">
        <div class="col-12 col-lg-3 navbar-collapse collapse d-lg-block" id="adminNav">
            <jsp:include page="/WEB-INF/page/_partial/admin/aside.jsp" >
                <jsp:param name="navParam" value="user" />
            </jsp:include>
        </div>
        <div class="col-12 col-lg-9">
            <div class="card">
                <div class="card-header">
                   <strong>用户管理</strong>
                </div>
                <div class="card-body">

                    <div class="row justify-content-md-center">
                        <div class="col-12 col-lg-8">
                            <form class="form-inline">
                                <div class="form-group mb-2">
                                    <label for="keyword" class="sr-only">关键词</label>
                                    <input type="password" class="form-control" id="keyword" placeholder="关键词">
                                </div>
                                <button type="submit" class="btn btn-primary mb-2 ml-2">搜索</button>
                            </form>
                        </div>
                        <div class="col-12 col-lg-4 text-center">
                            <button type="button" class="btn btn-success btn-block">添加用户</button>
                        </div>
                    </div>

                    <div class="table-responsive-lg">
                        <table class="table table-hover table-striped">
                            <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">用户名</th>
                                <th scope="col">昵称</th>
                                <th scope="col">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th scope="row" class="align-middle">1</th>
                                <td class="align-middle">k</td>
                                <td class="align-middle">k</td>
                                <td class="align-middle">
                                    <button type="button" class="btn-info btn  btn-sm">编辑</button>
                                    <button type="button" class="btn btn-danger btn-sm">删除</button>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row" class="align-middle">2</th>
                                <td class="align-middle">k</td>
                                <td class="align-middle">k</td>
                                <td class="align-middle">
                                    <button type="button" class="btn-info btn  btn-sm">编辑</button>
                                    <button type="button" class="btn btn-danger btn-sm">删除</button>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row" class="align-middle">3</th>
                                <td class="align-middle">k</td>
                                <td class="align-middle">k</td>
                                <td class="align-middle">
                                    <button type="button" class="btn-info btn  btn-sm">编辑</button>
                                    <button type="button" class="btn btn-danger btn-sm">删除</button>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



<%@include file="/WEB-INF/page/_partial/script.jsp"%>
</body>
</html>
