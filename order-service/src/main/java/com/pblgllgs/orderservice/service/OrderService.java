package com.pblgllgs.orderservice.service;

import com.pblgllgs.orderservice.dto.OrderRequest;
import com.pblgllgs.orderservice.model.Order;
import com.pblgllgs.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/*
 *
 * @author pblgl
 * Created on 08-04-2024
 *
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());
        orderRepository.save(order);
    }


}
