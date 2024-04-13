package com.pblgllgs.orderservice.mapper;
/*
 *
 * @author pblgl
 * Created on 13-04-2024
 *
 */

import com.pblgllgs.orderservice.dto.OrderRequest;
import com.pblgllgs.orderservice.model.Order;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

public class OrderMapper {

    public static Order dtoToEntity(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        BeanUtils.copyProperties(orderRequest, order);
        return order;
    }
}
