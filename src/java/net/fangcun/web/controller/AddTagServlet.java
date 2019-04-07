package net.fangcun.web.controller;

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

@WebServlet(urlPatterns = "/admin/addTag")
public class AddTagServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        String name = request.getParameter("name");

        if(name == null){
            response.sendError(400);
        }

        ITagService tagService = TagServiceImpl.getInstance();
        boolean result = tagService.add(name);

        response.setContentType("application/json;charset=utf-8");

        JSONObject jsonObject = new JSONObject();
        if(result){
            jsonObject.put("result", true);
            jsonObject.put("message", "添加标签成功！");
        }else{
            jsonObject.put("result", false);
            jsonObject.put("message", "添加标签失败！");
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
