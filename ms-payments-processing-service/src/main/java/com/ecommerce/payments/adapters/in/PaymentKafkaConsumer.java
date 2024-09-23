package com.ecommerce.payments.adapters.in;

import com.ecommerce.payments.application.in.ProcessPaymentUseCase;
import com.ecommerce.payments.domain.Payment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentKafkaConsumer {
    private final ProcessPaymentUseCase processPaymentUseCase;


    public PaymentKafkaConsumer(ProcessPaymentUseCase processPaymentUseCase) {
        this.processPaymentUseCase = processPaymentUseCase;
    }

    @KafkaListener(topics = "orderTopic")
    public void receiveOrder(Payment payment) {
        // processar o pagamento recebido
        Payment  paymentProcessed = processPaymentUseCase.processPayment(payment);

        // enviar status do pagamento de volta
        System.out.println(("Payment Processed: " + paymentProcessed.getStatus()));
    }
}
