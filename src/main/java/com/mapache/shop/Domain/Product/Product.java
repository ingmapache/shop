package com.mapache.shop.Domain.Product;

import com.mapache.shop.Domain.Shared.Image;

import java.util.List;
import java.util.Objects;

public class Product {
    private final Long id;
    private ProductName productName;
    private ProductDescription productDescription;
    private Review productReview;
    private List<Image> productImages

    public Product(Long id, ProductName productName, ProductDescription productDescription, Review productReview, List<Image> productImages)
    {
        this.id = Objects.requireNonNull(id, "Id cannot be null");
        this.productName = Objects.requireNonNull(productName, "Product name cannot be null");
        this.productDescription = Objects.requireNonNull(productDescription, "Product description cannot be null");
        this.productReview = productReview;
        this.productImages = Objects.requireNonNull(productImages, "Product must have at least one picture.");
    }


}
