package net.fangcun.web.UI;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 分类页面
 */
@WebServlet(urlPatterns = "/category")
public class CategoryUIServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{

        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/page/category.jsp");

        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{
        doGet(request, response);
    }

}
