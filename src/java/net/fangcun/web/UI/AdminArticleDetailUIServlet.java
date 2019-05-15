package net.fangcun.web.UI;

import net.fangcun.domain.Article;
import net.fangcun.service.IArticleService;
import net.fangcun.service.impl.ArticleServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/articleDetail")
public class AdminArticleDetailUIServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{
        String id = request.getParameter("id");

        if(id != null){
            IArticleService articleService = ArticleServiceImpl.getInstance();
            Article article = articleService.find(Integer.parseInt(id));
            if(article != null){
                article = articleService.addCategory(article);
                article = articleService.addAuthor(article);
                article = articleService.addTags(article);
                request.setAttribute("article", article);
            }
        }


        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/page/admin-article-detail.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        doPost(request, response);
    }
}
