package com.ecommerce.payments.adapters.out;

import com.ecommerce.payments.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPaymentRepository extends JpaRepository<Payment, Long> {

}
