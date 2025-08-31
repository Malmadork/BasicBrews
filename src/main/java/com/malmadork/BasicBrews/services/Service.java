package com.malmadork.BasicBrews.services;

import com.malmadork.BasicBrews.models.DomainObject;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * An abstract class for providing CRUD operations with a Database.
 * Each Service class requires an accompanying Repository.
 *
 * @param <Type> Type of DomainObject
 * @param <Key> Key for that Entity
 */
abstract public class Service <Type extends DomainObject, Key> {

    /**
     * Returns a JPA Repository instance
     *
     * @return Repository Instance
     */
    abstract protected JpaRepository<Type, Key> getRepository ();

    /**
     * Saves an object into the Database
     *
     * @param object Object to Save
     */
    public void save ( final Type object ) {
        getRepository().saveAndFlush( object );
    }

    /**
     * Saves a List of objects into the Database
     *
     * @param objects List of Objects to Save
     */
    public void saveAll ( final List<Type> objects ) {
        getRepository().saveAllAndFlush( objects );
    }

    /**
     * Returns all objects of this Type that exist in the Database.
     *
     * @return All records of Type stored in the Database.
     */
    public List<Type> findAll () {
        return getRepository().findAll();
    }

    /**
     * Returns one or more objects from the database by
     * matching against an Example.
     *
     * @param example An example to match against.
     * @return Matching records, empty List if none found.
     */
    protected List<Type> findBy ( final Example<Type> example ) {
        return getRepository().findAll( example );
    }

    /**
     * Deletes an object from the Database
     *
     * @param object Object to delete from the Database.
     */
    public void delete ( final Type object ) {
        getRepository().delete( object );
    }

    /**
     * Deletes all objects of Type from the Database.
     *
     * Be very careful, as this is a volatile and irreversible method.
     */
    public void deleteAll ( ) {
        getRepository().deleteAll();
    }

    /**
     * Returns a count of the number of objects of
     * Type stored in the Database.
     *
     * @return Number of objects in the Database
     */
    public long count () {
        return getRepository().count();
    }

    /**
     * Checks if the object exists in the Database.
     *
     * @param id Key of the object to check
     * @return boolean if the object was found
     */
    public boolean existsById ( final Key id ) {
        return getRepository().existsById( id );
    }

    /**
     * Gets an Object with the provided ID
     *
     * @param id Key/ID of the object
     * @return Found object of Type, null if not found
     */
    public Type findById ( final Key id ) {
        if ( id == null ) {
            return null;
        }
        final Optional<Type> result = getRepository().findById( id );
        if ( result.isPresent() ) return result.get();

        return null;
    }

}








