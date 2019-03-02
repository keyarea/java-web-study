package net.fangcun.web.filter;

import net.fangcun.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter", urlPatterns = "/admin/*")
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
    throws IOException, ServletException {

        // 获取request以及response
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // 类包装了ServletResponse，可以进行IO操作，返回数据
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(res);

        // 获取session
        HttpSession session = req.getSession();

        // 登录转向页面
        String loginPath = req.getContextPath() + "/login";

        // 判断session中是否有用户登录，如果有过滤
        User user = (User) session.getAttribute("user");
        if (user != null) {
            filterChain.doFilter(request, response);
            return;
        }
        // 以上条件都不符合，跳转到登录界面
        wrapper.sendRedirect(loginPath);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException{

    }

    @Override
    public void destroy(){

    }
}
