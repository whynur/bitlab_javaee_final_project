<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container-sm mt-3 shadow " style="border-radius: 3px; width: 100%; padding: 0; width: 940px">
    <div class="fs-5 p-3" style="background-color: #f7f7f7">
        Edit Profile Page
    </div>
    <div class="fs-6 p-4">
        <form action="/edit_profile" method="post">
            <div class="row">
                <div class="col-12">
                    <label>EMAIL : </label>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-12">
                    <input type="email" class="form-control" name="email" required placeholder="Insert Email">
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-12">
                    <label>PASSWORD : </label>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-12">
                    <input type="password" class="form-control" name="password" required placeholder="Insert Password">
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-12">
                    <label>FULL NAME : </label>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-12">
                    <input type="text" class="form-control" name="full_name" required placeholder="Full Name">
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-12">
                    <button class="btn btn-success">Save</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
