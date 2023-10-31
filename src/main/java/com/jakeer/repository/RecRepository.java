package com.jakeer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jakeer.modal.Receptionist;
@Repository
public interface RecRepository extends CrudRepository<Receptionist, Integer> {
	public Receptionist findByUsernameAndPassword(String username, String password);

}
