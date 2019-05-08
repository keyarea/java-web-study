package net.fangcun.web.controller;

import net.fangcun.dao.ITagDao;
import net.fangcun.service.ITagService;
import net.fangcun.service.impl.TagServiceImpl;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/admin/deleteTag")
public class DeleteTagByID extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{
        String regExp = "^\\d+$";
        String TagId = request.getParameter("id");

        boolean access = Pattern.matches(regExp, TagId);

        if(!access) {
            response.sendError(400, "错误的请求参数");
        }

        try{
            ITagService tagService = TagServiceImpl.getInstance();
            boolean result = tagService.delete(Integer.parseInt(TagId));

            if(result){
                response.setStatus(200);
            }else{
                throw new Exception("删除标签失败!");
            }
        }catch (Exception e){
            response.sendError(500, e.getMessage());
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        doPost(request, response);
    }
}
