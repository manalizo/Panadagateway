package com.heins.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfiguration {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("mclientsModule", r -> r.path("/clients/**")
                        .uri("lb://mclients")  // Correct format for mclients service
                )
                .route("mcommandesModule", r -> r.path("/commandes/**")
                        .uri("lb://mcommandes")  // Correct format for mcommandes service
                )
                .route("microserviceProduitsModule", r -> r.path("/products/**")
                        .uri("lb://microservice-produits")  // Correct format for microservice-produits service
                )
                .build();
    }
}
