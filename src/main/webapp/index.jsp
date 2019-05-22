<%--
  Created by IntelliJ IDEA.
  User: key
  Date: 2019/1/31
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="utf-8" %>

<!doctype html>
<html lang="en">
<jsp:include page="/WEB-INF/page/_partial/head.jsp">
    <jsp:param name="pageTitle" value="首页"/>
</jsp:include>
<body>

<%@include file="/WEB-INF/page/_partial/header.jsp"%>

<div id="content" class="container mt-4">
    <div class="row">
        <div class="col-12 col-md-8">

               <div class="card text-center">
                   <div class="card-header">
                       <ul class="nav nav-tabs card-header-tabs">
                           <li class="nav-item">
                               <a class="nav-link active btn" id="recommendArticle" href="#12">推荐文章</a>
                           </li>
                           <li class="nav-item">
                               <a class="nav-link btn" id="popularArticle" href="#122">热门文章</a>
                           </li>
                           <li class="nav-item">
                               <a class="nav-link btn" id="newArticle" href="#123">最新文章</a>
                           </li>
                       </ul>
                   </div>
                   <div class="card-body">
                       <h5 class="card-title">推荐文章</h5>
                       <p class="card-text">推荐您阅读的好文章</p>

                       <ul class="list-group list-group-flush text-left">
                           <a href="/article" class="list-group-item list-group-item-action flex-column align-items-start">
                               <div class="d-flex w-100 justify-content-between">
                                   <h5 class="mb-1">你好，世界</h5>
                                   <small>1小时之前</small>
                               </div>
                               <p class="mb-1">世界是一个大家庭</p>
                               <small>阅读量：1000       赞：1000 </small>
                           </a>
                           <a href="/article" class="list-group-item list-group-item-action flex-column align-items-start">
                               <div class="d-flex w-100 justify-content-between">
                                   <h5 class="mb-1">List group item heading</h5>
                                   <small class="text-muted">3天之前</small>
                               </div>
                               <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
                               <small class="text-muted">Donec id elit non mi porta.</small>
                           </a>
                           <a href="/article" class="list-group-item list-group-item-action flex-column align-items-start">
                               <div class="d-flex w-100 justify-content-between">
                                   <h5 class="mb-1">List group item heading</h5>
                                   <small class="text-muted">1周之前</small>
                               </div>
                               <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
                               <small class="text-muted">Donec id elit non mi porta.</small>
                           </a>
                       </ul>

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
</body>
</html>
