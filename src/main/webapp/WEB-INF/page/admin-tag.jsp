<%--
  Created by IntelliJ IDEA.
  User: key
  Date: 2019/3/6
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/page/_partial/admin/head.jsp"/>
<body>

<div class="main">
    <jsp:include page="/WEB-INF/page/_partial/admin/header.jsp" />

    <div class="container my-4">
        <div class="row justify-content-md-center">
            <div class="col-12 col-lg-3 navbar-collapse collapse d-lg-block" id="adminNav">
                <jsp:include page="/WEB-INF/page/_partial/admin/aside.jsp" >
                    <jsp:param name="navParam" value="tag" />
                </jsp:include>
            </div>
            <div class="col-12 col-lg-9">

                <div class="card">
                    <div class="card-header">
                        <strong>标签管理</strong>
                    </div>
                    <div class="card-body">

                        <div class="row justify-content-md-center">
                            <div class="col-12 col-lg-8">
                                <form class="form-inline">
                                    <div class="form-group mb-2">
                                        <label for="keyword" class="sr-only">关键词</label>
                                        <input type="password" class="form-control" id="keyword" placeholder="关键词">
                                    </div>
                                    <button type="submit" class="btn btn-primary mb-2 ml-2">搜索</button>
                                </form>
                            </div>
                            <div class="col-12 col-lg-4 text-center">
                                <button type="button" class="btn btn-success btn-block" data-id="" data-toggle="modal" data-target="#editTagModal">添加标签</button>
                            </div>
                        </div>

                        <div class="table-responsive-lg">
                            <table class="table table-hover table-striped">
                                <thead>
                                <tr>
                                    <th scope="col" nowrap>#</th>
                                    <th scope="col" nowrap>标签名称</th>
                                    <th scope="col" nowrap>文章数量</th>
                                    <th scope="col" nowrap>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:choose>
                                    <c:when test="${empty tags}">
                                        <tr>
                                            <td class="text-center" colspan="4">暂无数据</td>
                                        </tr>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach var="tag" items="${tags}" >
                                            <tr>
                                                <th scope="row" class="align-middle" nowrap>${tag.id}</th>
                                                <td class="align-middle" nowrap>${tag.name}</td>
                                                <td class="align-middle" nowrap>${fn:length(tag.articles)}</td>
                                                <td class="align-middle" nowrap>
                                                    <button type="button" class="btn-info btn  btn-sm" data-id="${tag.id}" data-toggle="modal" data-target="#editTagModal">编辑</button>
                                                    <button type="button" class="btn btn-danger btn-sm" data-id="${tag.id}" data-toggle="modal" data-target="#deleteTagModal">删除</button>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<%--删除标签模态框--%>
<div class="modal fade" tabindex="-1" role="dialog" id="deleteTagModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">删除标签</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p id="deleteTagModalBody"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" id="deleteTag">确认</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>

<%--添加编辑标签模态框--%>

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


<%@include file="/WEB-INF/page/_partial/footer.jsp"%>

<%@include file="/WEB-INF/page/_partial/script.jsp"%>
<%@include file="/WEB-INF/page/_partial/admin/script.jsp"%>
</body>
</html>
