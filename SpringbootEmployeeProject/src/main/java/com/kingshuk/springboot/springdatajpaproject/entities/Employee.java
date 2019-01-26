package com.kingshuk.springboot.springdatajpaproject.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.kingshuk.springboot.springdatajpaproject.dto.EmployeeDto;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeId;

	private String firstName;

	private String lastName;

	@ManyToOne(cascade = { CascadeType.PERSIST})
	@JoinColumn(name = "department_id")
	private Department department;

	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "address_id")
	private Address address;

	public Employee() {

	}

	public Employee(EmployeeDto employeeDto, Address address, Department department) {
		this.firstName = employeeDto.getFirstName();
		this.lastName = employeeDto.getLastName();
		this.employeeId = employeeDto.getEmployeeId();
		this.address = address;
		this.department = department;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", department=" + department + ", address=" + address + "]";
	}

}
