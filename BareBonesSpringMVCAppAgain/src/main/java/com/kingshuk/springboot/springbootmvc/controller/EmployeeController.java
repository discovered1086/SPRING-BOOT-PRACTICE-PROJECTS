package com.kingshuk.springboot.springbootmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kingshuk.springboot.springbootmvc.beans.Address;
import com.kingshuk.springboot.springbootmvc.beans.Employee;
import com.kingshuk.springboot.springbootmvc.service.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/employee")
@SessionAttributes("employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/findEmployeePage")
    public String findEmployeePage(Model theModel){
        theModel.addAttribute("theEmployee",employeeService.findEmployee(232649));
        return "find_employee";
    }

    /*@RequestMapping("/find/{empId}")
    public @ResponseBody Employee findEmployee(@PathVariable("empId") Integer employeeId){
        System.out.println("Inside the find employee method");
        return employeeService.findEmployee(employeeId);
    }*/

    @RequestMapping("/getEmployees")
    public String getAllEmployees(Model theModel){
        theModel.addAttribute("allEmployees",employeeService.getAllEmployees());

        return "all_employee";
    }

    @RequestMapping("/find/{empId}")
    public @ResponseBody
    Employee findEmployee(@PathVariable("empId") Integer employeeId){
        System.out.println("Inside the find employee method for the employee id "+employeeId);
        return employeeService.findEmployee(employeeId);
    }

    @GetMapping("/add")
    public String addEmployeePage(@ModelAttribute("theEmployee") Employee employee,
                                  Model theModel) {

        System.out.println("The employee Object "+employee);
        //System.out.println("The message: "+message);
        theModel.addAttribute("theEmployee",employee);
        //theModel.addAttribute("message","true");
        return "add_employee";
    }

    @ModelAttribute("employee")
    public Employee getNewEmployee() {
        Employee employee = new Employee();
        Address address = new Address();

        employee.setAddress(address);

        return employee;
    }

    @PostMapping("/review")
    public String reviewEmployee(@ModelAttribute @Validated Employee employee,
                                 BindingResult result) {

        if(result.hasErrors()){
            System.out.println("A validation error occurred");
            return "add_employee";
        }else{
            System.out.println("Everything is fine, let's go to the review page");
            return "review_employee";
        }

    }

    @RequestMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee,
                               SessionStatus sessionStatus,
                               RedirectAttributes redirectAttributes) {
        System.out.println(employee);
        sessionStatus.setComplete();
        //redirectAttributes.addAttribute("successMessage","The employee was added successfully");

        redirectAttributes.addFlashAttribute("theEmployee",employee);
        redirectAttributes.addAttribute("successMessage","true");

        //throw new RuntimeException("An error occurred while processing your request");
        employeeService.SaveEmployee(employee);
        return "redirect:/employee/add";
    }

    /*@ExceptionHandler({RuntimeException.class, IllegalArgumentException.class})
    public String handleExceptions(Model theModel){
        theModel.addAttribute("errorMessage",
                "There was an error while processing the form");
        return "common/error-handler";
    }*/

    @ModelAttribute("employeeTypes")
    public List<String> employeeType() {
        return new ArrayList<>(Arrays.asList("Full Time Employee", "Part Time Employee", "Contractor/Vendor"));
    }

    @ModelAttribute("employeeRoles")
    public List<String> employeeRoles() {
        return new ArrayList<>(Arrays.asList("HR", "Assistant Vice President", "Technical Lead", "Project Manager", "Developer", "QA Tester"));
    }



}