package com.feiyi.heritage.repository;

import com.feiyi.heritage.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingOrDescriptionContaining(String name, String description);
    List<Product> findByPriceLessThanEqual(Double price);
} 