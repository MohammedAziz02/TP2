package com.tp2.Interceptors;

import com.tp2.Models.Person;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
public class MyInterceptor1 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("pre handle Inreceptor 1");
        Person p1=(Person) request.getSession().getAttribute("p1");
        if(p1==null){
            request.getSession().setAttribute("message","error person n'existe pas dans la session");
            response.sendRedirect(request.getContextPath()+"/error"); // redirect to error page
            return false;
        }
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post handle Interceptor 1");
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
        System.out.println("afterCompletion handle Interceptor 1");
    }
}
