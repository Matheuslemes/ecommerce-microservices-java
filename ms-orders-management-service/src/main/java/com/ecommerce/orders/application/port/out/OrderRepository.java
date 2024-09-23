package com.ecommerce.orders.application.port.out;

import com.ecommerce.orders.domain.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository {


    Order save(Order order);
    Order update(Order order);
    Order seacrchById(Long id) throws Throwable;
}
