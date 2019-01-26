package com.kingshuk.springboot.springdatajpaproject.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.common.base.Optional;
import com.kingshuk.springboot.springdatajpaproject.entities.Employee;

public interface EmployeeManagementRepository extends JpaRepository<Employee, Long> {
	
	public Optional<Employee> findByFirstNameAndLastName(String firstName, String lastName);

}
