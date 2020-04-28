package com.example.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.EmployeeEntity;
import com.example.springboot.pojo.Employee;
import com.example.springboot.service.EmployeeService;

@RestController
public class EmployeeRestController {

	@Autowired 
	private EmployeeService employeeService;
	
	@RequestMapping("/")
	public String welcome() {
			return "Hello from One to One!!!!!";
	}
	
	@RequestMapping("/all")
	public List<Employee> getAllEmployess() {
		return employeeService.getAllEmployess();
	}
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee e) {
		return employeeService.addEmployee(e);
	}
	
}
