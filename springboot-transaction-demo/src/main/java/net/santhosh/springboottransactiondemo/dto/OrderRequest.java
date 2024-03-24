package net.santhosh.springboottransactiondemo.dto;

import lombok.Getter;
import lombok.Setter;
import net.santhosh.springboottransactiondemo.entity.Order;
import net.santhosh.springboottransactiondemo.entity.Payment;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
