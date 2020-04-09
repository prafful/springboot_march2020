package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.FriendDao;
import com.example.entity.FriendEntity;
import com.example.pojo.Friend;

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

	
	public List<FriendEntity> updateFriendById(int id,Friend f) {
		return friendDao.updateFriendById(id, f);
	}
	
	
	public List<FriendEntity> deleteFriendById(int id) {
		return friendDao.deleteFriendById(id);
	}

	public List<FriendEntity> getFriendByLocation(String location) {
		// TODO Auto-generated method stub
		return friendDao.getFriendByLocation(location);
	}

	public List<Friend> updateFriendPatchById(int id, Friend f) {
		// TODO Auto-generated method stub
		return friendDao.updateFriendPatchById(id, f);
	}
	

}
