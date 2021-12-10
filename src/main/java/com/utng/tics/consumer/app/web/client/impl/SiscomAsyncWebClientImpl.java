package com.utng.tics.consumer.app.web.client.impl;

import com.utng.tics.consumer.app.dto.ProductDTO;
import com.utng.tics.consumer.app.web.client.SiscomAsyncWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class SiscomAsyncWebClientImpl implements SiscomAsyncWebClient {

    @Autowired
    @Qualifier("webClientSiscomAsync")
    private WebClient webClient;

    @Override
    public Flux<ProductDTO> findAll() {
        return webClient
                .get()
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToFlux(clientResponse -> clientResponse.bodyToFlux(ProductDTO.class));
    }

    @Override
    public Mono<ProductDTO> findById(String id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        return webClient
                .get()
                .uri("/{id}", params)
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(ProductDTO.class));
    }

    @Override
    public Mono<ProductDTO> insert(ProductDTO productDTO) {
        return webClient
                .post()
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(productDTO)
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(ProductDTO.class));
    }

    @Override
    public Mono<ProductDTO> update(ProductDTO productDTO, String id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        return webClient
                .put()
                .uri("/{id}", params)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(productDTO)
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(ProductDTO.class));
    }

    @Override
    public Mono<Void> delete(String id) {
        return webClient
                .delete()
                .uri("/{id}", Collections.singletonMap("id", id))
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(Void.class));
    }
}
