package net.fangcun.web.UI;

import net.fangcun.dao.impl.UserDaoImpl;
import net.fangcun.domain.User;
import net.fangcun.service.IUserService;
import net.fangcun.service.impl.UserServiceImpl;

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
            // 得到用户服务实例
            IUserService userService = UserServiceImpl.getInstance();
            // 调用用户服务方法，查找全部用户
            User[] users = userService.findAllUsers();
            // 将得到的全部用户设置于请求上
            request.setAttribute("users", users);
            // 调用jsp
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/page/admin-user.jsp");

            view.forward(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            doGet(request, response);
        }



}
