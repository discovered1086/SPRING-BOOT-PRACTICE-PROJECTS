package com.kingshuk.springboot.springdatajpaproject.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.kingshuk.springboot.springdatajpaproject.entities.Employee;

public interface EmployeeManagementRepository extends JpaRepository<Employee, Long> {
	
	public Optional<Employee> findByFirstNameAndLastName(String firstName, String lastName);

}
