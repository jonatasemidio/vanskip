package com.vanhack.skip.order.repository;

import com.vanhack.skip.order.model.Order;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private static List<Order> db;

    public OrderRepository() {
        this.db = new ArrayList<>();
    }

    public Order getOrder(Integer orderId) {
        return this.db.stream().filter(c -> c.getCustomerId().equals(orderId)).findFirst().get();
    }

    public Order save(@Valid Order order) {
        this.db.add(order);
        return order;
    }
}
