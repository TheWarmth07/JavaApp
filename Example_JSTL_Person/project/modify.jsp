<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>modify.jsp</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    </head>
    
    <body>
	<h1>Modify Entry</h1>
        <p>To modify a person, please enter the new details below.</p>
        
        <form action="modifyPerson" method="post">
            <table border="1">
                <tr>
                    <td></td>
                    <td>Current Value</td>
                    <td>New Value</td>
                </tr>
                <tr>
                    <td><label>person ID:</label></td>
                    <td>${person.personId}</td>
                    <td><input type="hidden" name="personId" value="${person.personId}"></td>
                </tr>
                <tr>
                    <td><label>First Name:</label></td>
                    <td>${person.firstName}</td>
                    <td><input type="text" name="firstName" value="${person.firstName}"></td>
                </tr>
                <tr>
                    <td><label>Last Name:</label></td>
                    <td>${person.lastName}</td>
                    <td><input type="text" name="lastName" value="${person.lastName}"></td>
                </tr>
                <tr>
                    <td><label>Email:</label></td>
                    <td>${person.emailAddress}</td>
                    <td><input type="text" name="email" value="${person.emailAddress}"></td>
                </tr>
                <tr align="center">
                    <td><input type="submit" value="Change"></td>
                    <td><input type="hidden" name="action" value="modify"></td>
                </tr>
            </table>
        </form>
    </body>
</html>