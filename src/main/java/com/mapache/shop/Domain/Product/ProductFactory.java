package com.mapache.shop.Domain.Product;

import com.mapache.shop.Domain.Brand.Brand;
import com.mapache.shop.Domain.Brand.BrandRepository;
import com.mapache.shop.Domain.Category.Category;
import com.mapache.shop.Domain.Category.CategoryRepository;
import com.mapache.shop.Domain.Product.Events.ProductCreationEvent;
import com.mapache.shop.Domain.Shared.Image;
import com.mapache.shop.Domain.Shared.Money;

import java.util.List;
import java.util.Objects;

public class ProductFactory {

    private final BrandRepository brandRepo;
    private final CategoryRepository categoryRepo;

    public ProductFactory(BrandRepository incBrandRepo, CategoryRepository incCategoryRepo)
    {
        if (incBrandRepo == null) {
            throw new IllegalArgumentException("BrandRepository cannot be null.");
        }

        if (incCategoryRepo == null) {
            throw new IllegalArgumentException("CategoryRepository cannot be null.");
        }

        this.brandRepo = incBrandRepo;
        this.categoryRepo = incCategoryRepo;
    }

    public  Product createNew(
            Long incSellerId,
            ProductName incProductName,
            Brand incBrand,
            Category incCategory,
            ProductDescription incDescription,
            Money incPrice,
            ProductStock incStock,
            List<Image> incImages)
    {
        Objects.requireNonNull(incSellerId, "Seller id cannot be null.");
        Objects.requireNonNull(incProductName, "Product name cannot be null.");
        Objects.requireNonNull(incBrand, "Brand cannot be null.");
        Objects.requireNonNull(incCategory, "Category cannot be null.");
        Objects.requireNonNull(incDescription, "Description cannot be null.");
        Objects.requireNonNull(incPrice, "Product price cannot be null.");
        Objects.requireNonNull(incImages, "Images cannot be null.");
        Objects.requireNonNull(incStock, "Stock cannot be null.");

        if(incImages.isEmpty()) throw new IllegalArgumentException("Product must be created with at least 1 image.");

        Brand brand = brandRepo.findById(incBrand.getId()).orElseThrow(() -> new IllegalArgumentException("Brand doesn't exist."));
        Category category = categoryRepo.findById(incCategory.getId()).orElseThrow(() -> new IllegalArgumentException("Category doesn't exist."));

        return new Product(incSellerId, incProductName, brand, category, incDescription, incPrice, incStock, incImages);
    }

    public Product fromStorage(
            Long incId,
            Long incSellerId,
            ProductName incProductName,
            Brand incBrand,
            Category incCategory,
            ProductDescription incDescription,
            Money incPrice,
            ProductStock incStock,
            List<Image> incImages
    )
    {
        if(incId <= 0) throw new IllegalArgumentException("Product Id cannot be 0 or negative.");
        if(incSellerId <= 0) throw new IllegalArgumentException("Seller Id cannot be 0 or negative.");

        return new Product(incId, incSellerId, incProductName, incBrand, incCategory, incDescription, incPrice,  incStock, incImages);
    }
}
