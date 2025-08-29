package com.malmadork.BasicBrews.repositories;

import com.malmadork.BasicBrews.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * OrderRepository is used to provide CRUD operations for the Order model.
 * Spring will generate appropriate code with Java Persistence API.
 *
 * @author Marie Schwartz
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

    /**
     * Finds a Order object with the provided id. Spring will generate code to
     * make this happen.
     *
     * @param id
     *            id of the order
     * @return Found order, null if none.
     */
    Order findById ( long id );

    /**
     * Finds a Order object with the provided order number.
     * Spring will generate code to make this happen.
     *
     * @param orderNumber
     *            id of the order
     * @return Found order, null if none.
     */
    Order findByOrderNumber ( long orderNumber );
}
