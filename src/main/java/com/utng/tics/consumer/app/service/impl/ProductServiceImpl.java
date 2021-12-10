package com.utng.tics.consumer.app.service.impl;

import com.utng.tics.consumer.app.dto.ProductDTO;
import com.utng.tics.consumer.app.service.ProductService;
import com.utng.tics.consumer.app.web.client.ProductWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductWebClient productWebClient;

    @Override
    public Flux<ProductDTO> findAll() {
        return productWebClient.findAll();
    }

    @Override
    public Mono<ProductDTO> findById(String id) {
        return productWebClient.findById(id);
    }

    @Override
    public Mono<ProductDTO> insert(ProductDTO productDTO) {
        return productWebClient.insert(productDTO);
    }

    @Override
    public Mono<ProductDTO> update(ProductDTO productDTO, String id) {
        return productWebClient.update(productDTO, id);
    }

    @Override
    public Mono<Void> delete(String id) {
        return productWebClient.delete(id);
    }
}
