package io.logostory.orderbook.backend.controller;

import io.logostory.orderbook.backend.domain.dto.order.OrderDetailDto;
import io.logostory.orderbook.backend.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api")
public class OrderController {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @PostMapping(value = "/orders")
    private ResponseEntity saveOrder(@RequestBody OrderDetailDto orderDetailDto) {

        return ResponseEntity.ok(HttpStatus.CREATED);

    }

    @ExceptionHandler
    @GetMapping(path = "/orders/{orderId}")
    public OrderDetailDto findById(@PathVariable Long orderId) {

        return null;
    }
}
