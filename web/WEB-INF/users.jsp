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
        <table name="t1">
            <tr>
                <td><h3>username</h3></td><td><h3>First Name</h3></td><td><h3>Last Name</h3></td><td><h3>Email</h3></td><td></td><td><h3>Delete</h3></td><td><h3>Edit</h3></td>
            </tr>
            <tr>
                <td><p>${username}</p></td><td><p>${firstname}</p></td><td><p>${lastname}</p></td><td><p>${email}</p></td><td></td><td><form action="" method="" name="delete"><input type="submit" value="Delete"></form></td>
                <td><form action="" method="" name="edit"><input type="submit" value="Edit"></form></td>
            </tr>
        </table>
        
    </body>
</html>
