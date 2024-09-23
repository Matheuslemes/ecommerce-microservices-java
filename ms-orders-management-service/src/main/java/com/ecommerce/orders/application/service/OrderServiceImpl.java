package com.ecommerce.orders.application.service;

import com.ecommerce.orders.adapters.out.OrderKafkaProducer;
import com.ecommerce.orders.application.port.in.CreateOrderUseCase;
import com.ecommerce.orders.application.port.out.OrderRepository;
import com.ecommerce.orders.domain.Order;
import com.ecommerce.orders.domain.OrderStatus;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements CreateOrderUseCase {

    private final OrderRepository orderRepository;
    private OrderKafkaProducer orderKafkaProducer;

    public OrderServiceImpl(OrderRepository orderRepository, OrderKafkaProducer orderKafkaProducer) {
        this.orderRepository = orderRepository;
        this.orderKafkaProducer = orderKafkaProducer;
    }


    @Override
    public Order createOrder(Order order) {
        Order newOrder = orderRepository.save(order);
        orderKafkaProducer.sendOrder(newOrder);
        return newOrder;
    }

    public void updateOrderStatus(Long orderId, OrderStatus newStatus) throws Throwable {
        Order order = orderRepository.seacrchById(orderId);
        order.setStatus(newStatus);
        orderRepository.update(order);
    }
}
