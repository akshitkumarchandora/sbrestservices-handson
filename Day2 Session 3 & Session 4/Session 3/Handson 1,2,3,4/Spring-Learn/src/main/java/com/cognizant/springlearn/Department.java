package com.cognizant.springlearn;

public class Department {
	private int deptNo;
	

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	@Override
	public String toString() {
		
		return "Department [deptNo=" + deptNo + "]";
	}
}
