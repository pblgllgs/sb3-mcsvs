package com.pblgllgs.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/*
 *
 * @author pblgl
 * Created on 08-04-2024
 *
 */
@Table(name = "t_orders")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_number")
    private String orderNumber;
    @Column(name = "sku_code")
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
