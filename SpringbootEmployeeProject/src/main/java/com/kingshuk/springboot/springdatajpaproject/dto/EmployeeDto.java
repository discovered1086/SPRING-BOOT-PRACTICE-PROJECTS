package com.kingshuk.springboot.springdatajpaproject.dto;

import com.openpojo.business.BusinessIdentity;
import com.openpojo.business.annotation.BusinessKey;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {

	private long employeeId;

	@BusinessKey(caseSensitive = false, required = true)
	private String firstName;

	@BusinessKey(caseSensitive = false, required = true)
	private String lastName;

	private DepartmentDto department;

	private AddressDto address;

	public long getEmployeeId() {
		return employeeId;
	}

	@Override
	  public int hashCode() {
	    return BusinessIdentity.getHashCode(this);
	  }

	  @Override
	  public boolean equals(final Object obj) {
	    return BusinessIdentity.areEqual(this, obj);
	  }

	  @Override
	  public String toString() {
	    return BusinessIdentity.toString(this);
	  }

}
