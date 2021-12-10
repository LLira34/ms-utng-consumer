package com.utng.tics.consumer.app.web.router.handler;

import com.utng.tics.consumer.app.dto.ProductDTO;
import com.utng.tics.consumer.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ProductHandler {

    @Autowired
    private ProductService productService;

    public Mono<ServerResponse> findAll(ServerRequest serverRequest) {
        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(productService.findAll(), ProductDTO.class);
    }

    public Mono<ServerResponse> findById(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");

        return productService
            .findById(id)
            .flatMap(productDTO -> ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(productDTO))
            .switchIfEmpty(ServerResponse.notFound().build());
    }
}
