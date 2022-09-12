package com.CustomerRegistration.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerRegistration.Entities.CustomerEntity;
import com.CustomerRegistration.Entities.Users;
import com.CustomerRegistration.Repository.UsersRepo;

@RestController
@RequestMapping("/api/v1/users/")
@CrossOrigin
public class UserController {
	
	@Autowired
	private UsersRepo usersRepo; 
	
	@PostMapping
	public Users newUser(@RequestBody Users users){
		return usersRepo.save(users);
	}
	
	@GetMapping
	public List<Users> getAllUsers(){
		return usersRepo.findAll();
	}
}
