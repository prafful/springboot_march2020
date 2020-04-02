package com.example.springboot.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.springboot.pojo.Friend;

@Repository("friendDao")
public class FriendDao {
	
	List<Friend> friends = null;
	
	
	public FriendDao() {
		// TODO Auto-generated constructor stub
		// TODO Auto-generated constructor stub
		friends = new ArrayList<Friend>();
		
		Friend f1 = new Friend(1, "OBB", "Chennai");
		Friend f2 = new Friend(2, "MLANN", "Mumbai");
		Friend f3 = new Friend(3, "OWIOH", "Bengaluru");
		Friend f4 = new Friend(4, "CAS", "Tokyo");
		
		friends.add(f1);
		friends.add(f2);
		friends.add(f3);
		friends.add(f4);
	}
	
	
	public List<Friend> getFriends() {
		return friends;
	}
	
	public Friend getFriendById( int id ) {
		System.out.println("Get friend with id: " + id);
		Friend tempFriend = new Friend();
		for (int i = 0; i < friends.size(); i++) {
			tempFriend = friends.get(i);
			if(tempFriend.getId() == id) {
				return tempFriend;
			}
			
		}
		return null;
		
	}
	
	public List<Friend> addFriend(Friend f) {
		System.out.println("Received friend: " + f.getName() + ", "  + f.getId() + ", " + f.getLocation());
		friends.add(f);
		return friends;
		
	}

	
	public List<Friend> updateFriendById(int id,Friend f) {
		System.out.println("Update friend with id: " + id);
		System.out.println("Update content: "+ f.getName() + ", "  + f.getId() + ", " + f.getLocation());
		Friend tempFriend = new Friend(); 
		for(int i=0; i<friends.size(); i++) {
			tempFriend = friends.get(i);
			if(tempFriend.getId() == id) {
				friends.set(i, f);
			}
		}
		
		return friends;
	}
	
	
	public List<Friend> deleteFriendById(int id) {
		Friend tempFriend = new Friend(); 
		for(int i=0; i<friends.size(); i++) {
			tempFriend = friends.get(i);
			if(tempFriend.getId() == id) {
				friends.remove(i);
			}
		}
		return friends;
	}
	
	

}
