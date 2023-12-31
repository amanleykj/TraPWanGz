package com.trapwangz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.trapwangz.models.Orders;
import com.trapwangz.repositories.OrderRepo;

import jakarta.persistence.criteria.Order;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepo orderRepo;
	
	
	public Orders createOrder(Orders order, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		return orderRepo.save(order);
	}
	
	
	public Orders editOrder(Orders order) {
		return orderRepo.save(order);
	}
	
	
	public Orders getOneOrder(Long id) {
		Optional<Orders> order = orderRepo.findById(id);
		if(order.isPresent()) {
			return order.get();
		}
		else {
			return null;
		}
	}
	
	
	public List<Orders> getAllOrders() {
		return orderRepo.findAll();
	}
	
	public void deleteOrder(Long id) {
		orderRepo.deleteById(id);
	}

	
	
}
