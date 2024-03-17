package com.ecommerceduo.product.controller;

import com.ecommerceduo.product.model.Product;
import com.ecommerceduo.product.model.exception.DocumentNotFoundException;
import com.ecommerceduo.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductController {
    private Logger log = Logger.getLogger(this.getClass().getName());
    private final ProductService productService;

    @PostMapping
    public ResponseEntity createProduct(@RequestBody final Product product) {
        final Product result = productService.create(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable final String id) {
        log.info(String.format("processing GET request for id %s ", id));
        try {
            final Product product = productService.get(id);
            return ResponseEntity.ok(product);
        } catch (final DocumentNotFoundException e) {
            log.info(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable String id, @RequestBody final Product product) {
        product.setProductId(id);
        productService.update(product);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable final String id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
