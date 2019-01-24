package net.fangcun.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.Filter;

/**
 * 此过滤器用来解决全站中文乱码问题
 * @author keyarea
 * @since 2019-1-23 17:26
 */
@WebFilter(filterName = "CharacterEncodingFilter", urlPatterns = "/*")
public class CharacterEncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
      throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        req.setCharacterEncoding("utf-8");
        res.setCharacterEncoding("utf-8");

        filterChain.doFilter(req , res);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
    }

    @Override
    public void destroy(){

    }
}

