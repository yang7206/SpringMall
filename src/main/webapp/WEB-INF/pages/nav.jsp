<%--
  Created by IntelliJ IDEA.
  User: yangxiaoyu
  Date: 17/2/25
  Time: 下午9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:url value="/logout" var="logoutUrl"/>

<!-- csrt for log out-->
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>

<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>

<div class="header-area" style="margin-bottom: 0px">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="user-menu">
                    <ul>
                        <c:choose>
                            <c:when test="${pageContext.request.userPrincipal.name != null}">
                                <li><a href="/personcenter"><i class="fa fa-coffee"></i>欢迎，${pageContext.request.userPrincipal.name}</a></li>
                                <li><a href="javascript:formSubmit()"><i class="fa fa-sign-out"></i>注销登录</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="/login"><i class="fa fa-sign-in"></i>登录</a></li>
                            </c:otherwise>
                        </c:choose>
                        <li><a href="#"><i class="fa fa-shopping-cart"></i>购物车</a></li>
                        <li><a href="#"><i class="fa fa-heart"></i>心愿单</a></li>
                    </ul>
                </div>
            </div>

            <div class="col-md-4">
                <div class="header-right">
                    <ul class="list-unstyled list-inline">

                        <li class="dropdown dropdown-small">
                            <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span
                                    class="key">language :</span><span class="value">English </span><b
                                    class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">English</a></li>
                                <li><a href="#">French</a></li>
                                <li><a href="#">German</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End header area -->

<div class="top-banner">
    <div class="tb-bgimg">
        <div>
            <div class="tb-text">iPhone</div>
            <div class="tb-text2">6，在此</div>
            <div class="tb-text3"><a href="#">进一步了解</a></div>
        </div>
    </div>
</div>
<div class="site-branding-area">
    <div class="container">
        <div class="row">
            <div class="col-sm-3">
                <div class="logo">
                    <h1><a href="/"><img src="img/logo.png"></a></h1>
                </div>
            </div>

            <div class="col-sm-6">
                <div class="searchbar-item">
                    <div class="sb-inputdiv">
                        <div class="sb-input">
                            <input style="width: 100%" type="text" placeholder="搜索宝贝">
                        </div>
                    </div>
                    <div class="sb-btn">
                        <input type="submit" value="搜索">
                    </div>
                </div>
            </div>

            <div class="col-sm-3">
                <div class="shopping-item">
                    <a href="/cart">购物车 - <span class="cart-amunt">$100</span> <i class="fa fa-shopping-cart"></i>
                        <span class="product-count hidden">5</span></a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End site branding area -->

<div class="mainmenu-area">
    <div class="container">
        <div class="row">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="/">首页</a></li>
                    <li><a href="/shop">商店页</a></li>
                    <li><a href="/single-product">单品</a></li>
                    <li><a href="/cart">购物车</a></li>
                    <li><a href="/checkout">购买</a></li>
                    <li><a href="#">分类</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- End mainmenu area -->
