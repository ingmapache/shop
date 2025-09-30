package com.mapache.shop.Domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findById(Long id);
    Optional<Product> findByName(ProductName productName);
    List<Product> getAllBrands();
    Product save(Product product);
    void deleteById(Long id);
}
