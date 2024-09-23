package com.ecommerce.orders.application.port.in;

import com.ecommerce.orders.domain.Order;

public interface CreateOrderUseCase {

    Order createOrder(Order order);

}
