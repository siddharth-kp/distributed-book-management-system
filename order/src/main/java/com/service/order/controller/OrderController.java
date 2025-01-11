package com.service.order.controller;

import com.service.order.entity.Orders;
import com.service.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody Orders order) throws Exception {
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Orders> viewOrder(@PathVariable int id) {
        return ResponseEntity.ok(orderService.viewOrder(id));
    }

    @GetMapping("/view")
    public ResponseEntity<List<Orders>> viewAllOrder() {
        return ResponseEntity.ok(orderService.viewAllOrders());
    }
}
