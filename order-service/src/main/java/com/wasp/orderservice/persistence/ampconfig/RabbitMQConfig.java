package com.wasp.orderservice.persistence.ampconfig;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.queue.stock_queue.name}")
    private String stockQueue;

    @Value("${spring.rabbitmq.queue.email_queue.name}")
    private String emailQueue;


    @Value("${spring.rabbitmq.routing.stock.key}")
    private String stockRoutingKey;

    @Value("${spring.rabbitmq.routing.email.key}")
    private String emailRoutingKey;


    @Value("${spring.rabbitmq.exchange.name}")
    private String exchange;

    @Bean
    public Queue emailQueue() {
        return new Queue(emailQueue);
    }

    @Bean
    public Queue stockQueue() {
        return new Queue(stockQueue);
    }


    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding bindingEmailToExchange() {
        return BindingBuilder
                .bind(emailQueue())
                .to(exchange())
                .with(emailRoutingKey);
    }

    @Bean
    public Binding bindingStockToExchange() {
        return BindingBuilder
                .bind(stockQueue())
                .to(exchange())
                .with(stockRoutingKey);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate factory(ConnectionFactory connection) {
        RabbitTemplate template = new RabbitTemplate(connection);
        template.setMessageConverter(converter());
        return template;
    }

}
