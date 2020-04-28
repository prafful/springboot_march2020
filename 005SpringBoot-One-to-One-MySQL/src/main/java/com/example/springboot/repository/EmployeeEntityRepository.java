package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.EmployeeEntity;


@Repository
public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, Integer>{

}
