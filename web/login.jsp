<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container-sm mt-3 shadow " style="border-radius: 3px; width: 100%; padding: 0; width: 940px">
    <div class="fs-5 p-3" style="background-color: #f7f7f7">
        Login Page
    </div>
    <div class="fs-6 p-4">
        <form action="/login" method="post">
            <div class="input-group mb-3">
                <span class="input-group-text" id="user_email">Email</span>
                <input type="email" class="form-control"  required name="email" >
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="user_password">Password</span>
                <input type="password" class="form-control"  required name="password" >
            </div>
            <button class="btn btn-success">Login</button>
        </form>
    </div>
</div>
</body>
</html>
