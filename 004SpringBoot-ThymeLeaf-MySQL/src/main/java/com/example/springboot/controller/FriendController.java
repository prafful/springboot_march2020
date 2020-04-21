package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springboot.entity.FriendEntity;
import com.example.springboot.repository.FriendRepository;

@Controller
public class FriendController {
	
	@Autowired
	private FriendRepository friendRepository;
	
	@RequestMapping("/")
	public String defaultPage() {
		return "welcome";
	}

	
	@RequestMapping("/open_add_friend_page")
	public String openAddFriendPage(Model m) {
		m.addAttribute("friend", new FriendEntity() );
		return "addfriend";
	}

	@RequestMapping("/open_view_friend_page")
	public String openViewFriendPage( Model m) {
		List<FriendEntity> friendsList =   (List<FriendEntity>) friendRepository.findAll();
		m.addAttribute("friends", friendsList);
		return "viewfriend";
	}
	
	@RequestMapping(value = "/addnewfriend", method = RequestMethod.POST)
	public String addNewFriend(FriendEntity fe) {
		System.out.println("Check  " + fe.getName() );
		friendRepository.save(fe);
		return "redirect:/open_view_friend_page";
	}
	
	
}
