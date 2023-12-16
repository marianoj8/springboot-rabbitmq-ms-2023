package com.wasp.orderservice.producer;

import com.wasp.basedomain.entity.Order;
import com.wasp.basedomain.event.OrderEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.routing.stock.key}")
    private String stockRoutingKey;

    @Value("${spring.rabbitmq.routing.email.key}")
    private String emailRoutingKey;

    @Value("${spring.rabbitmq.exchange.name}")
    private String exchange;

    public void produce(OrderEvent event) {
        rabbitTemplate.convertAndSend(exchange, stockRoutingKey, event);
        rabbitTemplate.convertAndSend(exchange, emailRoutingKey, event);
    }
}
