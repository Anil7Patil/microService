package com.example.OrderService.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OrderService.model.Order;
import com.example.OrderService.repository.OrderRepository;
import com.example.OrderService.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

	@Override
	public Order updateOrder(Long orderId, Order order) {
	Order oldOrder	=orderRepository.findById(orderId).orElse(null);
	oldOrder.setOrderId(order.getOrderId());
	oldOrder.setPrice(order.getPrice());
	oldOrder.setProductName(order.getProductName());
	return orderRepository.save(oldOrder);
	}
}
