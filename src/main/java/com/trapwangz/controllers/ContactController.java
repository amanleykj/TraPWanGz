package com.trapwangz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.trapwangz.models.Contact;
import com.trapwangz.services.ContactService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ContactController {
	
	@Autowired
	ContactService contactService;
	
	@GetMapping("/contact")
	public String contact(Model model) {
		model.addAttribute("contact", new Contact());
		return "contact.jsp";
	}
	
	@PostMapping("/contact")
	public String contact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result, Model model, HttpSession session) {
		contactService.sendContact(contact, result);
		if(result.hasErrors()) {
			model.addAttribute("contact", new Contact());
			return "contact.jsp";
		}
		
		return "redirect:/home";
	}

}
