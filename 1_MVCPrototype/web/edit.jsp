<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>


<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Add User</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <center><h3>Edit User Page</h3></center>
    <form action="${pageContext.request.contextPath}/editUserServlet" method="post">

        <input type="hidden" name="id" value="${userInfo.id}">

        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Enter Name" value="${userInfo.name}">
        </div>

        <div class="form-group">
            <label>Gender:</label>
                <c:if test="${userInfo.gender=='male'}">
                    <input type="radio" name="gender" value="male" checked="checked"/>male
                    <input type="radio" name="gender" value="female"/>female
                </c:if>
                <c:if test="${userInfo.gender=='female'}">
                    <input type="radio" name="gender" value="male" />male
                    <input type="radio" name="gender" value="female" checked="checked"/>female
                </c:if>
        </div>

        <div class="form-group">
            <label for="age">Age:</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="Enter Age" value="${userInfo.age}">
        </div>

        <div class="form-group">
            <label for="nationality">Nationality:</label>
            <select name="nationality" class="form-control" id="jiguan">
                <c:if test="${userInfo.nationality=='Malaysia'}">
                    <option value="Malaysia" selected="selected">Malaysia</option>
                    <option value="China">China</option>
                </c:if>
                <c:if test="${userInfo.nationality=='China'}">
                    <option value="Malaysia">Malaysia</option>
                    <option value="China"  selected="selected">China</option>
                </c:if>

            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ:</label>
            <input type="text" class="form-control" name="qq" placeholder="Enter QQ"/ value="${userInfo.qq}">
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" class="form-control" name="email" placeholder="Enter Email Address"/ value="${userInfo.email}">
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="Submit" />
            <input class="btn btn-default" type="reset" value="Reset" />
            <input class="btn btn-default" type="button" value="Return" />
        </div>
    </form>
</div>
</body>
</html>