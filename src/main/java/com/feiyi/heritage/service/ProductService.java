package com.feiyi.heritage.service;

import com.feiyi.heritage.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    List<Product> searchProducts(String keyword);
    List<Product> getProductsByPriceRange(Double maxPrice);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Long id);
    Product updateStock(Long id, int stock);
} 