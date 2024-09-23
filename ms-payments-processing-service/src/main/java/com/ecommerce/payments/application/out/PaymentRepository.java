package com.ecommerce.payments.application.out;

import com.ecommerce.payments.domain.Payment;

public interface PaymentRepository {

    Payment save(Payment payment);
}
