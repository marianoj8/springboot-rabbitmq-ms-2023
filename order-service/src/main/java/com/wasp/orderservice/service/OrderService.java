package com.wasp.orderservice.service;

import com.wasp.basedomain.dto.OrderDto;
import com.wasp.basedomain.entity.Order;
import com.wasp.basedomain.event.OrderEvent;
import com.wasp.orderservice.producer.OrderProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.wasp.basedomain.mapper.OrderMapper.dtoToModel;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderProducer producer;

    public Order create(OrderDto dto) {
        producer.produce(new OrderEvent(
                "PENDING",
                "Order is in pending status...",
                dto));

        return dtoToModel(dto);
    }
}
