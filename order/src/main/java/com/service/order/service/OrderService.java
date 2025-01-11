package com.service.order.service;


import com.service.order.entity.Orders;
import com.service.order.feign.OrderFeignService;
import com.service.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderFeignService orderFeignService;

    public Orders createOrder(Orders order) throws Exception {
        ResponseEntity<Integer> quantityLeft = orderFeignService.getQuantity(order.getBookId());
        if(quantityLeft.getBody()<order.getQuantity())
            throw new Exception("Books not in stock");
        orderFeignService.setQuantity(order.getBookId(), order.getQuantity());
        return orderRepository.save(order);
    }

    public Orders viewOrder(int id) {
        return orderRepository.findById(id).get();
    }

    public List<Orders> viewAllOrders() {
        return orderRepository.findAll();
    }
}
