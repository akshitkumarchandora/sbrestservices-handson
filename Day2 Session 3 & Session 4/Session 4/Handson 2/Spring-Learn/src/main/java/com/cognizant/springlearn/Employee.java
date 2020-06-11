package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Employee {

	private String name;
	private int age;
	private double salary;
	private Department dept;
	private static final Logger LOGGER = LoggerFactory.getLogger(Employee.class);
	
	public Employee()
	{
		LOGGER.info("Inside Employee Constructor");
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", dept=" + dept + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

}
