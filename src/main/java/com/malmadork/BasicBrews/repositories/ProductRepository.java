package com.malmadork.BasicBrews.repositories;

import com.malmadork.BasicBrews.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ProductRepository is used to provide CRUD operations for the Product model.
 * Spring will generate appropriate code with Java Persistence API.
 *
 * @author Marie Schwartz
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    /**
     * Finds a Product object with the provided id. Spring will generate code to
     * make this happen.
     *
     * @param name
     *            name of the product
     * @return Found product, null if none.
     */
    Product findByName ( String name );
}
