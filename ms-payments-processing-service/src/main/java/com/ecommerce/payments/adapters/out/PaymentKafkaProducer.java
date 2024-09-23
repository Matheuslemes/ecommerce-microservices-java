package com.ecommerce.payments.adapters.out;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentKafkaProducer {

    private static final String TOPIC_PAYMANT_APPROVED = "paymant-approved";

    private final KafkaTemplate<String, String> kafkaTemplate;


    public PaymentKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPaymentApproved(Long orderId) {
        String mensage = "Payment approved for order " + orderId;
        kafkaTemplate.send(TOPIC_PAYMANT_APPROVED, mensage);
    }

    public void sendPaymentRefused(Long orderId) {
        String mmensage = "Payment declined for order " + orderId;
        kafkaTemplate.send(TOPIC_PAYMANT_APPROVED, mmensage);
    }


}
