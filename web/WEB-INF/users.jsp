<%-- 
    Document   : users
    Created on : 26-Oct-2020, 11:39:13 AM
    Author     : Group CCC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
        <h1>Manager Users</h1>
        <h2>Users</h2>
        <table class="t1">
            
            <c:forEach items="${userList}" var="user">
            <tr>
                <td><p>${user.username}</p></td>
                <td><p>${user.firstname}</p></td>
                <td><p>${user.lastname}</p></td>
                <td><p>${user.email}</p></td>
                <td></td>
                <td>
                    <form action="users" method="POST" name="delete">
                        <input type="hidden" name="user" value="${user}"/>
                        <input type="hidden" name="action" value="deleteItem"/>
                        <input type="submit" name="request" value="delete"/>
                    </form>
                </td>
                <td>
                    <form action="" method="POST" name="edit">
                        <input type="hidden" name="user" value="${user}"/>
                        <input type="hidden" name="action" value="editItem"/>
                        <input type="submit" name="request" value="edit"/>
                    </form>
                </td>
            </tr>
            </c:forEach>
        </table>
        
           ${message} 
        <h2>Add User</h2>
        <form action="users" method="post">
            <label>Username:</label><input type="text" name="addUser" value="${addUser}">
            <label>First Name:</label><input type="text" name="addFirstName" value="${addFirstName}">
            <label>Last Name:</label><input type="text" name="addLastName" value="${addLastName}">
            <label>Password:</label><input type="text" name="addPassword" value="${addPassword}">
            <label>Email:</label><input type="text" name="addEmail" value="${addEmail}">
            <input type="hidden" name="action" value="saveItem">
            <input type="submit" name="Save" value="Save">
        </form>    
        
    </body>
</html>
