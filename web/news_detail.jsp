<%@ page import="kz.bitlab.javaee.final_project.model.NewsCategories" %>
<%@ page import="kz.bitlab.javaee.final_project.model.News" %>
<%@ page import="kz.bitlab.javaee.final_project.model.Comments" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>News Detail</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container mt-3">
    <div class="row mt-3">
        <div class="col-12">
            <%
                News news = (News) request.getAttribute("news");
                ArrayList<NewsCategories> newsCategories = (ArrayList<NewsCategories>) request.getAttribute("news_categories");
                if (news != null) {

            %>
            <div class="p-5 mb-3" style="background-color: #dee1df;">

                <h3><%=news.getTitle()%>
                </h3>
                <%
                    for(NewsCategories newsCategories1 : newsCategories){
                        if(newsCategories1.getId() == news.getCategoryId()){
                %>
                <p class="mt-1">Category: <%=newsCategories1.getName()%></p>
                <%
                        }
                    }
                %>
                <p><%=news.getContent()%>
                </p>
                <p>
                    </strong>
                    Posted at <strong><%=news.getPostDate()%>
                </strong>
                </p>
                <%
                    if (currentUser != null && currentUser.getId() == 1) {
                %>
                <div>
                    <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal"
                            data-bs-target="#editNews">
                        EDIT
                    </button>
                    <div class="modal fade" id="editNews" data-bs-backdrop="static" data-bs-keyboard="false"
                         tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <form action="/save-news" method="post">
                                    <input type="hidden" name="id" value="<%=news.getId()%>">
                                    <div class="modal-header">
                                        <h1 class="modal-title fs-5" id="staticBackdropLabel">Edit News</h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="row">
                                            <div class="col-12">
                                                <label>
                                                    Take Category :
                                                </label>
                                            </div>
                                        </div>
                                        <div class="row mt-2">
                                            <div class="col-12">
                                                <select name="category_id">
                                                    <%
                                                        for(NewsCategories newsCategories1 : newsCategories){
                                                    %>
                                                    <option value="<%=newsCategories1.getId()%>"><%=newsCategories1.getName()%></option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-12">
                                                <label>
                                                    TITLE :
                                                </label>
                                            </div>
                                        </div>
                                        <div class="row mt-2">
                                            <div class="col-12">
                                                <input type="text" class="form-control" name="title" required
                                                       placeholder="Insert title:" value="<%=news.getTitle()%>">
                                            </div>
                                        </div>
                                        <div class="row mt-3">
                                            <div class="col-12">
                                                <label>
                                                    CONTENT :
                                                </label>
                                            </div>
                                        </div>
                                        <div class="row mt-2">
                                            <div class="col-12">
                                                <textarea class="form-control" name="content"
                                                          placeholder="Insert content:" required
                                                          rows="10"><%=news.getContent()%></textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel
                                        </button>
                                        <button class="btn btn-success">Update</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
            <%
                if (currentUser != null) {
            %>
            <div>
                <form action="/add-comment" method="post">
                    <input type="hidden" name="news_id" value="<%=news.getId()%>">
                    <div class="row">
                        <div class="col-12">
                            <textarea class="form-control" name="comment"></textarea>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <button class="btn btn-success btn-sm">ADD COMMENT</button>
                        </div>
                    </div>
                </form>
            </div>
            <%
                }
            %>
            <div class="row">
                <div class="col-12">
                    <%
                        ArrayList<Comments> comments = (ArrayList<Comments>) request.getAttribute("comments");
                        if (comments != null){
                            for(Comments comment : comments){
                    %>
                    <div class="list-group">
                        <a href="JavaScript:void(0)" class="list-group-item list-group-item-action">
                            <div class="d-flex w-100 justify-content-between">
                                <h5 class="mb-1"><%=comment.getUsers().getFullName()%></h5>
                                <small class="text-body-secondary"><%=comment.getPostDate()%></small>
                            </div>
                            <p class="mb-1"><%=comment.getComment()%></p>
                        </a>
                    </div>
                    <%
                            }
                        }
                    %>
                </div>
            </div>
            <%

                }
            %>
        </div>
    </div>
</div>
</body>
</html>