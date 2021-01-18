<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-05-24
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Lista książek</title>
</head>
<body>
<c:forEach var="book" items="${lista}">
    ${book.title}
    ${book.author}
    ${book.isbn}<br>
</c:forEach>
</body>
</html>
