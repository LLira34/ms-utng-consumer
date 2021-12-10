package com.utng.tics.consumer.app.service.impl;

import com.utng.tics.consumer.app.dto.ProductDTO;
import com.utng.tics.consumer.app.service.ProductService;
import com.utng.tics.consumer.app.web.client.SiscomAsyncWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private SiscomAsyncWebClient siscomAsyncWebClient;

    @Override
    public Flux<ProductDTO> findAll() {
        return siscomAsyncWebClient.findAll();
    }

    @Override
    public Mono<ProductDTO> findById(String id) {
        return siscomAsyncWebClient.findById(id);
    }

    @Override
    public Mono<ProductDTO> insert(ProductDTO productDTO) {
        return siscomAsyncWebClient.insert(productDTO);
    }

    @Override
    public Mono<ProductDTO> update(ProductDTO productDTO, String id) {
        return siscomAsyncWebClient.update(productDTO, id);
    }

    @Override
    public Mono<Void> delete(String id) {
        return siscomAsyncWebClient.delete(id);
    }
}
