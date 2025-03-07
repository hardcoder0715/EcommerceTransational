package com.dev.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.dto.OrderRequest;
import com.dev.dto.OrderResponce;
import com.dev.entity.Order;
import com.dev.entity.Payment;
import com.dev.exception.PaymentException;
import com.dev.repository.OrderRepository;
import com.dev.repository.PaymentRepository;
import com.dev.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	private OrderRepository orderRepository;
	
	private PaymentRepository paymentRepository;
	

	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
		super();
		System.out.println("this is payment repo");
		this.orderRepository = orderRepository;
		this.paymentRepository = paymentRepository;
	}

	@Override
	@Transactional
	public OrderResponce placeOrder(OrderRequest orderRequest) {
		
		Order order = orderRequest.getOrder();
		
		order.setStatus("InProgress!!");
		
		order.setOrderTrackingNumber(UUID.randomUUID().toString());
		
		orderRepository.save(order);
		
		
		
		
		
		//get payment first
		
		Payment payment= orderRequest.getPayment(); 
		
		
		
		if(!payment.getType().equals("DEBIT")) {
			
			throw new PaymentException("Card type is not supported!!!");
			
		}
		
		payment.setOrderId(order.getId());
		paymentRepository.save(payment);

		
		OrderResponce orderResponce=new OrderResponce();
		
		orderResponce.setOrderTrackingNumber(order.getOrderTrackingNumber());
		orderResponce.setStatus(order.getStatus());
		orderResponce.setMessage("SUCCESS!!!");
		
		return orderResponce;
	}

}
