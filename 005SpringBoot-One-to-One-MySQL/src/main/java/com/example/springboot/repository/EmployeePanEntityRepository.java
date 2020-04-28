package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.EmployeePanEntity;

@Repository
public interface EmployeePanEntityRepository extends JpaRepository<EmployeePanEntity, Integer>{

}
