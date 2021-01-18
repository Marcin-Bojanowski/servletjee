<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-05-24
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Third</title>
</head>
<body>
Parametry to: ${!empty param.a&&!empty param.b?param.a.concat(", ").concat(param.b):"brak"}

</body>
</html>
