<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>User Info Management System</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">User Infomation List</h3>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>ID</th>
            <th>Name</th>
            <th>Gender</th>
            <th>Age</th>
            <th>Nationality</th>
            <th>QQ</th>
            <th>Email</th>
            <th>Operation</th>
        </tr>

        <c:forEach items="${users}" var="user" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td><a class="btn btn-default btn-sm" href="update.html">Edit</a>&nbsp;<a class="btn btn-default btn-sm" href="">Delete</a></td>
            </tr>

        </c:forEach>


        <tr>
            <td colspan="8" align="center"><a class="btn btn-primary" href="add.html">Add User</a></td>
        </tr>
    </table>
</div>
</body>
</html>
