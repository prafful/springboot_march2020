package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.FriendDao;
import com.example.springboot.entity.FriendEntity;
import com.example.springboot.pojo.Friend;

@Service("friendService")
public class FriendService {
	
	@Autowired
	private FriendDao friendDao;
	
	public List<FriendEntity> getFriends() {
		return friendDao.getFriends();
	}
	
	public FriendEntity getFriendById( int id ) {
		return friendDao.getFriendById(id);
		
	}
	
	public List<FriendEntity> addFriend(Friend f) {
		return friendDao.addFriend(f);
		
	}

	
	public List<Friend> updateFriendById(int id,Friend f) {
		return friendDao.updateFriendById(id, f);
	}
	
	
	public List<Friend> deleteFriendById(int id) {
		return friendDao.deleteFriendById(id);
	}

	public List<FriendEntity> getFriendByLocation(String location) {
		// TODO Auto-generated method stub
		return friendDao.getFriendByLocation(location);
	}
	

}
