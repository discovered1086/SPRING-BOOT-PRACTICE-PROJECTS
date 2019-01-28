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
	
	public Employee(EmployeeDto employeeDto) {
		this.firstName = employeeDto.getFirstName();
		this.lastName = employeeDto.getLastName();
		this.employeeId = employeeDto.getEmployeeId();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	

}
