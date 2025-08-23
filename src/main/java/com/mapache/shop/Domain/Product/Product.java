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
    private ProductStock productStock;
    private List<Image> productImages;

    public Product(
            ProductName incproductName,
            Brand incProductBrand,
            ProductDescription incProductDescription,
            Money incProductPrice,
            ProductStock incStock,
            List<Image> incProductImages)
    {
        this.id = null;
        this.productName = Objects.requireNonNull(incproductName, "Product name cannot be null");
        this.productBrand = Objects.requireNonNull(incProductBrand, "Product brand cannot be null.");
        this.productDescription = Objects.requireNonNull(incProductDescription, "Product description cannot be null");
        this.productPrice = Objects.requireNonNull(incProductPrice, "Product price cannot be null.");
        this.productStock = Objects.requireNonNull(incStock, "Product stock cannot be null.");
        this.productImages = Objects.requireNonNull(incProductImages, "Product must have at least one picture.");
    }

    public Product(
            Long incId,
            ProductName incProductName,
            Brand incProductBrand,
            ProductDescription incProductDescription,
            Money incProductPrice,
            ProductStock incStock,
            List<Image> incProductImages
    ) {
        this.id = Objects.requireNonNull(incId, "Id cannot be null");
        if (incId <= 0) throw new IllegalArgumentException("Id must be greater than 0.");

        this.productName = Objects.requireNonNull(incProductName, "Product name cannot be null");
        this.productBrand = Objects.requireNonNull(incProductBrand, "Product brand cannot be null.");
        this.productDescription = Objects.requireNonNull(incProductDescription, "Product description cannot be null");
        this.productPrice = Objects.requireNonNull(incProductPrice, "Product price cannot be null.");
        this.productImages = Objects.requireNonNull(incProductImages, "Product images cannot be null.");
        this.productStock = Objects.requireNonNull(incStock, "Product stock cannot be null.");

        if (incProductImages.isEmpty()) {
            throw new IllegalArgumentException("Product must have at least one picture.");
        }
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

    public List<Image> getProductImages()
    {
        return List.copyOf(productImages);
    }

    public ProductStock getProductStock()
    {
        return productStock;
    }

    public void addStock(ProductStock stockToAdd)
    {
        productStock = productStock.add(stockToAdd);
    }

    public void removeStock(ProductStock stockToRemove)
    {
        productStock = productStock.remove(stockToRemove);
    }

    public void renameProduct(ProductName newProductName)
    {
        productName = Objects.requireNonNull(newProductName, "New product name cannot be null.");;
    }

    public void updateProductBrand(Brand newBrand)
    {
        productBrand = Objects.requireNonNull(newBrand, "New product brand cannot be null.");
    }

    public void updateProductPrice(Money newPrice)
    {
        productPrice = Objects.requireNonNull(newPrice, "New product price cannot be null.");
    }

    public void updateProductDescription(ProductDescription newDescription)
    {
        productDescription = Objects.requireNonNull(newDescription, "New description cannot be null.");
    }

    public void addImage(Image newImage)
    {
        Objects.requireNonNull(newImage, "Image to add cannot be null.");
        productImages.add(newImage);
    }

    public void removeImage(Image imageToRemove)
    {
        Objects.requireNonNull(imageToRemove);

        if(!productImages.contains(imageToRemove)) throw new IllegalArgumentException("Image to remove was not found in selected product.");

        productImages.remove(imageToRemove);
    }
}
