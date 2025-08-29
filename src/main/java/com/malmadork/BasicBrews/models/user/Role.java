package com.malmadork.BasicBrews.models.user;

import com.malmadork.BasicBrews.models.DomainObject;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * This class represents a User Role, used for authorization
 * when accessing certain functionalities.
 *
 * @author Marie Schwartz
 */
@Entity
@ToString
@EqualsAndHashCode
public class Role extends DomainObject {

    /** Unique, automatically generated id. */
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    @Column ( unique = true )
    private Long id;

    /** The name of a Role */
    @Column
    private String name;

    /**
     * Gets Role ID
     *
     * @return ID of a Role Object
     */
    @Override
    public Serializable getId() {
        return id;
    }

    /**
     * Returns the name of a Role.
     *
     * @return The name of this Role
     */
    public String getName () {
        return name;
    }

    /**
     * Sets the name of this Role.
     *
     * @param name String The name of the Role.
     */
    public void setName ( final String name ) {
        this.name = name;
    }

    /**
     * Set the ID of the Role (Used by Hibernate)
     *
     * @param id Long ID of the Role
     */
    @SuppressWarnings ( "unused" )
    private void setId ( final Long id ) {
        this.id = id;
    }

}
