package com.mapache.shop.Domain.Product.Events;

import com.mapache.shop.Domain.Category.Category;
import com.mapache.shop.Domain.Product.ProductName;
import com.mapache.shop.Domain.Product.ProductStock;
import com.mapache.shop.Domain.Shared.DomainEvent;

import java.time.LocalDateTime;
import java.util.Objects;

public class ProductCreationEvent implements DomainEvent {

    private final Long productId;
    private final Long sellerId;
    private final LocalDateTime ocurredAt;
    private final ProductName productName;
    private final Category productCategory;
    private final ProductStock productStock;

    private final int lowStock = 5;

    public ProductCreationEvent (Long incProductId, Long incSellerId, Category incCategory, ProductName incProductName, ProductStock incProductStock)
    {
        this.ocurredAt = java.time.LocalDateTime.now();
        this.productId = Objects.requireNonNull(incProductId, "Product Id cannot be null.");
        this.sellerId = Objects.requireNonNull(incSellerId, "Seller Id cannot be null.");
        this.productName = Objects.requireNonNull(incProductName, "Product name cannot be null.");
        this.productCategory = Objects.requireNonNull(incCategory, "Category cannot be null.");
        this.productStock = Objects.requireNonNull(incProductStock, "ProductStock cannot be null.");

        if(incProductId <= 0 || sellerId <= 0) throw new IllegalArgumentException("Seller id and Product id cannot be 0 or have a negative value.");
    }

    public Long getProductId()
    {
        return productId;
    }

    public Long getSellerId()
    {
        return sellerId;
    }

    public ProductName getProductName()
    {
        return productName;
    }

    public Category getProductCategory()
    {
        return  productCategory;
    }

    public ProductStock getProductStock()
    {
        return productStock;
    }

    @Override
    public LocalDateTime ocurredAt() {

        return ocurredAt;
    }

    @Override
    public String eventType() {
        return "Product creation.";
    }
}
