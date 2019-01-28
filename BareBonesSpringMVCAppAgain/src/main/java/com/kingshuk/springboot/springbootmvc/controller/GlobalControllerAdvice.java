package com.kingshuk.springboot.springbootmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import com.kingshuk.springboot.springbootmvc.validator.EmployeeValidator;

@ControllerAdvice(annotations = Controller.class)
public class GlobalControllerAdvice {

    @Autowired
    private EmployeeValidator employeeValidator;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        System.out.println("Inside the init binder method");
        dataBinder.addValidators(employeeValidator);
    }

    @ExceptionHandler({RuntimeException.class, IllegalArgumentException.class,
            NullPointerException.class})
    public String handleExceptions(Model theModel){
        theModel.addAttribute("errorMessage",
                "There was an error while processing the form");
        return "common/error-handler";
    }

}
