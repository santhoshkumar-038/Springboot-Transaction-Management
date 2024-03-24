package net.santhosh.springboottransactiondemo.repository;

import net.santhosh.springboottransactiondemo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
