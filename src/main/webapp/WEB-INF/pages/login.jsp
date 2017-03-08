<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/logincss.css">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-sm-3">
            <div class="logo">
                <h1><a href="/"><img src="img/logo.png"></a></h1>
            </div>
        </div>
    </div>

</div>
<div class="nopadding">
    <div class="content">

        <div class="parent">

            <div class="parent-c">

                <div class="child">

                    <h3 class="header">账号登录</h3>

                    <div>
                        <form class="form-horizontal clearfix" role="form" method="post" action="/login.do">
                            <input type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                            <div class="form-group">
                                <label for="account" class="col-sm-3 control-label">账号</label>
                                <div class="col-sm-9">
                                    <input type="text" placeholder="手机号" name="account" value="${sessionScope.account}" class="form-control"
                                           id="account"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="col-sm-3 control-label">密码</label>
                                <div class="col-sm-9">
                                    <input type="password" placeholder="密码" name="password" class="form-control"
                                           id="password"/>
                                </div>
                            </div>
                            <c:if test="${param.failed==true }">
                                <div class="fail-tips">
                                    <div class="error">${sessionScope.info}</div>
                                </div>
                            </c:if>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <div class="checkbox marglr20">
                                        <label><input type="checkbox" id="rememberMe" name="rememberMe"/>下次自动登录</label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <div class="marglr20">
                                        <button type="submit" class="btn loginbtn">登 录</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>


                    <div class="row clearfix">
                        <div class="col-md-11 regist-p">

                            <div class="regist-a">
                                <p><a href="#">忘记密码</a><a href="#">免费注册</a></p>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>


</div>

</div>

<div class="row bottom clearfix">
    <div class="copyright text-center clearfix">
        <p>Copyright &copy; 2015.Company name All rights reserved.<a target="_blank"
                                                                     href="http://www.cssmoban.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
        </p>
    </div>
</div>

</body>
</html>