package com.malmadork.BasicBrews.models.context;

/**
 * This class is a model for a RequestBody received through the
 * APIUserController
 *
 * @author Marie Schwartz
 */
public class UserContext {

    /** Field for the users email */
    String email;

    /** Field for the users password */
    String password;

    /**
     * Basic constructor for the UserContext wrapper object
     */
    public UserContext () {

    }

    /**
     * Getter for mail
     *
     * @return users username
     */
    public String getEmail () {
        return this.email;
    }

    /**
     * Getter for password
     *
     * @return users password
     */
    public String getPassword () {
        return this.password;
    }

    /**
     * Setter for the users email
     *
     * @param email
     *            for the new User
     */
    public void setUsername ( final String email ) {
        this.email = email;
    }

    /**
     * Setter for the users password
     *
     * @param password
     *            for the new user
     */
    public void setPassword ( final String password ) {
        this.password = password;
    }
}
