<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2019-03-02
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="utf-8" %>

<!doctype html>
<html lang="en">
<jsp:include page="/WEB-INF/page/_partial/head.jsp">
    <jsp:param name="pageTitle" value="文章"/>
</jsp:include>
<body>
<%@include file="/WEB-INF/page/_partial/header.jsp"%>

<div class="container mt-4">
    <div class="row">
        <div class="col-12 col-md-8">
           <h1>评论</h1>

        </div>
        <div class="col-12 col-md-4">
            <%@include file="/WEB-INF/page/_partial/aside.jsp"%>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/page/_partial/footer.jsp"%>
<%@include file="/WEB-INF/page/_partial/script.jsp"%>
</body>
</html>
