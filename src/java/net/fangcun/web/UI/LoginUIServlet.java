package net.fangcun.web.UI;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginUIServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        // 请求调度器
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/page/login.jsp");

        // 提供调度request到另一个资源（servlet/jsp/html）的功能
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        System.out.println(name);
        System.out.println(password);
        // 请求调度器
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/page/login.jsp");

        // 提供调度request到另一个资源（servlet/jsp/html）的功能
        view.forward(request, response);
    }

}
