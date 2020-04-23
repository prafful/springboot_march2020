package com.example.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_pan_id")
	private Integer panId;   //pan_id
	@Column
	private String panNumber;
	

}
