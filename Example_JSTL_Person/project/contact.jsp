<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>contact.jsp</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    </head>
    
    <body>
	<h1>Contact Entry</h1>
        <p>To create a new person, please enter the details below.</p>
        
        <form action="newPerson" method="post">
            <table border="1">
                <tr>
                    <td><label>person ID:</label></td>
                    <td><input type="text" name="personId"></td>
                </tr>
                <tr>
                    <td><label>First Name:</label></td>
                    <td><input type="text" name="firstName"></td>
                </tr>
                <tr>
                    <td><label>Last Name:</label></td>
                    <td><input type="text" name="lastName"></td>
                </tr>
                <tr>
                    <td><label>Email:</label></td>
                    <td><input type="text" name="email"></td>
                </tr>
                <tr align="center">
                    <td><input type="submit" value="Save"></td>
                    <td><input type="hidden" name="action" value="insert"></td>
                </tr>
            </table>
        </form>
    </body>
</html>