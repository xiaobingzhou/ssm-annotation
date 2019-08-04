package com.bell.ssm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bell.ssm.bean.Employee;
import com.bell.ssm.service.EmployeeService;

@Controller
@RequestMapping("/view")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/emps")
	public String getEmps(Map<String, Object> map) {
		List<Employee> emps = employeeService.getEmps();
		System.out.println(emps);
		map.put("emps", employeeService.getEmps());
		return "list";
	}
}
