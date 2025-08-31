package com.malmadork.BasicBrews.services;

import com.malmadork.BasicBrews.models.Inventory;
import com.malmadork.BasicBrews.models.ListItem;
import com.malmadork.BasicBrews.models.Product;
import com.malmadork.BasicBrews.repositories.InventoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class InventoryService extends Service<Inventory, Long> {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    protected JpaRepository<Inventory, Long> getRepository() {
        return inventoryRepository;
    }

    /**
     * Gets the Inventory instance from the database,
     * creating it if it does not exist.
     *
     * @return Inventory
     */
    public synchronized Inventory getInventory () {
        final List<Inventory> inventoryList = findAll();

        if ( inventoryList != null && inventoryList.size() == 1 ) {
            return inventoryList.get( 0 );
        }
        else {
            final Inventory i = new Inventory( new ArrayList<ListItem>() );
            save( i );
            return i;
        }
    }
}
