package com.kingshuk.springboot.business;

import com.kingshuk.springboot.dataaccess.SpringBootDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpringBootService {


    private SpringBootDAO springBootDAO;

    @Autowired
    public SpringBootService(SpringBootDAO springBootDAO) {
        System.out.println("Service class constructor called....");
        this.springBootDAO = springBootDAO;
    }

    public void callPrinting(){
        System.out.println("Calling the dao for printing");
        springBootDAO.simplePrint();
    }
}
