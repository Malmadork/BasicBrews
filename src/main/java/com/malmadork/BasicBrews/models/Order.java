package com.malmadork.BasicBrews.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@ToString
@EqualsAndHashCode
@Table(name="orders")
public class Order extends DomainObject {

    /** Unique, automatically generated id. */
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column( unique = true )
    private Long id;

    /** Unique order number */
    @Column ( unique = true )
    private Long orderNumber;

    /** DateTime object for order */
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss" )
    @Column
    private LocalDateTime dateTime;

    /** Status for the order */
    @Column
    private String status;

    /** Products in an Order */
    @OneToMany
    @JoinTable (inverseJoinColumns = @JoinColumn(name="listitem_id"))
    List<ListItem> products;

    /** Gets the Order's ID */
    @Override
    public Serializable getId() {
        return null;
    }

    /**
     * Set the ID of the Order (Used by Hibernate)
     *
     * @param id ID of the Order
     */
    @SuppressWarnings ( "unused" )
    private void setId ( final Long id ) {
        this.id = id;
    }

    /**
     * Get the Order number
     * @return the Order number
     */
    public Long getOrderNumber() {
        return orderNumber;
    }

    /**
     * Sets the Order's order number
     *
     * @param orderNumber The Order number
     */
    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * Gets the date and time the Order was placed.
     *
     * @return DateTime the order was placed
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Sets the DateTime of the Order
     *
     * @param dateTime DateTime of the Order
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Gets the status of the Order
     *
     * @return Order status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the Order
     *
     * @param status Status of the Order
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the List of Products associated with an Order
     * @return List of Products associated with an Order
     */
    public List<ListItem> getOrderProducts() {
        return products;
    }

    /**
     * Sets the List of Products associated with an Order
     *
     * @param orderProducts List of Products associated with an Order
     */
    public void setOrderProducts(List<ListItem> orderProducts) {
        this.products = orderProducts;
    }

    public void addProductToOrder(Product product, int quantity) {
        ListItem productEntry = new ListItem(product, quantity);
        this.products.add(productEntry);
    }
}
