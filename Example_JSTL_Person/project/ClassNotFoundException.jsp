<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Class Not Found Exception</title>
    </head>
    <body>
        <h1>Class Not Found Exception Error</h1>
        <p><c:out value="${exception.getMessage()}" /></p>
    </body>
</html>