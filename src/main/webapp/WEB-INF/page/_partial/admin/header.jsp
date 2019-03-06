<%--
  Created by IntelliJ IDEA.
  User: key
  Date: 2019/3/6
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<header id="header">
    <nav class="navbar navbar-expand-lg navbar-light bg-light p-3">
        <div class="container font-weight-bold">
            <a class="navbar-brand" href="/">
                <img src="/img/fc.png" height="30" alt="">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#adminNav" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <button type="button" data-toggle="modal" data-target="#logoutModal" class="btn btn-danger d-lg-block d-none" >
                注销
            </button>
        </div>
    </nav>
</header>

<!-- Modal -->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">注销登录</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                是否退出该账户？退出之后将不能对网站进行管理。
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="logout-btn">确认</button>
            </div>
        </div>
    </div>
</div>