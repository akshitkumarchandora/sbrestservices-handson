package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.exception.EmployeeNotFoundException;

public class EmployeeDao {

	private static ArrayList<Employee> EMPLOYEE_LIST;
	
	static {
		ApplicationContext context=new ClassPathXmlApplicationContext("employee.xml");
		setEMPLOYEE_LIST((ArrayList<Employee>)context.getBean("employeeList"));
		
	}
	public EmployeeDao()
	{
		super();
		
	}
	public static ArrayList<Employee> getAllEmployees() {
		return EMPLOYEE_LIST;
	}

	public static void setEMPLOYEE_LIST(ArrayList<Employee> eMPLOYEE_LIST) {
		EMPLOYEE_LIST = eMPLOYEE_LIST;
	}
	
	public static void updateEmployee(Employee employee) throws EmployeeNotFoundException //throws EmployeeNotFoundException
	{
		boolean flag=false;
		int pos=0;
		for(Employee e:EMPLOYEE_LIST)
		{
			if(e.getId().equals(employee.getId()))
					{
				flag=true;
				break;
					}
			pos++;
		}
		
		if(!flag)
			throw new EmployeeNotFoundException("Employee Not Found");
		else {
			EMPLOYEE_LIST.get(pos).setName(employee.getName());
			EMPLOYEE_LIST.get(pos).setDateOfBirth(employee.getDateOfBirth());
			EMPLOYEE_LIST.get(pos).setPermanent(employee.isPermanent());
			EMPLOYEE_LIST.get(pos).setSalary(employee.getSalary());
		}
		
	}
	
	public static void deleteEmployee(String id) throws EmployeeNotFoundException {
		Employee deleteemp=null;
		for(Employee e:EMPLOYEE_LIST)
		{
			if(e.getId().equals(id))
			{
				deleteemp=e;
				break;
			}
			
		}
		if(deleteemp == null)
		throw new EmployeeNotFoundException("Employee Not Found");
		else
			EMPLOYEE_LIST.remove(deleteemp);
	}
}
