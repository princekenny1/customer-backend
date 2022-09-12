package com.CustomerRegistration.SecurityConfigurations;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.CustomerRegistration.Entities.Users;
import com.CustomerRegistration.Repository.UsersRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private UsersRepo usersRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Users users = usersRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("user not found!!"));
		return new User(users.getEmail(),users.getPassword(), new ArrayList<>());
	 }

}
