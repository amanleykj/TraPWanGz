package com.trapwangz.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trapwangz.models.Contact;

@Repository
public interface ContactRepo extends CrudRepository<Contact, Long> {

	List<Contact> findAll();
	
	Optional<Contact> findByEmail(String email);
	
}
