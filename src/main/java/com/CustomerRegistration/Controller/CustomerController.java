package com.CustomerRegistration.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.CustomerRegistration.Entities.CustomerEntity;
import com.CustomerRegistration.Repository.CustomerRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	@GetMapping("/customers")
	public List<CustomerEntity> getAllCustomers(){
		return customerRepository.findAll();
	}
	@PostMapping("/customers")
	public CustomerEntity newCustomer(@RequestBody CustomerEntity customerEntity){
		return customerRepository.save(customerEntity);
	}
	@GetMapping("/customers/{id}")
	public ResponseEntity<CustomerEntity>  getOptionalCustomer(@PathVariable Long id){
		CustomerEntity customerEntity = customerRepository.findById(id).orElseThrow( ()-> new ResourceAccessException("The customer with id:"+id+"does not exist"));
		return ResponseEntity.ok(customerEntity);
	}
	@PutMapping("/customers/{id}")
	public ResponseEntity<CustomerEntity> UpdateCustomers(@PathVariable Long id,@RequestBody CustomerEntity customerEntityData){
		CustomerEntity customerEntity = customerRepository.findById(id).orElseThrow( ()-> new ResourceAccessException("The customer with id:"+id+"does not exist"));
		customerEntity.setUserName(customerEntityData.getUserName());
		customerEntity.setEmail(customerEntityData.getEmail());
		customerEntity.setPhoneNumber(customerEntityData.getPhoneNumber());
		
		CustomerEntity UpdateCustomer = customerRepository.save(customerEntity);
		return ResponseEntity.ok(UpdateCustomer);
		
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable Long id){
		CustomerEntity customerEntity = customerRepository.findById(id).orElseThrow( ()-> new ResourceAccessException("The customer with id:"+id+"does not exist"));
		customerRepository.delete(customerEntity);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
