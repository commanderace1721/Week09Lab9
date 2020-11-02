<%-- 
    Document   : users
    Created on : 26-Oct-2020, 11:39:13 AM
    Author     : Group CCC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users-Management</title>
        <link href="./usercss.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1 class="mainTitle">Manager Users</h1>
        <header> 
            <tabel class="menu">
                <tr>        
                <td class ="og"><h3>About</h3></td>
                <td class="og"><h3>Contact Us!</h3></td>
                <td class="og"><h3>403-123-4567</h3></td>
            </tr>
            </tabel>
        </header>
        <div class ="show">
        <h2>Users</h2>
        <table class="t1">
            <tr>
                <td><h3>username</h3></td
                ><td><h3>First Name</h3></td>
                <td><h3>Last Name</h3></td>
                <td><h3>Email</h3></td>
                <td></td>
                <td><h3>Delete</h3></td>
                <td><h3>Edit</h3></td>
            </tr>
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
        <table>
        <form action="users" method="post">
            <tr>
                <td><label>Username:</label><input type="text" name="addUser" value="${addUser}"></td>
            </tr>
            <label>First Name:</label><input type="text" name="addFirstName" value="${addFirstName}"></td>
            </tr>
            <tr>
                <td><label>Last Name:</label><input type="text" name="addLastName" value="${addLastName}"></td>
            </tr>
                <td><label>Password:</label><input type="text" name="addPassword" value="${addPassword}"></td>
            </tr>
            <tr>
                <td><label>Email:</label><input type="text" name="addEmail" value="${addEmail}"></td>
            </tr>
            <tr>
                <td><input type="hidden" name="action" value="saveItem"></td>
            </tr>
            <tr>
                <td><input type="submit" name="Save" value="Save"></td>
            </tr>
        </form>    
        </table>
    </div>
    </body>
</html>
