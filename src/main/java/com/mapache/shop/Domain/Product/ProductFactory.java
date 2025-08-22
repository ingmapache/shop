package com.mapache.shop.Domain.Product;

import com.mapache.shop.Domain.Brand.Brand;
import com.mapache.shop.Domain.Shared.Image;

import java.util.List;
import java.util.Objects;

public class ProductFactory {

    public static Product createNew(ProductName incProductName, Brand incBrand, ProductDescription incDescription, Money incPrice, List<Image> incImages)
    {
        Objects.requireNonNull(incProductName, "Product name cannot be null.");
        Objects.requireNonNull(incBrand, "Brand cannot be null.");

        if
    }
}
