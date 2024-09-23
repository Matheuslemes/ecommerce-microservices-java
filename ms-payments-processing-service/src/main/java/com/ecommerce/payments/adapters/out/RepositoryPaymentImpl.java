package com.ecommerce.payments.adapters.out;

import com.ecommerce.payments.application.out.PaymentRepository;
import com.ecommerce.payments.domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryPaymentImpl implements PaymentRepository {

    @Autowired
    private JpaPaymentRepository jpaPaymentRepository;

    @Override
    public Payment save(Payment payment) {
        return (Payment) jpaPaymentRepository.save(payment);
    }
}
