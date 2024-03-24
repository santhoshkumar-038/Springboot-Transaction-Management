package net.santhosh.springboottransactiondemo.service;

import lombok.AllArgsConstructor;
import net.santhosh.springboottransactiondemo.dto.OrderRequest;
import net.santhosh.springboottransactiondemo.dto.OrderResponse;
import net.santhosh.springboottransactiondemo.entity.Order;
import net.santhosh.springboottransactiondemo.entity.Payment;
import net.santhosh.springboottransactiondemo.exception.PaymentException;
import net.santhosh.springboottransactiondemo.repository.OrderRepository;
import net.santhosh.springboottransactiondemo.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;
    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("In Progress");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();
        if(!payment.getCardType().equals("DEBIT")){
            throw new PaymentException("Payment card type do not support");
        }
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");

        return orderResponse;
    }
}
