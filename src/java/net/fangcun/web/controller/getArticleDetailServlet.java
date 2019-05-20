package net.fangcun.web.controller;

import net.fangcun.dao.IArticleDao;
import net.fangcun.domain.Article;
import net.fangcun.domain.Category;
import net.fangcun.domain.Tag;
import net.fangcun.service.IArticleService;
import net.fangcun.service.ICategoryService;
import net.fangcun.service.ITagService;
import net.fangcun.service.impl.ArticleServiceImpl;
import net.fangcun.service.impl.CategoryServiceImpl;
import net.fangcun.service.impl.TagServiceImpl;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "getArticleDetailServlet", urlPatterns = "/admin/getArticleDetail")
public class getArticleDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        if(id == null){
            response.sendError(400, "错误的请求参数!!");
        }


        int articleID = Integer.parseInt(id);

        IArticleService articleService = ArticleServiceImpl.getInstance();
        Article article = articleService.find(articleID);

        article = articleService.addTags(article);
        article = articleService.addCategory(article);


        ITagService tagService = TagServiceImpl.getInstance();
        Tag[] tags = tagService.find();

        JSONObject res = new JSONObject();



        String categoryJSON = article.getCategory().getId();
        res.put("category", categoryJSON);

        JSONArray tagJson = this.addTags(article.getTags());

        res.put("tag", tagJson);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json;charset=utf-8");
        out.print(res);
        out.flush();
        out.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private JSONArray addTags(Tag[] tags){
        JSONArray jsonArray = new JSONArray();
        for (Tag tag:tags){
            jsonArray.put(tag.getId());
        }
        return jsonArray;
    }


}
