<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

</head>
<body>
<%@include file="navbar.jsp"%>
<div>
    <div class="container text-center" style="width: 980px">
        <p class="fs-2 fw-bold">Hello
            <%=currentUser.getFullName()%>
        </p>
        <p class="fs-5 fw-light">This is your profile page</p>
    </div>
</div>
</body>
</html>
