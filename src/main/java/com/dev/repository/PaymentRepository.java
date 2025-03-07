package com.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

//	void save(Payment payment);

}
