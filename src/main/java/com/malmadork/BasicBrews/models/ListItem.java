package com.malmadork.BasicBrews.models;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 * This class represents a Product within
 * an Order or Inventory List.
 *
 * This entity is associated with a Product and
 * contains a value for quantity of that product.
 *
 * @author Marie Schwartz
 */
@Entity
public class ListItem extends DomainObject {

    /** Unique, automatically generated id. */
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (unique = true)
    Long id;

    /**
     * Associated Product
     */
    @ManyToOne
    @JoinColumn( name = "product_id" )
    Product product;


    /** Quantity of products in a list item */
    @Column
    int quantity;

    /**
     * Constructor for ListItem
     *
     * @param product Associated Product
     * @param quantity Quantity of Product
     */
    public ListItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /** Gets this Object's ID */
    @Override
    public Serializable getId() {
        return id;
    }

    /**
     * Set the ID of this object (Used by Hibernate)
     *
     * @param id ID of this Object
     */
    @SuppressWarnings ( "unused" )
    private void setId ( final Long id ) {
        this.id = id;
    }


    /**
     * Get Product
     * @return Product to get
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Set Product
     * @param product Product to Set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Get the quantity of each Product
     *
     * @return Quantity of each Product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of each Product
     * @param quantity the quantity of each Product
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
