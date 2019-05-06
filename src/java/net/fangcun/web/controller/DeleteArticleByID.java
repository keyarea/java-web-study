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
        String articleID = request.getParameter("id");
        if(articleID == null){
            response.setStatus(400);
        }

        try{
            int id = Integer.parseInt(articleID);
            boolean result = ArticleServiceImpl.getInstance().deleteArticle(id);

            if (result) {
                response.setStatus(200);
            }else {
                throw new Exception("删除文章失败");
            }
        }catch (Exception e){
            response.setStatus(500);
        }
    }
}
