<%--
  User: key
  Date: 2019/1/23
  Time: 15:39
  首页
--%>

<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<jsp:include page="/WEB-INF/page/_partial/head.jsp" flush="true">
    <jsp:param name="pageTitle" value="首页" />
    <jsp:param name="pageStyle" value="css/index.css" />
</jsp:include>
<jsp:include page="WEB-INF/page/_partial/header.jsp" flush="true" />
<h1>首页</h1>
<%@include file="/WEB-INF/page/_partial/footer.jsp"%>
<%@include file="/WEB-INF/page/_partial/script.jsp"%>
