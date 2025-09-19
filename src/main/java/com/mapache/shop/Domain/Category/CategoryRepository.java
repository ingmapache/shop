package com.mapache.shop.Domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

    Optional<Category> findById(Long id);
    Optional<Category> findByName(CategoryName categoryName);
    List<Category> getAllBrands();
    Category save(Category category);
    void deleteById(Long id);
}
