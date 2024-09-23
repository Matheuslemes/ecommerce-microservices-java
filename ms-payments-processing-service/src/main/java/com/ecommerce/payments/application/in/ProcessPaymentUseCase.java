package com.ecommerce.payments.application.in;

import com.ecommerce.payments.domain.Payment;

public interface ProcessPaymentUseCase {

    Payment processPayment(Payment payment);
}
