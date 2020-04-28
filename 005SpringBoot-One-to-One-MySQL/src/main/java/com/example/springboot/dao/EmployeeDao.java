package com.example.springboot.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.EmployeeEntity;
import com.example.springboot.entity.EmployeePanEntity;
import com.example.springboot.pojo.Employee;
import com.example.springboot.pojo.EmployeePan;
import com.example.springboot.pojo.EmployeePanNumber;
import com.example.springboot.repository.EmployeeEntityRepository;
import com.example.springboot.repository.EmployeePanEntityRepository;

@Repository
public class EmployeeDao {
	
	@Autowired
	private EmployeeEntityRepository employeeEntityRepository;
		
	@Autowired
	private EmployeePanEntityRepository employeePanEntityRepository;

	public List<Employee> getAllEmployess() {
		// TODO Auto-generated method stub
		List<EmployeeEntity> eeList =  employeeEntityRepository.findAll();
		
		List<Employee> eList = new ArrayList<Employee>();
		
		for(EmployeeEntity ee: eeList) {
			Employee e = new Employee();
			EmployeePanNumber ep = new EmployeePanNumber();
			e.setId(ee.getId());
			e.setFirstName(ee.getFirstName());
			e.setLastName(ee.getLastName());
			
			ep.setPanNumber(ee.getEmployeePanEntity().getPanNumber());
			ep.setPanId(ee.getEmployeePanEntity().getPanId());
			
			e.setEmployeePan(ep);
			
			eList.add(e);
			
			
		}
		
		return eList;
		
		
		
	}

	public Employee addEmployee(Employee e) {
		// TODO Auto-generated method stub
		EmployeeEntity ee = new EmployeeEntity();
		EmployeePanEntity epe = new EmployeePanEntity();
		
		ee.setFirstName(e.getFirstName());
		ee.setLastName(e.getLastName());
		
		//ee.setEmployeePanEntity(employeePanEntity);
		
		epe.setPanNumber(e.getEmployeePan().getPanNumber());;
		
		ee.setEmployeePanEntity(epe);
		
		EmployeePanEntity epe1 =   employeePanEntityRepository.save(epe);
		EmployeeEntity ee1 = employeeEntityRepository.save(ee);
		
		Employee employee = new Employee();
		employee.setFirstName(ee1.getFirstName());
		employee.setLastName(ee1.getLastName());
		employee.setId(ee1.getId());
		
		EmployeePanNumber ep1 = new EmployeePanNumber();
		ep1.setPanId(ee1.getEmployeePanEntity().getPanId());
		ep1.setPanNumber(ee1.getEmployeePanEntity().getPanNumber());
		
		employee.setEmployeePan(ep1);
		
		
		
		return employee;
		
		
	}
	

}
;