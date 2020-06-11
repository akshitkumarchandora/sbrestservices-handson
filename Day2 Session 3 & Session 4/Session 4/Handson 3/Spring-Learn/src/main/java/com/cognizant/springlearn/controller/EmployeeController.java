package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@GetMapping("/employees")
	public ArrayList<Employee> getAllEmployees(){
		LOGGER.info("Inside getAllEmployees");
		LOGGER.debug("Employees : {}",employeeService.getAllEmployees());
		return employeeService.getAllEmployees();
	}
}
