package com.cognizant.springlearn.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {
	
	public ArrayList<Employee> getAllEmployees(){
		return  EmployeeDao.getAllEmployees();
	}
	
	public void updateEmployee(Employee employee)throws EmployeeNotFoundException{
		EmployeeDao.updateEmployee(employee);
	}
}
