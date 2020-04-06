package com.kingshuk.springboot.springdatajpaproject.unittest;

import org.junit.Test;

import com.kingshuk.springboot.springdatajpaproject.dto.EmployeeDto;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.BusinessKeyMustExistRule;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.BusinessIdentityTester;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

public class PojoValidatorTest {

	private String packagePath = "com.kingshuk.springboot.springdatajpaproject.dto";

	@Test
	public void testPojosInAllPackages() {
		Validator validator = ValidatorBuilder.create()
				.with(new SetterMustExistRule(), 
					  new GetterMustExistRule())
				.with(new SetterTester(), 
					  new GetterTester()).build();
		validator.validate(packagePath);
	}
	
	@Test
	public void testEmployeePojo() {
		PojoClass personPojo = PojoClassFactory.getPojoClass(EmployeeDto.class);
		
		Validator validator = ValidatorBuilder.create()
				.with(new SetterMustExistRule(), 
						  new GetterMustExistRule(),
						  new BusinessKeyMustExistRule())
				.with(new SetterTester(), new GetterTester(), new BusinessIdentityTester())
				.build();
		
		validator.validate(personPojo);
	}
	
	

}
