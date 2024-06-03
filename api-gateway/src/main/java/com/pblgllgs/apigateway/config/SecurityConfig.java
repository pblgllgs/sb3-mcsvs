package com.pblgllgs.apigateway.config;
/*
 *
 * @author pblgl
 * Created on 23-04-2024
 *
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    private final String[] freeResourceUrl = {
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/api-docs/**",
            "/aggregate/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests( auth ->
                        auth
                                .requestMatchers(freeResourceUrl).permitAll()
                                .anyRequest().authenticated()
                )
                .oauth2ResourceServer( oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                .build();
    }
}
