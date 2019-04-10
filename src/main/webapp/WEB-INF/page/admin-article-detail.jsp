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
    <div class="row justify-content-md-center">
        <div class="col-12 col-lg-3 navbar-collapse collapse d-lg-block" id="adminNav">
            <jsp:include page="/WEB-INF/page/_partial/admin/aside.jsp" >
                <jsp:param name="navParam" value="article" />
            </jsp:include>
        </div>
        <div class="col-12 col-lg-9">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="/">首页</a></li>
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

            <nav>
                <div class="nav nav-tabs" id="nav-tab" role="tablist">
                    <a class="nav-item nav-link active" id="nav-basic-tab" data-toggle="tab" href="#nav-basic" role="tab" aria-controls="nav-basic" aria-selected="true">常规</a>
                    <a class="nav-item nav-link" id="nav-more-tab" data-toggle="tab" href="#nav-more" role="tab" aria-controls="nav-more" aria-selected="false">高级</a>
                </div>
            </nav>
            <div class="tab-content" id="nav-tabContent">
                <div class="tab-pane fade show active text-right" id="nav-basic" role="tabpanel" aria-labelledby="nav-basic-tab">




                    <div class="input-group input-group my-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="inputGroup-sizing-lg">文章标题</span>
                        </div>
                        <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" value="${article.title}">
                    </div>

                    <div class="btn-group text-right" role="group" aria-label="Basic example">
                        <button type="button" class="btn btn-danger">删除</button>
                        <button type="button" class="btn btn-info">发表</button>
                        <button type="button" class="btn btn-success">保存</button>
                    </div>

                    <link rel="stylesheet" href="/editor.md-1.5.0/css/editormd.min.css" />
                    <div id="editormd" class="mt-4">
                        <textarea style="display:none;">${article.content}</textarea>
                    </div>

                </div>
                <div class="tab-pane fade" id="nav-more" role="tabpanel" aria-labelledby="nav-more-tab">

                    <div class="row mt-4">
                        <div class="col-sm-6">
                            <div class="card">
                                <div class="card-header">
                                    分类目录
                                </div>
                                <div class="card-body">
                                        <div class="tab-pane fade show active p-4" id="nav-all-category" role="tabpanel" aria-labelledby="nav-all-category-tab">
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1">
                                                <label class="form-check-label" for="exampleRadios1">
                                                    java
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="option2">
                                                <label class="form-check-label" for="exampleRadios2">
                                                    javaScript
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios3" value="option3">
                                                <label class="form-check-label" for="exampleRadios3">
                                                    nodejs
                                                </label>
                                            </div>
                                        </div>

                                    <button type="button" class="btn btn-link btn-block text-left" data-id="" data-toggle="modal" data-target="#editCategoryModal">+ 添加新的分类目录</button>

                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="card">
                                <div class="card-header">
                                    标签
                                </div>
                                <div class="card-body">
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
                                        <label class="form-check-label" for="inlineCheckbox1">java</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
                                        <label class="form-check-label" for="inlineCheckbox2">nodejs</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3">
                                        <label class="form-check-label" for="inlineCheckbox3">3</label>
                                    </div>

                                    <button type="button" class="btn btn-link btn-block text-left" data-id="" data-toggle="modal" data-target="#editTagModal">+ 添加新的标签</button>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        </div>
    </div>


<div class="modal fade" id="editCategoryModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editCategoryModalLabel">分类管理</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="category-name" class="col-form-label">分类标题</label>
                        <input type="text" class="form-control" id="category-name">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-success" id="saveCategory">保存</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="editTagModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editTagModalLabel">分类管理</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="tag-name" class="col-form-label">分类标题</label>
                        <input type="text" class="form-control" id="tag-name">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-success" id="saveTag">保存</button>
            </div>
        </div>
    </div>
</div>





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
