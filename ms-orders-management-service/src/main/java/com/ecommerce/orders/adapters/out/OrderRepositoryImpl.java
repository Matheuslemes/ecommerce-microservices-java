package com.ecommerce.orders.adapters.out;

import com.ecommerce.orders.application.port.out.OrderRepository;
import com.ecommerce.orders.domain.Order;
import org.hibernate.query.criteria.JpaOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final JpaOrderRepository jpaOrderRepository;

    public OrderRepositoryImpl(JpaOrderRepository jpaOrderRepository) {
        this.jpaOrderRepository = jpaOrderRepository;
    }

    public Order save(Order order) {
        return jpaOrderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        return jpaOrderRepository.save(order);
    }

    @Override
    public Order seacrchById(Long id) throws Throwable {
        return jpaOrderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
