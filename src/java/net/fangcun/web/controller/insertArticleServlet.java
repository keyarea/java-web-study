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

        if(title == null || content == null ){
            response.sendError(400);
            return;
        }

        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);

        IArticleService articleService = ArticleServiceImpl.getInstance();


        if(categoryID != null && !categoryID.trim().equals("")){
            Category category = new Category();
            category.setId(categoryID);
            article.setCategory(category);
        }

        if(tagsID != null && tagsID.length != 0){
            ArrayList<Tag> tagList = new ArrayList<>();
            ITagService tagService = TagServiceImpl.getInstance();
            for(String tagID: tagsID){
                if(!tagID.trim().equals("")){
                   Tag tag = new Tag();
                   tag.setId(tagID);
                   tagList.add(tag);
                }
            }
            Tag[] tags = tagList.toArray(new Tag[0]);
            article.setTags(tags);
        }
        articleService.insert(article);
        response.setStatus(200);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
