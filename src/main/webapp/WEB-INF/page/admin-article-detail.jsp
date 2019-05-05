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


<jsp:include page="/WEB-INF/page/_partial/admin/header.jsp" />

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


    <div class="card mb-4">
        <div class="card-body">
            <div class="input-group input-group my-4">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-lg">文章标题</span>
                </div>
                <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" value="${article.title}">
            </div>




            <link rel="stylesheet" href="/editor.md-1.5.0/css/editormd.min.css" />
            <div id="editormd" class="mt-4">
                <textarea style="display:none;">${article.content}</textarea>
            </div>
            <div class="btn-group text-right" role="group" aria-label="Basic example">
                <button type="button" class="btn btn-info">发表</button>
                <button type="button" class="btn btn-success">保存</button>
            </div>

        </div>
    </div>

 </div>


<%@include file="/WEB-INF/page/_partial/footer.jsp"%>




<%@include file="/WEB-INF/page/_partial/script.jsp"%>
<script src="/jquery.min.js"></script>
<script src="/zepto.min.js"></script>
<script src="/editor.md-1.5.0/editormd.min.js"></script>
<script type="text/javascript">
    $(function() {
        var editor = editormd("editormd", {
            path : "/editor.md-1.5.0/lib/", // Autoload modules mode, codemirror, marked... dependents libs path,
            width: "100%",
            //autoHeight: true,
            height: "640",
            toolbarAutoFixed: true,
            codeFold : true,
            //searchReplace : true,
            //saveHTMLToTextarea : true,                // 保存HTML到Textarea
            htmlDecode : "style,script,iframe",       // 开启HTML标签解析，为了安全性，默认不开启
            emoji : true,
            taskList : true,
            tex : true,
            tocm : true,         // Using [TOCM]
            //autoLoadModules : false,
            previewCodeHighlight : true,
            flowChart : true,
            sequenceDiagram : true
        });

        /*
        // or
        var editor = editormd({
            id   : "editormd",
            path : "../lib/"
        });
        */
    });
</script>
</body>
</html>
