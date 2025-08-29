package com.malmadork.BasicBrews.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents product Inventory.
 *
 * Inventory contains a List of Products
 * (Joined using the ListItem object which contains
 * a quantity associated with each product)
 *
 * @author Marie Schwartz
 */
@Entity
public class Inventory extends DomainObject {

    /** ID for inventory entry */
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    /** List of Products **/
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinTable (inverseJoinColumns = @JoinColumn(name="listitem_id"))
    private List<ListItem> products;

    /**
     * Empty constructor for Hibernate
     */
    public Inventory () {
        this.products = new ArrayList<ListItem>();
    }

    /**
     * Gets the ID of the entry in the DB
     *
     * @return ID
     */
    @Override
    public Long getId () {
        return id;
    }

    /**
     * Set the ID of the Inventory (Used by Hibernate)
     *
     * @param id the ID
     */
    public void setId ( final Long id ) {
        this.id = id;
    }

    /**
     * Returns the list of Products in the inventory.
     *
     * @return ingredient list
     */
    public List<ListItem> getInventory() {
        return products;
    }
}
