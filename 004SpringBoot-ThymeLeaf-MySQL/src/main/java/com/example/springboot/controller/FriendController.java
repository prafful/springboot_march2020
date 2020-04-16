package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FriendController {
	
	@RequestMapping("/")
	public String defaultPage() {
		return "welcome";
	}

	
	@RequestMapping("/open_add_friend_page")
	public String openAddFriendPage() {
		return "addfriend";
	}

	@RequestMapping("/open_view_friend_page")
	public String openViewFriendPage() {
		return "viewfriend";
	}

}
