package com.example.springboot.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.Employee;
import com.example.springboot.entity.EmployeePan;
import com.example.springboot.repository.EmployeePanRepository;
import com.example.springboot.repository.EmployeeRepository;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeRepository employeeRepopsitory;
	
	@Autowired
	private EmployeePanRepository employeePanRepository;
	
	
	@RequestMapping("/")
	public String welcome() {
		
		EmployeePan ep = new EmployeePan();
		ep.setPanNumber("AAAAAAAAA");
		employeePanRepository.save(ep);
		
		Employee e = new Employee();
		e.setFirstName("OBB");
		e.setLastName("OMG");
		e.setEmployeePan(ep);
		
		employeeRepopsitory.save(e);
		
		return "Hello from One to One!!!!";
	}
	
}
