package com.business.menu_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/menus/endpoints").permitAll()
                        .requestMatchers("/api/menus/add").permitAll()
                        .requestMatchers("/api/menus/all").permitAll()
                        .requestMatchers("/api/menus/pages/all").permitAll()
                        .requestMatchers("/api/menus/{menuId}").permitAll()
                        .requestMatchers("/api/menus/update/{id}").permitAll()
                        .requestMatchers("/api/menus/delete/{id}").permitAll()


                        .anyRequest().authenticated()

                );





        return http.build();
    }



    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
