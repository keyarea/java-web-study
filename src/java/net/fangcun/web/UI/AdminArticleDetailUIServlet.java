package net.fangcun.web.UI;

import net.fangcun.domain.Article;
import net.fangcun.domain.Category;
import net.fangcun.domain.Tag;
import net.fangcun.service.IArticleService;
import net.fangcun.service.ICategoryService;
import net.fangcun.service.ITagService;
import net.fangcun.service.impl.ArticleServiceImpl;
import net.fangcun.service.impl.CategoryServiceImpl;
import net.fangcun.service.impl.TagServiceImpl;

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
                request.setAttribute("article", article);
            }
        }
        ICategoryService categoryService = CategoryServiceImpl.getInstance();
        Category[] categories = categoryService.find();
        request.setAttribute("categories", categories);

        ITagService tagService = TagServiceImpl.getInstance();
        Tag[] tags = tagService.find();
        request.setAttribute("tags", tags);


        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/page/admin-article-detail.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        doPost(request, response);
    }
}
