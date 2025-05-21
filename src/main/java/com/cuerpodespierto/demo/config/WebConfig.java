package com.cuerpodespierto.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.lang.NonNull;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:5173") // puerto de Vite
            .allowedMethods("*")
            .allowedHeaders("*")
            .allowCredentials(true);
    }
 }

