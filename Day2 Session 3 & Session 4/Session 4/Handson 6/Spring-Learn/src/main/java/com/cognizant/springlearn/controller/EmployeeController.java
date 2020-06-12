package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.exception.EmployeeNotFoundException;
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
	
	@PutMapping("/employees")
	public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException
	{
		LOGGER.info("INSIDE updateemployee in Controller");
		employeeService.updateEmployee(employee);
		LOGGER.debug(employee.toString());
		LOGGER.info("END");
		
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable String id) throws EmployeeNotFoundException //throws EmployeeNotFoundException
	{
		LOGGER.info("Inside delete Employee in Controller");
		employeeService.deleteEmployee(id);
		LOGGER.info("end");
	}
	
}
