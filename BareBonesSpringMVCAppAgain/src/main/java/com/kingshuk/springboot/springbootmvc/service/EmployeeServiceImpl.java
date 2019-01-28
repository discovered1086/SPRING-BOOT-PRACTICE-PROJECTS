package com.kingshuk.springboot.springbootmvc.service;

import org.springframework.stereotype.Service;

import com.kingshuk.springboot.springbootmvc.beans.Address;
import com.kingshuk.springboot.springbootmvc.beans.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl {

    private static Employee employee;

    static {
        employee = new Employee();
    }

    public Employee findEmployee(Integer employeeId) {
        Employee employee1 = new Employee();
        employee1.setFirstName("Kingshuk");
        employee1.setLastName("Mukherjee");
        employee1.setEmployeeId(232649);
        employee1.setEmployeeType("Full Time Employee");

        List<String> roles = new ArrayList<>();
        roles.add("HR");
        employee1.setRoles(roles);

        Address address = new Address();
        address.setAddressLine1("600 Asylum Avenue");
        address.setAddressLine2("Apt - 316");
        address.setCity("Hartford");
        address.setState("CT");
        address.setZip("06105");

        employee1.setAddress(address);
        return employee1;
    }

    public void SaveEmployee(Employee employee1) {
        System.out.println("Saving the object to our employee object");
        employee = employee1;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        Employee employee1 = new Employee();
        employee1.setFirstName("kingshuk");
        employee1.setLastName("Mukherjee");
        employee1.setEmployeeId(232649);
        employee1.setEmployeeType("Full Time Employee");

        List<String> roles = new ArrayList<>();
        roles.add("HR");
        employee1.setRoles(roles);

        Address address = new Address();
        address.setAddressLine1("600 Asylum Avenue");
        address.setAddressLine2("Apt - 316");
        address.setCity("Hartford");
        address.setState("CT");
        address.setZip("06105");

        employee1.setAddress(address);

        Employee employee2 = new Employee();
        employee2.setFirstName("Deeksha");
        employee2.setLastName("Banerjee");
        employee2.setEmployeeId(458798);
        employee2.setEmployeeType("Full Time Employee");

        employee2.setRoles(roles);

        employee2.setAddress(address);

        try {
            employee1.setHireDate(new SimpleDateFormat("MM/dd/yyyy").parse("03/29/2010"));
            employee2.setHireDate(new SimpleDateFormat("MM/dd/yyyy").parse("03/29/2010"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        employees.add(employee1);
        employees.add(employee2);

        return employees;
    }
}
