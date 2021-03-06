<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2019-02-04
  Time: 08:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head lang="en">
    <title>登录-方寸</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%@include file="/WEB-INF/page/_partial/css.jsp"%>
</head>
<body>

<div class="container">
    <div class="text-center mt-4">
        <a href="/">
            <img src="img/fc.png" alt="" height="50px">
            <p class="text-muted">方寸之间见天地，细微之处有乾坤。</p>
        </a>
    </div>
    <div class="row justify-content-center">
        <div class="card mt-4 col-10 col-sm-10 col-md-8 col-lg-6 p-0 ">
            <div class="card-header">
                登录
            </div>
            <div class="card-body p-3 p-sm-3 p-md-4 p-lg-5">
                <form method="post" action="${pageContext.request.contextPath}/login" class="needs-validation">
                    <div class="form-group">
                        <label for="exampleInputEmail1">用户名</label>
                        <input type="text" name="name" required value="${formBean.name}" class="form-control ${formBean.errors.name == null?"":"is-invalid"}" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="请输入用户名">
                        <div class="invalid-feedback">
                            ${formBean.errors.name}
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">密码</label>
                        <input type="password" name="password"  required value="${formBean.password}" class="form-control ${formBean.errors.password == null?"":"is-invalid"}" id="exampleInputPassword1" placeholder="请输入密码">
                        <div class="invalid-feedback">
                            ${formBean.errors.password}
                        </div>

                    </div>
                    <div class="form-group">
                        <label for="verificationCode" class="d-block">验证码</label>
                        <input type="text" name="verifyCode" required class="form-control w-50 d-inline-block ${formBean.errors.verifyCode == null?"":"is-invalid"}" id="verificationCode" placeholder="请输入验证码">
                        <img src="getVerifyCode" class="align-middle" id="verifyCode">
                        <div class="invalid-feedback">
                            ${formBean.errors.verifyCode}
                        </div>
                    </div>
                    <button type="submit" class="btn btn-success btn-block">登录</button>
                </form>
            </div>
            <div class="card-footer text-muted text-center">
                Copyright © <a href="http://github.com/keyarea" target="_blank">keyarea</a> 2019 <br>
                鲁ICP备15027646号-2
            </div>
        </div>
    </div>
</div>


<%@include file="/WEB-INF/page/_partial/script.jsp"%>
<script type="application/javascript" src="/js/login.js"></script>

</body>
</html>
