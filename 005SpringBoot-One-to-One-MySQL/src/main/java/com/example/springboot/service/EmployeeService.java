package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.EmployeeDao;
import com.example.springboot.entity.EmployeeEntity;
import com.example.springboot.pojo.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	public List<Employee> getAllEmployess() {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployess();
	}

	public Employee addEmployee(Employee e) {
		// TODO Auto-generated method stub
		return employeeDao.addEmployee(e);
	}

}
