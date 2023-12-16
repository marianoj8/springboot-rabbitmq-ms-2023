package com.wasp.basedomain.mapper;

import com.wasp.basedomain.dto.OrderDto;
import com.wasp.basedomain.entity.Order;

public class OrderMapper {
    public static OrderDto modelToDto(Order model) {
        return model == null ? null : new OrderDto(
                model.getId(),
                model.getName(),
                model.getQty(),
                model.getPrice());
    }

    public static Order dtoToModel(OrderDto dto) {
        return dto == null ? null : new Order(
                dto.id(),
                dto.name(),
                dto.qty(),
                dto.price());
    }
}
