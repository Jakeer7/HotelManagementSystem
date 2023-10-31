package com.jakeer.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jakeer.modal.Receptionist;
import com.jakeer.repository.RecRepository;
@Component
@Service
@Transactional
public class RecService {
	@Autowired
	private final RecRepository userRepository;
	
	public RecService(RecRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	public void saveMyReceptionist(Receptionist user ) {
		userRepository.save(user);
	}
	
	public List<Receptionist> showAllReceptionists(){
		List<Receptionist> users = new ArrayList<Receptionist>();
		for(Receptionist user : userRepository.findAll()) {
			users.add(user);
		}
		
		return users;
	}
	
	public void deleteMyReceptionist(int id) {
		userRepository.deleteById(id);
	}
	
	public Receptionist editReceptionist(int id) {
		return userRepository.findById(id).get();
	}
	public Receptionist findByReceptionistnameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}
}

	