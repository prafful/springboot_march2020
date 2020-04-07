package com.example.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entity.FriendEntity;

public interface FriendRepository extends JpaRepository<FriendEntity, Integer>{

		//all basic CRUD methods are implemented by default!
	
	   List<FriendEntity> findByLocation(String location);
	
	
}
