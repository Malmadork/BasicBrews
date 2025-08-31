package com.malmadork.BasicBrews.security;

import com.malmadork.BasicBrews.models.user.Role;
import com.malmadork.BasicBrews.models.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class MyUserDetails implements UserDetails {

    /** An authenticated User. */
    private final User user;

    /**
     * Creates MyUserDetails about the provided User.
     *
     * @param user Authenticated User.
     */
    public MyUserDetails (final User user ) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final Set<Role> roles = user.getRoles();
        final List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        for (final Role role : roles ) {
            authorityList.add( new SimpleGrantedAuthority( role.getName() ) );
        }
        return authorityList;
    }


    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
