package com.capgemini.customeraccount.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.customeraccount.customerservice.CustomerAccountService;
import com.capgemini.customeraccount.model.Customer;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerAccountService customerService;

	@PostMapping("/register")
	public boolean registerCustomer(@RequestBody Customer customer) {
		return customerService.insertCustomer(customer);
	}
	@GetMapping("/customer/{:id}")
	public Customer getCustomer(@PathVariable String id) {
		return customerService.getCustomer(id);
	}
	
	
}
