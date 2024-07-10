package com.adalbertofjr.RestAPI.repository;

import com.adalbertofjr.RestAPI.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
