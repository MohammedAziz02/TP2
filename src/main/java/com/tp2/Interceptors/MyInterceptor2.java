package com.tp2.Interceptors;

import com.tp2.Models.Person;
import com.tp2.utils.AgeCalculator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor2 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("pre handle Interceptor 2");
        Person p1=(Person) request.getSession().getAttribute("p1");

        System.out.println("AGE  ----------> "+AgeCalculator.calculateAge(p1.getDate_naiss()));
        if (AgeCalculator.calculateAge(p1.getDate_naiss())<18){
            request.getSession().setAttribute("message","person existe ms il a un age < 18");
            response.sendRedirect(request.getContextPath()+"/error"); // redirect to error page
            return false;
        }


        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post handle Interceptor 2");
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
        System.out.println("afterCompletion handle Interceptor 2");
    }
}
