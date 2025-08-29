package com.malmadork.BasicBrews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.malmadork.BasicBrews.models.user.User;

/**
 * UserRepository is used to provide CRUD operations for the User model.
 * Spring will generate appropriate code with Java Persistence API.
 *
 * @author Marie Schwartz
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a User object with the provided email. Spring will generate code to
     * make this happen.
     *
     * @param email
     *            email of the User
     * @return Found User, null if none.
     */
    User findByEmail ( String email );
}
