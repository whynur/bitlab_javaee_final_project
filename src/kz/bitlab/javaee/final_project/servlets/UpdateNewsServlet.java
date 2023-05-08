package kz.bitlab.javaee.final_project.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.javaee.final_project.db.DBManager;
import kz.bitlab.javaee.final_project.model.News;
import kz.bitlab.javaee.final_project.model.Users;

import java.io.IOException;

@WebServlet(value = "/save-news")
public class UpdateNewsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users user = (Users) request.getSession().getAttribute("currentUser");
        if(user!=null) {
            int categoryId = Integer.parseInt(request.getParameter("category_id"));
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            Long id = Long.parseLong(request.getParameter("id"));

            News news = DBManager.getNewsById(id);
            if(news!=null) {
                news.setTitle(title);
                news.setContent(content);
                news.setCategoryId(categoryId);

                DBManager.updateNews(news);

                response.sendRedirect("/news-details?id="+id);

            }else{
                response.sendRedirect("/");
            }

        }else{
            response.sendRedirect("/login");
        }
    }
}