<%--
  Created by IntelliJ IDEA.
  User: key
  Date: 2019/1/23
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<jsp:include page="/WEB-INF/page/_partial/head.jsp" flush="true">
    <jsp:param name="pageTitle" value="登录" />
    <jsp:param name="pageStyle" value="css/login.css" />
</jsp:include>

<header>
    <nav class="loginNav">
        <div class="container text-center loginLogo" >
            <a href="#">
                <img src="img/logo.png" alt="方寸" height="40px" width="40px">
            </a>
        </div>
    </nav>
</header>

<div class="container content">

    <div class="row">
        <div class="col-md-7 col-sm-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="jumbotron">
                        <h1>Hello, world!</h1>
                        <p>...</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-5 col-sm-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <ul class="nav nav-tabs nav-justified loginTabs" role="tablist">
                        <li role="presentation" class="active"><a href="#login" aria-controls="login" role="tab" data-toggle="tab">登录</a> </li>
                        <li role="presentation"><a href="#signIn" aria-controls="signIn" role="tab" data-toggle="tab">注册</a></li>
                    </ul>

                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="login">
                            <form action="login" method="post" class="loginForm">
                                <div class="form-group form-group-lg form-item">
                                    <label for="exampleInputEmail1" class="control-label">用户名或邮件地址</label>
                                    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="用户名或邮件地址" name="username" required="required">
                                </div>
                                <div class="form-group form-group-lg form-item">
                                    <label for="exampleInputPassword1">密码</label>
                                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="密码" name="password" required="required">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" width="100%" height="100%"> 记住密码
                                    </label>

                                    <label class="pull-right">
                                        <a>忘记密码</a>
                                    </label>
                                </div>
                                <button type="submit" data-loading-text="登录中..." class="btn btn-success btn-block btn-lg">登录</button>
                            </form>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="signIn">
                            <form action="signIn" method="post" class="signInForm">
                                <div class="form-group form-group-lg form-item">
                                    <label for="InputUserName">用户名</label>
                                    <input type="text" class="form-control" id="InputUserName" placeholder="用户名" required="required">
                                </div>
                                <div class="form-group form-group-lg form-item">
                                    <label for="InputEmail">邮箱地址</label>
                                    <input type="email" class="form-control" id="InputEmail" placeholder="邮箱地址" required="required">
                                </div>
                                <div class="form-group form-group-lg form-item">
                                    <label for="InputEmail1">确认邮箱地址</label>
                                    <input type="email" class="form-control" id="InputEmail1" placeholder="重复邮箱地址" required="required">
                                </div>
                                <div class="form-group form-group-lg form-item">
                                    <label for="InputPassword">密码</label>
                                    <input type="password" class="form-control" id="InputPassword" placeholder="用户密码" required="required">
                                </div>

                                <button type="submit" class="btn btn-success btn-block btn-lg">注册</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<footer >

</footer>

<jsp:include page="/WEB-INF/page/_partial/script.jsp">
    <jsp:param name="pageScript" value="/WEB-INF/js/login.js"></jsp:param>
</jsp:include>
