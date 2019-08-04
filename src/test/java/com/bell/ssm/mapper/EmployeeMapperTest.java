package com.bell.ssm.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bell.ssm.bean.Employee;
import com.bell.ssm.confg.MybatisConfig;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MybatisConfig.class)
public class EmployeeMapperTest {

	@Autowired
	EmployeeMapper  employeeMapper;
	
	@Test
	public final void testGetEmps() {
		List<Employee> emps = employeeMapper.getEmps();
		Assert.assertNotNull(emps);
	}

	@Test
	public final void testAddEmp() {
		Employee employee = new Employee();
		employee.setLastName("admin223");
		employee.setEmail("admin223@qq.com");
		employee.setGender("1");
		boolean addEmp = employeeMapper.addEmp(employee);
		Assert.assertTrue(addEmp);
	}

}
