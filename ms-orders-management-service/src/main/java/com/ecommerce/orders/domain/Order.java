package com.ecommerce.orders.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;


import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String clientId;

    @ElementCollection
    private List<String> products;

    @Column(nullable = false)
    private BigDecimal totalValue;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderType orderType;

    public Order(){}

    public Order(Long id, String clientId, List<String> products, BigDecimal totalValue, OrderStatus status) {
        this.id = id;
        this.clientId = clientId;
        this.products = products;
        this.totalValue = totalValue;
        this.status = OrderStatus.CREATED;
    }

    public void confirm() {
        this.status = OrderStatus.CONFIRMED;
    }

    public void cancel() {
        this.status = OrderStatus.CANCELLED;
    }

    public void send() {
        this.status = OrderStatus.SENT;
    }

    public void deliver() {
        this.status = OrderStatus.DELIVERED;
    }
}
