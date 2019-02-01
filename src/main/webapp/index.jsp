<%--
  Created by IntelliJ IDEA.
  User: key
  Date: 2019/1/31
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="utf-8" %>

<jsp:include page="WEB-INF/page/_partial/head.jsp">
    <jsp:param name="pageTitle" value="首页"/>
</jsp:include>

<%@include file="./WEB-INF/page/_partial/header.jsp"%>

<div id="content" class="container">
    <div class="row">
        <div class="col-12 col-md-8">
           <%-- <ul class="nav nav-tabs my-4 mr-3 font-weight-bold">
                <li class="nav-item">
                    <a class="nav-link active" href="#">推荐文章</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">热门文章</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">最新文章</a>
                </li>
            </ul>

            <div class="list-group">
                <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
                    <div class="d-flex w-100 justify-content-between">
                        <h5 class="mb-1">List group item heading</h5>
                        <small>3 days ago</small>
                    </div>
                    <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
                    <small>Donec id elit non mi porta.</small>
                </a>
                <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
                    <div class="d-flex w-100 justify-content-between">
                        <h5 class="mb-1">List group item heading</h5>
                        <small class="text-muted">3 days ago</small>
                    </div>
                    <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
                    <small class="text-muted">Donec id elit non mi porta.</small>
                </a>
                <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
                    <div class="d-flex w-100 justify-content-between">
                        <h5 class="mb-1">List group item heading</h5>
                        <small class="text-muted">3 days ago</small>
                    </div>
                    <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
                    <small class="text-muted">Donec id elit non mi porta.</small>
                </a>
            </div>--%>

               <div class="card text-center my-4">
                   <div class="card-header">
                       <ul class="nav nav-tabs card-header-tabs">
                           <li class="nav-item">
                               <a class="nav-link active" href="#">Active</a>
                           </li>
                           <li class="nav-item">
                               <a class="nav-link" href="#">Link</a>
                           </li>
                           <li class="nav-item">
                               <a class="nav-link disabled" href="#">Disabled</a>
                           </li>
                       </ul>
                   </div>
                   <div class="card-body">
                       <h5 class="card-title">Special title treatment</h5>
                       <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                       <a href="#" class="btn btn-primary">Go somewhere</a>
                   </div>
               </div>
        </div>
        <div class="col-12 col-md-4 p-3">
            <%@include file="WEB-INF/page/_partial/aside.jsp"%>
        </div>
    </div>
</div>

<%@include file="./WEB-INF/page/_partial/footer.jsp"%>
