package com.malmadork.BasicBrews.security;

import org.springframework.boot.autoconfigure.security.StaticResourceLocation;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
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

//    protected void configure (final AuthenticationManagerBuilder auth ) throws Exception {
//        auth.authenticationProvider( authenticationProvider() );
//    }

    @Bean
    public SecurityFilterChain filterChain ( HttpSecurity http ) throws Exception {
        http //Add CSRF
            .csrf(AbstractHttpConfigurer::disable)
            .cors(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests( (authorizations) -> authorizations

//                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//                    .requestMatchers("/api/v1").permitAll()
//                    .requestMatchers( HttpMethod.GET, "/fonts/**", "/register*", "/login*" ).permitAll()
////                    .requestMatchers( HttpMethod.POST, "/register", "/login").permitAll()
                    .requestMatchers("/").authenticated()
                    .anyRequest().permitAll()

            )
                .httpBasic( withDefaults() )
                .formLogin( form -> form
                        .loginPage("/login")
                        .permitAll()
                        .defaultSuccessUrl("/", true)

                )


                .logout( logout -> logout
                        .logoutSuccessUrl("/login"))
                .exceptionHandling( error -> error
                        .accessDeniedPage("/403")
                )

                .authenticationProvider( authenticationProvider() );
        return http.build();
    }
}
