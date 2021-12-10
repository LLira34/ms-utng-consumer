package com.utng.tics.consumer.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BaseWebClient {

    @Value("${application.client.product.url}")
    private String productUrl;

    @Bean
    public WebClient webClientProduct() {
        return WebClient.create(productUrl);
    }
}
