package com.adalbertofjr.RestAPI.services;

import com.adalbertofjr.RestAPI.models.Product;
import com.adalbertofjr.RestAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Optional<Product> find(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Product create(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Optional<Product> update(Long id, Product product) {
        return this.productRepository.findById(id).map(record -> {
            record.setName(product.getName());
            record.setQtd(product.getQtd());
            Product updated = this.productRepository.save(record);
            return updated;
        });
    }

    @Override
    public void delete(Long id) {
        Optional<Product> product = this.productRepository.findById(id);
        if (product.isPresent())this.productRepository.deleteById(id);
    }
}
