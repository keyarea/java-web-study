<%--
  Created by IntelliJ IDEA.
  User: key
  Date: 2019/3/6
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                                    <input type="text" class="form-control" id="keyword" placeholder="关键词">
                                </div>
                                <button type="submit" class="btn btn-primary mb-2 ml-2">搜索</button>
                            </form>
                        </div>
                        <div class="col-12 col-lg-4 text-center">
                            <button type="button" class="btn btn-success btn-block" data-id="" data-toggle="modal" data-target="#editUserModal">添加用户</button>
                        </div>
                    </div>

                    <div class="table-responsive-lg">
                        <table class="table table-hover table-striped">
                            <thead>
                            <tr>
                                <th scope="col" nowrap>#</th>
                                <th scope="col" nowrap>用户名</th>
                                <th scope="col" nowrap>昵称</th>
                                <th scope="col" nowrap>文章数</th>
                                <th scope="col" nowrap>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:choose>
                                <c:when test="${empty users}">
                                    <tr>
                                        <td colspan="5" class="text-center">暂无数据</td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach var="user" items="${users}" >
                                        <tr>
                                            <th nowrap scope="row" class="align-middle">${user.id}</th>
                                            <td nowrap class="align-middle">${user.name}</td>
                                            <td nowrap class="align-middle">${user.nickname}</td>
                                            <td nowrap class="align-middle">${fn:length(user.articles)}</td>
                                            <td nowrap class="align-middle">
                                                <button type="button" class="btn-info btn  btn-sm" data-id="${user.id}" data-toggle="modal" data-target="#editUserModal">编辑</button>
                                                <button type="button" class="btn btn-danger btn-sm" data-id="${user.id}" data-toggle="modal" data-target="#deleteUserModal">删除</button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%--编辑用户模态框--%>
<div class="modal fade" id="editUserModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editUserModalLabel">用户管理</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="user-name" class="col-form-label">用户名</label>
                        <input type="text" class="form-control" id="user-name">
                    </div>
                    <div class="form-group">
                        <label for="nickname-text" class="col-form-label">用户昵称</label>
                        <input type="text" class="form-control" id="nickname-text">
                    </div>
                    <div class="form-group">
                        <label for="password-text" class="col-form-label">用户密码</label>
                        <input type="password" class="form-control" id="password-text">
                    </div>
                    <div class="form-group">
                        <label for="verify-password" class="col-form-label">重复用户密码</label>
                        <input type="password" class="form-control" id="verify-password">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-success" id="saveUser">保存</button>
            </div>
        </div>
    </div>
</div>

<%--删除用户模态框--%>
<div class="modal fade" tabindex="-1" role="dialog" id="deleteUserModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">删除用户</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p id="deleteUserModalBody"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" id="deleteUser">确认</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>





<%@include file="/WEB-INF/page/_partial/script.jsp"%>
</body>
</html>
