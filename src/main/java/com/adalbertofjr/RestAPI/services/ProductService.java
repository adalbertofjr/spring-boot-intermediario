package com.adalbertofjr.RestAPI.services;

import com.adalbertofjr.RestAPI.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> find(Long id);
    Product create(Product product);
    Optional<Product> update(Long id, Product product);
    void delete(Long id);
}
