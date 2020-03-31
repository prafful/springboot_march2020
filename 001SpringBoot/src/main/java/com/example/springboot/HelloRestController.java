package com.example.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
	
	List<Friend> friends = null;

	public HelloRestController() {
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
	
	
	@RequestMapping("/")
	public String welcome() {
		return "Hello from Spring Boot!";
	}
	
	@RequestMapping("/friends")
	public List<Friend> getFriends() {
		return friends;
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


