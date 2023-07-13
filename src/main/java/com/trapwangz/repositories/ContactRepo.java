package com.trapwangz.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.trapwangz.models.Contact;

public interface ContactRepo extends CrudRepository<Contact, Long> {

	List<Contact> findAll();
	
	Optional<Contact> findByEmail(String email);
	
}
