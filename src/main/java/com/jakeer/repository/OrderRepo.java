package com.jakeer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jakeer.modal.Order;

@Repository
public interface OrderRepo extends CrudRepository<Order, Integer> {
	
}
