package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.Department;

public class DepartmentDao {
	private static ArrayList<Department> DEPARTMENT_LIST;

	public DepartmentDao() {
		super();
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		this.setDEPARTMENT_LIST((ArrayList<Department>) context.getBean("departmentList"));
	}

	public static ArrayList<Department> getAllDepartments() {
		return DEPARTMENT_LIST;
	}

	public static void setDEPARTMENT_LIST(ArrayList<Department> dEPARTMENT_LIST) {
		DEPARTMENT_LIST = dEPARTMENT_LIST;
	}

}
