package net.fangcun.web.controller;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 生成随机图片，用来作为验证码
 */

@WebServlet(urlPatterns = "/getVerifyCode")
public class VerifyCodeServlet extends HttpServlet {
    private static final long serialVersionUID = 3038623696184546092L;

    public static final int WIDTH = 60; // 生成图片的宽度
    public static final int HEIGHT = 30; // 生成图片的高度
    private static final String DICTIONARY = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789abcdefghijklmnpqrstuvwxyz";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 随机类
        Random random = new Random();

        // 1. 创建图片数据缓存区域（核心类）
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB); // 创建一个彩色图片

        // 2. 获得画板（图片，ps图层）,绘画对象。
        Graphics g = image.getGraphics();

        // 3. 选择颜色，画矩形3，4步是画一个有内外边框的效果
        g.setColor(Color.BLACK);
        g.fillRect(0,0,WIDTH,HEIGHT);

        // 4. 白色边框
        g.setColor(Color.WHITE);
        g.fillRect(1,1,WIDTH-2, HEIGHT-2);

        // 提供缓存区域,便于写入session
        StringBuilder builder = new StringBuilder();

        // 5. 生成4个随机字符
        g.setFont(new Font("宋体", Font.BOLD&Font.ITALIC, 20));

        for(int i = 0; i < 4; i++){
            // 随机颜色
            g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));

            // 随机字符
            int Index = random.nextInt(DICTIONARY.length());
            String str = DICTIONARY.substring(Index, Index + 1);

            // 缓存
            builder.append(str);

            // 写入
            g.drawString(str, (WIDTH / 6) * (i + 1), 20);
        }

        // 绘制噪点
        for(int j=0,n=random.nextInt(100);j<n;j++){
            g.setColor(Color.RED);
            g.fillRect(random.nextInt(WIDTH), random.nextInt(HEIGHT), 1, 1); // 随机噪音点
        }

        // 获取随机数据，并保存至session
        String tempStr = builder.toString();
        request.getSession().setAttribute("sessionCacheData", tempStr);

        // 生成图片发送到浏览器-- 相当于下载
        ImageIO.write(image, "jpg", response.getOutputStream());


    }


}
