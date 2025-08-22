package com.mapache.shop.Domain.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandRepository {

    Optional<Brand> findById(Long id);
    Optional<Brand> findByName(BrandName brandName);
    List<Brand> getAllBrands();
    Brand save(Brand brand);
    void deleteById(Long id);
}
