<%--
  Created by IntelliJ IDEA.
  User: key
  Date: 2019/3/6
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/page/_partial/admin/head.jsp"/>
<body>


<jsp:include page="/WEB-INF/page/_partial/admin/header.jsp" />

<div class="container mt-4">
    <div class="row justify-content-md-center">
        <div class="col-12 col-lg-3 navbar-collapse collapse d-lg-block" id="adminNav">
            <jsp:include page="/WEB-INF/page/_partial/admin/aside.jsp" >
                <jsp:param name="navParam" value="article" />
            </jsp:include>
        </div>
        <div class="col-12 col-lg-9">
            <div class="card">
                <div class="card-header">
                    <strong>文章管理</strong>
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
                            <button type="button" class="btn btn-success btn-block" data-id="" data-toggle="modal" data-target="#editCategoryModal">添加文章</button>
                        </div>
                    </div>

                    <div class="table-responsive-lg">
                        <table class="table table-hover table-striped">
                            <thead>
                            <tr>
                                <th scope="col" nowrap>#</th>
                                <th scope="col" nowrap>文章标题</th>
                                <th scope="col" nowrap>文章分类</th>
                                <th scope="col" nowrap>文章标签</th>
                                <th scope="col" nowrap>文章作者</th>
                                <th scope="col" nowrap>文章管理</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:choose>
                                <c:when test="${empty articles}">
                                    <tr>
                                        <td  colspan="6" class="text-center">暂无数据</td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach  items="${articles}" var="article">
                                        <tr>
                                            <th nowrap class="align-middle">${article.id}</th>
                                            <td nowrap class="align-middle">${article.title}</td>
                                            <td nowrap class="align-middle"></td>
                                            <td nowrap class="align-middle"></td>
                                            <td nowrap class="align-middle"></td>
                                            <td nowrap class="align-middle">
                                                <button type="button" class="btn-info btn  btn-sm" >编辑</button>
                                                <button type="button" class="btn btn-danger btn-sm" >删除</button>
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



<%@include file="/WEB-INF/page/_partial/script.jsp"%>
</body>
</html>
