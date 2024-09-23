package com.ecommerce.payments.application.service;

import com.ecommerce.payments.adapters.in.PaymentKafkaConsumer;
import com.ecommerce.payments.adapters.out.PaymentKafkaProducer;
import com.ecommerce.payments.application.in.ProcessPaymentUseCase;
import com.ecommerce.payments.application.out.PaymentRepository;
import com.ecommerce.payments.domain.Payment;
import com.ecommerce.payments.domain.PaymentMethod;

import java.math.BigDecimal;

public class PaymentServiceImpl implements ProcessPaymentUseCase {

    private final PaymentRepository paymentRepository;
    private final PaymentKafkaProducer paymentKafkaProducer;

    public PaymentServiceImpl(PaymentRepository paymentRepository, PaymentKafkaProducer paymentKafkaProducer) {
        this.paymentRepository = paymentRepository;
        this.paymentKafkaProducer = paymentKafkaProducer;
    }

    @Override
    public Payment processPayment(Payment payment) {
        if (validatePayment(payment)) {
            payment.approve();
            paymentRepository.save(payment);

            paymentKafkaProducer.sendPaymentApproved(payment.getOrderId());
        } else {
            payment.refuse();
            paymentRepository.save(payment);

            paymentKafkaProducer.sendPaymentRefused(payment.getOrderId());
        }
        return null;
    }

    private boolean validatePayment(Payment payment) {

        return payment.getPaymentMethod() == PaymentMethod.CARD_CREDITED && payment.getTotalValue().compareTo(new BigDecimal("2000")) < 0;
    }
}
