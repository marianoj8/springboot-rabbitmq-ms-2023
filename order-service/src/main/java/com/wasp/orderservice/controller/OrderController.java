package com.wasp.orderservice.controller;

import com.wasp.basedomain.dto.OrderDto;
import com.wasp.basedomain.entity.Order;
import com.wasp.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("v1/orders")
@AllArgsConstructor
public class OrderController {
    private OrderService service;

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderDto dto) {
        return new ResponseEntity<>(service.create(dto), CREATED);
    }
}
