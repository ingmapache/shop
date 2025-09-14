package com.mapache.shop.Domain.Product.Events;

import com.mapache.shop.Domain.Product.ProductName;
import com.mapache.shop.Domain.Product.ProductStock;
import com.mapache.shop.Domain.Shared.DomainEvent;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class LowStockEvent implements DomainEvent {

    private final Long productId;
    private final Long sellerId;
    private final ProductName productName;
    private final ProductStock productStock;
    private final LocalDateTime ocurredAt;


    public LowStockEvent(Long incProductId, ProductName incProductName, Long incSellerId, ProductStock incProductStock)
    {
        this.productId = Objects.requireNonNull(incProductId, "Product id cannot be null.");
        this.productStock = Objects.requireNonNull(incProductStock, "Product stock cannot be null.");
        this.sellerId = Objects.requireNonNull(incSellerId, "Seller id cannot be null.");
        this.productName = Objects.requireNonNull(incProductName, "Product name cannot be null.");
        this.ocurredAt = java.time.LocalDateTime.now();
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
        return "Low stock";
    }
}
