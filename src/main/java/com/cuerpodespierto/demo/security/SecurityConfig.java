package com.cuerpodespierto.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests()
                .requestMatchers("/api/auth/**").permitAll() // Permite registro y login sin autenticación
                .anyRequest().authenticated() // El resto requiere JWT
            .and()
            .cors();
        return http.build();
    }
}