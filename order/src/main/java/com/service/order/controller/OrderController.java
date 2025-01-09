package com.service.order.controller;

import com.service.order.entity.Order;
import com.service.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public void createOrder(@RequestBody Order order) {

    }

    @GetMapping("/view/{id}")
    public void viewOrder(@PathVariable int id) {

    }

    @GetMapping("/view")
    public void viewAllOrder() {

    }
}
