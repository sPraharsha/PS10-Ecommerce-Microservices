package com.ps10.api_gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {

        return builder.routes()

                // =========================
                // AUTH SERVICE
                // =========================
                .route("auth-service", route -> route
                        .path("/auth/**")
                        .uri("lb://AUTH-SERVICE"))

                // =========================
                // VENDOR SERVICE
                // =========================
                .route("vendor-service", route -> route
                        .path("/vendor/**")
                        .uri("lb://VENDOR-SERVICE"))

                // =========================
                // PRODUCT SERVICE
                // =========================
                .route("product-service", route -> route
                        .path("/product/**")
                        .uri("lb://PRODUCT-SERVICE"))

                .build();
    }
}