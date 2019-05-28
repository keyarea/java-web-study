<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: key
  Date: 2019/1/31
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="utf-8" %>

<html lang="en">
<jsp:include page="/WEB-INF/page/_partial/head.jsp">
    <jsp:param name="pageTitle" value="首页"/>
</jsp:include>
<link rel="stylesheet" href="css/index.css">
<body>

<%@include file="/WEB-INF/page/_partial/header.jsp"%>

<div id="content" class="container mt-4">
    <div class="row">
        <div class="col-12 col-md-8">

               <div class="card text-center">
                   <div class="card-header">
                       <ul class="nav nav-tabs card-header-tabs">
                           <li class="nav-item">
                               <a class="nav-link active btn" id="recommendArticle" >最新文章</a>
                           </li>
                           <li class="nav-item">
                               <a class="nav-link btn" id="popularArticle" >热门文章</a>
                           </li>
                           <li class="nav-item">
                               <a class="nav-link btn" id="newArticle" >推荐文章</a>
                           </li>
                       </ul>
                   </div>
                   <div class="card-body">
                       <div class="loading">
                           <span></span>
                           <span></span>
                           <span></span>
                           <span></span>
                           <span></span>
                       </div>
<%--                       <h5 class="card-title">最新文章</h5>--%>
<%--                       <p class="card-text">最近发表的好文章</p>--%>
<%--
                       <ul class="list-group list-group-flush text-left">
                           <c:choose>
                               <c:when test="empty articles">
                                   <p>当前文章为空!</p>
                               </c:when>
                               <c:otherwise>
                                   <c:forEach var="article" items="${articles}">
                                       <a href="/article" class="list-group-item list-group-item-action flex-column align-items-start">
                                           <div class="d-flex w-100 justify-content-between">
                                               <h5 class="mb-1">${article.title}</h5>
                                               <small>
                                                   <fmt:formatDate value="${article.createTime}" pattern="yyyy-MM-dd HH:mm"  />
                                               </small>
                                           </div>
                                           <p class="mb-1">
                                               ${fn:substring(article.content, 0 , 100)}
                                           </p>
                                           <small></small>
                                       </a>

                                   </c:forEach>
                               </c:otherwise>
                           </c:choose>
                       </ul>--%>

                       <nav aria-label="Page navigation example" class="mt-3">
                           <ul class="pagination justify-content-center">
                               <li class="page-item">
                                   <a class="page-link" href="#" aria-label="Previous">
                                       <span aria-hidden="true">&laquo;</span>
                                       <span class="sr-only">Previous</span>
                                   </a>
                               </li>
                               <li class="page-item"><a class="page-link" href="#">1</a></li>
                               <li class="page-item"><a class="page-link" href="#">2</a></li>
                               <li class="page-item"><a class="page-link" href="#">3</a></li>
                               <li class="page-item">
                                   <a class="page-link" href="#" aria-label="Next">
                                       <span aria-hidden="true">&raquo;</span>
                                       <span class="sr-only">Next</span>
                                   </a>
                               </li>
                           </ul>
                       </nav>
                   </div>
               </div>
        </div>
        <div class="col-12 col-md-4">
            <%@include file="WEB-INF/page/_partial/aside.jsp"%>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/page/_partial/footer.jsp"%>
<%@include file="/WEB-INF/page/_partial/script.jsp"%>
<script  type="text/javascript" src="js/index.js"></script>
</body>
</html>
