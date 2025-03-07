package com.dev.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.dto.OrderRequest;
import com.dev.dto.OrderResponce;
import com.dev.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

	private OrderService orderService;

	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	


	@PostMapping
// this is post mapping 
	public ResponseEntity<OrderResponce> placeOrder(@RequestBody OrderRequest orderRequest){
		
		return ResponseEntity.ok(orderService.placeOrder(orderRequest));
		
	}
	
}
