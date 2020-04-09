package com.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Repository;

import com.example.entity.FriendEntity;
import com.example.pojo.Friend;
import com.example.repository.FriendRepository;

@Repository("friendDao")
public class FriendDao {
	
	List<Friend> friends = null;
	
	@Autowired
	private FriendRepository friendRepository;
	
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
	
	
	public List<FriendEntity> getFriends() {
		return friendRepository.findAll();
	}
	
	public FriendEntity getFriendById( int id ) {
		System.out.println("Get friend with id: " + id);
		Optional<FriendEntity> optionalFe = friendRepository.findById(id);
		FriendEntity fe = new FriendEntity();
		if(optionalFe.isPresent()) {
			fe = optionalFe.get();
		}
		return fe;
		
	}
	
	public List<FriendEntity> addFriend(Friend f) {
		System.out.println("Received friend: " + f.getName() + ", "  + f.getId() + ", " + f.getLocation());
		FriendEntity fe = new FriendEntity();
		fe.setName(f.getName());
		fe.setLocation(f.getLocation());	
		friendRepository.save(fe);
		
		return friendRepository.findAll();
		
	}

	
	public List<FriendEntity> updateFriendById(int id,Friend f) {
		System.out.println("Update friend with id: " + id);
		System.out.println("Update content: "+ f.getName() + ", "  + f.getId() + ", " + f.getLocation());
		Optional<FriendEntity> feo = friendRepository.findById(id);
		//check if optional contains the valid entity (received with valid id)
		if(feo.isPresent()) {
			FriendEntity fe = new FriendEntity();
			fe = feo.get();
			System.out.println(fe.getName());
			System.out.println(fe.getLocation());
			fe.setName(f.getName());
			fe.setLocation(f.getLocation());
			fe.setId(id);
			//friendRepository.save(new FriendEntity(feo.get().setId(id), feo.get().setName(f.getName()), feo.get().setLocation(f.getLocation()))));
			friendRepository.saveAndFlush(fe);
			
		}
		
		return friendRepository.findAll();
	}
	
	
	public List<FriendEntity> deleteFriendById(int id) {
		Optional<FriendEntity> feo = friendRepository.findById(id);
		if(feo.isPresent()) {
			friendRepository.deleteById(id);
		}
		
		return friendRepository.findAll();
	}


	public List<FriendEntity> getFriendByLocation(String location) {
		// TODO Auto-generated method stub
		return friendRepository.findByLocation(location);
	}


	public List<Friend> updateFriendPatchById(int id, Friend f) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
