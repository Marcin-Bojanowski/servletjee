<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>MVC 1</title>
</head>
<body>
Parametr w GET: ${param.role}<br>
Atrybut z kontrolera: ${userRole}<br>
JSTL:
<c:out value="${userRole}" default="<b>guest</b>" escapeXml="false"></c:out>
</body>
</html>
