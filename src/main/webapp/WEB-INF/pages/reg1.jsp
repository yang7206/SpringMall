<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/1
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Title</title>
    <%@include file="header.jsp"%>
</head>
<body>
<div class="main">

    <div class="header">
        <h1>加入我们</h1>
    </div>

    <form:form method="post" action="/reg1" modelAttribute="loginAccount">
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3" for="accunt">账号</label>
                <div class="col-md-7">
                    <form:input id="accunt" path="account" />
                    <div class="has-error">
                        <form:errors path="account"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3" for="email">邮箱</label>
                <div class="col-md-7">
                    <form:input id="email" path="email" />
                    <div class="has-error">
                        <form:errors path="email"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3" for="password">密码</label>
                <div class="col-md-7">
                    <form:input type="password" id="password" path="password" />
                    <div class="has-error">
                        <form:errors path="password"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3" for="passwordAgain">密码</label>
                <div class="col-md-7">
                    <form:input type="password" id="passwordAgain" path="passwordAgain" />
                    <div class="has-error">
                        <form:errors path="passwordAgain"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <form:select path="sex" id="sex">
                <form:options items="${countries}"/>
            </form:select>
        </div>

        <div class="row">
            <div class="form-actions">
                <input type="submit" value="Register" class="btn btn-primary btn-sm">
            </div>
        </div>
    </form:form>

</div>

</body>
</html>
