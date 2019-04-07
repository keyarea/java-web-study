package net.fangcun.web.controller;

import net.fangcun.domain.Tag;
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

@WebServlet(urlPatterns = "/admin/getTag")
public class FindTagByID extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{
        String id = request.getParameter("id");

        if(id == null){
            response.sendError(400, "请求的参数错误");
        }

        ITagService tagService = TagServiceImpl.getInstance();
        Tag tag = tagService.find(Integer.parseInt(id));

        if(tag == null){
            response.sendError(404);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", tag.getId());
        jsonObject.put("name", tag.getName());

        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(jsonObject);
        writer.flush();
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        doPost(request, response);
    }
}
