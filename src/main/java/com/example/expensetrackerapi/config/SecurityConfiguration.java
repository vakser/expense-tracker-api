package com.example.expensetrackerapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/login", "/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        UserDetails user1 = User.withUsername("bushan").password("12345").authorities("admin").build();
        UserDetails user2 = User.withUsername("bharath").password("12345").authorities("user").build();
        userDetailsManager.createUser(user1);
        userDetailsManager.createUser(user2);
        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
