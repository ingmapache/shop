package com.mapache.shop.Domain.Product.Events;

import com.mapache.shop.Domain.Product.ProductName;
import com.mapache.shop.Domain.Shared.DomainEvent;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class OutOfStockEvent implements DomainEvent {

    private Long sellerId;
    private Long productId;
    private ProductName productName;
    private LocalDateTime occurredAt;

    public OutOfStockEvent(Long incSelleriD, Long incProductId, ProductName incProductName)
    {
        this.sellerId = Objects.requireNonNull(incSelleriD, "Seller id cannot be null.");
        this.productId = Objects.requireNonNull(incProductId, "Product id cannot be null.");
        this.productName = Objects.requireNonNull(incProductName, "Product name cannot be null.");

        if(incSelleriD <= 0 || incProductId <= 0)
            throw new IllegalArgumentException("Product and seller id must have a value above 0 and cannot be null.");

        this.occurredAt = java.time.LocalDateTime.now();
    }

    public Long getSellerId(){
        return sellerId;
    }

    public Long getProductId(){
        return productId;
    }

    public ProductName getProductName(){
        return productName;
    }


    @Override
    public LocalDateTime ocurredAt() {
        return occurredAt;
    }

    @Override
    public String eventType() {
        return "Out of stock";
    }
}
