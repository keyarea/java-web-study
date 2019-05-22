<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2019-04-09
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/page/_partial/admin/head.jsp"/>


<body>

<div class="main">
    <header id="header">
        <nav class="navbar navbar-expand-lg navbar-light bg-light p-3">
            <div class="container font-weight-bold">
                <a class="navbar-brand" href="/">
                    <img src="/img/fc.png" height="30" alt="">
                </a>
                <button type="button" data-toggle="modal" data-target="#logoutModal" class="btn btn-danger" >
                    注销
                </button>
            </div>
        </nav>
    </header>

    <div class="container mt-4">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="/admin">管理中心</a></li>
                <li class="breadcrumb-item"><a href="/admin/article">文章管理</a></li>
                <li class="breadcrumb-item active" aria-current="page">
                    <c:choose>
                        <c:when test="${article == null}">
                            撰写新的文章
                        </c:when>
                        <c:otherwise>
                            ${article.title}
                        </c:otherwise>
                    </c:choose>
                </li>
            </ol>
        </nav>



        <div class="row">
            <div class="col-12 col-lg-9">
                <div class="card mb-4">
                    <div class="card-body">
                        <div class="input-group input-group my-4">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="inputGroup-sizing-lg">文章标题</span>
                            </div>
                            <input type="text" name="title" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" value="${article.title}">
                        </div>


                        <link rel="stylesheet" href="/editor.md-1.5.0/css/editormd.min.css" />
                        <div id="editormd" class="mt-4">
                            <textarea style="display:none;" name="content">${article.content}</textarea>
                        </div>

                    </div>
                </div>

            </div>
            <div class="col-12 col-lg-3">
                <div class="card mb-4">
                    <div class="card-header">
                        发布
                    </div>
                    <div class="card-body">
                        <button class="btn btn-danger btn-block">移到回收站</button>
                        <button class="btn btn-success btn-block" id="saveArticle">保存</button>
                    </div>
                </div>
                <div class="card mb-4">
                    <div class="card-header">
                        文章标签
                    </div>
                    <div class="card-body" id="articleTag" >
                        <c:choose>
                            <c:when test="empty tags">
                                <p>暂无标签</p>
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="tag" items="${tags}">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" name="tag" value="${tag.id}" id="tag-${tag.id}">
                                        <label class="form-check-label" for="tag-${tag.id}">
                                                ${tag.name}
                                        </label>
                                    </div>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>

                    </div>
                </div>
                <div class="card mb-4">
                    <div class="card-header">
                        文章分类
                    </div>
                    <div class="card-body" id="articleCategory">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="category" id="noArticleCategory" value="" checked>
                            <label class="form-check-label" for="noArticleCategory">
                                未分类
                            </label>
                        </div>
                        <c:choose>
                            <c:when test="empty categories">
                                <p>暂无分类</p>
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="category" items="${categories}">
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="category" id="category-${category.id}" value="${category.id}">
                                        <label class="form-check-label" for="category-${category.id}">
                                                ${category.name}
                                        </label>
                                    </div>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>


                    </div>
                </div>
            </div>
        </div>


    </div>
</div>


<div class="modal fade" id="savedArticleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">提示框</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>文章保存成功！</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>


<%@include file="/WEB-INF/page/_partial/footer.jsp"%>




<%@include file="/WEB-INF/page/_partial/script.jsp"%>
<script src="/editor.md-1.5.0/editormd.min.js"></script>
<script src="/js/articleDetail.js"></script>
<%@include file="/WEB-INF/page/_partial/admin/script.jsp"%>

</body>
</html>
