package com.jakeer.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jakeer.modal.Customer;
import com.jakeer.modal.Receptionist;
import com.jakeer.repository.CustRepository;
import com.jakeer.repository.RoomRepository;

@Service
@Transactional
public class CustService {
	@Autowired
	private final CustRepository userRepository;
	
	public CustService(CustRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	public void saveMyCustomer(Customer user ) {
		userRepository.save(user);
	}
	
	public List<Customer> showAllCustomers(){
		List<Customer> users = new ArrayList<Customer>();
		for(Customer user : userRepository.findAll()) {
			users.add(user);
		}
		
		return users;
	}

	
	public void deleteMyCustomer(int id) {
		userRepository.deleteById(id);
	}
	
	public Customer editCustomer(int id) {
		return userRepository.findById(id).get();
	}
	public Customer getCustomers(int id) {
		return userRepository.findById(id).get();
	}

	public Customer findByReceptionistnameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}
}

	