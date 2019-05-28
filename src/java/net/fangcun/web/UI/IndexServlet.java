package net.fangcun.web.UI;

import net.fangcun.domain.Article;
import net.fangcun.domain.Category;
import net.fangcun.domain.Tag;
import net.fangcun.service.IArticleService;
import net.fangcun.service.impl.ArticleServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


//@WebServlet(name = "IndexServlet", urlPatterns = {"^/$","^/popular$", "^/recommend$"}, loadOnStartup = 1)
public class IndexServlet extends HttpServlet {
    final static int PAGE_SIZE = 10;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        // 获取到的uri
        String url = request.getRequestURI();
        // 获取的页数
        String pageIndex = request.getParameter("pageIndex");

        // 如果没有获取到该参数,则认为该值为1
        if(pageIndex == null){
            pageIndex = "1";
        }

        //
        int indexPage = 0;

        // 是否能转换为整数类型,不能转为整数类型则为错误的请求参数
        try {
            indexPage = Integer.valueOf(pageIndex);
        }catch (Exception e){
            e.printStackTrace();
            response.sendError(400);
            return;
        }

        // 文章服务实例对象
        IArticleService articleService = ArticleServiceImpl.getInstance();

        // 文章数量
        int articleCount =  articleService.ArticleCount();

        // 一共多少页
        int pageCount = articleCount / PAGE_SIZE;

        // 超过总页数,或者页数小于1,则返回404错误
        if(indexPage < 1 || indexPage > pageCount){
            response.sendError(404);
            return;
        }

        // 获取的数量
        int limit = PAGE_SIZE;
        int skip = (indexPage -1) * PAGE_SIZE;


        ArrayList<Article> articles = new ArrayList<>();
        switch (url){
            case "/":
                articles = new ArrayList<>(Arrays.asList(articleService.getNewArticles(limit, skip)));
                break;
            case "/recommend":
                articles = new ArrayList<>(Arrays.asList(articleService.getNewArticles(limit, skip)));
                break;
            case "/popular":
                articles = new ArrayList<>(Arrays.asList(articleService.getNewArticles(limit, skip)));
                break;
                default:
                    articles = new ArrayList<>(Arrays.asList(articleService.getNewArticles(limit, skip)));

        }

        // 目前的页数
        request.setAttribute("pageIndex", indexPage);
        // 文章
        request.setAttribute("articles", articles);
        // 总页数
        request.setAttribute("pageCount", pageCount);
        // 总文章数
        request.setAttribute("articlesCount", articleCount);*/

        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/page/index.jsp");
        view.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
