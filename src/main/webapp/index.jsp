<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= LocalDateTime.now()%>
</h1>
<h2><%="Fuck you"%></h2>
<br/>
<a href="hello-servlet">Hello Servlet</a>

</body>
</html>