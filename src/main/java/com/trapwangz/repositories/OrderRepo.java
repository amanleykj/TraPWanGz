package com.trapwangz.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trapwangz.models.Orders;

@Repository
public interface OrderRepo extends CrudRepository<Orders, Long> {
	
	List<Orders> findAll();
	
}
