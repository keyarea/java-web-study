<%--
  Created by IntelliJ IDEA.
  User: key
  Date: 2019/1/31
  Time: 8:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header id="header">
    <nav class="navbar navbar-expand-lg navbar-dark bg-info p-3 text-white">
        <div class="container font-weight-bold">
            <a class="navbar-brand" href="#">LOONG.IO</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">主页 <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">归档</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            更多
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">分类</a>
                            <a class="dropdown-item" href="#">留言板</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">关于</a>
                        </div>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="输入你想要搜索的内容" aria-label="Search">
                    <button class="btn btn-outline-light my-2 my-sm-0" type="submit">搜索</button>
                </form>
            </div>
        </div>
    </nav>

</header>
