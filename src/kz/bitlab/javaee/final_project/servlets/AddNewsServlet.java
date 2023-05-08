package kz.bitlab.javaee.final_project.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.javaee.final_project.db.DBManager;
import kz.bitlab.javaee.final_project.model.News;
import kz.bitlab.javaee.final_project.model.NewsCategories;
import kz.bitlab.javaee.final_project.model.Users;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet(value = "/addblog")
public class AddNewsServlet extends HttpServlet {
    @Override
    public void  doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException, ServletException {
        ArrayList<NewsCategories> news_categories = DBManager.getAllCategory();
        request.setAttribute("news_categories", news_categories);
        request.getRequestDispatcher("/add_news.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Users user = (Users) request.getSession().getAttribute("currentUser");
        ArrayList<NewsCategories> newsCategories = DBManager.getAllCategory();
        if(user!=null && user.getRoleId()==1) {
            Timestamp postDate = new Timestamp(System.currentTimeMillis());
            String categoryName = request.getParameter("news_category_name");
            int categoryId = 0;
            for(NewsCategories newsCategories1 : newsCategories){
                if(Objects.equals(categoryName, newsCategories1.getName())){
                    categoryId = Math.toIntExact(newsCategories1.getId());
                }else{
                }
            }
            String title = request.getParameter("title");
            String content = request.getParameter("content");

            NewsCategories news_category = DBManager.getCategory(categoryId);

            if (news_category != null) {

                News news = new News();
                news.setPostDate(postDate);
                news.setCategoryId(categoryId);
                news.setTitle(title);
                news.setContent(content);
                DBManager.addNews(news);
            }
            response.sendRedirect("/home");
        }else{
            response.sendRedirect("/login");
        }
    }
}
