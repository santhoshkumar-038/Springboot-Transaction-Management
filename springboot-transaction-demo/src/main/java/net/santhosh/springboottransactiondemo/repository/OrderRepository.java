package net.santhosh.springboottransactiondemo.repository;

import net.santhosh.springboottransactiondemo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
