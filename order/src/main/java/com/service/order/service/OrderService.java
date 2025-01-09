package com.service.order.service;

import com.service.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void createOrder() {
        // only if sufficient stock is there of a type of book
    }

    public void viewOrder(int id) {

    }

    public void viewAllOrders() {

    }
}
