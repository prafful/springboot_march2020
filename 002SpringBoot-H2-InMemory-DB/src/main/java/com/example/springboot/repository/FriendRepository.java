package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entity.FriendEntity;

public interface FriendRepository extends JpaRepository<FriendEntity, Integer>{

		//all basic CRUD methods are implemented by default!
	
	
}
