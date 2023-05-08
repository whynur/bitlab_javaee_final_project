<%@ page import="kz.bitlab.javaee.final_project.model.Users" %>
<% Users currentUser = (Users) session.getAttribute("currentUser");%>
<div class="container-sm">
    <nav class="navbar navbar-expand-lg" style="background-color: #435f81">
        <div class="container-fluid">
            <a class="navbar-brand text-white" href="/home">TEMA NEWS</a>
            <div class="collapse navbar-collapse" id="navbarScroll">
                <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                    <%
                        if(currentUser!=null){
                    %>
                    <%
                        if(currentUser.getRoleId()==1){
                    %>
                    <li class="nav-item">
                        <a class="nav-link active text-white-50" aria-current="page" href="/add_news">Add News</a>
                    </li>
                    <%
                        }
                    %>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle text-white-50" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <%=currentUser.getFullName()%>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/profile">Profile</a></li>
                            <li><a class="dropdown-item" href="/edit_profile">Edit Profile</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="/logout">Logout</a></li>
                        </ul>
                    </li>
                    <%
                    }else{
                    %>
                    <li class="nav-item">
                        <a class="nav-link text-white-50" href="/login" role="button">
                            Login
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active text-white-50" aria-current="page" href="/register">Register</a>
                    </li>
                    <%
                        }
                    %>
                </ul>
            </div>
        </div>
    </nav>
</div>
