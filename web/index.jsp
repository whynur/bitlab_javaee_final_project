<%@ page import="kz.bitlab.javaee.final_project.model.NewsCategories" %>
<%@ page import="kz.bitlab.javaee.final_project.model.News" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Project</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container" style="min-height: 500px;">

    <div class="row mt-3">

        <div class="col-12">

            <%
                ArrayList<News> news = (ArrayList<News>) request.getAttribute("news");
                ArrayList<NewsCategories> newsCategories = (ArrayList<NewsCategories>) request.getAttribute("news_categories");
                if(news!=null){
                    for(News nev : news){
            %>

            <div class="row mt-3">

                <div class="col-11 mx-auto p-3" style="background-color: lightgrey;">
                    <a href="/news-details?id=<%=nev.getId()%>">
                        <h2><%=nev.getTitle()%></h2>
                    </a>
                    <%
                        for(NewsCategories newsCategories1 : newsCategories){
                            if(newsCategories1.getId() == nev.getCategoryId()){
                    %>
                    <p class="mt-1">Category: <%=newsCategories1.getName()%></p>
                    <%
                            }
                        }
                    %>
                    <p class="mt-2"><%=nev.getContent()%></p>

                    <p class="mt-2">

                        Posted at <strong><%=nev.getPostDate()%></strong>

                    </p>

                </div>

            </div>

            <%
                    }
                }
            %>
        </div>
    </div>
</div>
</body>
</html>
