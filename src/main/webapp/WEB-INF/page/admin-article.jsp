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

<div class="container my-4">
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
                            <a href="/admin/articleDetail" role="button" aria-pressed="true"  class="btn btn-success btn-block">添加文章</a>
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
                                <th scope="col" nowrap>文章状态</th>
                                <th scope="col" nowrap>文章管理</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:choose>
                                <c:when test="${empty articles}">
                                    <tr>
                                        <td  colspan="7" class="text-center">暂无数据</td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach  items="${articles}" var="article">
                                        <tr>
                                            <th nowrap class="align-middle">${article.id}</th>
                                            <td nowrap class="align-middle">${article.title}</td>
                                            <td nowrap class="align-middle">${article.category.name}</td>
                                            <td nowrap class="align-middle">
                                                <c:forEach var="tag" items="${article.tags}">
                                                    <span class="badge badge-pill badge-info">${tag.name}</span>
                                                </c:forEach>
                                            </td>
                                            <td nowrap class="align-middle">${article.author.nickname}</td>
                                            <td nowrap class="align-middle">
                                                已发布
                                            </td>
                                            <td nowrap class="align-middle">
                                                <a href="/admin/articleDetail?id=${article.id}" role="button" aria-pressed="true" class="btn-info btn btn-sm" >编辑</a>
                                                <button type="button" class="btn btn-danger btn-sm" data-id="${article.id}" data-toggle="modal" data-target="#deleteArticleModal">删除</button>
                                                <button type="button" class="btn btn-secondary btn-sm">预览</button>
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

<%--删除文章模态框--%>
<div class="modal fade" tabindex="-1" role="dialog" id="deleteArticleModal">
    <div class="modal-dialog modal-dialog-centered " role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">删除文章</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p id="deleteArticleModalBody"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" id="deleteArticle">确认</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/page/_partial/footer.jsp"%>


<%@include file="/WEB-INF/page/_partial/script.jsp"%>
</body>
</html>
