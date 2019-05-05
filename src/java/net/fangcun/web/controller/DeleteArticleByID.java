package net.fangcun.web.controller;

import net.fangcun.dao.IArticleDao;
import net.fangcun.service.IArticleService;
import net.fangcun.service.impl.ArticleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/admin/deleteArticle")
public class DeleteArticleByID extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pattern = "^\\d+$";
        String articleID = request.getParameter("id");

        boolean access = Pattern.matches(pattern, articleID);

        if(!access){
            response.setStatus(400);
        }

        try{
            int id = Integer.parseInt(articleID);
            boolean result = ArticleServiceImpl.getInstance().deleteArticle(id);

            if (result) {
                response.setStatus(200);
            }else {
                throw new Exception("删除分类失败");
            }
        }catch (Exception e){
            response.setStatus(500);
        }
    }
}
