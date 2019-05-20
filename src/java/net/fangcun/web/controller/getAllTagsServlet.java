package net.fangcun.web.controller;

import net.fangcun.domain.Tag;
import net.fangcun.service.ITagService;
import net.fangcun.service.impl.TagServiceImpl;
import org.json.JSONObject;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "getAllTagsServlet", urlPatterns = "/getAllTag")
public class getAllTagsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建标签服务接口对象
        ITagService tagService = TagServiceImpl.getInstance();

        // 获取所有标签
        Tag[] tags = tagService.find();

        JSONArray res = new JSONArray();
        for (Tag tag : tags){
            JSONObject resItem = new JSONObject();
            resItem.put("id", tag.getId());
            resItem.put("name", tag.getName());
            res.put(resItem);
        }
        response.setContentType("application/json;charset=utf-8");

        PrintWriter out = response.getWriter();
        out.print(res);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
