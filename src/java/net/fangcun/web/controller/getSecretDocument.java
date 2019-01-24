package net.fangcun.web.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 实验输出一个文件（输出字节流数据）
 * 对于输出，你有两个选择，字符还是字节，ServletOutputStream用于输出字节，PrintWriter用于输出字符数据
 * @author keyarea
 * @since 2019-01-24 7:36pm
 */
@WebServlet(urlPatterns = "/getSecretDocument")
public class getSecretDocument extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // 设置返回文件类型
        response.setContentType("mage/jpeg");

        // 获取应用上下文
        ServletContext ctx = getServletContext();

        // 这表示这个资源给我一个输入流
        InputStream is = ctx.getResourceAsStream("/WEB-INF/secretDocument.jpeg");

        int read = 0;
        byte[] bytes = new byte[1024];


        OutputStream out = response.getOutputStream();
        while ((read = is.read(bytes)) != -1){
            out.write(bytes, 0, read);
        }
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }
}
