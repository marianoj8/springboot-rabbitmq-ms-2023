package com.wasp.basedomain.dto;

public record OrderDto(
        Long id,
        String name,
        int qty,
        double price) {
}
