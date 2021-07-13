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
    <center><h3>Add User Page</h3></center>
    <form action="${pageContext.request.contextPath}/AddUserServlet" method="post">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Enter Name">
        </div>

        <div class="form-group">
            <label>Gender:</label>
            <input type="radio" name="gender" value="male" checked="checked"/>male
            <input type="radio" name="gender" value="female"/>female
        </div>

        <div class="form-group">
            <label for="age">Age:</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="Enter Age">
        </div>

        <div class="form-group">
            <label for="nationality">Nationality:</label>
            <select name="nationality" class="form-control" id="jiguan">
                <option value="Malaysia">Malaysia</option>
                <option value="China">China</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" name="qq" placeholder="Enter QQ"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" name="email" placeholder="Enter Email Address"/>
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