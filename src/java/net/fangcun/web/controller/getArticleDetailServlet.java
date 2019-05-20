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

        ICategoryService categoryService = CategoryServiceImpl.getInstance();
        Category[] categories = categoryService.find();

        Tag[] articleTags = article.getTags();
        Category articleCategory = article.getCategory();

        JSONObject res = new JSONObject();

        JSONArray categoryJson = getSelectedCategory(categories, articleCategory);

        JSONArray tagJson = getSelectedTag(tags, articleTags);

        res.put("category", categoryJson);
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

    private JSONArray getSelectedCategory(Category[] categories, Category selectedCategory){
        JSONArray result = new JSONArray();

        for (Category category : categories){
            JSONObject categoryItem = new JSONObject();
            categoryItem.put("id", category.getId());
            categoryItem.put("name", category.getName());
            categoryItem.put("checked", false);
            if(category.getId().equals(selectedCategory.getId())){
                categoryItem.put("checked", true);
            }
            result.put(categoryItem);
        }
        return result;
    }

    private JSONArray getSelectedTag(Tag[] tags, Tag[] selectedTags){
        JSONArray result = new JSONArray();

        for (Tag tag : tags){
            JSONObject tagItem = new JSONObject();
            tagItem.put("id", tag.getId());
            tagItem.put("name", tag.getName());
            tagItem.put("checked", false);
            if(isExist(tag.getId(), selectedTags)){
                tagItem.put("checked", true);
            }
            result.put(tagItem);
        }

        return result;
    }

    private boolean isExist(String id, Tag[] tags){
        boolean result = false;
        for (Tag tag: tags){
            if(tag.getId().equals(id)){
                result = true;
            }
        }
        return result;
    }

}
