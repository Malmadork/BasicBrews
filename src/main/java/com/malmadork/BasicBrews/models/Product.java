package com.malmadork.BasicBrews.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Entity
@ToString
@EqualsAndHashCode
public class Product extends DomainObject {

    /** Unique, automatically generated id. */
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column( unique = true )
    private Long id;

    /** Name of a product */
    @Column
    private String name;

    /** Price of a product */
    @Column
    @Min( 0 )
    private Float price;

    /** Description of a product */
    @Column
    private String description;

    /** Inventory for a product */
    @Column
    @Min( 0 )
    private int inventory;

    /** Gets the Product's ID */
    @Override
    public Serializable getId() {
        return id;
    }

    /**
     * Set the ID of the Product (Used by Hibernate)
     *
     * @param id ID of the Product
     */
    @SuppressWarnings ( "unused" )
    private void setId ( final Long id ) {
        this.id = id;
    }

    /**
     * Sets the name of the Product
     *
     * @param name Name of the Product
     */
    public void setName( final String name ) {
        this.name = name;
    }

    /**
     * Sets the price of the Product
     *
     * @param price Price of the Product
     */
    public void setPrice( final Float price ) {
        this.price = price;
    }

    /**
     * Sets the description of the Product
     *
     * @param description Description of the Product
     */
    public void setDescription( final String description ) {
        this.description = description;
    }

    /**
     * Sets the inventory of the Product
     *
     * @param inventory Inventory of the Product
     */
    public void setInventory( final int inventory ) {
        this.inventory = inventory;
    }

    /** Gets the Product's Name */
    public String getName() {
        return name;
    }

    /** Gets the Product's Price */
    public Float getPrice() {
        return price;
    }

    /** Gets the Product's Description */
    public String getDescription() {
        return description;
    }

    /** Gets the Product's Inventory */
    public int getInventory() {
        return inventory;
    }
}
