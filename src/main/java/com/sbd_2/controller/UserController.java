package com.sbd_2.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbd_2.model.User;
@RestController
@RequestMapping(value="user")
public class UserController {
@PostMapping(value="create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
 public User createUser(@RequestBody User user) {
	 System.out.println("Create User "+user.getUserId());
	 System.out.println("Create User "+user.getUserName());
	 System.out.println("Create User "+user.getPassword());
	 return user;
 }
@GetMapping(value="read/{userId}/{password}")
public User readByUserIdAndPassword(@PathVariable int userId,@PathVariable String password) {
	User user=null;
	if(userId==1111 && password.equals("Reset123")) {
		user=new User(1111,"Tea","Reset123");
		
	}else {
		user=new User(2222,"Coffe","Break");
	}
	return user;
}
@PutMapping(value="update")
public User  updeteUser(@RequestBody User user) {
	return user;
}
@DeleteMapping(value="deletebyId/{userId}")
public int deleteUserById(@PathVariable int userId) {
	System.out.println("Delete : "+userId);
	return userId;
}
@DeleteMapping(value="deletebyName/{userName}")
public String deleteUserByName(@PathVariable String userName) {
	System.out.println("Delete : "+userName);
	return userName;
}
}
