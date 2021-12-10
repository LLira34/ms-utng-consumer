package com.utng.tics.consumer.app.web.client;

import com.utng.tics.consumer.app.dto.ProductDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SiscomAsyncWebClient {

    Flux<ProductDTO> findAll();

    Mono<ProductDTO> findById(String id);

    Mono<ProductDTO> insert(ProductDTO productDTO);

    Mono<ProductDTO> update(ProductDTO productDTO, String id);

    Mono<Void> delete(String id);
}
