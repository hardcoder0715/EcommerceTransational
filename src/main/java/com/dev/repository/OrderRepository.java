package com.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
