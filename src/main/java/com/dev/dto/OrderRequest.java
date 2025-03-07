package com.dev.dto;

import com.dev.entity.Order;
import com.dev.entity.Payment;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderRequest {
	
 private Order order;
 
 private Payment payment;

}
