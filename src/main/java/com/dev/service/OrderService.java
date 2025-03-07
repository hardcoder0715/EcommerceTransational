package com.dev.service;

import com.dev.dto.OrderRequest;
import com.dev.dto.OrderResponce;

public interface OrderService {
	 OrderResponce placeOrder (OrderRequest orderRequest);

}
