<%--
  Created by IntelliJ IDEA.
  User: key
  Date: 2019/2/4
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="utf-8" %>

<jsp:include page="_partial/head.jsp">
    <jsp:param name="pageTitle" value="文章"/>
</jsp:include>

<%@include file="_partial/header.jsp"%>

<div class="container mt-4">
    <div class="row">
        <div class="col-12 col-md-8">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="/">主页</a></li>
                    <li class="breadcrumb-item active" aria-current="page">文章</li>
                </ol>
            </nav>

            <div class="p-3 mt-3">

            </div>

        </div>
        <div class="col-12 col-md-4">
            <%@include file="_partial/aside.jsp"%>
        </div>
    </div>
</div>

<%@include file="_partial/footer.jsp"%>
