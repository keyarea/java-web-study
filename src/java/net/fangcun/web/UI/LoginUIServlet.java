package net.fangcun.web.UI;


import net.fangcun.domain.User;
import net.fangcun.service.impl.UserServiceImpl;
import net.fangcun.util.WebUtils;
import net.fangcun.web.formbean.LoginFormBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/login")
public class LoginUIServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if(user != null){
            response.sendRedirect("/admin");
        }else{
            // 请求调度器
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/page/login.jsp");

            // 提供调度request到另一个资源（servlet/jsp/html）的功能
            view.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        //将客户端提交的表单数据封装到LoginFormBean对象中
        LoginFormBean formBean = WebUtils.request2Bean(request, LoginFormBean.class);


        // 校验用户注册填写的表单数据
        if(!formBean.validate()){  // 如果校验失败
            //将封装了用户填写的表单数据的formbean对象发送回login.jsp页面的form表单中进行显示
            request.setAttribute("formBean", formBean);
            //校验失败就说明是用户填写的表单数据有问题，那么就跳转回login.jsp
            request.getRequestDispatcher("/WEB-INF/page/login.jsp").forward(request, response);

            return;
        }

        // 校验验证码

        // 获取存储在session中的验证码信息
        String rightVerifyCode = request.getSession().getAttribute("sessionCacheData").toString();

        if(!formBean.getVerifyCode().equalsIgnoreCase(rightVerifyCode)){
            Map<String, String> errors =  new HashMap<String, String>();
            errors.put("verifyCode", "验证码输入错误");
            formBean.setErrors(errors);

            //将封装了用户填写的表单数据的formbean对象发送回login.jsp页面的form表单中进行显示
            request.setAttribute("formBean", formBean);
            //校验失败就说明是用户填写的表单数据有问题，那么就跳转回login.jsp
            request.getRequestDispatcher("/WEB-INF/page/login.jsp").forward(request, response);

            return;
        }


        UserServiceImpl userService = UserServiceImpl.getInstance();


        String name = formBean.getName();
        String password = formBean.getPassword();

        // 用户登录
        User user = userService.loginUser(name, password);

        //  用户登录
        if(user == null){
            Map<String, String> errors =  new HashMap<String, String>();
            errors.put("name", "用户名或密码输入错误");
            errors.put("password", "用户名或密码输入错误");
            formBean.setErrors(errors);

            //将封装了用户填写的表单数据的formbean对象发送回login.jsp页面的form表单中进行显示
            request.setAttribute("formBean", formBean);
            //校验失败就说明是用户填写的表单数据有问题，那么就跳转回login.jsp
            request.getRequestDispatcher("/WEB-INF/page/login.jsp").forward(request, response);

            return;
        }
        //登录成功后，就将用户存储到session中
        request.getSession().setAttribute("user", user);
        response.sendRedirect("/admin");

    }

}
