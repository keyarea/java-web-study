package net.fangcun.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 实验输出一个html页面（输出字符数据）
 * 对于输出，你有两个选择，字符还是字节，ServletOutputStream用于输出字节，PrintWriter用于输出字符数据
 * @author keyarea
 * @since 2019-1-24 7:07pm
 */
@WebServlet(urlPatterns = "/getHelloWorld")
public class GetHelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        // 设置请求以及响应的内容类型以及编码方式：
        // response.setContentType("text/html;charset=UTF-8");
        // request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        // 获取一个输出流
        PrintWriter out = response.getWriter();

        // 向输出流中写入
        out.println("<h1>hello world!!</h1>");

        // 强制数据输出，清空缓存区
        out.flush();

        // 关闭流
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        doGet(request, response);
    }
}
