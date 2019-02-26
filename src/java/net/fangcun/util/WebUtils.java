package net.fangcun.util;

import com.mchange.v2.beans.BeansUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 把request对象中的请求参数封装到bean中
 */
public class WebUtils {

    public static <T> T request2Bean(HttpServletRequest request, Class<T> tClass){
        try{
            T bean =  tClass.newInstance();
            Enumeration<String> e = request.getParameterNames();
            while (e.hasMoreElements()){
                String name = (String) e.nextElement();
                String value = request.getParameter(name);
                BeanUtils.setProperty(bean, name, value);
            }
            return bean;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
