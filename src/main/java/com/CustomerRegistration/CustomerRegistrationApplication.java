package com.CustomerRegistration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.CustomerRegistration.Entities.CustomerEntity;
import com.CustomerRegistration.Entities.Users;
import com.CustomerRegistration.Repository.CustomerRepository;
import com.CustomerRegistration.Repository.UsersRepo;


@SpringBootApplication
public class CustomerRegistrationApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CustomerRegistrationApplication.class, args);
	}
		
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private UsersRepo usersRepo;
	
	@Override
	public void run(String... args) throws Exception {
		//creating customer 1
				CustomerEntity customer1 = new CustomerEntity();
				customer1.setUserName("kenny");
				customer1.setEmail("kennyprince022@gmail.com");
				customer1.setPhoneNumber("+250785087374");
				
				customerRepository.save(customer1);
				//creating customer 2
				CustomerEntity customer2 = new CustomerEntity();
				customer2.setUserName("prince");
				customer2.setEmail("prince0392@gmail.com");
				customer2.setPhoneNumber("+2507839826");
				
				customerRepository.save(customer2);
				//creating customer 3
				CustomerEntity customer3 = new CustomerEntity();
				customer3.setUserName("kendra");
				customer3.setEmail("kendra032@gmail.com");
				customer3.setPhoneNumber("+250786362323");
				
				customerRepository.save(customer3);
				//creating customer 4
				CustomerEntity customer4 = new CustomerEntity();
				customer4.setUserName("nancy");
				customer4.setEmail("nancy098@gmail.com");
				customer4.setPhoneNumber("+250786465233");
				
				customerRepository.save(customer4);
				//creating customer 5
				CustomerEntity customer5 = new CustomerEntity();
				customer5.setUserName("King");
				customer5.setEmail("king078@gmail.com");
				customer5.setPhoneNumber("+250786498343");
				
				customerRepository.save(customer5);
				
				//creating a first-run user
				Users user1 = new Users();
				user1.setEmail("kennyprince022@gmail.com");
				user1.setName("kenny");
				user1.setPassword("Kenny123");
				user1.setRoles("admin");
				
				usersRepo.save(user1);
	}
}
