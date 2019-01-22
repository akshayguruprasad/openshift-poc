package com.capgemini.customeraccount.customerservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.customeraccount.model.Customer;
import com.capgemini.customeraccount.repository.CustomerRepository;
@Service
public class CustomerAccountServiceImpl implements CustomerAccountService {

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public boolean insertCustomer(Customer customer) {

		customer = customerRepo.save(customer);
		boolean result = customer != null ? true : false;
		return result;
	}

	@Override
	public boolean deleteCustomer(String id) {

		try {

			customerRepo.deleteById(id);

		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
			return false;
		}

		return true;
	}

	@Override
	public Customer getCustomer(String id) {

		Customer customer = null;
		try {

			Optional<Customer> optional = customerRepo.findById(id);
			customer = optional.orElse(null);

		} catch (Exception e) {
			System.err.println("exception : " + e.getMessage());
		}
		return customer;
	}

}
