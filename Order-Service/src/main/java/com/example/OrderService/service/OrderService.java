package com.example.OrderService.service;
import java.util.List;

import com.example.OrderService.model.Order;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long orderId);
    Order createOrder(Order order);
    void deleteOrder(Long orderId);
	Order updateOrder(Long orderId,Order order);
}