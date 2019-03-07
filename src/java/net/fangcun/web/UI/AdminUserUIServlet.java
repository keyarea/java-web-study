package net.fangcun.web.UI;

import net.fangcun.dao.impl.UserImpl;
import net.fangcun.domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/user")
public class AdminUserUIServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            User[] users = UserImpl.getInstance().findPartUsers(0,10);
            request.setAttribute("users", users);
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/page/admin-user.jsp");

            view.forward(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            doGet(request, response);
        }



}
