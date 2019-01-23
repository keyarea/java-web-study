package net.fangcun.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.Filter;

/**
 * 此过滤器用来解决全站中文乱码问题
 * @author keyarea
 * @since 2019-1-23 17:26
 */
public class CharacterEncodingFilter implements Filter {

    private FilterConfig filterConfig = null;
    // 设置默认的字符编码
    private String defaultCharset = "UTF-8";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
      throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String charset = filterConfig.getInitParameter("charset");
        if(charset == null){
            charset = defaultCharset;
        }

        req.setCharacterEncoding(charset);
        res.setCharacterEncoding(charset);
        res.setContentType("text/html;charset="+charset);

        MyCharacterEncodingRequest requestWrapper = new MyCharacterEncodingRequest(req);
        filterChain.doFilter(requestWrapper, res);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        // 得到过滤器的初始化配置
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy(){

    }
}

class MyCharacterEncodingRequest extends HttpServletRequestWrapper {

    private HttpServletRequest request;
    MyCharacterEncodingRequest(HttpServletRequest request){
        super(request);
        this.request = request;
    }

    @Override
    public String getParameter(String name){

        try{
            // 获取参数的值
            String value= this.request.getParameter(name);
            if(value == null){
                return null;
            }
            // 如果不是以get方式提交数据，就直接返回获取到的数据
            if(!this.request.getMethod().equalsIgnoreCase("get")) {
                return value;
            }else{
                //如果是以get方式提交数据的，就对获取到的值进行转码处理
                value = new String(value.getBytes("ISO8859-1"),this.request.getCharacterEncoding());
                return value;
            }
        }catch (Exception e){
            throw new RuntimeException(e);

        }
    }
}
