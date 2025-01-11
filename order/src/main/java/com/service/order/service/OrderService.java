package com.service.order.service;

import com.service.order.entity.Order;
import com.service.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void createOrder() {
        // only if sufficient stock is there of a type of book
    }

    public Order viewOrder(int id) {
        return orderRepository.findById(id).get();
    }

    public List<Order> viewAllOrders() {
        return orderRepository.findAll();
    }
}
