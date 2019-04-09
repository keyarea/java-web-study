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

@WebServlet(urlPatterns = "/admin/article")
public class AdminArticleUIServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        IArticleService articleService = ArticleServiceImpl.getInstance();

        // 查找到全部的文章
        Article[] articles = articleService.find();
        // 给文章数组全部添加上该有的分类
        articles = articleService.addCategory(articles);
        // 给文章数组全部添加上该有的作者
        articles = articleService.addAuthor(articles);
        // 给文章数组全部添加上该有的标签
        articles = articleService.addTags(articles);
        // 将这个文章数组添加到请求对象上
        request.setAttribute("articles", articles);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/page/admin-article.jsp");
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        doGet(request, response);
    }
}
