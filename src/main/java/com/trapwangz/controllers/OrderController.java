package com.trapwangz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trapwangz.models.Orders;
import com.trapwangz.services.OrderService;
import com.trapwangz.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	@Autowired
	UserService userService;
	
	@GetMapping("/createOrder")
	public String menu(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("order", new Orders());
		model.addAttribute("user", userService.getOneUser((Long)session.getAttribute("userId")));
		return "createOrder.jsp";
	}
	
	@GetMapping("/flavors")
	public String flavors(@Valid @ModelAttribute("order") Orders order, 
			Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("order", orderService.getOneOrder((Long)session.getAttribute("userId")));
		return "flavors.jsp";
	}
	
	@GetMapping("/sides")
	public String order(Model model) {
		model.addAttribute("order", new Orders());
		return "sides.jsp";
	}
	
	@PostMapping("/createOrder")
	public String createOrder(@Valid @ModelAttribute("order") Orders order, 
			BindingResult result, Model model, 
			HttpSession session) {
		orderService.createOrder(order, result);
		if(result.hasErrors()) {
			model.addAttribute("order", new Orders());
			return "order.jsp";
		}
		return "redirect:/flavors";
	}
	
	@RequestMapping(value = "/chooseFlavor", method = RequestMethod.PUT)
	public String chooseFlavor(
			@Valid @ModelAttribute("order") Orders order,
			BindingResult result,
			Model model
			)
	{
		if(result.hasErrors()) {
			model.addAttribute("order", order);
			return "flavors.jsp";
		}
		else {
			orderService.editOrder(order);
			return "redirect:/sides";
		}
	}

}
