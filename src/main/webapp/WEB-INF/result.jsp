<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-05-24
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Wynik</title>
</head>
<body>
Utworzono obiekt:
${book.title.concat(" ").concat(book.author).concat(" ").concat(book.isbn)}
</body>
</html>
