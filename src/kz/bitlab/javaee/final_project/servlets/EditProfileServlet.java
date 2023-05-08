package kz.bitlab.javaee.final_project.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kz.bitlab.javaee.final_project.db.DBManager;
import kz.bitlab.javaee.final_project.model.Users;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "/edit_profile")
public class EditProfileServlet extends HttpServlet {
    @Override
    public void  doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException, ServletException {
        request.getRequestDispatcher("/edit_profile_page.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users currentUser = (Users) session.getAttribute("currentUser");

        Long id = currentUser.getId();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String full_name = request.getParameter("full_name");
        int role_id = currentUser.getRoleId();

        Users temp = new Users();
        temp.setId(id);
        temp.setEmail(email);
        temp.setPassword(password);
        temp.setFullName(full_name);
        temp.setRoleId(role_id);

        System.out.println(temp);

        try {
            session.setAttribute("currentUser", temp);
            DBManager.editUser(temp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/profile");
    }
}
