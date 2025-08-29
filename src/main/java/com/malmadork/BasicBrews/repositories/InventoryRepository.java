package com.malmadork.BasicBrews.repositories;

import com.malmadork.BasicBrews.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
