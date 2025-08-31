package com.malmadork.BasicBrews.services;

import com.malmadork.BasicBrews.models.Order;
import com.malmadork.BasicBrews.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class OrderService extends Service<Order, Long> {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    protected JpaRepository<Order, Long> getRepository() {
        return orderRepository;
    }

    /**
     * Gets an Order by its order number
     *
     * @param orderNumber Order Number
     * @return Order from the database.
     */
    public Order findByOrderNumber ( final Long orderNumber ) {
        return orderRepository.findByOrderNumber( orderNumber );
    }
}
