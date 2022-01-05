package com.practice.customerjpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer,Long>{
	
	List<Customer> findBylastname(String lastname);
	Customer findById(long id);

}
