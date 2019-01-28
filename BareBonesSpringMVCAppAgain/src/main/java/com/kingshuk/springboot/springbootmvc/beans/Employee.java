package com.kingshuk.springboot.springbootmvc.beans;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

//@XmlRootElement(name="employee")
public class Employee {

    private String firstName, lastName, employeeType;

    private Address address;

    @NotNull(message = "Employee ID can't be empty")
    private Integer employeeId;

    private List<String> roles;

    public String getFirstName() {
        return firstName;
    }

    private Date hireDate;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public List<String> getRoles() {
        return roles;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", employeeType='").append(employeeType).append('\'');
        sb.append(", address=").append(address);
        sb.append(", employeeId=").append(employeeId);
        sb.append(", roles=").append(roles);
        sb.append(", hireDate=").append(hireDate);
        sb.append('}');
        return sb.toString();
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

}
