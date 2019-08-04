package com.bell.ssm.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bell.ssm.bean.Employee;
import com.bell.ssm.dto.RestResult;
import com.bell.ssm.service.EmployeeService;

@RestController
public class EmployeeRestController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/emps")
	public RestResult getEmps() {
		List<Employee> emps = employeeService.getEmps();
		return RestResult.ok(emps);
	}
	
	@PostMapping("/emps")
	public RestResult addEmp(@RequestBody Employee employee) {
		Employee result = employeeService.addEmp(employee);
		return RestResult.ok(result);
	}
	
}
