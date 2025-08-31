package com.malmadork.BasicBrews.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService () {
        return new MyUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider () {
        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider( userDetailsService() );
        authProvider.setPasswordEncoder( passwordEncoder() );

        return authProvider;
    }

    protected void configure (final AuthenticationManagerBuilder auth ) throws Exception {
        auth.authenticationProvider( authenticationProvider() );
    }

    @Bean
    public SecurityFilterChain filterChain ( HttpSecurity http ) throws Exception {
        http //Add CSRF
            .authorizeHttpRequests( (authorizations) -> authorizations
                    .anyRequest().permitAll()
            )
                .httpBasic( withDefaults() );
        return http.build();
    }
}
