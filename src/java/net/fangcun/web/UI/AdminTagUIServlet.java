package net.fangcun.web.UI;

import net.fangcun.domain.Tag;
import net.fangcun.service.ITagService;
import net.fangcun.service.impl.TagServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/tag")
public class AdminTagUIServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        ITagService tagService = TagServiceImpl.getInstance();
        Tag[] tags = tagService.find();
        tags = tagService.addArticles(tags);
        request.setAttribute("tags", tags);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/page/admin-tag.jsp");
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }
}
