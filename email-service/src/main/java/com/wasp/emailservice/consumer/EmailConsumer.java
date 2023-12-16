package com.wasp.emailservice.consumer;

import com.wasp.basedomain.event.OrderEvent;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@AllArgsConstructor
public class EmailConsumer {
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = {"${spring.rabbitmq.queue.name}"})
    public void consume(OrderEvent event) {
        log.info(String.format("Order event received from Order Service -> %s", event));

        // save event into database...
    }
}
