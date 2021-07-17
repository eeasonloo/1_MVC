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
    <script>
        function deleteUser(id){
            if(confirm("Do you want to delete this record?")){
                location.href="${pageContext.request.contextPath}/delUserServlet?id="+id;
            }
        }

        window.onload = function (){
            document.getElementById("firstCheckbox").onclick = function(){
                var userCheckbox = document.getElementsByName("userCheckbox")

                for (var i = 0; i < userCheckbox.length; i++) {
                    userCheckbox[i].checked = this.checked;
                }
            }
            document.getElementById("delSelected").onclick = function(){
               if(confirm("Do you want to delete the records?")){
                   var userCheckbox = document.getElementsByName("userCheckbox");

                   var flag = false;
                   for (var i = 0; i < userCheckbox.length ; i++) {
                       if (userCheckbox[i].checked) {
                           flag = true;
                           break;
                       }
                   }
                       if(flag){
                           document.getElementById("form").submit();
                       }

                }

            }

        }
    </script>
</head>
<body>
<div class="container">
    <h1 style="text-align: center;margin-bottom: 50px">User Information List</h1>

    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" >
            <span>&times;</span></button>
        <strong>${add_msg}</strong>
        <strong>${del_msg}</strong>
    </div>
    <div style="float: left;margin-top: 10px">

        <form class="form-inline" action="${pageContext.request.contextPath}/findUserByPageServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName2">name</label>
                <input type="text" name="name" value="${condition.name[0]}" class="form-control" id="exampleInputName2" >
            </div>
            <div class="form-group">
                <label for="exampleInputName3">nationality</label>
                <input type="text" name="nationality" value="${condition.nationality[0]}" class="form-control" id="exampleInputName3" >
            </div>

            <div class="form-group">
                <label for="exampleInputEmail2">email</label>
                <input type="text" name="email" value="${condition.email[0]}" class="form-control" id="exampleInputEmail2"  >
            </div>
            <button type="submit" class="btn btn-default">search</button>
        </form>

    </div>

    <div style="float: right;margin: 5px;margin-top: 10px">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">Add User</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">Delete Selected</a>

    </div>
    <form id="form" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">

    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="firstCheckbox"></th>
            <th>ID</th>
            <th>Name</th>
            <th>Gender</th>
            <th>Age</th>
            <th>Nationality</th>
            <th>QQ</th>
            <th>Email</th>
            <th>Operation</th>
        </tr>

        <c:forEach items="${pb.list}" var="user" varStatus="s">
            <tr>
                <th><input type="checkbox" name="userCheckbox" id="userCheckbox" value="${user.id}"></th>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.nationality}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">Edit</a>&nbsp;
                    <a class="btn btn-default btn-sm" id="deleteUser" href="javascript:deleteUser(${user.id})">Delete</a></td>
            </tr>

        </c:forEach>


        <tr>
            <td colspan="9" align="center"><a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">Add User</a></td>
        </tr>
    </table>
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">

                <c:if test="${pb.currentPage == 1}">
                    <li class="disabled">
                </c:if>
                <c:if test="${pb.currentPage > 1}">
                    <li>
                </c:if>
                        <a href="${pageContext.request.contextPath}/findUserByPageServlet?row=5&currentPage=${pb.currentPage-1}&name=${condition.name[0]}&nationality=${condition.nationality[0]}&email=${condition.email[0]}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>


                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <c:if test="${pb.currentPage==i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/findUserByPageServlet?row=5&currentPage=${i}&name=${condition.name[0]}&nationality=${condition.nationality[0]}&email=${condition.email[0]}">${i}</a></li>
                    </c:if>
                    <c:if test="${pb.currentPage!=i}">
                        <li><a href="${pageContext.request.contextPath}/findUserByPageServlet?row=5&currentPage=${i}&name=${condition.name[0]}&nationality=${condition.nationality[0]}&email=${condition.email[0]}">${i}</a></li>
                    </c:if>
                </c:forEach>

                <c:if test="${pb.currentPage < pb.totalPage}">
                    <li >
                </c:if>

                <c:if test="${pb.currentPage == pb.totalPage}">
                    <li class="disabled">
                </c:if>
                        <a href="${pageContext.request.contextPath}/findUserByPageServlet?row=5&currentPage=${pb.currentPage+1}&name=${condition.name[0]}&nationality=${condition.nationality[0]}&email=${condition.email[0]}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>

                <span style="font-size: 25px;margin-left: 5px;">
                    Total of ${pb.totalCount} Records, Total of ${pb.totalPage} Pages
                </span>

            </ul>
        </nav>


    </div>
</div>
</body>
</html>
