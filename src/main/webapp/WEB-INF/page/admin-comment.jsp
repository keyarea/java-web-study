<%--
  Created by IntelliJ IDEA.
  User: key
  Date: 2019/3/6
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/page/_partial/admin/head.jsp"/>
<body>


<jsp:include page="/WEB-INF/page/_partial/admin/header.jsp" />

<div class="container my-4">
    <div class="row justify-content-md-center">
        <div class="col-12 col-lg-3 navbar-collapse collapse d-lg-block" id="adminNav">
            <jsp:include page="/WEB-INF/page/_partial/admin/aside.jsp" >
                <jsp:param name="navParam" value="comment" />
            </jsp:include>
        </div>
        <div class="col-12 col-lg-9">
            <h1>评论</h1>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/page/_partial/footer.jsp"%>


<%@include file="/WEB-INF/page/_partial/script.jsp"%>
</body>
</html>
