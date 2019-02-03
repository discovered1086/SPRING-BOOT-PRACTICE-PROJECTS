package com.kingshuk.springboot.springdatajpaproject.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeControllerAspects {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeControllerAspects.class);
	
	
	/*
	 * Here essentially what I'm saying is that execute this method when a call has been made to the method
	 * getEmployeeByEmployeeId() in the class EmployeeManagementController
	 */
	@Before("execution(* com.kingshuk.springboot.springdatajpaproject.controller.EmployeeManagementController.getEmployeeByEmployeeId(..))")
	public void logGetEmployeeByEmployeeId(JoinPoint joinPoint) {
		Long empId = (Long)joinPoint.getArgs()[0];
		
		if(LOGGER.isInfoEnabled()) {
			LOGGER.info(String.format("Request for employee with employee id: %s", empId));	
		}
		

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(String.format("Request for employee with employee id: %s", empId));
		}
	}
	
	
	/*
	 * Here what I'm saying is that execute this method when a call has been made to any method in the class EmployeeManagementController
	 * that starts with the word delete (we know there's just one such method) and there's argument type that matches a long value.
	 * the name 'empId' here does not have to match with the exact name in the controller.
	 * It can be anything.
	 * The 'args' part helps us avoid the extraction of argument from the join point and casting and all that
	 */
	@Before("execution(* com.kingshuk.springboot.springdatajpaproject.controller.EmployeeManagementController.delete*(..))"
			+ " && args(empId)")
	public void logDeleteEmployeeByEmployeeId(long empId) {
				
		if(LOGGER.isInfoEnabled()) {
			LOGGER.info(String.format("Request for deleting the employee with employee id: %s", empId));	
		}
		

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(String.format("Request for deleting employee with employee id: %s", empId));
		}
	}

}
