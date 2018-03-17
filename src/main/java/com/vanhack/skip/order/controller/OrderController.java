package com.vanhack.skip.order.controller;

import com.vanhack.skip.order.model.Order;
import com.vanhack.skip.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/v1/Order")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service){
        this.service = service;
    }

    @GetMapping("/")
    public @ResponseBody String version() {
        return "Order v1";
    }

    @GetMapping("/{orderId}")
    @ResponseBody
    public Order getOrder(@PathVariable Integer orderId) {
        return this.service.getOrder(orderId);
    }

    @GetMapping("/customer")
    @ResponseBody
    public List<Order> getOrdersFromCustomer() {
        return null;
    }

    @PostMapping
    public ResponseEntity<Order> saveOrder(@Valid @ModelAttribute Order order) {

        if(order != null && order.getId() != null){
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
}
