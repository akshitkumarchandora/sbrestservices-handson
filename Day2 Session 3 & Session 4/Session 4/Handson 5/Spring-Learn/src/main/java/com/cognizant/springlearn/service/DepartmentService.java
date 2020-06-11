package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Department;
import com.cognizant.springlearn.dao.DepartmentDao;

@Service
public class DepartmentService {
	public ArrayList<Department> getAllDepartments(){
		return new DepartmentDao().getAllDepartments();
	}
}
