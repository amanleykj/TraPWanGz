package com.trapwangz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.trapwangz.models.Contact;
import com.trapwangz.models.LoginUser;
import com.trapwangz.models.User;
import com.trapwangz.services.ContactService;
import com.trapwangz.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	ContactService contactService;
	
	@GetMapping("/")
	public String login() {
		return "index.jsp";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register.jsp";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("loginuser", new LoginUser());
		return "login.jsp";
	}
	
	@GetMapping("/contact")
	public String contact(Model model) {
		model.addAttribute("contact", new Contact());
		return "contact.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		userService.register(user, result);
		if(result.hasErrors()) {
			model.addAttribute("loginuser", new LoginUser());
			return "login.jsp";
		}
		session.setAttribute("userId", user.getId());
		return "redirect:/home";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		userService.register(user, result);
		if(result.hasErrors()) {
			model.addAttribute("loginuser", new LoginUser());
			return "login.jsp";
		}
		session.setAttribute("userId", user.getId());
		return "redirect:/home";
	}
	
	@PostMapping("/contact")
	public String contact(@Valid @ModelAttribute("user") Contact contact, BindingResult result, Model model, HttpSession session) {
		contactService.sendContact(contact, result);
		if(result.hasErrors()) {
			model.addAttribute("contact", new Contact());
			return "contact.jsp";
		}
		
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String home(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("user", userService.getOneUser((Long)session.getAttribute("userId")));
		return "home.jsp";
	}
	
	

}
