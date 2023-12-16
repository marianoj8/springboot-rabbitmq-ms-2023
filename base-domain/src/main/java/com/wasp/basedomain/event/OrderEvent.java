package com.wasp.basedomain.event;

import com.wasp.basedomain.dto.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {
    private String status;
    private String message;
    private OrderDto orderDto;
}
