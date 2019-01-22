package com.capgemini.customeraccount.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.customeraccount.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>{

}
