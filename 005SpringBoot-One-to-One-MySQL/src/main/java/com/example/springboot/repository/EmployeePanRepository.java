package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.EmployeePan;

@Repository
public interface EmployeePanRepository extends JpaRepository<EmployeePan, Integer>{

}
