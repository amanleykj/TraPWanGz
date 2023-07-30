package com.trapwangz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.trapwangz.models.LoginUser;
import com.trapwangz.models.Orders;
import com.trapwangz.models.User;
import com.trapwangz.services.ContactService;
import com.trapwangz.services.OrderService;
import com.trapwangz.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	ContactService contactService;
	@Autowired
	OrderService orderService;
	
	@GetMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "index.jsp";
		}
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String home(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("allOrders", orderService.getAllOrders());
		model.addAttribute("user", userService.getOneUser((Long)session.getAttribute("userId")));
		return "home.jsp";
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
			
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		userService.register(user, result);
		if(result.hasErrors()) {
			model.addAttribute("loginuser", new LoginUser());
			return "register.jsp";
		}
		session.setAttribute("userId", user.getId());
		return "redirect:/home";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginuser") LoginUser user, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("user", new User());
			return "login.jsp";
		}
		User user1 = userService.login(user, result);
		session.setAttribute("userId", user1.getId());
		return "redirect:/home";
	}
	
	@GetMapping("/user/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("user", userService.getOneUser((Long)session.getAttribute("userId")));
		return "editProfile.jsp";
	}
	
	@PutMapping("/user/{id}")
	public String orderComplete(@Valid @ModelAttribute("user") User user, BindingResult result, @PathVariable("id") Long id)
	{
	if(result.hasErrors()) {
			return "editProfile.jsp";
	}
			userService.register(user, result);
			return "redirect:/home";
	}
		
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null);
		return "redirect:/";
	}

}
