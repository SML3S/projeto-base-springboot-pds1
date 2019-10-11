package com.projetobase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetobase.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
