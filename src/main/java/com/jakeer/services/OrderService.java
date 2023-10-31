package com.jakeer.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jakeer.modal.Order;
import com.jakeer.repository.OrderRepo;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	private final OrderRepo userRepository;
	
	public OrderService(OrderRepo userRepository) {
		super();
		this.userRepository = userRepository;
	}
	public void saveMyOrder(Order user ) {
		userRepository.save(user);
	}
	public List<Order> showAllOrders(){
		List<Order> users = new ArrayList<Order>();
		for(Order user : userRepository.findAll()) {
			users.add(user);
		}
		
		return users;
	}
}
