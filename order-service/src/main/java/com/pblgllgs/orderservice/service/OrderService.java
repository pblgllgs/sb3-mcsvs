package com.pblgllgs.orderservice.service;

import com.pblgllgs.orderservice.clients.InventoryClient;
import com.pblgllgs.orderservice.dto.OrderRequest;
import com.pblgllgs.orderservice.mapper.OrderMapper;
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
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest){
        boolean inStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if (!inStock){
            throw new RuntimeException("Not enough stock of product with SKU " + orderRequest.skuCode());
        }
        Order order = OrderMapper.dtoToEntity(orderRequest);
        orderRepository.save(order);
    }

}
