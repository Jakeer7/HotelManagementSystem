package com.jakeer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jakeer.modal.Customer;
@Repository
public interface CustRepository extends CrudRepository<Customer, Integer> {
	public Customer findByUsernameAndPassword(String username, String password);

}


