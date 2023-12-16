package com.wasp.stockservice.consumer;

import com.wasp.basedomain.entity.Order;
import com.wasp.basedomain.event.OrderEvent;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class StockConsumer {

    @RabbitListener(queues = {"${spring.rabbitmq.queue.name}"})
    public void consume(OrderEvent event) {
        log.info(String.format("Event received from Order-Service: %s", event));

        // save event into database
    }
}
