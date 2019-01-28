package com.kingshuk.springboot.springbootmvc.exceptionhandler;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler,
                                         Exception exception) {

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("common/global-error-handler");
        modelAndView.addObject("errorMessage",exception.getMessage()!=null?exception.getMessage():"An error occurred");
        return modelAndView;
    }
}
