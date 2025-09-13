package com.malmadork.BasicBrews.controllers;

import com.malmadork.BasicBrews.models.context.UserContext;
import com.malmadork.BasicBrews.models.user.Role;
import com.malmadork.BasicBrews.models.user.User;
import com.malmadork.BasicBrews.security.MyUserDetailsService;
import com.malmadork.BasicBrews.security.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
public class APIUserController extends APIController {

    @Autowired
    private MyUserDetailsService service;

    @Autowired
    private WebSecurityConfig security;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping ( "/register" )
    public ResponseEntity<String> register ( @RequestBody final UserContext user ) {
        // no longer @ModelAttribute final UserContext user
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        return createNewUser("USER", user);
    }

    @PostMapping ( BASE_PATH + "/users" )
    public ResponseEntity<String> createNewUser(@RequestParam final String role, @RequestBody final UserContext user ) {

        if ( user.getEmail() == null || user.getEmail().isEmpty() ) {
            return new ResponseEntity<>( errorResponse("Email cannot be empty."), HttpStatus.BAD_REQUEST);
        }
        if ( user.getPassword() == null || user.getPassword().isEmpty() ) {
            return new ResponseEntity<>( errorResponse("Password cannot be empty."), HttpStatus.BAD_REQUEST);
        }

        if( role == null || role.isEmpty() ) {
            return new ResponseEntity<>( errorResponse("Role cannot be empty."), HttpStatus.BAD_REQUEST);
        }

        if( !"USER".equals(role) && !"EMPLOYEE".equals(role) ) {
            return new ResponseEntity<>( errorResponse("Invalid role."), HttpStatus.BAD_REQUEST);
        }

        try {
            if ( null != service.loadUserByUsername( user.getEmail() ) ) {
                return new ResponseEntity<>( errorResponse("Username with the email" + user.getEmail() + " already exists."), HttpStatus.CONFLICT);
            }
        }
        catch( final UsernameNotFoundException e ) {
            // This exception is expected if the user does not exist. Continue
            // with user creation.
        }

        final Set<Role> roles = new HashSet<>();
        final Role userRole = new Role();

        userRole.setName( role.toUpperCase() );
        roles.add( userRole );

        bCryptPasswordEncoder = security.passwordEncoder();

        final User newUser = new User();
        newUser.setEmail( user.getEmail() );
        newUser.setPassword( bCryptPasswordEncoder.encode( user.getPassword()) );

        newUser.setRoles( roles );

        service.save( newUser );

        return new ResponseEntity<>( successResponse("Successfully created new user"), HttpStatus.OK);
    }

}
