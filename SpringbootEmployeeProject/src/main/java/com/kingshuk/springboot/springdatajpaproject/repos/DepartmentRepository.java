package com.kingshuk.springboot.springdatajpaproject.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kingshuk.springboot.springdatajpaproject.entities.Department;

@RepositoryRestResource
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	public Optional<Department> findByDepartmentName(String departmentName);

}
