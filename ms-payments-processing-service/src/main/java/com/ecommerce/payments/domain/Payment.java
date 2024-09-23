package com.ecommerce.payments.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long orderId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status;

    @Column(nullable = false)
    private BigDecimal totalValue;

    @Column(nullable = false)
    private String paymentDetails;

    public Payment(String paymentDetails, BigDecimal totalValue, PaymentStatus status, PaymentMethod paymentMethod, Long orderId) {
        this.orderId = orderId;
        this.paymentDetails = paymentDetails;
        this.totalValue = totalValue;
        this.status = PaymentStatus.PENDING;
        this.paymentMethod = paymentMethod;
    }

    public void approve() {
        this.status = PaymentStatus.APPROVED;
    }

    public void refuse() {
        this.status = PaymentStatus.REFUSED;
    }
}
