<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>MVC 2</title>
</head>
<body>
NIEPOPRAWNE BO KORZYSTAMY Z PARAMETRU ŻĄDANIA A NIE Z ATRYBUTU USTAWIANEGO PRZEZ KONTROLER:<br>
<c:forEach begin="${param.start}" end="${param.end}" var="number">
    ${number}
</c:forEach>
<br>
POPRAWNE:<br>
<c:forEach begin="${start}" end="${end}" var="number">
    ${number}
</c:forEach>
</body>
</html>
