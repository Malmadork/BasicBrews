package com.malmadork.BasicBrews.models.user;

import com.malmadork.BasicBrews.models.DomainObject;
import com.malmadork.BasicBrews.models.ListItem;
import com.malmadork.BasicBrews.models.Order;
import com.malmadork.BasicBrews.models.Product;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class represents a User.
 *
 * Users have an email and password used for login,
 * as well as a First and Last Name provided when created.
 *
 * Users also have a list of Roles used for Authorization.
 *
 * Additionally, Users are associated with a list of Orders
 * they have placed.
 *
 * @author Marie Schwartz
 */
@Entity
@ToString
@EqualsAndHashCode
public class User extends DomainObject {

    /** Unique, automatically generated id. */
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (unique = true)
    private Long id;

    /** Unique email for a user account. */
    @Column ( unique = true )
    private String email;

    /** The password is salted and hashed before storage. */
    private String password;

    /** User's first name */
    @Column
    private String firstname;

    /** User's last name */
    @Column
    private String lastname;

    /** Collection of roles that designate a User's authorities */
    @ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinTable ( name = "user_roles", joinColumns = @JoinColumn ( name = "user_id" ),
            inverseJoinColumns = @JoinColumn ( name = "roles_id" ) )
    private Set<Role> roles;

    /** Orders the User has placed */
    @ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinTable ( name = "user_orders", joinColumns = @JoinColumn ( name = "user_id" ),
            inverseJoinColumns = @JoinColumn ( name = "order_id" ) )
    private List<Order> orders;

    /** Items in the User's Cart */
    @OneToMany
    @JoinTable (inverseJoinColumns = @JoinColumn(name="listitem_id"))
    List<ListItem> cart;

    /**
     * Setter for giving roles to the User
     *
     * @param roles Set&lt;Role&rt; Set of Roles for the User
     */
    public void setRoles ( final Set<Role> roles ) {
        this.roles = roles;
    }

    /**
     * Constructs a new User with a new secret salt value.
     */
    public User () {
        super();
    }

    /** Gets the User's ID */
    @Override
    public Serializable getId() {
        return id;
    }

    /**
     * Set the ID of the User (Used by Hibernate)
     *
     * @param id ID of the User
     */
    @SuppressWarnings ( "unused" )
    private void setId ( final Long id ) {
        this.id = id;
    }

    /**
     * Gets the email of the User account.
     *
     * @return The email of the User.
     */
    public String getEmail () {
        return email;
    }

    /**
     * Sets the email of the User account.
     *
     * @param email String The email of the User.
     */
    public void setEmail ( final String email ) {
        if ( email == null || email.length() == 0 ) {
            throw new IllegalArgumentException( "Invalid user name." );
        }
        this.email = email;
    }

    /**
     * Returns the password of the User account.
     *
     * @return The password of the User account.
     */
    public String getPassword () {
        return password;
    }

    /**
     * Sets the password of the User account.
     *
     * @param password String The password of the User account.
     */
    public void setPassword ( final String password ) {
        if ( password == null || password.length() == 0 ) {
            throw new IllegalArgumentException( "Invalid password." );
        }
        this.password = password;
    }

    /**
     * Returns the roles of the User account.
     *
     * @return The roles of the User account.
     */
    @ManyToMany
    public Set<Role> getRoles () {
        return roles;
    }

    /**
     * Sets the roles of the User account.
     *
     * @param roles Collection The roles of the User account.
     */
    public void setRoles ( final HashSet<Role> roles ) {
        if ( roles == null || roles.isEmpty() ) {
            throw new IllegalArgumentException( "User must have a role." );
        }
        this.roles = roles;
    }

    /**
     * Returns the orders of the User account.
     *
     * @return The orders of the User account.
     */
    @ManyToMany
    public List<Order> getOrders () {
        return orders;
    }

    /**
     * Sets the orders of the User account.
     *
     * @param orders Collection The roles of the User account.
     */
    public void setRoles ( final ArrayList<Order> orders ) {
        this.orders = orders;
    }

    /**
     * Adds an Order to the User.
     *
     * @param order The Order to add.
     */
    public void addOrder ( final Order order ) {
        for ( final Order i : orders ) {
            if ( i.getId().equals( order.getId() ) ) {
                throw new IllegalArgumentException( "Order already exists in user" );
            }
        }
        this.orders.add( order );
    }

    /**
     * Gets the User's First Name
     *
     * @return User First Name
     * */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the User's First Name
     *
     * @param firstname First Name to Set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets the User's Last Name
     *
     * @return User's Last Name
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the User's Last Name
     *
     * @param lastname Last Name to Set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets the ListItem (Products) in a User's Cart
     *
     * @return List of ListItem (Products)
     */
    public List<ListItem> getCart() {
        return cart;
    }

    /**
     * Adds a product to a User's Cart
     *
     * @param product Product to add
     * @param quantity Quantity of Product
     */
    public void addToCart(Product product, int quantity) {
        ListItem productEntry = new ListItem(product, quantity);
        this.cart.add(productEntry);
    }

    /**
     * Clears a User's Cart
     */
    public void clearCart() {
        this.cart.clear();
    }
}
