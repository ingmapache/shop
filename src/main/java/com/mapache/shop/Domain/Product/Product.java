package com.mapache.shop.Domain.Product;

import com.mapache.shop.Domain.Brand.Brand;
import com.mapache.shop.Domain.Shared.Image;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Product {
    private final Long id;
    private ProductName productName;
    private Brand productBrand;
    private ProductDescription productDescription;
    private Money productPrice;
    private List<Review> productReviews;
    private List<Image> productImages;

    public Product(Long incId, ProductName incproductName, Brand incProductBrand, ProductDescription incProductDescription, Money incProductPrice, List<Review> incProductReviews, List<Image> incProductImages)
    {
        this.id = Objects.requireNonNull(incId, "Id cannot be null");
        this.productName = Objects.requireNonNull(incproductName, "Product name cannot be null");
        this.productBrand = Objects.requireNonNull(incProductBrand, "Product brand cannot be null.");
        this.productDescription = Objects.requireNonNull(incProductDescription, "Product description cannot be null");
        this.productPrice = Objects.requireNonNull(incProductPrice, "Product price cannot be null.");
        this.productReviews = incProductReviews;
        this.productImages = Objects.requireNonNull(incProductImages, "Product must have at least one picture.");
    }

    public Product(ProductName incproductName, Brand incProductBrand, ProductDescription incProductDescription, Money incProductPrice, List<Image> incProductImages)
    {
        this.id = null;
        this.productName = Objects.requireNonNull(incproductName, "Product name cannot be null");
        this.productBrand = Objects.requireNonNull(incProductBrand, "Product brand cannot be null.");
        this.productDescription = Objects.requireNonNull(incProductDescription, "Product description cannot be null");
        this.productPrice = Objects.requireNonNull(incProductPrice, "Product price cannot be null.");
        this.productImages = Objects.requireNonNull(incProductImages, "Product must have at least one picture.");
    }

    public Optional<Long> getId() {
        return Optional.ofNullable(id);
    }

    public ProductName getProductName()
    {
        return productName;
    }

    public Brand getProductBrand()
    {
        return productBrand;
    }

    public ProductDescription getProductDescription()
    {
        return productDescription;
    }

    public Money getProductPrice()
    {
        return productPrice;
    }

    public List<Review> getProductReviews()
    {
        return productReviews;
    }

    public List<Image> getProductImages()
    {
        return productImages;
    }

    public void renameProduct(ProductName newProductName)
    {
        this.productName = Objects.requireNonNull(newProductName, "New product name cannot be null.");;
    }

    public void updateProductBrand(Brand newBrand)
    {
        this.productBrand = Objects.requireNonNull(newBrand, "New product brand cannot be null.");
    }

    public void updateProductPrice(Money newPrice)
    {
        this.productPrice = Objects.requireNonNull(newPrice, "New product price cannot be null.");
    }

    public void addReview(Review newReview)
    {
        Objects.requireNonNull(newReview, "New review cannot be null.");

        if(productReviews.contains(newReview)) throw new IllegalArgumentException("This review already exists for this product.");


        productReviews.add(newReview);
    }

    public

}
