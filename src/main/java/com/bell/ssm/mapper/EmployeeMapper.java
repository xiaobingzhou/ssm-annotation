package com.bell.ssm.mapper;

import java.util.List;

import com.bell.ssm.bean.Employee;

public interface EmployeeMapper {

	public List<Employee> getEmps();

	public boolean addEmp(Employee employee);
	
}
