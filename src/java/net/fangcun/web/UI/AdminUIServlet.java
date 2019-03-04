package net.fangcun.web.UI;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 管理页面
 */
@WebServlet(urlPatterns = {"/admin","/admin/user","/admin/article","/admin/category","/admin/tag","/admin/comment","/admin/notice"})
public class AdminUIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println(request.getRequestURI());
        String contentPage = getContentPageByURI(request.getRequestURI());
        request.setAttribute("contentPage",contentPage);
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/page/admin.jsp");

        System.out.println("hhhhh");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

    public String getContentPageByURI(String URI){
        String contentPage = "";
        switch (URI){
            case "/admin":
                contentPage = "_partial/admin/overview.jsp";
                break;
            case "/admin/user":
                contentPage = "_partial/admin/user.jsp";
                break;
            case "/admin/article":
                contentPage = "_partial/admin/article.jsp";
                break;
            case "/admin/category":
                contentPage = "_partial/admin/category.jsp";
                break;
            case "/admin/tag":
                contentPage = "_partial/admin/tag.jsp";
                break;
            case "/admin/comment":
                contentPage = "_partial/admin/comment.jsp";
                break;
            case "/admin/notice":
                contentPage = "_partial/admin/notice.jsp";
                break;
        }
        return contentPage;
    }


}
