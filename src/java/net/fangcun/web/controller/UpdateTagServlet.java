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

@WebServlet(urlPatterns = "/admin/updateTag")
public class UpdateTagServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{
        String id = request.getParameter("id");
        String name = request.getParameter("name");

        if(id == null || name == null){
            response.sendError(400);
        }

        Tag tag = new Tag();
        tag.setId(id);
        tag.setName(name);

        ITagService tagService = TagServiceImpl.getInstance();

        boolean result = tagService.update(tag);

        response.setContentType("application/json;charset=utf-8");
        JSONObject jsonObject = new JSONObject();

        if(result){
            jsonObject.put("result", true);
            jsonObject.put("message", "成功更新标签！");
        }else{
            jsonObject.put("result", false);
            jsonObject.put("message", "更新标签失败！");
        }

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
