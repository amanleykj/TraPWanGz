package com.trapwangz.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.trapwangz.models.User;

public interface UserRepo extends CrudRepository<User, Long> {
	List<User> findAll();
	
	Optional<User> findByEmail(String email);

}