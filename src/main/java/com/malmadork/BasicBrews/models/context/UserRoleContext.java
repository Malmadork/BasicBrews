package com.malmadork.BasicBrews.models.context;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a model for a RequestBody received through the
 * APIUserController
 *
 * @author Marie Schwartz
 */
public class UserRoleContext {
    /** field for the users email */
    String email;

    /** field for the users role */
    final List<String> roles = new ArrayList<>();

    /**
     * Basic constructor for the UserRoleContext wrapper object
     */
    public UserRoleContext () {
    }

    /**
     * Getter for email
     *
     * @return users email
     */
    public String getUsername () {
        return this.email;
    }

    /**
     * Getter for List of Roles
     *
     * @return User roles
     */
    public List<String> getAuthorities () {
        return this.roles;
    }

    /**
     * Setter for the User's email
     *
     * @param email for the new user
     */
    public void setUsername ( final String email ) {
        this.email = email;
    }

    /**
     * Add a Role to the new User
     *
     * @param role for the new user
     */
    public void addRole ( final String role ) {
        roles.add( role );
    }
}
