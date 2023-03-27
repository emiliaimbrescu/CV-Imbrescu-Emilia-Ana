package org.example.Repository;

import org.example.Domain.Student;
import org.example.Domain.ValidationException;

public interface Repository0 {

    /**
     *
     * @param id -the id of the entity to be returned
     *           id must not be null
     * @return the entity with the specified id
     *          or null - if there is no entity with the given id
     * @throws IllegalArgumentException
     *                  if id is null.
     */
    Student findOne(Long id);

    /**
     *
     * @return all entities
     */
    Iterable<Student> findAll();

    /**
     *
     * @param entity
     *         entity must be not null
     * @return null- if the given entity is saved
     *         otherwise returns the entity (id already exists)
     * @throws ValidationException
     *     if the entity is not valid
     * @throws IllegalArgumentException
     *             if the given entity is null.     *
     */
    Student save(Student entity);


    /**
     *  removes the entity with the specified id
     * @param id
     *      id must be not null
     * @return the removed entity or null if there is no entity with the given id
     * @throws IllegalArgumentException
     *                   if the given id is null.
     */
    Student delete(Long id);


}

