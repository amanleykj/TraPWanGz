package com.trapwangz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.trapwangz.models.Contact;
import com.trapwangz.repositories.ContactRepo;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepo contactRepo;
	
	public Contact sendContact(Contact contact, BindingResult result) {
			
		if(result.hasErrors()) {
			return null;
		}
		return contactRepo.save(contact);
	}
	

}
