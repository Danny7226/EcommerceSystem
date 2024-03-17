package com.ecommerceduo.product.repository;

import com.ecommerceduo.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
