package com.kingshuk.springboot.springdatajpaproject.dto;

public class DepartmentDto {
	
	
	private long departmentId;
	
	private String departmentName;

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "DepartmentDto [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}
	
	
	
	

}
