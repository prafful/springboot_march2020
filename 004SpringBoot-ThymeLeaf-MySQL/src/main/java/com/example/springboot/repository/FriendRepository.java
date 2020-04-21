package com.example.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.FriendEntity;

@Repository
public interface FriendRepository extends CrudRepository<FriendEntity, Integer> {
	
}
