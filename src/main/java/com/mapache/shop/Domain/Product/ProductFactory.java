package com.mapache.shop.Domain.Product;

import com.mapache.shop.Domain.Brand.Brand;
import com.mapache.shop.Domain.Brand.BrandRepository;
import com.mapache.shop.Domain.Shared.Image;

import java.util.List;
import java.util.Objects;

public class ProductFactory {

    private final BrandRepository brandRepo;

    public ProductFactory(BrandRepository incBrandRepo)
    {
        if (incBrandRepo == null) {
            throw new IllegalArgumentException("BrandRepository cannot be null.");
        }

        this.brandRepo = incBrandRepo;
    }

    public  Product createNew(
            ProductName incProductName,
            Brand incBrand,
            ProductDescription incDescription,
            Money incPrice,
            ProductStock incStock,
            List<Image> incImages)
    {
        Objects.requireNonNull(incProductName, "Product name cannot be null.");
        Objects.requireNonNull(incBrand, "Brand cannot be null.");
        Objects.requireNonNull(incDescription, "Description cannot be null.");
        Objects.requireNonNull(incPrice, "Product price cannot be null.");
        Objects.requireNonNull(incImages, "Images cannot be null.");
        Objects.requireNonNull(incStock, "Stock cannot be null.");

        if(incImages.isEmpty()) throw new IllegalArgumentException("Product must be created with at least 1 image.");

        Brand brand = brandRepo.findById(incBrand.getId()).orElseThrow(() -> new IllegalArgumentException("Brand doesn't exist."));

        return new Product(incProductName, brand, incDescription, incPrice, incStock, incImages);
    }

    public Product reconstitute(
            Long id,
            ProductName incProductName,
            Brand incBrand,
            ProductDescription incDescription,
            Money incPrice,
            ProductStock incStock,
            List<Image> incImages
    )
    {
        if(id <= 0) throw new IllegalArgumentException("Product Id cannot be 0 or negative.");

        return new Product(incProductName, incBrand, incDescription, incPrice,  incStock, incImages);
    }
}
