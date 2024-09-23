package com.ecommerce.orders.adapters.out;

import com.ecommerce.orders.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderKafkaProducer {

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public OrderKafkaProducer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate =kafkaTemplate;
    }

    public void sendOrder(Order order) {
        kafkaTemplate.send("orderTopic", order);
    }
}
