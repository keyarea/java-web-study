package net.fangcun.web.controller;

import net.fangcun.domain.Article;
import net.fangcun.domain.Category;
import net.fangcun.domain.Tag;
import net.fangcun.service.IArticleService;
import net.fangcun.service.ICategoryService;
import net.fangcun.service.ITagService;
import net.fangcun.service.impl.ArticleServiceImpl;
import net.fangcun.service.impl.CategoryServiceImpl;
import net.fangcun.service.impl.TagServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "insertArticleServlet", urlPatterns = "/admin/insertArticle")
public class insertArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String categoryID = request.getParameter("category");
        String content = request.getParameter("content");
        String[] tagsID = request.getParameterValues("tags");

        if(title == null || categoryID == null || content == null || tagsID == null){
            response.sendError(400);
        }

        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);

        if(!categoryID.trim().equals("")){
            ICategoryService categoryService = CategoryServiceImpl.getInstance();
            Category category = categoryService.find(Integer.parseInt(categoryID));
            article.setCategory(category);
        }

        if(tagsID.length != 0){
            ArrayList<Tag> tagList = new ArrayList<>();
            ITagService tagService = TagServiceImpl.getInstance();
            for(String tagID: tagsID){
                if(!tagID.trim().equals("")){
                    Tag tag = tagService.find(Integer.parseInt(tagID));
                    tagList.add(tag);
                }
            }
            Tag[] tags = tagList.toArray(new Tag[0]);
            article.setTags(tags);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
