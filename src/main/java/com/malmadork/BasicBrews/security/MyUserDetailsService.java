package com.malmadork.BasicBrews.security;

import com.malmadork.BasicBrews.models.user.User;
import com.malmadork.BasicBrews.repositories.UserRepository;
import com.malmadork.BasicBrews.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService extends Service<User, Long> implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    protected JpaRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    public UserDetails loadUserByUsername( final String email ) throws UsernameNotFoundException {
        final User user = userRepository.findByEmail( email );
        if( user == null ) {
            throw new UsernameNotFoundException( "User with provided email not found." );
        }
        return new MyUserDetails( user );
    }
}
