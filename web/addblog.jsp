<%@ page import="kz.bitlab.javaee.final_project.model.News" %>
<%@ page import="kz.bitlab.javaee.final_project.model.NewsCategories" %>
<%@ page import="java.util.ArrayList" %>
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
        Add News
    </div>
    <div class="fs-6 p-4">
        <form action="/add_news" method="post">
            <div class="row">
                <div class="col-12">
                    <label>Select Category : </label>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-12">
                    <div class="form-floating">
                        <select class="form-select" name="news_category_name">
                            <%
                                ArrayList<NewsCategories> news_categories = (ArrayList<NewsCategories>) request.getAttribute("news_categories");
                                if(news_categories!=null){
                                    for(NewsCategories news_cat : news_categories){
                            %>
                            <option><%=news_cat.getName()%></option>
                            <%
                                    }
                                }
                            %>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-12">
                    <label>Title : </label>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-12">
                    <input type="title" class="form-control" name="title" required placeholder="Insert Title">
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-12">
                    <label>Content : </label>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-12">
                    <textarea type="content" class="form-control" name="content" required placeholder="..."></textarea>
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
