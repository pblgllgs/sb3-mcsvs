package com.pblgllgs.orderservice.controller;
/*
 *
 * @author pblgl
 * Created on 08-04-2024
 *
 */

import com.pblgllgs.orderservice.dto.OrderRequest;
import com.pblgllgs.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        return new ResponseEntity<>("Order Placed Successfully", HttpStatus.CREATED);
    }

}
