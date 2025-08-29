package com.malmadork.BasicBrews.models;

import java.io.Serializable;

/**
 * Used to provide a common superclass for models and services.
 *
 * @author Marie Schwartz
 */
abstract public class DomainObject {

    /**
     * Returns the ID of this object, used for identifying this object
     * for persistent storage in the database.
     *
     * @return ID of the DomainObject
     */
    public abstract Serializable getId ();
}


