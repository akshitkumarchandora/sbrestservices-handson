package com.cognizant.springlearn.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.dao.EmployeeDao;

@Service
public class EmployeeService {
	
	public ArrayList<Employee> getAllEmployees(){
		return new EmployeeDao().getAllEmployees();
	}
}
