package com.example.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.FriendEntity;
import com.example.springboot.pojo.Friend;
import com.example.springboot.service.FriendService;

@RestController
public class HelloRestController {
	
	List<Friend> friends = null;
	
	@Autowired
	private FriendService friendService;

	@RequestMapping("/")
	public String welcome() {
		return "Hello from Spring Boot!";
	}
	
	@RequestMapping("/friend/all")
	public List<FriendEntity> getFriends() {
		return friendService.getFriends();
	}
	
	@RequestMapping("/friend/{myid}")
	public Friend getFriendById(@PathVariable("myid") int id ) {
		return friendService.getFriendById(id);
		
	}
	
	
	@RequestMapping(value = "/friend/add", method = RequestMethod.POST)
	public List<FriendEntity> addFriend(@RequestBody Friend f) {
		System.out.println("Received friend: " + f.getName() + ", "  + f.getId() + ", " + f.getLocation());
		return friendService.addFriend(f);
		
	}

	//@RequestMapping(value = "/friend/update/{id}", method = RequestMethod.PUT)
	@PutMapping("/friend/update/{id}")
	public List<Friend> updateFriendById(@PathVariable("id") int id, @RequestBody Friend f) {
		System.out.println("Update friend with id: " + id);
		System.out.println("Update content: "+ f.getName() + ", "  + f.getId() + ", " + f.getLocation());
		return friendService.updateFriendById(id, f);
	}
	
	@DeleteMapping("/friend/delete/{id}")
	public List<Friend> deleteFriendById(@PathVariable("id") int id) {
		return friendService.deleteFriendById(id);
	}
	
	/*	GET
	 *  /friends
	 *	/friends/2	
	 *  
	 *  POST
	 *  /friends/add   (new friend as a JSON request object!)
	 *  
	 *  DELETE
	 *  /friends/del/2
	 *  
	 *  PUT
	 *  /friends/update (new friend as a JSON request object!)
	 *  
	 *  PATCH
	 *  /friends/update (new friend as a JSON request object!) 
	 */
	
}


