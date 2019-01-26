package com.kingshuk.springboot.springdatajpaproject.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.common.base.Optional;
import com.kingshuk.springboot.springdatajpaproject.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	public Optional<Department> findByDepartmentName(String departmentName);

}
