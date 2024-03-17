package com.ecommerceduo.product.service;

import com.ecommerceduo.product.model.Product;
import com.ecommerceduo.product.model.exception.DocumentNotFoundException;
import com.ecommerceduo.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product create(final Product product) {
        return productRepository.insert(product);
    }

    public Product get(final String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new DocumentNotFoundException(String.format("document cannot be found with id %s", id)));
    }

    public void update(final Product product) throws DocumentNotFoundException{
        final Product document = this.get(product.getProductId());
        document.setPrice(product.getPrice());
        document.setProductTitle(product.getProductTitle());
        document.setProductDescription(product.getProductDescription());
        productRepository.save(document);
    }

    public void delete(final String id) {
        productRepository.deleteById(id);
    }
}
