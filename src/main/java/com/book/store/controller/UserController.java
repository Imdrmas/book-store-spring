package com.book.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.modal.User;
import com.book.store.service.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@PutMapping("/editUser/{id}")
	User editUser(@RequestBody User user, @PathVariable long id) {
		return userService.editUser(user, id);
	}
    
	@DeleteMapping("/deleteUser/{id}")
	void deleteUser(@PathVariable long id) {
		userService.deleteUser(id);
	}
    @GetMapping("/findByUsername/{username}")
	User findByUsername(@PathVariable String username) {
		return userService.findByUsername(username);
	}

}
