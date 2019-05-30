package net.fangcun.web.controller;

import net.fangcun.domain.Article;
import net.fangcun.service.IArticleService;
import net.fangcun.service.impl.ArticleServiceImpl;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet(name = "ListNewArticleServlet", urlPatterns = "/listNewArticle")
public class ListNewArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 得到页数
        String page = request.getParameter("page");

        // 如果没有获取到该参数,则认为该值为1
        if(page == null){
            page = "1";
        }
        String pageSize = getServletContext().getInitParameter("pageSize");

        int indexPage;
        // 是否能转换为整数类型,不能转为整数类型则为错误的请求参数
        try {
            indexPage = Integer.valueOf(page);
        }catch (Exception e){
            e.printStackTrace();
            response.sendError(400, "错误的请求参数");
            return;
        }
        // 文章服务实例对象
        IArticleService articleService = ArticleServiceImpl.getInstance();
        // 验证参数是否在范围内
        boolean verify = articleService.verifyPage(indexPage, Integer.parseInt(pageSize));
        if(!verify){
            response.sendError(404, "参数不在范围内");
            return;
        }

        // 获取的数量
        int limit = Integer.parseInt(pageSize);
        int skip = (indexPage -1) * limit;

        // 获取文章
        ArrayList<Article> articles = new ArrayList<>();
        articles = new ArrayList<>(Arrays.asList(articleService.getNewArticles(limit, skip)));
        JSONArray result = new JSONArray(articles);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
