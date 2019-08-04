package com.bell.ssm.service;

import java.util.List;

import com.bell.ssm.bean.Employee;

public interface EmployeeService {

	List<Employee> getEmps();

	Employee addEmp(Employee employee);
	
}
