<%--
  Created by IntelliJ IDEA.
  User: lucky
  Date: 2017/12/12
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>标题: ${title}</h1>
<h1>消息 : ${message}</h1>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>欢迎: ${pageContext.request.userPrincipal.name}
        | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a></h2>
</c:if>
</body>
</html>
