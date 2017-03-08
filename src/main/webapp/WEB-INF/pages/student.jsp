<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/2
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <%--<%@include file="header.jsp"%>--%>
</head>
<body>

<form:form method="post" modelAttribute="SStudent">
    <table>
        <tr>
            <td>
                <form:label path="firstName">firstName</form:label>
                <form:input path="firstName"/>
                <form:errors path="firstName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="lastName">lastName</form:label>
                <form:input path="lastName"/>
                <form:errors path="lastName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="sex">sex</form:label>
                <form:select path="sex" multiple="true" items="${sexAttr}">
                </form:select>
                <form:errors path="sex"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:checkboxes path="country" items="${webFrameworkList}"/>
                <form:errors path="country"/>
            </td>
        </tr>
        <tr>
    </table>
    <input type="submit" value="提交">
</form:form>

</body>
</html>
