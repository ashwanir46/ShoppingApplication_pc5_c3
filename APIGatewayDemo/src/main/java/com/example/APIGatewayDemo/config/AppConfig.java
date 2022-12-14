package com.example.APIGatewayDemo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/userdata/api/v2")
                        .uri("http://authentication-service:8085/")
                ).route(p -> p
                        .path("/userproduct/api/v1")
                        .uri("http://product-service:8081/")
                ).build();
    }
}
