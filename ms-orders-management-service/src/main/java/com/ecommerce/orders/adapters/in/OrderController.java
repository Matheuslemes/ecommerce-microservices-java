package com.ecommerce.orders.adapters.in;

import com.ecommerce.orders.application.port.in.CreateOrderUseCase;
import com.ecommerce.orders.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private CreateOrderUseCase createOrderUseCase;



    public OrderController(CreateOrderUseCase createOrderUseCase) {
        this.createOrderUseCase = createOrderUseCase;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order newOrder = createOrderUseCase.createOrder(order);
        return ResponseEntity.ok(newOrder);
    }

    public Order update(@RequestBody Order order) {
        return null;
    }
}
