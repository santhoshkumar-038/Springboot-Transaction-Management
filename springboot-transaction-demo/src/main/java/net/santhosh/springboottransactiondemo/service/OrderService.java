package net.santhosh.springboottransactiondemo.service;

import net.santhosh.springboottransactiondemo.dto.OrderRequest;
import net.santhosh.springboottransactiondemo.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
