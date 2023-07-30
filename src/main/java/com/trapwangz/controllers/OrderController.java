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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException.Forbidden;

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
		
	@GetMapping("/wings")
	public String wings(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null ) {
			return "redirect:/";
		}
		model.addAttribute("user", userService.getOneUser((Long)session.getAttribute("userId")));
		return "wings.jsp";
	}
	
	@GetMapping("/sides")
	public String sides(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null ) {
			return "redirect:/";
		}
		model.addAttribute("user", userService.getOneUser((Long)session.getAttribute("userId")));
		return "sides.jsp";
	}
	
	@GetMapping("/sets")
	public String sets(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null ) {
			return "redirect:/";
		}
		model.addAttribute("user", userService.getOneUser((Long)session.getAttribute("userId")));
		return "sets.jsp";
	}
	
	@GetMapping("/createOrder")
	public String createOrder(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("order", new Orders());
		model.addAttribute("user", userService.getOneUser((Long)session.getAttribute("userId")));
		return "createOrder.jsp";
	}

//	Totally new order is here
	@PostMapping("/createOrder")
	public String createOrder(@Valid @ModelAttribute("order") Orders order, 
			BindingResult result, Model model, 
			HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("order", new Orders());
			return "createOrder.jsp";
		}
		orderService.createOrder(order, result);
		session.setAttribute("order", order.getId());
		return "redirect:/confirm";
	}
	
//	For editing an order IS BELOW
	@PostMapping("/editOrder")
	public String editOrder(@Valid @ModelAttribute("order") Orders order, 
			BindingResult result, Model model, 
			HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("order", new Orders());
			return "createOrder.jsp";
		}
		orderService.createOrder(order, result);
		session.setAttribute("order", order.getId());
		return "redirect:/confirm";
	}
	
	@GetMapping("/confirm")
	public String confirm(@Valid @ModelAttribute("order") Orders order, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
				return "redirect:/";
		}
		if(session.getAttribute("order") == null) {
			return "redirect:/";
		}
		model.addAttribute("user", userService.getOneUser((Long)session.getAttribute("userId")));
		model.addAttribute("order", orderService.getOneOrder((Long)session.getAttribute("order")));
		return "confirm.jsp";
	}
	
	@GetMapping("/order/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Orders order = orderService.getOneOrder(id);
		model.addAttribute("user", userService.getOneUser((Long)session.getAttribute("userId")));
		model.addAttribute("order", order);
		return "editOrder.jsp";
	}
	
	@PutMapping("/order/{id}")
	public String completeOrder(@Valid @ModelAttribute("order") Orders order, BindingResult result, @PathVariable("id") Long id)
	{
	if(result.hasErrors()) {
			return "confirm.jsp";
	}
			orderService.createOrder(order, result);
			return "redirect:/confirm";
	}
	
	@PutMapping("/orderComplete/{id}")
	public String orderComplete(@Valid @ModelAttribute("order") Orders order, BindingResult result, @PathVariable("id") Long id)
	{
	if(result.hasErrors()) {
			return "confirm.jsp";
	}
			orderService.createOrder(order, result);
			return "redirect:/home";
	}
	
	@GetMapping("/delete/{id}")
	public String destroy(@PathVariable("id") Long id, HttpSession session) {
	if(session.getAttribute("userId") == null) {
			return "redirect:/";
	}
		orderService.deleteOrder(id);
		return "redirect:/home";
	}
	
}
