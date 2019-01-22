package com.capgemini.customeraccount.customerservice;

import com.capgemini.customeraccount.model.Customer;

public interface CustomerAccountService {

	boolean insertCustomer(Customer customer);
	boolean deleteCustomer(String id);
	Customer getCustomer(String id);
}
