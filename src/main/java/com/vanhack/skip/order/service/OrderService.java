package com.vanhack.skip.order.service;

import com.vanhack.skip.order.model.Order;
import com.vanhack.skip.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class OrderService {
    private OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order getOrder(Integer orderId){
        return repository.getOrder(orderId);
    }

    public Order save(@Valid Order order) {
        return repository.save(order);
    }
}
