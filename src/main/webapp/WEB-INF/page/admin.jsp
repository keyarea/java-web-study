<%--
  Created by IntelliJ IDEA.
  User: key
  Date: 2019/2/4
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>


<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/page/_partial/admin/head.jsp"/>
<body>


<jsp:include page="/WEB-INF/page/_partial/admin/header.jsp" />

<div class="container mt-4">
    <div class="row justify-content-md-center">
        <div class="col-12 col-lg-3 navbar-collapse collapse d-lg-block" id="adminNav">
            <jsp:include page="/WEB-INF/page/_partial/admin/aside.jsp" >
                <jsp:param name="navParam" value="index" />
            </jsp:include>
        </div>
        <div class="col-12 col-lg-9">
            <div class="card">
                <div class="card-header">
                    系统概况
                </div>
                <div class="card-body">
                    数据库数据统计：
                </div>
            </div>
        </div>
    </div>
</div>


<%@include file="/WEB-INF/page/_partial/footer.jsp"%>

<%@include file="/WEB-INF/page/_partial/script.jsp"%>
<%@include file="/WEB-INF/page/_partial/admin/script.jsp"%>
</body>
</html>


