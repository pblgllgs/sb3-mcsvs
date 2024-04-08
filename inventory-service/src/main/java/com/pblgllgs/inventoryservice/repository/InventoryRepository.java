package com.pblgllgs.inventoryservice.repository;
/*
 *
 * @author pblgl
 * Created on 08-04-2024
 *
 */

import com.pblgllgs.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, int quantity);
}
