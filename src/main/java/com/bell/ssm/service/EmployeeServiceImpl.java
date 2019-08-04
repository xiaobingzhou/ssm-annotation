package com.bell.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bell.ssm.bean.Employee;
import com.bell.ssm.mapper.EmployeeMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeMapper employeeMapper;
	
	public List<Employee> getEmps(){
		return employeeMapper.getEmps();
	}

	@Override
	@Transactional
	public Employee addEmp(Employee employee) {
		if(employeeMapper.addEmp(employee)) {
			String lastName = employee.getLastName();
			if ("error".equals(lastName)) {
				throw new RuntimeException();
			}
			return employee;
		}
		return employee;
	}
	
}
